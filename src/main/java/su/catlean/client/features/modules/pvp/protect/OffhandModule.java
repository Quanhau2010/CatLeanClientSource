package su.catlean.client.features.modules.pvp.protect;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_10799;
import net.minecraft.class_124;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1541;
import net.minecraft.class_1548;
import net.minecraft.class_1661;
import net.minecraft.class_1674;
import net.minecraft.class_1701;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1819;
import net.minecraft.class_2237;
import net.minecraft.class_2561;
import net.minecraft.class_2663;
import net.minecraft.class_2846;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_2960;
import net.minecraft.class_3965;
import net.minecraft.class_476;
import net.minecraft.class_495;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.PostTasksProcessEvent;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.ClickSlotEvent;
import su.catlean.api.event.events.player.PostSyncEvent;
import su.catlean.api.event.events.player.UpdateSelectedSlotEvent;
import su.catlean.api.event.events.render.HotBarRenderEventPost;
import su.catlean.api.event.events.render.HotBarRenderEventPre;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl4;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.rage.ElytraTargetModule;
import su.catlean.client.features.modules.render.world.FreeCamModule;
import su.catlean.client.features.modules.utility.equip.ReFillerModule;
import su.catlean.client.features.modules.utility.misc.NotifierModule;
import su.catlean.client.features.modules.utility.player.NoInteractModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.ItemServiceComponent;
import su.catlean.client.services.client.ItemServiceComponent4;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent112;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.TextServiceComponent;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode14;
import su.catlean.mixins.accessors.MinecraftAccessor;

public class OffhandModule extends Module {

    public static final OffhandModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl delayBetweenSwapsSetting;
    private static final RangeVisibleSettingPropertyImpl2 totemHealthSetting;
    private static final RangeVisibleSettingPropertyImpl2 totemElytraHealthSetting;
    private static final VisibleVisibleSettingPropertyImpl outdatedSwapSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 offhandSetting;
    private static final VisibleVisibleSettingPropertyImpl bindSwapSetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 swapButtonSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 swapModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 swapGroupSetting;
    private static final DefaultValueVisibleSettingPropertyImpl4 notationSetting;
    private static final SettingIdVisibleSettingPropertyImpl swap1Setting;
    private static final SettingIdVisibleSettingPropertyImpl swap2Setting;
    private static final SettingIdVisibleSettingPropertyImpl swap3Setting;
    private static final SettingIdVisibleSettingPropertyImpl swap4Setting;
    private static final SettingIdVisibleSettingPropertyImpl swap5Setting;
    private static final SettingIdVisibleSettingPropertyImpl swap6Setting;
    private static final SettingIdVisibleSettingPropertyImpl swap7Setting;
    private static final SettingIdVisibleSettingPropertyImpl swap8Setting;
    private static final SettingIdVisibleSettingPropertyImpl swap9Setting;
    private static final VisibleVisibleSettingPropertyImpl hotBarSwapSetting;
    private static final VisibleVisibleSettingPropertyImpl resetAttackCooldownSetting;
    private static final VisibleVisibleSettingPropertyImpl saveEnchantedSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 rcGapSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 gapplePrioritySetting;
    private static final VisibleVisibleSettingPropertyImpl crappleSpoofSetting;
    private static final VisibleVisibleSettingPropertyImpl deathVerboseSetting;
    private static final VisibleVisibleSettingPropertyImpl containersSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 safetyFactorsSetting;
    private static final VisibleVisibleSettingPropertyImpl onCrystalInHandSetting;
    private static final VisibleVisibleSettingPropertyImpl onFallingSetting;
    private static final VisibleVisibleSettingPropertyImpl onMaceSetting;
    private static final VisibleVisibleSettingPropertyImpl onExlposiveEntitiesSetting;
    private static final VisibleVisibleSettingPropertyImpl onAnchorsSetting;
    private static final class_2960 minecraftRef;
    private static final class_2960 minecraftRef2;
    private static ItemStack itemStack;
    private static int countValue;
    private static int countValue2;
    private static AtomicBoolean atomicBoolean;
    private static int countValue3;
    private static final ServiceComponent10 serviceComponent10;
    private static ItemStack itemStack2;
    private static float factorValue;
    private static float factorValue2;
    private static float factorValue3;
    private static int[] countValueArray;

    private OffhandModule() {
        String[] items = new String[2];
        items[0] = "auto-totem";
        items[1] = "autototem";
        super("offhand", SubCategoriesKt.getProtectCategory(), CollectionsKt.listOf(items));
    }

