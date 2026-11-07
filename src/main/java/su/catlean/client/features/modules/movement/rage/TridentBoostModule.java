package su.catlean.client.features.modules.movement.rage;

import java.util.Optional;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1313;
import net.minecraft.class_1890;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_6880;
import net.minecraft.class_9701;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.TridentUseEvent;
import su.catlean.api.event.events.player.TridentWeatherEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class TridentBoostModule extends Module {

    public static final TridentBoostModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl2 factorSetting;
    private static final RangeVisibleSettingPropertyImpl cooldownSetting;
    private static final VisibleVisibleSettingPropertyImpl anyWeatherSetting;

    private TridentBoostModule() {
        super("trident-boost", SubCategoriesKt.getRageMovementCategory());
    }

    private TridentBoostMode getMode() {
        return ((TridentBoostMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private float getFactor() {
        return ((Number) factorSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public int getCooldown() {
        if (((Number) cooldownSetting.getValue(this, DELEGATED_PROPERTIES[2])) != null) {
        }
        return null;
    }

    private boolean getAnyWeather() {
        return ((Boolean) anyWeatherSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    public void onTridentUseEvent(TridentUseEvent e) {
        if (SharedKt.getPlayer().method_6048() >= this.getCooldown()) {
            float factor = class_1890.method_60123(SharedKt.getPlayer().method_6030(), ((LivingEntity) SharedKt.getPlayer()));
            if (!(this.getAnyWeather())) {
            }
            if (SharedKt.getPlayer().method_5721() && factor > 0.0F) {
                float factor2 = SharedKt.getPlayer().method_36454();
                float factor3 = SharedKt.getPlayer().method_36455();
                double offset = (Math.sin((factor2 * 0.017453292F)) * Math.cos((factor3 * 0.017453292F)));
                double offset2 = Math.sin((factor3 * 0.017453292F));
                double offset3 = (Math.cos((factor2 * 0.017453292F)) * Math.cos((factor3 * 0.017453292F)));
                double offset4 = Math.sqrt((((offset * offset) + (offset2 * offset2)) + (offset3 * offset3)));
                if (this.getMode() == TridentBoostMode.Factor) {
                } else {
                }
                float factor4 = this.getFactor();
                offset = (offset * (factor4 / offset4));
                offset2 = (offset2 * (factor4 / offset4));
                offset3 = (offset3 * (factor4 / offset4));
                SharedKt.getPlayer().method_5762(offset, offset2, offset3);
                SharedKt.getPlayer().method_40126(20, 8.0F, SharedKt.getPlayer().method_6030());
                if (SharedKt.getPlayer().isOnGround()) {
                    SharedKt.getPlayer().method_5784(class_1313.field_6308, new Vec3d(0.0D, 1.1999999284744263D, 0.0D));
                }
                class_6880 class6880 = ((class_6880) class_1890.method_60165(SharedKt.getPlayer().method_6030(), class_9701.field_51654).orElse(class_3417.field_15001));
                SharedKt.getWorld().method_43129(null, SharedKt.getPlayer(), ((class_3414) class6880.comp_349()), class_3419.field_15248, 1.0F, 1.0F);
            }
        }
        e.cancel();
    }

    public void onTridentWeatherEvent(TridentWeatherEvent e) {
        e.cancel();
    }

    static {
        KProperty[] items = new KProperty[4];
        INSTANCE = new TridentBoostModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", TridentBoostMode.Motion);
        factorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "factor", 1.0F, RangesKt.rangeTo(0.1F, 20.0F));
        cooldownSetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 10, new IntRange(0, 20));
        anyWeatherSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rain-spoof", true);
    }

}
