package su.catlean.client.services.client.module.category;

import su.catlean.client.features.modules.Module;

public class SubCategoriesKt {

    private static final SubCategory subCategory;
    private static final SubCategory subCategory2;
    private static final SubCategory subCategory3;
    private static final SubCategory subCategory4;
    private static final SubCategory subCategory5;
    private static final SubCategory subCategory6;
    private static final SubCategory subCategory7;
    private static final SubCategory subCategory8;
    private static final SubCategory subCategory9;
    private static final SubCategory subCategory10;
    private static final SubCategory subCategory11;
    private static Module[] moduleArray;

    public static SubCategory getProtectCategory() {
        return subCategory;
    }

    public static SubCategory getAttackCategory() {
        return subCategory2;
    }

    public static SubCategory getLegitCategory() {
        return subCategory3;
    }

    public static SubCategory getBasicMovementCategory() {
        return subCategory4;
    }

    public static SubCategory getRageMovementCategory() {
        return subCategory5;
    }

    public static SubCategory getCosmeticCategory() {
        return subCategory6;
    }

    public static SubCategory getEspCategory() {
        return subCategory7;
    }

    public static SubCategory getWorldRenderCategory() {
        return subCategory8;
    }

    public static SubCategory getEquipCategory() {
        return subCategory9;
    }

    public static SubCategory getPlayerUtilityCategory() {
        return subCategory10;
    }

    public static SubCategory getMiscUtilityCategory() {
        return subCategory11;
    }

    static {
        subCategory = new SubCategory("protect");
        subCategory2 = new SubCategory("attack");
        subCategory3 = new SubCategory("legit");
        subCategory4 = new SubCategory("basic");
        subCategory5 = new SubCategory("rage");
        subCategory6 = new SubCategory("cosmetic");
        subCategory7 = new SubCategory("esp");
        subCategory8 = new SubCategory("world");
        subCategory9 = new SubCategory("equip");
        subCategory10 = new SubCategory("player");
        subCategory11 = new SubCategory("misc");
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
