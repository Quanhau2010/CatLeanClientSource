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
        this.enabledSetting = VisibleRenderHelper.registerSetting(this, "enabled");
        this.posSetting = VisibleRenderHelper.registerSetting(this, "position", new XRecord(0.5F, 0.5F));
        this.missingnoRenderHelper2 = new MissingnoRenderHelper(this.textValue, 10, 10);
        StringBuilder var13 = new StringBuilder();
        Object var14 = var13;
        Object var28 = this;
        int var15 = 0;
        String[] var16 = new String[1];
        var16[0] = "-";
        var16 = (Iterable) StringsKt.split$default((CharSequence) this.textValue);
        int var17 = 0;
        Iterator iterator = var16.iterator();
        if (iterator.hasNext()) {
            Object var19 = iterator.next();
            String var20 = (String) var19;
            int var21 = 0;
            Object var22 = var20;
            if (0L > 0) {
                if ((CharSequence) var22.length() > 0) {
                }
            } else {
            }
            if (0) {
                char var23 = var22.charAt(0);
                StringBuilder var24 = new StringBuilder();
                int var25 = 1;
                int var26 = 0;
                CharSequence var27 = (CharSequence) String.valueOf().toUpperCase(Locale.ROOT);
                var23 = var22;
                var26 = 1;
            } else {
            }
            var24.append().append(var23.substring()).toString().append();
            var14.append(32);
            StringsKt.trim((CharSequence) var14);
        }
        var28.textValue2 = var13.toString();
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
        return (Boolean) this.enabledSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public void setEnabled(boolean value) {
        this.enabledSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    public XRecord getPos() {
        return (XRecord) this.posSetting.getValue(this, DELEGATED_PROPERTIES[1]);
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

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 65469789313429L);
        long var5 = ((arg0 ^ 24976244493437L) >>> 48);
        long var6 = (((arg0 ^ 24976244493437L) << 16) >>> 48);
        long var7 = (((arg0 ^ 24976244493437L) << 32) >>> 32);
        long var8 = ((arg0 ^ 67469537118988L) >>> 56);
        long var9 = (((arg0 ^ 67469537118988L) << 8) >>> 8);
        if (this.getEnabled()) {
            this.updateValue2();
        }
        this.executeAction();
    }

    public void executeAction(byte arg0, long arg1) {
        int var4 = ((arg0 << 56) | ((arg1 << 8) >>> 8));
        long var6 = (var4 ^ 44318043563409L);
        this.setEnabled(1);
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 51235729995528L);
        this.setEnabled(0);
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
            CheckRenderHelper var43 = (CheckRenderHelper) iterator.next();
            if (!(var43.getEnabled())) {
            }
            float var44 = var43.computeValue();
            float var45 = (var43.factorValue6 + var43.computeValue());
            float var46 = this.computeValue();
            if (var44 <= var46) {
            } else {
            }
            if (var46 <= var45) {
                var44 = var43.computeValue2();
                var45 = (var43.computeValue2() + var43.factorValue5);
                var46 = this.computeValue2();
                if (var44 <= var46) {
                } else {
                }
                if (var46 <= var45) {
                    var44 = (((var43.computeValue() + var43.factorValue6) + 2.0F) / this.computeValue2());
                    var45 = (((var43.computeValue2() + var43.factorValue5) + 2.0F) / this.computeValue());
                    var46 = Math.min((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
                    float var47 = Math.max((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
                    if (var43.computeValue() != this.computeValue() && var43.computeValue2() == this.computeValue2()) {
                        this.getPos().updateValue(RangesKt.coerceIn((5.0F / this.computeValue2()), 1.0F));
                    }
                    if (var43.computeValue() != this.computeValue()) {
                        if (var43.computeValue2() != this.computeValue2() && (var43.computeValue() + var43.factorValue6) == (this.computeValue() + this.factorValue6)) {
                        }
                        this.getPos().updateValue2(RangesKt.coerceIn());
                    }
                }
            }
            if (var43.computeValue2() == this.computeValue2() && Math.abs(((var43.computeValue() + var43.factorValue6) - this.computeValue())) < 10.0F) {
                var44 = (((var43.computeValue() + var43.factorValue6) + 2.0F) / this.computeValue2());
                this.getPos().updateValue(RangesKt.coerceIn((5.0F / this.computeValue2()), 1.0F));
            }
            if (var43.computeValue() != this.computeValue()) {
            }
            var44 = (((var43.computeValue2() + var43.factorValue5) + 2.0F) / this.computeValue());
            var45 = Math.min((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
            var46 = Math.max((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
            this.getPos().updateValue2(RangesKt.coerceIn());
        }
        if ((this.computeValue() + this.factorValue6) <= (SharedKt.getMc().method_22683().method_4486() - 5.0F)) {
            if (Math.abs((((this.computeValue() + this.factorValue6) - SharedKt.getMc().method_22683().method_4486()) - 5.0F)) < 60.0F) {
            }
            iterator = (((SharedKt.getMc().method_22683().method_4486() - this.factorValue6) - 5.0F) / this.computeValue2());
            this.getPos().updateValue(RangesKt.coerceIn(iterator, (5.0F / this.computeValue2()), 1.0F));
        }
        if (!(SharedKt.getMc().currentScreen instanceof class_408)) {
            if (SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper) {
            }
            if (this.enabledFlag) {
                iterator = ((this.getNumericValue3() - this.factorValue) / this.computeValue2());
                var43 = ((this.getNumericValue4() - this.factorValue2) / this.computeValue());
                this.getPos().updateValue(RangesKt.coerceIn(iterator, (5.0F / this.computeValue2()), (1.0F - ((this.factorValue6 + 5.0F) / this.computeValue2()))));
                var44 = Math.min((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
                var45 = Math.max((5.0F / this.computeValue()), (1.0F - (this.factorValue5 / this.computeValue())));
                this.getPos().updateValue2(RangesKt.coerceIn());
                var46 = 0.0F;
                var47 = 0.0F;
                float var48 = 0.0F;
                Iterator iterator2 = POSITIONCOLORRenderHelper.INSTANCE.getList().iterator();
                while (iterator2.hasNext()) {
                    CheckRenderHelper var50 = (CheckRenderHelper) iterator2.next();
                    if (!(var50.getEnabled())) {
                    }
                    if (this.checkCondition((var50.computeValue() + var50.factorValue6), (this.computeValue() + this.factorValue6))) {
                        var46 = ((var50.computeValue() + var50.factorValue6) - this.factorValue6);
                        var47 = (var50.computeValue() + var50.factorValue6);
                    } else {
                        if (this.checkCondition(var50.computeValue(), this.computeValue())) {
                            var46 = var50.computeValue();
                            var47 = var46;
                        }
                    }
                    if (this.checkCondition(var50.computeValue2(), this.computeValue2())) {
                        var48 = var50.computeValue2();
                    }
                    if (var47 != 0.0F) {
                        PolygonShaderComponent.executeAction(context.method_51448(), 5.0F, (this.computeValue() - 5.0F), Color.WHITE);
                        this.getPos().updateValue((var46 / this.computeValue2()));
                    }
                    PolygonShaderComponent.executeAction(context.method_51448(), 5.0F, (this.computeValue2() - 5.0F), Color.WHITE);
                    this.getPos().updateValue2((var48 / this.computeValue()));
                }
            }
            if (this.enabledFlag2) {
                iterator = 0.0F;
                var44 = (Iterable) this.getList();
                var45 = 0;
                var46 = var44;
                var47 = (Collection) new ArrayList();
                var48 = 0;
                iterator2 = var46.iterator();
                while (iterator2.hasNext()) {
                    var50 = iterator2.next();
                    VisibleSettingProperty var51 = (VisibleSettingProperty) var50;
                    int var52 = 0;
                    var47.add();
                }
                var43 = var47;
                var47 = (Iterable) var43.iterator();
                if (!(var47.hasNext())) {
                } else {
                    var48 = (VisibleSettingProperty) var47.next();
                    iterator2 = 0;
                    var48 = SFMServiceComponent.resolveFontRenderHelper3().computeValue(var48.getString2());
                    while (var47.hasNext()) {
                        iterator2 = (VisibleSettingProperty) var47.next();
                        var50 = 0;
                        iterator2 = SFMServiceComponent.resolveFontRenderHelper3().computeValue(iterator2.getString2());
                        var48 = Math.max(iterator2);
                    }
                }
                if (Float.valueOf() != null) {
                } else {
                    Float.valueOf();
                }
                var44 = (0.0F + 23.0F);
                StackShaderComponent2.executeAction(context.method_51448(), this.factorValue3, this.factorValue4, ((14.0F * var43.size()) + 6.0F), 3.0F, 1.5F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
                var45 = (Iterable) var43;
                var46 = 0;
                var47 = var45.iterator();
                while (var47.hasNext()) {
                    var48 = var47.next();
                    iterator2 = (VisibleSettingProperty) var48;
                    var50 = 0;
                    SFMServiceComponent.resolveFontRenderHelper3().render(context, iterator2.getString2(), (this.factorValue3 + 3.0F), ((this.factorValue4 + iterator) + 3.0F), NewThemeRenderHelper.INSTANCE.getColor7());
                    StackShaderComponent2.executeAction(context.method_51448(), ((this.factorValue3 + var44) - 14.0F), ((this.factorValue4 + 3.5F) + iterator), 11.0F, 11.0F, 3.0F, 2.5F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor12(), 0.0F, 0.0F, 0.0F);
                    if (Intrinsics.areEqual(iterator2.getObject2(), Boolean.valueOf(1))) {
                        MissingnoRenderHelper.executeAction(this.missingnoRenderHelper, (Matrix3x2f) context.method_51448(), ((this.factorValue3 + var44) - 14.5D), ((this.factorValue4 + iterator) + 2.0D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.getColor2(), null, 0.0F);
                    }
                    iterator = (iterator + 14.0F);
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
        float var23 = SFMServiceComponent.resolveFontRenderHelper().computeValue(text);
        executeAction(this, context.method_51448(), this.computeValue(), this.computeValue2(), (var23 + 19.0F), 13.0F, 0.0F);
        executeAction(this, context.method_51448(), (this.computeValue() + 14), (this.computeValue2() + 3.0F), 0.0F);
        executeAction(this, this.missingnoRenderHelper2, context.method_51448(), (this.computeValue() + 2.0F), this.computeValue2(), 10.0F, 10.0F, 0.0F);
        this.render(context, text, (this.computeValue() + 16.0F), (this.computeValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.factorValue6 = (var23 + 20.0F);
        this.factorValue5 = 13.0F;
    }

    public void render(DrawContext context, String header, float factor, boolean right) {
        float var25 = SFMServiceComponent.resolveFontRenderHelper().computeValue(header);
        float var26 = (var25 + 24.0F);
        if (right) {
        } else {
        }
        float var27 = ((this.factorValue6 - var26) + 0.0F);
        context.method_51448().pushMatrix();
        context.method_51448().translate((var27 + (var26 / 2.0F)), (this.computeValue2() + 8.0F));
        context.method_51448().scale((Number) RangesKt.coerceIn((Comparable) Float.valueOf(factor), RangesKt.rangeTo(0.0F, 2.0F)), (Number) RangesKt.coerceIn((Comparable) Float.valueOf(factor), RangesKt.rangeTo(0.0F, 2.0F)));
        context.method_51448().translate((var27 + (var26 / 2.0F)), (this.computeValue2() + 8.0F));
        executeAction(this, context.method_51448(), this.computeValue2(), 16.0F, 0.0F);
        executeAction(this, this.missingnoRenderHelper2, context.method_51448(), (var27 + 2.0F), (this.computeValue2() + 1.5F), 10.0F, 10.0F, 0.0F);
        executeAction(this, context.method_51448(), (var27 + 14), (this.computeValue2() + 4.0F), 0.0F);
        this.render(context, header, (var27 + 18.0F), (this.computeValue2() + 2.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        context.method_51448().popMatrix();
    }

    public void executeAction(Action action) {
        if (0L > 0) {
            if (this.enabledFlag2 && action == Action.Press) {
                Iterable var18 = (Iterable) this.getList();
                int var19 = 0;
                Object var20 = var18;
                Collection var21 = (Collection) new ArrayList();
                int var22 = 0;
                Iterator iterator = var20.iterator();
                while (iterator.hasNext()) {
                    Object var24 = iterator.next();
                    VisibleSettingProperty var25 = (VisibleSettingProperty) var24;
                    int var26 = 0;
                    if (0L >= 0 && var16 == null) {
                    }
                    var21.add();
                }
                List positions = var21;
                var21 = (Iterable) positions.iterator();
                if (!(var21.hasNext())) {
                } else {
                    var22 = (VisibleSettingProperty) var21.next();
                    iterator = 0;
                    var22 = SFMServiceComponent.resolveFontRenderHelper3().computeValue(var22.getString2());
                    while (var21.hasNext()) {
                        iterator = (VisibleSettingProperty) var21.next();
                        var24 = 0;
                        iterator = SFMServiceComponent.resolveFontRenderHelper3().computeValue(iterator.getString2());
                        var22 = Math.max(iterator);
                        if (0L <= 0 || var16 == null) {
                            continue;
                        }
                    }
                }
                var18 = (0.0F + 23.0F);
                var19 = 0.0F;
                var20 = (Iterable) positions;
                var21 = 0;
                var22 = var20.iterator();
                while (var22.hasNext()) {
                    iterator = var22.next();
                    var24 = (VisibleSettingProperty) iterator;
                    var25 = 0;
                    var26 = ((this.factorValue3 + var18) - 14.0F);
                    float var27 = ((this.factorValue3 + var18) - 3.0F);
                    float var28 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue();
                    if (0L > 0) {
                        if (var16 == null) {
                            if (var26 <= var28) {
                            }
                        }
                    } else {
                    }
                    if (var28 <= var27) {
                        var26 = ((this.factorValue4 + 3.5F) + var19);
                        var27 = ((this.factorValue4 + 14.5F) + var19);
                        var28 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2();
                        if (0L >= 0) {
                            if (var16 == null) {
                                if (var26 <= var28) {
                                }
                            }
                        } else {
                        }
                        if (var28 <= var27) {
                            if (var24.getObject2() instanceof Boolean) {
                                var26 = var24;
                                var26.updateValue(Boolean.valueOf(!((Boolean) var26.getObject2())));
                            }
                        }
                    }
                    var19 = (var19 + 14.0F);
                }
                return;
            }
        }
        if (0L < 0 || action == Action.Release) {
            return;
        }
        if (0L >= 0) {
        }
        this.executeAction();
        positions = (Iterable) this.getList();
        var18 = 0;
        if (positions instanceof Collection) {
            if ((Collection) positions.isEmpty()) {
            }
        } else {
            var19 = positions.iterator();
            if (var19.hasNext()) {
                var20 = var19.next();
                var21 = (VisibleSettingProperty) var20;
                var22 = 0;
                if (!(Intrinsics.areEqual(var21.getString(), "enabled"))) {
                } else {
                }
            } else {
            }
        }
        }
        this.enabledFlag2 = !(this.enabledFlag2);
        this.factorValue3 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue();
        this.factorValue4 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2();
    }

    protected void executeAction() {
        if (var13 == null) {
            if (this instanceof CoordWidgetRenderHelper) {
                GLFW.glfwSetClipboardString(SharedKt.getMc().method_22683().method_4490(), (CharSequence) (SharedKt.getPlayer().getX() + SharedKt.getPlayer().getY() + SharedKt.getPlayer().getZ()));
            }
            this.factorValue = (POSITIONCOLORRenderHelper.INSTANCE.getNumericValue() - this.computeValue());
            this.factorValue2 = (POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2() - this.computeValue2());
        }
        this.enabledFlag = 1;
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
        float var8 = this.computeValue();
        float var9 = (this.computeValue() + this.factorValue6);
        float var10 = this.getNumericValue3();
        if (var8 <= var10) {
        } else {
        }
        if (var10 <= var9) {
            var8 = this.computeValue2();
            var9 = (this.computeValue2() + this.factorValue5);
            var10 = this.getNumericValue4();
            if (var8 <= var10) {
            } else {
            }
        } else {
        }
        return var10 <= var9;
    }

    protected void updateValue2() {
        if (POSITIONCOLORRenderHelper.INSTANCE.getCheckRenderHelper() != null) {
        } else {
        }
        int var5 = 221188;
        GLFW.glfwSetCursor(SharedKt.getMc().method_22683().method_4490(), GLFW.glfwCreateStandardCursor());
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
        if (arg3 >= 0) {
            if (var17 == null) {
                if ((arg9 & 32)) {
                    arg7 = 1.0F;
                }
            }
        }
        if (var17 == null) {
            if ((arg9 & 64)) {
            }
            arg8 = 1;
        }
        arg0.executeAction(arg1, arg2, arg4, arg5, arg6, arg7, arg8);
    }

    protected void executeAction(Matrix3x2fStack m, float x, float y) {
        Matrix3x2f var5 = new Matrix3x2f((Matrix3x2fc) m);
        POSITIONCOLORRenderHelper.INSTANCE.getList2().add(new ServiceComponent6(x, y, 0.5F, 8.5F));
    }

    public static void executeAction(CheckRenderHelper arg0, Matrix3x2fStack arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if (arg6 != null) {
        }
        if ((arg5 & 8)) {
            arg4 = 1.0F;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4);
    }

    protected void executeAction(MissingnoRenderHelper image, Matrix3x2fStack m, float x, float y, float w, float h) {
        Matrix3x2f var12 = new Matrix3x2f((Matrix3x2fc) m);
        POSITIONCOLORRenderHelper.INSTANCE.getList3().add(new ImageServiceComponent(image, x, y, w, h));
    }

    public static void executeAction(CheckRenderHelper arg0, MissingnoRenderHelper arg1, Matrix3x2fStack arg2, float arg3, float arg4, float arg5, float arg6, float arg7, int arg8, Object arg9) {
        if (arg9 != null) {
        }
        if ((arg8 & 64)) {
            arg7 = 1.0F;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    protected void render(DrawContext context, String s, float x, float y, Color color) {
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), context.method_51448(), s, x, y, color);
    }

    static {
        KProperty[] var22 = new KProperty[2];
    }

    public static void updateValue(String arg0) {
        textValue3 = arg0;
    }

    public static String getString3() {
        return textValue3;
    }

}
