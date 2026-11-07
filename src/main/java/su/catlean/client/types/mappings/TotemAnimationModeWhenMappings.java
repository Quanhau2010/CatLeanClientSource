package su.catlean.client.types.mappings;

import su.catlean.client.features.modules.render.cosmetic.TotemAnimationMode;

public class TotemAnimationModeWhenMappings {

    public static final int[] ENUM_SWITCH_MAP;

    static {
        Object element = new int[TotemAnimationMode.values()];
        element[TotemAnimationMode.FadeOut.ordinal()] = 1;
        element[TotemAnimationMode.Size.ordinal()] = 2;
        element[TotemAnimationMode.Otkisuli.ordinal()] = 3;
        element[TotemAnimationMode.Insert.ordinal()] = 4;
        element[TotemAnimationMode.Fall.ordinal()] = 5;
        element[TotemAnimationMode.Rocket.ordinal()] = 6;
        element[TotemAnimationMode.Roll.ordinal()] = 7;
        element[TotemAnimationMode.Off.ordinal()] = 8;
        ENUM_SWITCH_MAP = element;
    }

}
