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
        ProxyGuiElement.INSTANCE.updateValue();
        File[] items = ServiceComponent65.process();
        int index = 0;
        if (index < items) {
            Object element = items[index];
            element.mkdirs();
        }
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().updateValue();
        ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().updateValue();
        ConfigPanelRenderHelper3Impl.INSTANCE.executeAction();
    }

}
