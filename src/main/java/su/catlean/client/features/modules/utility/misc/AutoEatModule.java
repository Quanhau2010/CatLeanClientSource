package su.catlean.client.features.modules.utility.misc;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1661;
import net.minecraft.class_1702;
import net.minecraft.class_9323;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.StopUsingItemEvent;
import su.catlean.api.event.events.player.UsingItemEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoEatModule extends Module {

    public static final AutoEatModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl hungerSetting;
    private static final VisibleVisibleSettingPropertyImpl swapBackSetting;
    private static final VisibleVisibleSettingPropertyImpl gappleSetting;
    private static final VisibleVisibleSettingPropertyImpl chorusSetting;
    private static final VisibleVisibleSettingPropertyImpl rottenFleshSetting;
    private static final VisibleVisibleSettingPropertyImpl spiderEyeSetting;
    private static final VisibleVisibleSettingPropertyImpl pufferfishSetting;
    private static boolean enabledFlag;
    private static int countValue;

    private AutoEatModule() {
        super("auto-eat", SubCategoriesKt.getMiscUtilityCategory());
    }

    private int getHunger() {
        return ((Number) hungerSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getSwapBack() {
        return ((Boolean) swapBackSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getGapple() {
        return ((Boolean) gappleSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getChorus() {
        return ((Boolean) chorusSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getRottenFlesh() {
        return ((Boolean) rottenFleshSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getSpiderEye() {
        return ((Boolean) spiderEyeSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getPufferfish() {
        return ((Boolean) pufferfishSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        enabledFlag = 0;
        if (SharedKt.getPlayer().method_7344().method_7586() <= this.getHunger()) {
            if (!(this.checkCondition(Hand.field_5808)) && !(this.checkCondition(Hand.field_5810))) {
            } else {
            }
            this.executeAction();
        } else {
            ItemPacketHelper.INSTANCE.executeAction(countValue);
            countValue = -1;
        }
    }

    private void executeAction() {
        if (!(SharedKt.getPlayer().method_6115())) {
            if (this.checkCondition(Hand.field_5810)) {
            } else {
            }
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        }
        enabledFlag = 1;
    }

    private boolean checkCondition() {
        int index = 0;
        if (index < 9) {
            ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(index);
            if (!(this.getGapple())) {
                if (stack.getItem() == Items.field_8367) {
                } else {
                    if (!(this.getChorus())) {
                    }
                    if (!(this.getRottenFlesh())) {
                    }
                    if (!(this.getSpiderEye())) {
                    }
                    if (!(this.getPufferfish())) {
                        if (stack.method_57353().method_57832(class_9334.field_50075) && stack.getItem() != Items.field_8463 && stack.getItem() != Items.field_8233 && stack.getItem() != Items.field_8511 && stack.getItem() != Items.field_8680 && stack.getItem() != Items.field_8323) {
                            countValue = SharedKt.getPlayer().method_31548().method_67532();
                            ItemPacketHelper.INSTANCE.executeAction(index);
                            return true;
                        }
                    }
                }
            } else {
            }
        }
        return false;
    }

    private boolean checkCondition(Hand arg0) {
        if (arg0 == Hand.field_5808) {
        } else {
        }
        ItemStack stack = SharedKt.getPlayer().method_6079();
        stack = stack.getItem();
        if (!(this.getGapple())) {
        }
        if (!(this.getChorus())) {
        }
        if (!(this.getRottenFlesh())) {
        }
        if (!(this.getSpiderEye())) {
        }
        if (!(this.getPufferfish())) {
            if (stack.method_57353().method_57832(class_9334.field_50075) && stack != Items.field_8463 && stack != Items.field_8367 && stack != Items.field_8233 && stack != Items.field_8511 && stack != Items.field_8680 && stack != Items.field_8323) {
            } else {
            }
        }
        return false;
    }

    private void onUsingItemEvent(UsingItemEvent arg0) {
        arg0.cancel();
    }

    private void onStopUsingItemEvent(StopUsingItemEvent arg0) {
        arg0.cancel();
    }

    static {
        KProperty[] items = new KProperty[7];
        INSTANCE = new AutoEatModule();
        hungerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "Hunger", 8, new IntRange(0, 20));
        swapBackSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-back", true);
        gappleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "gapple", true);
        chorusSetting = VisibleRenderHelper.registerSetting(INSTANCE, "chorus", false);
        rottenFleshSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotten-flesh", false);
        spiderEyeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "spider-eye", false);
        pufferfishSetting = VisibleRenderHelper.registerSetting(INSTANCE, "puffer-fish", false);
        countValue = -1;
    }

}
