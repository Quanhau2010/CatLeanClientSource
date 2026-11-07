package su.catlean.client.features.modules.utility.misc;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class TapeMouseModule extends Module {

    public static final TapeMouseModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final RangeVisibleSettingPropertyImpl randomizeSetting;
    private static final ServiceComponent10 serviceComponent10;

    private TapeMouseModule() {
        super("tape-mouse", SubCategoriesKt.getMiscUtilityCategory());
    }

    private TapeMouseMode getMode() {
        return ((TapeMouseMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private int getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private int getRandomize() {
        return ((Number) randomizeSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    public void onRender2DEvent(Render2DEvent event) {
        if (SharedKt.getMc().field_1765 == null) {
            return;
        }
        if (this.getMode() == TapeMouseMode.LEFT) {
            if (__UNDEF_KEY__ instanceof class_3966) {
                SharedKt.getInteractionManager().method_2918(((PlayerEntity) SharedKt.getPlayer()), this.method_17782());
            }
            if (__UNDEF_KEY__ instanceof class_3965 && !(SharedKt.getWorld().method_22347(this.method_17777()))) {
                SharedKt.getInteractionManager().method_2910(this.method_17777(), this.method_17780());
            }
            SharedKt.getPlayer().method_6104(Hand.field_5808);
        } else {
            if (__UNDEF_KEY__ instanceof class_3966) {
                SharedKt.getInteractionManager().method_2905(((PlayerEntity) SharedKt.getPlayer()), this.method_17782(), Hand.field_5808);
            } else {
                SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808);
                SharedKt.getPlayer().method_6104(Hand.field_5808);
            }
        }
    }

    static {
        KProperty[] items = new KProperty[3];
        INSTANCE = new TapeMouseModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "button", TapeMouseMode.LEFT);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 600, new IntRange(0, 10000));
        randomizeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "randomize", 50, new IntRange(0, 10000));
        serviceComponent10 = new ServiceComponent10();
    }

}
