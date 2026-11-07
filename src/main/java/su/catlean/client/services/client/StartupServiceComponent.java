package su.catlean.client.services.client;

import kotlin.random.Random;
import kotlin.random.Random.Default;
import net.minecraft.client.MinecraftClient;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.client.CloseSoundManagerEvent;
import su.catlean.api.event.events.client.PostTickEvent;
import su.catlean.client.features.modules.utility.misc.AssistantModule;
import su.catlean.client.services.client.config.models.ModulesConfigRecord;
import su.catlean.client.ui.clickgui.ProxyGuiElement;
import su.catlean.mixins.accessors.SoundEngineAccessor;
import su.catlean.mixins.accessors.SoundManagerAccessor;

public class StartupServiceComponent implements Contract9 {

    public static final StartupServiceComponent INSTANCE;
    private static boolean enabledFlag;
    private static final VecServiceComponent vecServiceComponent;
    private static final VecServiceComponent vecServiceComponent2;
    private static final VecServiceComponent vecServiceComponent3;
    private static final VecServiceComponent vecServiceComponent4;
    private static final VecServiceComponent vecServiceComponent5;
    private static final VecServiceComponent vecServiceComponent6;
    private static final VecServiceComponent vecServiceComponent7;
    private static final VecServiceComponent vecServiceComponent8;
    private static final VecServiceComponent vecServiceComponent9;
    private static final VecServiceComponent vecServiceComponent10;
    private static final VecServiceComponent vecServiceComponent11;
    private static final VecServiceComponent vecServiceComponent12;
    private static final VecServiceComponent vecServiceComponent13;
    private static final VecServiceComponent vecServiceComponent14;
    private static final VecServiceComponent vecServiceComponent15;
    private static final VecServiceComponent vecServiceComponent16;
    private static final VecServiceComponent vecServiceComponent17;
    private static final VecServiceComponent vecServiceComponent18;
    private static final VecServiceComponent vecServiceComponent19;
    private static final VecServiceComponent vecServiceComponent20;
    private static final VecServiceComponent vecServiceComponent21;
    private static final VecServiceComponent vecServiceComponent22;
    private static final VecServiceComponent vecServiceComponent23;
    private static final ServiceComponent10 serviceComponent10;
    private static String textValue;

    private StartupServiceComponent() {
    }

    public VecServiceComponent getVecServiceComponent() {
        return vecServiceComponent4;
    }

    public VecServiceComponent getVecServiceComponent2() {
        return vecServiceComponent5;
    }

    public VecServiceComponent getVecServiceComponent3() {
        return vecServiceComponent6;
    }

    public VecServiceComponent getVecServiceComponent4() {
        return vecServiceComponent7;
    }

    public VecServiceComponent getVecServiceComponent5() {
        return vecServiceComponent8;
    }

    public VecServiceComponent getVecServiceComponent6() {
        return vecServiceComponent9;
    }

    public VecServiceComponent getVecServiceComponent7() {
        return vecServiceComponent10;
    }

    public VecServiceComponent getVecServiceComponent8() {
        return vecServiceComponent11;
    }

    public VecServiceComponent getVecServiceComponent9() {
        return vecServiceComponent12;
    }

    public VecServiceComponent getVecServiceComponent10() {
        return vecServiceComponent13;
    }

    public VecServiceComponent getVecServiceComponent11() {
        return vecServiceComponent14;
    }

    public VecServiceComponent getVecServiceComponent12() {
        return vecServiceComponent15;
    }

    public VecServiceComponent getVecServiceComponent13() {
        return vecServiceComponent16;
    }

    public VecServiceComponent getVecServiceComponent14() {
        return vecServiceComponent17;
    }

    public VecServiceComponent getVecServiceComponent15() {
        return vecServiceComponent18;
    }

    public VecServiceComponent getVecServiceComponent16() {
        return vecServiceComponent19;
    }

    public VecServiceComponent getVecServiceComponent17() {
        return vecServiceComponent22;
    }

    public VecServiceComponent getVecServiceComponent18() {
        return vecServiceComponent23;
    }

    public void executeAction(boolean crystal) {
        if (!(AssistantModule.INSTANCE.getEnabled()) || !(serviceComponent10.checkCondition(timestampValue))) {
            return;
        }
        if (crystal && Random.Default.nextBoolean()) {
            vecServiceComponent21.updateValue();
        } else {
            vecServiceComponent20.updateValue();
        }
        serviceComponent10.executeAction();
    }

    private void onPostTickEvent(PostTickEvent arg0) {
        SoundEngineAccessor soundEngineAccessor = ((SoundEngineAccessor) ((SoundManagerAccessor) SharedKt.getMc().method_1483()).getSoundEngine());
        enabledFlag = 1;
        if (!(ProxyGuiElement.INSTANCE.getJsonServiceComponent4().resolveModulesConfigRecord().isActive())) {
            vecServiceComponent3.updateValue();
        } else {
            vecServiceComponent.updateValue();
        }
    }

    private void onCloseSoundManagerEvent(CloseSoundManagerEvent arg0) {
        vecServiceComponent2.updateValue();
        Thread.sleep(2000L);
    }

    static {
        INSTANCE = new StartupServiceComponent();
        vecServiceComponent = new VecServiceComponent("startup", 1.0F);
        vecServiceComponent2 = new VecServiceComponent("shutdown", 1.0F);
        vecServiceComponent3 = new VecServiceComponent("first-launch", 1.0F);
        vecServiceComponent4 = new VecServiceComponent("settings-open", 1.0F);
        vecServiceComponent5 = new VecServiceComponent("settings-close", 1.0F);
        vecServiceComponent6 = new VecServiceComponent("no-settings", 1.0F);
        vecServiceComponent7 = new VecServiceComponent("switch-right", 0.7F);
        vecServiceComponent8 = new VecServiceComponent("switch-left", 0.7F);
        vecServiceComponent9 = new VecServiceComponent("enable", 0.7F);
        vecServiceComponent10 = new VecServiceComponent("disable", 0.7F);
        vecServiceComponent11 = new VecServiceComponent("lag-back", 1.0F);
        vecServiceComponent12 = new VecServiceComponent("lag", 1.0F);
        vecServiceComponent13 = new VecServiceComponent("armor-alert", 1.0F);
        vecServiceComponent14 = new VecServiceComponent("chat-mention", 1.0F);
        vecServiceComponent15 = new VecServiceComponent("totem-pop", 1.0F);
        vecServiceComponent16 = new VecServiceComponent("range-in", 1.0F);
        vecServiceComponent17 = new VecServiceComponent("range-out", 1.0F);
        vecServiceComponent18 = new VecServiceComponent("config-load", 1.0F);
        vecServiceComponent19 = new VecServiceComponent("config-save", 1.0F);
        vecServiceComponent20 = new VecServiceComponent("kill", 1.0F);
        vecServiceComponent21 = new VecServiceComponent("crystal-kill", 1.0F);
        vecServiceComponent22 = new VecServiceComponent("found-stash", 1.0F);
        vecServiceComponent23 = new VecServiceComponent("lego-breaking", 1.0F);
        serviceComponent10 = new ServiceComponent10();
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
