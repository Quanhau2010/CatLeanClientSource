package su.catlean.client.features.modules.pvp.attack;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1294;
import net.minecraft.class_2824;
import net.minecraft.class_2824.class_5907;
import net.minecraft.class_2848.class_2849;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class MoreKnockbackModule extends Module {

    public static final MoreKnockbackModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl inMoveSetting;
    private static final RangeVisibleSettingPropertyImpl chanceSetting;

    private MoreKnockbackModule() {
        super("more-knockback", SubCategoriesKt.getAttackCategory());
    }

    private boolean getInMove() {
        return ((Boolean) inMoveSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setInMove(boolean value) {
        inMoveSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    private int getChance() {
        return ((Number) chanceSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setChance(int value) {
        chanceSetting.setValue(this, DELEGATED_PROPERTIES[1], Integer.valueOf(value));
    }

    private void onSendPacket(SendPacket arg0) {
        Packet packet = arg0.getPacket();
        if (!(packet instanceof class_2824)) {
            return;
        }
        Entity entity = CriticalsModule.INSTANCE.resolveMinecraftObject(((class_2824) packet));
        if (EventPacketHelper2.INSTANCE.checkCondition()) {
        }
        if (SharedKt.getPlayer().method_5624()) {
            PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12985)));
        }
        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12981)));
        SharedKt.getPlayer().method_5728(true);
        SharedKt.getPlayer().field_3919 = true;
    }

    private boolean checkCondition(int arg0, short arg1) {
        if (!(SharedKt.getPlayer().method_31549().field_7479) && !(SharedKt.getPlayer().isFallFlying()) && !(SharedKt.getPlayer().method_6059(class_1294.field_5919)) && !(Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()))).getBlock(), Blocks.COBWEB)) && !(SharedKt.getPlayer().method_5771())) {
            if (SharedKt.getPlayer().method_5869()) {
            } else {
            }
        }
        int index = 0;
        if (arg0 > 0 && __UNDEF_KEY__ == null) {
            if (SharedKt.getPlayer().method_7261(0.5F) < 0.9F) {
                return false;
            }
        }
        if (!(index)) {
            if (arg1 <= 0 && __UNDEF_KEY__ == null) {
            }
            return SharedKt.getPlayer().field_6017 > 0.0D;
        }
        return false;
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new MoreKnockbackModule();
        inMoveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "allow-while-move", true);
        chanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "chance", 100, new IntRange(0, 100));
    }

}
