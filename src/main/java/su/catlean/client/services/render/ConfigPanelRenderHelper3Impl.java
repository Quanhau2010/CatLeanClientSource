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

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 116290776716647L);
        long var5 = ((arg0 ^ 139412124989938L) >>> 32);
        long var6 = (((arg0 ^ 139412124989938L) << 32) >>> 48);
        long var7 = (((arg0 ^ 139412124989938L) << 48) >>> 48);
        long var8 = (arg0 ^ 111425449978190L);
        itemList.clear();
        Iterator iterator = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList().iterator();
        if (iterator.hasNext()) {
            IdRecord3 var11 = (IdRecord3) iterator.next();
            itemList.add(new ServiceComponent87(var11.getString(), 0.0F, 0.0F, OptionMode8.MODULES));
            if (arg0 > 0L) {
            }
            iterator = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveList().iterator();
        }
        var11 = (IdRecord8) iterator.next();
        itemList.add(new ServiceComponent87(var11.getString(), 0.0F, 0.0F, OptionMode8.WIDGETS));
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        long var6 = (0L ^ 34939445883507L);
        long var8 = (0L ^ 38443269427772L);
        long var10 = (0L ^ 132587743020005L);
        long var12 = ((0L ^ 39651225804900L) >>> 32);
        long var13 = (((0L ^ 39651225804900L) << 32) >>> 48);
        long var14 = (((0L ^ 39651225804900L) << 48) >>> 48);
        long var15 = ((0L ^ 55302899458674L) >>> 48);
        long var16 = (((0L ^ 55302899458674L) << 16) >>> 32);
        long var17 = (((0L ^ 55302899458674L) << 48) >>> 48);
        long var18 = (0L ^ 61082805113702L);
        long var20 = ((0L ^ 22135879901675L) >>> 48);
        long var21 = (((0L ^ 22135879901675L) << 16) >>> 48);
        long var22 = (((0L ^ 22135879901675L) << 32) >>> 32);
        long var23 = (0L ^ 27182768661316L);
        long var25 = (0L ^ 0L);
        long var27 = (0L ^ 97910750751556L);
        long var29 = (0L ^ 129721350371956L);
        long var31 = (0L ^ 55127167163707L);
        long var33 = (0L ^ 117687767941534L);
        long var35 = (0L ^ 18562037465340L);
        this.render(context, mouseX, mouseY);
        if (this.getContract4() != null) {
        }
        0.5F.executeAction(0.0F);
        this.render(context);
        serviceComponent87 = null;
        double var53 = Math.floor((this.getNumericValue3() / (factorValue + 6)));
        float var54 = 0.0F;
        float var55 = 15.0F;
        float var56 = Math.max(3.0F, (((this.getNumericValue3() - 6) - (var53 * factorValue)) / var53));
        Iterator iterator = itemList.iterator();
        if (iterator.hasNext()) {
            ServiceComponent87 var58 = (ServiceComponent87) iterator.next();
            if (0L >= 0L) {
                if (var52 != null) {
                    if (optionMode8 != var58.getOptionMode8()) {
                    }
                    float var59 = ((var54 + this.getNumericValue()) + 4);
                    float var60 = (((var54 + this.getNumericValue()) + 4) + factorValue);
                    int var61 = mouseX;
                    if (0L > 0L) {
                        if (var52 != null) {
                            if (var59 <= var61) {
                            }
                        }
                        if (var52 != null) {
                            if (var61 <= var60) {
                            }
                        }
                    } else {
                    }
                    if (0) {
                        var59 = ((var55 + this.getNumericValue2()) + 17);
                        var60 = (((var55 + this.getNumericValue2()) + 17) + factorValue);
                        var61 = mouseY;
                        if (0L > 0L) {
                            if (var52 != null) {
                                if (var59 <= var61) {
                                }
                            }
                            if (var52 != null) {
                                if (var61 <= var60) {
                                }
                            }
                        } else {
                        }
                        if (0) {
                            serviceComponent87 = var58;
                        }
                    }
                    if (Intrinsics.areEqual(serviceComponent87)) {
                    }
                    int var38 = 14336;
                    float var39 = 0.0F;
                    float var40 = 0.0F;
                    float var41 = 0.0F;
                    Color var42 = NewThemeRenderHelper.INSTANCE.getColor5().darker();
                    Color var43 = NewThemeRenderHelper.INSTANCE.getColor5().darker();
                    float var44 = 1.0F;
                    float var45 = 0.0F;
                    float var46 = 0.0F;
                    float var47 = 2.0F;
                    float var48 = 4.0F;
                    float var49 = factorValue;
                    float var50 = factorValue;
                    float var51 = ((var55 + this.getNumericValue2()) + 17);
                    StackShaderComponent2.executeAction(((var54 + this.getNumericValue()) + 4));
                    if (var52 != null) {
                        if (var58.getString().length() > 10) {
                        }
                    }
                    var59 = var58.getString();
                    SFMServiceComponent.resolveFontRenderHelper().render(context, (((var54 + this.getNumericValue()) + 4) + (factorValue / 2.0F)), ((((var55 + this.getNumericValue2()) + 17) + (factorValue / 2.0F)) + 12.0F), NewThemeRenderHelper.INSTANCE.getColor5());
                    var60 = new NoWhenBranchMatchedException();
                    var61 = 0;
                    if (var52 != null) {
                        if (var58.getOptionMode8() == OptionMode8.MODULES) {
                            var61 = Intrinsics.areEqual(var58.getString(), ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveIdRecord3().getString());
                        }
                        if (var52 != null) {
                        }
                        if (var58.getOptionMode8() == OptionMode8.WIDGETS) {
                        }
                        var61 = Intrinsics.areEqual(var58.getString(), ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveIdRecord8().getString());
                    }
                    if (0L > 0L) {
                        if (var61) {
                            MissingnoRenderHelper.executeAction((Matrix3x2f) context.method_51448(), ((var54 + this.getNumericValue()) + 10.0D), ((var55 + this.getNumericValue2()) + 18.0D), 0.0F, 0.0F, NewThemeRenderHelper.INSTANCE.resolveColor(0), NewThemeRenderHelper.INSTANCE.resolveColor(180), 0.0F);
                            if (0L >= 0L) {
                                if (var52 == null) {
                                }
                                MissingnoRenderHelper.executeAction((Matrix3x2f) context.method_51448(), ((var54 + this.getNumericValue()) + 10.0D), ((var55 + this.getNumericValue2()) + 18.0D), 0.0F, 0.0F, null, null, 0.0F);
                            }
                        }
                        var54 = (var54 + (factorValue + var56));
                    }
                    if (0L >= 0L) {
                        if (var52 != null) {
                            var54 = 0.0F;
                        }
                    }
                    var55 = (var55 + (factorValue + 3.0F));
                }
                ColorValue1RenderHelper.executeAction(this.getNumericValue(), this.getNumericValue2(), this.getNumericValue3(), this.getNumericValue4(), 5.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent.getNumericValue()), PolygonShaderComponent.INSTANCE.resolveColor(Color.BLACK, easingServiceComponent.getNumericValue()), context.method_51448(), 0.0F);
                if (0L >= 0L) {
                }
            }
        }
        if (var52 != null) {
            if (this.getContract4() != null) {
                this.getContract4().render(context, ((this.getNumericValue() + (this.getNumericValue3() / 2.0F)) - 60.0F), ((this.getNumericValue2() + (this.getNumericValue4() / 2)) - 35.0F), mouseX, mouseY);
            }
        } else {
        }
        if (0L > 0L) {
            if (elementIdRenderHelper != null) {
                elementIdRenderHelper.render(context, mouseX, mouseY);
            }
        }
        if (0L > 0L) {
        }
    }

    private void render(DrawContext arg0) {
        int var17 = 0;
        float var18 = 16.0F;
        float var19 = 3.5F;
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.getNumericValue() + var19), (this.getNumericValue2() + var18), (this.getNumericValue3() - 7.0F), 13.0F, 2.0F, 0.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5().darker(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        Color[] var20 = new Color[1];
        var20[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(arg0.method_51448(), ((this.getNumericValue() + ((this.getNumericValue3() - 7.0F) * 0.5F)) + var19), ((this.getNumericValue2() + 2.0F) + var18), 0.5F, 9.0F);
        if (optionMode8 != OptionMode8.MODULES) {
        }
        var20 = Color.WHITE;
        if (var16 != null) {
            arg0.render("Modules", ((this.getNumericValue() + ((this.getNumericValue3() - 7.0F) * 0.25F)) + var19), ((this.getNumericValue2() + 5.0F) + var18), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F));
            if (optionMode8 != OptionMode8.WIDGETS) {
            }
        } else {
        }
        var20 = Color.WHITE;
        arg0.render("Hud", ((this.getNumericValue() + ((this.getNumericValue3() - 7.0F) * 0.75F)) + var19), ((this.getNumericValue2() + 5.0F) + var18), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, 0.5F));
    }

    public void executeAction(float mX, float mY, int button) {
        int var7 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var9 = ((var7 ^ 0L) >>> 48);
        long var10 = (((var7 ^ 0L) << 16) >>> 32);
        long var11 = (((var7 ^ 0L) << 48) >>> 48);
        long var12 = (var7 ^ 38836403100948L);
        long var14 = (var7 ^ 126023736501908L);
        long var16 = ((var7 ^ 76359761823462L) >>> 32);
        long var17 = (((var7 ^ 76359761823462L) << 32) >>> 48);
        long var18 = (((var7 ^ 76359761823462L) << 48) >>> 48);
        long var19 = (var7 ^ 3863036392059L);
        long var21 = (var7 ^ 127291086940760L);
        long var23 = (var7 ^ 122723470579105L);
        long var25 = ((var7 ^ 132701681991706L) >>> 32);
        long var26 = (((var7 ^ 132701681991706L) << 32) >>> 48);
        long var27 = (((var7 ^ 132701681991706L) << 48) >>> 48);
        this.executeAction(mX, mY, button);
        if (var28 != null) {
            if (this.getContract4() != null) {
                if (var28 != null) {
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
            if (elementIdRenderHelper != null) {
                elementIdRenderHelper.executeAction(mX, mY, button);
            }
        }
        if (0L >= 0) {
            if (button == 1) {
            }
            if (serviceComponent87 != null) {
            }
            float var29 = this.getNumericValue();
            if (0L >= 0) {
                if (var28 != null) {
                    if (mX <= (this.getNumericValue() + this.getNumericValue3())) {
                    }
                }
                if (var28 != null) {
                    if (var29 <= mX) {
                    }
                }
            } else {
            }
            if (0) {
                var29 = this.getNumericValue2();
                if (0L > 0) {
                    if (var28 != null) {
                        if (mY <= (this.getNumericValue2() + this.getNumericValue4())) {
                        }
                    }
                    if (var28 != null) {
                        if (var29 <= mY) {
                        }
                    }
                } else {
                }
                if (0) {
                }
            }
        } else {
        }
        elementIdRenderHelper = null;
        if (!(button) && serviceComponent87 != null) {
            if (var28 != null) {
                if (0L > 0) {
                    if (!(serviceComponent10.checkCondition(400))) {
                        DefaultServiceComponent.executeAction(serviceComponent87.getString(), serviceComponent87.getOptionMode8());
                        StartupServiceComponent.INSTANCE.getVecServiceComponent15().updateValue();
                    }
                }
            }
            serviceComponent10.executeAction();
            return;
        }
        var29 = (this.getNumericValue2() + 16);
        if (var28 != null || 0L >= 0) {
            return;
        }
        if (var28 != null) {
            if (mY <= (this.getNumericValue2() + 29)) {
            }
        }
        var29 = (this.getNumericValue() + 3.5F);
        if (0L >= 0) {
            if (var28 != null) {
                if (mX <= ((this.getNumericValue() + 3.5F) + ((this.getNumericValue3() - 7.0F) * 0.5F))) {
                }
            }
            if (var28 != null) {
                if (var29 <= mX) {
                }
            }
        } else {
        }
        if (0L > 0) {
            if (0) {
                optionMode8 = OptionMode8.MODULES;
            }
            var29 = ((this.getNumericValue() + 3.5F) + ((this.getNumericValue3() - 7.0F) * 0.5F));
        }
        if (0L > 0) {
            if (var28 != null) {
                if (mX <= ((this.getNumericValue() + 3.5F) + (this.getNumericValue3() - 7.0F))) {
                }
            }
            if (var28 != null) {
                if (var29 <= mX) {
                }
            }
        } else {
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
