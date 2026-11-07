package su.catlean.client.features.modules.utility.misc;

import net.minecraft.item.Item;

public enum AutoPotionBrewMode {

    private final Item minecraftRef;
    private final Item minecraftRef2;
    private final Item minecraftRef3;
    public static final AutoPotionBrewMode SPEED;
    public static final AutoPotionBrewMode STRENGTH;
    public static final AutoPotionBrewMode FIRE_RESISTANCE;
    public static final AutoPotionBrewMode INVISIBILITY;
    private static int countValue;

    AutoPotionBrewMode(String arg0, int arg1, Item arg2, Item arg3, Item arg4) {
        super(arg0, arg1);
        this.minecraftRef = arg2;
        this.minecraftRef2 = arg3;
        this.minecraftRef3 = arg4;
    }

    public Item getMinecraftObject() {
        return this.minecraftRef;
    }

    public Item getMinecraftObject2() {
        return this.minecraftRef2;
    }

    public Item getMinecraftObject3() {
        return this.minecraftRef3;
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 107;
        return 0;
    }

}
