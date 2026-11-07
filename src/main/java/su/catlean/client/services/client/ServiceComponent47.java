package su.catlean.client.services.client;

import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AutoBasePlaceModule;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.services.player.ConfigStateEntityHelper;

public class ServiceComponent47 implements Runnable {

    private final int countValue;
    private final boolean enabledFlag;
    private static int[] countValueArray;

    public ServiceComponent47(int arg0, boolean arg1) {
        this.countValue = arg0;
        this.enabledFlag = arg1;
    }

    public void run() {
        Thread.sleep(this.countValue);
        AutoBasePlaceModule.updateValue(ConfigStateEntityHelper.resolveMinecraftObject(AutoCrystalModule.INSTANCE, AutoBasePlaceModule.checkCondition(), this.enabledFlag));
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
