package su.catlean.client.features.modules.utility.equip;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_1263;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_2371;
import net.minecraft.class_2561;
import net.minecraft.class_2815;
import net.minecraft.class_490;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl8;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ActionServiceComponent2;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.ItemsServiceComponent2;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl3;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.config.models.IdRecord4;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.CatleanInterfaceRenderHelper;
import su.catlean.client.services.render.RenderHelper;
import su.catlean.client.services.render.SelectRenderHelperImpl;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class InventoryManagerModule extends Module {

    public static final InventoryManagerModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl openManagerSetting;
    private static final DefaultValueVisibleSettingPropertyImpl8 cleanerListSetting;
    private static final RangeVisibleSettingPropertyImpl actionDelaySetting;
    private static final RangeVisibleSettingPropertyImpl clicksPerActionSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 cleanerSetting;
    private static final RangeVisibleSettingPropertyImpl cleanerDelaySetting;
    private static final VisibleVisibleSettingPropertyImpl cleanChestsSetting;
    private static final ServiceComponent10 serviceComponent10;
    private static boolean enabledFlag;
    private static int countValue;

    private InventoryManagerModule() {
        super("inventory-manager", SubCategoriesKt.getEquipCategory());
    }

    private ActionServiceComponent2 getOpenManager() {
        return ((ActionServiceComponent2) openManagerSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setOpenManager(ActionServiceComponent2 value) {
        openManagerSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private static void executeAction() {
    }

    private ItemsServiceComponent2 getCleanerList() {
        return ((ItemsServiceComponent2) cleanerListSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setCleanerList(ItemsServiceComponent2 value) {
        cleanerListSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private int getActionDelay() {
        return ((Number) actionDelaySetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setActionDelay(int value) {
        actionDelaySetting.setValue(this, DELEGATED_PROPERTIES[2], Integer.valueOf(value));
    }

    private int getClicksPerAction() {
        return ((Number) clicksPerActionSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setClicksPerAction(int value) {
        clicksPerActionSetting.setValue(this, DELEGATED_PROPERTIES[3], Integer.valueOf(value));
    }

    private InventoryManagerCleanerMode getCleaner() {
        return ((InventoryManagerCleanerMode) cleanerSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private int getCleanerDelay() {
        return ((Number) cleanerDelaySetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getCleanChests() {
        return ((Boolean) cleanChestsSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (countValue > 0) {
            int index = countValue;
            countValue = (index + -1);
            return;
        }
        if (ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().isEmpty()) {
            return;
        }
        index = 0;
        Iterator iterator = this.resolveArrayList(SharedKt.getPlayer().field_7512).iterator();
        while (iterator.hasNext()) {
            int index2 = ((Number) iterator.next());
            HandServiceComponent.e(index2, 0, null, false);
        }
        countValue = this.getActionDelay();
    }

    private int computeValue(Item arg0, class_1703 arg1, long arg2, IntRange arg3) {
        if (Intrinsics.areEqual(arg1.method_34255().getItem(), arg0)) {
            return -2;
        }
        IntRange intRange = this.resolveIntRange(arg1.field_7761.size());
        int index = arg3.getFirst();
        int index2 = arg3.getLast();
        if (Intrinsics.areEqual(arg1.method_7611(index).method_7677().getItem(), arg0)) {
            if (!(arg3.getFirst())) {
            } else {
            }
            if (arg2 >= 0L) {
                if (__UNDEF_KEY__ != null) {
                    if (!(Intrinsics.areEqual((index - arg3.getFirst()).get(Integer.valueOf((intRange.getFirst() - 0))), arg0))) {
                        return index;
                    }
                }
            }
        }
        if (index <= index2 && index != index2) {
        }
        return -1;
    }

    private IntRange resolveIntRange(int arg0) {
        return new IntRange(0, 89);
    }

    private IntRange resolveIntRange(int arg0) {
        return new IntRange(54, 89);
    }

    private ArrayList resolveArrayList(class_1703 arg0) {
        List<BlockPos> list = new ArrayList();
        int index = arg0.field_7761.size();
        if (index != 46 && index != 63 && index != 90) {
            return list;
        }
        Iterator iterator = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().keySet().iterator();
        while (iterator.hasNext()) {
            int index2 = ((Number) iterator.next());
            Item item = ((Item) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().get(Integer.valueOf(index2)));
            if (Intrinsics.areEqual(item, Items.field_8162)) {
            }
            int index3 = (index2 + this.resolveIntRange(index).getFirst());
            if (Intrinsics.areEqual(((class_1735) arg0.field_7761.get(index3)).method_7677().getItem(), item)) {
            }
            int index4 = this.computeValue(item, arg0, this.resolveIntRange(index));
            if (index4 == -2) {
                list.add(Integer.valueOf(index3));
            }
            list.add(Integer.valueOf(index4));
            list.add(Integer.valueOf(index3));
            list.add(Integer.valueOf(index4));
        }
        return list;
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (SharedKt.getPlayer().field_7512 instanceof class_1707 && this.getCleanChests()) {
            class_1707 class1707 = ((class_1707) SharedKt.getPlayer().field_7512);
            String text = SharedKt.getMc().currentScreen.method_25440().getString();
            int index = 0;
            int index2 = class1707.method_7629().method_5439();
            if (index < index2) {
                class_1735 class1735 = class1707.method_7611(index);
                if (class1735.method_7681() && this.getCleanerList().getList().contains(class1735.method_7677().getItem()) && !(StringsKt.contains$default(((CharSequence) text), ((CharSequence) "\u0410\u0443\u043a\u0446\u0438\u043e\u043d"), false)) && !(StringsKt.contains$default(((CharSequence) text), ((CharSequence) "\u043f\u043e\u043a\u0443\u043f\u043a\u0438"), false))) {
                    this.executeAction(index);
                }
            }
        }
        if (this.getCleaner() == InventoryManagerCleanerMode.INVENTORY) {
            return;
        }
        if (this.getCleaner() == InventoryManagerCleanerMode.NOT_IN_INVENTORY && SharedKt.getMc().currentScreen instanceof class_490) {
            return;
        }
        class1707 = 0;
        if (class1707 < 36) {
            if (this.getCleanerList().getList().contains(SharedKt.getPlayer().method_31548().method_5438(class1707).getItem())) {
                if (class1707 < 9) {
                } else {
                }
                (class1707 + 36).executeAction(class1707);
            }
        }
        PacketPacketHelper.handlePacket(((Packet) new class_2815(SharedKt.getPlayer().field_7512.field_7763)));
        enabledFlag = 0;
    }

    public IdRecord4 resolveIdRecord4(String name) {
        Map map = ((Map) new LinkedHashMap());
        int index = 9;
        if (index < 45) {
            map.put(Integer.valueOf((index - 9)), ((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(index)).method_7677().getItem());
        }
        return new IdRecord4(name, map);
    }

    private void executeAction(int arg0) {
        HandServiceComponent.e(arg0, 1, class_1713.field_7795, false);
        enabledFlag = 1;
    }

    private static Unit getUnit() {
        CatleanInterfaceRenderHelper.INSTANCE.updateValue(((RenderHelper) new SelectRenderHelperImpl()));
        return Unit.INSTANCE;
    }

    private static boolean isActive() {
        return INSTANCE.getCleaner() != InventoryManagerCleanerMode.OFF;
    }

    private static boolean isActive2() {
        return INSTANCE.getCleaner() != InventoryManagerCleanerMode.OFF;
    }

    static {
        KProperty[] items = new KProperty[7];
        INSTANCE = new InventoryManagerModule();
        openManagerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-manager", this::getUnit);
        cleanerListSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cleaner-list", new ItemsServiceComponent2());
        actionDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "action-delay", 0, new IntRange(0, 10));
        clicksPerActionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "click-per-action", 1, new IntRange(1, 3));
        cleanerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cleaner", InventoryManagerCleanerMode.OFF);
        cleanerDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "cleaner-delay", 50, new IntRange(0, 500), null, this::isActive);
        cleanChestsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "clean-chests", false, null, this::isActive2);
        serviceComponent10 = new ServiceComponent10();
    }

}
