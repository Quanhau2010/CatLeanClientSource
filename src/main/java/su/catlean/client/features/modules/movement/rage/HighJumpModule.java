package su.catlean.client.features.modules.movement.rage;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1713;
import net.minecraft.class_2627;
import net.minecraft.class_2627.class_2628;
import net.minecraft.class_2767;
import net.minecraft.class_2815;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_3417;
import net.minecraft.class_3965;
import net.minecraft.class_4050;
import net.minecraft.class_6880;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.ScreenEvent;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.AfterElytraEvent;
import su.catlean.api.event.events.player.JumpEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PreElytraEvent;
import su.catlean.api.event.events.player.SetPoseEvent;
import su.catlean.api.event.events.world.FireWorkVelocityEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.BlockPlacementInteractMode;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.GuiMoveClickBypassMode;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.features.modules.utility.equip.ElytraSwapModule;
import su.catlean.client.services.client.DirServiceComponent;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationRotationServiceComponent4Impl;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.ServiceComponent38;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.StringServiceComponent;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.types.OptionMode18;

public class HighJumpModule extends Module {

    public static final HighJumpModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl2 verticalSetting;
    private static final RangeVisibleSettingPropertyImpl2 horizontalSetting;
    private static final VisibleVisibleSettingPropertyImpl minimizeClicksSetting;
    private static final VisibleVisibleSettingPropertyImpl offHandFireworkSetting;
    private static final VisibleVisibleSettingPropertyImpl alternativeFireworkSwapSetting;
    private static final RangeVisibleSettingPropertyImpl ticksSetting;
    private static boolean enabledFlag;
    private static int countValue;
    private static ServiceComponent38 serviceComponent38;
    private static float factorValue;

    private HighJumpModule() {
        super("high-jump", SubCategoriesKt.getRageMovementCategory());
    }

