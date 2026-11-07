package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.contracts.Contract4;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.HoveringComponentServiceComponent7;
import su.catlean.client.services.client.HoveringComponentServiceComponent9;
import su.catlean.client.services.client.ProxyServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent7;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.client.Socks4ServiceComponent;
import su.catlean.client.services.client.config.models.IdRecord12;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class ProxyPanelRenderHelper3Impl extends RenderHelper3 {

    public static final ProxyPanelRenderHelper3Impl INSTANCE;
    private static final List itemList;
    private static RenderHelper2 renderHelper2;
    private static RenderHelper2 renderHelper22;
    private static RenderHelper2 renderHelper23;
    private static ProxyRenderHelper2Impl proxyRenderHelper2Impl;
    private static EasingServiceComponent easingServiceComponent;
    private static EasingServiceComponent easingServiceComponent2;
    private static EasingServiceComponent easingServiceComponent3;
    private static boolean enabledFlag;
    private static float factorValue;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl2;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl3;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl4;
    private static final SuggestionsRenderHelper2Impl suggestionsRenderHelper2Impl5;
    private static String textValue;

    private ProxyPanelRenderHelper3Impl() {
        super("proxy-panel", 0.0F, 0.0F, 0.0F, 0.0F);
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

    public ProxyRenderHelper2Impl getProxyRenderHelper2Impl() {
        return proxyRenderHelper2Impl;
    }

    public void updateValue(ProxyRenderHelper2Impl value) {
        proxyRenderHelper2Impl = value;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return easingServiceComponent;
    }

    public void executeAction(EasingServiceComponent value) {
        easingServiceComponent = value;
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 135417448851113L);
        long var5 = (arg0 ^ 25583469870279L);
        itemList.clear();
        Iterable var7 = (Iterable) ProxyServiceComponent.INSTANCE.resolveList();
        int var8 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            IdRecord12 var11 = (IdRecord12) var10;
            int var12 = 0;
            itemList.add(new ProxyRenderHelper2Impl());
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        long var6 = (0L ^ 135894313010346L);
        long var8 = ((0L ^ 138493012530694L) >>> 32);
        long var9 = (((0L ^ 138493012530694L) << 32) >>> 48);
        long var10 = (((0L ^ 138493012530694L) << 48) >>> 48);
        long var11 = (0L ^ 136208856317167L);
        long var13 = (0L ^ 38443269427772L);
        long var15 = (0L ^ 128069896831989L);
        long var17 = (0L ^ 136208856317167L);
        long var19 = (0L ^ 129382754651428L);
        long var21 = (0L ^ 47084340786468L);
        long var23 = ((0L ^ 55302899458674L) >>> 48);
        long var24 = (((0L ^ 55302899458674L) << 16) >>> 32);
        long var25 = (((0L ^ 55302899458674L) << 48) >>> 48);
        long var26 = ((0L ^ 22135879901675L) >>> 48);
        long var27 = (((0L ^ 22135879901675L) << 16) >>> 48);
        long var28 = (((0L ^ 22135879901675L) << 32) >>> 32);
        long var29 = (0L ^ 136208856317167L);
        long var31 = (0L ^ 27182768661316L);
        long var33 = (0L ^ 0L);
        long var35 = (0L ^ 97910750751556L);
        long var37 = (0L ^ 55127167163707L);
        long var39 = (0L ^ 101408683801774L);
        long var41 = (0L ^ 2881734234662L);
        long var43 = (0L ^ 55531218400380L);
        long var45 = (0L ^ 136208856317167L);
        this.render(context, mouseX, mouseY);
        if (var62 == null) {
            easingServiceComponent.executeAction(1.0F);
            if (this.getContract4() != null) {
            }
        } else {
        }
        0.5F.executeAction(0.0F);
        easingServiceComponent3.executeAction(factorValue);
        float var63 = (this.getNumericValue() + 3.0F);
        float var64 = (this.getNumericValue() + 72.0F);
        int var65 = mouseX;
        if (0L >= 0L) {
            if (var62 == null) {
                if (var63 <= var65) {
                }
            }
            if (var62 == null) {
            }
        } else {
        }
        if (var65 <= var64) {
            var63 = (this.getNumericValue2() + 5.0F);
            var64 = (this.getNumericValue2() + 13.0F);
            var65 = mouseY;
            if (0L > 0L) {
                if (var62 == null) {
                    if (var63 <= var65) {
                    }
                }
                if (var62 == null) {
                }
            } else {
            }
            if (0L > 0L) {
                if (var65 <= var64) {
                }
            }
        } else {
        }
        }
        enabledFlag = 0;
        if (enabledFlag) {
        } else {
        }
        if (enabledFlag) {
        } else {
        }
        int var48 = 14336;
        float var49 = 0.0F;
        float var50 = 0.0F;
        float var51 = 0.0F;
        Color var52 = NewThemeRenderHelper.INSTANCE.getColor6();
        Color var53 = NewThemeRenderHelper.INSTANCE.getColor4();
        float var54 = 1.0F;
        float var55 = 0.0F;
        float var56 = 0.1F;
        float var57 = 2.0F;
        float var58 = 2.5F;
        float var59 = 2.0F;
        float var60 = 8.0F;
        float var61 = 69.0F;
        StackShaderComponent2.executeAction((this.getNumericValue2() + 3.0F));
        SFMServiceComponent.resolveFontRenderHelper().render(context, "+", (this.getNumericValue() + 36.0F), (this.getNumericValue2() + 1.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() + 76.0F), this.getNumericValue2(), 6.0F, this.getNumericValue4(), 1.0F, 0.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        renderHelper23 = null;
        renderHelper2 = null;
        var63 = 0.0F;
        var63 = (17.0F + easingServiceComponent3.getNumericValue());
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(this.getNumericValue(), (this.getNumericValue2() + 14), (this.getNumericValue() + 76), ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)));
        var64 = (Iterable) itemList;
        var65 = 0;
        Iterator iterator = var64.iterator();
        if (iterator.hasNext()) {
            Object var67 = iterator.next();
            ProxyRenderHelper2Impl var68 = (ProxyRenderHelper2Impl) var67;
            int var69 = 0;
            var68.render(context, INSTANCE.getNumericValue(), (INSTANCE.getNumericValue2() + var63), mouseX, mouseY);
            var63 = (var63 + 29.0F);
            if (0L >= 0L) {
                if (var62 == null) {
                }
                PolygonShaderComponent.INSTANCE.render(context);
            }
        }
        if (0L >= 0L) {
            if (var62 == null) {
                if (proxyRenderHelper2Impl != null) {
                    var64 = ((1.0F - easingServiceComponent.getNumericValue()) * 10.0F);
                    var65 = this::getUnit;
                    suggestionsRenderHelper2Impl.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 17.0F) + var64), mouseX, mouseY);
                    suggestionsRenderHelper2Impl2.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 32.0F) + var64), mouseX, mouseY);
                    suggestionsRenderHelper2Impl3.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 47.0F) + var64), mouseX, mouseY);
                    suggestionsRenderHelper2Impl4.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 62.0F) + var64), mouseX, mouseY);
                    suggestionsRenderHelper2Impl5.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 77.0F) + var64), mouseX, mouseY);
                    new FirstRenderHelper2Impl(this.getNumericValue3(), "Socks5", "Socks4", (KMutableProperty0) new Socks4ServiceComponent(proxyRenderHelper2Impl.getIdRecord12()), (KMutableProperty0) new HoveringComponentServiceComponent7(this)).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 92.0F) + var64), mouseX, mouseY);
                    new ClickActionRenderHelper2Impl(this.getNumericValue3(), (KMutableProperty0) new HoveringComponentServiceComponent9(this)).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 107.0F) + var64), mouseX, mouseY);
                }
                ColorValue1RenderHelper.executeAction(this.getNumericValue(), this.getNumericValue2(), this.getNumericValue3(), this.getNumericValue4(), 5.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), context.method_51448(), 0.0F);
            }
        }
        if (var62 == null) {
            if (this.getContract4() != null) {
                this.getContract4().render(context, ((this.getNumericValue() + (this.getNumericValue3() / 2.0F)) - 60.0F), ((this.getNumericValue2() + (this.getNumericValue4() / 2)) - 35.0F), mouseX, mouseY);
            }
        } else {
        }
    }

    private void executeAction(String arg0) {
        ProxyServiceComponent.INSTANCE.checkCondition2(new IdRecord12(arg0, "", 0, "", ""));
        this.updateValue();
        this.updateValue(null);
    }

    public void executeAction(float mX, float mY, int button) {
        int var7 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var9 = (var7 ^ 72650074335561L);
        long var11 = ((var7 ^ 0L) >>> 48);
        long var12 = (((var7 ^ 0L) << 16) >>> 32);
        long var13 = (((var7 ^ 0L) << 48) >>> 48);
        long var14 = (var7 ^ 38836403100948L);
        long var16 = (var7 ^ 89123186698759L);
        long var18 = (var7 ^ 20362906346987L);
        this.executeAction(mX, mY, button);
        if (this.getContract4() != null) {
        } else {
        }
        if (this.getContract4().checkCondition(mX, mY, button) == 1) {
            return;
        }
        if (0L > 0) {
            if (enabledFlag) {
                SuggestionsRenderHelper2Impl.serviceComponent7.updateValue(null);
                this.updateValue(new ActionRenderHelper(this::resolveUnit));
                return;
            }
            this.updateValue(null);
        }
        if (0L > 0) {
            if (renderHelper2 != null) {
                renderHelper22 = renderHelper2;
                renderHelper2.checkCondition(mX, mY, button);
                return;
            }
            renderHelper22 = null;
        }
        if (0L >= 0) {
            if (0L >= 0) {
            }
            if (Intrinsics.areEqual(ProxyServiceComponent.INSTANCE.getIdRecord12(), (ProxyRenderHelper2Impl) renderHelper23.getIdRecord12())) {
                ProxyServiceComponent.INSTANCE.updateValue(null);
            } else {
            }
            ProxyServiceComponent.INSTANCE.updateValue((ProxyRenderHelper2Impl) renderHelper23.getIdRecord12());
            proxyRenderHelper2Impl = (ProxyRenderHelper2Impl) renderHelper23;
            suggestionsRenderHelper2Impl.executeAction(proxyRenderHelper2Impl.getIdRecord12().getString());
            suggestionsRenderHelper2Impl2.executeAction(proxyRenderHelper2Impl.getIdRecord12().getString2());
            suggestionsRenderHelper2Impl3.executeAction(String.valueOf(proxyRenderHelper2Impl.getIdRecord12().getNumericValue()));
            suggestionsRenderHelper2Impl5.executeAction(proxyRenderHelper2Impl.getIdRecord12().getString4());
            suggestionsRenderHelper2Impl4.executeAction(proxyRenderHelper2Impl.getIdRecord12().getString3());
            easingServiceComponent.updateValue2(0.0F);
        }
    }

    public void executeAction(double mouseX, double mouseY, double amount) {
        float var10 = this.getNumericValue();
        if (0L > 0L) {
            if (var9 == null) {
                if (mouseX <= (this.getNumericValue() + 76.0F)) {
                }
            }
            if (var9 == null) {
            }
        } else {
        }
        var10 = this.getNumericValue2();
        if (0L > 0L) {
            if (var9 == null) {
                if (mouseY <= ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)) {
                }
            }
            if (var9 == null) {
            }
        } else {
        }
        factorValue = (factorValue + (amount * 7.0F));
        factorValue = Math.clamp(factorValue, (itemList.size() * -29.0F), 0.0F);
    }

    private static Unit resolveUnit(SuggestionsRenderHelper2Impl arg0) {
        if (proxyRenderHelper2Impl != null && proxyRenderHelper2Impl.getIdRecord12() != null) {
            proxyRenderHelper2Impl.getIdRecord12().executeAction(arg0.getString2());
        } else {
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(SuggestionsRenderHelper2Impl arg0) {
        if (proxyRenderHelper2Impl != null && proxyRenderHelper2Impl.getIdRecord12() != null) {
            proxyRenderHelper2Impl.getIdRecord12().executeAction(arg0.getString2());
        } else {
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit3(SuggestionsRenderHelper2Impl arg0) {
        if (proxyRenderHelper2Impl != null && proxyRenderHelper2Impl.getIdRecord12() != null) {
            if (StringsKt.toIntOrNull(arg0.getString2()) != null) {
            } else {
                StringsKt.toIntOrNull(arg0.getString2());
            }
            proxyRenderHelper2Impl.getIdRecord12().updateValue(Math.abs(25565));
        } else {
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit4(SuggestionsRenderHelper2Impl arg0) {
        if (proxyRenderHelper2Impl != null && proxyRenderHelper2Impl.getIdRecord12() != null) {
            proxyRenderHelper2Impl.getIdRecord12().executeAction(arg0.getString2());
        } else {
        }
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit5(SuggestionsRenderHelper2Impl arg0) {
        if (proxyRenderHelper2Impl != null && proxyRenderHelper2Impl.getIdRecord12() != null) {
            proxyRenderHelper2Impl.getIdRecord12().executeAction2(arg0.getString2());
        } else {
        }
        return Unit.INSTANCE;
    }

    private static Unit getUnit() {
        ProxyServiceComponent.INSTANCE.checkCondition(proxyRenderHelper2Impl.getIdRecord12());
        Collection var4 = (Collection) itemList;
        ProxyRenderHelper2Impl var5 = proxyRenderHelper2Impl;
        TypeIntrinsics.asMutableCollection().remove();
        proxyRenderHelper2Impl = null;
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(String arg0) {
        INSTANCE.executeAction(arg0);
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new ProxyPanelRenderHelper3Impl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[0]);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[2]);
        easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[1]);
        suggestionsRenderHelper2Impl = new SuggestionsRenderHelper2Impl("Name", INSTANCE.getNumericValue3(), null, this::resolveUnit);
        suggestionsRenderHelper2Impl2 = new SuggestionsRenderHelper2Impl("IP", INSTANCE.getNumericValue3(), null, this::resolveUnit2);
        suggestionsRenderHelper2Impl3 = new SuggestionsRenderHelper2Impl("Port", INSTANCE.getNumericValue3(), null, this::resolveUnit3);
        suggestionsRenderHelper2Impl4 = new SuggestionsRenderHelper2Impl("Login", INSTANCE.getNumericValue3(), null, this::resolveUnit4);
        suggestionsRenderHelper2Impl5 = new SuggestionsRenderHelper2Impl("Pass", INSTANCE.getNumericValue3(), null, this::resolveUnit5);
        ProxyServiceComponent.INSTANCE.updateValue();
        INSTANCE.updateValue();
        INSTANCE.updateValue(530.0F);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
