package su.catlean.client.features.modules.pvp.attack;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1661;
import net.minecraft.class_2824;
import net.minecraft.class_2824.class_5907;
import net.minecraft.class_2828.class_2829;
import net.minecraft.class_2828.class_5911;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class MaceKillerModule extends Module {

    public static final MaceKillerModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl heightSetting;
    private static int countValue;

    private MaceKillerModule() {
        super("mace-killer", SubCategoriesKt.getAttackCategory());
    }

    private int getHeight() {
        return (Number) heightSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void onSendPacket(SendPacket arg0) {
        Packet var22 = arg0.getPacket();
        Object var23 = var22;
        int var24 = 0;
        if (var23 instanceof class_2824 && CriticalsModule.INSTANCE.checkCondition((class_2824) var23)) {
            if (var25 instanceof EndCrystalEntity) {
            } else {
                if (var25 instanceof PlayerEntity && (PlayerEntity) var25.method_6039()) {
                    return;
                }
                StackServiceComponent2 var26 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition);
                if (var26.isActive()) {
                    if (SharedKt.getPlayer().method_31548().method_67532() != var26.getNumericValue()) {
                        var26.updateValue();
                        countValue = SharedKt.getPlayer().method_31548().method_67532();
                    }
                    Vec3d vec = INSTANCE.resolveMinecraftObject();
                    double var28 = INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).method_1022(vec);
                    if (INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).method_1022(vec) > 10.0D) {
                        double var30 = Math.ceil(Math.abs((var28 / 10.0D)));
                        int var31 = 0;
                        if (var31 < var30) {
                            int var32 = var31;
                            int var33 = 0;
                            PacketPacketHelper.handlePacket((Packet) new class_5911(0, SharedKt.getPlayer().field_5976));
                        }
                    }
                    PacketPacketHelper.handlePacket((Packet) new class_2829(vec.field_1352, vec.field_1351, vec.field_1350, 0, SharedKt.getPlayer().field_5976));
                    PacketPacketHelper.handlePacket((Packet) new class_2829(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), 0, SharedKt.getPlayer().field_5976));
                }
            }
        }
    }

    private void onAfterSendPacket(AfterSendPacket arg0) {
        Packet var10 = arg0.getPacket();
        Object var11 = var10;
        int var12 = 0;
        if (var11 instanceof class_2824 && CriticalsModule.INSTANCE.resolveMinecraftObject((class_2824) var11) == class_5907.field_29172 && countValue != -1) {
            ItemPacketHelper.INSTANCE.executeAction(countValue);
            countValue = -1;
        }
    }

    private Vec3d resolveMinecraftObject() {
        Vec3d vec = this.resolveMinecraftObject(SharedKt.getPlayer());
        int var15 = 2;
        int var16 = (this.getHeight() / 2);
        if (var15 <= var16) {
            if (ExplosionPosEntityHelper.resolveMinecraftObject(this.resolveMinecraftObject(SharedKt.getPlayer()), this.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(0.0D, (var15 * 1.8D), 0.0D)) == null) {
                vec = this.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(0.0D, ((var15 - 1) * 1.8D), 0.0D);
            } else {
                if (var15 != var16) {
                }
            }
        }
        return vec;
    }

    private static boolean checkCondition(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_49814);
    }

    static {
        KProperty[] var26 = new KProperty[1];
        INSTANCE = new MaceKillerModule();
        heightSetting = VisibleRenderHelper.registerSetting(INSTANCE, "height", 20, new IntRange(0, 200));
        countValue = -1;
    }

}
