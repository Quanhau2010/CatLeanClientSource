package su.catlean.client.features.modules.movement.basic;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2767;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_3417;
import net.minecraft.class_6880;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;

public class InfiniteElytraModule extends Module {

    public static final InfiniteElytraModule INSTANCE;

    private InfiniteElytraModule() {
        super("infinite-elytra", SubCategoriesKt.getBasicMovementCategory());
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (!(SharedKt.getPlayer().isFallFlying())) {
            return;
        }
        Item[] items = new Item[6];
        items[0] = Items.NETHERITE_CHESTPLATE;
        items[1] = Items.DIAMOND_CHESTPLATE;
        items[2] = Items.IRON_CHESTPLATE;
        items[3] = Items.GOLDEN_CHESTPLATE;
        items[4] = Items.LEATHER_CHESTPLATE;
        items[5] = Items.CHAINMAIL_CHESTPLATE;
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        if (!(stackServiceComponent2.isActive())) {
            this.executeAction("no-armor-hotbar");
        }
        ItemPacketHelper.executeAction(stackServiceComponent2.getNumericValue());
        RunnableServiceComponent2.executeAction(0, 0, false, this::updateValue);
        EventPacketHelper2.INSTANCE.updateValue(0);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        arg0.cancel();
    }

    private static void executeAction() {
        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
        SharedKt.getPlayer().startFallFlying();
    }

    private static void updateValue(StackServiceComponent2 arg0) {
        Item[] items = new Item[1];
        items[0] = Items.ELYTRA;
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        if (!(arg0.isActive())) {
            INSTANCE.executeAction("no-elytra-hotbar");
        }
        ItemPacketHelper.executeAction(stackServiceComponent2.getNumericValue());
        RunnableServiceComponent2.executeAction(1, 0, false, this::executeAction);
    }

    static {
        INSTANCE = new InfiniteElytraModule();
    }

}
