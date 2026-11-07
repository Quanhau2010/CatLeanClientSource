package su.catlean.client.features.modules.utility.misc;

import net.minecraft.item.Item;

public enum AutoPotionBrewMode {

    SPEED,
    STRENGTH,
    FIRE_RESISTANCE,
    INVISIBILITY;

    private final Item minecraftRef;
    private final Item minecraftRef2;
    private final Item minecraftRef3;
    private static int countValue;

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
