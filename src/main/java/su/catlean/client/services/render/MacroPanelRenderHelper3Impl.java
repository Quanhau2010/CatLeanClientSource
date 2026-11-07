package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.text.StringsKt;
import net.minecraft.block.Block;
import net.minecraft.class_7923;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.Item;
import su.catlean.api.contracts.Contract4;
import su.catlean.api.contracts.Contract8;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EnabledServiceComponent;
import su.catlean.client.services.client.HoldServiceComponent;
import su.catlean.client.services.client.HoveringComponentServiceComponent;
import su.catlean.client.services.client.HoveringComponentServiceComponent2;
import su.catlean.client.services.client.HoveringComponentServiceComponent3;
import su.catlean.client.services.client.HoveringComponentServiceComponent4;
import su.catlean.client.services.client.HoveringComponentServiceComponent8;
import su.catlean.client.services.client.LegitServiceComponent;
import su.catlean.client.services.client.MacroServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent7;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.client.SuggestionsServiceComponent;
import su.catlean.client.services.client.config.models.IdRecord;
import su.catlean.client.services.client.config.models.IdRecord11;
import su.catlean.client.services.client.config.models.IdRecord9;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class MacroPanelRenderHelper3Impl extends RenderHelper3 {

    public static final MacroPanelRenderHelper3Impl INSTANCE;
    private static final List itemList;
    private static RenderHelper2 renderHelper2;
    private static RenderHelper2 renderHelper22;
    private static RenderHelper2 renderHelper23;
    private static boolean enabledFlag;
    private static MacrosRenderHelper2Impl macrosRenderHelper2Impl;
    private static MacrosRenderHelper2Impl macrosRenderHelper2Impl2;
    private static final EasingServiceComponent easingServiceComponent;
    private static final EasingServiceComponent easingServiceComponent2;
    private static final EasingServiceComponent easingServiceComponent3;
    private static boolean enabledFlag2;
    private static float factorValue;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl2;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl3;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl4;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl5;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl6;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl7;
    private static String[] textValueArray;

    private MacroPanelRenderHelper3Impl() {
        super("macro-panel", 0.0F, 0.0F, 0.0F, 0.0F);
    }

    public List getList() {
        return itemList;
    }

    public RenderHelper2 getRenderHelper2() {
        return renderHelper2;
    }

    public void updateValue(RenderHelper2 value) {
        renderHelper2 = value;
    }

    public RenderHelper2 getRenderHelper22() {
        return renderHelper23;
    }

    public void updateValue2(RenderHelper2 value) {
        renderHelper23 = value;
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public MacrosRenderHelper2Impl getMacrosRenderHelper2Impl() {
        return macrosRenderHelper2Impl;
    }

    public void updateValue(MacrosRenderHelper2Impl value) {
        macrosRenderHelper2Impl = value;
    }

    public MacrosRenderHelper2Impl getMacrosRenderHelper2Impl2() {
        return macrosRenderHelper2Impl2;
    }

    public void updateValue2(MacrosRenderHelper2Impl value) {
        macrosRenderHelper2Impl2 = value;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return easingServiceComponent;
    }

    public void updateValue(long arg0) {
        long var3 = ((arg0 ^ 115595886169135L) >>> 48);
        long var4 = (((arg0 ^ 115595886169135L) << 16) >>> 32);
        long var5 = (((arg0 ^ 115595886169135L) << 48) >>> 48);
        long var6 = ((arg0 ^ 115779852416719L) >>> 32);
        long var7 = (((arg0 ^ 115779852416719L) << 32) >>> 32);
        itemList.clear();
        Iterable var8 = (Iterable) MacroServiceComponent.INSTANCE.resolveList();
        int var9 = 0;
        Iterator iterator = var8.iterator();
        if (iterator.hasNext()) {
            Object var11 = iterator.next();
            Contract8 var12 = var11;
            int var13 = 0;
            itemList.add(new MacrosRenderHelper2Impl());
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        long var6 = ((0L ^ 138493012530694L) >>> 32);
        long var7 = (((0L ^ 138493012530694L) << 32) >>> 48);
        long var8 = (((0L ^ 138493012530694L) << 48) >>> 48);
        long var9 = (0L ^ 136208856317167L);
        long var11 = (0L ^ 38443269427772L);
        long var13 = (0L ^ 136208856317167L);
        long var15 = (0L ^ 2439703879599L);
        long var17 = (0L ^ 129382754651428L);
        long var19 = (0L ^ 24054421754188L);
        long var21 = (0L ^ 60583055863356L);
        long var23 = ((0L ^ 55302899458674L) >>> 48);
        long var24 = (((0L ^ 55302899458674L) << 16) >>> 32);
        long var25 = (((0L ^ 55302899458674L) << 48) >>> 48);
        long var26 = (0L ^ 133028505816902L);
        long var28 = ((0L ^ 22135879901675L) >>> 48);
        long var29 = (((0L ^ 22135879901675L) << 16) >>> 48);
        long var30 = (((0L ^ 22135879901675L) << 32) >>> 32);
        long var31 = (0L ^ 27182768661316L);
        long var33 = (0L ^ 0L);
        long var35 = (0L ^ 89114448831051L);
        long var37 = (0L ^ 136208856317167L);
        long var39 = (0L ^ 97910750751556L);
        long var41 = (0L ^ 55127167163707L);
        long var43 = (0L ^ 76831427342201L);
        long var45 = (0L ^ 101408683801774L);
        long var47 = (0L ^ 2881734234662L);
        long var49 = (0L ^ 55531218400380L);
        long var51 = (0L ^ 136208856317167L);
        long var53 = ((0L ^ 128917815534086L) >>> 32);
        long var54 = (((0L ^ 128917815534086L) << 32) >>> 40);
        long var55 = (((0L ^ 128917815534086L) << 56) >>> 56);
        this.render(context, mouseX, mouseY);
        if (var71) {
            easingServiceComponent.executeAction(1.0F);
            if (this.getContract4() != null) {
            }
        } else {
        }
        0.5F.executeAction(0.0F);
        easingServiceComponent3.executeAction(factorValue);
        float var72 = (this.getNumericValue() + 3.0F);
        float var73 = (this.getNumericValue() + 72.0F);
        int var74 = mouseX;
        if (0L >= 0L) {
            if (var71) {
                if (var72 <= var74) {
                }
            }
            if (var71) {
                if (var74 <= var73) {
                }
            }
        } else {
        }
        if (0) {
            var72 = (this.getNumericValue2() + 5.0F);
            var73 = (this.getNumericValue2() + 13.0F);
            var74 = mouseY;
            if (0L >= 0L) {
                if (var71) {
                    if (var72 <= var74) {
                    }
                }
                if (var71) {
                    if (var74 <= var73) {
                    }
                }
            } else {
            }
            if (0L > 0L) {
                if (0) {
                }
            }
        }
        enabledFlag2 = 0;
        if (enabledFlag2) {
        }
        if (enabledFlag2) {
        }
        int var57 = 14336;
        float var58 = 0.0F;
        float var59 = 0.0F;
        float var60 = 0.0F;
        Color var61 = NewThemeRenderHelper.INSTANCE.getColor6();
        Color var62 = NewThemeRenderHelper.INSTANCE.getColor4();
        float var63 = 1.0F;
        float var64 = 0.0F;
        float var65 = 0.1F;
        float var66 = 2.0F;
        float var67 = 2.5F;
        float var68 = 2.0F;
        float var69 = 8.0F;
        float var70 = 69.0F;
        StackShaderComponent2.executeAction((this.getNumericValue2() + 3.0F));
        SFMServiceComponent.resolveFontRenderHelper().render(context, "+", (this.getNumericValue() + 36.0F), (this.getNumericValue2() + 1.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() + 76.0F), this.getNumericValue2(), 6.0F, this.getNumericValue4(), 1.0F, 0.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        renderHelper23 = null;
        renderHelper2 = null;
        enabledFlag = 0;
        var72 = 0.0F;
        var72 = (17.0F + easingServiceComponent3.getNumericValue());
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(this.getNumericValue(), (this.getNumericValue2() + 14), (this.getNumericValue() + 76), ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)));
        var73 = (Iterable) itemList;
        var74 = 0;
        Iterator iterator = var73.iterator();
        if (iterator.hasNext()) {
            Object var76 = iterator.next();
            MacrosRenderHelper2Impl var77 = (MacrosRenderHelper2Impl) var76;
            int var78 = 0;
            var77.render(context, INSTANCE.getNumericValue(), (INSTANCE.getNumericValue2() + var72), mouseX, mouseY);
            var72 = (var72 + 29.0F);
            if (0L > 0L) {
                if (var71) {
                }
                PolygonShaderComponent.INSTANCE.render(context);
            }
        }
        if (0L >= 0L) {
            if (var71) {
                if (macrosRenderHelper2Impl != null) {
                    var73 = ((1.0F - easingServiceComponent.getNumericValue()) * 10.0F);
                    var74 = this::getUnit;
                    suggestionsRenderHelper2Impl.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 17.0F) + var73), mouseX, mouseY);
                    iterator = macrosRenderHelper2Impl.getContract8();
                    if (0L > 0L) {
                        if (var71) {
                            if (iterator instanceof IdRecord9) {
                                suggestionsRenderHelper2Impl2.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 32.0F) + var73), mouseX, mouseY);
                                new ClickActionRenderHelper2Impl(this.getNumericValue3(), (KMutableProperty0) new HoveringComponentServiceComponent8(this)).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 47.0F) + var73), mouseX, mouseY);
                                if (!(var71)) {
                                }
                            }
                            if (0L > 0L) {
                            }
                            if (var71) {
                                if (iterator instanceof IdRecord) {
                                    suggestionsRenderHelper2Impl3.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 32.0F) + var73), mouseX, mouseY);
                                    new FirstRenderHelper2Impl(this.getNumericValue3(), "Rage", "Legit", (KMutableProperty0) new LegitServiceComponent((IdRecord) macrosRenderHelper2Impl.getContract8()), (KMutableProperty0) new HoveringComponentServiceComponent2(this)).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 47.0F) + var73), mouseX, mouseY);
                                    new ClickActionRenderHelper2Impl(this.getNumericValue3(), (KMutableProperty0) new HoveringComponentServiceComponent(this)).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 62.0F) + var73), mouseX, mouseY);
                                    if (!(var71)) {
                                    }
                                }
                            }
                            if (0L >= 0L) {
                                if (iterator instanceof IdRecord11) {
                                    suggestionsRenderHelper2Impl4.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 32.0F) + var73), mouseX, mouseY);
                                    suggestionsRenderHelper2Impl5.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 47.0F) + var73), mouseX, mouseY);
                                    suggestionsRenderHelper2Impl6.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 62.0F) + var73), mouseX, mouseY);
                                    suggestionsRenderHelper2Impl7.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 77.0F) + var73), mouseX, mouseY);
                                    new FirstRenderHelper2Impl(this.getNumericValue3(), "Toggle", "Hold", (KMutableProperty0) new HoldServiceComponent((IdRecord11) macrosRenderHelper2Impl.getContract8()), (KMutableProperty0) new HoveringComponentServiceComponent4(this)).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 92.0F) + var73), mouseX, mouseY);
                                    new ClickActionRenderHelper2Impl(this.getNumericValue3(), (KMutableProperty0) new HoveringComponentServiceComponent3(this)).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 107.0F) + var73), mouseX, mouseY);
                                    if (0L >= 0L && 0L >= 0L && 0L >= 0L) {
                                    }
                                    if (!(var71)) {
                                    }
                                }
                            }
                        }
                    }
                    ColorValue1RenderHelper.executeAction(this.getNumericValue(), this.getNumericValue2(), this.getNumericValue3(), this.getNumericValue4(), 5.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), context.method_51448(), 0.0F);
                }
            }
        }
        if (var71) {
            if (this.getContract4() != null) {
                this.getContract4().render(context, ((this.getNumericValue() + (this.getNumericValue3() / 2.0F)) - 60.0F), ((this.getNumericValue2() + (this.getNumericValue4() / 2)) - 35.0F), mouseX, mouseY);
            }
        } else {
        }
        if (var71) {
        }
    }

    public void executeAction(int keyCode, int scanCode, int modifiers) {
        long var6 = (0L ^ 0L);
        long var8 = (0L ^ 37401059096302L);
        long var10 = (0L ^ 103591931905114L);
        if (macrosRenderHelper2Impl2 != null) {
            if (macrosRenderHelper2Impl2 != null && macrosRenderHelper2Impl2.getContract8() != null) {
                macrosRenderHelper2Impl2.getContract8().executeAction(new KeyRecord(keyCode));
            }
            macrosRenderHelper2Impl2 = null;
            return;
        }
        this.executeAction(keyCode, scanCode, modifiers);
    }

    public void executeAction(float mX, float mY, int button) {
        int var7 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var9 = (var7 ^ 72650074335561L);
        long var11 = ((var7 ^ 0L) >>> 48);
        long var12 = (((var7 ^ 0L) << 16) >>> 32);
        long var13 = (((var7 ^ 0L) << 48) >>> 48);
        long var14 = (var7 ^ 38836403100948L);
        long var16 = (var7 ^ 102667265312912L);
        long var18 = (var7 ^ 36642135734820L);
        long var20 = (var7 ^ 20362906346987L);
        this.executeAction(mX, mY, button);
        if (!(var22)) {
            if (this.getContract4() != null) {
                if (!(var22)) {
                    if (this.getContract4().checkCondition(mX, mY, button) == 1) {
                    }
                }
            } else {
            }
        }
        if (0) {
            return;
        }
        if (0L >= 0) {
            if (enabledFlag2) {
                SuggestionsRenderHelper2Impl.serviceComponent7.updateValue(null);
                this.updateValue(new CancelRenderHelper());
                return;
            }
            this.updateValue(null);
        }
        if (0L >= 0) {
            if (!(var22)) {
                if (macrosRenderHelper2Impl2 != null) {
                    macrosRenderHelper2Impl2.getContract8().executeAction(new KeyRecord(button));
                    macrosRenderHelper2Impl2 = null;
                    return;
                }
            }
        }
        if (0L > 0 && !(var22)) {
            if (renderHelper2 != null) {
                renderHelper22 = renderHelper2;
                renderHelper2.checkCondition(mX, mY, button);
                return;
            }
            renderHelper22 = null;
        }
        if (0L >= 0 && !(var22)) {
        }
        if (enabledFlag) {
            macrosRenderHelper2Impl2 = (MacrosRenderHelper2Impl) renderHelper23;
            return;
        }
        if (!(var22)) {
            if (!((MacrosRenderHelper2Impl) renderHelper23.getContract8().isActive())) {
            }
        } else {
        }
        1.updateValue(0);
        if (0L >= 0) {
            macrosRenderHelper2Impl = (MacrosRenderHelper2Impl) renderHelper23;
            suggestionsRenderHelper2Impl.executeAction(macrosRenderHelper2Impl.getContract8().getString());
        }
        if (0L >= 0) {
            if (!(var22)) {
                if (macrosRenderHelper2Impl.getContract8() instanceof IdRecord9) {
                    suggestionsRenderHelper2Impl2.executeAction((IdRecord9) macrosRenderHelper2Impl.getContract8().getString());
                }
            }
        }
        if (0L > 0 && !(var22)) {
            if (macrosRenderHelper2Impl.getContract8() instanceof IdRecord) {
                suggestionsRenderHelper2Impl3.executeAction((IdRecord) macrosRenderHelper2Impl.getContract8().getString());
            }
        }
        if (0L >= 0) {
            if (macrosRenderHelper2Impl.getContract8() instanceof IdRecord11) {
                suggestionsRenderHelper2Impl4.executeAction((IdRecord11) macrosRenderHelper2Impl.getContract8().getString());
                suggestionsRenderHelper2Impl5.executeAction((IdRecord11) macrosRenderHelper2Impl.getContract8().getString2());
                suggestionsRenderHelper2Impl6.executeAction((IdRecord11) macrosRenderHelper2Impl.getContract8().getString3());
                suggestionsRenderHelper2Impl7.executeAction((IdRecord11) macrosRenderHelper2Impl.getContract8().getString4());
            }
            easingServiceComponent.updateValue2(0.0F);
            if (0L > 0) {
            }
            macrosRenderHelper2Impl2 = (MacrosRenderHelper2Impl) renderHelper23;
        }
    }

    public void executeAction(double mouseX, double mouseY, double amount) {
        float var10 = this.getNumericValue();
        if (0L >= 0L) {
            if (!(var9)) {
                if (mouseX <= (this.getNumericValue() + 76.0F)) {
                }
            }
            if (!(var9)) {
                if (var10 <= mouseX) {
                }
            }
        } else {
        }
        var10 = this.getNumericValue2();
        if (0L >= 0L) {
            if (!(var9)) {
                if (mouseY <= ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)) {
                }
            }
            if (!(var9)) {
                if (var10 <= mouseY) {
                }
            }
        } else {
        }
        factorValue = (factorValue + (amount * 7.0F));
        factorValue = Math.clamp(factorValue, (itemList.size() * -29.0F), 0.0F);
    }

    private static Unit resolveUnit(SuggestionsRenderHelper2Impl arg0) {
        if (macrosRenderHelper2Impl != null && macrosRenderHelper2Impl.getContract8() != null) {
            macrosRenderHelper2Impl.getContract8().executeAction(arg0.getString2());
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(SuggestionsRenderHelper2Impl arg0) {
        if (!(var5)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord9)) {
            return Unit.INSTANCE;
        }
        if (!(var5)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        (IdRecord9) null.executeAction(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit3(SuggestionsRenderHelper2Impl arg0) {
        if (var6) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord)) {
            return Unit.INSTANCE;
        }
        if (var6) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        (IdRecord) null.executeAction(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit4(SuggestionsRenderHelper2Impl arg0) {
        if (var5) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord11)) {
            return Unit.INSTANCE;
        }
        if (var5) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        (IdRecord11) null.executeAction(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit5(SuggestionsRenderHelper2Impl arg0) {
        if (var9) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord11)) {
            return Unit.INSTANCE;
        }
        if (var9) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        IdRecord11 var10 = (IdRecord11) null;
        int var11 = 0;
        Iterable var12 = (Iterable) EnabledServiceComponent.INSTANCE.getArrayList2();
        Object var13 = arg0;
        int var14 = 0;
        Iterator iterator = var12.iterator();
        if (iterator.hasNext()) {
            Object var16 = iterator.next();
            Module var17 = (Module) var16;
            int var18 = 0;
        } else {
        }
        Module var20 = (Module) null;
        if (var9) {
            if (var20 != null) {
            }
            var12 = var20.getList();
            if (var9) {
                if (var12 != null) {
                }
                iterator = (Iterable) var12;
                var16 = 0;
                var17 = iterator;
                var18 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterator, 10));
                int var21 = 0;
                Iterator iterator2 = var17.iterator();
                if (iterator2.hasNext()) {
                    Object var23 = iterator2.next();
                    VisibleSettingProperty var24 = (VisibleSettingProperty) var23;
                    if (var9) {
                        Object var19 = var18;
                        int var25 = 0;
                        var19.add(var24.getString());
                    }
                }
            }
        } else {
        }
        }
        List positions = CollectionsKt.emptyList();
        var18.executeAction(new SuggestionsServiceComponent(positions));
        var10.executeAction2(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit6(SuggestionsRenderHelper2Impl arg0) {
        if (!(var6)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord11)) {
            return Unit.INSTANCE;
        }
        if (!(var6)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        (IdRecord11) null.executeAction(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit7(SuggestionsRenderHelper2Impl arg0) {
        if (!(var5)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        if (!(null instanceof IdRecord11)) {
            return Unit.INSTANCE;
        }
        if (!(var5)) {
            if (macrosRenderHelper2Impl != null) {
            }
            macrosRenderHelper2Impl.getContract8();
        }
        (IdRecord11) null.executeAction3(arg0.getString2());
        return Unit.INSTANCE;
    }

    private static Unit getUnit() {
        MacroServiceComponent.INSTANCE.checkCondition(macrosRenderHelper2Impl.getContract8());
        Collection var5 = (Collection) itemList;
        MacrosRenderHelper2Impl var6 = macrosRenderHelper2Impl;
        TypeIntrinsics.asMutableCollection().remove();
        macrosRenderHelper2Impl = null;
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new MacroPanelRenderHelper3Impl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[2]);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[1]);
        easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[0]);
        suggestionsRenderHelper2Impl = new SuggestionsRenderHelper2Impl("Name", INSTANCE.getNumericValue3(), null, this::resolveUnit);
        suggestionsRenderHelper2Impl2 = new SuggestionsRenderHelper2Impl("Text", INSTANCE.getNumericValue3(), null, this::resolveUnit2);
        List positions = new ArrayList();
        Object var46 = positions;
        float var60 = INSTANCE.getNumericValue3();
        String var59 = "Item";
        int var47 = 0;
        Iterable var48 = (Iterable) class_7923.field_41175;
        Object var49 = var46;
        int var50 = 0;
        Object var51 = var48;
        Collection var52 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var53 = 0;
        Iterator iterator = var51.iterator();
        if (iterator.hasNext()) {
            Object var55 = iterator.next();
            Block var56 = (Block) var55;
            Object var57 = var52;
            int var58 = 0;
            var57.add(StringsKt.replace$default(var56.method_63499(), "block.minecraft.", ""));
        }
        var49.addAll((Collection) var52);
        var48 = (Iterable) class_7923.field_41178;
        var49 = var46;
        var50 = 0;
        var51 = var48;
        var52 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        var53 = 0;
        iterator = var51.iterator();
        if (iterator.hasNext()) {
            var55 = iterator.next();
            var56 = (Item) var55;
            var57 = var52;
            var58 = 0;
            var57.add(StringsKt.replace$default(var56.method_7876(), "item.minecraft.", ""));
        }
        var49.addAll((Collection) var52);
        Unit var61 = Unit.INSTANCE;
        Object var62 = positions;
        Function1 var63 = this::resolveUnit3;
        SuggestionsServiceComponent var64 = new SuggestionsServiceComponent();
        float var65 = var60;
        Object var66 = var59;
        suggestionsRenderHelper2Impl3 = new SuggestionsRenderHelper2Impl();
        positions = (Iterable) EnabledServiceComponent.INSTANCE.getArrayList2();
        var60 = INSTANCE.getNumericValue3();
        var59 = "Module";
        var46 = 0;
        var47 = positions;
        var48 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(positions, 10));
        var49 = 0;
        var50 = var47.iterator();
        if (var50.hasNext()) {
            var51 = var50.next();
            var52 = (Module) var51;
            var61 = var48;
            var53 = 0;
            var61.add(var52.getString());
        }
        var61 = var48;
        Object var67 = var61;
        Function1 var68 = this::resolveUnit4;
        SuggestionsServiceComponent var69 = new SuggestionsServiceComponent();
        float var70 = var60;
        Object var71 = var59;
        suggestionsRenderHelper2Impl4 = new SuggestionsRenderHelper2Impl();
        suggestionsRenderHelper2Impl5 = new SuggestionsRenderHelper2Impl("Setting", INSTANCE.getNumericValue3(), null, this::resolveUnit5);
        suggestionsRenderHelper2Impl6 = new SuggestionsRenderHelper2Impl("Press", INSTANCE.getNumericValue3(), null, this::resolveUnit6);
        suggestionsRenderHelper2Impl7 = new SuggestionsRenderHelper2Impl("Release", INSTANCE.getNumericValue3(), null, this::resolveUnit7);
        INSTANCE.updateValue();
        INSTANCE.updateValue2(240.0F);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