    private int getDelayBetweenSwaps() {
        return ((Number) delayBetweenSwapsSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private float getTotemHealth() {
        return ((Number) totemHealthSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private float getTotemElytraHealth() {
        return ((Number) totemElytraHealthSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getOutdatedSwap() {
        return ((Boolean) outdatedSwapSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private OffhandOffhandMode getOffhand() {
        return ((OffhandOffhandMode) offhandSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getBindSwap() {
        return ((Boolean) bindSwapSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private KeyRecord getSwapButton() {
        return ((KeyRecord) swapButtonSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private OffhandSwapMode getSwapMode() {
        return ((OffhandSwapMode) swapModeSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private SettingGroup getSwapGroup() {
        return ((SettingGroup) swapGroupSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private TextServiceComponent getNotation() {
        return ((TextServiceComponent) notationSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private void setNotation(TextServiceComponent value) {
        notationSetting.setValue(this, DELEGATED_PROPERTIES[9], value);
    }

    private String getSwap1() {
        return ((String) swap1Setting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private void setSwap1(String value) {
        swap1Setting.setValue(this, DELEGATED_PROPERTIES[10], value);
    }

    private String getSwap2() {
        return ((String) swap2Setting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    private void setSwap2(String value) {
        swap2Setting.setValue(this, DELEGATED_PROPERTIES[11], value);
    }

    private String getSwap3() {
        return ((String) swap3Setting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    private void setSwap3(String value) {
        swap3Setting.setValue(this, DELEGATED_PROPERTIES[12], value);
    }

    private String getSwap4() {
        return ((String) swap4Setting.getValue(this, DELEGATED_PROPERTIES[13]));
    }

    private void setSwap4(String value) {
        swap4Setting.setValue(this, DELEGATED_PROPERTIES[13], value);
    }

    private String getSwap5() {
        return ((String) swap5Setting.getValue(this, DELEGATED_PROPERTIES[14]));
    }

    private void setSwap5(String value) {
        swap5Setting.setValue(this, DELEGATED_PROPERTIES[14], value);
    }

    private String getSwap6() {
        return ((String) swap6Setting.getValue(this, DELEGATED_PROPERTIES[15]));
    }

    private void setSwap6(String value) {
        swap6Setting.setValue(this, DELEGATED_PROPERTIES[15], value);
    }

    private String getSwap7() {
        return ((String) swap7Setting.getValue(this, DELEGATED_PROPERTIES[16]));
    }

    private void setSwap7(String value) {
        swap7Setting.setValue(this, DELEGATED_PROPERTIES[16], value);
    }

    private String getSwap8() {
        return ((String) swap8Setting.getValue(this, DELEGATED_PROPERTIES[17]));
    }

    private void setSwap8(String value) {
        swap8Setting.setValue(this, DELEGATED_PROPERTIES[17], value);
    }

    private String getSwap9() {
        return ((String) swap9Setting.getValue(this, DELEGATED_PROPERTIES[18]));
    }

    private void setSwap9(String value) {
        swap9Setting.setValue(this, DELEGATED_PROPERTIES[18], value);
    }

    private boolean getHotBarSwap() {
        return ((Boolean) hotBarSwapSetting.getValue(this, DELEGATED_PROPERTIES[19]));
    }

    private boolean getResetAttackCooldown() {
        return ((Boolean) resetAttackCooldownSetting.getValue(this, DELEGATED_PROPERTIES[20]));
    }

    private boolean getSaveEnchanted() {
        return ((Boolean) saveEnchantedSetting.getValue(this, DELEGATED_PROPERTIES[21]));
    }

    private OffhandRcGapMode getRcGap() {
        return ((OffhandRcGapMode) rcGapSetting.getValue(this, DELEGATED_PROPERTIES[22]));
    }

    private OffhandGapplePriorityMode getGapplePriority() {
        return ((OffhandGapplePriorityMode) gapplePrioritySetting.getValue(this, DELEGATED_PROPERTIES[23]));
    }

    private boolean getCrappleSpoof() {
        return ((Boolean) crappleSpoofSetting.getValue(this, DELEGATED_PROPERTIES[24]));
    }

    private boolean getDeathVerbose() {
        return ((Boolean) deathVerboseSetting.getValue(this, DELEGATED_PROPERTIES[25]));
    }

    private boolean getContainers() {
        return ((Boolean) containersSetting.getValue(this, DELEGATED_PROPERTIES[26]));
    }

    private SettingGroup getSafetyFactors() {
        return ((SettingGroup) safetyFactorsSetting.getValue(this, DELEGATED_PROPERTIES[27]));
    }

    private boolean getOnCrystalInHand() {
        return ((Boolean) onCrystalInHandSetting.getValue(this, DELEGATED_PROPERTIES[28]));
    }

    private boolean getOnFalling() {
        return ((Boolean) onFallingSetting.getValue(this, DELEGATED_PROPERTIES[29]));
    }

    private boolean getOnMace() {
        return ((Boolean) onMaceSetting.getValue(this, DELEGATED_PROPERTIES[30]));
    }

    private boolean getOnExlposiveEntities() {
        return ((Boolean) onExlposiveEntitiesSetting.getValue(this, DELEGATED_PROPERTIES[31]));
    }

    private boolean getOnAnchors() {
        return ((Boolean) onAnchorsSetting.getValue(this, DELEGATED_PROPERTIES[32]));
    }

    public int getNumericValue() {
        return countValue3;
    }

    public void updateValue(int value) {
        countValue3 = value;
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        if (!(this.getBindSwap()) || this.getSwapMode() != OffhandSwapMode.CUSTOM) {
            return;
        }
        int index = (arg0.getContext().method_51443() - 23);
        int index2 = ((arg0.getContext().method_51443() - 16) - 3);
        int index3 = (((arg0.getContext().method_51421() / 2) - 91) - 29);
        int index4 = 21;
        List list = this.resolveList();
        if (list.isEmpty()) {
            return;
        }
        Iterable iterable = ((Iterable) list);
        int index5 = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (index5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ItemStack stack = ((ItemStack) element);
            int index6 = (index3 - (index5 * index4));
            arg0.getContext().method_52706(class_10799.field_56883, minecraftRef2, index6, index, 29, 24);
            if (!(stack.isEmpty())) {
                arg0.getContext().method_51427(stack, (index6 + 3), index2);
            }
        }
        if (countValue == list.size()) {
            iterable = countValue;
            countValue = (iterable + -1);
        }
        iterable = (index3 - (((list.size() - countValue) - 1) * index4));
        arg0.getContext().method_52706(class_10799.field_56883, minecraftRef, (iterable - 1), index, 24, 23);
    }

    private void onPostTasksProcessEvent(PostTasksProcessEvent arg0) {
        if (!(this.checkCondition())) {
            return;
        }
        float factor = (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067());
        if (factor < factorValue3) {
            factorValue2 = factorValue;
            factorValue = (factorValue3 - factor);
        }
        factorValue3 = factor;
        this.executeAction(this.computeValue());
    }

    private void onPostSyncEvent(PostSyncEvent arg0) {
        if (this.checkCondition() && !(SharedKt.getPlayer().method_6115())) {
            ((MinecraftAccessor) SharedKt.getMc()).idoItemUse();
        }
        countValue3 = (countValue3 + -1);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (((class_2663) arg0.getPacket()).method_11470() != 3) {
        }
        this.updateValue();
    }

    private void onUpdateSelectedSlotEvent(UpdateSelectedSlotEvent arg0) {
        if (!(this.checkCondition()) || atomicBoolean.get()) {
            return;
        }
        int index = SharedKt.getPlayer().method_31548().method_67532();
        List list = this.resolveList();
        if (list.isEmpty()) {
            return;
        }
        Iterable iterable = ((Iterable) new IntRange(0, 8));
        int index2 = 0;
        if (iterable instanceof Collection && ((Collection) iterable).isEmpty()) {
        }
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            int index3 = ((IntIterator) iterator).nextInt();
            if (!(SharedKt.getMc().options.field_1852[index3].method_1436())) {
                if (SharedKt.getMc().options.field_1852[index3].method_1434()) {
                } else {
                }
            }
        }
        int index4 = 0;
        if (index4) {
            countValue = (arg0.getSlot() % list.size());
        }
        index2 = arg0.getSlot();
        if (index2 == ((index + 1) % 9)) {
        }
        if (index2 == ((index + 8) % 9)) {
        } else {
        }
        iterable = 0;
        if (iterable) {
        } else {
        }
        countValue = this.computeValue(arg0.getSlot(), list.size());
        arg0.cancel();
    }

    private void onClickSlotEvent(ClickSlotEvent arg0) {
        int index = arg0.getId();
        if (0 <= index) {
        } else {
        }
        if (arg0.getId() > 35) {
        }
        index = (arg0.getId() - 36).method_5438(arg0.getId()).method_7964().getString();
        if (Intrinsics.areEqual(index, "Air")) {
            return;
        }
        String[] items = new String[9];
        items[0] = this.getSwap1();
        items[1] = this.getSwap2();
        items[2] = this.getSwap3();
        items[3] = this.getSwap4();
        items[4] = this.getSwap5();
        items[5] = this.getSwap6();
        items[6] = this.getSwap7();
        items[7] = this.getSwap8();
        items[8] = this.getSwap9();
        items = ((Iterable) CollectionsKt.listOf(items));
        if (items instanceof Collection && ((Collection) items).isEmpty()) {
        }
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            String text = ((String) element);
        }
        int index2 = 0;
        if (Intrinsics.areEqual(this.getSwap1(), index)) {
            this.setSwap1("");
        }
        if (Intrinsics.areEqual(this.getSwap2(), index)) {
            this.setSwap2("");
        }
        if (Intrinsics.areEqual(this.getSwap3(), index)) {
            this.setSwap3("");
        }
        if (Intrinsics.areEqual(this.getSwap4(), index)) {
            this.setSwap4("");
        }
        if (Intrinsics.areEqual(this.getSwap5(), index)) {
            this.setSwap5("");
        }
        if (Intrinsics.areEqual(this.getSwap6(), index)) {
            this.setSwap6("");
        }
        if (Intrinsics.areEqual(this.getSwap7(), index)) {
            this.setSwap7("");
        }
        if (Intrinsics.areEqual(this.getSwap8(), index)) {
            this.setSwap8("");
        }
        if (Intrinsics.areEqual(this.getSwap8(), index)) {
            this.setSwap8("");
        }
        if (index2) {
            arg0.cancel();
            return;
        }
        this.setSwap1(index);
        this.setSwap2(index);
        this.setSwap3(index);
        this.setSwap4(index);
        this.setSwap5(index);
        this.setSwap6(index);
        this.setSwap7(index);
        this.setSwap8(index);
        this.setSwap9(index);
        items = countValue2;
        countValue2 = (items + 1);
        countValue2 = (countValue2 % 9);
        arg0.cancel();
    }

    private void onHotBarRenderEventPre(HotBarRenderEventPre arg0) {
        itemStack = SharedKt.getPlayer().method_6079();
        SharedKt.getPlayer().method_6122(Hand.field_5810, ItemStack.field_8037);
    }

    private void onHotBarRenderEventPost(HotBarRenderEventPost arg0) {
        SharedKt.getPlayer().method_6122(Hand.field_5810, itemStack);
    }

    private void updateValue(long arg0) {
        int index = TheNetherPacketHelper.f();
        float factor = TheNetherPacketHelper.INSTANCE.computeValue();
        float factor2 = TheNetherPacketHelper.INSTANCE.getNumericValue();
        int index2 = 2;
        int index3 = 0;
        Item item = Items.field_8288;
        int index4 = ItemPacketHelper.computeValue(item, index3, index2);
        boolean flag = Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8288);
        boolean flag2 = Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8288);
        boolean flag3 = Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8288);
        String text = "";
        if (__UNDEF_KEY__ == null) {
            if (flag2) {
                text = (text + "mainhand ");
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (flag3) {
                text = (text + "offhand ");
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (flag) {
                text = (text + "cursor ");
            }
        }
        int index5 = 0;
        if (index <= 400) {
            if (factor >= 5.0F) {
                if (Math.abs((factor2 - factor)) <= 5.0F) {
                    if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                        if (__UNDEF_KEY__ < 450L) {
                        } else {
                        }
                    }
                }
            }
        }
        int index6 = 0;
        if (index4 <= 0) {
            if (!(flag)) {
                if (!(flag3)) {
                    if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                        if (flag2) {
                            index5 = 1;
                        }
                    }
                }
            }
        }
        String text2 = class_124.field_1060.toString();
        String text3 = class_124.field_1061.toString();
        String text4 = class_124.field_1080.toString();
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
            if (index5 && factorValue > factorValue2 && __UNDEF_KEY__ < 500L) {
            } else {
            }
        }
        int index7 = 0;
        if (index5) {
        }
        if (__UNDEF_KEY__ == null) {
            if (index5) {
            } else {
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (index5) {
                if (__UNDEF_KEY__ == null) {
                    if (!(((CharSequence) text).length())) {
                    } else {
                    }
                }
                if (0) {
                }
                String text5 = StringsKt.trim(((CharSequence) text)).toString();
                String text6 = "";
            } else {
            }
        }
        if (index > 400) {
        }
        if (factor < 5.0F) {
        }
        if (__UNDEF_KEY__ < 450L) {
        }
        if (Math.abs((factor2 - factor)) > 5.0F) {
        }
        if (__UNDEF_KEY__ == null) {
            if (index5) {
                if (__UNDEF_KEY__ == null) {
                    if (!(index6)) {
                        if (this.computeValue() >= 36.0F) {
                        }
                    }
                }
            } else {
            }
        }
        String text7 = (text2 + "No totems + skill issue");
        String text8 = (text3 + "OffHand does not have time to take the totem increase minimum health");
        String text9 = (text2 + "Unstable internet connection / Server lag");
        String text10 = (text2 + "OK");
        String text11 = (text3 + "BAD");
        float factor3 = Math.abs((factor2 - factor));
        String text12 = (text2 + "OK");
        String text13 = (text3 + "BAD");
        String text14 = (text2 + "OK");
        String text15 = (text3 + "BAD");
        String text16 = (text2 + "OK");
        String text17 = (text3 + "BAD");
        String text18 = "";
        MessageServiceComponent.S(("\n totem locations = (" + text6 + text5 + ")"), false);
    }

    private void executeAction(int arg0) {
        if (!(this.checkCondition())) {
            return;
        }
        int index = arg0;
        if (!(SharedKt.getMc().currentScreen instanceof class_495)) {
            if (SharedKt.getMc().currentScreen instanceof class_476) {
            } else {
            }
        }
        int index2 = 0;
        if (!(this.getContainers()) && index2) {
            return;
        }
        countValue3 = this.getDelayBetweenSwaps();
        if (index < 9 && this.getHotBarSwap()) {
            atomicBoolean.set(true);
            ItemPacketHelper.INSTANCE.executeAction(index);
            PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN)));
            ItemPacketHelper.INSTANCE.updateValue2();
            atomicBoolean.set(false);
            ReFillerModule.INSTANCE.updateValue(3);
            ReFillerModule.INSTANCE.updateValue2(index);
            SharedKt.getPlayer().method_75203();
            return;
        }
        if (index == -1 || countValue3 > 0 || !(this.getResetAttackCooldown()) || index < 9) {
            return;
        }
        if (!(SharedKt.getPlayer().field_7512.method_34255().isEmpty())) {
            HandServiceComponent.e(-999, 0, null, false);
        }
        if (this.getOutdatedSwap()) {
            ItemPacketHelper.INSTANCE.executeAction(index, 45);
        }
        if (!(index2)) {
        } else {
        }
        HandServiceComponent.executeAction(40, class_1713.field_7791, 1, false);
    }

    private int computeValue(long arg0) {
        if (!(this.checkCondition())) {
            return -1;
        }
        Item[] items = new Item[1];
        items[0] = Items.field_8367;
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        Item[] items2 = new Item[1];
        items2[0] = Items.field_8463;
        items = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items2);
        Item[] items3 = new Item[1];
        items3[0] = Items.field_8288;
        items2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items3);
        items3 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition);
        ItemStack stack = SharedKt.getPlayer().method_6079();
        Item item = stack.getItem();
        boolean flag = Intrinsics.areEqual(item, Items.field_8463);
        boolean flag2 = Intrinsics.areEqual(item, Items.field_8367);
        int index = -1;
        ItemServiceComponent itemServiceComponent = this.resolveItemServiceComponent(item, flag);
        itemServiceComponent = new ItemServiceComponent(Items.field_8301, false, false);
        if (this.getCrappleSpoof()) {
            if (SharedKt.getPlayer().method_6059(class_1294.field_5898) && SharedKt.getPlayer().method_6112(class_1294.field_5898).method_5578() > 2) {
                if (!(items.isActive())) {
                    if (flag) {
                        itemServiceComponent = new ItemServiceComponent(Items.field_8463, false, false);
                    } else {
                        if (!(stackServiceComponent2.isActive())) {
                            if (flag2) {
                                itemServiceComponent = new ItemServiceComponent(Items.field_8367, false, false);
                                if (!(stackServiceComponent2.isActive())) {
                                    if (flag2) {
                                        itemServiceComponent = new ItemServiceComponent(Items.field_8367, false, false);
                                    } else {
                                        if (!(items.isActive())) {
                                            if (flag) {
                                                itemServiceComponent = new ItemServiceComponent(Items.field_8463, false, false);
                                                if (!(items.isActive())) {
                                                    if (flag) {
                                                        itemServiceComponent = new ItemServiceComponent(Items.field_8463, false, false);
                                                    } else {
                                                        if (!(stackServiceComponent2.isActive())) {
                                                            if (flag2) {
                                                                itemServiceComponent = new ItemServiceComponent(Items.field_8367, false, false);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
            }
        } else {
        }
        if (!(items2.isActive())) {
            if (this.computeValue2() <= this.computeValue() && Intrinsics.areEqual(item, Items.field_8288)) {
                itemServiceComponent = new ItemServiceComponent(Items.field_8288, false, false);
            }
        }
        if (!(Intrinsics.areEqual(itemServiceComponent, Items.field_8288))) {
            itemServiceComponent = this.resolveItemServiceComponent(itemServiceComponent);
        }
        if (this.getRcGap() != OffhandRcGapMode.ALWAYS) {
            if (this.checkCondition() && this.getRcGap() == OffhandRcGapMode.ONLY_SAFE && this.computeValue2() > this.computeValue()) {
                if (this.getGapplePriority() == OffhandGapplePriorityMode.NORMAL) {
                    if (!(items.isActive())) {
                        if (flag) {
                            itemServiceComponent = new ItemServiceComponent(Items.field_8463, false, false);
                        } else {
                            if (!(stackServiceComponent2.isActive())) {
                                if (flag2) {
                                    itemServiceComponent = new ItemServiceComponent(Items.field_8367, false, false);
                                    if (!(stackServiceComponent2.isActive())) {
                                        if (flag2) {
                                            itemServiceComponent = new ItemServiceComponent(Items.field_8367, false, false);
                                        } else {
                                            if (!(items.isActive())) {
                                                if (flag) {
                                                    itemServiceComponent = new ItemServiceComponent(Items.field_8463, false, false);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                }
            }
        }
        if (Intrinsics.areEqual(item, Items.field_8288)) {
        }
        if (Intrinsics.areEqual(item, Items.FIREWORK_ROCKET)) {
            if (itemServiceComponent != null && Intrinsics.areEqual(itemServiceComponent.getMinecraftObject(), Items.field_8288) && !(Intrinsics.areEqual(item, Items.field_8162)) && stack.method_7942() && this.getSaveEnchanted() && !(ElytraTargetModule.INSTANCE.getEnabled())) {
                itemStack2 = stack;
            }
        }
        if (this.getOffhand() == OffhandOffhandMode.OFF && this.getBindSwap() && this.getSwapButton().getNumericValue() != -1 && ServiceComponent13.checkCondition(this.getSwapButton().getNumericValue())) {
            itemStack2 = null;
        }
        if (itemServiceComponent != null) {
        }
        if (Intrinsics.areEqual(itemServiceComponent.getMinecraftObject(), Items.field_8162) && itemStack2 != null) {
            ItemStack stack2 = itemStack2;
            itemStack2 = null;
            int index2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition).getNumericValue();
            int index3 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition2).getNumericValue();
            if (index2 == -1) {
                if (index3 >= 36) {
                } else {
                }
                return index3;
            }
            if (index2 >= 36) {
            } else {
            }
            return index2;
        }
        if (itemServiceComponent != null) {
            if (Intrinsics.areEqual(itemServiceComponent.getMinecraftObject(), Items.field_8162)) {
                return -1;
            }
        }
        if (Intrinsics.areEqual(itemServiceComponent.getString(), "") && Intrinsics.areEqual(itemServiceComponent.getMinecraftObject(), Items.field_8288) && this.getSaveEnchanted() && Intrinsics.areEqual(item, Items.field_8288) && stack.method_7942() && items3.isActive()) {
            if (items3.getNumericValue() >= 36) {
            }
            return items3.getNumericValue();
        }
        stack2 = 44;
        if (8 < stack2) {
            if (!(((CharSequence) itemServiceComponent.getString()).length())) {
            } else {
            }
            if (0) {
                return -1;
            }
            if (Intrinsics.areEqual(item, itemServiceComponent.getMinecraftObject()) && !(itemServiceComponent.isActive()) && Intrinsics.areEqual(stack.method_7964().getString(), itemServiceComponent.getString())) {
                return -1;
            }
            if (stack2 >= 36) {
            } else {
            }
            index2 = stack2;
            index3 = SharedKt.getPlayer().method_31548().method_5438(index2);
            if (!(((CharSequence) itemServiceComponent.getString()).length())) {
            } else {
            }
            if (!(0)) {
            }
            if (itemServiceComponent.isActive2()) {
                if (index3.getItem().equals(itemServiceComponent.getMinecraftObject()) && Intrinsics.areEqual(itemServiceComponent.getString(), index3.method_7964().getString()) && index3.method_7942()) {
                    index = index2;
                } else {
                }
            }
        }
        if (Intrinsics.areEqual(itemServiceComponent, SharedKt.getPlayer().method_6047().getItem()) && SharedKt.getMc().options.field_1904.method_1434()) {
            return -1;
        }
        return index;
    }

    private ItemServiceComponent resolveItemServiceComponent(ItemServiceComponent arg0, short arg1, long arg2) {
        ItemServiceComponent itemServiceComponent = arg0;
        if (this.getOnFalling()) {
            if ((this.computeValue2() - (((EventPacketHelper2.INSTANCE.getNumericValue() - 3.0F) / 2.0F) + 3.5F)) < 0.5D) {
                if (!(SharedKt.getPlayer().isFallFlying())) {
                    if (arg1 >= 0) {
                        if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                            if (!(FreeCamModule.INSTANCE.getEnabled())) {
                                itemServiceComponent = new ItemServiceComponent(Items.field_8288, false, false);
                            }
                        }
                    }
                }
            }
        }
        if (arg2 > 0L) {
            if (__UNDEF_KEY__ == null) {
                if (this.getOnCrystalInHand()) {
                    Iterator iterator = RunnableServiceComponent.INSTANCE.getList().iterator();
                    while (iterator.hasNext()) {
                        AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) iterator.next());
                        if (arg1 >= 0) {
                            if (__UNDEF_KEY__ == null) {
                                if (arg2 >= 0L) {
                                    if (__UNDEF_KEY__ == null) {
                                        if (EntityHelper4.isFriend(((PlayerEntity) player))) {
                                        }
                                    }
                                }
                                if (arg1 >= 0) {
                                    if (__UNDEF_KEY__ == null) {
                                        if (Intrinsics.areEqual(player, SharedKt.getPlayer())) {
                                        }
                                    }
                                }
                                if (arg2 > 0L) {
                                    if (__UNDEF_KEY__ == null) {
                                    }
                                }
                                if (arg2 >= 0L) {
                                    if (__UNDEF_KEY__ == null) {
                                    }
                                }
                                if (arg2 > 0L) {
                                    if (__UNDEF_KEY__ == null) {
                                    }
                                }
                                if (arg2 > 0L) {
                                    if (__UNDEF_KEY__ == null) {
                                        if (!(Intrinsics.areEqual(player.method_6047().getItem(), Items.field_8281)) && !(Intrinsics.areEqual(player.method_6047().getItem(), Items.field_8301)) && !(Intrinsics.areEqual(player.method_6079().getItem(), Items.field_8281))) {
                                        }
                                    }
                                }
                                itemServiceComponent = new ItemServiceComponent(Items.field_8288, false, false);
                                if (arg1 >= 0) {
                                    if (arg2 >= 0L) {
                                        if (__UNDEF_KEY__ == null) {
                                            if (this.getOnExlposiveEntities()) {
                                                iterator = Lists.newArrayList(SharedKt.getWorld().method_18112()).iterator();
                                                while (iterator.hasNext()) {
                                                    player = iterator.next();
                                                    if (arg1 >= 0) {
                                                        if (__UNDEF_KEY__ == null) {
                                                            if (arg2 > 0L) {
                                                                if (player instanceof class_1674) {
                                                                    if (arg1 >= 0) {
                                                                        if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                                                                            if (this.resolveMinecraftObject(player).method_1022(this.resolveMinecraftObject(SharedKt.getPlayer())) <= 12.0D) {
                                                                                itemServiceComponent = new ItemServiceComponent(Items.field_8288, false, false);
                                                                                if (__UNDEF_KEY__ != null) {
                                                                                    if (arg2 > 0L) {
                                                                                        if (__UNDEF_KEY__ == null) {
                                                                                            if (player.isAlive()) {
                                                                                                if (arg1 >= 0) {
                                                                                                    if (__UNDEF_KEY__ == null) {
                                                                                                        if (EventPacketHelper2.INSTANCE.resolveMinecraftObject().method_1025(this.resolveMinecraftObject(player)) > 144.0D) {
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    if (!(player instanceof EndCrystalEntity)) {
                                                                                        if (!(player instanceof class_1541)) {
                                                                                            if (!(player instanceof class_1701)) {
                                                                                                if (arg1 >= 0) {
                                                                                                    if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                                                                                                        if (!(player instanceof class_1548)) {
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    itemServiceComponent = new ItemServiceComponent(Items.field_8288, false, false);
                                                                                    if (arg1 >= 0) {
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (__UNDEF_KEY__ == null) {
                                        if (this.getOnAnchors()) {
                                            iterator = -6;
                                            if (iterator < 7) {
                                                if (__UNDEF_KEY__ == null) {
                                                    player = -6;
                                                    if (player < 7) {
                                                        int index = -6;
                                                        if (index < 7) {
                                                            if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(new BlockPos(iterator, player, index)).getBlock(), Blocks.field_23152)) {
                                                                itemServiceComponent = new ItemServiceComponent(Items.field_8288, false, false);
                                                                if (arg2 >= 0L) {
                                                                    if (__UNDEF_KEY__ != null) {
                                                                        if (arg1 >= 0) {
                                                                            if (arg2 > 0L) {
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (arg1 >= 0 && this.getOnMace()) {
            player = ((Iterable) SharedKt.getWorld().getPlayers());
            index = 0;
            Iterator iterator2 = player.iterator();
            while (iterator2.hasNext()) {
                Object element = iterator2.next();
                AbstractClientPlayerEntity player2 = ((AbstractClientPlayerEntity) element);
                if (__UNDEF_KEY__ == null) {
                }
                if (__UNDEF_KEY__ == null) {
                    if (player2.method_18798().field_1351 >= -0.10000000149011612D) {
                        if (arg2 >= 0L) {
                            if (__UNDEF_KEY__ == null) {
                            }
                        }
                    }
                }
                if (__UNDEF_KEY__ == null) {
                    if (!(Intrinsics.areEqual(player2.method_6047().getItem(), Items.field_49814))) {
                        if (arg1 >= 0) {
                            if (__UNDEF_KEY__ == null) {
                            }
                        }
                    }
                }
                if (arg2 > 0L) {
                    if (__UNDEF_KEY__ == null) {
                    }
                }
                if (__UNDEF_KEY__ == null) {
                    if (INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).method_1022(INSTANCE.resolveMinecraftObject(player2)) < 12.0D && (player2.field_6036 - player2.getY()) > 0.5D && Intrinsics.areEqual(player2.method_6079().getItem(), Items.field_49814) && !(Intrinsics.areEqual(player2, SharedKt.getPlayer())) && !(EntityHelper4.isFriend(((PlayerEntity) player2)))) {
                    } else {
                    }
                }
            }
            iterator = ((AbstractClientPlayerEntity) null);
            if (arg1 >= 0) {
                if (__UNDEF_KEY__ == null) {
                    if (iterator != null) {
                        NotifierModule.INSTANCE.updateValue(true);
                        NotifierModule.INSTANCE.getServiceComponent10().executeAction();
                        itemServiceComponent = new ItemServiceComponent(Items.field_8288, false, false);
                        if (arg2 >= 0L) {
                            if (__UNDEF_KEY__ != null) {
                                NotifierModule.INSTANCE.updateValue(false);
                            }
                        }
                    }
                }
            }
        }
        return itemServiceComponent;
    }

    private ItemServiceComponent resolveItemServiceComponent(Item arg0, boolean arg1) {
        if (__UNDEF_KEY__ == null) {
            if (__UNDEF_KEY__ == null) {
                if (this.getBindSwap() && this.getSwapButton().getNumericValue() != -1) {
                    if (__UNDEF_KEY__ == null) {
                        if (this.getSwapMode() == OffhandSwapMode.CUSTOM) {
                            List list = this.resolveList();
                            if (__UNDEF_KEY__ == null) {
                                if (!(((Collection) list).isEmpty())) {
                                } else {
                                }
                            }
                            if (0) {
                                int index = (((list.size() - countValue) - 1) % list.size());
                                if (__UNDEF_KEY__ == null) {
                                    if (0 <= index) {
                                        if (__UNDEF_KEY__ == null) {
                                            if (index < list.size()) {
                                            }
                                        }
                                    } else {
                                    }
                                }
                                if (0) {
                                    ItemStack stack = ((ItemStack) list.get(index));
                                    ItemServiceComponent itemServiceComponent = new ItemServiceComponent(stack.getItem(), true, false, stack.method_7964().getString());
                                    if (__UNDEF_KEY__ == null) {
                                    }
                                    if (__UNDEF_KEY__ == null) {
                                        if (ServiceComponent13.checkCondition(this.getSwapButton().getNumericValue()) && serviceComponent10.checkCondition(250)) {
                                            serviceComponent10.executeAction();
                                            if (__UNDEF_KEY__ == null) {
                                            }
                                            if (__UNDEF_KEY__ == null) {
                                                if (!(SharedKt.getPlayer().method_6079().isEmpty())) {
                                                    if (Intrinsics.areEqual(arg0, Items.field_8255)) {
                                                    }
                                                }
                                            }
                                            if (__UNDEF_KEY__ == null) {
                                                if (!(SharedKt.getPlayer().method_6079().isEmpty())) {
                                                    if (arg1) {
                                                    }
                                                }
                                            }
                                            if (__UNDEF_KEY__ == null) {
                                                if (!(SharedKt.getPlayer().method_6079().isEmpty())) {
                                                    if (Intrinsics.areEqual(arg0, Items.field_8255)) {
                                                    }
                                                }
                                            }
                                            if (__UNDEF_KEY__ == null) {
                                                if (!(SharedKt.getPlayer().method_6079().isEmpty())) {
                                                    if (Intrinsics.areEqual(arg0, Items.field_8288)) {
                                                    }
                                                }
                                            }
                                            itemServiceComponent = new ItemServiceComponent(Items.field_8575, true, false);
                                            itemStack2 = itemServiceComponent.getMinecraftObject().method_7854();
                                        }
                                    }
                                }
                            }
                        } else {
                        }
                    }
                }
            }
        }
        return itemServiceComponent;
    }

    private float computeValue() {
        if (SharedKt.getPlayer().isFallFlying() && EventPacketHelper2.INSTANCE.getNumericValue() > 15) {
        }
        return this.getTotemHealth();
    }

    private boolean checkCondition() {
        if (SharedKt.getMc().field_1765 instanceof class_3965) {
        }
        Block block = Blocks.field_10566;
        if (this.getRcGap() != OffhandRcGapMode.OFF && ItemServiceComponent4.checkCondition(SharedKt.getPlayer().method_6047()) && SharedKt.getMc().options.field_1904.method_1434() && !(SharedKt.getPlayer().method_6079().getItem() instanceof class_1819)) {
        } else {
        }
        block = 0;
        if (!(block instanceof class_2237) && !(Intrinsics.areEqual(block, Blocks.field_9980))) {
        } else {
        }
        int index = 0;
        if (!(index)) {
            if (block && NoInteractModule.INSTANCE.getEnabled()) {
            } else {
            }
        }
        return false;
    }

    private float computeValue2() {
        return (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067());
    }

    private int computeValue(int arg0, int arg1) {
        return (((arg0 % arg1) + arg1) % arg1);
    }

    private List resolveList() {
        List list = new ArrayList();
        String[] items = new String[9];
        items[0] = this.getSwap1();
        items[1] = this.getSwap2();
        items[2] = this.getSwap3();
        items[3] = this.getSwap4();
        items[4] = this.getSwap5();
        items[5] = this.getSwap6();
        items[6] = this.getSwap7();
        items[7] = this.getSwap8();
        items[8] = this.getSwap9();
        items = ((Iterable) CollectionsKt.listOf(items));
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            String text = ((String) element);
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                    if (((CharSequence) text).length() > 0) {
                    } else {
                    }
                }
                if (__UNDEF_KEY__ == null) {
                }
                if (__UNDEF_KEY__ == null) {
                    if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().method_7964().getString(), text)) {
                        list.add(SharedKt.getPlayer().method_6079());
                        if (0 && !(Intrinsics.areEqual(text, "Air")) && __UNDEF_KEY__ != null) {
                            int index = 0;
                            if (index < 36) {
                                ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(index);
                                if (__UNDEF_KEY__ == null) {
                                    if (Intrinsics.areEqual(stack.method_7964().getString(), text)) {
                                        list.add(stack);
                                        if (__UNDEF_KEY__ != null) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    private static boolean isActive() {
        return INSTANCE.getOffhand() == OffhandOffhandMode.OFF;
    }

    private static boolean isActive2() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap()) {
        } else {
        }
        return false;
    }

    private static boolean isActive3() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap()) {
        } else {
        }
        return false;
    }

    private static boolean isActive4() {
        return INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM;
    }

    private static boolean isActive5() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
        } else {
        }
        return false;
    }

    private static boolean isActive6() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
        } else {
        }
        return false;
    }

    private static boolean isActive7() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
        } else {
        }
        return false;
    }

    private static boolean isActive8() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
        } else {
        }
        return false;
    }

    private static boolean isActive9() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
        } else {
        }
        return false;
    }

    private static boolean isActive10() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
        } else {
        }
        return false;
    }

    private static boolean isActive11() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
        } else {
        }
        return false;
    }

    private static boolean isActive12() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
        } else {
        }
        return false;
    }

    private static boolean isActive13() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
        } else {
        }
        return false;
    }

    private static boolean isActive14() {
        if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
        } else {
        }
        return false;
    }

    private static boolean isActive15() {
        return INSTANCE.getHotBarSwap();
    }

    private static boolean isActive16() {
        return INSTANCE.getRcGap() != OffhandRcGapMode.OFF;
    }

    private static boolean isActive17() {
        return INSTANCE.getOffhand() == OffhandOffhandMode.GAPPLE;
    }

    private static boolean checkCondition(ItemStack arg0) {
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
            if (Intrinsics.areEqual(arg0.getItem(), Items.field_8288) && !(arg0.method_7942())) {
            } else {
            }
        }
        return false;
    }

    private static boolean checkCondition(ItemStack arg0, ItemStack arg1) {
        return Intrinsics.areEqual(arg1, arg0);
    }

    private static boolean checkCondition2(ItemStack arg0, ItemStack arg1) {
        return Intrinsics.areEqual(arg1.getItem(), arg0.getItem());
    }

    static {
        KProperty[] items = new KProperty[33];
        INSTANCE = new OffhandModule();
        delayBetweenSwapsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay-between-swaps", 0, new IntRange(0, 10));
        totemHealthSetting = VisibleRenderHelper.registerSetting(INSTANCE, "totem-hp", 16.0F, RangesKt.rangeTo(0.0F, 36.0F));
        totemElytraHealthSetting = VisibleRenderHelper.registerSetting(INSTANCE, "totem-elytra-hp", 16.0F, RangesKt.rangeTo(0.0F, 36.0F));
        outdatedSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pre-1.16.5-swap", false);
        offhandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "force-item", OffhandOffhandMode.OFF);
        bindSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bind-swap", false, null, this::isActive);
        swapButtonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-button", new KeyRecord(0, false, false), null, this::isActive2);
        swapModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap", OffhandSwapMode.GAPPLE_SHIELD, null, this::isActive3);
        swapGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-items", null, this::isActive4);
        int index = 4;
        Function0 function0 = this::isActive5;
        TextServiceComponent textServiceComponent = new TextServiceComponent("Hold the bind and click items in inv to add them. Hold the bind and use the hotbar to swap items");
        notationSetting = VisibleRenderHelper.registerSetting(INSTANCE, "notation", textServiceComponent, function0, index);
        swap1Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap1", "", null, this::isActive6);
        swap2Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap2", "", null, this::isActive7);
        swap3Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap3", "", null, this::isActive8);
        swap4Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap4", "", null, this::isActive9);
        swap5Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap5", "", null, this::isActive10);
        swap6Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap6", "", null, this::isActive11);
        swap7Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap7", "", null, this::isActive12);
        swap8Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap8", "", null, this::isActive13);
        swap9Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap9", "", null, this::isActive14);
        hotBarSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hot-bar-swap", false);
        resetAttackCooldownSetting = VisibleRenderHelper.registerSetting(INSTANCE, "reset-attack-cooldown", false, null, this::isActive15);
        saveEnchantedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "save-enchanted", false);
        rcGapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "right-click-gapple", OffhandRcGapMode.OFF);
        gapplePrioritySetting = VisibleRenderHelper.registerSetting(INSTANCE, "gapple-priority", OffhandGapplePriorityMode.ENCHANTED, null, this::isActive16);
        crappleSpoofSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crapple-spoof", true, null, this::isActive17);
        deathVerboseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "death-verbose", true);
        containersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "containers", true);
        safetyFactorsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "safety-factors", OptionMode14.BOOLS);
        onCrystalInHandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-crystal-in-hand", false, INSTANCE.getSafetyFactors());
        onFallingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-falling", true, INSTANCE.getSafetyFactors());
        onMaceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-mace", true, INSTANCE.getSafetyFactors());
        onExlposiveEntitiesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-explosive-entities", true, INSTANCE.getSafetyFactors());
        onAnchorsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-anchors", true, INSTANCE.getSafetyFactors());
        minecraftRef = class_2960.method_60656("hud/hotbar_selection");
        minecraftRef2 = class_2960.method_60656("hud/hotbar_offhand_left");
        itemStack = Items.field_8162.method_7854();
        atomicBoolean = new AtomicBoolean(false);
        serviceComponent10 = new ServiceComponent10();
        timestampValue = 1000000L;
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
