package su.catlean.client.types;

import net.minecraft.class_2960;

public enum OptionMode11 {

    private final class_2960 minecraftRef;
    private final class_2960 minecraftRef2;
    public static final OptionMode11 CONTAINER;
    public static final OptionMode11 NORMAL;
    public static final OptionMode11 ABSORBING;

    OptionMode11(String arg0, int arg1, class_2960 arg2, class_2960 arg3) {
        super(arg0, arg1);
        this.minecraftRef = arg2;
        this.minecraftRef2 = arg3;
    }

    public class_2960 resolveMinecraftObject(boolean half) {
        return this.minecraftRef;
    }

}
