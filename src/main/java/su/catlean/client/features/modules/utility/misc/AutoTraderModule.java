package su.catlean.client.features.modules.utility.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1646;
import net.minecraft.class_1713;
import net.minecraft.class_1728;
import net.minecraft.class_1735;
import net.minecraft.class_1914;
import net.minecraft.class_1916;
import net.minecraft.class_2863;
import net.minecraft.class_492;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl8;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.ItemsServiceComponent2;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.CatleanInterfaceRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoTraderModule extends Module {

    public static final AutoTraderModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl buySetting;
    private static final DefaultValueVisibleSettingPropertyImpl8 buyItemSetting;
    private static final VisibleVisibleSettingPropertyImpl sellSetting;
    private static final DefaultValueVisibleSettingPropertyImpl8 sellItemSetting;
    private static final RangeVisibleSettingPropertyImpl interactDelaySetting;
    private static final RangeVisibleSettingPropertyImpl tradeDelaySetting;
    private static int countValue;
    private static int countValue2;
    private static int countValue3;
    private static final Map lookupMap;

    private AutoTraderModule() {
        super("auto-trader", SubCategoriesKt.getMiscUtilityCategory());
    }

    private boolean getBuy() {
        return ((Boolean) buySetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private ItemsServiceComponent2 getBuyItem() {
        return ((ItemsServiceComponent2) buyItemSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setBuyItem(ItemsServiceComponent2 value) {
        buyItemSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private boolean getSell() {
        return ((Boolean) sellSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private ItemsServiceComponent2 getSellItem() {
        return ((ItemsServiceComponent2) sellItemSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setSellItem(ItemsServiceComponent2 value) {
        sellItemSetting.setValue(this, DELEGATED_PROPERTIES[3], value);
    }

    private int getInteractDelay() {
        return ((Number) interactDelaySetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void setInteractDelay(int value) {
        interactDelaySetting.setValue(this, DELEGATED_PROPERTIES[4], Integer.valueOf(value));
    }

    private int getTradeDelay() {
        return ((Number) tradeDelaySetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private void setTradeDelay(int value) {
        tradeDelaySetting.setValue(this, DELEGATED_PROPERTIES[5], Integer.valueOf(value));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (countValue > 0) {
            int index = countValue;
            countValue = (index + -1);
        }
        if (countValue2 > 0) {
            index = countValue2;
            countValue2 = (index + -1);
            return;
        }
        lookupMap.entrySet().removeIf(this::checkCondition);
        if (SharedKt.getMc().currentScreen instanceof class_492) {
            index = ((class_492) SharedKt.getMc().currentScreen);
            class_1728 class1728 = ((class_1728) index.method_17577());
            class_1916 class1916 = class1728.method_17438();
            int index2 = 0;
            int index3 = ((Collection) class1916).size();
            if (index2 < index3) {
                class_1914 class1914 = ((class_1914) class1916.get(index2));
                if (this.checkCondition(class1914)) {
                    class1728.method_20215(index2);
                    class1728.method_7650(index2);
                    PacketPacketHelper.handlePacket(((Packet) new class_2863(index2)));
                    GuiMoveModule.INSTANCE.updateValue(true);
                    HandServiceComponent.e(2, 0, class_1713.field_7794, false);
                    GuiMoveModule.INSTANCE.updateValue(false);
                    countValue2 = this.getTradeDelay();
                    return;
                }
                if (!(class1728.method_7611(0).method_7677().isEmpty())) {
                    GuiMoveModule.INSTANCE.updateValue(true);
                    HandServiceComponent.e(0, 0, class_1713.field_7794, false);
                    GuiMoveModule.INSTANCE.updateValue(false);
                    countValue2 = this.getTradeDelay();
                    return;
                }
                if (!(class1728.method_7611(1).method_7677().isEmpty())) {
                    GuiMoveModule.INSTANCE.updateValue(true);
                    HandServiceComponent.e(1, 0, class_1713.field_7794, false);
                    GuiMoveModule.INSTANCE.updateValue(false);
                    countValue2 = this.getTradeDelay();
                    return;
                }
                lookupMap.put(Integer.valueOf(countValue3), Integer.valueOf(SharedKt.getPlayer().field_6012));
            }
            SharedKt.getPlayer().method_7346();
        } else {
            class1728 = SharedKt.getWorld().method_18112();
            class1916 = 0;
            index2 = class1728;
            index3 = ((Collection) new ArrayList());
            class1914 = 0;
            Iterator iterator = index2.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                Entity entity = element;
                index3.add(element);
            }
            class1728 = ((Iterable) index3);
            class1916 = 0;
            index2 = class1728.iterator();
            if (!(index2.hasNext())) {
            } else {
                index3 = index2.next();
                if (!(index2.hasNext())) {
                } else {
                    class1914 = index3;
                    iterator = 0;
                    class1914 = class1914.distanceTo(SharedKt.getPlayer());
                    iterator = index2.next();
                    element = iterator;
                    entity = 0;
                    element = element.distanceTo(SharedKt.getPlayer());
                    if (Float.compare(class1914, element) > 0) {
                        index3 = iterator;
                        class1914 = element;
                    }
                }
            }
            index = index3;
            SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(index.getEyePos().method_1031((Math.random() * 0.2D), 0.0D, (Math.random() * 0.2D))), 0, this::resolveUnit));
        }
    }

    private boolean checkCondition(short arg0, class_1914 arg1, int arg2, short arg3) {
        Iterator iterator = this.getBuyItem().getList().iterator();
        while (iterator.hasNext()) {
            Item item = ((Item) iterator.next());
            boolean flag = Intrinsics.areEqual(arg1.method_8250().getItem(), item);
            int index = 2;
            int index2 = 0;
            Item item2 = arg1.method_19272().getItem();
            boolean flag2 = arg1.method_19272().method_7947() <= ItemPacketHelper.computeValue(item2, index2, index);
            if (arg0 >= 0) {
                if (__UNDEF_KEY__) {
                }
            }
            if (arg0 >= 0) {
                if (__UNDEF_KEY__) {
                }
            }
            boolean flag3 = this.getBuy();
            if (flag3) {
                if (arg2 >= 0) {
                    if (__UNDEF_KEY__) {
                        if (!(flag2)) {
                        }
                    }
                }
            }
            return true;
        }
        iterator = this.getSellItem().getList().iterator();
        if (arg2 >= 0) {
            while (iterator.hasNext()) {
                item = ((Item) iterator.next());
                flag = Intrinsics.areEqual(arg1.method_19272().getItem(), item);
                if (arg0 >= 0) {
                    if (__UNDEF_KEY__) {
                        index = 2;
                        index2 = 0;
                        item2 = arg1.method_19272().getItem();
                        flag2 = arg1.method_19272().method_7947() <= ItemPacketHelper.computeValue(item2, index2, index);
                        if (arg0 >= 0) {
                            if (__UNDEF_KEY__) {
                                if (flag) {
                                    if (arg0 >= 0) {
                                        if (__UNDEF_KEY__) {
                                            if (!(arg1.method_8255())) {
                                            } else {
                                                flag3 = this.getSell();
                                            }
                                        }
                                    }
                                } else {
                                }
                            }
                        }
                        if (flag3) {
                            if (arg3 > 0) {
                                if (__UNDEF_KEY__) {
                                    if (!(flag2)) {
                                    }
                                }
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkCondition(Entry arg0) {
        int index = ((Number) arg0.getValue());
        if (__UNDEF_KEY__) {
            if ((SharedKt.getPlayer().field_6012 - index) > 160) {
            } else {
            }
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static Unit resolveUnit(Entity arg0) {
        SharedKt.getInteractionManager().method_2905(((PlayerEntity) SharedKt.getPlayer()), arg0, Hand.field_5808);
        countValue3 = arg0.method_5628();
        countValue = INSTANCE.getInteractDelay();
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[6];
        INSTANCE = new AutoTraderModule();
        buySetting = VisibleRenderHelper.registerSetting(INSTANCE, "buy", true);
        buyItemSetting = VisibleRenderHelper.registerSetting(INSTANCE, "buy-item", new ItemsServiceComponent2());
        sellSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sell", false);
        sellItemSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sell-item", new ItemsServiceComponent2());
        interactDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-delay", 12, new IntRange(0, 40));
        tradeDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "trade-delay", 3, new IntRange(0, 40));
        lookupMap = ((Map) new LinkedHashMap());
    }

}
