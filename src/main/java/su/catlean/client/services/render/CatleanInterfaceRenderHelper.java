package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1041;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EnabledServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent115;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.SubCategoriesServiceComponent;
import su.catlean.client.services.client.SubCategoryServiceComponent;
import su.catlean.client.services.client.VecServiceComponent;
import su.catlean.client.services.client.module.category.SubCategory;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class CatleanInterfaceRenderHelper extends Screen {

    public static final CatleanInterfaceRenderHelper INSTANCE;
    private static boolean enabledFlag;
    private static final List itemList;
    private static RenderHelper renderHelper;
    private static EasingServiceComponent easingServiceComponent;
    private static EasingServiceComponent easingServiceComponent2;
    private static boolean enabledFlag2;
    private static boolean enabledFlag3;
    private static int countValue;
    private static int countValue2;
    private static int countValue3;

    private CatleanInterfaceRenderHelper() {
        super(class_2561.method_30163("catlean-interface"));
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public RenderHelper getRenderHelper() {
        return renderHelper;
    }

    public void updateValue(RenderHelper value) {
        renderHelper = value;
    }

    public void method_25394(DrawContext context, int mX, int mY, float delta) {
        countValue = mX;
        countValue2 = mY;
        if (var9 != null) {
            if (renderHelper != null) {
                RenderHelper var10 = renderHelper;
                int var11 = 0;
                INSTANCE.render(context);
            } else {
            }
        }
    }

    public void render(DrawContext context) {
        if (!(enabledFlag3) && !(enabledFlag2)) {
            easingServiceComponent.updateValue2(0.0F);
            enabledFlag3 = 1;
        }
        if (SharedKt.getMc().world == null) {
            this.method_25420(context, countValue, countValue2, 1.0F);
        }
        easingServiceComponent.executeAction(0.1F);
        context.method_51448().pushMatrix();
        context.method_51448().translate((this.field_22789 / 2.0F), (this.field_22790 / 2.0F));
        if (enabledFlag3) {
            context.method_51448().scale((1.1F - easingServiceComponent.getNumericValue()));
        }
        if (enabledFlag2) {
            easingServiceComponent2.executeAction(1.0F);
            context.method_51448().scale((1.0F + easingServiceComponent2.getNumericValue()));
            PolygonShaderComponent.INSTANCE.updateValue((1.0F - easingServiceComponent2.getNumericValue()));
            if (easingServiceComponent2.getNumericValue() >= 0.999F) {
                enabledFlag2 = 0;
                this.method_25419();
            }
            easingServiceComponent2.updateValue2(0.0F);
        }
        context.method_51448().translate((this.field_22789 / 2.0F), (this.field_22790 / 2.0F));
        enabledFlag = 1;
        Iterable var19 = (Iterable) itemList;
        int var20 = 0;
        Iterator iterator = var19.iterator();
        while (iterator.hasNext()) {
            Object var22 = iterator.next();
            CategoryRenderHelper var23 = (CategoryRenderHelper) var22;
            int var24 = 0;
            var23.render(context, countValue, countValue2);
        }
        context.method_51448().popMatrix();
        BackRenderHelper.INSTANCE.render(context, countValue, countValue2);
        if (renderHelper != null) {
            renderHelper.render(context, countValue, countValue2);
        } else {
        }
        SFMServiceComponent.resolveFontRenderHelper().render(context, "Drag and drop the configuration here to add\nCTRL + SHIFT + LMB - Reset hovered module\nLMB - enable module\nRMB - open settings\nMMB - bind module\nALT - show binds", 5.0F, 5.0F, Color.WHITE);
        SFMServiceComponent.resolveFontRenderHelper().render(context, "CatLean public beta (free)", (SharedKt.getMc().method_22683().method_4486() - 85.0F), (SharedKt.getMc().method_22683().method_4502() - 10.0F), Color.WHITE);
        PolygonShaderComponent.INSTANCE.updateValue(1.0F);
    }

    public void method_25393() {
        this.method_25393();
        if (renderHelper != null) {
            return;
        }
        if (ServiceComponent13.checkCondition(263)) {
            Iterable var7 = (Iterable) itemList;
            int var8 = 0;
            Iterator iterator = var7.iterator();
            while (iterator.hasNext()) {
                Object var10 = iterator.next();
                CategoryRenderHelper var11 = (CategoryRenderHelper) var10;
                int var12 = 0;
                var11.updateValue4((var11.getNumericValue4() - 10));
            }
        }
        if (ServiceComponent13.checkCondition(262)) {
            var7 = (Iterable) itemList;
            var8 = 0;
            iterator = var7.iterator();
            while (iterator.hasNext()) {
                var10 = iterator.next();
                var11 = (CategoryRenderHelper) var10;
                var12 = 0;
                var11.updateValue4((var11.getNumericValue4() + 10));
            }
        }
        if (ServiceComponent13.checkCondition(265)) {
            var7 = (Iterable) itemList;
            var8 = 0;
            iterator = var7.iterator();
            while (iterator.hasNext()) {
                var10 = iterator.next();
                var11 = (CategoryRenderHelper) var10;
                var12 = 0;
                var11.updateValue5((var11.getNumericValue5() - 10));
            }
        }
        var7 = (Iterable) itemList;
        var8 = 0;
        iterator = var7.iterator();
        while (iterator.hasNext()) {
            var10 = iterator.next();
            var11 = (CategoryRenderHelper) var10;
            var12 = 0;
            var11.updateValue5((var11.getNumericValue5() + 10));
        }
    }

    private void executeAction(SubCategory arg0) {
        Iterable var9 = (Iterable) itemList;
        int var10 = 0;
        Iterator iterator = var9.iterator();
        if (iterator.hasNext()) {
            Object var12 = iterator.next();
            CategoryRenderHelper var13 = (CategoryRenderHelper) var12;
            int var14 = 0;
            if (var8 != null) {
                if (var13.getSubCategoriesServiceComponent().getList().contains(arg0)) {
                    Iterable var15 = (Iterable) var13.getArrayList();
                    int var16 = 0;
                    Iterator iterator2 = var15.iterator();
                    if (iterator2.hasNext()) {
                        Object var18 = iterator2.next();
                        SubCategoryServiceComponent var19 = (SubCategoryServiceComponent) var18;
                        int var20 = 0;
                        if (Intrinsics.areEqual(var19.getSubCategory(), arg0)) {
                            var13.updateValue(null);
                            StartupServiceComponent.INSTANCE.getVecServiceComponent2().updateValue();
                            if (var8 != null && var8 != null) {
                                if (!(Intrinsics.areEqual(var13.getSubCategoryServiceComponent().getSubCategory(), arg0))) {
                                    var13.executeAction();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void executeAction(Module module) {
        Iterable var5 = (Iterable) itemList;
        int var6 = 0;
        Iterator iterator = var5.iterator();
        if (iterator.hasNext()) {
            Object var8 = iterator.next();
            CategoryRenderHelper var9 = (CategoryRenderHelper) var8;
            int var10 = 0;
            Iterable var11 = (Iterable) var9.getArrayList2();
            int var12 = 0;
            Iterator iterator2 = var11.iterator();
            if (iterator2.hasNext()) {
                Object var14 = iterator2.next();
                CatComponentRenderHelper var15 = (CatComponentRenderHelper) var14;
                int var16 = 0;
                if (var4 != null) {
                    if (Intrinsics.areEqual(var15.getModule(), module)) {
                        var9.updateValue();
                    }
                }
            }
        }
    }

    public void executeAction2(Module module) {
        this.executeAction(module.getSubCategory());
        RunnableServiceComponent var6 = RunnableServiceComponent.INSTANCE;
        int var7 = 300;
        int var8 = 0;
        var6.getExecutorService().execute((Runnable) new ServiceComponent115(module));
    }

    public boolean method_25421() {
        return false;
    }

    public boolean method_25402(class_11909 click, boolean doubled) {
        double var12 = click.comp_4798();
        double var14 = click.comp_4799();
        int var16 = click.method_74245();
        if (renderHelper != null) {
            renderHelper.executeAction();
            return false;
        }
        if (!(BackRenderHelper.INSTANCE.checkCondition())) {
            Iterable var17 = (Iterable) itemList;
            int var18 = 0;
            Iterator iterator = var17.iterator();
            while (iterator.hasNext()) {
                Object var20 = iterator.next();
                CategoryRenderHelper var21 = (CategoryRenderHelper) var20;
                int var22 = 0;
                var21.executeAction();
            }
        }
        return this.method_25402(click, doubled);
    }

    public boolean method_25406(class_11909 click) {
        double var9 = click.comp_4798();
        double var11 = click.comp_4799();
        int var13 = click.method_74245();
        Iterable var14 = (Iterable) itemList;
        int var15 = 0;
        Iterator iterator = var14.iterator();
        while (iterator.hasNext()) {
            Object var17 = iterator.next();
            CategoryRenderHelper var18 = (CategoryRenderHelper) var17;
            int var19 = 0;
            var18.executeAction();
        }
        BackRenderHelper.INSTANCE.executeAction();
        if (this.method_25406(click) != null) {
        }
        return null;
    }

    public boolean method_25404(class_11908 input) {
        int var11 = input.comp_4795();
        int var12 = input.comp_4796();
        int var13 = input.comp_4797();
        if (renderHelper != null) {
            renderHelper.executeAction();
            return false;
        }
        Iterable var14 = (Iterable) itemList;
        int var15 = 0;
        Iterator iterator = var14.iterator();
        while (iterator.hasNext()) {
            Object var17 = iterator.next();
            CategoryRenderHelper var18 = (CategoryRenderHelper) var17;
            int var19 = 0;
            var18.executeAction();
        }
        BackRenderHelper.INSTANCE.executeAction();
        return this.method_25404(input);
    }

    public boolean method_25400(class_11905 input) {
        if (ArraysKt.firstOrNull(input.method_74226().toCharArray()) != null) {
        } else {
            ArraysKt.firstOrNull(input.method_74226().toCharArray()).charValue();
            return this.method_25400(input);
        }
        if (renderHelper != null) {
            renderHelper.executeAction();
            return this.method_25400(input);
        }
        Iterable var13 = (Iterable) itemList;
        int var14 = 0;
        Iterator iterator = var13.iterator();
        while (iterator.hasNext()) {
            Object var16 = iterator.next();
            CategoryRenderHelper var17 = (CategoryRenderHelper) var16;
            int var18 = 0;
            var17.executeAction();
        }
        BackRenderHelper.INSTANCE.executeAction();
        return this.method_25400(input);
    }

    public boolean method_25401(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (renderHelper != null) {
            renderHelper.executeAction(mouseX, mouseY, verticalAmount);
            return this.method_25401(mouseX, mouseY, horizontalAmount, verticalAmount);
        }
        if (BackRenderHelper.INSTANCE.checkCondition(mouseX, mouseY, verticalAmount)) {
            return this.method_25401(mouseX, mouseY, horizontalAmount, verticalAmount);
        }
        int var18 = 0;
        Iterable var19 = (Iterable) itemList;
        int var20 = 0;
        Iterator iterator = var19.iterator();
        while (iterator.hasNext()) {
            Object var22 = iterator.next();
            CategoryRenderHelper var23 = (CategoryRenderHelper) var22;
            int var24 = 0;
            if (var23.checkCondition(mouseX, mouseY, verticalAmount, horizontalAmount)) {
                var18 = 1;
            }
        }
        if (!(var18)) {
            var19 = (Iterable) itemList;
            var20 = 0;
            iterator = var19.iterator();
            while (iterator.hasNext()) {
                var22 = iterator.next();
                var23 = (CategoryRenderHelper) var22;
                var24 = 0;
                var23.executeAction(verticalAmount, horizontalAmount);
            }
        }
        return this.method_25401(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    public void method_25419() {
        Iterable var6 = (Iterable) itemList;
        int var7 = 0;
        Iterator iterator = var6.iterator();
        while (iterator.hasNext()) {
            Object var9 = iterator.next();
            CategoryRenderHelper var10 = (CategoryRenderHelper) var9;
            int var11 = 0;
            var10.updateValue();
        }
        enabledFlag = 0;
        enabledFlag2 = 1;
        enabledFlag3 = 0;
    }

    protected void method_57734(DrawContext context) {
    }

    public void method_25420(DrawContext context, float deltaTicks) {
    }

    public static List getList() {
        return itemList;
    }

    static {
        INSTANCE = new CatleanInterfaceRenderHelper();
        enabledFlag = 1;
        Iterable var40 = (Iterable) EnabledServiceComponent.INSTANCE.getArrayList();
        int var41 = 0;
        Object var42 = var40;
        Collection var43 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var44 = 0;
        int var45 = 0;
        Iterator iterator = var42.iterator();
        if (iterator.hasNext()) {
            Object var47 = iterator.next();
            int var48 = var45;
            if (var48 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SubCategoriesServiceComponent var49 = (SubCategoriesServiceComponent) var47;
            int var50 = var48;
            int var51 = 0;
            var52.add(new CategoryRenderHelper());
        }
        itemList = var43;
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK, var0[1]);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.IN_QUAD, var0[0]);
    }

    public static void updateValue(int arg0) {
        countValue3 = arg0;
    }

    public static int getNumericValue() {
        return countValue3;
    }

    public static int getNumericValue2() {
        return 121;
        return 0;
    }

}
