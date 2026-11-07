package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.mappings.SpiderModeWhenMappings;

public class SpiderModule extends Module {

    public static final SpiderModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;

    private SpiderModule() {
        super("spider", SubCategoriesKt.getRageMovementCategory());
    }

    private SpiderMode getMode() {
        return (SpiderMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private int getDelay() {
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (!(SharedKt.getPlayer().field_5976)) {
            return;
        }
        SharedKt.getPlayer().method_24830(!((SharedKt.getPlayer().field_6012 % this.getDelay())));
        SharedKt.getPlayer().method_18800(SharedKt.getPlayer().method_18798().method_10216(), 0.42D, SharedKt.getPlayer().method_18798().method_10215());
        SharedKt.getPlayer().method_18800(SharedKt.getPlayer().method_18798().method_10216(), 0.21D, SharedKt.getPlayer().method_18798().method_10215());
        float var23 = SharedKt.getPlayer().method_36455();
        SharedKt.getPlayer().method_36457(82.0F);
        Item[] var25 = new Item[1];
        var25[0] = Items.field_8705;
        StackServiceComponent2 var24 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (var24.isActive()) {
            ItemPacketHelper.INSTANCE.executeAction(var24.getNumericValue());
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            ItemPacketHelper.INSTANCE.updateValue2();
        }
        SharedKt.getPlayer().method_36457();
    }

    private void onPreSyncEvent(PreSyncEvent arg0) {
        SharedKt.getPlayer().method_24830(1);
        SharedKt.getPlayer().method_18800(SharedKt.getPlayer().method_18798().method_10216(), 0.48114514191918D, SharedKt.getPlayer().method_18798().method_10215());
        SharedKt.getPlayer().method_24830(1);
        SharedKt.getPlayer().method_6043();
    }

    static {
        KProperty[] var28 = new KProperty[2];
        INSTANCE = new SpiderModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", SpiderMode.DEFAULT);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 2, new IntRange(1, 15));
    }

}
