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
        return ((Number) crystalDelaySetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private KeyRecord getCrystalBind() {
        return ((KeyRecord) crystalBindSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getChangePitch() {
        return ((Boolean) changePitchSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getCrystalOptimizer() {
        return ((Boolean) crystalOptimizerSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getSwitchBack() {
        return ((Boolean) switchBackSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        boolean flag = ((class_3966) SharedKt.getMc().field_1765).method_17782() instanceof EndCrystalEntity;
        if (SharedKt.getMc().field_1765 instanceof class_3965) {
            if (!(Intrinsics.areEqual(SharedKt.getWorld().getBlockState(((class_3965) SharedKt.getMc().field_1765).method_17777()).getBlock(), Blocks.OBSIDIAN))) {
                if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(((class_3965) SharedKt.getMc().field_1765).method_17777()).getBlock(), Blocks.field_9987)) {
                } else {
                }
            }
        } else {
        }
        Item[] items = new Item[1];
        items[0] = Items.field_8301;
        int index = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items).getNumericValue();
        Block[] items2 = new Block[1];
        items2[0] = Blocks.OBSIDIAN;
        items = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items2).getNumericValue();
        if (items == -1) {
            if (!(0)) {
            }
        }
        if (!(ServiceComponent13.checkCondition(this.getCrystalBind().getNumericValue())) || !(serviceComponent10.checkCondition2((this.getCrystalDelay() * flag))) || !(flag) || index == -1 || index >= 9 || items >= 9) {
            return;
        }
        if (flag) {
            SharedKt.getInteractionManager().method_2918(((PlayerEntity) SharedKt.getPlayer()), ((class_3966) SharedKt.getMc().field_1765).method_17782());
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            return;
        }
        items2 = SharedKt.getPlayer().method_31548().method_67532();
        if (SharedKt.getPlayer().method_31548().method_67532() != items) {
            ItemPacketHelper.INSTANCE.executeAction(items);
        }
        ((MinecraftAccessor) SharedKt.getMc()).idoItemUse();
        RunnableServiceComponent2.executeAction(this.getCrystalDelay(), 0, false, this::executeAction);
        ItemPacketHelper.INSTANCE.executeAction(index);
        RunnableServiceComponent2.executeAction(this.getCrystalDelay(), 0, false, this::updateValue4);
    }

    private void onEntitySpawn(EntitySpawn arg0) {
        vec3d = Vec3d.ZERO;
        if (this.getChangePitch()) {
            SharedKt.getPlayer().method_36457(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(this.resolveMinecraftObject(arg0.getEntity()).method_1031(0.0D, 0.15D, 0.0D)).resolveMoveFixServiceComponent().getNumericValue2());
        }
        SharedKt.getInteractionManager().method_2918(((PlayerEntity) SharedKt.getPlayer()), arg0.getEntity());
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        SharedKt.getWorld().method_2945(((EndCrystalEntity) arg0.getEntity()).method_5628(), class_5529.field_26998);
    }

    private static void updateValue(int arg0) {
        ItemPacketHelper.INSTANCE.executeAction(arg0);
    }

    private static void updateValue2(int arg0) {
        ((MinecraftAccessor) SharedKt.getMc()).idoItemUse();
        if (SharedKt.getMc().field_1765 != null) {
            if (SharedKt.getMc().field_1765.method_17784() == null) {
                SharedKt.getMc().field_1765.method_17784();
            }
        }
        vec3d = Vec3d.ZERO;
        RunnableServiceComponent2.executeAction(INSTANCE.getCrystalDelay(), 0, false, this::updateValue);
    }

    private static void executeAction(int arg0, int arg1) {
        ItemPacketHelper.INSTANCE.executeAction(arg0);
        RunnableServiceComponent2.executeAction(INSTANCE.getCrystalDelay(), 0, false, this::updateValue2);
    }

    private static void updateValue3(int arg0) {
        ItemPacketHelper.INSTANCE.executeAction(arg0);
    }

    private static void updateValue4(int arg0) {
        ((MinecraftAccessor) SharedKt.getMc()).idoItemUse();
        if (SharedKt.getMc().field_1765 != null) {
            if (SharedKt.getMc().field_1765.method_17784() == null) {
                SharedKt.getMc().field_1765.method_17784();
            }
        }
        vec3d = Vec3d.ZERO;
        RunnableServiceComponent2.executeAction(INSTANCE.getCrystalDelay(), 0, false, this::updateValue3);
    }

    static {
        KProperty[] items = new KProperty[5];
        INSTANCE = new CrystalBindModule();
        crystalDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 0, new IntRange(0, 250));
        crystalBindSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crystal-bind", new KeyRecord(0, false, false));
        changePitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "change-pitch", false);
        crystalOptimizerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "optimizer", false);
        switchBackSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch-back", false);
        vec3d = Vec3d.ZERO;
        serviceComponent10 = new ServiceComponent10();
    }

}
