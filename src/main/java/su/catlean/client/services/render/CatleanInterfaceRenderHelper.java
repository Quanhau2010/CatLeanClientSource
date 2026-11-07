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
        if (__UNDEF_KEY__ != null) {
            if (renderHelper != null) {
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
                easingServiceComponent2.updateValue2(0.0F);
            }
        }
        context.method_51448().translate((this.field_22789 / 2.0F), (this.field_22790 / 2.0F));
        enabledFlag = 1;
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CategoryRenderHelper categoryRenderHelper = ((CategoryRenderHelper) element);
            categoryRenderHelper.render(context, countValue, countValue2);
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
            Iterable iterable = ((Iterable) itemList);
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                CategoryRenderHelper categoryRenderHelper = ((CategoryRenderHelper) element);
                categoryRenderHelper.updateValue4((categoryRenderHelper.getNumericValue4() - 10));
            }
        }
        if (ServiceComponent13.checkCondition(262)) {
            iterable = ((Iterable) itemList);
            iterator = iterable.iterator();
            while (iterator.hasNext()) {
                element = iterator.next();
                categoryRenderHelper = ((CategoryRenderHelper) element);
                categoryRenderHelper.updateValue4((categoryRenderHelper.getNumericValue4() + 10));
            }
        }
        if (ServiceComponent13.checkCondition(265)) {
            iterable = ((Iterable) itemList);
            iterator = iterable.iterator();
            while (iterator.hasNext()) {
                element = iterator.next();
                categoryRenderHelper = ((CategoryRenderHelper) element);
                categoryRenderHelper.updateValue5((categoryRenderHelper.getNumericValue5() - 10));
            }
        }
        iterable = ((Iterable) itemList);
        iterator = iterable.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            categoryRenderHelper = ((CategoryRenderHelper) element);
            categoryRenderHelper.updateValue5((categoryRenderHelper.getNumericValue5() + 10));
        }
    }

    private void executeAction(SubCategory arg0) {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CategoryRenderHelper categoryRenderHelper = ((CategoryRenderHelper) element);
            if (__UNDEF_KEY__ != null) {
                if (categoryRenderHelper.getSubCategoriesServiceComponent().getList().contains(arg0)) {
                    Iterable iterable2 = ((Iterable) categoryRenderHelper.getArrayList());
                    Iterator iterator2 = iterable2.iterator();
                    while (iterator2.hasNext()) {
                        Object element2 = iterator2.next();
                        SubCategoryServiceComponent subCategoryServiceComponent = ((SubCategoryServiceComponent) element2);
                        if (Intrinsics.areEqual(subCategoryServiceComponent.getSubCategory(), arg0)) {
                            categoryRenderHelper.updateValue(null);
                            StartupServiceComponent.INSTANCE.getVecServiceComponent2().updateValue();
                            if (__UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
                                if (!(Intrinsics.areEqual(categoryRenderHelper.getSubCategoryServiceComponent().getSubCategory(), arg0))) {
                                    categoryRenderHelper.executeAction(subCategoryServiceComponent);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void executeAction(Module module) {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CategoryRenderHelper categoryRenderHelper = ((CategoryRenderHelper) element);
            Iterable iterable2 = ((Iterable) categoryRenderHelper.getArrayList2());
            Iterator iterator2 = iterable2.iterator();
            while (iterator2.hasNext()) {
                Object element2 = iterator2.next();
                CatComponentRenderHelper catComponentRenderHelper = ((CatComponentRenderHelper) element2);
                if (__UNDEF_KEY__ != null) {
                    if (Intrinsics.areEqual(catComponentRenderHelper.getModule(), module)) {
                        categoryRenderHelper.updateValue(catComponentRenderHelper);
                    }
                }
            }
        }
    }

    public void executeAction2(Module module) {
        this.executeAction(module.getSubCategory());
        RunnableServiceComponent runnableServiceComponent = RunnableServiceComponent.INSTANCE;
        int index = 300;
        runnableServiceComponent.getExecutorService().execute(((Runnable) new ServiceComponent115(index, module)));
    }

    public boolean method_25421() {
        return false;
    }

    public boolean method_25402(class_11909 click, boolean doubled) {
        double offset = click.comp_4798();
        double offset2 = click.comp_4799();
        int index = click.method_74245();
        if (renderHelper != null) {
            renderHelper.executeAction(offset, offset2, index);
            return false;
        }
        if (!(BackRenderHelper.INSTANCE.checkCondition(offset, offset2, index))) {
            Iterable iterable = ((Iterable) itemList);
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                CategoryRenderHelper categoryRenderHelper = ((CategoryRenderHelper) element);
                categoryRenderHelper.executeAction(offset, offset2, index);
            }
        }
        return this.method_25402(click, doubled);
    }

    public boolean method_25406(class_11909 click) {
        double offset = click.comp_4798();
        double offset2 = click.comp_4799();
        int index = click.method_74245();
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CategoryRenderHelper categoryRenderHelper = ((CategoryRenderHelper) element);
            categoryRenderHelper.executeAction(offset, offset2, index);
        }
        BackRenderHelper.INSTANCE.executeAction(offset, offset2, index);
        if (this.method_25406(click) != null) {
        }
        return null;
    }

    public boolean method_25404(class_11908 input) {
        int index = input.comp_4795();
        int index2 = input.comp_4796();
        int index3 = input.comp_4797();
        if (renderHelper != null) {
            renderHelper.executeAction(index);
            return false;
        }
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CategoryRenderHelper categoryRenderHelper = ((CategoryRenderHelper) element);
            categoryRenderHelper.executeAction(index);
        }
        BackRenderHelper.INSTANCE.executeAction(index, index2, index3);
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
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CategoryRenderHelper categoryRenderHelper = ((CategoryRenderHelper) element);
            categoryRenderHelper.executeAction();
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
        int index = 0;
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CategoryRenderHelper categoryRenderHelper = ((CategoryRenderHelper) element);
            if (categoryRenderHelper.checkCondition(mouseX, mouseY, verticalAmount, horizontalAmount)) {
                index = 1;
            }
        }
        if (!(index)) {
            iterable = ((Iterable) itemList);
            iterator = iterable.iterator();
            while (iterator.hasNext()) {
                element = iterator.next();
                categoryRenderHelper = ((CategoryRenderHelper) element);
                categoryRenderHelper.executeAction(verticalAmount, horizontalAmount);
            }
        }
        return this.method_25401(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    public void method_25419() {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CategoryRenderHelper categoryRenderHelper = ((CategoryRenderHelper) element);
            categoryRenderHelper.updateValue();
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
        Iterable iterable = ((Iterable) EnabledServiceComponent.INSTANCE.getArrayList());
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SubCategoriesServiceComponent subCategoriesServiceComponent = ((SubCategoriesServiceComponent) element);
            this.add(new CategoryRenderHelper(subCategoriesServiceComponent, index));
        }
        itemList = collection;
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.IN_QUAD);
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
