package su.catlean.client.features.modules.pvp.attack;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1661;
import net.minecraft.class_1743;
import net.minecraft.class_1893;
import net.minecraft.class_2824;
import net.minecraft.class_9362;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.ServiceComponent91;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.StackServiceComponent3;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AttributeSwapModule extends Module {

    public static final AttributeSwapModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 maceSetting;
    private static final VisibleVisibleSettingPropertyImpl axeSetting;
    private static final VisibleVisibleSettingPropertyImpl axeOnlyBlockingSetting;
    private static final VisibleVisibleSettingPropertyImpl knockBackSetting;
    private static final VisibleVisibleSettingPropertyImpl axeMaceHitSetting;
    private static final RangeVisibleSettingPropertyImpl axeMaceHitDelaySetting;
    private static int countValue;

    private AttributeSwapModule() {
        super("attribute-swap", SubCategoriesKt.getAttackCategory());
    }

    private int getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private AttributeSwapMaceMode getMace() {
        return ((AttributeSwapMaceMode) maceSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getAxe() {
        return ((Boolean) axeSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getAxeOnlyBlocking() {
        return ((Boolean) axeOnlyBlockingSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getKnockBack() {
        return ((Boolean) knockBackSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getAxeMaceHit() {
        return ((Boolean) axeMaceHitSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private int getAxeMaceHitDelay() {
        return ((Number) axeMaceHitDelaySetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private void onSendPacket(SendPacket arg0) {
        Entity entity = CriticalsModule.INSTANCE.resolveMinecraftObject(((class_2824) arg0.getPacket()));
        if (!(arg0.getPacket() instanceof class_2824) || !(CriticalsModule.INSTANCE.checkCondition(((class_2824) arg0.getPacket()))) || entity == null || entity instanceof EndCrystalEntity) {
            return;
        }
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent23();
        StackServiceComponent2 stackServiceComponent22 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition);
        StackServiceComponent2 stackServiceComponent23 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition2);
        StackServiceComponent2 stackServiceComponent24 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition3);
        StackServiceComponent2 stackServiceComponent25 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition4);
        if (this.getAxeMaceHit() && SharedKt.getPlayer().method_6047().getItem() instanceof class_1743 && stackServiceComponent22.isActive()) {
            if (stackServiceComponent24.isActive()) {
            } else {
            }
            StackServiceComponent2 stackServiceComponent26 = stackServiceComponent22;
            RunnableServiceComponent2.executeAction(this.getAxeMaceHitDelay(), 0, false, this::executeAction);
        } else {
            if (this.getAxeOnlyBlocking()) {
                if (!(Intrinsics.areEqual(((PlayerEntity) entity).method_6079().getItem(), Items.field_8255))) {
                    if (this.getAxe() && !(SharedKt.getPlayer().method_6047().getItem() instanceof class_1743) && entity instanceof PlayerEntity && ((PlayerEntity) entity).method_6115() && Intrinsics.areEqual(((PlayerEntity) entity).method_6047().getItem(), Items.field_8255)) {
                        StackServiceComponent2 stackServiceComponent27 = stackServiceComponent2;
                    }
                }
            }
            if (stackServiceComponent27 != null) {
            }
            if (!(stackServiceComponent27.isActive()) && this.getMace() != AttributeSwapMaceMode.OFF && !(SharedKt.getPlayer().method_6047().getItem() instanceof class_9362)) {
                stackServiceComponent27 = stackServiceComponent22;
            }
            if (stackServiceComponent27 != null) {
            }
            if (!(stackServiceComponent27.isActive()) && this.getKnockBack()) {
                stackServiceComponent27 = stackServiceComponent25;
            }
            countValue = SharedKt.getPlayer().method_31548().method_67532();
            stackServiceComponent27.updateValue();
            stackServiceComponent26 = countValue;
            RunnableServiceComponent2.executeAction(this.getDelay(), 0, false, this::updateValue);
        }
    }

    private void onAfterSendPacket(AfterSendPacket arg0) {
        ItemPacketHelper.INSTANCE.executeAction(countValue);
        countValue = -1;
    }

    private static boolean isActive() {
        return INSTANCE.getAxe();
    }

    private static boolean isActive2() {
        return INSTANCE.getAxeMaceHit();
    }

    private static boolean checkCondition(ItemStack arg0) {
        return Intrinsics.areEqual(arg0.getItem(), Items.field_49814);
    }

    private static boolean checkCondition2(ItemStack arg0) {
        return StackServiceComponent3.computeValue(arg0, class_1893.field_50158) >= 1;
    }

    private static boolean checkCondition3(ItemStack arg0) {
        return StackServiceComponent3.computeValue(arg0, class_1893.field_50157) >= 1;
    }

    private static boolean checkCondition4(ItemStack arg0) {
        if (__UNDEF_KEY__ != null) {
            if (StackServiceComponent3.computeValue(arg0, class_1893.field_9121) >= 1) {
            } else {
            }
        }
        return false;
    }

    private static void executeAction(StackServiceComponent2 arg0, Entity arg1) {
        ItemPacketHelper.INSTANCE.executeAction(arg0.getNumericValue());
        SharedKt.getInteractionManager().method_2918(((PlayerEntity) SharedKt.getPlayer()), arg1);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
    }

    private static void updateValue(int arg0) {
        ItemPacketHelper.INSTANCE.executeAction(arg0);
    }

    static {
        KProperty[] items = new KProperty[7];
        INSTANCE = new AttributeSwapModule();
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 0, new IntRange(0, 5));
        maceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mace", AttributeSwapMaceMode.ANY);
        axeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "axe", true);
        axeOnlyBlockingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-when-target-blocking", true, null, this::isActive);
        knockBackSetting = VisibleRenderHelper.registerSetting(INSTANCE, "knock-back-item", true);
        axeMaceHitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "axe-mace-hit", true);
        axeMaceHitDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "axe-mace-hit-delay", 4, new IntRange(1, 8), null, this::isActive2);
        countValue = -1;
    }

}
