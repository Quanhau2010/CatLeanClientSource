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
        ElytraTargetModule.updateValue(false);
        TitleRenderHelper.INSTANCE.updateValue(true);
        BlinkModule.INSTANCE.updateValue2();
        ElytraTargetModule.updateValue2(false);
        if (__UNDEF_KEY__ != null) {
            if (ElytraTargetModule.checkCondition()) {
                BlinkModule.INSTANCE.executeAction();
                ElytraTargetModule.updateValue2(true);
            }
            TitleRenderHelper.INSTANCE.updateValue(false);
        }
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
