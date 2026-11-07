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
        return (WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setSwitchMode(WindHopSwitchMode value) {
        switchModeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private boolean getSelfDamageCheck() {
        return (Boolean) selfDamageCheckSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setSelfDamageCheck(boolean value) {
        selfDamageCheckSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private void onAfterSendPacket(AfterSendPacket arg0) {
        BlockPos blockPos = this.resolveMinecraftObject();
        double var26 = SharedKt.getPlayer().method_55754();
        double var27 = SharedKt.getPlayer().getEyePos().method_1022(blockPos.toCenterPos());
        if (2.299999952316284D <= var27) {
        } else {
        }
        if (this.getSwitchMode() != WindHopSwitchMode.SILENT) {
            if (this.getSwitchMode() == WindHopSwitchMode.NORMAL) {
            }
        } else {
        }
        var26 = 0;
        if (var26) {
            Item[] var28 = new Item[4];
            var28[0] = Items.field_8129;
            var28[1] = Items.field_8848;
            var28[2] = Items.field_8211;
            var28[3] = Items.field_8655;
        } else {
            var28 = new Item[4];
            var28[0] = Items.field_8129;
            var28[1] = Items.field_8848;
            var28[2] = Items.field_8211;
            var28[3] = Items.field_8655;
        }
        var27 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (var26) {
            Item[] var29 = new Item[1];
            var29[0] = Items.field_8069;
        } else {
            var29 = new Item[1];
            var29[0] = Items.field_8069;
        }
        var28 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(blockPos.up().toCenterPos()), 100, this::resolveUnit));
    }

    private BlockPos resolveMinecraftObject() {
        double var12 = SharedKt.getPlayer().getX();
        double var14 = (SharedKt.getPlayer().getEyePos().field_1351 - 0.1000000014901161D);
        double var16 = SharedKt.getPlayer().getZ();
        double var18 = Math.toRadians(SharedKt.getPlayer().method_36454());
        double var20 = Math.toRadians(SharedKt.getPlayer().method_36455());
        double var22 = (Math.sin() * Math.cos());
        double var24 = Math.sin();
        double var26 = (Math.cos() * Math.cos());
        int var28 = (SharedKt.getPlayer().method_6048() / 20.0F);
        var28 = (((var28 * var28) + (var28 * 2.0F)) / 3.0F);
        if (var28 <= 1.0F) {
            if (var28 == 0.0F) {
            }
            var28 = 1.0F;
        }
        double var29 = Math.sqrt((((var22 * var22) + (var24 * var24)) + (var26 * var26)));
        var22 = (var22 / var29);
        var24 = (var24 / var29);
        var26 = (var26 / var29);
        float var31 = (var28 * 3);
        var22 = (var22 * var31);
        var24 = (var24 * var31);
        var26 = (var26 * var31);
        if (!(SharedKt.getPlayer().isOnGround())) {
            var24 = (var24 + SharedKt.getPlayer().method_18798().method_10214());
        }
        int var33 = 0;
        if (var33 < 300) {
            Vec3d vec = new Vec3d();
            var12 = (var12 + var22);
            var14 = (var14 + var24);
            var16 = (var16 + var26);
            var22 = (var22 * 0.99D);
            var24 = (var24 * 0.99D);
            var26 = (var26 * 0.99D);
            var24 = (var24 - 0.05000000074505806D);
            Vec3d vec2 = new Vec3d();
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
                if (this.getSelfDamageCheck() && ExplosionPosEntityHelper.computeValue(iterator.method_17777().up().toCenterPos()) > (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067())) {
                } else {
                    return iterator.method_17777();
                }
                if (var14 > -65.0D) {
                }
            }
        }
        return null;
    }

    public boolean checkCondition(long arg0) {
        if (arg0 >= 0L) {
            if (!(var12)) {
            }
        }
        return StackServiceComponent3.checkCondition(SharedKt.getPlayer().method_6047(), class_1893.field_9126);
    }

    private static Unit resolveUnit(BlockPos arg0) {
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, new class_3965(new Vec3d((arg0.method_10263() + 0.5D), arg0.up().method_10264(), (arg0.method_10260() + 0.0D)), Direction.UP, arg0, 0));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit2(BlockPos arg0) {
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, new class_3965(new Vec3d((arg0.method_10263() + 0.5D), (arg0.up().method_10264() + 0.125D), (arg0.method_10260() + 0.5D)), Direction.UP, arg0.up(), 0));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(StackServiceComponent2 arg0, BlockPos arg1) {
        ItemPacketHelper.INSTANCE.executeAction(arg0.getNumericValue(), INSTANCE.getSwitchMode(), this::resolveUnit);
        ItemPacketHelper.INSTANCE.checkCondition(Items.field_8069, INSTANCE.getSwitchMode(), this::resolveUnit2);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] var28 = new KProperty[2];
        INSTANCE = new BowMinecartModule();
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
        selfDamageCheckSetting = VisibleRenderHelper.registerSetting(INSTANCE, "check-self-damage");
    }

}
