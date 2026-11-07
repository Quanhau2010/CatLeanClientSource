package su.catlean.client.features.modules.utility.player;

import java.util.Optional;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_1498;
import net.minecraft.class_1753;
import net.minecraft.class_1764;
import net.minecraft.class_1835;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_2378;
import net.minecraft.class_5321;
import net.minecraft.class_5455;
import net.minecraft.class_6880;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.rage.TridentBoostModule;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.mixins.accessors.LocalPlayerAccessor;

public class PerfectDelayModule extends Module {

    public static final PerfectDelayModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 horseSetting;
    private static final VisibleVisibleSettingPropertyImpl bowSetting;
    private static final VisibleVisibleSettingPropertyImpl crossbowSetting;
    private static final VisibleVisibleSettingPropertyImpl tridentSetting;

    private PerfectDelayModule() {
        super("perfect-delay", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private PerfectDelayHorseMode getHorse() {
        return (PerfectDelayHorseMode) horseSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getBow() {
        return (Boolean) bowSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getCrossbow() {
        return (Boolean) crossbowSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getTrident() {
        return (Boolean) tridentSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (TridentBoostModule.INSTANCE.getEnabled()) {
        } else {
        }
        if (this.getTrident() && SharedKt.getPlayer().method_6030().getItem() instanceof class_1835 && TridentBoostModule.INSTANCE.getCooldown() > 9) {
            SharedKt.getInteractionManager().method_2897((PlayerEntity) SharedKt.getPlayer());
        }
        if (SharedKt.getPlayer().method_6030().getItem() instanceof class_1764 && this.getCrossbow() && SharedKt.getPlayer().method_6048() >= (25 - ((0.25D * this.computeValue(SharedKt.getPlayer().method_6030())) * 20))) {
            SharedKt.getInteractionManager().method_2897((PlayerEntity) SharedKt.getPlayer());
        }
        if (SharedKt.getPlayer().method_6030().getItem() instanceof class_1753 && this.getBow() && SharedKt.getPlayer().method_6048() > 19) {
            SharedKt.getInteractionManager().method_2897((PlayerEntity) SharedKt.getPlayer());
        }
        if (this.getHorse() == PerfectDelayHorseMode.Rage) {
            (LocalPlayerAccessor) SharedKt.getPlayer().setJumpRidingScale(1.0F);
        }
        SharedKt.getMc().options.field_1903.method_23481(0);
    }

    private float computeValue(ItemStack arg0) {
        return class_1890.method_8225((class_6880) (class_2378) SharedKt.getWorld().method_30349().method_46759(class_1893.field_9098.method_58273()).get().method_10223(class_1893.field_9098.method_29177()).get(), arg0);
    }

    static {
        KProperty[] var28 = new KProperty[4];
        INSTANCE = new PerfectDelayModule();
        horseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "horse", PerfectDelayHorseMode.Legit);
        bowSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bow");
        crossbowSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crossbow");
        tridentSetting = VisibleRenderHelper.registerSetting(INSTANCE, "trident");
    }

}
