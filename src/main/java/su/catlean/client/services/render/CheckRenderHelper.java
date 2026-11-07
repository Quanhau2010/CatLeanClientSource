package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.class_408;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix3x2fc;
import org.lwjgl.glfw.GLFW;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract;
import su.catlean.api.contracts.Contract5;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl5;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ImageServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent6;
import su.catlean.client.services.client.config.models.XRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;

public abstract class CheckRenderHelper implements Contract5, Contract {

    private final String textValue;
    private final List itemList;
    private final List itemList2;
    private final MissingnoRenderHelper missingnoRenderHelper;
    private final VisibleVisibleSettingPropertyImpl enabledSetting;
    private final DefaultValueVisibleSettingPropertyImpl5 posSetting;
    private MissingnoRenderHelper missingnoRenderHelper2;
    private boolean enabledFlag;
    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private float factorValue4;
    private boolean enabledFlag2;
    private float factorValue5;
    private float factorValue6;
    private final String textValue2;
    private static String textValue3;

    public CheckRenderHelper(String id) {
        this.textValue = id;
        this.itemList = new ArrayList();
        this.itemList2 = new ArrayList();
        this.missingnoRenderHelper = new MissingnoRenderHelper("check", 12, 12);
        this.enabledSetting = VisibleRenderHelper.registerSetting(this, "enabled", false);
        this.posSetting = VisibleRenderHelper.registerSetting(this, "position", new XRecord(0.5F, 0.5F));
        this.missingnoRenderHelper2 = new MissingnoRenderHelper(this.textValue, 10, 10);
        StringBuilder stringBuilder = new StringBuilder();
        String[] items = new String[1];
        items[0] = "-";
        items = ((Iterable) StringsKt.split$default(((CharSequence) this.textValue), items, false));
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            String text = ((String) element);
            if (__UNDEF_KEY__ > 0) {
                if (((CharSequence) text).length() > 0) {
                } else {
                }
            }
            if (0) {
                char ch = text.charAt(0);
                StringBuilder stringBuilder2 = new StringBuilder();
                int index = 1;
                int index2 = 0;
                CharSequence charSequence = ((CharSequence) String.valueOf(ch).toUpperCase(Locale.ROOT));
                ch = text;
                index2 = 1;
            } else {
            }
            stringBuilder2.append(charSequence).append(ch.substring(index2)).toString().append(text);
            stringBuilder.append(32);
            StringsKt.trim(((CharSequence) stringBuilder));
        }
        this.textValue2 = stringBuilder.toString();
    }

    public String getString() {
        return this.textValue;
    }

    public List getList() {
        return this.itemList;
    }

    public List getList2() {
        return this.itemList2;
    }

    public boolean getEnabled() {
        return ((Boolean) this.enabledSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public void setEnabled(boolean value) {
        this.enabledSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    public XRecord getPos() {
        return ((XRecord) this.posSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public void setPos(XRecord value) {
        this.posSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    public MissingnoRenderHelper getMissingnoRenderHelper() {
        return this.missingnoRenderHelper2;
    }

    public float getNumericValue() {
        return this.factorValue5;
    }

    public void updateValue(float value) {
        this.factorValue5 = value;
    }

    public float getNumericValue2() {
        return this.factorValue6;
    }

    public void updateValue2(float value) {
        this.factorValue6 = value;
    }

    public String getString2() {
        return this.textValue2;
    }

    public void updateValue() {
        if (this.getEnabled()) {
            this.updateValue2();
        }
        this.executeAction();
    }

    public void executeAction() {
        this.setEnabled(true);
    }

    public void updateValue2() {
        this.setEnabled(false);
    }

    public void render(DrawContext arg0) {
    }

    public void render(DrawContext context) {
    }

    public void updateValue() {
    }

    public void render2(DrawContext context) {
        this.render(context);
        Iterator iterator = POSITIONCOLORRenderHelper.INSTANCE.getList().iterator();
        while (iterator.hasNext()) {
            CheckRenderHelper checkRenderHelper = ((CheckRenderHelper) iterator.next());
            if (!(checkRenderHelper.getEnabled())) {
            }
            float factor = checkRenderHelper.computeValue();
            float factor2 = (checkRenderHelper.factorValue6 + checkRenderHelper.computeValue());
            float factor3 = this.computeValue();
            if (factor <= factor3) {
            } else {
                if (factor3 <= factor2) {
                    factor = checkRenderHelper.computeValue2();
                    factor2 = (checkRenderHelper.computeValue2() + checkRenderHelper.factorValue5);
                    factor3 = this.computeValue2();
                    if (factor <= factor3) {
                    } else {
                        if (factor3 <= factor2) {
                            factor = (((checkRenderHelper.computeValue() + checkRenderHelper.factorValue6) + 2.0F) / this.computeValue2());
                            factor2 = (((checkRenderHelper.computeValue2() + checkRenderHelper.factorValue5) + 2.0F) / this.computeValue());
                            factor3 = Math.min((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
                            float factor4 = Math.max((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
                            if (checkRenderHelper.computeValue() != this.computeValue() && checkRenderHelper.computeValue2() == this.computeValue2()) {
                                this.getPos().updateValue(RangesKt.coerceIn(factor, (5.0F / this.computeValue2()), 1.0F));
                            }
                            if (checkRenderHelper.computeValue() != this.computeValue()) {
                                if (checkRenderHelper.computeValue2() != this.computeValue2() && (checkRenderHelper.computeValue() + checkRenderHelper.factorValue6) == (this.computeValue() + this.factorValue6)) {
                                    this.getPos().updateValue2(RangesKt.coerceIn(factor2, factor3, factor4));
                                }
                            }
                        }
                    }
                }
            }
            if (checkRenderHelper.computeValue2() == this.computeValue2() && Math.abs(((checkRenderHelper.computeValue() + checkRenderHelper.factorValue6) - this.computeValue())) < 10.0F) {
                factor = (((checkRenderHelper.computeValue() + checkRenderHelper.factorValue6) + 2.0F) / this.computeValue2());
                this.getPos().updateValue(RangesKt.coerceIn(factor, (5.0F / this.computeValue2()), 1.0F));
            }
            if (checkRenderHelper.computeValue() != this.computeValue()) {
            }
            factor = (((checkRenderHelper.computeValue2() + checkRenderHelper.factorValue5) + 2.0F) / this.computeValue());
            factor2 = Math.min((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
            factor3 = Math.max((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
            this.getPos().updateValue2(RangesKt.coerceIn(factor, factor2, factor3));
        }
        if ((this.computeValue() + this.factorValue6) <= (SharedKt.getMc().method_22683().method_4486() - 5.0F)) {
            if (Math.abs((((this.computeValue() + this.factorValue6) - SharedKt.getMc().method_22683().method_4486()) - 5.0F)) < 60.0F) {
                iterator = (((SharedKt.getMc().method_22683().method_4486() - this.factorValue6) - 5.0F) / this.computeValue2());
                this.getPos().updateValue(RangesKt.coerceIn(iterator, (5.0F / this.computeValue2()), 1.0F));
            }
        }
        if (!(SharedKt.getMc().currentScreen instanceof class_408)) {
            if (SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper) {
                if (this.enabledFlag) {
                    iterator = ((this.getNumericValue3() - this.factorValue) / this.computeValue2());
                    checkRenderHelper = ((this.getNumericValue4() - this.factorValue2) / this.computeValue());
                    this.getPos().updateValue(RangesKt.coerceIn(iterator, (5.0F / this.computeValue2()), (1.0F - ((this.factorValue6 + 5.0F) / this.computeValue2()))));
                    factor = Math.min((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
                    factor2 = Math.max((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
                    this.getPos().updateValue2(RangesKt.coerceIn(checkRenderHelper, factor, factor2));
                    factor3 = 0.0F;
                    factor4 = 0.0F;
                    float factor5 = 0.0F;
                    Iterator iterator2 = POSITIONCOLORRenderHelper.INSTANCE.getList().iterator();
                    while (iterator2.hasNext()) {
                        CheckRenderHelper checkRenderHelper2 = ((CheckRenderHelper) iterator2.next());
                        if (!(checkRenderHelper2.getEnabled())) {
                        }
                        if (this.checkCondition((checkRenderHelper2.computeValue() + checkRenderHelper2.factorValue6), (this.computeValue() + this.factorValue6))) {
                            factor3 = ((checkRenderHelper2.computeValue() + checkRenderHelper2.factorValue6) - this.factorValue6);
                            factor4 = (checkRenderHelper2.computeValue() + checkRenderHelper2.factorValue6);
                        } else {
                            if (this.checkCondition(checkRenderHelper2.computeValue(), this.computeValue())) {
                                factor3 = checkRenderHelper2.computeValue();
                                factor4 = factor3;
                            }
                        }
                        if (this.checkCondition(checkRenderHelper2.computeValue2(), this.computeValue2())) {
                            factor5 = checkRenderHelper2.computeValue2();
                        }
                        if (factor4 != 0.0F) {
                            PolygonShaderComponent.executeAction(context.method_51448(), factor4, 5.0F, factor4, (this.computeValue() - 5.0F), Color.WHITE);
                            this.getPos().updateValue((factor3 / this.computeValue2()));
                        }
                        PolygonShaderComponent.executeAction(context.method_51448(), 5.0F, factor5, (this.computeValue2() - 5.0F), factor5, Color.WHITE);
                        this.getPos().updateValue2((factor5 / this.computeValue()));
                    }
                }
                if (this.enabledFlag2) {
                    iterator = 0.0F;
                    factor = ((Iterable) this.getList());
                    factor2 = 0;
                    factor3 = factor;
                    factor4 = ((Collection) new ArrayList());
                    factor5 = 0;
                    iterator2 = factor3.iterator();
                    while (iterator2.hasNext()) {
                        checkRenderHelper2 = iterator2.next();
                        VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) checkRenderHelper2);
                        factor4.add(checkRenderHelper2);
                    }
                    checkRenderHelper = factor4;
                    factor4 = ((Iterable) checkRenderHelper).iterator();
                    if (!(factor4.hasNext())) {
                    } else {
                        factor5 = ((VisibleSettingProperty) factor4.next());
                        iterator2 = 0;
                        factor5 = SFMServiceComponent.resolveFontRenderHelper3().computeValue(factor5.getString2());
                        while (factor4.hasNext()) {
                            iterator2 = ((VisibleSettingProperty) factor4.next());
                            checkRenderHelper2 = 0;
                            iterator2 = SFMServiceComponent.resolveFontRenderHelper3().computeValue(iterator2.getString2());
                            factor5 = Math.max(factor5, iterator2);
                        }
                    }
                    if (Float.valueOf(factor5) != null) {
                    } else {
                        Float.valueOf(factor5);
                    }
                    factor = (0.0F + 23.0F);
                    StackShaderComponent2.executeAction(context.method_51448(), this.factorValue3, this.factorValue4, factor, ((14.0F * checkRenderHelper.size()) + 6.0F), 3.0F, 1.5F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
                    factor2 = ((Iterable) checkRenderHelper);
                    factor3 = 0;
                    factor4 = factor2.iterator();
                    while (factor4.hasNext()) {
                        factor5 = factor4.next();
                        iterator2 = ((VisibleSettingProperty) factor5);
                        checkRenderHelper2 = 0;
                        SFMServiceComponent.resolveFontRenderHelper3().render(context, iterator2.getString2(), (this.factorValue3 + 3.0F), ((this.factorValue4 + iterator) + 3.0F), NewThemeRenderHelper.INSTANCE.getColor7());
                        StackShaderComponent2.executeAction(context.method_51448(), ((this.factorValue3 + factor) - 14.0F), ((this.factorValue4 + 3.5F) + iterator), 11.0F, 11.0F, 3.0F, 2.5F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
                        if (Intrinsics.areEqual(iterator2.getObject2(), Boolean.valueOf(true))) {
                            MissingnoRenderHelper.executeAction(this.missingnoRenderHelper, ((Matrix3x2f) context.method_51448()), ((this.factorValue3 + factor) - 14.5D), ((this.factorValue4 + iterator) + 2.0D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor2(), null, 0.0F);
                        }
                        iterator = (iterator + 14.0F);
                    }
                }
            }
        }
        if (this.checkCondition()) {
            if (!(SharedKt.getMc().currentScreen instanceof class_408)) {
            }
        }
        this.updateValue2();
        POSITIONCOLORRenderHelper.INSTANCE.updateValue2(this);
    }

    public void render(DrawContext context, String text) {
        float factor = SFMServiceComponent.resolveFontRenderHelper().computeValue(text);
        executeAction(this, context.method_51448(), this.computeValue(), this.computeValue2(), (factor + 19.0F), 13.0F, 0.0F, false);
        executeAction(this, context.method_51448(), (this.computeValue() + 14), (this.computeValue2() + 3.0F), 0.0F);
        executeAction(this, this.missingnoRenderHelper2, context.method_51448(), (this.computeValue() + 2.0F), this.computeValue2(), 10.0F, 10.0F, 0.0F);
        this.render(context, text, (this.computeValue() + 16.0F), (this.computeValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.factorValue6 = (factor + 20.0F);
        this.factorValue5 = 13.0F;
    }

    public void render(DrawContext context, String header, float factor, boolean right) {
        float factor2 = SFMServiceComponent.resolveFontRenderHelper().computeValue(header);
        float factor3 = (factor2 + 24.0F);
        if (right) {
        } else {
        }
        float factor4 = ((this.factorValue6 - factor3) + 0.0F);
        context.method_51448().pushMatrix();
        context.method_51448().translate((factor4 + (factor3 / 2.0F)), (this.computeValue2() + 8.0F));
        context.method_51448().scale(((Number) RangesKt.coerceIn(((Comparable) Float.valueOf(factor)), RangesKt.rangeTo(0.0F, 2.0F))), ((Number) RangesKt.coerceIn(((Comparable) Float.valueOf(factor)), RangesKt.rangeTo(0.0F, 2.0F))));
        context.method_51448().translate((factor4 + (factor3 / 2.0F)), (this.computeValue2() + 8.0F));
        executeAction(this, context.method_51448(), factor4, this.computeValue2(), factor3, 16.0F, 0.0F, false);
        executeAction(this, this.missingnoRenderHelper2, context.method_51448(), (factor4 + 2.0F), (this.computeValue2() + 1.5F), 10.0F, 10.0F, 0.0F);
        executeAction(this, context.method_51448(), (factor4 + 14), (this.computeValue2() + 4.0F), 0.0F);
        this.render(context, header, (factor4 + 18.0F), (this.computeValue2() + 2.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        context.method_51448().popMatrix();
    }

    public void executeAction(Action action) {
        if (__UNDEF_KEY__ > 0) {
            if (this.enabledFlag2 && action == Action.Press) {
                Iterable iterable = ((Iterable) this.getList());
                int index = 0;
                Iterable iterable2 = iterable;
                Collection collection = ((Collection) new ArrayList());
                int index2 = 0;
                Iterator iterator = iterable2.iterator();
                while (iterator.hasNext()) {
                    Object element = iterator.next();
                    VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) element);
                    int index3 = 0;
                    if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ == null) {
                    }
                    collection.add(element);
                }
                List list = collection;
                collection = ((Iterable) list).iterator();
                if (!(collection.hasNext())) {
                } else {
                    index2 = ((VisibleSettingProperty) collection.next());
                    iterator = 0;
                    index2 = SFMServiceComponent.resolveFontRenderHelper3().computeValue(index2.getString2());
                    while (collection.hasNext()) {
                        iterator = ((VisibleSettingProperty) collection.next());
                        element = 0;
                        iterator = SFMServiceComponent.resolveFontRenderHelper3().computeValue(iterator.getString2());
                        index2 = Math.max(index2, iterator);
                        if (__UNDEF_KEY__ <= 0 || __UNDEF_KEY__ == null) {
                            continue;
                        }
                    }
                }
                iterable = (0.0F + 23.0F);
                index = 0.0F;
                iterable2 = ((Iterable) list);
                collection = 0;
                index2 = iterable2.iterator();
                while (index2.hasNext()) {
                    iterator = index2.next();
                    element = ((VisibleSettingProperty) iterator);
                    visibleSettingProperty = 0;
                    index3 = ((this.factorValue3 + iterable) - 14.0F);
                    float factor = ((this.factorValue3 + iterable) - 3.0F);
                    float factor2 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue();
                    if (__UNDEF_KEY__ > 0) {
                        if (__UNDEF_KEY__ == null) {
                            if (index3 <= factor2) {
                            } else {
                                if (factor2 <= factor) {
                                    index3 = ((this.factorValue4 + 3.5F) + index);
                                    factor = ((this.factorValue4 + 14.5F) + index);
                                    factor2 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2();
                                    if (__UNDEF_KEY__ >= 0) {
                                        if (__UNDEF_KEY__ == null) {
                                            if (index3 <= factor2) {
                                            } else {
                                                if (factor2 <= factor) {
                                                    if (element.getObject2() instanceof Boolean) {
                                                        index3 = element;
                                                        index3.updateValue(Boolean.valueOf(!(((Boolean) index3.getObject2()))));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    index = (index + 14.0F);
                }
                return;
            }
        }
        if (__UNDEF_KEY__ < 0 || action == Action.Release) {
            return;
        }
        if (__UNDEF_KEY__ >= 0) {
        }
        this.executeAction();
        list = ((Iterable) this.getList());
        iterable = 0;
        if (list instanceof Collection) {
            if (((Collection) list).isEmpty()) {
            } else {
                index = list.iterator();
                while (index.hasNext()) {
                    iterable2 = index.next();
                    collection = ((VisibleSettingProperty) iterable2);
                    index2 = 0;
                    if (!(Intrinsics.areEqual(collection.getString(), "enabled"))) {
                    } else {
                    }
                }
            }
        } else {
        }
        this.enabledFlag2 = !(this.enabledFlag2);
        this.factorValue3 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue();
        this.factorValue4 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2();
    }

    protected void executeAction() {
        if (this instanceof CoordWidgetRenderHelper) {
            GLFW.glfwSetClipboardString(SharedKt.getMc().method_22683().method_4490(), ((CharSequence) (SharedKt.getPlayer().getX() + SharedKt.getPlayer().getY() + SharedKt.getPlayer().getZ())));
        }
        this.factorValue = (POSITIONCOLORRenderHelper.INSTANCE.getNumericValue() - this.computeValue());
        this.factorValue2 = (POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2() - this.computeValue2());
        this.enabledFlag = true;
        POSITIONCOLORRenderHelper.INSTANCE.updateValue(this);
    }

    public float computeValue() {
        return (this.getPos().getNumericValue() * this.computeValue2());
    }

    public float computeValue2() {
        return (this.getPos().getNumericValue2() * this.computeValue());
    }

    protected float getNumericValue3() {
        return POSITIONCOLORRenderHelper.INSTANCE.getNumericValue();
    }

    protected float getNumericValue4() {
        return POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2();
    }

    protected boolean checkCondition() {
        float factor = this.computeValue();
        float factor2 = (this.computeValue() + this.factorValue6);
        float factor3 = this.getNumericValue3();
        if (factor <= factor3) {
        } else {
            if (factor3 <= factor2) {
                factor = this.computeValue2();
                factor2 = (this.computeValue2() + this.factorValue5);
                factor3 = this.getNumericValue4();
                if (factor <= factor3) {
                } else {
                }
            } else {
                return factor3 <= factor2;
            }
        }
    }

    protected void updateValue2() {
        if (POSITIONCOLORRenderHelper.INSTANCE.getCheckRenderHelper() != null) {
        } else {
        }
        int index = 221188;
        GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor(index));
    }

    protected void executeAction(float w, float h) {
        this.factorValue6 = w;
        this.factorValue5 = h;
    }

    protected int computeValue() {
        return SharedKt.getMc().method_22683().method_4502();
    }

    protected int computeValue2() {
        return SharedKt.getMc().method_22683().method_4486();
    }

    protected boolean checkCondition(float n1, float n2) {
        return Math.abs((n1 - n2)) < 2.0F;
    }

    protected void executeAction(Matrix3x2fStack m, float x, float y, float w, float h, boolean batch) {
        POSITIONCOLORRenderHelper.INSTANCE.getStackShaderComponent().executeAction(m, x, y, w, h);
        StackShaderComponent2.executeAction(m, x, y, w, h, 3.0F, 1.5F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
    }

    public static void executeAction(CheckRenderHelper arg0, Matrix3x2fStack arg1, float arg2, short arg3, float arg4, float arg5, float arg6, float arg7, boolean arg8, int arg9, Object arg10) {
        if (arg10 != null) {
        }
        if (arg3 >= 0 && __UNDEF_KEY__ == null) {
            if ((arg9 & 32) != 0) {
                arg7 = 1.0F;
            }
        }
        if ((arg9 & 64) != 0) {
            arg8 = 1;
        }
        arg0.executeAction(arg1, arg2, arg4, arg5, arg6, arg7, arg8);
    }

    protected void executeAction(Matrix3x2fStack m, float x, float y) {
        Matrix3x2f matrix3x2f = new Matrix3x2f(((Matrix3x2fc) m));
        POSITIONCOLORRenderHelper.INSTANCE.getList2().add(new ServiceComponent6(matrix3x2f, x, y, 0.5F, 8.5F));
    }

    public static void executeAction(CheckRenderHelper arg0, Matrix3x2fStack arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if (arg6 != null) {
        }
        if ((arg5 & 8) != 0) {
            arg4 = 1.0F;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4);
    }

    protected void executeAction(MissingnoRenderHelper image, Matrix3x2fStack m, float x, float y, float w, float h) {
        Matrix3x2f matrix3x2f = new Matrix3x2f(((Matrix3x2fc) m));
        POSITIONCOLORRenderHelper.INSTANCE.getList3().add(new ImageServiceComponent(image, matrix3x2f, x, y, w, h));
    }

    public static void executeAction(CheckRenderHelper arg0, MissingnoRenderHelper arg1, Matrix3x2fStack arg2, float arg3, float arg4, float arg5, float arg6, float arg7, int arg8, Object arg9) {
        if (arg9 != null) {
        }
        if ((arg8 & 64) != 0) {
            arg7 = 1.0F;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    protected void render(DrawContext context, String s, float x, float y, Color color) {
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), context.method_51448(), s, x, y, color, false);
    }

    static {
        KProperty[] items = new KProperty[2];
    }

    public static void updateValue(String arg0) {
        textValue3 = arg0;
    }

    public static String getString3() {
        return textValue3;
    }

}
