package su.catlean.client.features.modules.utility.misc;

import kotlin.Unit;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.WindHopSwitchMode;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoSoupModule extends Module {

    public static final AutoSoupModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 healthSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchModeSetting;

    private AutoSoupModule() {
        super("auto-soup", SubCategoriesKt.getMiscUtilityCategory());
    }

    private float getHealth() {
        return (Number) healthSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private WindHopSwitchMode getSwitchMode() {
        return (WindHopSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setSwitchMode(WindHopSwitchMode value) {
        switchModeSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        ItemPacketHelper.INSTANCE.checkCondition(Items.field_8208, this.getSwitchMode(), this::getUnit);
    }

    private static Unit getUnit() {
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] var29 = new KProperty[2];
        INSTANCE = new AutoSoupModule();
        healthSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-health", 5.0F, RangesKt.rangeTo(1.0F, 20.0F));
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch", WindHopSwitchMode.SILENT_FULL);
    }

}