    private HighJumpMode getMode() {
        return ((HighJumpMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private float getVertical() {
        return ((Number) verticalSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private float getHorizontal() {
        return ((Number) horizontalSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getMinimizeClicks() {
        return ((Boolean) minimizeClicksSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getOffHandFirework() {
        return ((Boolean) offHandFireworkSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getAlternativeFireworkSwap() {
        return ((Boolean) alternativeFireworkSwapSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private int getTicks() {
        return ((Number) ticksSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    public void updateValue() {
        countValue = 0;
    }

    private void onScreenEvent(ScreenEvent arg0) {
        arg0.cancel();
        enabledFlag = 0;
    }

    private void onJumpEvent(JumpEvent arg0) {
        arg0.cancel();
        arg0.setY(this.getVertical());
        arg0.setXz(this.getHorizontal());
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getPlayer().method_31549().field_7479 || SharedKt.getPlayer().isFallFlying()) {
            return;
        }
        if (this.getMode() == HighJumpMode.GRIM_SHULKER && !((SharedKt.getPlayer().field_6012 % 5)) && EventPacketHelper2.INSTANCE.checkCondition()) {
            Iterable iterable = ((Iterable) TheNetherPacketHelper.INSTANCE.getList());
            int index = 0;
            Iterable iterable2 = iterable;
            Collection collection = ((Collection) new ArrayList());
            Iterator iterator = iterable2.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                collection.add(element);
            }
            Iterator iterator2 = collection.iterator();
            while (iterator2.hasNext()) {
                iterable = ((class_2627) iterator2.next());
                index = iterable.method_11313() != class_2628.field_12063;
                iterable2 = new Box(iterable.method_11016()).method_1009(0.5D, 1.0D, 0.5D);
                collection = new Box(iterable.method_11016()).method_1009(1.5D, 1.0D, 1.5D);
                TextShaderComponent2.checkCondition(iterable2, Color.WHITE);
                if (index) {
                    if (SharedKt.getPlayer().method_5829().method_994(collection)) {
                        SequenceServiceComponent.INSTANCE.executeAction(((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(this.getMinecraftObject()), 0, this::resolveUnit)));
                    }
                }
                if (this.getHorizontal() == 0.0F) {
                    iterator = new double[2];
                    iterator[0] = SharedKt.getPlayer().method_18798().field_1352;
                    iterator[1] = SharedKt.getPlayer().method_18798().field_1350;
                } else {
                }
                SharedKt.getPlayer().method_18800(this.getVertical());
                PacketPacketHelper.handlePacket(((Packet) new class_2815(SharedKt.getPlayer().field_7512.field_7763)));
            }
        }
        iterator2 = ItemPacketHelper.INSTANCE.computeValue();
        index = new Item[1];
        index[0] = Items.FIREWORK_ROCKET;
        iterable = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(index);
        if (iterator2 >= 0) {
            if (iterable.isActive()) {
                if (!(SharedKt.getPlayer().method_5799())) {
                    if (SharedKt.getPlayer().method_5771()) {
                        this.updateValue2();
                        return;
                    }
                }
            }
        }
        SequenceServiceComponent.INSTANCE.executeAction(new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), -90.0F, false, OptionMode18.FORCE), 0);
        if (countValue > (this.getTicks() - 1)) {
            index = countValue;
            countValue = (index + 1);
            if (GuiMoveModule.INSTANCE.getEnabled()) {
                if (GuiMoveModule.INSTANCE.getClickBypass() == GuiMoveClickBypassMode.LEGIT) {
                    EventPacketHelper2.INSTANCE.updateValue6();
                }
            }
            this.updateValue2();
            return;
        }
        if (this.getMode() != HighJumpMode.ELYTRA || index <= (this.getTicks() + 5) || SharedKt.getPlayer().isOnGround()) {
            return;
        }
        if (GuiMoveModule.INSTANCE.getEnabled()) {
            if (GuiMoveModule.INSTANCE.getClickBypass() == GuiMoveClickBypassMode.LEGIT) {
                if (EventPacketHelper2.INSTANCE.checkCondition()) {
                    EventPacketHelper2.INSTANCE.updateValue5();
                    return;
                }
            }
        }
        if (iterator2 >= 36) {
            GuiMoveModule.INSTANCE.updateValue(true);
            index = (iterator2 - 36);
            HandServiceComponent.executeAction(6, index, class_1713.field_7791, true);
            ElytraSwapModule.INSTANCE.updateValue(true);
            SharedKt.getPlayer().startFallFlying();
            PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
            if (!(countValue)) {
                ElytraTargetModule.INSTANCE.executeAction(this.getOffHandFirework(), this.getAlternativeFireworkSwap());
            }
            HandServiceComponent.executeAction(6, index, class_1713.field_7791, true);
            GuiMoveModule.INSTANCE.updateValue(false);
        } else {
            GuiMoveModule.INSTANCE.updateValue(true);
            HandServiceComponent.e(iterator2, 0, null, false);
            int index2 = 14;
            int index3 = 0;
            int index4 = 0;
            HandServiceComponent.e(6, index4, index3, index2);
            if (!(this.getMinimizeClicks())) {
                HandServiceComponent.e(iterator2, 0, null, true);
            }
            ElytraSwapModule.INSTANCE.updateValue(true);
            SharedKt.getPlayer().startFallFlying();
            PacketPacketHelper.handlePacket(((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982)));
            if (!(countValue)) {
                ElytraTargetModule.INSTANCE.executeAction(this.getOffHandFirework(), this.getAlternativeFireworkSwap());
            }
            if (!(this.getMinimizeClicks())) {
                HandServiceComponent.e(iterator2, 0, null, false);
            }
            HandServiceComponent.e(6, 0, null, false);
            HandServiceComponent.e(iterator2, 0, null, true);
            GuiMoveModule.INSTANCE.updateValue(false);
        }
        index = countValue;
        countValue = (index + 1);
    }

    private void onFireWorkVelocityEvent(FireWorkVelocityEvent arg0) {
        if (this.getMode() != HighJumpMode.ELYTRA) {
            return;
        }
        arg0.cancel();
        Vec3d vec = SharedKt.getPlayer().method_18798();
        arg0.setVelocity(SharedKt.getPlayer().method_18798().method_1031((vec.field_1352 * 0.5D), (0.1D + ((1.5D - vec.field_1351) * 0.5D)), (vec.field_1350 * 0.5D)));
    }

    private void onPreElytraEvent(PreElytraEvent arg0) {
        if (this.getMode() != HighJumpMode.ELYTRA) {
            return;
        }
        factorValue = SharedKt.getPlayer().method_36455();
        SharedKt.getPlayer().method_36457(-90.0F);
    }

    private void onAfterElytraEvent(AfterElytraEvent arg0) {
        if (this.getMode() != HighJumpMode.ELYTRA) {
            return;
        }
        SharedKt.getPlayer().method_36457(factorValue);
    }

    private void onSetPoseEvent(SetPoseEvent arg0) {
        if (this.getMode() != HighJumpMode.ELYTRA) {
            return;
        }
        arg0.cancel();
        arg0.setPose(class_4050.field_18076);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (this.getMode() != HighJumpMode.ELYTRA) {
            return;
        }
        class_6880 class6880 = ((class_2767) arg0.getPacket()).method_11894();
        if (!(Intrinsics.areEqual(class6880, class_3417.field_14966)) && !(Intrinsics.areEqual(class6880, class_3417.field_21866)) && !(Intrinsics.areEqual(class6880, class_3417.field_15103)) && !(Intrinsics.areEqual(class6880, class_3417.field_14761)) && !(Intrinsics.areEqual(class6880, class_3417.field_14862)) && !(Intrinsics.areEqual(class6880, class_3417.field_14883)) && !(Intrinsics.areEqual(class6880, class_3417.field_15191))) {
        }
        arg0.cancel();
    }

    private static boolean isActive() {
        return INSTANCE.getMode() == HighJumpMode.ELYTRA;
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() == HighJumpMode.ELYTRA;
    }

    private static boolean isActive3() {
        return INSTANCE.getMode() == HighJumpMode.ELYTRA;
    }

    private static boolean isActive4() {
        return INSTANCE.getMode() == HighJumpMode.ELYTRA;
    }

    private static Unit resolveUnit(DirServiceComponent arg0, class_2627 arg1) {
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, new class_3965(arg0.getMinecraftObject(), arg0.getMinecraftObject(), arg1.method_11016(), false));
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        enabledFlag = 1;
        return Unit.INSTANCE;
    }

    private static void executeAction() {
        SharedKt.getMc().options.field_1903.method_23481(false);
    }

    static {
        KProperty[] items = new KProperty[7];
        INSTANCE = new HighJumpModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", HighJumpMode.VANILLA);
        verticalSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vertical", 0.42F, RangesKt.rangeTo(0.1F, 20.0F));
        horizontalSetting = StringServiceComponent.resolveRangeVisibleSettingPropertyImpl2(VisibleRenderHelper.registerSetting(INSTANCE, "horizontal", 0.0F, RangesKt.rangeTo(0.0F, 5.0F)), 0.0F, "copy-from-player");
        minimizeClicksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "minimize-clicks", false, null, this::isActive);
        offHandFireworkSetting = VisibleRenderHelper.registerSetting(INSTANCE, "offHand-firework", false, null, this::isActive2);
        alternativeFireworkSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "alt-firework-swap", false, null, this::isActive3);
        ticksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ticks", 2, new IntRange(1, 15), null, this::isActive4);
        serviceComponent38 = new ServiceComponent38();
    }

}
