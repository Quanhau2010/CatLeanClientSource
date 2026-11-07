package su.catlean.client.features.modules.utility.player;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1747;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.mixins.accessors.LivingEntityAccessor;
import su.catlean.mixins.accessors.MinecraftAccessor;

public class NoDelayModule extends Module {

    public static final NoDelayModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final VisibleVisibleSettingPropertyImpl jumpSetting;
    private static final VisibleVisibleSettingPropertyImpl blocksSetting;
    private static final VisibleVisibleSettingPropertyImpl crystalsSetting;
    private static final VisibleVisibleSettingPropertyImpl xpSetting;
    private static final VisibleVisibleSettingPropertyImpl allSetting;

    private NoDelayModule() {
        super("no-delay", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private int getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getJump() {
        return ((Boolean) jumpSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setJump(boolean value) {
        jumpSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    public boolean getBlocks() {
        return ((Boolean) blocksSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    public void setBlocks(boolean value) {
        blocksSetting.setValue(this, DELEGATED_PROPERTIES[2], Boolean.valueOf(value));
    }

    private boolean getCrystals() {
        return ((Boolean) crystalsSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setCrystals(boolean value) {
        crystalsSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private boolean getXp() {
        return ((Boolean) xpSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void setXp(boolean value) {
        xpSetting.setValue(this, DELEGATED_PROPERTIES[4], Boolean.valueOf(value));
    }

    public boolean getAll() {
        return ((Boolean) allSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    public void setAll(boolean value) {
        allSetting.setValue(this, DELEGATED_PROPERTIES[5], Boolean.valueOf(value));
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        if (((LivingEntityAccessor) SharedKt.getPlayer()).getLastJumpCooldown() > 0 && this.getJump()) {
            ((LivingEntityAccessor) SharedKt.getPlayer()).setLastJumpCooldown(0);
        }
        ((MinecraftAccessor) SharedKt.getMc()).setUseCooldown(this.getDelay());
    }

    private boolean checkCondition(Item arg0) {
        if (arg0 instanceof class_1747) {
        }
        if (arg0 == Items.field_8301) {
        }
        if (arg0 == Items.field_8287) {
            if (!(this.getBlocks()) && !(this.getCrystals()) && !(this.getXp())) {
                if (this.getAll()) {
                } else {
                }
            }
        }
        return false;
    }

    static {
        KProperty[] items = new KProperty[6];
        INSTANCE = new NoDelayModule();
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 1, new IntRange(0, 4));
        jumpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "jump", false);
        blocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks", false);
        crystalsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crystals", false);
        xpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "x-p", false);
        allSetting = VisibleRenderHelper.registerSetting(INSTANCE, "all", true);
    }

}
