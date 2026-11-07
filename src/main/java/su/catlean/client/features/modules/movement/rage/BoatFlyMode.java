package su.catlean.client.features.modules.movement.rage;

public enum BoatFlyMode {

    public static final BoatFlyMode Packet;
    public static final BoatFlyMode Motion;
    private static String textValue;

    BoatFlyMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
