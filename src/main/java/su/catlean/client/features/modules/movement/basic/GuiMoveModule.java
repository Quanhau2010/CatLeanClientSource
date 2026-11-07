package su.catlean.client.features.modules.movement.basic;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_2371;
import net.minecraft.class_241;
import net.minecraft.class_2645;
import net.minecraft.class_2813;
import net.minecraft.class_2815;
import net.minecraft.class_2828.class_2829;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_3675;
import net.minecraft.class_3675.class_306;
import net.minecraft.class_3944;
import net.minecraft.class_408;
import net.minecraft.class_744;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.math.Box;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.ClickSlotEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.mappings.GuiMoveClickBypassModeWhenMappings;
import su.catlean.client.ui.clickgui.ActionTypeGuiElement;
import su.catlean.mixins.accessors.ClientInputAccessor;

public class GuiMoveModule extends Module {

    public static final GuiMoveModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 clickBypassSetting;
    private static List itemList;
    private static final LinkedList linkedList;
    private static final AtomicBoolean atomicBoolean;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static int countValue;
    private static boolean enabledFlag3;
    private static boolean enabledFlag4;
    private static final Map lookupMap;
    private static final Map lookupMap2;
    private static boolean enabledFlag5;
    private static Module[] moduleArray;

    private GuiMoveModule() {
        super("gui-move", SubCategoriesKt.getBasicMovementCategory());
    }

