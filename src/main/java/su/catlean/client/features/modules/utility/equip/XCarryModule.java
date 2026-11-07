package su.catlean.client.features.modules.utility.equip;

import net.minecraft.class_2815;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.GuiMoveClickBypassMode;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.services.client.module.category.SubCategoriesKt;

public class XCarryModule extends Module {

    public static final XCarryModule INSTANCE;

    private XCarryModule() {
        super("x-carry", SubCategoriesKt.getEquipCategory());
    }

    private void onSendPacket(SendPacket arg0) {
        if (GuiMoveModule.INSTANCE.getEnabled() && GuiMoveModule.INSTANCE.getClickBypass() != GuiMoveClickBypassMode.NONE) {
            this.executeAction("not-compatible");
            return;
        }
        arg0.cancel();
    }

    static {
        INSTANCE = new XCarryModule();
    }

}
