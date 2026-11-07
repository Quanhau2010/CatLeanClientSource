package su.catlean.client.services.client;

import su.catlean.client.features.modules.movement.rage.BlinkModule;
import su.catlean.client.features.modules.movement.rage.ElytraTargetModule;
import su.catlean.client.services.render.TitleRenderHelper;

public class ServiceComponent71 implements Runnable {

    private final int countValue;
    private static String textValue;

    public ServiceComponent71(int $delay) {
        this.countValue = $delay;
    }

    public void run() {
        Thread.sleep(this.countValue);
        int var11 = 0;
        ElytraTargetModule.updateValue(0);
        TitleRenderHelper.INSTANCE.updateValue(1);
        BlinkModule.INSTANCE.updateValue2();
        ElytraTargetModule.updateValue2(0);
        if (var10 != null) {
            if (ElytraTargetModule.checkCondition()) {
                BlinkModule.INSTANCE.executeAction();
                ElytraTargetModule.updateValue2(1);
            }
            TitleRenderHelper.INSTANCE.updateValue(0);
        }
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
