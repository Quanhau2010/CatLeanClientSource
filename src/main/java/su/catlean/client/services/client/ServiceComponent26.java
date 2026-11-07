package su.catlean.client.services.client;

import java.io.File;
import su.catlean.client.services.render.ConfigPanelRenderHelper3Impl;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class ServiceComponent26 implements Runnable {

    private final int countValue;

    public ServiceComponent26(int $delay) {
        this.countValue = $delay;
    }

    public void run() {
        Thread.sleep(this.countValue);
        int var10 = 0;
        ProxyGuiElement.INSTANCE.updateValue();
        File[] var11 = ServiceComponent65.process();
        int var12 = 0;
        int var13 = 0;
        Object var14 = var11;
        if (var13 < var14) {
            Object var15 = var11[var13];
            Object var16 = var15;
            int var17 = 0;
            var16.mkdirs();
        }
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().updateValue();
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().updateValue();
        ConfigPanelRenderHelper3Impl.INSTANCE.executeAction();
    }

}
