package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.cosmetic.TotemAnimationMode;

public class TotemAnimationModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object var13 = new int[TotemAnimationMode.values()];
        var13[TotemAnimationMode.FadeOut.ordinal()] = 1;
        var13[TotemAnimationMode.Size.ordinal()] = 2;
        var13[TotemAnimationMode.Otkisuli.ordinal()] = 3;
        var13[TotemAnimationMode.Insert.ordinal()] = 4;
        var13[TotemAnimationMode.Fall.ordinal()] = 5;
        var13[TotemAnimationMode.Rocket.ordinal()] = 4631064897982038022L;
        var13[TotemAnimationMode.Roll.ordinal()] = -766584149745074169L;
        var13[TotemAnimationMode.Off.ordinal()] = 4850365764907040776L;
        ENUM_SWITCH_MAP = var13;
    }

}
