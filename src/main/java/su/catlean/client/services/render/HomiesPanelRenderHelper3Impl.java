package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.contracts.Contract4;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.JsonServiceComponent2;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent7;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.player.PlayerEntityHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class HomiesPanelRenderHelper3Impl extends RenderHelper3 {

    public static final HomiesPanelRenderHelper3Impl INSTANCE;
    private static final MissingnoRenderHelper missingnoRenderHelper;
    private static final List itemList;
    private static boolean enabledFlag;
    private static EasingServiceComponent easingServiceComponent;
    private static EasingServiceComponent easingServiceComponent2;
    private static float factorValue;

    private HomiesPanelRenderHelper3Impl() {
        super("homies-panel", 0.0F, 0.0F, 0.0F, 0.0F);
    }

    public MissingnoRenderHelper getMissingnoRenderHelper() {
        return missingnoRenderHelper;
    }

    public void updateValue() {
        itemList.clear();
        Iterable iterable = ((Iterable) ProxyGuiElement.INSTANCE.getJsonServiceComponent2().resolveList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            String text = ((String) element);
            itemList.add(new Type32TextureRenderHelper2Impl(text));
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        this.updateValue3(110.0F);
        this.render(context, mouseX, mouseY);
        float factor = (this.getNumericValue() + 3.0F);
        float factor2 = (this.getNumericValue() + 27.0F);
        int index = mouseX;
        if (factor <= index) {
        } else {
            if (index <= factor2) {
                factor = (this.getNumericValue2() + 5.0F);
                factor2 = (this.getNumericValue2() + 13.0F);
                index = mouseY;
                if (factor <= index) {
                } else {
                }
            } else {
                enabledFlag = index <= factor2;
            }
        }
        easingServiceComponent.executeAction(factorValue);
        if (this.getContract4() != null) {
        } else {
        }
        this.executeAction(0.0F);
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
        float factor13 = 22.0F;
        StackShaderComponent2.executeAction((this.getNumericValue2() + 3.0F), factor13, factor12, factor11, factor10, factor9, factor8, factor7, factor6, color2, color, factor5, factor4, factor3, index2);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "+", (this.getNumericValue() + 13.5F), (this.getNumericValue2() + 1.0F), Color.WHITE);
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(this.getNumericValue(), (this.getNumericValue2() + 14.0F), ((this.getNumericValue() + this.getNumericValue3()) - 4.0F), ((this.getNumericValue2() + this.getNumericValue4()) - 3.0F)));
        factor = 0.0F;
        factor = (17.0F + easingServiceComponent.getNumericValue());
        factor2 = ((Iterable) itemList);
        index = 0;
        Iterator iterator = factor2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Type32TextureRenderHelper2Impl type32TextureRenderHelper2Impl = ((Type32TextureRenderHelper2Impl) element);
            type32TextureRenderHelper2Impl.render(context, INSTANCE.getNumericValue(), (INSTANCE.getNumericValue2() + factor), mouseX, mouseY);
            factor = (factor + 29.0F);
        }
        PolygonShaderComponent.INSTANCE.render(context);
        if (this.getContract4() != null) {
            this.getContract4().render(context, ((this.getNumericValue() + (this.getNumericValue3() / 2.0F)) - 60.0F), ((this.getNumericValue2() + (this.getNumericValue4() / 2)) - 35.0F), mouseX, mouseY);
        } else {
        }
    }

    public void executeAction(float mX, float mY, int button) {
        this.executeAction(mX, mY, button);
        if (this.getContract4() != null) {
        } else {
            if (this.getContract4().checkCondition(mX, mY, button) == 1) {
                return;
            }
        }
        if (enabledFlag) {
            SuggestionsRenderHelper2Impl.serviceComponent7.updateValue(null);
            this.updateValue(new ActionRenderHelper(this::resolveUnit));
            return;
        }
        int index = 0;
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Type32TextureRenderHelper2Impl type32TextureRenderHelper2Impl = ((Type32TextureRenderHelper2Impl) element);
            if (__UNDEF_KEY__ <= 0 || __UNDEF_KEY__ == null || __UNDEF_KEY__ > 0) {
                continue;
            }
        }
        if (type32TextureRenderHelper2Impl.checkCondition(mX, mY, button)) {
            this.updateValue();
        }
        this.updateValue(null);
    }

    public void executeAction(double mouseX, double mouseY, double amount) {
        float factor = this.getNumericValue();
        if (__UNDEF_KEY__ > 0L) {
            if (__UNDEF_KEY__ != null) {
                if (mouseX <= (this.getNumericValue() + 76.0F)) {
                    if (__UNDEF_KEY__ != null) {
                    }
                } else {
                }
            }
        }
        factor = this.getNumericValue2();
        if (__UNDEF_KEY__ >= 0L) {
            if (__UNDEF_KEY__ != null) {
                if (mouseY <= ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)) {
                    if (__UNDEF_KEY__ != null) {
                    }
                } else {
                }
            }
        }
        factorValue = (factorValue + (amount * 7.0F));
        factorValue = Math.clamp(factorValue, (itemList.size() * -29.0F), 0.0F);
    }

    private static Unit resolveUnit(String arg0) {
        PlayerEntityHelper.INSTANCE.checkCondition(arg0);
        INSTANCE.updateValue();
        INSTANCE.updateValue(null);
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new HomiesPanelRenderHelper3Impl();
        missingnoRenderHelper = new MissingnoRenderHelper("panels/trash", 19, 19);
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        INSTANCE.updateValue2(240.0F);
        INSTANCE.updateValue(290.0F);
        INSTANCE.updateValue3(110.0F);
        INSTANCE.updateValue();
    }

}
