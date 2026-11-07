package su.catlean.client.features.modules.pvp.protect;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.StopUsingItemEvent;
import su.catlean.api.event.events.player.UsingItemEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoGappleModule extends Module {

    public static final AutoGappleModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 healthSetting;
    private static boolean enabledFlag;

    private AutoGappleModule() {
        super("auto-gapple", SubCategoriesKt.getProtectCategory());
    }

    private float getHealth() {
        return (Number) healthSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        enabledFlag = 0;
        if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8463))) {
            if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8367)) {
            }
        } else {
        }
        if (!(Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8463))) {
            if (Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8367)) {
            }
        } else {
        }
        int var13 = 0;
        if (!(SharedKt.getPlayer().method_6115())) {
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        }
        enabledFlag = 1;
    }

    private void onUsingItemEvent(UsingItemEvent arg0) {
        arg0.cancel();
    }

    private void onStopUsingItemEvent(StopUsingItemEvent arg0) {
        arg0.cancel();
    }

    static {
        KProperty[] var26 = new KProperty[1];
        INSTANCE = new AutoGappleModule();
        healthSetting = VisibleRenderHelper.registerSetting(INSTANCE, "health", 15.0F, RangesKt.rangeTo(1.0F, 36.0F));
    }

}
