package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import su.catlean.api.contracts.Contract4;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.DefaultServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl2;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl4;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent87;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.VecServiceComponent;
import su.catlean.client.services.client.config.models.IdRecord3;
import su.catlean.client.services.client.config.models.IdRecord8;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.OptionMode7;
import su.catlean.client.types.OptionMode8;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.types.mappings.i0WhenMappings;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class ConfigPanelRenderHelper3Impl extends RenderHelper3 {

    public static final ConfigPanelRenderHelper3Impl INSTANCE;
    private static final List itemList;
    private static float factorValue;
    private static OptionMode8 optionMode8;
    private static ServiceComponent87 serviceComponent87;
    private static final ServiceComponent10 serviceComponent10;
    private static ElementIdRenderHelper elementIdRenderHelper;
    private static final MissingnoRenderHelper missingnoRenderHelper;
    private static final MissingnoRenderHelper missingnoRenderHelper2;
    private static final EasingServiceComponent easingServiceComponent;

    private ConfigPanelRenderHelper3Impl() {
        super("config-panel", 0.0F, 0.0F, 0.0F, 0.0F);
    }

    public ElementIdRenderHelper getElementIdRenderHelper() {
        return elementIdRenderHelper;
    }

    public void updateValue(ElementIdRenderHelper value) {
        elementIdRenderHelper = value;
    }

    public void updateValue() {
        itemList.clear();
        Iterator iterator = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList().iterator();
        while (iterator.hasNext()) {
            IdRecord3 idRecord3 = ((IdRecord3) iterator.next());
            itemList.add(new ServiceComponent87(idRecord3.getString(), 0.0F, 0.0F, OptionMode8.MODULES));
        }
        iterator = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveList().iterator();
        while (iterator.hasNext()) {
            idRecord3 = ((IdRecord8) iterator.next());
            itemList.add(new ServiceComponent87(idRecord3.getString(), 0.0F, 0.0F, OptionMode8.WIDGETS));
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        this.render(context, mouseX, mouseY);
        if (this.getContract4() != null) {
        }
        this.executeAction(0.0F);
        this.render(context);
        serviceComponent87 = null;
        double offset = Math.floor((this.getNumericValue3() / (factorValue + 6)));
        float factor = 0.0F;
        float factor2 = 15.0F;
        float factor3 = Math.max(3.0F, (((this.getNumericValue3() - 6) - (offset * factorValue)) / offset));
        Iterator iterator = itemList.iterator();
        while (iterator.hasNext()) {
            ServiceComponent87 serviceComponent87 = ((ServiceComponent87) iterator.next());
            if (__UNDEF_KEY__ != null) {
                if (optionMode8 != serviceComponent87.getOptionMode8()) {
                }
                float factor4 = ((factor + this.getNumericValue()) + 4);
                float factor5 = (((factor + this.getNumericValue()) + 4) + factorValue);
                int index = mouseX;
                if (__UNDEF_KEY__ != null) {
                    if (factor4 <= index) {
                        if (__UNDEF_KEY__ != null) {
                            if (index <= factor5) {
                            }
                        }
                    } else {
                    }
                }
                if (0) {
                    factor4 = ((factor2 + this.getNumericValue2()) + 17);
                    factor5 = (((factor2 + this.getNumericValue2()) + 17) + factorValue);
                    index = mouseY;
                    if (__UNDEF_KEY__ != null) {
                        if (factor4 <= index) {
                            if (__UNDEF_KEY__ != null) {
                                if (index <= factor5) {
                                }
                            }
                        } else {
                        }
                    }
                    if (0) {
                        serviceComponent87 = serviceComponent87;
                    }
                }
                if (Intrinsics.areEqual(serviceComponent87, serviceComponent87)) {
                }
                int index2 = 14336;
                float factor6 = 0.0F;
                float factor7 = 0.0F;
                float factor8 = 0.0F;
                Color color = NewThemeRenderHelper.INSTANCE.getColor5().darker();
                Color color2 = NewThemeRenderHelper.INSTANCE.getColor5().darker();
                float factor9 = 1.0F;
                float factor10 = 0.0F;
                float factor11 = 0.0F;
                float factor12 = 2.0F;
                float factor13 = 4.0F;
                float factor14 = ((factor2 + this.getNumericValue2()) + 17);
                StackShaderComponent2.executeAction(((factor + this.getNumericValue()) + 4), factor14, factorValue, factorValue, factor13, factor12, factor11, factor10, factor9, color2, color, factor8, factor7, factor6, index2);
                if (__UNDEF_KEY__ != null) {
                    if (serviceComponent87.getString().length() > 10) {
                    }
                }
                factor4 = serviceComponent87.getString();
                SFMServiceComponent.resolveFontRenderHelper().render(context, factor4, (((factor + this.getNumericValue()) + 4) + (factorValue / 2.0F)), ((((factor2 + this.getNumericValue2()) + 17) + (factorValue / 2.0F)) + 12.0F), NewThemeRenderHelper.INSTANCE.getColor5());
                factor5 = new NoWhenBranchMatchedException();
                index = 0;
                if (__UNDEF_KEY__ != null) {
                    if (serviceComponent87.getOptionMode8() == OptionMode8.MODULES) {
                        index = Intrinsics.areEqual(serviceComponent87.getString(), ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveIdRecord3().getString());
                    }
                    if (__UNDEF_KEY__ != null) {
                        if (serviceComponent87.getOptionMode8() == OptionMode8.WIDGETS) {
                            index = Intrinsics.areEqual(serviceComponent87.getString(), ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveIdRecord8().getString());
                        }
                    }
                }
                if (index) {
                    MissingnoRenderHelper.executeAction(factor5, ((Matrix3x2f) context.method_51448()), ((factor + this.getNumericValue()) + 10.0D), ((factor2 + this.getNumericValue2()) + 18.0D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.resolveColor(0), NewThemeRenderHelper.INSTANCE.resolveColor(180), 0.0F);
                    if (__UNDEF_KEY__ == null) {
                        MissingnoRenderHelper.executeAction(factor5, ((Matrix3x2f) context.method_51448()), ((factor + this.getNumericValue()) + 10.0D), ((factor2 + this.getNumericValue2()) + 18.0D), 0.0F, 0.0F, null, null, 0.0F);
                    }
                }
                factor = (factor + (factorValue + factor3));
                if (__UNDEF_KEY__ != null) {
                    factor = 0.0F;
                }
                factor2 = (factor2 + (factorValue + 3.0F));
                ColorValue1RenderHelper.executeAction(this.getNumericValue(), this.getNumericValue2(), this.getNumericValue3(), this.getNumericValue4(), 5.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent.getNumericValue()), context.method_51448(), 0.0F);
            }
        }
        if (__UNDEF_KEY__ != null) {
            if (this.getContract4() != null) {
                this.getContract4().render(context, ((this.getNumericValue() + (this.getNumericValue3() / 2.0F)) - 60.0F), ((this.getNumericValue2() + (this.getNumericValue4() / 2)) - 35.0F), mouseX, mouseY);
            } else {
            }
        }
        if (elementIdRenderHelper != null) {
            elementIdRenderHelper.render(context, mouseX, mouseY);
        }
    }

    private void render(DrawContext arg0) {
        float factor = 16.0F;
        float factor2 = 3.5F;
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.getNumericValue() + factor2), (this.getNumericValue2() + factor), (this.getNumericValue3() - 7.0F), 13.0F, 2.0F, 0.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5().darker(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        Color[] items = new Color[1];
        items[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(arg0.method_51448(), ((this.getNumericValue() + ((this.getNumericValue3() - 7.0F) * 0.5F)) + factor2), ((this.getNumericValue2() + 2.0F) + factor), 0.5F, 9.0F, items);
        if (optionMode8 != OptionMode8.MODULES) {
        }
        items = Color.WHITE;
        if (__UNDEF_KEY__ != null) {
            arg0.render("Modules", ((this.getNumericValue() + ((this.getNumericValue3() - 7.0F) * 0.25F)) + factor2), ((this.getNumericValue2() + 5.0F) + factor), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F), items);
            if (optionMode8 != OptionMode8.WIDGETS) {
            } else {
            }
        }
        items = Color.WHITE;
        arg0.render("Hud", ((this.getNumericValue() + ((this.getNumericValue3() - 7.0F) * 0.75F)) + factor2), ((this.getNumericValue2() + 5.0F) + factor), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F), items);
    }

    public void executeAction(float mX, float mY, int button) {
        this.executeAction(mX, mY, button);
        if (__UNDEF_KEY__ != null) {
            if (this.getContract4() != null) {
                if (__UNDEF_KEY__ != null) {
                    if (this.getContract4().checkCondition(mX, mY, button) == 1) {
                    }
                }
            } else {
            }
        }
        if (0) {
            return;
        }
        if (__UNDEF_KEY__ >= 0) {
            if (elementIdRenderHelper != null) {
                elementIdRenderHelper.executeAction(mX, mY, button);
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (button == 1) {
                if (serviceComponent87 != null) {
                }
                float factor = this.getNumericValue();
                if (__UNDEF_KEY__ >= 0) {
                    if (__UNDEF_KEY__ != null) {
                        if (mX <= (this.getNumericValue() + this.getNumericValue3())) {
                            if (__UNDEF_KEY__ != null) {
                                if (factor <= mX) {
                                }
                            }
                        } else {
                        }
                    }
                }
                if (0) {
                    factor = this.getNumericValue2();
                    if (__UNDEF_KEY__ > 0) {
                        if (__UNDEF_KEY__ != null) {
                            if (mY <= (this.getNumericValue2() + this.getNumericValue4())) {
                                if (__UNDEF_KEY__ != null) {
                                    if (factor <= mY) {
                                    }
                                }
                            } else {
                            }
                        }
                    }
                    if (0) {
                    }
                }
            } else {
            }
        }
        elementIdRenderHelper = null;
        if (!(button) && serviceComponent87 != null) {
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ > 0) {
                    if (!(serviceComponent10.checkCondition(400))) {
                        DefaultServiceComponent.executeAction(serviceComponent87.getString(), serviceComponent87.getOptionMode8());
                        StartupServiceComponent.INSTANCE.getVecServiceComponent15().updateValue();
                    }
                }
            }
            serviceComponent10.executeAction();
            return;
        }
        factor = (this.getNumericValue2() + 16);
        if (__UNDEF_KEY__ != null || __UNDEF_KEY__ >= 0) {
            return;
        }
        if (__UNDEF_KEY__ != null) {
            if (mY <= (this.getNumericValue2() + 29)) {
            }
        }
        factor = (this.getNumericValue() + 3.5F);
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ != null) {
                if (mX <= ((this.getNumericValue() + 3.5F) + ((this.getNumericValue3() - 7.0F) * 0.5F))) {
                    if (__UNDEF_KEY__ != null) {
                        if (factor <= mX) {
                        }
                    }
                } else {
                }
            }
        }
        if (__UNDEF_KEY__ > 0) {
            if (0) {
                optionMode8 = OptionMode8.MODULES;
            }
            factor = ((this.getNumericValue() + 3.5F) + ((this.getNumericValue3() - 7.0F) * 0.5F));
        }
        if (__UNDEF_KEY__ > 0) {
            if (__UNDEF_KEY__ != null) {
                if (mX <= ((this.getNumericValue() + 3.5F) + (this.getNumericValue3() - 7.0F))) {
                    if (__UNDEF_KEY__ != null) {
                        if (factor <= mX) {
                        }
                    }
                } else {
                }
            }
        }
        optionMode8 = OptionMode8.WIDGETS;
    }

    static {
        INSTANCE = new ConfigPanelRenderHelper3Impl();
        itemList = new ArrayList();
        factorValue = 40.0F;
        optionMode8 = OptionMode8.MODULES;
        serviceComponent10 = new ServiceComponent10();
        missingnoRenderHelper = new MissingnoRenderHelper("panels/modules-config", 28, 28);
        missingnoRenderHelper2 = new MissingnoRenderHelper("panels/hud-config", 28, 28);
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        INSTANCE.updateValue();
    }

}
