package su.catlean.client.features.modules.utility.equip;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1661;
import net.minecraft.class_1743;
import net.minecraft.class_1794;
import net.minecraft.class_1821;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ItemServiceComponent4;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class ToolSaverModule extends Module {

    public static final ToolSaverModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl savePercentSetting;

    private ToolSaverModule() {
        super("tool-saver", SubCategoriesKt.getEquipCategory());
    }

    private int getSavePercent() {
        return ((Number) savePercentSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        ItemStack stack = SharedKt.getPlayer().method_6047();
        if (!(ItemServiceComponent4.checkCondition2(stack)) && !(ItemServiceComponent4.checkCondition(stack)) && !(stack.getItem() instanceof class_1743) && !(stack.getItem() instanceof class_1794) && !(stack.getItem() instanceof class_1821)) {
            return;
        }
        int index = (stack.method_7936() - stack.method_7919());
        int index2 = ((index / stack.method_7936()) * 100.0F);
        SharedKt.getPlayer().method_31548().method_61496(((SharedKt.getPlayer().method_31548().method_67532() + 1) % 8));
        MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "switch-message", new Object[0], false), false);
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new ToolSaverModule();
        savePercentSetting = VisibleRenderHelper.registerSetting(INSTANCE, "save-percent", 10, new IntRange(1, 50));
    }

}
