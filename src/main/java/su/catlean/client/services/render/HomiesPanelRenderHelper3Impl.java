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

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 120126245374909L);
        long var5 = (arg0 ^ 84193765869375L);
        itemList.clear();
        Iterable var7 = (Iterable) ProxyGuiElement.INSTANCE.getJsonServiceComponent2().resolveList();
        int var8 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            String var11 = (String) var10;
            int var12 = 0;
            itemList.add(new Type32TextureRenderHelper2Impl());
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        long var6 = (0L ^ 136208856317167L);
        long var8 = ((0L ^ 22135879901675L) >>> 48);
        long var9 = (((0L ^ 22135879901675L) << 16) >>> 48);
        long var10 = (((0L ^ 22135879901675L) << 32) >>> 32);
        long var11 = (0L ^ 27182768661316L);
        long var13 = (0L ^ 38443269427772L);
        long var15 = (0L ^ 0L);
        long var17 = (0L ^ 129382754651428L);
        long var19 = (0L ^ 55127167163707L);
        long var21 = (0L ^ 2881734234662L);
        long var23 = (0L ^ 55531218400380L);
        this.updateValue3(110.0F);
        this.render(context, mouseX, mouseY);
        float var41 = (this.getNumericValue() + 3.0F);
        float var42 = (this.getNumericValue() + 27.0F);
        int var43 = mouseX;
        if (var41 <= var43) {
        } else {
        }
        if (var43 <= var42) {
            var41 = (this.getNumericValue2() + 5.0F);
            var42 = (this.getNumericValue2() + 13.0F);
            var43 = mouseY;
            if (0L > 0L && var40 != null) {
                if (var41 <= var43) {
                }
            } else {
            }
            if (0L >= 0L) {
                if (var43 <= var42) {
                }
            }
        } else {
        }
        }
        enabledFlag = 0;
        if (0L > 0L) {
            easingServiceComponent.executeAction(factorValue);
        }
        if (this.getContract4() != null) {
        } else {
        }
        0.5F.executeAction(0.0F);
        if (enabledFlag) {
        } else {
        }
        if (enabledFlag) {
        } else {
        }
        int var26 = 14336;
        float var27 = 0.0F;
        float var28 = 0.0F;
        float var29 = 0.0F;
        Color var30 = NewThemeRenderHelper.INSTANCE.getColor6();
        Color var31 = NewThemeRenderHelper.INSTANCE.getColor4();
        float var32 = 1.0F;
        float var33 = 0.0F;
        float var34 = 0.1F;
        float var35 = 2.0F;
        float var36 = 2.5F;
        float var37 = 2.0F;
        float var38 = 8.0F;
        float var39 = 22.0F;
        StackShaderComponent2.executeAction((this.getNumericValue2() + 3.0F));
        SFMServiceComponent.resolveFontRenderHelper().render(context, "+", (this.getNumericValue() + 13.5F), (this.getNumericValue2() + 1.0F), Color.WHITE);
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78(this.getNumericValue(), (this.getNumericValue2() + 14.0F), ((this.getNumericValue() + this.getNumericValue3()) - 4.0F), ((this.getNumericValue2() + this.getNumericValue4()) - 3.0F)));
        var41 = 0.0F;
        var41 = (17.0F + easingServiceComponent.getNumericValue());
        var42 = (Iterable) itemList;
        var43 = 0;
        Iterator iterator = var42.iterator();
        while (iterator.hasNext()) {
            Object var45 = iterator.next();
            Type32TextureRenderHelper2Impl var46 = (Type32TextureRenderHelper2Impl) var45;
            int var47 = 0;
            var46.render(context, INSTANCE.getNumericValue(), (INSTANCE.getNumericValue2() + var41), mouseX, mouseY);
            var41 = (var41 + 29.0F);
            if (0L >= 0L && var40 != null) {
            }
            PolygonShaderComponent.INSTANCE.render(context);
        }
        if (this.getContract4() != null) {
            this.getContract4().render(context, ((this.getNumericValue() + (this.getNumericValue3() / 2.0F)) - 60.0F), ((this.getNumericValue2() + (this.getNumericValue4() / 2)) - 35.0F), mouseX, mouseY);
        } else {
        }
    }

    public void executeAction(float mX, float mY, int button) {
        int var7 = (((0L << 48) | ((0L << 32) >>> 16)) | ((0L << 48) >>> 48));
        long var9 = ((var7 ^ 0L) >>> 48);
        long var10 = (((var7 ^ 0L) << 16) >>> 32);
        long var11 = (((var7 ^ 0L) << 48) >>> 48);
        long var12 = (var7 ^ 38836403100948L);
        long var14 = (var7 ^ 89123186698759L);
        long var16 = (var7 ^ 20382250252594L);
        long var18 = (var7 ^ 20362906346987L);
        this.executeAction(mX, mY, button);
        if (this.getContract4() != null) {
        } else {
        }
        if (this.getContract4().checkCondition(mX, mY, button) == 1) {
            return;
        }
        if (enabledFlag) {
            SuggestionsRenderHelper2Impl.serviceComponent7.updateValue(null);
            this.updateValue(new ActionRenderHelper(this::resolveUnit));
            return;
        }
        int var21 = 0;
        Iterable var22 = (Iterable) itemList;
        int var23 = 0;
        Iterator iterator = var22.iterator();
        while (iterator.hasNext()) {
            Object var25 = iterator.next();
            Type32TextureRenderHelper2Impl var26 = (Type32TextureRenderHelper2Impl) var25;
            int var27 = 0;
            if (0L <= 0 || var20 == null || 0L > 0) {
                continue;
            }
        }
        if (var26.checkCondition(mX, mY, button)) {
            this.updateValue();
        }
        this.updateValue(null);
    }

    public void executeAction(double mouseX, double mouseY, double amount) {
        float var10 = this.getNumericValue();
        if (0L > 0L) {
            if (var9 != null) {
                if (mouseX <= (this.getNumericValue() + 76.0F)) {
                }
            }
            if (var9 != null) {
            }
        } else {
        }
        var10 = this.getNumericValue2();
        if (0L >= 0L) {
            if (var9 != null) {
                if (mouseY <= ((this.getNumericValue2() + this.getNumericValue4()) - 2.0F)) {
                }
            }
            if (var9 != null) {
            }
        } else {
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
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[0]);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[1]);
        INSTANCE.updateValue2(240.0F);
        INSTANCE.updateValue(290.0F);
        INSTANCE.updateValue3(110.0F);
        INSTANCE.updateValue();
    }

}
