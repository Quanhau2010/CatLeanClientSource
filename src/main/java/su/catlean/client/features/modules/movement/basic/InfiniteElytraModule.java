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
        Item[] var17 = new Item[6];
        var17[0] = Items.NETHERITE_CHESTPLATE;
        var17[1] = Items.DIAMOND_CHESTPLATE;
        var17[2] = Items.IRON_CHESTPLATE;
        var17[3] = Items.GOLDEN_CHESTPLATE;
        var17[4] = Items.LEATHER_CHESTPLATE;
        var17[5] = Items.CHAINMAIL_CHESTPLATE;
        StackServiceComponent2 var16 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (!(var16.isActive())) {
            this.executeAction("no-armor-hotbar");
        }
        ItemPacketHelper.executeAction(var16.getNumericValue());
        RunnableServiceComponent2.executeAction(0, 0, 0, this::updateValue);
        EventPacketHelper2.INSTANCE.updateValue(0);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        arg0.cancel();
    }

    private static void executeAction() {
        PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982));
        SharedKt.getPlayer().startFallFlying();
    }

    private static void updateValue(StackServiceComponent2 arg0) {
        Item[] var14 = new Item[1];
        var14[0] = Items.ELYTRA;
        StackServiceComponent2 var13 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (!(arg0.isActive())) {
            INSTANCE.executeAction("no-elytra-hotbar");
        }
        ItemPacketHelper.executeAction(var13.getNumericValue());
        RunnableServiceComponent2.executeAction(1, 0, 0, this::executeAction);
    }

    static {
        INSTANCE = new InfiniteElytraModule();
    }

}
