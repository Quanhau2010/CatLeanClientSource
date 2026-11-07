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
        String[] var8 = new String[2];
        var8[0] = "auto-totem";
        var8[1] = "autototem";
        super("offhand", SubCategoriesKt.getProtectCategory(), CollectionsKt.listOf());
    }

    private int getDelayBetweenSwaps() {
        return (Number) delayBetweenSwapsSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private float getTotemHealth() {
        return (Number) totemHealthSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private float getTotemElytraHealth() {
        return (Number) totemElytraHealthSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getOutdatedSwap() {
        return (Boolean) outdatedSwapSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private OffhandOffhandMode getOffhand() {
        return (OffhandOffhandMode) offhandSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getBindSwap() {
        return (Boolean) bindSwapSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private KeyRecord getSwapButton() {
        return (KeyRecord) swapButtonSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private OffhandSwapMode getSwapMode() {
        return (OffhandSwapMode) swapModeSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private SettingGroup getSwapGroup() {
        return (SettingGroup) swapGroupSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private TextServiceComponent getNotation() {
        return (TextServiceComponent) notationSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private void setNotation(TextServiceComponent value) {
        notationSetting.setValue(this, DELEGATED_PROPERTIES[9], value);
    }

    private String getSwap1() {
        return (String) swap1Setting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private void setSwap1(String value) {
        swap1Setting.setValue(this, DELEGATED_PROPERTIES[10], value);
    }

    private String getSwap2() {
        return (String) swap2Setting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private void setSwap2(String value) {
        swap2Setting.setValue(this, DELEGATED_PROPERTIES[11], value);
    }

    private String getSwap3() {
        return (String) swap3Setting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private void setSwap3(String value) {
        swap3Setting.setValue(this, DELEGATED_PROPERTIES[12], value);
    }

    private String getSwap4() {
        return (String) swap4Setting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private void setSwap4(String value) {
        swap4Setting.setValue(this, DELEGATED_PROPERTIES[13], value);
    }

    private String getSwap5() {
        return (String) swap5Setting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private void setSwap5(String value) {
        swap5Setting.setValue(this, DELEGATED_PROPERTIES[14], value);
    }

    private String getSwap6() {
        return (String) swap6Setting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    private void setSwap6(String value) {
        swap6Setting.setValue(this, DELEGATED_PROPERTIES[15], value);
    }

    private String getSwap7() {
        return (String) swap7Setting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    private void setSwap7(String value) {
        swap7Setting.setValue(this, DELEGATED_PROPERTIES[16], value);
    }

    private String getSwap8() {
        return (String) swap8Setting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    private void setSwap8(String value) {
        swap8Setting.setValue(this, DELEGATED_PROPERTIES[17], value);
    }

    private String getSwap9() {
        return (String) swap9Setting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    private void setSwap9(String value) {
        swap9Setting.setValue(this, DELEGATED_PROPERTIES[18], value);
    }

    private boolean getHotBarSwap() {
        return (Boolean) hotBarSwapSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    private boolean getResetAttackCooldown() {
        return (Boolean) resetAttackCooldownSetting.getValue(this, DELEGATED_PROPERTIES[20]);
    }

    private boolean getSaveEnchanted() {
        return (Boolean) saveEnchantedSetting.getValue(this, DELEGATED_PROPERTIES[21]);
    }

    private OffhandRcGapMode getRcGap() {
        return (OffhandRcGapMode) rcGapSetting.getValue(this, DELEGATED_PROPERTIES[22]);
    }

    private OffhandGapplePriorityMode getGapplePriority() {
        return (OffhandGapplePriorityMode) gapplePrioritySetting.getValue(this, DELEGATED_PROPERTIES[23]);
    }

    private boolean getCrappleSpoof() {
        return (Boolean) crappleSpoofSetting.getValue(this, DELEGATED_PROPERTIES[24]);
    }

    private boolean getDeathVerbose() {
        return (Boolean) deathVerboseSetting.getValue(this, DELEGATED_PROPERTIES[25]);
    }

    private boolean getContainers() {
        return (Boolean) containersSetting.getValue(this, DELEGATED_PROPERTIES[26]);
    }

    private SettingGroup getSafetyFactors() {
        return (SettingGroup) safetyFactorsSetting.getValue(this, DELEGATED_PROPERTIES[27]);
    }

    private boolean getOnCrystalInHand() {
        return (Boolean) onCrystalInHandSetting.getValue(this, DELEGATED_PROPERTIES[28]);
    }

    private boolean getOnFalling() {
        return (Boolean) onFallingSetting.getValue(this, DELEGATED_PROPERTIES[29]);
    }

    private boolean getOnMace() {
        return (Boolean) onMaceSetting.getValue(this, DELEGATED_PROPERTIES[30]);
    }

    private boolean getOnExlposiveEntities() {
        return (Boolean) onExlposiveEntitiesSetting.getValue(this, DELEGATED_PROPERTIES[31]);
    }

    private boolean getOnAnchors() {
        return (Boolean) onAnchorsSetting.getValue(this, DELEGATED_PROPERTIES[32]);
    }

    public int getNumericValue() {
        return countValue3;
    }

    public void updateValue(int value) {
        countValue3 = value;
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        if (var10 == null) {
        }
        if (!(this.getBindSwap()) || this.getSwapMode() != OffhandSwapMode.CUSTOM) {
            return;
        }
        int var11 = (arg0.getContext().method_51443() - 23);
        int var12 = ((arg0.getContext().method_51443() - 16) - 3);
        int var13 = (((arg0.getContext().method_51421() / 2) - 91) - 29);
        int var14 = 21;
        List positions = this.resolveList();
        if (var10 == null) {
            if (positions.isEmpty()) {
                return;
            }
        }
        Iterable var16 = (Iterable) positions;
        int var17 = 0;
        int var18 = 0;
        Iterator iterator = var16.iterator();
        if (iterator.hasNext()) {
            Object var20 = iterator.next();
            int var21 = var18;
            if (var10 == null) {
                if (var10 == null) {
                    if (var21 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                }
                ItemStack stack = (ItemStack) var20;
                int var23 = var21;
                int var24 = 0;
                int var25 = (var13 - (var23 * var14));
                arg0.getContext().method_52706(class_10799.field_56883, minecraftRef2, 29, 24);
                if (var10 == null) {
                    if (!(stack.isEmpty())) {
                        arg0.getContext().method_51427(stack, (var25 + 3));
                    }
                }
            }
        }
        if (var10 == null) {
            if (countValue == positions.size()) {
                var16 = countValue;
                countValue = (var16 + -1);
            }
        }
        var16 = (var13 - (((positions.size() - countValue) - 1) * var14));
        arg0.getContext().method_52706(class_10799.field_56883, minecraftRef, (var16 - 1), 24, 23);
    }

    private void onPostTasksProcessEvent(PostTasksProcessEvent arg0) {
        if (!(this.checkCondition())) {
            return;
        }
        float var13 = (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067());
        if (var12 == null) {
            if (var13 < factorValue3) {
                factorValue2 = factorValue;
                factorValue = (factorValue3 - var13);
            }
        }
        factorValue3 = var13;
        this.executeAction(this.computeValue());
    }

    private void onPostSyncEvent(PostSyncEvent arg0) {
        if (this.checkCondition()) {
            if (var10 == null && var10 == null) {
                if (!(SharedKt.getPlayer().method_6115())) {
                    (MinecraftAccessor) SharedKt.getMc().idoItemUse();
                }
            }
        }
        int var11 = countValue3;
        countValue3 = (var11 + -1);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (var14 == null) {
        }
        if (var14 == null) {
        }
        if ((class_2663) arg0.getPacket().method_11470() != 3) {
            if (var14 == null && var14 == null) {
            }
        }
        this.updateValue();
    }

    private void onUpdateSelectedSlotEvent(UpdateSelectedSlotEvent arg0) {
        if (var19 == null) {
        }
        if (!(this.checkCondition()) || var19 == null) {
            return;
        }
        boolean var20 = atomicBoolean.get();
        if (var19 == null) {
        }
        if (var19 == null) {
        }
        List positions = this.resolveList();
        if (var19 == null) {
            if (positions.isEmpty()) {
                return;
            }
        }
        Iterable var23 = (Iterable) new IntRange(0, 8);
        int var24 = 0;
        if (var23 instanceof Collection) {
            if (var19 == null && var19 == null) {
                if ((Collection) var23.isEmpty()) {
                }
            }
        }
        Iterator iterator = var23.iterator();
        if (iterator.hasNext()) {
            int var26 = (IntIterator) iterator.nextInt();
            int var27 = var26;
            int var28 = 0;
            if (!(SharedKt.getMc().options.field_1852[var27].method_1436())) {
                if (var19 == null && var19 == null) {
                    if (SharedKt.getMc().options.field_1852[var27].method_1434()) {
                    }
                }
            } else {
            }
        } else {
        }
        int var22 = 0;
        if (var19 == null) {
            if (var22) {
                countValue = (arg0.getSlot() % positions.size());
                if (var19 != null) {
                }
                var24 = arg0.getSlot();
            }
            if (var19 == null) {
                if (var24 == ((var20 + 1) % 9)) {
                }
                if (var19 == null) {
                }
                if (var24 == ((var20 + 8) % 9)) {
                }
            } else {
            }
            var23 = 0;
            if (var19 == null) {
                if (var23) {
                }
            } else {
            }
            countValue = this.computeValue(arg0.getSlot(), positions.size());
        }
        arg0.cancel();
    }

    private void onClickSlotEvent(ClickSlotEvent arg0) {
        if (var53 == null) {
        }
        if (var53 == null) {
        }
        int var54 = arg0.getId();
        if (var53 == null) {
            if (0 <= var54) {
                if (var53 == null) {
                }
                if (var54 < 45) {
                }
            }
        } else {
        }
        if (var53 == null) {
            if (arg0.getId() > 35) {
            }
        }
        var54 = (arg0.getId() - 36).method_5438(arg0.getId()).method_7964().getString();
        if (var53 == null) {
            if (Intrinsics.areEqual("Air")) {
                return;
            }
        }
        String[] var56 = new String[9];
        var56[0] = this.getSwap1();
        var56[1] = this.getSwap2();
        var56[2] = this.getSwap3();
        var56[3] = this.getSwap4();
        var56[4] = this.getSwap5();
        var56[5] = this.getSwap6();
        var56[6] = this.getSwap7();
        var56[7] = this.getSwap8();
        var56[8] = this.getSwap9();
        var56 = (Iterable) CollectionsKt.listOf();
        int var57 = 0;
        if (var56 instanceof Collection) {
            if (var53 == null && var53 == null) {
                if ((Collection) var56.isEmpty()) {
                }
            }
        }
        Iterator iterator = var56.iterator();
        if (iterator.hasNext()) {
            Object var59 = iterator.next();
            String var60 = (String) var59;
            int var61 = 0;
        } else {
        }
        int var55 = 0;
        if (var53 == null) {
            if (Intrinsics.areEqual(this.getSwap1())) {
                this.setSwap1("");
            }
        }
        if (var53 == null) {
            if (Intrinsics.areEqual(this.getSwap2())) {
                this.setSwap2("");
            }
        }
        if (var53 == null) {
            if (Intrinsics.areEqual(this.getSwap3())) {
                this.setSwap3("");
            }
        }
        if (var53 == null) {
            if (Intrinsics.areEqual(this.getSwap4())) {
                this.setSwap4("");
            }
        }
        if (var53 == null) {
            if (Intrinsics.areEqual(this.getSwap5())) {
                this.setSwap5("");
            }
        }
        if (var53 == null) {
            if (Intrinsics.areEqual(this.getSwap6())) {
                this.setSwap6("");
            }
        }
        if (var53 == null) {
            if (Intrinsics.areEqual(this.getSwap7())) {
                this.setSwap7("");
            }
        }
        if (var53 == null) {
            if (Intrinsics.areEqual(this.getSwap8())) {
                this.setSwap8("");
            }
        }
        if (var53 == null) {
            if (Intrinsics.areEqual(this.getSwap8())) {
                this.setSwap8("");
            }
        }
        if (var53 == null) {
            if (var55) {
                arg0.cancel();
                return;
            }
        }
        if (var53 == null) {
            this.setSwap1();
            this.setSwap2();
            this.setSwap3();
            this.setSwap4();
            this.setSwap5();
            this.setSwap6();
            this.setSwap7();
            this.setSwap8();
            if (var53 != null && var53 != null && var53 != null && var53 != null && var53 != null && var53 != null && var53 != null && var53 != null) {
                this.setSwap9();
            }
        }
        var56 = countValue2;
        countValue2 = (var56 + 1);
        countValue2 = (countValue2 % 9);
        arg0.cancel();
    }

    private void onHotBarRenderEventPre(HotBarRenderEventPre arg0) {
        if (var12 == null) {
        }
        itemStack = SharedKt.getPlayer().method_6079();
        SharedKt.getPlayer().method_6122(Hand.field_5810, ItemStack.field_8037);
    }

    private void onHotBarRenderEventPost(HotBarRenderEventPost arg0) {
        if (var12 == null) {
        }
        SharedKt.getPlayer().method_6122(Hand.field_5810, itemStack);
    }

    private void updateValue(long arg0) {
        int var22 = TheNetherPacketHelper.f();
        float var23 = TheNetherPacketHelper.INSTANCE.computeValue();
        float var24 = TheNetherPacketHelper.INSTANCE.getNumericValue();
        int var18 = 2;
        int var19 = 0;
        Item var20 = Items.field_8288;
        int var27 = ItemPacketHelper.computeValue();
        boolean var28 = Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8288);
        boolean var29 = Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem(), Items.field_8288);
        boolean var30 = Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.field_8288);
        String var31 = "";
        if (var21 == null) {
            if (var29) {
                var31 = (var31 + "mainhand ");
            }
        }
        if (var21 == null) {
            if (var30) {
                var31 = (var31 + "offhand ");
            }
        }
        if (var21 == null) {
            if (var28) {
                var31 = (var31 + "cursor ");
            }
        }
        int var32 = 0;
        if (var22 <= 400) {
            if (var23 >= 5.0F) {
                if (Math.abs((var24 - var23)) <= 5.0F) {
                    if (var21 == null && var21 == null && var21 == null && var21 == null) {
                        if (var25 < 450L) {
                        }
                    }
                }
            }
        } else {
        }
        int var33 = 0;
        if (var27 <= 0) {
            if (!(var28)) {
                if (!(var30)) {
                    if (var21 == null && var21 == null && var21 == null && var21 == null) {
                        if (var29) {
                        }
                    }
                }
            }
            var32 = 1;
        }
        String var34 = class_124.field_1060.toString();
        String var35 = class_124.field_1061.toString();
        String var36 = class_124.field_1080.toString();
        if (var21 == null) {
        }
        if (var21 == null) {
        }
        if (var21 == null) {
            if (var32 && factorValue > factorValue2 && var25 < 500L) {
            }
        } else {
        }
        int var37 = 0;
        if (var32) {
        }
        if (var21 == null) {
            if (var32) {
            }
        } else {
        }
        if (var21 == null) {
            if (var32) {
            }
            if (var21 == null) {
                if (!((CharSequence) var31.length())) {
                }
            } else {
            }
            if (0) {
            }
            String var38 = StringsKt.trim((CharSequence) var31).toString();
            String var39 = "";
        } else {
        }
        if (var22 > 400) {
        }
        if (var23 < 5.0F) {
        }
        if (var25 < 450L) {
        }
        if (Math.abs((var24 - var23)) > 5.0F) {
        }
        if (var21 == null) {
            if (var32) {
            }
            if (var21 == null) {
                if (!(var33)) {
                }
                if (this.computeValue() >= 36.0F) {
                }
            }
        } else {
        }
        String var40 = (var34 + "No totems + skill issue");
        String var41 = (var35 + "OffHand does not have time to take the totem increase minimum health");
        String var42 = (var34 + "Unstable internet connection / Server lag");
        Object var43 = var36;
        String var44 = (var34 + "OK");
        String var45 = (var35 + "BAD");
        float var46 = Math.abs((var24 - var23));
        Object var48 = var36;
        String var49 = (var34 + "OK");
        String var50 = (var35 + "BAD");
        long var51 = var25;
        Object var52 = var36;
        String var53 = (var34 + "OK");
        String var54 = (var35 + "BAD");
        float var55 = var23;
        Object var56 = var36;
        String var57 = (var34 + "OK");
        String var58 = (var35 + "BAD");
        int var59 = var22;
        Object var60 = var36;
        int var61 = var37;
        Object var62 = var36;
        float var63 = factorValue2;
        Object var64 = var36;
        float var65 = factorValue;
        Object var66 = var36;
        String var67 = "";
        MessageServiceComponent.S(("\n totem locations = (" + var39 + var38 + ")"), ("[" + var67 + "Death Analysis" + var66 + "]\n failed =" + var65 + " " + var64 + var63 + var62 + var61 + var60 + "\n damage = " + var59 + var58 + "\n prevDamage = " + var57 + var56 + "\n double pop = " + var55 + " " + var54 + "\n ping = " + var53 + " | " + var52 + var51 + "\n tps = " + var50 + " | " + var49 + var48 + "\n lastPop = " + var46 + " | " + var45 + var44 + "\n tpsSpike = " + var43 + " | " + var42 + var41 + "\n\n Conclusion: " + var40));
    }

    private void executeAction(int arg0) {
        if (var35 == null) {
            if (!(this.checkCondition())) {
                return;
            }
        }
        int var36 = arg0;
        if (!(SharedKt.getMc().currentScreen instanceof class_495)) {
            if (var35 == null && var35 == null) {
                if (SharedKt.getMc().currentScreen instanceof class_476) {
                }
            }
        } else {
        }
        int var37 = 0;
        if (!(this.getContainers())) {
            if (var35 == null && var35 == null) {
                if (var37) {
                    return;
                }
            }
        }
        if (var35 == null) {
        }
        if (var35 == null) {
            countValue3 = this.getDelayBetweenSwaps();
        }
        if (var35 == null) {
            if (var35 == null) {
                if (var36 < 9 && this.getHotBarSwap()) {
                    atomicBoolean.set(1);
                    ItemPacketHelper.INSTANCE.executeAction();
                    PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12969, BlockPos.field_10980, Direction.DOWN));
                    ItemPacketHelper.INSTANCE.updateValue2();
                    atomicBoolean.set(0);
                    ReFillerModule.INSTANCE.updateValue(3);
                    ReFillerModule.INSTANCE.updateValue2();
                    SharedKt.getPlayer().method_75203();
                    return;
                }
            }
            if (var36 == -1 || countValue3 > 0 || !(this.getResetAttackCooldown()) || var35 == null) {
                return;
            }
        }
        if (var35 == null) {
            if (!(var36)) {
                HandServiceComponent.e(-999);
            }
        }
        if (var35 == null) {
            if (this.getOutdatedSwap()) {
                ItemPacketHelper.INSTANCE.executeAction(45);
            }
        }
        if (var35 == null) {
            if (!(var37)) {
            }
        } else {
        }
        HandServiceComponent.executeAction(40, class_1713.field_7791, 1, 0);
    }

    private int computeValue(long arg0) {
        if (var50 == null) {
            if (!(this.checkCondition())) {
            }
            return -1;
        }
        Item[] var52 = new Item[1];
        var52[0] = Items.field_8367;
        StackServiceComponent2 var51 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        Item[] var53 = new Item[1];
        var53[0] = Items.field_8463;
        var52 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        Item[] var54 = new Item[1];
        var54[0] = Items.field_8288;
        var53 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        var54 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition);
        ItemStack stack = SharedKt.getPlayer().method_6079();
        Item var56 = stack.getItem();
        boolean var57 = Intrinsics.areEqual(Items.field_8463);
        boolean var58 = Intrinsics.areEqual(Items.field_8367);
        int var59 = -1;
        if (var50 == null) {
        }
        ItemServiceComponent var60 = this.resolveItemServiceComponent();
        var60 = new ItemServiceComponent(Items.field_8301);
        if (var50 == null) {
            if (this.getCrappleSpoof()) {
                if (SharedKt.getPlayer().method_6059(class_1294.field_5898)) {
                    if (var50 == null && var50 == null) {
                        if (SharedKt.getPlayer().method_6112(class_1294.field_5898).method_5578() > 2) {
                            if (var50 == null) {
                                if (!(var52.isActive())) {
                                }
                                if (var50 == null) {
                                    if (var57) {
                                    }
                                    var60 = new ItemServiceComponent(Items.field_8463);
                                } else {
                                }
                                if (var50 == null) {
                                    if (!(var51.isActive())) {
                                    }
                                    if (var58) {
                                    }
                                    var60 = new ItemServiceComponent(Items.field_8367);
                                }
                            } else {
                            }
                            if (var50 == null) {
                                if (!(var51.isActive())) {
                                }
                                if (var50 == null) {
                                    if (var58) {
                                    }
                                    var60 = new ItemServiceComponent(Items.field_8367);
                                } else {
                                }
                                if (var50 == null) {
                                    if (!(var52.isActive())) {
                                    }
                                    if (var57) {
                                    }
                                    var60 = new ItemServiceComponent(Items.field_8463);
                                } else {
                                }
                                if (var50 == null) {
                                    if (!(var52.isActive())) {
                                    }
                                    if (var50 == null) {
                                        if (var57) {
                                        }
                                        var60 = new ItemServiceComponent(Items.field_8463);
                                    } else {
                                    }
                                    if (var50 == null) {
                                        if (!(var51.isActive())) {
                                        }
                                        if (var58) {
                                        }
                                        var60 = new ItemServiceComponent(Items.field_8367);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        }
        if (this.computeValue2() <= this.computeValue()) {
            if (var50 == null) {
                if (!(var53.isActive())) {
                }
                if (var50 == null && var50 == null) {
                    if (Intrinsics.areEqual(Items.field_8288)) {
                    }
                    var60 = new ItemServiceComponent(Items.field_8288);
                }
            }
        }
        if (var50 == null) {
            if (!(Intrinsics.areEqual(Items.field_8288))) {
                var60 = this.resolveItemServiceComponent();
            }
            if (var50 == null) {
            }
        }
        if (var50 == null) {
            if (this.getRcGap() != OffhandRcGapMode.ALWAYS) {
                if (var50 == null) {
                }
                if (var50 == null) {
                    if (this.checkCondition() && this.getRcGap() == OffhandRcGapMode.ONLY_SAFE && this.computeValue2() > this.computeValue()) {
                    }
                }
            }
            if (this.getGapplePriority() == OffhandGapplePriorityMode.NORMAL) {
                if (var50 == null) {
                    if (!(var52.isActive())) {
                    }
                    if (var50 == null) {
                        if (var57) {
                        }
                        var60 = new ItemServiceComponent(Items.field_8463);
                    }
                }
                if (var50 == null) {
                    if (!(var51.isActive())) {
                    }
                    if (var50 != null && var58) {
                    }
                    var60 = new ItemServiceComponent(Items.field_8367);
                    if (var50 != null) {
                    }
                    if (var50 == null) {
                        if (!(var51.isActive())) {
                        }
                        if (var50 == null) {
                            if (var58) {
                            }
                            var60 = new ItemServiceComponent(Items.field_8367);
                        }
                    }
                    if (var50 == null) {
                        if (!(var52.isActive())) {
                        }
                        if (var50 != null && var57) {
                        }
                        var60 = new ItemServiceComponent(Items.field_8463);
                    }
                }
            }
        }
        if (var50 == null) {
        }
        if (var50 == null) {
        }
        if (var50 == null) {
        }
        if (var50 == null) {
            if (Intrinsics.areEqual(Items.field_8288)) {
                if (var50 == null) {
                    if (var50 == null) {
                    }
                }
            }
            if (var50 == null) {
                if (Intrinsics.areEqual(Items.FIREWORK_ROCKET)) {
                }
                if (var60 != null && Intrinsics.areEqual(var60.getMinecraftObject(), Items.field_8288) && !(Intrinsics.areEqual(Items.field_8162)) && stack.method_7942() && this.getSaveEnchanted() && !(ElytraTargetModule.INSTANCE.getEnabled())) {
                }
                itemStack2 = stack;
            }
        }
        if (var50 == null) {
        }
        if (var50 == null) {
        }
        if (var50 == null) {
        }
        if (this.getOffhand() == OffhandOffhandMode.OFF && this.getBindSwap() && this.getSwapButton().getNumericValue() != -1 && ServiceComponent13.checkCondition(this.getSwapButton().getNumericValue())) {
            itemStack2 = null;
        }
        if (var50 == null) {
            if (var60 != null) {
            }
            if (var50 == null) {
            }
            if (var50 == null) {
                if (Intrinsics.areEqual(var60.getMinecraftObject(), Items.field_8162) && itemStack2 != null) {
                }
                ItemStack stack2 = itemStack2;
                itemStack2 = null;
                int var62 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition).getNumericValue();
                int var63 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition2).getNumericValue();
                if (var50 == null) {
                    if (var62 == -1) {
                        if (var50 == null) {
                            if (var63 >= 36) {
                            }
                        } else {
                        }
                        return var63;
                    }
                }
                if (var50 == null) {
                    if (var62 >= 36) {
                    }
                } else {
                }
                return var62;
            }
        }
        if (var50 == null) {
            if (var60 != null) {
            }
            if (var50 == null) {
                if (Intrinsics.areEqual(var60.getMinecraftObject(), Items.field_8162)) {
                }
                return -1;
            }
        }
        if (Intrinsics.areEqual(var60.getString(), "")) {
            if (Intrinsics.areEqual(var60.getMinecraftObject(), Items.field_8288)) {
                if (this.getSaveEnchanted()) {
                    if (Intrinsics.areEqual(Items.field_8288)) {
                        if (stack.method_7942()) {
                            if (var50 == null && var50 == null && var50 == null && var50 == null && var50 == null && var50 == null) {
                                if (var54.isActive()) {
                                    if (var50 == null) {
                                        if (var54.getNumericValue() >= 36) {
                                        }
                                    }
                                    return var54.getNumericValue();
                                }
                            }
                        }
                    }
                }
            }
        }
        stack2 = 44;
        if (8 < stack2) {
            if (var50 == null) {
                if (var50 == null) {
                    if (!((CharSequence) var60.getString().length())) {
                    }
                } else {
                }
                if (0) {
                    if (Intrinsics.areEqual(var60.getMinecraftObject())) {
                        if (!(var60.isActive())) {
                            return -1;
                        }
                        if (var50 == null && var50 == null && var50 == null) {
                            if (Intrinsics.areEqual(stack.method_7964().getString(), var60.getString())) {
                                return -1;
                            }
                        }
                    }
                }
                if (var50 == null) {
                    if (stack2 >= 36) {
                    }
                } else {
                }
                var62 = stack2;
                var63 = SharedKt.getPlayer().method_31548().method_5438();
                if (var50 == null) {
                    if (var50 == null) {
                        if (!((CharSequence) var60.getString().length())) {
                        }
                    } else {
                    }
                    if (!(0)) {
                        if (var50 == null) {
                        }
                    }
                    if (var50 == null) {
                        if (var60.isActive2()) {
                            if (var50 == null) {
                                if (var63.getItem().equals(var60.getMinecraftObject()) && Intrinsics.areEqual(var60.getString(), var63.method_7964().getString()) && var63.method_7942()) {
                                }
                            }
                        }
                        var59 = var62;
                        if (var50 != null) {
                        }
                    }
                }
            }
        }
        if (Intrinsics.areEqual(SharedKt.getPlayer().method_6047().getItem())) {
            if (var50 == null && var50 == null) {
                if (SharedKt.getMc().options.field_1904.method_1434()) {
                    return -1;
                }
            }
        }
        return var59;
    }

    private ItemServiceComponent resolveItemServiceComponent(ItemServiceComponent arg0, short arg1, long arg2) {
        Object var40 = arg0;
        if (this.getOnFalling()) {
            if ((this.computeValue2() - (((EventPacketHelper2.INSTANCE.getNumericValue() - 3.0F) / 2.0F) + 3.5F)) < 0.5D) {
                if (!(SharedKt.getPlayer().isFallFlying())) {
                    if (arg1 >= 0) {
                        if (var39 == null && var39 == null && var39 == null && var39 == null) {
                            if (!(FreeCamModule.INSTANCE.getEnabled())) {
                                var40 = new ItemServiceComponent(Items.field_8288);
                            }
                        }
                    }
                }
            }
        }
        if (arg2 > 0L) {
            if (var39 == null) {
                if (this.getOnCrystalInHand()) {
                    Iterator iterator = RunnableServiceComponent.INSTANCE.getList().iterator();
                    if (iterator.hasNext()) {
                        AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) iterator.next();
                        if (arg1 >= 0) {
                            if (var39 == null) {
                            }
                            if (arg2 >= 0L) {
                                if (var39 == null) {
                                    if (EntityHelper4.isFriend((PlayerEntity) player)) {
                                    }
                                }
                            }
                            if (arg1 >= 0) {
                                if (var39 == null) {
                                    if (Intrinsics.areEqual(player, SharedKt.getPlayer())) {
                                    }
                                }
                            }
                            if (arg2 > 0L) {
                                if (var39 == null) {
                                }
                            }
                            if (arg2 >= 0L) {
                                if (var39 == null) {
                                }
                            }
                            if (arg2 > 0L) {
                                if (var39 == null) {
                                }
                            }
                            if (arg2 > 0L) {
                                if (var39 == null) {
                                    if (!(Intrinsics.areEqual(player.method_6047().getItem(), Items.field_8281)) && !(Intrinsics.areEqual(player.method_6047().getItem(), Items.field_8301)) && !(Intrinsics.areEqual(player.method_6079().getItem(), Items.field_8281))) {
                                    }
                                }
                            }
                            var40 = new ItemServiceComponent(Items.field_8288);
                        }
                    }
                    if (arg1 >= 0) {
                    }
                }
            }
            if (arg2 >= 0L) {
                if (var39 == null) {
                    if (this.getOnExlposiveEntities()) {
                        iterator = Lists.newArrayList(SharedKt.getWorld().method_18112()).iterator();
                        if (iterator.hasNext()) {
                            player = iterator.next();
                            if (arg1 >= 0) {
                                if (var39 == null) {
                                }
                                if (arg2 > 0L) {
                                    if (player instanceof class_1674) {
                                        if (arg1 >= 0) {
                                            if (var39 == null && var39 == null) {
                                                if (this.resolveMinecraftObject(player).method_1022(this.resolveMinecraftObject(SharedKt.getPlayer())) <= 12.0D) {
                                                    var40 = new ItemServiceComponent(Items.field_8288);
                                                    if (var39 != null) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (arg2 > 0L) {
                                        if (var39 == null) {
                                            if (player.isAlive()) {
                                            }
                                        }
                                        if (arg1 >= 0) {
                                            if (var39 == null) {
                                                if (EventPacketHelper2.INSTANCE.resolveMinecraftObject().method_1025(this.resolveMinecraftObject(player)) > 144.0D) {
                                                }
                                            }
                                        }
                                    }
                                    if (!(player instanceof EndCrystalEntity)) {
                                        if (!(player instanceof class_1541)) {
                                            if (!(player instanceof class_1701)) {
                                                if (arg1 >= 0) {
                                                    if (var39 == null && var39 == null && var39 == null && var39 == null) {
                                                        if (!(player instanceof class_1548)) {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    var40 = new ItemServiceComponent(Items.field_8288);
                                    if (arg1 >= 0) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (var39 == null) {
                if (this.getOnAnchors()) {
                    iterator = -6;
                    if (iterator < 7) {
                        if (var39 == null) {
                            player = -6;
                            if (player < 7) {
                                int var43 = -6;
                                if (var43 < 7) {
                                    if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(new BlockPos(iterator, player)).getBlock(), Blocks.field_23152)) {
                                        var40 = new ItemServiceComponent(Items.field_8288);
                                        if (arg2 >= 0L) {
                                            if (var39 != null) {
                                            }
                                            if (arg1 >= 0) {
                                            }
                                        }
                                    }
                                }
                                if (arg2 > 0L) {
                                }
                            }
                        }
                    }
                }
            }
        }
        if (arg1 >= 0 && this.getOnMace()) {
            player = (Iterable) SharedKt.getWorld().getPlayers();
            var43 = 0;
            Iterator iterator2 = player.iterator();
            if (iterator2.hasNext()) {
                Object var45 = iterator2.next();
                AbstractClientPlayerEntity player2 = (AbstractClientPlayerEntity) var45;
                int var47 = 0;
                if (var39 == null) {
                }
                if (var39 == null) {
                    if (player2.method_18798().field_1351 >= -0.10000000149011612D) {
                        if (arg2 >= 0L) {
                            if (var39 == null) {
                            }
                        }
                    }
                }
                if (var39 == null) {
                    if (!(Intrinsics.areEqual(player2.method_6047().getItem(), Items.field_49814))) {
                        if (arg1 >= 0) {
                            if (var39 == null) {
                            }
                        }
                    }
                }
                if (arg2 > 0L) {
                    if (var39 == null) {
                    }
                }
                if (var39 == null) {
                    if (INSTANCE.resolveMinecraftObject(SharedKt.getPlayer()).method_1022(INSTANCE.resolveMinecraftObject(player2)) < 12.0D && (player2.field_6036 - player2.getY()) > 0.5D && Intrinsics.areEqual(player2.method_6079().getItem(), Items.field_49814) && !(Intrinsics.areEqual(player2, SharedKt.getPlayer())) && !(EntityHelper4.isFriend((PlayerEntity) player2))) {
                    }
                } else {
                }
            } else {
            }
            iterator = (AbstractClientPlayerEntity) null;
            if (arg1 >= 0) {
                if (var39 == null) {
                    if (iterator != null) {
                        NotifierModule.INSTANCE.updateValue(1);
                        NotifierModule.INSTANCE.getServiceComponent10().executeAction();
                        var40 = new ItemServiceComponent(Items.field_8288);
                    }
                    if (arg2 >= 0L) {
                    }
                    if (var39 != null) {
                    }
                    NotifierModule.INSTANCE.updateValue(0);
                }
            }
        }
        return var40;
    }

    private ItemServiceComponent resolveItemServiceComponent(Item arg0, boolean arg1) {
        if (var22 == null) {
            if (var22 == null) {
            }
            if (this.getBindSwap() && this.getSwapButton().getNumericValue() != -1) {
            }
            if (var22 == null) {
                if (this.getSwapMode() == OffhandSwapMode.CUSTOM) {
                    List positions = this.resolveList();
                    if (var22 == null) {
                        if (!((Collection) positions.isEmpty())) {
                        }
                    } else {
                    }
                    if (0) {
                        int var25 = (((positions.size() - countValue) - 1) % positions.size());
                        if (var22 == null) {
                            if (0 <= var25) {
                                if (var22 == null) {
                                }
                                if (var25 < positions.size()) {
                                }
                            }
                        } else {
                        }
                        if (0) {
                            ItemStack stack = (ItemStack) positions.get();
                            ItemServiceComponent var23 = new ItemServiceComponent(stack.getItem(), 1, 0, stack.method_7964().getString());
                        } else {
                        }
                        if (var22 == null) {
                        }
                        if (var22 == null) {
                            if (ServiceComponent13.checkCondition(this.getSwapButton().getNumericValue()) && serviceComponent10.checkCondition(250)) {
                                serviceComponent10.executeAction();
                            }
                            if (var22 == null) {
                            }
                            if (var22 == null) {
                                if (!(SharedKt.getPlayer().method_6079().isEmpty())) {
                                }
                                if (Intrinsics.areEqual(arg0, Items.field_8255)) {
                                }
                            }
                            if (var22 == null) {
                                if (!(SharedKt.getPlayer().method_6079().isEmpty())) {
                                }
                                if (arg1) {
                                }
                            }
                            if (var22 == null) {
                                if (!(SharedKt.getPlayer().method_6079().isEmpty())) {
                                }
                                if (Intrinsics.areEqual(arg0, Items.field_8255)) {
                                }
                            }
                            if (var22 == null) {
                                if (!(SharedKt.getPlayer().method_6079().isEmpty())) {
                                }
                                if (Intrinsics.areEqual(arg0, Items.field_8288)) {
                                }
                            }
                            var23 = new ItemServiceComponent(Items.field_8575);
                            itemStack2 = var23.getMinecraftObject().method_7854();
                        }
                    }
                }
            }
        }
        return var23;
    }

    private float computeValue() {
        if (var9 == null) {
        }
        if (SharedKt.getPlayer().isFallFlying() && EventPacketHelper2.INSTANCE.getNumericValue() > 15) {
        }
        return this.getTotemHealth();
    }

    private boolean checkCondition() {
        if (SharedKt.getMc().field_1765 instanceof class_3965) {
        }
        Block var17 = Blocks.field_10566;
        Object var16 = var17;
        if (var15 == null) {
        }
        if (var15 == null) {
        }
        if (var15 == null) {
            if (this.getRcGap() != OffhandRcGapMode.OFF && ItemServiceComponent4.checkCondition(SharedKt.getPlayer().method_6047()) && SharedKt.getMc().options.field_1904.method_1434() && !(SharedKt.getPlayer().method_6079().getItem() instanceof class_1819)) {
            }
        } else {
        }
        var17 = 0;
        if (var15 == null) {
        }
        if (var15 == null) {
            if (!(var16 instanceof class_2237) && !(Intrinsics.areEqual(Blocks.field_9980))) {
            }
        } else {
        }
        int var18 = 0;
        if (var15 == null) {
        }
        if (var15 == null) {
            if (!(var18)) {
                if (var15 == null) {
                    if (var17 && NoInteractModule.INSTANCE.getEnabled()) {
                    }
                }
            }
        } else {
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
        List positions = new ArrayList();
        String[] var26 = new String[9];
        var26[0] = this.getSwap1();
        var26[1] = this.getSwap2();
        var26[2] = this.getSwap3();
        var26[3] = this.getSwap4();
        var26[4] = this.getSwap5();
        var26[5] = this.getSwap6();
        var26[6] = this.getSwap7();
        var26[7] = this.getSwap8();
        var26[8] = this.getSwap9();
        var26 = (Iterable) CollectionsKt.listOf();
        int var27 = 0;
        Iterator iterator = var26.iterator();
        if (iterator.hasNext()) {
            Object var29 = iterator.next();
            String var30 = (String) var29;
            int var31 = 0;
            if (var24 == null) {
                if (var24 == null) {
                    if ((CharSequence) var30.length() > 0) {
                    }
                } else {
                }
                if (var24 == null) {
                }
                if (var24 == null) {
                    if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().method_7964().getString())) {
                        positions.add(SharedKt.getPlayer().method_6079());
                        if (0 && !(Intrinsics.areEqual("Air")) && var24 != null) {
                        }
                    }
                    int var32 = 0;
                    if (var32 < 36) {
                        ItemStack stack = SharedKt.getPlayer().method_31548().method_5438();
                        int var34 = 0;
                        if (var24 == null) {
                            if (Intrinsics.areEqual(stack.method_7964().getString())) {
                                positions.add(stack);
                                if (var24 != null) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return positions;
    }

    private static boolean isActive() {
        return INSTANCE.getOffhand() == OffhandOffhandMode.OFF;
    }

    private static boolean isActive2() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive3() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive4() {
        if (var8 == null) {
        }
        if (var8 == null) {
        }
        return INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM;
    }

    private static boolean isActive5() {
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive6() {
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive7() {
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive8() {
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive9() {
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive10() {
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive11() {
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive12() {
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive13() {
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive14() {
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
        }
        if (var11 == null) {
            if (INSTANCE.getOffhand() == OffhandOffhandMode.OFF && INSTANCE.getBindSwap() && INSTANCE.getSwapMode() == OffhandSwapMode.CUSTOM && INSTANCE.getSwapGroup().isActive()) {
            }
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
        if (var3 == null) {
        }
        if (var3 == null) {
            if (Intrinsics.areEqual(arg0.getItem(), Items.field_8288) && !(arg0.method_7942())) {
            }
        } else {
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
        KProperty[] var66 = new KProperty[33];
        INSTANCE = new OffhandModule();
        delayBetweenSwapsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay-between-swaps", 0, new IntRange(0, 10));
        totemHealthSetting = VisibleRenderHelper.registerSetting(INSTANCE, "totem-hp", 16.0F, RangesKt.rangeTo(0.0F, 36.0F));
        totemElytraHealthSetting = VisibleRenderHelper.registerSetting(INSTANCE, "totem-elytra-hp", 16.0F, RangesKt.rangeTo(0.0F, 36.0F));
        outdatedSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pre-1.16.5-swap");
        offhandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "force-item", OffhandOffhandMode.OFF);
        bindSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bind-swap", 0, null, this::isActive);
        swapButtonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-button", new KeyRecord(), null, this::isActive2);
        swapModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap", OffhandSwapMode.GAPPLE_SHIELD, null, this::isActive3);
        swapGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-items", null, this::isActive4);
        int var62 = 4;
        Function0 var63 = this::isActive5;
        TextServiceComponent var65 = new TextServiceComponent("Hold the bind and click items in inv to add them. Hold the bind and use the hotbar to swap items");
        notationSetting = VisibleRenderHelper.registerSetting(INSTANCE, "notation");
        swap1Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap1", "", null, this::isActive6);
        swap2Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap2", "", null, this::isActive7);
        swap3Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap3", "", null, this::isActive8);
        swap4Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap4", "", null, this::isActive9);
        swap5Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap5", "", null, this::isActive10);
        swap6Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap6", "", null, this::isActive11);
        swap7Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap7", "", null, this::isActive12);
        swap8Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap8", "", null, this::isActive13);
        swap9Setting = VisibleRenderHelper.registerSetting(INSTANCE, "swap9", "", null, this::isActive14);
        hotBarSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hot-bar-swap");
        resetAttackCooldownSetting = VisibleRenderHelper.registerSetting(INSTANCE, "reset-attack-cooldown", 0, null, this::isActive15);
        saveEnchantedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "save-enchanted");
        rcGapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "right-click-gapple", OffhandRcGapMode.OFF);
        gapplePrioritySetting = VisibleRenderHelper.registerSetting(INSTANCE, "gapple-priority", OffhandGapplePriorityMode.ENCHANTED, null, this::isActive16);
        crappleSpoofSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crapple-spoof", 1, null, this::isActive17);
        deathVerboseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "death-verbose");
        containersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "containers");
        safetyFactorsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "safety-factors", OptionMode14.BOOLS);
        onCrystalInHandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-crystal-in-hand", 0, INSTANCE.getSafetyFactors());
        onFallingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-falling", 1, INSTANCE.getSafetyFactors());
        onMaceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-mace", 1, INSTANCE.getSafetyFactors());
        onExlposiveEntitiesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-explosive-entities", 1, INSTANCE.getSafetyFactors());
        onAnchorsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-anchors", 1, INSTANCE.getSafetyFactors());
        minecraftRef = class_2960.method_60656("hud/hotbar_selection");
        minecraftRef2 = class_2960.method_60656("hud/hotbar_offhand_left");
        itemStack = Items.field_8162.method_7854();
        atomicBoolean = new AtomicBoolean(0);
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
