package su.catlean.client.features.modules.utility.equip;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1890;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_2879;
import net.minecraft.class_6880;
import net.minecraft.class_9304;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.ElytraRecastModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode16;

public class ElytraSwapModule extends Module {

    public static final ElytraSwapModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 switchButtonSetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 fireWorkButtonSetting;
    private static final VisibleVisibleSettingPropertyImpl startFireWorkSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 fireWorkModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 swapModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 hotBarSwapModeSetting;
    private static final VisibleVisibleSettingPropertyImpl swapOnLandSetting;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static int countValue;
    private static final Item[] minecraftRefArray;
    private static boolean enabledFlag3;

    private ElytraSwapModule() {
        super("elytra-swap", SubCategoriesKt.getEquipCategory());
    }

    private ElytraSwapMode getMode() {
        return ((ElytraSwapMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private KeyRecord getSwitchButton() {
        return ((KeyRecord) switchButtonSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private KeyRecord getFireWorkButton() {
        return ((KeyRecord) fireWorkButtonSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getStartFireWork() {
        return ((Boolean) startFireWorkSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private ElytraSwapFireWorkMode getFireWorkMode() {
        return ((ElytraSwapFireWorkMode) fireWorkModeSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private ElytraSwapSwapMode getSwapMode() {
        return ((ElytraSwapSwapMode) swapModeSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private ElytraSwapHotBarSwapMode getHotBarSwapMode() {
        return ((ElytraSwapHotBarSwapMode) hotBarSwapModeSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getSwapOnLand() {
        return ((Boolean) swapOnLandSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public void updateValue() {
        executeAction(this, true, false);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (EventPacketHelper2.INSTANCE.getNumericValue() > 15) {
            enabledFlag2 = 1;
        }
        if (Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) {
            this.executeAction(false, true);
        }
        enabledFlag2 = 0;
    }

    private void onAfterSendPacket(AfterSendPacket arg0) {
        if (this.getMode() == ElytraSwapMode.BIND && this.getStartFireWork() && !(enabledFlag)) {
            this.updateValue();
        }
        enabledFlag = 0;
    }

    private void onInputEvent(InputEvent arg0) {
        if (arg0.getKey() == this.getSwitchButton().getNumericValue()) {
            executeAction(this, false, false);
        }
        this.updateValue();
    }

    private void updateValue() {
        RunnableServiceComponent2.executeAction(0, -10, false, this::executeAction);
    }

    public int computeValue(short arg0) {
        int index = 0;
        if (index < minecraftRefArray) {
            Object element = minecraftRefArray[index];
            Item[] items = new Item[1];
            items[0] = element;
            StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
            if (stackServiceComponent2.isActive()) {
                return stackServiceComponent2.getNumericValue();
            }
        }
        return -1;
    }

    private int computeValue(byte arg0, int arg1, int arg2) {
        int index = -1;
        int index2 = -1;
        int index3 = 0;
        if (index3 < 37) {
            if (arg1 > 0) {
                if (SharedKt.getMc().player != null && SharedKt.getMc().player.method_31548() != null) {
                } else {
                    SharedKt.getMc().player.method_31548().method_5438(index3);
                }
            }
            if (arg2 > 0 && __UNDEF_KEY__ != null) {
            }
            if (Intrinsics.areEqual(this.getItem(), Items.ELYTRA) && ElytraRecastModule.INSTANCE.checkCondition()) {
                int index4 = 0;
                class_9304 class9304 = class_1890.method_57532();
                Iterable iterable = ((Iterable) class9304.method_57534());
                Iterator iterator = iterable.iterator();
                while (iterator.hasNext()) {
                    Object element = iterator.next();
                    class_6880 class6880 = ((class_6880) element);
                    if (arg0 >= 0) {
                        if (__UNDEF_KEY__ != null) {
                            if (class6880 != null) {
                                index4 = (index4 + class9304.method_57536(class6880));
                            } else {
                            }
                            if (arg0 >= 0) {
                            }
                        }
                    }
                }
                if (index4 > index2) {
                    index2 = index4;
                    if (arg0 >= 0) {
                        if (index3 < 9) {
                        } else {
                        }
                    }
                    index = index3;
                }
            }
        }
        return index;
    }

    private void executeAction(boolean arg0, boolean arg1) {
        RunnableServiceComponent2.executeAction(0, -10, false, this::executeAction);
    }

    private static void executeAction(ElytraSwapModule arg0, boolean arg1, boolean arg2, int arg3, Object arg4) {
        if ((arg3 & 2) != 0) {
            arg2 = 0;
        }
        arg0.executeAction(arg1, arg2);
    }

    private void executeAction(int arg0, boolean arg1) {
        if (36 <= arg0) {
        } else {
            if (arg0 < 45) {
                if (this.getHotBarSwapMode() == ElytraSwapHotBarSwapMode.DEFAULT) {
                    HandServiceComponent.executeAction(6, (arg0 - 36), class_1713.field_7791, true);
                } else {
                    ItemPacketHelper.executeAction((arg0 - 36));
                    if (this.getSwapMode() == ElytraSwapSwapMode.DEFAULT) {
                        HandServiceComponent.e(arg0, 0, null, false);
                        HandServiceComponent.e(6, 0, null, false);
                        HandServiceComponent.e(arg0, 0, null, true);
                    } else {
                        HandServiceComponent.e(arg0, 7, class_1713.field_7791, false);
                        HandServiceComponent.e(6, 7, class_1713.field_7791, false);
                        HandServiceComponent.executeAction(arg0, 7, class_1713.field_7791, true);
                    }
                }
            } else {
            }
        }
        countValue = SharedKt.getPlayer().field_6012;
        this.executeAction();
    }

    private void executeAction() {
        RunnableServiceComponent2.executeAction(-1, -10, false, this::executeAction2);
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() == ElytraSwapMode.BIND;
    }

    private static boolean isActive3() {
        return INSTANCE.getMode() == ElytraSwapMode.BIND;
    }

    private static boolean isActive4() {
        return INSTANCE.getMode() == ElytraSwapMode.BIND;
    }

    private static boolean isActive5() {
        return INSTANCE.getMode() == ElytraSwapMode.BIND;
    }

    private static boolean isActive6() {
        return INSTANCE.getMode() == ElytraSwapMode.BIND;
    }

    private static void executeAction() {
        Item[] items = new Item[1];
        items[0] = Items.FIREWORK_ROCKET;
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        Item[] items2 = new Item[1];
        items2[0] = Items.FIREWORK_ROCKET;
        items = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items2);
        ItemPacketHelper.INSTANCE.updateValue();
        if (stackServiceComponent2.isActive()) {
            stackServiceComponent2.updateValue();
        } else {
            if (items.isActive()) {
                HandServiceComponent.executeAction(items.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, true);
            } else {
                MessageServiceComponent.S(INSTANCE, MessageServiceComponent.resolveString(INSTANCE, "no-fireworks", new Object[0], true), false);
                return;
            }
        }
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        PacketPacketHelper.handlePacket(((Packet) new class_2879(Hand.field_5808)));
        ItemPacketHelper.INSTANCE.updateValue2();
        HandServiceComponent.executeAction(items.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, true);
    }

    private static void executeAction(boolean arg0, boolean arg1) {
        if (Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) {
            int index = INSTANCE.computeValue();
            if (index != -1) {
                if (index >= 36) {
                } else {
                }
                int index2 = 4;
                ItemStack stack = (index - 36).method_5438(index).method_7972();
                class_1661 class1661 = SharedKt.getPlayer().method_31548();
                int index3 = 0;
                MessageServiceComponent.e(MessageServiceComponent.Z(INSTANCE, "done-chestplate", new Object[0], false), OptionMode16.SUCCESS, index3, class1661, stack, index2);
                INSTANCE.executeAction(index, false);
                TitleRenderHelper.INSTANCE.updateValue(true);
                INSTANCE.updateValue2();
                TitleRenderHelper.INSTANCE.updateValue(false);
            } else {
                if (INSTANCE) {
                    INSTANCE.executeAction(MessageServiceComponent.Z(INSTANCE, "no-chestplate", new Object[0], false));
                } else {
                    MessageServiceComponent.S(INSTANCE, MessageServiceComponent.Z(INSTANCE, "no-chestplate", new Object[0], false), false);
                    index = INSTANCE.computeValue();
                    if (index != -1) {
                        if (index >= 36) {
                        } else {
                        }
                        index2 = 4;
                        stack = (index - 36).method_5438(index).method_7972();
                        class1661 = SharedKt.getPlayer().method_31548();
                        index3 = 0;
                        MessageServiceComponent.e(MessageServiceComponent.Z(INSTANCE, "done-elytra", new Object[0], false), OptionMode16.SUCCESS, index3, class1661, stack, index2);
                        INSTANCE.executeAction(index, true);
                        TitleRenderHelper.INSTANCE.updateValue(true);
                        INSTANCE.updateValue2();
                        TitleRenderHelper.INSTANCE.updateValue(false);
                    } else {
                        if (INSTANCE) {
                            INSTANCE.executeAction(MessageServiceComponent.resolveString(INSTANCE, "no-elytra", new Object[0], true));
                        } else {
                            MessageServiceComponent.S(INSTANCE, MessageServiceComponent.resolveString(INSTANCE, "no-elytra", new Object[0], true), false);
                        }
                    }
                }
            }
        } else {
        }
    }

    private static void executeAction2() {
        if (Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA)) {
            if (SharedKt.getPlayer().isFallFlying()) {
                SharedKt.getMc().options.field_1903.method_23481(false);
            } else {
                SharedKt.getMc().options.field_1903.method_23481(!(((SharedKt.getPlayer().field_6012 - countValue) % 2)));
                INSTANCE.executeAction();
                SharedKt.getMc().options.field_1903.method_23481(true);
                INSTANCE.executeAction();
            }
        } else {
        }
    }

    static {
        KProperty[] items = new KProperty[8];
        INSTANCE = new ElytraSwapModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", ElytraSwapMode.ENABLE);
        switchButtonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch-button", new KeyRecord(0, false, false), null, this::isActive2);
        fireWorkButtonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-work-button", new KeyRecord(0, false, false), null, this::isActive3);
        startFireWorkSetting = VisibleRenderHelper.registerSetting(INSTANCE, "start-fire-work", false, null, this::isActive4);
        fireWorkModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-work-mode", ElytraSwapFireWorkMode.SILENT, null, this::isActive5);
        swapModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-mode", ElytraSwapSwapMode.ALT);
        hotBarSwapModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hotbar-swap-mode", ElytraSwapHotBarSwapMode.DEFAULT);
        swapOnLandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-on-land", false, null, this::isActive6);
        items = new Item[6];
        items[0] = Items.NETHERITE_CHESTPLATE;
        items[1] = Items.DIAMOND_CHESTPLATE;
        items[2] = Items.CHAINMAIL_CHESTPLATE;
        items[3] = Items.IRON_CHESTPLATE;
        items[4] = Items.GOLDEN_CHESTPLATE;
        items[5] = Items.LEATHER_CHESTPLATE;
        minecraftRefArray = items;
    }

    public static void updateValue2(boolean arg0) {
        enabledFlag3 = arg0;
    }

    public static boolean isActive7() {
        return enabledFlag3;
    }

    public static boolean isActive8() {
        return true;
        return false;
    }

}
