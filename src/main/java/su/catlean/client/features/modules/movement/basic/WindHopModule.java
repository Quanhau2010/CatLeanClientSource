package su.catlean.client.features.modules.movement.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.class_1796;
import net.minecraft.class_2879;
import net.minecraft.class_3675.class_306;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent120;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.mixins.accessors.KeyMappingAccessor;

public class WindHopModule extends Module {

    public static final WindHopModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchModeSetting;

    private WindHopModule() {
        super("wind-hop", SubCategoriesKt.getBasicMovementCategory());
    }

    private WindHopSwitchMode getSwitchMode() {
        return (WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setSwitchMode(WindHopSwitchMode value) {
        switchModeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 64129331416845L);
        long var5 = ((arg0 ^ 44030506242343L) >>> 48);
        long var6 = (((arg0 ^ 44030506242343L) << 16) >>> 32);
        long var7 = (((arg0 ^ 44030506242343L) << 48) >>> 48);
        if (var8 == null) {
            if (!(ServiceComponent13.checkCondition((KeyMappingAccessor) SharedKt.getMc().options.field_1903.getKey().method_1444()))) {
            }
            SharedKt.getMc().options.field_1903.method_23481(0);
        }
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        SharedKt.getMc().options.field_1903.method_23481(1);
        if (SharedKt.getPlayer().method_7357().method_7904(Items.field_49098.method_7854())) {
            return;
        }
        if (!(SharedKt.getPlayer().isOnGround()) && SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_989(0.0D, -1.0D, 0.0D)).iterator().hasNext()) {
            this.executeAction(new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), 90.0F));
        } else {
            BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
            Iterable var22 = (Iterable) ServiceComponent120.enumEntries;
            int var23 = 0;
            Object var24 = var22;
            Collection var25 = (Collection) new ArrayList();
            int var26 = 0;
            Iterator iterator = var24.iterator();
            while (iterator.hasNext()) {
                Object var28 = iterator.next();
                Direction var29 = (Direction) var28;
                int var30 = 0;
                var25.add();
            }
            Iterator iterator2 = var25.iterator();
            while (iterator2.hasNext()) {
                var22 = (Direction) iterator2.next();
                var23 = blockPos.offset();
                this.executeAction(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(var23.toCenterPos().method_1031(0.0D, -0.5D, 0.0D)));
            }
        }
    }

    private void executeAction(MoveFixServiceComponent arg0) {
        StackServiceComponent2 var12 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(arg0, 150, this::resolveUnit));
    }

    private static boolean checkCondition(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_49098);
    }

    private static Unit getUnit() {
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(StackServiceComponent2 arg0) {
        ItemPacketHelper.INSTANCE.executeAction(arg0.getNumericValue(), INSTANCE.getSwitchMode(), this::getUnit);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] var26 = new KProperty[1];
        INSTANCE = new WindHopModule();
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
    }

}
