package su.catlean.client.features.modules.utility.player;

import java.awt.Color;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1747;
import net.minecraft.class_2846;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_3965;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class AirPlaceModule extends Module {

    public static final AirPlaceModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl bypassSetting;
    private static final RangeVisibleSettingPropertyImpl2 rangeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 colorSetting;
    private static class_3965 minecraftRef;
    private static int countValue;

    private AirPlaceModule() {
        super("air-place", SubCategoriesKt.getPlayerUtilityCategory());
    }

    public boolean getBypass() {
        return ((Boolean) bypassSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private float getRange() {
        return ((Number) rangeSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private Color getColor() {
        return ((Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (countValue > 0) {
            int index = countValue;
            countValue = (index + -1);
        }
        index = SharedKt.getMc().method_1560().method_5745(this.getRange(), 0.0F, false);
        minecraftRef = ((class_3965) index);
        if (!(index instanceof class_3965) || !(SharedKt.getWorld().getBlockState(minecraftRef.method_17777()).getBlock().equals(Blocks.AIR))) {
            return;
        }
        boolean flag = SharedKt.getPlayer().method_6079().getItem() instanceof class_1747;
        if (this.getBypass()) {
            HandServiceComponent.K(Hand.field_5810, 0.0F, 0.0F);
            PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN)));
            SharedKt.getPlayer().method_2896(Hand.field_5808, Hand.field_5810, minecraftRef);
            Hand.field_5808.method_6104(Hand.field_5810);
            PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN)));
            Hand.field_5808.method_6104(Hand.field_5810);
        } else {
            SharedKt.getPlayer().method_2896(Hand.field_5808, Hand.field_5810, minecraftRef);
            Hand.field_5808.method_6104(Hand.field_5810);
        }
        if (!(NoDelayModule.INSTANCE.getBlocks())) {
            if (NoDelayModule.INSTANCE.getEnabled() && NoDelayModule.INSTANCE.getAll()) {
            } else {
            }
        }
        countValue = 4;
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (minecraftRef != null) {
            boolean flag = SharedKt.getPlayer().method_6047().getItem() instanceof class_1747;
            boolean flag2 = SharedKt.getPlayer().method_6079().getItem() instanceof class_1747;
            Box box = new Box(minecraftRef.method_17777());
            if (!(SharedKt.getWorld().getBlockState(minecraftRef.method_17777()).getBlock().equals(Blocks.AIR)) || !(flag)) {
                return;
            }
            TextShaderComponent2.checkCondition(box, INSTANCE.getColor());
            TextShaderComponent2.checkCondition(box, PolygonShaderComponent.INSTANCE.resolveColor(INSTANCE.getColor(), 1.0F));
        } else {
        }
    }

    static {
        KProperty[] items = new KProperty[3];
        INSTANCE = new AirPlaceModule();
        bypassSetting = VisibleRenderHelper.registerSetting(INSTANCE, "2b2t", true);
        rangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range", 5.0F, RangesKt.rangeTo(0.0F, 6.0F));
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill--color", new Color(100, 50, 255, 50));
    }

}