    public GuiMoveClickBypassMode getClickBypass() {
        return ((GuiMoveClickBypassMode) clickBypassSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public Map getMap() {
        return lookupMap;
    }

    public Map getMap2() {
        return lookupMap2;
    }

    public boolean isActive() {
        return enabledFlag5;
    }

    public void updateValue(boolean value) {
        enabledFlag5 = value;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (itemList.isEmpty()) {
            KeyBinding[] items = new KeyBinding[6];
            items[0] = SharedKt.getMc().options.field_1894;
            items[1] = SharedKt.getMc().options.field_1881;
            items[2] = SharedKt.getMc().options.field_1913;
            items[3] = SharedKt.getMc().options.field_1849;
            items[4] = SharedKt.getMc().options.field_1903;
            items[5] = SharedKt.getMc().options.field_1867;
            itemList = CollectionsKt.listOf(items);
        }
        if (enabledFlag4) {
        }
        if (this.getClickBypass() != GuiMoveClickBypassMode.LEGIT && SharedKt.getMc().currentScreen != null && !(SharedKt.getMc().currentScreen instanceof class_408)) {
            items = ((Iterable) itemList);
            int index = 0;
            Iterator iterator = items.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                KeyBinding keyBinding = ((KeyBinding) element);
                keyBinding.method_23481(ServiceComponent13.checkCondition(class_3675.method_15981(keyBinding.method_1428()).method_1444()));
            }
        }
        if (this.getClickBypass() == GuiMoveClickBypassMode.LEGIT && !(((Collection) linkedList).isEmpty())) {
            if (!(enabledFlag)) {
            }
        }
        SprintModule.INSTANCE.updateValue(true);
        enabledFlag3 = SharedKt.getPlayer().method_5624();
        SharedKt.getPlayer().method_5728(false);
        EventPacketHelper2.INSTANCE.updateValue5();
        countValue = 1;
        SprintModule.INSTANCE.updateValue(true);
        atomicBoolean.set(true);
        this.executeAction(lookupMap2);
        this.executeAction(lookupMap);
        if (!(linkedList.isEmpty())) {
            index = ((ActionTypeGuiElement) linkedList.poll());
            if (SharedKt.getMc().interactionManager != null) {
                SharedKt.getMc().interactionManager.method_2906(index.getNumericValue(), index.getNumericValue2(), index.getNumericValue3(), index.getMinecraftObject(), ((PlayerEntity) SharedKt.getPlayer()));
            }
        }
        PacketPacketHelper.handlePacket(((Packet) new class_2815(SharedKt.getPlayer().field_7512.field_7763)));
        atomicBoolean.set(false);
        enabledFlag = 0;
        SprintModule.INSTANCE.updateValue(true);
        SharedKt.getPlayer().method_5728(enabledFlag3);
        EventPacketHelper2.INSTANCE.updateValue6();
        countValue = 0;
        this.executeAction(lookupMap2);
    }

    private void onClickSlotEvent(ClickSlotEvent arg0) {
        if (enabledFlag5 || atomicBoolean.get()) {
            return;
        }
        if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
            if (SharedKt.getMc().options.field_1903.method_1434()) {
                if (SharedKt.getPlayer().isFallFlying()) {
                    enabledFlag4 = 1;
                    return;
                }
            }
        }
        this.executeAction(arg0.getSyncId(), arg0.getId(), arg0.getButton(), arg0.getAction(), ((PlayerEntity) SharedKt.getPlayer()));
        if (this.getClickBypass() == GuiMoveClickBypassMode.STRICT_NCP) {
        } else {
        }
        double offset = 2.71875E-7D;
        if (SharedKt.getPlayer().method_5624()) {
            PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12985)));
            enabledFlag2 = 1;
        }
        PacketPacketHelper.handlePacket(((Packet) new class_2829(SharedKt.getPlayer().getX(), (SharedKt.getPlayer().getY() + offset), SharedKt.getPlayer().getZ(), false, SharedKt.getPlayer().field_5976)));
        this.executeAction(arg0.getSyncId(), arg0.getId(), arg0.getButton(), arg0.getAction(), ((PlayerEntity) SharedKt.getPlayer()));
        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12985)));
        SharedKt.getMc().options.field_1894.method_23481(false);
        ((ClientInputAccessor) SharedKt.getPlayer().field_3913).setMoveVector(new class_241(SharedKt.getPlayer().field_3913.method_3128().field_1343, 0.0F));
        if (SharedKt.getPlayer().field_7512.field_7761.size() != 46) {
            return;
        }
        if (linkedList.isEmpty()) {
            this.executeAction(lookupMap);
        }
        this.executeAction(arg0.getSyncId(), arg0.getId(), arg0.getButton(), arg0.getAction(), ((PlayerEntity) SharedKt.getPlayer()));
        linkedList.add(new ActionTypeGuiElement(arg0.getSyncId(), arg0.getId(), arg0.getButton(), arg0.getAction()));
        arg0.cancel();
        arg0.cancel();
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (enabledFlag5) {
            return;
        }
        if (arg0.getPacket() instanceof class_2645) {
            enabledFlag4 = 0;
            if (this.getClickBypass() == GuiMoveClickBypassMode.DISABLE_CLICKS) {
                arg0.cancel();
            }
            if (this.getClickBypass() == GuiMoveClickBypassMode.LEGIT && !(atomicBoolean.get()) && !(((Collection) linkedList).isEmpty())) {
                arg0.cancel();
                enabledFlag = 1;
            }
        }
        enabledFlag4 = 1;
    }

    private void onSendPacket(SendPacket arg0) {
        if (enabledFlag5) {
            return;
        }
        enabledFlag4 = 0;
        if (this.getClickBypass() == GuiMoveClickBypassMode.DISABLE_CLICKS) {
            arg0.cancel();
        }
        if (!(((Collection) linkedList).isEmpty())) {
            enabledFlag = 1;
        }
        arg0.cancel();
    }

    private void onAfterSendPacket(AfterSendPacket arg0) {
        if (enabledFlag5) {
            return;
        }
        PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12981)));
        enabledFlag2 = 0;
    }

    private void executeAction(int arg0, int arg1, int arg2, class_1713 arg3, PlayerEntity arg4) {
        arg4.field_7512.method_7593(arg1, arg2, arg3, arg4);
    }

    private void executeAction(Map arg0) {
        int index = 0;
        arg0.put(Integer.valueOf(index), SharedKt.getPlayer().field_7512.method_7611(index).method_7677().method_7972());
    }

    private void executeAction(Map arg0, int arg1) {
        int index = 0;
        if (index < 46) {
            SharedKt.getPlayer().field_7512.method_7619(index, SharedKt.getPlayer().field_7512.method_37421(), ((ItemStack) arg0.get(Integer.valueOf(index))));
        }
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new GuiMoveModule();
        clickBypassSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bypass", GuiMoveClickBypassMode.NONE);
        itemList = CollectionsKt.emptyList();
        linkedList = new LinkedList();
        atomicBoolean = new AtomicBoolean();
        lookupMap = ((Map) new LinkedHashMap());
        lookupMap2 = ((Map) new LinkedHashMap());
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
