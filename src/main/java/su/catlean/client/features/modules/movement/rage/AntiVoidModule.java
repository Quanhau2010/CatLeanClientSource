package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_2828.class_2829;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AntiVoidModule extends Module {

    public static final AntiVoidModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final VisibleVisibleSettingPropertyImpl rubberBandPacketSetting;

    private AntiVoidModule() {
        super("anti-void", SubCategoriesKt.getRageMovementCategory());
    }

    private AntiVoidMode getMode() {
        return ((AntiVoidMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setMode(AntiVoidMode value) {
        modeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private boolean getRubberBandPacket() {
        return ((Boolean) rubberBandPacketSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setRubberBandPacket(boolean value) {
        rubberBandPacketSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    public void onMoveEvent(MoveEvent e) {
        if (this.getMode() == AntiVoidMode.NCP) {
            e.setCancelled(true);
            e.setY(0.0D);
            PacketPacketHelper.handlePacket(((Packet) new class_2829(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), true, SharedKt.getPlayer().field_5976)));
        } else {
            ServiceComponent98.INSTANCE.updateValue2(0.2F);
        }
    }

    private boolean checkCondition() {
        if (SharedKt.getPlayer().isFallFlying()) {
            return false;
        }
        double offset = SharedKt.getPlayer().getY();
        if (-65 < offset) {
            if (!(SharedKt.getWorld().method_22347(BlockPos.method_49637(SharedKt.getPlayer().getX(), offset, SharedKt.getPlayer().getZ())))) {
                return false;
            }
        }
        return EventPacketHelper2.INSTANCE.getNumericValue() > 0.0D;
    }

    private static boolean isActive() {
        return INSTANCE.getMode() == AntiVoidMode.NCP;
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new AntiVoidModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", AntiVoidMode.TIMER);
        rubberBandPacketSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rubber-band", true, null, this::isActive);
    }

}
