package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import su.catlean.SharedKt;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EnabledServiceComponent;
import su.catlean.client.services.client.EventServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.SubCategoriesServiceComponent;
import su.catlean.client.services.client.SubCategoryServiceComponent;
import su.catlean.client.services.client.VecServiceComponent;
import su.catlean.client.services.client.module.category.SubCategory;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.tools.comparators.Comparator19;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.ui.clickgui.REDGuiElement;

public class CategoryRenderHelper {

    private final SubCategoriesServiceComponent subCategoriesServiceComponent;
    private int countValue;
    private int countValue2;
    private int countValue3;
    private int countValue4;
    private int countValue5;
    private float factorValue;
    private float factorValue2;
    private SubCategoryServiceComponent subCategoryServiceComponent;
    private SubCategoryServiceComponent subCategoryServiceComponent2;
    private int countValue6;
    private final ArrayList arrayList;
    private final ArrayList arrayList2;
    private final EasingServiceComponent easingServiceComponent;
    private final EasingServiceComponent easingServiceComponent2;
    private final EasingServiceComponent easingServiceComponent3;
    private CatComponentRenderHelper catComponentRenderHelper;
    private boolean enabledFlag;

    public CategoryRenderHelper(SubCategoriesServiceComponent category, int offset) {
        this.subCategoriesServiceComponent = category;
        this.countValue = offset;
        this.countValue2 = ((SharedKt.getMc().method_22683().method_4486() / 2.0F) + ((this.countValue - 2) * 125.0F));
        this.countValue3 = 100;
        this.countValue4 = this.countValue2;
        this.countValue5 = this.countValue3;
        this.factorValue = 120.0F;
        this.factorValue2 = 350.0F;
        this.countValue6 = -1;
        this.arrayList = new ArrayList();
        this.arrayList2 = new ArrayList();
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 300L);
        this.easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_EXPO, 400L);
        this.easingServiceComponent3 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, 200L);
        this.enabledFlag = 1;
        int var16 = 0;
        Iterable var17 = (Iterable) EnabledServiceComponent.INSTANCE.getArrayList2();
        int var18 = 0;
        var17 = (Iterable) CollectionsKt.sortedWith((Comparator) new Comparator19());
        var18 = 0;
        Iterator iterator = var17.iterator();
        if (iterator.hasNext()) {
            Object var20 = iterator.next();
            Module var21 = (Module) var20;
            int var22 = 0;
            if (0L >= 0) {
                if (0L >= 0L) {
                    if (this.subCategoriesServiceComponent.getList().contains(var21.getSubCategory())) {
                        this.arrayList2.add(new CatComponentRenderHelper(this, (this.countValue2 + 3.0F), ((this.countValue3 + 45.0F) + (18 * var16))));
                        var16 = (var16 + 1);
                    }
                }
            }
        }
        if (0L >= 0) {
            if (this.subCategoriesServiceComponent.getList().size() == 2) {
                this.arrayList.add(new SubCategoryServiceComponent(0.0F, 54.0F, (SubCategory) this.subCategoriesServiceComponent.getList().get(0)));
                this.arrayList.add(new SubCategoryServiceComponent(56.0F, 54.0F, (SubCategory) this.subCategoriesServiceComponent.getList().get(1)));
            }
        }
        if (0L >= 0) {
            if (this.subCategoriesServiceComponent.getList().size() == 3) {
                this.arrayList.add(new SubCategoryServiceComponent(0.0F, 35.5F, (SubCategory) this.subCategoriesServiceComponent.getList().get(0)));
                this.arrayList.add(new SubCategoryServiceComponent(37.5F, 35.5F, (SubCategory) this.subCategoriesServiceComponent.getList().get(1)));
                this.arrayList.add(new SubCategoryServiceComponent(74.5F, 35.5F, (SubCategory) this.subCategoriesServiceComponent.getList().get(2)));
            }
            if (0L >= 0) {
            }
            if (this.subCategoriesServiceComponent.getList().size() == 4) {
                this.arrayList.add(new SubCategoryServiceComponent(0.0F, 27.0F, (SubCategory) this.subCategoriesServiceComponent.getList().get(0)));
                this.arrayList.add(new SubCategoryServiceComponent(28.0F, 27.0F, (SubCategory) this.subCategoriesServiceComponent.getList().get(1)));
                this.arrayList.add(new SubCategoryServiceComponent(56.0F, 27.0F, (SubCategory) this.subCategoriesServiceComponent.getList().get(2)));
                this.arrayList.add(new SubCategoryServiceComponent(83.0F, 27.0F, (SubCategory) this.subCategoriesServiceComponent.getList().get(3)));
            }
            this.subCategoryServiceComponent = (SubCategoryServiceComponent) this.arrayList.get(0);
        }
        this.subCategoryServiceComponent2 = this.subCategoryServiceComponent;
    }

    public SubCategoriesServiceComponent getSubCategoriesServiceComponent() {
        return this.subCategoriesServiceComponent;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public void updateValue2(int value) {
        this.countValue2 = value;
    }

    public int getNumericValue3() {
        return this.countValue3;
    }

    public void updateValue3(int value) {
        this.countValue3 = value;
    }

    public int getNumericValue4() {
        return this.countValue4;
    }

    public void updateValue4(int value) {
        this.countValue4 = value;
    }

    public int getNumericValue5() {
        return this.countValue5;
    }

    public void updateValue5(int value) {
        this.countValue5 = value;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public void updateValue2(float value) {
        this.factorValue2 = value;
    }

    public SubCategoryServiceComponent getSubCategoryServiceComponent() {
        return this.subCategoryServiceComponent;
    }

    public void executeAction(SubCategoryServiceComponent value) {
        this.subCategoryServiceComponent = value;
    }

    public ArrayList getArrayList() {
        return this.arrayList;
    }

    public ArrayList getArrayList2() {
        return this.arrayList2;
    }

    public CatComponentRenderHelper getCatComponentRenderHelper() {
        return this.catComponentRenderHelper;
    }

    public void updateValue(CatComponentRenderHelper value) {
        this.catComponentRenderHelper = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        SFMServiceComponent.resolveFontRenderHelper3().updateValue(50.0F);
        SFMServiceComponent.resolveFontRenderHelper2().updateValue(50.0F);
        if (this.enabledFlag) {
            this.countValue2 = ((SharedKt.getMc().method_22683().method_4486() / 2) + ((this.countValue - 2) * 125));
            this.countValue3 = 100;
            this.countValue4 = this.countValue2;
            this.countValue5 = this.countValue3;
            this.enabledFlag = 0;
        }
        this.countValue2 = MathKt.roundToInt(this.computeValue(this.countValue2, this.countValue4, 13.0F));
        this.countValue3 = MathKt.roundToInt(this.computeValue(this.countValue3, this.countValue5, 13.0F));
        StackShaderComponent2.executeAction(context.method_51448(), this.countValue2, this.countValue3, this.factorValue, 25.0F, 7.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4().brighter(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 7.0F);
        StackShaderComponent2.executeAction(context.method_51448(), this.countValue2, (this.countValue3 + 24.0F), this.factorValue, (this.easingServiceComponent.getNumericValue() - 24.0F), 0.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 7.0F, 7.0F, 0.0F);
        String var44 = this.subCategoriesServiceComponent.getString();
        if ((CharSequence) var44.length() > 0) {
            char var45 = var44.charAt(0);
            Object var49 = context;
            FontRenderHelper var48 = SFMServiceComponent.resolveFontRenderHelper9();
            int var46 = 0;
            char var50 = Character.toUpperCase();
            var45 = var50;
            var46 = var44;
            int var47 = 1;
            var46 = var46.substring();
        } else {
        }
        int var38 = 10;
        int var39 = (this.countValue3 + 5.0F);
        int var40 = (this.countValue2 + (this.factorValue / 2.0F));
        Object var41 = var44;
        String var42 = new StringBuilder().append().append().toString();
        var49.render();
        var44 = new Color[1];
        var44[0] = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor6(), 0.3F);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), this.countValue2, (this.countValue3 + 41.0F), this.factorValue, 1.0F);
        this.easingServiceComponent2.executeAction(1.0F);
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78((this.countValue2 + 1.0F), this.countValue3, (this.countValue2 + this.factorValue), (this.countValue3 + this.easingServiceComponent.getNumericValue())));
        if (this.catComponentRenderHelper == null) {
            this.render(mouseX, mouseY, context, this.easingServiceComponent.isActive());
        }
        this.render(mouseX, mouseY, context);
        SFMServiceComponent.resolveFontRenderHelper3().executeAction();
        SFMServiceComponent.resolveFontRenderHelper2().executeAction();
        PolygonShaderComponent.INSTANCE.render(context);
    }

    private void render(int arg0, int arg1, DrawContext arg2) {
        this.easingServiceComponent3.executeAction(1.0F);
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper3(), arg2.method_51448(), this.catComponentRenderHelper.getModule().getString2(), ((this.countValue2 + 8.0F) + (40.0F * (1 - this.easingServiceComponent3.getNumericValue()))), (this.countValue3 + 27), NewThemeRenderHelper.INSTANCE.getColor7());
        float var22 = 0.0F;
        if (this.catComponentRenderHelper != null && this.catComponentRenderHelper.resolveList() != null) {
            Iterable var23 = (Iterable) this.catComponentRenderHelper.resolveList();
            int var24 = 0;
            Iterator iterator = var23.iterator();
            while (iterator.hasNext()) {
                Object var26 = iterator.next();
                SettingRenderHelper16 var27 = (SettingRenderHelper16) var26;
                int var28 = 0;
                if (var27.getVisibleSettingProperty().getSettingGroup() != null) {
                    if (var27.getVisibleSettingProperty().getSettingGroup().isActive() && var27.getVisibleSettingProperty().getSettingGroup().getOptionMode14() != OptionMode14.BOOLS) {
                    }
                    var27.updateValue((this.countValue2 + 5.0F));
                    var27.updateValue2(((this.countValue3 + 47.0F) + var22));
                    var27.render(arg2, arg0, arg1, this.easingServiceComponent2.getNumericValue());
                    var22 = (var22 + (var27.getNumericValue4() + 2.0F));
                }
            }
        } else {
        }
        MissingnoRenderHelper.executeAction(REDGuiElement.INSTANCE.getMissingnoRenderHelper(), (Matrix3x2f) arg2.method_51448(), ((this.countValue2 + this.factorValue) - 15.0D), (this.countValue3 + 26.0D), 0.0F, 0.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), this.easingServiceComponent3.getNumericValue()), null, 0.0F);
        this.easingServiceComponent.executeAction((49.0F + var22));
    }

    private void render(int arg0, int arg1, DrawContext arg2, boolean arg3) {
        this.easingServiceComponent3.executeAction(0.0F);
        Iterable var22 = (Iterable) this.arrayList;
        int var23 = 0;
        Iterator iterator = var22.iterator();
        while (iterator.hasNext()) {
            Object var25 = iterator.next();
            SubCategoryServiceComponent var26 = (SubCategoryServiceComponent) var25;
            int var27 = 0;
            if (Intrinsics.areEqual(this.subCategoryServiceComponent)) {
            } else {
            }
            1.0F.executeAction(0.0F);
            if (var26.getEasingServiceComponent().getNumericValue() > 0.001D) {
                StackShaderComponent2.executeAction(arg2.method_51448(), ((this.countValue2 + var26.getNumericValue()) + 5.0F), (this.countValue3 + 27.0F), var26.getNumericValue2(), 11.5F, 2.0F, (2.0F * var26.getEasingServiceComponent().getNumericValue()), (0.05F * var26.getEasingServiceComponent().getNumericValue()), 1.0F, NewThemeRenderHelper.INSTANCE.getColor4(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            }
            Color var28 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor8(), NewThemeRenderHelper.INSTANCE.getColor7(), var26.getEasingServiceComponent().getNumericValue());
            String var29 = var26.getSubCategory().getString();
            if ((CharSequence) var29.length() > 0) {
                char var30 = var29.charAt(0);
                Object var31 = arg2;
                FontRenderHelper var32 = SFMServiceComponent.resolveFontRenderHelper3();
                int var33 = 0;
                char var34 = Character.toUpperCase();
                var30 = var34;
                var33 = var29;
                int var35 = 1;
                var33 = var33.substring();
            } else {
            }
            var31.render(new StringBuilder().append().append().toString(), (((this.countValue2 + var26.getNumericValue()) + 5.0F) + (MathKt.roundToInt((var26.getNumericValue2() / 0.2F)) / 10.0F)), (this.countValue3 + 31.5F));
        }
        var22 = 0.0F;
        var23 = 0.0F;
        iterator = 0.0F;
        var25 = (Iterable) this.arrayList2;
        var26 = 0;
        var27 = var25;
        var28 = (Collection) new ArrayList();
        var29 = 0;
        var30 = var27.iterator();
        while (var30.hasNext()) {
            var31 = var30.next();
            var32 = (CatComponentRenderHelper) var31;
            var33 = 0;
            if (!(Intrinsics.areEqual(var32.getModule().getSubCategory(), this.subCategoryServiceComponent.getSubCategory()))) {
                if (Intrinsics.areEqual(var32.getModule().getSubCategory(), this.subCategoryServiceComponent2.getSubCategory()) && this.easingServiceComponent2.getNumericValue() < 1.0F) {
                }
            } else {
            }
            var28.add();
        }
        var25 = (Iterable) var28;
        var26 = 0;
        var27 = var25.iterator();
        while (var27.hasNext()) {
            var28 = var27.next();
            var29 = (CatComponentRenderHelper) var28;
            var30 = 0;
            if (Intrinsics.areEqual(var29.getModule().getSubCategory(), this.subCategoryServiceComponent.getSubCategory())) {
            } else {
            }
            var31 = (this.countValue2 + (this.countValue6 * (this.factorValue * this.easingServiceComponent2.getNumericValue())));
            var29.updateValue((var31 + 3.0F));
            if (Intrinsics.areEqual(var29.getModule().getSubCategory(), this.subCategoryServiceComponent.getSubCategory())) {
                var29.updateValue2(((this.countValue3 + 44.0F) + var22));
                var22 = (var22 + (var29.getNumericValue4() + 2.0F));
                if (var29.isActive()) {
                } else {
                }
                iterator = (31.0F + (17.0F + 2.0F));
            } else {
                var29.updateValue2(((this.countValue3 + 44.0F) + var23));
                var23 = (var23 + (var29.getNumericValue4() + 2.0F));
            }
            var29.render(arg2, arg0, arg1, this.easingServiceComponent2.getNumericValue(), arg3);
        }
        this.easingServiceComponent.executeAction((45.0F + iterator));
    }

    public void executeAction(SubCategoryServiceComponent selector) {
        this.subCategoryServiceComponent2 = this.subCategoryServiceComponent;
        this.subCategoryServiceComponent = selector;
        this.countValue6 = this.subCategoryServiceComponent2.getNumericValue() > this.subCategoryServiceComponent.getNumericValue();
        if (this.countValue6 == 1) {
            StartupServiceComponent.INSTANCE.getVecServiceComponent4().updateValue();
        } else {
            StartupServiceComponent.INSTANCE.getVecServiceComponent5().updateValue();
        }
        this.easingServiceComponent2.updateValue(0.0F);
        this.easingServiceComponent2.updateValue2(this.easingServiceComponent2.getNumericValue());
    }

    public void executeAction(double mouseX, double mouseY, int button) {
        if (this.catComponentRenderHelper == null) {
            Iterable var20 = (Iterable) this.arrayList;
            int var21 = 0;
            Iterator iterator = var20.iterator();
            while (iterator.hasNext()) {
                Object var23 = iterator.next();
                SubCategoryServiceComponent var24 = (SubCategoryServiceComponent) var23;
                int var25 = 0;
                float var26 = (var24.getNumericValue() + this.countValue2);
                if (mouseX <= ((var24.getNumericValue() + var24.getNumericValue2()) + this.countValue2)) {
                } else {
                }
                if (var26 <= mouseX) {
                    var26 = (this.countValue3 + 27);
                    int var27 = (this.countValue3 + 38);
                    double var28 = mouseY;
                    if (var26 <= var28) {
                    } else {
                    }
                    if (var28 <= var27 && !(Intrinsics.areEqual(this.subCategoryServiceComponent))) {
                        this.executeAction();
                    }
                }
            }
            var20 = (Iterable) this.arrayList2;
            var21 = 0;
            iterator = var20;
            var23 = (Collection) new ArrayList();
            var24 = 0;
            var25 = iterator.iterator();
            while (var25.hasNext()) {
                var26 = var25.next();
                var27 = (CatComponentRenderHelper) var26;
                var28 = 0;
                var23.add();
            }
            var20 = (Iterable) var23;
            var21 = 0;
            iterator = var20.iterator();
            while (iterator.hasNext()) {
                var23 = iterator.next();
                var24 = (CatComponentRenderHelper) var23;
                var25 = 0;
                var24.executeAction(mouseX, mouseY, button);
            }
        } else {
            var20 = (this.countValue2 + 3);
            var21 = ((this.countValue2 + this.factorValue) - 3);
            iterator = mouseX;
            if (var20 <= iterator) {
            } else {
            }
            if (iterator <= var21) {
                var20 = (this.countValue3 + 25);
                var21 = (this.countValue3 + 40);
                iterator = mouseY;
                if (var20 <= iterator) {
                } else {
                }
                if (iterator <= var21) {
                    this.catComponentRenderHelper = null;
                    StartupServiceComponent.INSTANCE.getVecServiceComponent2().updateValue();
                }
            } else {
                var20 = this.catComponentRenderHelper;
                if (var20 != null) {
                    var21 = var20.resolveList();
                    if (var21 != null) {
                        var23 = (Iterable) var21;
                        var24 = 0;
                        var25 = var23;
                        var26 = (Collection) new ArrayList();
                        var27 = 0;
                        var28 = var25.iterator();
                        while (var28.hasNext()) {
                            Object var29 = var28.next();
                            SettingRenderHelper16 var30 = (SettingRenderHelper16) var29;
                            int var31 = 0;
                            if ((Boolean) var30.getVisibleSettingProperty().getFunction0().invoke()) {
                                if (var30.getVisibleSettingProperty().getSettingGroup() != null) {
                                }
                                if (var30.getVisibleSettingProperty().getSettingGroup().isActive() && var30.getVisibleSettingProperty().getSettingGroup().getOptionMode14() != OptionMode14.BOOLS) {
                                }
                            } else {
                            }
                            var26.add();
                        }
                        var23 = (Iterable) var26;
                        var24 = 0;
                        var25 = var23.iterator();
                        while (var25.hasNext()) {
                            var26 = var25.next();
                            var27 = (SettingRenderHelper16) var26;
                            var28 = 0;
                            var27.setValue(mouseX, mouseY, button);
                        }
                    }
                } else {
                }
            }
        }
        }
        }
    }

    public void executeAction(double mouseX, double mouseY, int button) {
        if (this.catComponentRenderHelper != null && this.catComponentRenderHelper.resolveList() != null) {
            Iterable var11 = (Iterable) this.catComponentRenderHelper.resolveList();
            int var12 = 0;
            Iterator iterator = var11.iterator();
            while (iterator.hasNext()) {
                Object var14 = iterator.next();
                SettingRenderHelper16 var15 = (SettingRenderHelper16) var14;
                int var16 = 0;
                var15.setValue(mouseX, mouseY, button);
            }
        } else {
        }
    }

    public void executeAction(int key) {
        Iterable var8 = (Iterable) this.arrayList2;
        int var9 = 0;
        Iterator iterator = var8.iterator();
        if (iterator.hasNext()) {
            Object var11 = iterator.next();
            CatComponentRenderHelper var12 = (CatComponentRenderHelper) var11;
            int var13 = 0;
            var12.executeAction(key);
        }
    }

    public void executeAction(char char) {
        Iterable var10 = (Iterable) this.arrayList2;
        int var11 = 0;
        Iterator iterator = var10.iterator();
        if (iterator.hasNext()) {
            Object var13 = iterator.next();
            CatComponentRenderHelper var14 = (CatComponentRenderHelper) var13;
            int var15 = 0;
            var14.executeAction(char);
            if (0L >= 0) {
            }
        }
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount, double horizontalAmmount) {
        int var14 = 0;
        Iterable var15 = (Iterable) this.arrayList2;
        int var16 = 0;
        Iterator iterator = var15.iterator();
        while (iterator.hasNext()) {
            Object var18 = iterator.next();
            CatComponentRenderHelper var19 = (CatComponentRenderHelper) var18;
            int var20 = 0;
            if (var19.checkCondition(mouseX, mouseY, verticalAmount)) {
                var14 = 1;
            }
        }
        return var14;
    }

    public void executeAction(double verticalAmount, double horizontalAmmount) {
        this.countValue5 = (this.countValue5 + (verticalAmount * 10.0F));
        this.countValue4 = (this.countValue4 + (horizontalAmmount * 10.0F));
    }

    private float computeValue(float arg0, float arg1, float arg2) {
        if (EventServiceComponent.INSTANCE.getNumericValue() > 5) {
        } else {
        }
        float var6 = Math.clamp((0.016F * arg2), 0.0F, 1.0F);
        return (((1.0F - var6) * arg0) + (var6 * arg1));
    }

    public void updateValue() {
        if (this.catComponentRenderHelper != null && this.catComponentRenderHelper.resolveList() != null) {
            Iterable var6 = (Iterable) this.catComponentRenderHelper.resolveList();
            int var7 = 0;
            Iterator iterator = var6.iterator();
            while (iterator.hasNext()) {
                Object var9 = iterator.next();
                SettingRenderHelper16 var10 = (SettingRenderHelper16) var9;
                int var11 = 0;
                var10.setValue();
            }
        } else {
        }
        this.enabledFlag = 1;
    }

    private float computeValue(float arg0) {
        if (Float.isNaN(arg0)) {
        } else {
        }
        return (MathKt.roundToInt(((MathKt.roundToInt((arg0 * 100.0F)) / 100.0F) * 10.0F)) / 10.0F);
    }

}
