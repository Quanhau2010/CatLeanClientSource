package su.catlean.client.features.modules.pvp.legit;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1297.class_5529;
import net.minecraft.class_1661;
import net.minecraft.class_239;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.world.EntitySpawn;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.mixins.accessors.MinecraftAccessor;

public class CrystalBindModule extends Module {

    public static final CrystalBindModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl crystalDelaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 crystalBindSetting;
    private static final VisibleVisibleSettingPropertyImpl changePitchSetting;
    private static final VisibleVisibleSettingPropertyImpl crystalOptimizerSetting;
    private static final VisibleVisibleSettingPropertyImpl switchBackSetting;
    private static Vec3d vec3d;
    private static ServiceComponent10 serviceComponent10;

    private CrystalBindModule() {
        super("crystal-bind", SubCategoriesKt.getLegitCategory());
    }

    private int getCrystalDelay() {
        return (Number) crystalDelaySetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private KeyRecord getCrystalBind() {
        return (KeyRecord) crystalBindSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getChangePitch() {
        return (Boolean) changePitchSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getCrystalOptimizer() {
        return (Boolean) crystalOptimizerSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getSwitchBack() {
        return (Boolean) switchBackSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        boolean var32 = (class_3966) SharedKt.getMc().field_1765.method_17782() instanceof EndCrystalEntity;
        if (SharedKt.getMc().field_1765 instanceof class_3965) {
            if (!(Intrinsics.areEqual(SharedKt.getWorld().getBlockState((class_3965) SharedKt.getMc().field_1765.method_17777()).getBlock(), Blocks.OBSIDIAN))) {
                if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState((class_3965) SharedKt.getMc().field_1765.method_17777()).getBlock(), Blocks.field_9987)) {
                }
            }
        } else {
        }
        }
        Item[] var35 = new Item[1];
        var35[0] = Items.field_8301;
        int var34 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue();
        Block[] var36 = new Block[1];
        var36[0] = Blocks.OBSIDIAN;
        var35 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue();
        if (var35 == -1) {
            if (!(0)) {
            }
        }
        if (!(ServiceComponent13.checkCondition(this.getCrystalBind().getNumericValue())) || !(serviceComponent10.checkCondition2((this.getCrystalDelay() * var32))) || !(var32) || var34 == -1 || var34 >= 9 || var35 >= 9) {
            return;
        }
        if (var32) {
            SharedKt.getInteractionManager().method_2918((PlayerEntity) SharedKt.getPlayer(), (class_3966) SharedKt.getMc().field_1765.method_17782());
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            return;
        }
        var36 = SharedKt.getPlayer().method_31548().method_67532();
        if (SharedKt.getPlayer().method_31548().method_67532() != var35) {
            ItemPacketHelper.INSTANCE.executeAction();
        }
        (MinecraftAccessor) SharedKt.getMc().idoItemUse();
        RunnableServiceComponent2.executeAction(this.getCrystalDelay(), 0, 0, this::executeAction);
        ItemPacketHelper.INSTANCE.executeAction();
        RunnableServiceComponent2.executeAction(this.getCrystalDelay(), 0, 0, this::updateValue4);
    }

    private void onEntitySpawn(EntitySpawn arg0) {
        vec3d = Vec3d.ZERO;
        if (this.getChangePitch()) {
            SharedKt.getPlayer().method_36457(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(this.resolveMinecraftObject(arg0.getEntity()).method_1031(0.0D, 0.15D, 0.0D)).resolveMoveFixServiceComponent().getNumericValue2());
        }
        SharedKt.getInteractionManager().method_2918((PlayerEntity) SharedKt.getPlayer(), arg0.getEntity());
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        SharedKt.getWorld().method_2945((EndCrystalEntity) arg0.getEntity().method_5628(), class_5529.field_26998);
    }

    private static void updateValue(int arg0) {
        ItemPacketHelper.INSTANCE.executeAction(arg0);
    }

    private static void updateValue2(int arg0) {
        (MinecraftAccessor) SharedKt.getMc().idoItemUse();
        if (SharedKt.getMc().field_1765 != null) {
            if (SharedKt.getMc().field_1765.method_17784() == null) {
            }
            SharedKt.getMc().field_1765.method_17784();
        }
        vec3d = Vec3d.ZERO;
        RunnableServiceComponent2.executeAction(INSTANCE.getCrystalDelay(), 0, 0, this::updateValue);
    }

    private static void executeAction(int arg0, int arg1) {
        ItemPacketHelper.INSTANCE.executeAction(arg0);
        RunnableServiceComponent2.executeAction(INSTANCE.getCrystalDelay(), 0, 0, this::updateValue2);
    }

    private static void updateValue3(int arg0) {
        ItemPacketHelper.INSTANCE.executeAction(arg0);
    }

    private static void updateValue4(int arg0) {
        (MinecraftAccessor) SharedKt.getMc().idoItemUse();
        if (SharedKt.getMc().field_1765 != null) {
            if (SharedKt.getMc().field_1765.method_17784() == null) {
            }
            SharedKt.getMc().field_1765.method_17784();
        }
        vec3d = Vec3d.ZERO;
        RunnableServiceComponent2.executeAction(INSTANCE.getCrystalDelay(), 0, 0, this::updateValue3);
    }

    static {
        KProperty[] var33 = new KProperty[5];
        INSTANCE = new CrystalBindModule();
        crystalDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 0, new IntRange(0, 250));
        crystalBindSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crystal-bind", new KeyRecord());
        changePitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "change-pitch");
        crystalOptimizerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "optimizer");
        switchBackSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch-back");
        vec3d = Vec3d.ZERO;
        serviceComponent10 = new ServiceComponent10();
    }

}
