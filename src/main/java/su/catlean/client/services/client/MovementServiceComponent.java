package su.catlean.client.services.client;

import kotlin.collections.CollectionsKt;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.client.module.category.SubCategory;

public class MovementServiceComponent {

    private static final SubCategoriesServiceComponent subCategoriesServiceComponent;
    private static final SubCategoriesServiceComponent subCategoriesServiceComponent2;
    private static final SubCategoriesServiceComponent subCategoriesServiceComponent3;
    private static final SubCategoriesServiceComponent subCategoriesServiceComponent4;

    public static SubCategoriesServiceComponent getSubCategoriesServiceComponent() {
        return subCategoriesServiceComponent;
    }

    public static SubCategoriesServiceComponent getSubCategoriesServiceComponent2() {
        return subCategoriesServiceComponent2;
    }

    public static SubCategoriesServiceComponent getSubCategoriesServiceComponent3() {
        return subCategoriesServiceComponent3;
    }

    public static SubCategoriesServiceComponent getSubCategoriesServiceComponent4() {
        return subCategoriesServiceComponent4;
    }

    static {
        SubCategory[] var13 = new SubCategory[3];
        var13[0] = SubCategoriesKt.getAttackCategory();
        var13[1] = SubCategoriesKt.getLegitCategory();
        var13[2] = SubCategoriesKt.getProtectCategory();
        subCategoriesServiceComponent = new SubCategoriesServiceComponent("pvp", CollectionsKt.arrayListOf());
        var13 = new SubCategory[2];
        var13[0] = SubCategoriesKt.getBasicMovementCategory();
        var13[1] = SubCategoriesKt.getRageMovementCategory();
        subCategoriesServiceComponent2 = new SubCategoriesServiceComponent("movement", CollectionsKt.arrayListOf());
        var13 = new SubCategory[2];
        var13[0] = SubCategoriesKt.getCosmeticCategory();
        var13[1] = SubCategoriesKt.getEspCategory();
        subCategoriesServiceComponent3 = new SubCategoriesServiceComponent("visual", CollectionsKt.arrayListOf());
        var13 = new SubCategory[4];
        var13[0] = SubCategoriesKt.getWorldRenderCategory();
        var13[1] = SubCategoriesKt.getEquipCategory();
        var13[2] = SubCategoriesKt.getPlayerUtilityCategory();
        var13[3] = SubCategoriesKt.getMiscUtilityCategory();
        subCategoriesServiceComponent4 = new SubCategoriesServiceComponent("utility", CollectionsKt.arrayListOf());
    }

}
