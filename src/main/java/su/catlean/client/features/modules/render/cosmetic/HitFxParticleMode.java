package su.catlean.client.features.modules.render.cosmetic;

import su.catlean.client.types.OptionMode6;

public enum HitFxParticleMode {

    private final OptionMode6 optionMode6;
    public static final HitFxParticleMode STAR;
    public static final HitFxParticleMode FIRE_FLY;
    public static final HitFxParticleMode DOLLAR;
    public static final HitFxParticleMode HEART;
    public static final HitFxParticleMode SNOW_FLAKE;
    public static final HitFxParticleMode DROP;
    public static final HitFxParticleMode CLOUD;

    HitFxParticleMode(String arg0, int arg1, OptionMode6 arg2) {
        super(arg0, arg1);
        this.optionMode6 = arg2;
    }

    public OptionMode6 getOptionMode6() {
        return this.optionMode6;
    }

}
