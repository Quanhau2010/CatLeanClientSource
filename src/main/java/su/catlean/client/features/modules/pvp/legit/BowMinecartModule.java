package su.catlean.client.features.modules.pvp.legit;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_1667;
import net.minecraft.class_1893;
import net.minecraft.class_239.class_240;
import net.minecraft.class_2846;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_3959;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.WindHopSwitchMode;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.StackServiceComponent3;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class BowMinecartModule extends Module {

    public static final BowMinecartModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchModeSetting;
    private static final VisibleVisibleSettingPropertyImpl selfDamageCheckSetting;

    private BowMinecartModule() {
        super("bow-minecart", SubCategoriesKt.getLegitCategory());
    }

    private WindHopSwitchMode getSwitchMode() {
        return ((WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setSwitchMode(WindHopSwitchMode value) {
        switchModeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private boolean getSelfDamageCheck() {
        return ((Boolean) selfDamageCheckSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setSelfDamageCheck(boolean value) {
        selfDamageCheckSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private void onAfterSendPacket(AfterSendPacket arg0) {
        BlockPos blockPos = this.resolveMinecraftObject();
        double offset = SharedKt.getPlayer().method_55754();
        double offset2 = SharedKt.getPlayer().getEyePos().method_1022(blockPos.toCenterPos());
        if (2.299999952316284D <= offset2) {
        } else {
        }
        if (this.getSwitchMode() != WindHopSwitchMode.SILENT) {
            if (this.getSwitchMode() == WindHopSwitchMode.NORMAL) {
            } else {
            }
        }
        offset = 0;
        if (offset) {
            Item[] items = new Item[4];
            items[0] = Items.field_8129;
            items[1] = Items.field_8848;
            items[2] = Items.field_8211;
            items[3] = Items.field_8655;
        } else {
            items = new Item[4];
            items[0] = Items.field_8129;
            items[1] = Items.field_8848;
            items[2] = Items.field_8211;
            items[3] = Items.field_8655;
        }
        offset2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        if (offset) {
            Item[] items2 = new Item[1];
            items2[0] = Items.field_8069;
        } else {
            items2 = new Item[1];
            items2[0] = Items.field_8069;
        }
        items = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items2);
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(blockPos.up().toCenterPos()), 100, this::resolveUnit));
    }

    private BlockPos resolveMinecraftObject() {
        double offset = SharedKt.getPlayer().getX();
        double offset2 = (SharedKt.getPlayer().getEyePos().field_1351 - 0.1000000014901161D);
        double offset3 = SharedKt.getPlayer().getZ();
        double offset4 = Math.toRadians(SharedKt.getPlayer().method_36454());
        double offset5 = Math.toRadians(SharedKt.getPlayer().method_36455());
        double offset6 = (Math.sin(offset4) * Math.cos(offset5));
        double offset7 = Math.sin(offset5);
        double offset8 = (Math.cos(offset4) * Math.cos(offset5));
        int index = (SharedKt.getPlayer().method_6048() / 20.0F);
        index = (((index * index) + (index * 2.0F)) / 3.0F);
        if (index <= 1.0F) {
            if (index == 0.0F) {
                index = 1.0F;
            }
        }
        double offset9 = Math.sqrt((((offset6 * offset6) + (offset7 * offset7)) + (offset8 * offset8)));
        offset6 = (offset6 / offset9);
        offset7 = (offset7 / offset9);
        offset8 = (offset8 / offset9);
        int index2 = (index * 3);
        offset6 = (offset6 * index2);
        offset7 = (offset7 * index2);
        offset8 = (offset8 * index2);
        if (!(SharedKt.getPlayer().isOnGround())) {
            offset7 = (offset7 + SharedKt.getPlayer().method_18798().method_10214());
        }
        int index3 = 0;
        if (index3 < 300) {
            Vec3d vec = new Vec3d(offset, offset2, offset3);
            offset = (offset + offset6);
            offset2 = (offset2 + offset7);
            offset3 = (offset3 + offset8);
            offset6 = (offset6 * 0.99D);
            offset7 = (offset7 * 0.99D);
            offset8 = (offset8 * 0.99D);
            offset7 = (offset7 - 0.05000000074505806D);
            Vec3d vec2 = new Vec3d(offset, offset2, offset3);
            Iterator iterator = SharedKt.getWorld().method_18112().iterator();
            while (iterator.hasNext()) {
                Entity entity = iterator.next();
                if (entity instanceof class_1667 || entity.equals(SharedKt.getPlayer())) {
                    continue;
                }
                return null;
            }
            iterator = SharedKt.getWorld().method_17742(new class_3959(vec, vec2, class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer()));
            if (iterator.method_17783() == class_240.field_1332) {
                if (this.getSelfDamageCheck() && ExplosionPosEntityHelper.computeValue(iterator.method_17777().up().toCenterPos(), null, 0, false, null, false) > (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067())) {
                } else {
                    return iterator.method_17777();
                    if (offset2 > -65.0D) {
                    }
                }
            }
        }
        return null;
    }

    public boolean checkCondition(long arg0) {
        if (arg0 >= 0L) {
            if (!(__UNDEF_KEY__)) {
            }
        }
        return StackServiceComponent3.checkCondition(SharedKt.getPlayer().method_6047(), class_1893.field_9126);
    }

    private static Unit resolveUnit(BlockPos arg0) {
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, new class_3965(Direction.UP, arg0, false));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(BlockPos arg0) {
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, new class_3965(Direction.UP, arg0.up(), false));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(StackServiceComponent2 arg0, BlockPos arg1) {
        ItemPacketHelper.INSTANCE.executeAction(arg0.getNumericValue(), INSTANCE.getSwitchMode(), this::resolveUnit);
        ItemPacketHelper.INSTANCE.checkCondition(Items.field_8069, INSTANCE.getSwitchMode(), this::resolveUnit2);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new BowMinecartModule();
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        selfDamageCheckSetting = VisibleRenderHelper.registerSetting(INSTANCE, "check-self-damage", false);
    }

}
