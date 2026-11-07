package su.catlean.client.features.modules.movement.rage;

import su.catlean.api.contracts.Contract6;

public enum ElytraPlusMode {

    FIRE_WORK,
    BOOST,
    CONTROL,
    INFINITE,
    PACKET,
    SILENT_FIRE_WORK;

    private final Contract6 contract6;

    public Contract6 getContract6() {
        return this.contract6;
    }

}
