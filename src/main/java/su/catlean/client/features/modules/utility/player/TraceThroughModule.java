package su.catlean.client.features.modules.utility.player;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.class_10209;
import net.minecraft.class_239;
import net.minecraft.class_3695;
import net.minecraft.class_3959;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.client.InputEvent.Device;
import su.catlean.api.event.events.player.AttackEvent;
import su.catlean.api.event.events.player.UpdateCrosshairTarget;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class TraceThroughModule extends Module {

    public static final TraceThroughModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl attackEntitiesSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreEntitiesSetting;
    private static final VisibleVisibleSettingPropertyImpl openContainersSetting;

    private TraceThroughModule() {
        super("trace-through", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private boolean getAttackEntities() {
        return (Boolean) attackEntitiesSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getIgnoreEntities() {
        return (Boolean) ignoreEntitiesSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getOpenContainers() {
        return (Boolean) openContainersSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void onUpdateCrosshairTarget(UpdateCrosshairTarget arg0) {
        if (var15 == null) {
            class_10209.method_64146().method_15407();
            arg0.cancel();
            SharedKt.getMc().field_1765 = this.resolveMinecraftObject(SharedKt.getMc().method_1560(), SharedKt.getPlayer().method_55754(), TextShaderComponent2.INSTANCE.computeValue());
        }
        if (var15 == null) {
            if (SharedKt.getMc().field_1765 instanceof class_3966) {
            }
        } else {
        }
        (class_3966) SharedKt.getMc().field_1765.method_17782().field_1692 = null;
    }

    private class_239 resolveMinecraftObject(Entity arg0, double arg1, float arg2) {
        class_239 var8 = arg0.method_5745(arg1, arg2, 0);
        Vec3d vec = arg0.method_5836(arg2);
        Vec3d vec2 = var8.method_17784();
        if (var7 == null) {
            if (!(vec2.method_24802(vec, arg1))) {
            }
            Vec3d vec3 = var8.method_17784();
            Direction var12 = Direction.method_10142((vec3.field_1352 - vec.field_1352), (vec3.field_1351 - vec.field_1351), (vec3.field_1350 - vec.field_1350));
            return (class_239) class_3965.method_17778(vec3, BlockPos.ofFloored(vec3));
        }
        return var8;
    }

    public void onAttackEvent(AttackEvent e) {
        if (this.getAttackEntities() && SharedKt.getMc().field_1765 instanceof class_3965) {
            SharedKt.getInteractionManager().method_2918((PlayerEntity) SharedKt.getPlayer());
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            e.cancel();
        }
    }

    public void onInputEvent(InputEvent e) {
        if (SharedKt.getMc().field_1765 instanceof class_3965 && SharedKt.getWorld().getBlockState((class_3965) SharedKt.getMc().field_1765.method_17777()).method_31709()) {
            return;
        }
        int var25 = 1;
        double var26 = SharedKt.getPlayer().method_55754();
        BlockPos blockPos = BlockPos.ofFloored(SharedKt.getPlayer().getEyePos().method_1019(EventPacketHelper2.INSTANCE.resolveMinecraftObject(EventPacketHelper2.INSTANCE.computeValue2(), EventPacketHelper2.INSTANCE.computeValue()).method_1021()));
        if (SharedKt.getWorld().getBlockState(blockPos).method_31709()) {
            BlockState state = SharedKt.getWorld().getBlockState(blockPos);
            Object var22 = blockPos;
            class_3959 var23 = new class_3959(SharedKt.getPlayer().getEyePos(), blockPos.toCenterPos(), class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer());
            class_3965 var28 = VecPacketHelper.INSTANCE.resolveMinecraftObject(state);
            SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808);
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            return;
        }
    }

    static {
        KProperty[] var27 = new KProperty[3];
        INSTANCE = new TraceThroughModule();
        attackEntitiesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "attack-entities", 0, null, null, -7544630854568378356L);
        ignoreEntitiesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-entities", 1, null, null, -8495368362853924852L);
        openContainersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-containers", 0, null, null, -8495368362853924852L);
    }

}
