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
        return ((WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setSwitchMode(WindHopSwitchMode value) {
        switchModeSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    public void updateValue2() {
        SharedKt.getMc().options.field_1903.method_23481(false);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        SharedKt.getMc().options.field_1903.method_23481(true);
        if (SharedKt.getPlayer().method_7357().method_7904(Items.field_49098.method_7854())) {
            return;
        }
        while (SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_989(0.0D, -1.0D, 0.0D)).iterator().hasNext()) {
            this.executeAction(new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), 90.0F, false));
        }
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        Iterable iterable = ((Iterable) ServiceComponent120.enumEntries);
        int index = 0;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Direction direction = ((Direction) element);
            if (direction != Direction.UP) {
            } else {
            }
            collection.add(element);
        }
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            iterable = ((Direction) iterator2.next());
            index = blockPos.offset(iterable);
            this.executeAction(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(index.toCenterPos().method_1031(0.0D, -0.5D, 0.0D)));
        }
    }

    private void executeAction(MoveFixServiceComponent arg0) {
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition, this.getSwitchMode());
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(arg0, 150, this::resolveUnit));
    }

    private static boolean checkCondition(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_49098);
    }

    private static Unit getUnit() {
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
        return Unit.INSTANCE;
    }

    private static Unit resolveUnit(StackServiceComponent2 arg0) {
        ItemPacketHelper.INSTANCE.executeAction(arg0.getNumericValue(), INSTANCE.getSwitchMode(), this::getUnit);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new WindHopModule();
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
    }

}
