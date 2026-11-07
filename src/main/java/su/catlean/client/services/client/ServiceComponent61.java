package su.catlean.client.services.client;

import su.catlean.client.features.modules.Module;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class ServiceComponent61 extends Thread {

    private static boolean enabledFlag;

    public ServiceComponent61() {
        super();
    }

    public void run() {
        ProxyGuiElement.INSTANCE.updateValue();
        AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.resolveUnit();
        this.run();
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
