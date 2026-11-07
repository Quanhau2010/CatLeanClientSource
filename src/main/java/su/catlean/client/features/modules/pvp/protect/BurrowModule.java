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
        return (Boolean) onceSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public void updateValue(long arg0) {
        long var3 = ((arg0 ^ 103451004335712L) >>> 56);
        long var4 = (((arg0 ^ 103451004335712L) << 8) >>> 8);
        long var6 = (arg0 ^ 67464996320865L);
        blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        if (!(this.getOnce()) && !(Intrinsics.areEqual(blockPos, blockPos))) {
            this.updateValue2();
            return;
        }
        Block[] var33 = new Block[1];
        var33[0] = Blocks.OBSIDIAN;
        StackServiceComponent2 var32 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        Block[] var34 = new Block[1];
        var34[0] = Blocks.ENDER_CHEST;
        var33 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (!(var32.isActive())) {
        } else {
        }
        var34 = var32.getNumericValue();
        if (var34 != -1) {
            if (SharedKt.getMc().method_1542()) {
            }
            this.updateValue2();
            return;
        }
        float var35 = SharedKt.getPlayer().method_36455();
        int var36 = (90 - var35);
        this.executeAction(0.42D, (var35 + (var36 * 0.25F)));
        this.executeAction(0.75D, (var35 + (var36 * 0.5F)));
        this.executeAction(1.01D, (var35 + (var36 * 0.75F)));
        this.executeAction(1.16D, (var35 + var36));
        ItemPacketHelper.INSTANCE.executeAction();
        PacketPacketHelper.executeAction(this::resolveMinecraftObject);
        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
        ItemPacketHelper.INSTANCE.updateValue2();
        PacketPacketHelper.handlePacket((Packet) new class_2830(SharedKt.getPlayer().getX(), (SharedKt.getPlayer().getY() + 1.0F), SharedKt.getPlayer().getZ(), SharedKt.getPlayer().method_36454(), 90.0F, 1, SharedKt.getPlayer().field_5976));
        serviceComponent10.executeAction();
        this.updateValue2();
    }

    private void executeAction(double arg0, float arg1) {
        PacketPacketHelper.handlePacket((Packet) new class_2830(SharedKt.getPlayer().getX(), (SharedKt.getPlayer().getY() + arg0), SharedKt.getPlayer().getZ(), SharedKt.getPlayer().method_36454(), arg1, 0, SharedKt.getPlayer().field_5976));
    }

    private static Packet resolveMinecraftObject(BlockPos arg0, int arg1) {
        return (Packet) new class_2885(Hand.field_5808, new class_3965(arg0.toCenterPos().method_1031(0.0D, -0.5D, 0.0D), Direction.UP, arg0.down(), 0), arg1);
    }

    static {
        KProperty[] var26 = new KProperty[1];
        INSTANCE = new BurrowModule();
        onceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "once");
        serviceComponent10 = new ServiceComponent10();
    }

}
