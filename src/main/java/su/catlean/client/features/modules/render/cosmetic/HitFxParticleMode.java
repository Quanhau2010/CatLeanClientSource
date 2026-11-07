package su.catlean.client.features.modules.render.cosmetic;

import su.catlean.client.types.OptionMode6;

public enum HitFxParticleMode {

    STAR,
    FIRE_FLY,
    DOLLAR,
    HEART,
    SNOW_FLAKE,
    DROP,
    CLOUD;

    private final OptionMode6 optionMode6;

    public OptionMode6 getOptionMode6() {
        return this.optionMode6;
    }

}
