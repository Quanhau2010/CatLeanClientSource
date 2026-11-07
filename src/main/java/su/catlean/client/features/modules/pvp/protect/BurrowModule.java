package su.catlean.client.features.modules.pvp.protect;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.class_2828.class_2830;
import net.minecraft.class_2879;
import net.minecraft.class_2885;
import net.minecraft.class_3965;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class BurrowModule extends Module {

    public static final BurrowModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl onceSetting;
    private static BlockPos blockPos;
    private static final ServiceComponent10 serviceComponent10;

    private BurrowModule() {
        super("burrow", SubCategoriesKt.getProtectCategory());
    }

    private boolean getOnce() {
        return ((Boolean) onceSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public void updateValue() {
        blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        if (!(this.getOnce()) && !(Intrinsics.areEqual(blockPos, blockPos))) {
            this.updateValue2();
            return;
        }
        Block[] items = new Block[1];
        items[0] = Blocks.OBSIDIAN;
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        Block[] items2 = new Block[1];
        items2[0] = Blocks.ENDER_CHEST;
        items = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items2);
        if (!(stackServiceComponent2.isActive())) {
        } else {
        }
        items2 = stackServiceComponent2.getNumericValue();
        if (items2 != -1) {
            if (SharedKt.getMc().method_1542()) {
                this.updateValue2();
                return;
            }
        }
        float factor = SharedKt.getPlayer().method_36455();
        int index = (90 - factor);
        this.executeAction(0.42D, (factor + (index * 0.25F)));
        this.executeAction(0.75D, (factor + (index * 0.5F)));
        this.executeAction(1.01D, (factor + (index * 0.75F)));
        this.executeAction(1.16D, (factor + index));
        ItemPacketHelper.INSTANCE.executeAction(items2);
        PacketPacketHelper.executeAction(this::resolveMinecraftObject);
        PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
        ItemPacketHelper.INSTANCE.updateValue2();
        PacketPacketHelper.handlePacket(((Packet) new class_2830(SharedKt.getPlayer().getX(), (SharedKt.getPlayer().getY() + 1.0F), SharedKt.getPlayer().getZ(), SharedKt.getPlayer().method_36454(), 90.0F, true, SharedKt.getPlayer().field_5976)));
        serviceComponent10.executeAction();
        this.updateValue2();
    }

    private void executeAction(double arg0, float arg1) {
        PacketPacketHelper.handlePacket(((Packet) new class_2830(SharedKt.getPlayer().getX(), (SharedKt.getPlayer().getY() + arg0), SharedKt.getPlayer().getZ(), SharedKt.getPlayer().method_36454(), arg1, false, SharedKt.getPlayer().field_5976)));
    }

    private static Packet resolveMinecraftObject(BlockPos arg0, int arg1) {
        return ((Packet) new class_2885(Hand.field_5808, arg1));
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new BurrowModule();
        onceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "once", true);
        serviceComponent10 = new ServiceComponent10();
    }

}
