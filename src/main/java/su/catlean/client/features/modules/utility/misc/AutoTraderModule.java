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
        return (Boolean) buySetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private ItemsServiceComponent2 getBuyItem() {
        return (ItemsServiceComponent2) buyItemSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setBuyItem(ItemsServiceComponent2 value) {
        buyItemSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private boolean getSell() {
        return (Boolean) sellSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private ItemsServiceComponent2 getSellItem() {
        return (ItemsServiceComponent2) sellItemSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setSellItem(ItemsServiceComponent2 value) {
        sellItemSetting.setValue(this, DELEGATED_PROPERTIES[3], value);
    }

    private int getInteractDelay() {
        return (Number) interactDelaySetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setInteractDelay(int value) {
        interactDelaySetting.setValue(this, DELEGATED_PROPERTIES[4], Integer.valueOf(value));
    }

    private int getTradeDelay() {
        return (Number) tradeDelaySetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private void setTradeDelay(int value) {
        tradeDelaySetting.setValue(this, DELEGATED_PROPERTIES[5], Integer.valueOf(value));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (countValue > 0) {
            int var26 = countValue;
            countValue = (var26 + -1);
        }
        if (countValue2 > 0) {
            var26 = countValue2;
            countValue2 = (var26 + -1);
            return;
        }
        lookupMap.entrySet().removeIf(this::checkCondition);
        if (SharedKt.getMc().currentScreen instanceof class_492) {
            var26 = (class_492) SharedKt.getMc().currentScreen;
            class_1728 var27 = (class_1728) var26.method_17577();
            class_1916 var28 = var27.method_17438();
            int var29 = 0;
            int var30 = (Collection) var28.size();
            if (var29 < var30) {
                class_1914 var31 = (class_1914) var28.get();
                if (this.checkCondition()) {
                    var27.method_20215();
                    var27.method_7650();
                    PacketPacketHelper.handlePacket((Packet) new class_2863());
                    GuiMoveModule.INSTANCE.updateValue(1);
                    HandServiceComponent.e(2, 0, class_1713.field_7794);
                    GuiMoveModule.INSTANCE.updateValue(0);
                    countValue2 = this.getTradeDelay();
                    return;
                }
                if (!(var27.method_7611(0).method_7677().isEmpty())) {
                    GuiMoveModule.INSTANCE.updateValue(1);
                    HandServiceComponent.e(0, 0, class_1713.field_7794);
                    GuiMoveModule.INSTANCE.updateValue(0);
                    countValue2 = this.getTradeDelay();
                    return;
                }
                if (!(var27.method_7611(1).method_7677().isEmpty())) {
                    GuiMoveModule.INSTANCE.updateValue(1);
                    HandServiceComponent.e(1, 0, class_1713.field_7794);
                    GuiMoveModule.INSTANCE.updateValue(0);
                    countValue2 = this.getTradeDelay();
                    return;
                }
                lookupMap.put(Integer.valueOf(countValue3), Integer.valueOf(SharedKt.getPlayer().field_6012));
            }
            SharedKt.getPlayer().method_7346();
        } else {
            var27 = SharedKt.getWorld().method_18112();
            var28 = 0;
            var29 = var27;
            var30 = (Collection) new ArrayList();
            var31 = 0;
            Iterator iterator = var29.iterator();
            while (iterator.hasNext()) {
                Object var33 = iterator.next();
                Entity entity = var33;
                int var35 = 0;
                var30.add();
            }
            var27 = (Iterable) var30;
            var28 = 0;
            var29 = var27.iterator();
            if (!(var29.hasNext())) {
            } else {
                var30 = var29.next();
                if (!(var29.hasNext())) {
                } else {
                    var31 = var30;
                    iterator = 0;
                    var31 = var31.distanceTo(SharedKt.getPlayer());
                    iterator = var29.next();
                    var33 = iterator;
                    entity = 0;
                    var33 = var33.distanceTo(SharedKt.getPlayer());
                    if (Float.compare() > 0) {
                        var30 = iterator;
                        var31 = var33;
                    }
                }
            }
            var26 = var30;
            SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(var26.getEyePos().method_1031((Math.random() * 0.2D), 0.0D, (Math.random() * 0.2D))), 0, this::resolveUnit));
        }
    }

    private boolean checkCondition(short arg0, class_1914 arg1, int arg2, short arg3) {
        Iterator iterator = this.getBuyItem().getList().iterator();
        if (iterator.hasNext()) {
            Item var25 = (Item) iterator.next();
            boolean var26 = Intrinsics.areEqual(arg1.method_8250().getItem());
            int var20 = 2;
            int var21 = 0;
            Item var22 = arg1.method_19272().getItem();
            boolean var27 = arg1.method_19272().method_7947() <= ItemPacketHelper.computeValue();
            if (arg0 >= 0) {
                if (var23) {
                }
            }
            if (arg0 >= 0) {
                if (var23) {
                }
            }
            boolean var28 = this.getBuy();
            if (var28) {
                if (arg2 >= 0) {
                    if (var23) {
                        if (!(var27)) {
                        }
                    }
                }
            }
            return true;
        }
        iterator = this.getSellItem().getList().iterator();
        if (arg2 >= 0) {
            if (iterator.hasNext()) {
            }
            var25 = (Item) iterator.next();
            var26 = Intrinsics.areEqual(arg1.method_19272().getItem());
            if (arg0 >= 0) {
                if (var23) {
                }
                var20 = 2;
                var21 = 0;
                var22 = arg1.method_19272().getItem();
                var27 = arg1.method_19272().method_7947() <= ItemPacketHelper.computeValue();
                if (arg0 >= 0) {
                    if (var23) {
                        if (var26) {
                        }
                    }
                    if (arg0 >= 0) {
                        if (var23) {
                            if (!(arg1.method_8255())) {
                            }
                        }
                    }
                } else {
                }
            }
            var28 = this.getSell();
            if (var28) {
                if (arg3 > 0) {
                    if (var23) {
                        if (!(var27)) {
                        }
                    }
                }
            }
            return true;
        }
        }
        return false;
    }

    private static boolean checkCondition(Entry arg0) {
        int var6 = (Number) arg0.getValue();
        if (var5) {
            if ((SharedKt.getPlayer().field_6012 - var6) > 160) {
            }
        } else {
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static Unit resolveUnit(Entity arg0) {
        SharedKt.getInteractionManager().method_2905((PlayerEntity) SharedKt.getPlayer(), arg0, Hand.field_5808);
        countValue3 = arg0.method_5628();
        countValue = INSTANCE.getInteractDelay();
        return Unit.INSTANCE;
    }

    static {
        KProperty[] var32 = new KProperty[6];
        INSTANCE = new AutoTraderModule();
        buySetting = VisibleRenderHelper.registerSetting(INSTANCE, "buy");
        buyItemSetting = VisibleRenderHelper.registerSetting(INSTANCE, "buy-item", new ItemsServiceComponent2());
        sellSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sell");
        sellItemSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sell-item", new ItemsServiceComponent2());
        interactDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-delay", 12, new IntRange(0, 40));
        tradeDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "trade-delay", 3, new IntRange(0, 40));
        lookupMap = (Map) new LinkedHashMap();
    }

}
