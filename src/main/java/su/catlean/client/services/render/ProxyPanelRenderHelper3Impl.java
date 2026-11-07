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

    public void updateValue() {
        itemList.clear();
        Iterable iterable = ((Iterable) ProxyServiceComponent.INSTANCE.resolveList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord12 idRecord12 = ((IdRecord12) element);
            itemList.add(new ProxyRenderHelper2Impl(idRecord12));
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        this.render(context, mouseX, mouseY);
        if (__UNDEF_KEY__ == null) {
            easingServiceComponent.executeAction(1.0F);
            if (this.getContract4() != null) {
            } else {
            }
        }
        this.executeAction(0.0F);
        easingServiceComponent3.executeAction(factorValue);
        float factor = (this.getNumericValue() + 3.0F);
        float factor2 = (this.getNumericValue() + 72.0F);
        int index = mouseX;
        if (__UNDEF_KEY__ == null) {
            if (factor <= index) {
                if (__UNDEF_KEY__ == null) {
                }
            } else {
                if (index <= factor2) {
                    factor = (this.getNumericValue2() + 5.0F);
                    factor2 = (this.getNumericValue2() + 13.0F);
                    index = mouseY;
                    if (__UNDEF_KEY__ == null) {
                        if (factor <= index) {
                            if (__UNDEF_KEY__ == null) {
                            }
                        } else {
                        }
                    }
                } else {
                    enabledFlag = index <= factor2;
                }
            }
        }
        if (enabledFlag) {
        } else {
        }
        if (enabledFlag) {
        } else {
        }
        int index2 = 14336;
        float factor3 = 0.0F;
        float factor4 = 0.0F;
        float factor5 = 0.0F;
        Color color = NewThemeRenderHelper.INSTANCE.getColor6();
        Color color2 = NewThemeRenderHelper.INSTANCE.getColor4();
        float factor6 = 1.0F;
        float factor7 = 0.0F;
        float factor8 = 0.1F;
        float factor9 = 2.0F;
        float factor10 = 2.5F;
        float factor11 = 2.0F;
        float factor12 = 8.0F;
        float factor13 = 69.0F;
        StackShaderComponent2.executeAction((this.getNumericValue2() + 3.0F), factor13, factor12, factor11, factor10, factor9, factor8, factor7, factor6, color2, color, factor5, factor4, factor3, index2);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "+", (this.getNumericValue() + 36.0F), (this.getNumericValue2() + 1.0F), Color.WHITE);
        StackShaderComponent2.executeAction(context.method_51448(), (this.getNumericValue() + 76.0F), this.getNumericValue2(), 6.0F, this.getNumericValue4(), 1.0F, 0.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        renderHelper23 = null;
        renderHelper2 = null;
        factor = 0.0F;
        factor = (17.0F + easingServiceComponent3.getNumericValue());
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(this.getNumericValue(), (this.getNumericValue2() + 14), (this.getNumericValue() + 76), ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)));
        factor2 = ((Iterable) itemList);
        index = 0;
        Iterator iterator = factor2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ProxyRenderHelper2Impl proxyRenderHelper2Impl = ((ProxyRenderHelper2Impl) element);
            proxyRenderHelper2Impl.render(context, INSTANCE.getNumericValue(), (INSTANCE.getNumericValue2() + factor), mouseX, mouseY);
            factor = (factor + 29.0F);
            if (__UNDEF_KEY__ == null) {
                PolygonShaderComponent.INSTANCE.render(context);
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (proxyRenderHelper2Impl != null) {
                factor2 = ((1.0F - easingServiceComponent.getNumericValue()) * 10.0F);
                index = this::getUnit;
                suggestionsRenderHelper2Impl.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 17.0F) + factor2), mouseX, mouseY);
                suggestionsRenderHelper2Impl2.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 32.0F) + factor2), mouseX, mouseY);
                suggestionsRenderHelper2Impl3.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 47.0F) + factor2), mouseX, mouseY);
                suggestionsRenderHelper2Impl4.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 62.0F) + factor2), mouseX, mouseY);
                suggestionsRenderHelper2Impl5.render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 77.0F) + factor2), mouseX, mouseY);
                new FirstRenderHelper2Impl(this.getNumericValue3(), "Socks5", "Socks4", ((KMutableProperty0) new Socks4ServiceComponent(proxyRenderHelper2Impl.getIdRecord12())), ((KMutableProperty0) new HoveringComponentServiceComponent7(this))).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 92.0F) + factor2), mouseX, mouseY);
                new ClickActionRenderHelper2Impl(index, this.getNumericValue3(), ((KMutableProperty0) new HoveringComponentServiceComponent9(this))).render(context, (this.getNumericValue() + 84.0F), ((this.getNumericValue2() + 107.0F) + factor2), mouseX, mouseY);
            }
            ColorValue1RenderHelper.executeAction(this.getNumericValue(), this.getNumericValue2(), this.getNumericValue3(), this.getNumericValue4(), 5.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent2.getNumericValue()), context.method_51448(), 0.0F);
        }
        if (__UNDEF_KEY__ == null) {
            if (this.getContract4() != null) {
                this.getContract4().render(context, ((this.getNumericValue() + (this.getNumericValue3() / 2.0F)) - 60.0F), ((this.getNumericValue2() + (this.getNumericValue4() / 2)) - 35.0F), mouseX, mouseY);
            } else {
            }
        }
    }

    private void executeAction(String arg0) {
        ProxyServiceComponent.INSTANCE.checkCondition2(new IdRecord12(arg0, "", 0, "", "", false));
        this.updateValue();
        this.updateValue(null);
    }

    public void executeAction(float mX, float mY, int button) {
        this.executeAction(mX, mY, button);
        if (this.getContract4() != null) {
        } else {
            if (this.getContract4().checkCondition(mX, mY, button) == 1) {
                return;
            }
        }
        if (__UNDEF_KEY__ > 0) {
            if (enabledFlag) {
                SuggestionsRenderHelper2Impl.serviceComponent7.updateValue(null);
                this.updateValue(new ActionRenderHelper(this::resolveUnit));
                return;
            }
            this.updateValue(null);
        }
        if (__UNDEF_KEY__ > 0) {
            if (renderHelper2 != null) {
                renderHelper22 = renderHelper2;
                renderHelper2.checkCondition(mX, mY, button);
                return;
            }
            renderHelper22 = null;
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ >= 0) {
                if (Intrinsics.areEqual(ProxyServiceComponent.INSTANCE.getIdRecord12(), ((ProxyRenderHelper2Impl) renderHelper23).getIdRecord12())) {
                    ProxyServiceComponent.INSTANCE.updateValue(null);
                } else {
                    ProxyServiceComponent.INSTANCE.updateValue(((ProxyRenderHelper2Impl) renderHelper23).getIdRecord12());
                    proxyRenderHelper2Impl = ((ProxyRenderHelper2Impl) renderHelper23);
                    suggestionsRenderHelper2Impl.executeAction(proxyRenderHelper2Impl.getIdRecord12().getString());
                    suggestionsRenderHelper2Impl2.executeAction(proxyRenderHelper2Impl.getIdRecord12().getString2());
                    suggestionsRenderHelper2Impl3.executeAction(String.valueOf(proxyRenderHelper2Impl.getIdRecord12().getNumericValue()));
                    suggestionsRenderHelper2Impl5.executeAction(proxyRenderHelper2Impl.getIdRecord12().getString4());
                    suggestionsRenderHelper2Impl4.executeAction(proxyRenderHelper2Impl.getIdRecord12().getString3());
                    easingServiceComponent.updateValue2(0.0F);
                }
            }
        }
    }

    public void executeAction(double mouseX, double mouseY, double amount) {
        float factor = this.getNumericValue();
        if (__UNDEF_KEY__ > 0L) {
            if (__UNDEF_KEY__ == null) {
                if (mouseX <= (this.getNumericValue() + 76.0F)) {
                    if (__UNDEF_KEY__ == null) {
                    }
                } else {
                }
            }
        }
        factor = this.getNumericValue2();
        if (__UNDEF_KEY__ > 0L) {
            if (__UNDEF_KEY__ == null) {
                if (mouseY <= ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)) {
                    if (__UNDEF_KEY__ == null) {
                    }
                } else {
                }
            }
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
        Collection collection = ((Collection) itemList);
        TypeIntrinsics.asMutableCollection(collection).remove(proxyRenderHelper2Impl);
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
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
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
