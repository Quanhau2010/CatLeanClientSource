package su.catlean.client.features.modules.movement.basic;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.class_1922;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_2350.class_2353;
import net.minecraft.class_2382;
import net.minecraft.class_2386;
import net.minecraft.class_2663;
import net.minecraft.class_2769;
import net.minecraft.class_3609;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.EntityPushEvent;
import su.catlean.api.event.events.player.PushOutOfBlocksEvent;
import su.catlean.api.event.events.world.WaterPushEvent;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class NoPushModule extends Module {

    public static final NoPushModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl blocksSetting;
    private static final VisibleVisibleSettingPropertyImpl entitiesSetting;
    private static final VisibleVisibleSettingPropertyImpl waterSetting;
    private static final VisibleVisibleSettingPropertyImpl fishingHookSetting;

    private NoPushModule() {
        super("no-push", SubCategoriesKt.getBasicMovementCategory());
    }

    private boolean getBlocks() {
        return ((Boolean) blocksSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setBlocks(boolean value) {
        blocksSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    private boolean getEntities() {
        return ((Boolean) entitiesSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setEntities(boolean value) {
        entitiesSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private boolean getWater() {
        return ((Boolean) waterSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setWater(boolean value) {
        waterSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private boolean getFishingHook() {
        return ((Boolean) fishingHookSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setFishingHook(boolean value) {
        fishingHookSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        FishingBobberEntity entity = ((FishingBobberEntity) ((class_2663) arg0.getPacket()).method_11469(((World) SharedKt.getWorld())));
        arg0.cancel();
    }

    private void onWaterPushEvent(WaterPushEvent arg0) {
        if (!(this.getWater()) || SharedKt.getMc().world == null || SharedKt.getMc().player == null) {
            return;
        }
        class_2339 class2339 = new class_2339();
        Vec3d vec = Vec3d.ZERO;
        if (((Boolean) arg0.getState().method_11654(((class_2769) class_3609.field_15902)))) {
            Iterator iterator = class_2353.field_11062.iterator();
            while (iterator.hasNext()) {
                Direction direction = ((Direction) iterator.next());
                class2339.method_25505(((class_2382) arg0.getPos()), direction);
                if (!(this.checkCondition(arg0.getFluid(), ((BlockPos) class2339), direction)) && !(this.checkCondition(arg0.getFluid(), class2339.up(), direction))) {
                }
                vec = vec.method_1029().method_1031(0.0D, -6.0D, 0.0D);
            }
        }
        arg0.setVec(vec.method_1029());
        arg0.cancel();
    }

    private void onPushOutOfBlocksEvent(PushOutOfBlocksEvent arg0) {
        arg0.cancel();
    }

    private void onEntityPushEvent(EntityPushEvent arg0) {
        arg0.cancel();
    }

    private boolean checkCondition(class_3611 arg0, BlockPos arg1, Direction arg2) {
        BlockState state = SharedKt.getWorld().getBlockState(arg1);
        if (SharedKt.getWorld().method_8316(arg1).method_15772().method_15780(arg0)) {
        } else {
            if (arg2 == Direction.UP) {
            } else {
                if (state.getBlock() instanceof class_2386) {
                } else {
                }
            }
        }
        return state.method_26206(((class_1922) SharedKt.getWorld()), arg1, arg2);
    }

    static {
        KProperty[] items = new KProperty[4];
        INSTANCE = new NoPushModule();
        blocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks", true);
        entitiesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "entities", true);
        waterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "liquids", true);
        fishingHookSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fishing-hook", true);
    }

}
