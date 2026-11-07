package su.catlean.client.services.client;

import su.catlean.client.features.modules.render.cosmetic.SwingAnimationsMode;

public class ServiceComponent34 {

    public static final int[] countValueArray;
    private static int[] countValueArray2;

    static {
        Object element = new int[SwingAnimationsMode.values()];
        element[SwingAnimationsMode.Default.ordinal()] = 1;
        element[SwingAnimationsMode.Bonk.ordinal()] = 2;
        element[SwingAnimationsMode.Rubber.ordinal()] = 3;
        element[SwingAnimationsMode.Flip.ordinal()] = 4;
        element[SwingAnimationsMode.Snap.ordinal()] = 5;
        element[SwingAnimationsMode.Hook.ordinal()] = 6;
        element[SwingAnimationsMode.Swipe.ordinal()] = 7;
        element[SwingAnimationsMode.Tap.ordinal()] = 8;
        element[SwingAnimationsMode.Inject.ordinal()] = 9;
        element[SwingAnimationsMode.Slap.ordinal()] = 10;
        element[SwingAnimationsMode.Akrien.ordinal()] = 11;
        countValueArray = element;
    }

    public static void updateValue(int[] arg0) {
        countValueArray2 = arg0;
    }

    public static int[] process() {
        return countValueArray2;
    }

}
