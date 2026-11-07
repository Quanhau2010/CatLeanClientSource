package su.catlean.client.features.modules.utility.equip;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1041;
import net.minecraft.class_11910;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_2371;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.client.InputEvent.Device;
import su.catlean.api.event.events.player.ClickSlotEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.mixins.accessors.MouseHandlerAccessor;

public class ItemScrollerModule extends Module {

    public static final ItemScrollerModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static final ServiceComponent10 serviceComponent10;

    private ItemScrollerModule() {
        super("item-scroller", SubCategoriesKt.getEquipCategory());
    }

    public int getDelay() {
        if (((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[0])) != null) {
        }
        return null;
    }

    public void setDelay(int value) {
        delaySetting.setValue(this, DELEGATED_PROPERTIES[0], Integer.valueOf(value));
    }

    private void onClickSlotEvent(ClickSlotEvent arg0) {
        if (!(ServiceComponent13.checkCondition(340))) {
        }
        if (!(ServiceComponent13.checkCondition(341))) {
        }
        if (ServiceComponent13.checkCondition(344) && ServiceComponent13.checkCondition(345) && arg0.getAction() == class_1713.field_7795 && !(enabledFlag2)) {
            Item item = ((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(arg0.getId())).method_7677().getItem();
            enabledFlag2 = 1;
            int index = 0;
            int index2 = SharedKt.getPlayer().field_7512.field_7761.size();
            if (index < index2) {
                if (Intrinsics.areEqual(((class_1735) SharedKt.getPlayer().field_7512.field_7761.get(index)).method_7677().getItem(), item)) {
                    HandServiceComponent.executeAction(index, 1, class_1713.field_7795, false);
                }
            }
            enabledFlag2 = 0;
        }
        if (!(ServiceComponent13.checkCondition(342))) {
        }
        if (!(ServiceComponent13.checkCondition(341))) {
        }
        enabledFlag2 = 1;
        item = 0;
        index = SharedKt.getPlayer().field_7512.field_7761.size();
        if (item < index) {
            HandServiceComponent.executeAction(item, 1, class_1713.field_7795, false);
        }
        enabledFlag2 = 0;
    }

    private void onInputEvent(InputEvent arg0) {
        enabledFlag = arg0.getAction() == Action.Press;
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        ((MouseHandlerAccessor) SharedKt.getMc().field_1729).iMouseClick(SharedKt.getMc().method_22683().method_4490(), new class_11910(0, 0), 0);
        ((MouseHandlerAccessor) SharedKt.getMc().field_1729).iMouseClick(SharedKt.getMc().method_22683().method_4490(), new class_11910(0, 1), 1);
        serviceComponent10.executeAction();
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new ItemScrollerModule();
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 75, new IntRange(0, 200));
        serviceComponent10 = new ServiceComponent10();
    }

}
