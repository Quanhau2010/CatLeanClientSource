package su.catlean.client.features.modules;

public enum BlockPlacementSwitchMode {

    Silent,
    Normal,
    Alternative;

    private static String[] textValueArray;

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

}
