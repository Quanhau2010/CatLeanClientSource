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
        return (ActionServiceComponent2) openManagerSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setOpenManager(ActionServiceComponent2 value) {
        openManagerSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private static void executeAction() {
    }

    private ItemsServiceComponent2 getCleanerList() {
        return (ItemsServiceComponent2) cleanerListSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setCleanerList(ItemsServiceComponent2 value) {
        cleanerListSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private int getActionDelay() {
        return (Number) actionDelaySetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setActionDelay(int value) {
        actionDelaySetting.setValue(this, DELEGATED_PROPERTIES[2], Integer.valueOf(value));
    }

    private int getClicksPerAction() {
        return (Number) clicksPerActionSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setClicksPerAction(int value) {
        clicksPerActionSetting.setValue(this, DELEGATED_PROPERTIES[3], Integer.valueOf(value));
    }

    private InventoryManagerCleanerMode getCleaner() {
        return (InventoryManagerCleanerMode) cleanerSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private int getCleanerDelay() {
        return (Number) cleanerDelaySetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getCleanChests() {
        return (Boolean) cleanChestsSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (countValue > 0) {
            int var18 = countValue;
            countValue = (var18 + -1);
            return;
        }
        if (ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().isEmpty()) {
            return;
        }
        var18 = 0;
        Iterator iterator = this.resolveArrayList(SharedKt.getPlayer().field_7512).iterator();
        if (iterator.hasNext()) {
            int var20 = (Number) iterator.next();
            HandServiceComponent.e();
        }
        countValue = this.getActionDelay();
    }

    private int computeValue(Item arg0, class_1703 arg1, long arg2, IntRange arg3) {
        if (Intrinsics.areEqual(arg1.method_34255().getItem(), arg0)) {
            return -2;
        }
        IntRange var14 = this.resolveIntRange(arg1.field_7761.size());
        int var15 = arg3.getFirst();
        int var16 = arg3.getLast();
        if (Intrinsics.areEqual(arg1.method_7611().method_7677().getItem(), arg0)) {
            if (!(arg3.getFirst())) {
            } else {
            }
            if (arg2 >= 0L) {
                if (var13 != null) {
                    if (!(Intrinsics.areEqual((var15 - arg3.getFirst()).get(Integer.valueOf((var14.getFirst() - 0))), arg0))) {
                        return var15;
                    }
                }
            }
        }
        if (var15 <= var16 && var15 != var16) {
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
        List<BlockPos> positions = new ArrayList();
        int var16 = arg0.field_7761.size();
        if (var16 != 46 && var16 != 63 && var16 != 90) {
            return positions;
        }
        Iterator iterator = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().keySet().iterator();
        while (iterator.hasNext()) {
            int var18 = (Number) iterator.next();
            Item var19 = (Item) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl3().resolveIdRecord4().getMap().get(Integer.valueOf());
            if (Intrinsics.areEqual(Items.field_8162)) {
            }
            int var20 = (var18 + this.resolveIntRange().getFirst());
            if (Intrinsics.areEqual((class_1735) arg0.field_7761.get().method_7677().getItem())) {
            }
            int var21 = this.computeValue(arg0, this.resolveIntRange());
            if (var21 == -2) {
                positions.add(Integer.valueOf());
            }
            positions.add(Integer.valueOf());
            positions.add(Integer.valueOf());
            positions.add(Integer.valueOf());
        }
        return positions;
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (SharedKt.getPlayer().field_7512 instanceof class_1707 && this.getCleanChests()) {
            class_1707 var24 = (class_1707) SharedKt.getPlayer().field_7512;
            String var25 = SharedKt.getMc().currentScreen.method_25440().getString();
            int var26 = 0;
            int var27 = var24.method_7629().method_5439();
            if (var26 < var27) {
                class_1735 var28 = var24.method_7611();
                if (var28.method_7681() && this.getCleanerList().getList().contains(var28.method_7677().getItem()) && !(StringsKt.contains$default((CharSequence) var25, (CharSequence) "\u0410\u0443\u043a\u0446\u0438\u043e\u043d")) && !(StringsKt.contains$default((CharSequence) var25, (CharSequence) "\u043f\u043e\u043a\u0443\u043f\u043a\u0438"))) {
                    this.executeAction();
                }
            }
        }
        if (this.getCleaner() == InventoryManagerCleanerMode.INVENTORY) {
            return;
        }
        if (this.getCleaner() == InventoryManagerCleanerMode.NOT_IN_INVENTORY && SharedKt.getMc().currentScreen instanceof class_490) {
            return;
        }
        var24 = 0;
        if (var24 < 36) {
            if (this.getCleanerList().getList().contains(SharedKt.getPlayer().method_31548().method_5438().getItem())) {
                if (var24 < 9) {
                } else {
                }
                (var24 + 36).executeAction();
            }
        }
        PacketPacketHelper.handlePacket((Packet) new class_2815(SharedKt.getPlayer().field_7512.field_7763));
        enabledFlag = 0;
    }

    public IdRecord4 resolveIdRecord4(String name) {
        Map var12 = (Map) new LinkedHashMap();
        int var13 = 9;
        if (var13 < 45) {
            var12.put(Integer.valueOf((var13 - 9)), (class_1735) SharedKt.getPlayer().field_7512.field_7761.get().method_7677().getItem());
        }
        return new IdRecord4(name);
    }

    private void executeAction(int arg0) {
        HandServiceComponent.e(arg0, 1, class_1713.field_7795);
        enabledFlag = 1;
    }

    private static Unit getUnit() {
        CatleanInterfaceRenderHelper.INSTANCE.updateValue((RenderHelper) new SelectRenderHelperImpl());
        return Unit.INSTANCE;
    }

    private static boolean isActive() {
        return INSTANCE.getCleaner() != InventoryManagerCleanerMode.OFF;
    }

    private static boolean isActive2() {
        return INSTANCE.getCleaner() != InventoryManagerCleanerMode.OFF;
    }

    static {
        KProperty[] var37 = new KProperty[7];
        INSTANCE = new InventoryManagerModule();
        openManagerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-manager", this::getUnit);
        cleanerListSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cleaner-list", new ItemsServiceComponent2());
        actionDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "action-delay", 0, new IntRange(0, 10));
        clicksPerActionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "click-per-action", 1, new IntRange(1, 3));
        cleanerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cleaner", InventoryManagerCleanerMode.OFF);
        cleanerDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "cleaner-delay", 50, new IntRange(0, 500), null, this::isActive);
        cleanChestsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "clean-chests", 0, null, this::isActive2);
        serviceComponent10 = new ServiceComponent10();
    }

}
