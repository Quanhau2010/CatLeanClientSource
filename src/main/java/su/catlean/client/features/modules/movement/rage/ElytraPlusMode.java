package su.catlean.client.features.modules.movement.rage;

import su.catlean.api.contracts.Contract6;

public enum ElytraPlusMode {

    private final Contract6 contract6;
    public static final ElytraPlusMode FIRE_WORK;
    public static final ElytraPlusMode BOOST;
    public static final ElytraPlusMode CONTROL;
    public static final ElytraPlusMode INFINITE;
    public static final ElytraPlusMode PACKET;
    public static final ElytraPlusMode SILENT_FIRE_WORK;

    ElytraPlusMode(String arg0, int arg1, Contract6 arg2) {
        super(arg0, arg1);
        this.contract6 = arg2;
    }

    public Contract6 getContract6() {
        return this.contract6;
    }

}
