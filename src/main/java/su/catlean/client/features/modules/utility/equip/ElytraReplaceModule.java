package su.catlean.client.features.modules.utility.equip;

import net.minecraft.class_9323;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.types.OptionMode16;

public class ElytraReplaceModule extends Module {

    public static final ElytraReplaceModule INSTANCE;

    private ElytraReplaceModule() {
        super("elytra-replace", SubCategoriesKt.getEquipCategory());
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        ItemStack stack = SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST);
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition);
        if (stackServiceComponent2.isActive()) {
            HandServiceComponent.e(stackServiceComponent2.getNumericValue(), 0, null, false);
            HandServiceComponent.e(6, 0, null, false);
            HandServiceComponent.e(stackServiceComponent2.getNumericValue(), 0, null, true);
            TitleRenderHelper.executeAction(INSTANCE.getString2(), MessageServiceComponent.Z(INSTANCE, "replaced", new Object[0], false), 2, OptionMode16.INFO);
            MessageServiceComponent.S(INSTANCE, MessageServiceComponent.Z(INSTANCE, "replaced", new Object[0], false), false);
        }
    }

    private static boolean checkCondition(ItemStack arg0) {
        if (arg0.getItem().method_57347().method_57832(class_9334.field_54197)) {
            return (arg0.method_7936() - arg0.method_7919()) > 2;
        }
        return false;
    }

    static {
        INSTANCE = new ElytraReplaceModule();
    }

}
