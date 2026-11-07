package su.catlean.client.services.player;

import com.mojang.authlib.GameProfile;
import java.util.List;
import net.minecraft.entity.player.PlayerEntity;
import su.catlean.api.contracts.Contract9;
import su.catlean.client.services.client.JsonServiceComponent2;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class PlayerEntityHelper implements Contract9 {

    public static final PlayerEntityHelper INSTANCE;
    private static boolean enabledFlag;

    private PlayerEntityHelper() {
    }

    public boolean checkCondition(String name) {
        return ProxyGuiElement.INSTANCE.getJsonServiceComponent2().resolveList().contains(name);
    }

    public boolean checkCondition(PlayerEntity player) {
        String text = player.method_7334().name();
        return this.checkCondition(text);
    }

    public boolean checkCondition(String name) {
        return ProxyGuiElement.INSTANCE.getJsonServiceComponent2().resolveList().add(name);
    }

    public boolean checkCondition(PlayerEntity player) {
        return this.checkCondition2(player.method_7334().name());
    }

    public boolean checkCondition2(String name) {
        return ProxyGuiElement.INSTANCE.getJsonServiceComponent2().resolveList().remove(name);
    }

    public void updateValue() {
        ProxyGuiElement.INSTANCE.getJsonServiceComponent2().resolveList().clear();
    }

    static {
        INSTANCE = new PlayerEntityHelper();
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
