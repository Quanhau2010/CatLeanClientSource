package su.catlean.client.features.modules.pvp.legit;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RotationServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.render.VisibleRenderHelper;

public class TriggerModule extends Module {

    public static final TriggerModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 attackRangeSetting;
    private static final RangeVisibleSettingPropertyImpl reactValSetting;
    private static final VisibleVisibleSettingPropertyImpl whileAttackPressedSetting;
    private static final VisibleVisibleSettingPropertyImpl autoJumpSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreWallsSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseEatingSetting;
    private static int countValue;

    private TriggerModule() {
        super("trigger", SubCategoriesKt.getLegitCategory());
    }

    private float getAttackRange() {
        return ((Number) attackRangeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private int getReactVal() {
        return ((Number) reactValSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getWhileAttackPressed() {
        return ((Boolean) whileAttackPressedSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getAutoJump() {
        return ((Boolean) autoJumpSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getIgnoreWalls() {
        return ((Boolean) ignoreWallsSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getPauseEating() {
        return ((Boolean) pauseEatingSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (this.getWhileAttackPressed() && !(SharedKt.getMc().options.field_1886.method_1434())) {
            return;
        }
        if (SharedKt.getPlayer().method_6115() && this.getPauseEating()) {
            return;
        }
        if (!(SharedKt.getMc().options.field_1903.method_1434()) && SharedKt.getPlayer().isOnGround() && this.getAutoJump()) {
            SharedKt.getPlayer().method_6043();
        }
        Entity entity = EventPacketHelper2.resolveMinecraftObject(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455(), this.getAttackRange(), this.getIgnoreWalls(), false);
        if (entity instanceof PlayerEntity) {
            if (entity != null && !(EntityHelper4.isFriend(((PlayerEntity) entity)))) {
                if (countValue >= this.getReactVal() && RotationServiceComponent.INSTANCE.checkCondition()) {
                    SharedKt.getInteractionManager().method_2918(((PlayerEntity) SharedKt.getPlayer()), entity);
                    SharedKt.getPlayer().method_6104(Hand.field_5808);
                }
                countValue = (countValue + 1);
            } else {
                countValue = 0;
            }
        }
    }

    static {
        KProperty[] items = new KProperty[6];
        INSTANCE = new TriggerModule();
        attackRangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range", 3.0F, RangesKt.rangeTo(1.0F, 7.0F));
        reactValSetting = VisibleRenderHelper.registerSetting(INSTANCE, "react-val", 1, new IntRange(0, 10));
        whileAttackPressedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "while-attack-pressed", false);
        autoJumpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "auto-jump", false);
        ignoreWallsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-walls", false);
        pauseEatingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-while-eating", false);
    }

}
