package su.catlean.client.features.modules.pvp.legit;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1661;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.mixins.accessors.MinecraftAccessor;

public class AnchorBindModule extends Module {

    public static final AnchorBindModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl anchorDelaySetting;
    private static final VisibleVisibleSettingPropertyImpl randomizeDelaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 anchorBindSetting;
    private static ServiceComponent38 serviceComponent38;

    private AnchorBindModule() {
        super("anchor-bind", SubCategoriesKt.getLegitCategory());
    }

    private int getAnchorDelay() {
        return ((Number) anchorDelaySetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getRandomizeDelay() {
        return ((Boolean) randomizeDelaySetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private KeyRecord getAnchorBind() {
        return ((KeyRecord) anchorBindSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (this.getAnchorDelay() > 0) {
        } else {
        }
        Item[] items = new Item[1];
        items[0] = Items.field_8801;
        int index = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items).getNumericValue();
        items = Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(SharedKt.getPlayer().method_31548().method_67532()).getItem(), Items.field_8801);
        Item[] items2 = new Item[1];
        items2[0] = Items.field_23141;
        int index2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items2).getNumericValue();
        items2 = SharedKt.getPlayer().method_31548().method_67532();
        boolean flag = Intrinsics.areEqual(SharedKt.getWorld().getBlockState(((class_3965) SharedKt.getMc().field_1765).method_17777()).getBlock(), Blocks.field_23152);
        if (!(ServiceComponent13.checkCondition(this.getAnchorBind().getNumericValue())) || !(((this.getAnchorDelay() * 5) + 10).checkCondition(2)) || index == -1 || index2 == -1) {
            return;
        }
        if (flag) {
            Object element = new int[2];
            element[0] = index;
            element[1] = items2;
            this.executeAction(element);
        } else {
            element = new int[3];
            element[0] = index2;
            element[1] = index;
            if (items) {
            } else {
            }
            2[index2] = items2;
            element.executeAction(element);
        }
    }

    private void executeAction(int[] arg0) {
        Function0 function0 = this::getUnit;
        Iterable iterable = ((Iterable) ArraysKt.reversed(arg0));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            int index = ((Number) element);
            function0 = this::resolveUnit;
        }
        function0.invoke();
    }

    private static Unit getUnit() {
        return Unit.INSTANCE;
    }

    private static void updateValue(Function0 arg0) {
        arg0.invoke();
    }

    private static void updateValue2(Function0 arg0) {
        ((MinecraftAccessor) SharedKt.getMc()).idoItemUse();
        if (INSTANCE.getRandomizeDelay()) {
        } else {
        }
        (INSTANCE.getAnchorDelay() - 2).executeAction((RangeServiceComponent.f(((ClosedRange) new IntRange(-1, 1)), false) + 0), -10, INSTANCE.getAnchorDelay() > 0, this::updateValue);
    }

    private static Unit resolveUnit(int arg0, Function0 arg1) {
        ItemPacketHelper.INSTANCE.executeAction(arg0);
        if (INSTANCE.getRandomizeDelay()) {
        } else {
        }
        (INSTANCE.getAnchorDelay() - 2).executeAction((RangeServiceComponent.f(((ClosedRange) new IntRange(-1, 1)), false) + 0), -10, INSTANCE.getAnchorDelay() > 0, this::updateValue2);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[3];
        INSTANCE = new AnchorBindModule();
        anchorDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 1, new IntRange(0, 5));
        randomizeDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "randomize-delay", false);
        anchorBindSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anchor-bind", new KeyRecord(0, false, false));
        serviceComponent38 = new ServiceComponent38();
    }

}
