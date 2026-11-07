package su.catlean.client.services.client;

import su.catlean.client.features.modules.render.cosmetic.SwingAnimationsMode;

public class ServiceComponent34 {

    public static final int[] countValueArray;
    private static int[] countValueArray2;

    static {
        Object var13 = new int[SwingAnimationsMode.values()];
        var13[SwingAnimationsMode.Default.ordinal()] = 1;
        var13[SwingAnimationsMode.Bonk.ordinal()] = 2;
        var13[SwingAnimationsMode.Rubber.ordinal()] = 3;
        var13[SwingAnimationsMode.Flip.ordinal()] = 4;
        var13[SwingAnimationsMode.Snap.ordinal()] = 5;
        var13[SwingAnimationsMode.Hook.ordinal()] = 8490399918916108294L;
        var13[SwingAnimationsMode.Swipe.ordinal()] = -3747397723544879097L;
        var13[SwingAnimationsMode.Tap.ordinal()] = 1779522194750046216L;
        var13[SwingAnimationsMode.Inject.ordinal()] = 8167976668170813449L;
        var13[SwingAnimationsMode.Slap.ordinal()] = 5875065977284067338L;
        var13[SwingAnimationsMode.Akrien.ordinal()] = 6472835458207318027L;
        countValueArray = var13;
    }

    public static void updateValue(int[] arg0) {
        countValueArray2 = arg0;
    }

    public static int[] process() {
        return countValueArray2;
    }

}
