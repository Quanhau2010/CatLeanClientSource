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
        SubCategory[] items = new SubCategory[3];
        items[0] = SubCategoriesKt.getAttackCategory();
        items[1] = SubCategoriesKt.getLegitCategory();
        items[2] = SubCategoriesKt.getProtectCategory();
        subCategoriesServiceComponent = new SubCategoriesServiceComponent("pvp", CollectionsKt.arrayListOf(items));
        items = new SubCategory[2];
        items[0] = SubCategoriesKt.getBasicMovementCategory();
        items[1] = SubCategoriesKt.getRageMovementCategory();
        subCategoriesServiceComponent2 = new SubCategoriesServiceComponent("movement", CollectionsKt.arrayListOf(items));
        items = new SubCategory[2];
        items[0] = SubCategoriesKt.getCosmeticCategory();
        items[1] = SubCategoriesKt.getEspCategory();
        subCategoriesServiceComponent3 = new SubCategoriesServiceComponent("visual", CollectionsKt.arrayListOf(items));
        items = new SubCategory[4];
        items[0] = SubCategoriesKt.getWorldRenderCategory();
        items[1] = SubCategoriesKt.getEquipCategory();
        items[2] = SubCategoriesKt.getPlayerUtilityCategory();
        items[3] = SubCategoriesKt.getMiscUtilityCategory();
        subCategoriesServiceComponent4 = new SubCategoriesServiceComponent("utility", CollectionsKt.arrayListOf(items));
    }

}
