package su.catlean.client.services.client;

import kotlin.TuplesKt;
import net.minecraft.class_500;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.client.PostTitleScreenInitEvent;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.MoveFixModule;
import su.catlean.client.features.modules.utility.misc.AssistantModule;
import su.catlean.client.features.modules.utility.misc.RPCModule;
import su.catlean.client.services.client.config.models.ModulesConfigRecord;
import su.catlean.client.ui.clickgui.CatleanDiscordConfirmGuiElement;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class MainServiceComponent implements Contract9 {

    public static final MainServiceComponent INSTANCE;
    private static final ServiceComponent10 serviceComponent10;
    private static boolean enabledFlag;
    private static Module[] moduleArray;

    private MainServiceComponent() {
    }

    private void onTickEvent(TickEvent arg0) {
        if (RPCModule.INSTANCE.getEnabled()) {
            AppIdXDGRUNTIMEDIRServiceComponentImpl var17 = AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE;
            Object var18 = var17;
            int var19 = 0;
            var18.setAppId(Long.valueOf(1324838037661945876L));
            if ((CharSequence) INSTANCE.resolveString().length() > 0) {
                var18.setDetails(INSTANCE.resolveString());
            }
            var18.setLargeImage(TuplesKt.to("main", "By Pan4ur & 06ED"));
            var18.setButton1(TuplesKt.to("Get", "https://catlean.su/"));
            var18.setState(INSTANCE.resolveString2());
        } else {
            AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.resolveUnit();
        }
    }

    private String resolveString(long arg0) {
        if (SharedKt.getMc().method_1562() != null && SharedKt.getNetwork().method_45734() != null) {
        } else {
            if (SharedKt.getMc().currentScreen instanceof class_500) {
            } else {
            }
        }
        return "";
    }

    private String resolveString2() {
        return "public beta test";
    }

    private void onPostTitleScreenInitEvent(PostTitleScreenInitEvent arg0) {
        if (!(enabledFlag) && !(ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().isActive())) {
            AssistantModule.INSTANCE.setEnabled(1);
            RPCModule.INSTANCE.setEnabled(1);
            MoveFixModule.INSTANCE.setEnabled(1);
            SharedKt.getMc().method_1507((Screen) new CatleanDiscordConfirmGuiElement());
            ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().updateValue(1);
        }
        enabledFlag = 1;
    }

    static {
        INSTANCE = new MainServiceComponent();
        serviceComponent10 = new ServiceComponent10();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
