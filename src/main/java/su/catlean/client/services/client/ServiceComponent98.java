package su.catlean.client.services.client;

import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.client.TickFactorEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;

public class ServiceComponent98 implements Contract9 {

    public static final ServiceComponent98 INSTANCE;
    private static float factorValue;
    private static int[] countValueArray;

    private ServiceComponent98() {
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
    }

    public void updateValue2(float t) {
        factorValue = t;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        this.updateValue2(1.0F);
    }

    private void onTickFactorEvent(TickFactorEvent arg0) {
        if (factorValue == 1.0F) {
            return;
        }
        arg0.setFactor(factorValue);
        arg0.cancel();
    }

    static {
        INSTANCE = new ServiceComponent98();
        factorValue = 1.0F;
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
