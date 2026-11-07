package su.catlean.client.features.modules.pvp.attack;

import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_10209;
import net.minecraft.class_12125;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1743;
import net.minecraft.class_239;
import net.minecraft.class_2561;
import net.minecraft.class_2663;
import net.minecraft.class_2828.class_2830;
import net.minecraft.class_3695;
import net.minecraft.class_3966;
import net.minecraft.class_9334;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract2;
import su.catlean.api.event.events.client.PostTickEvent;
import su.catlean.api.event.events.network.PostTasksProcessEvent;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.SprintEvent;
import su.catlean.api.event.events.player.UpdateCrosshairTarget;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.features.modules.movement.basic.SprintModule;
import su.catlean.client.features.modules.movement.rage.BlinkAttackActionMode;
import su.catlean.client.features.modules.movement.rage.BlinkModule;
import su.catlean.client.features.modules.movement.rage.ElytraTargetModule;
import su.catlean.client.features.modules.movement.rage.MaceElytraTargetModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationRotationServiceComponent4Impl;
import su.catlean.client.services.client.RotationServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent2;
import su.catlean.client.services.client.RotationServiceComponent3;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.RotationServiceComponent5;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.StringServiceComponent;
import su.catlean.client.services.client.SwitchModeServiceComponent;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.player.ActionEntityHelper;
import su.catlean.client.services.player.TargetEntityHelper10;
import su.catlean.client.services.player.ZEROEntityHelper;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.StackShaderComponent3;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.OptionMode16;
import su.catlean.client.types.mappings.AuraEspModeWhenMappings2;

public class AuraModule extends Module {

    public static final AuraModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 attackRangeSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreWallsSetting;
    private static final RangeVisibleSettingPropertyImpl fovSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 rotationModeSetting;
    private static final VisibleVisibleSettingPropertyImpl priorityManualSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchModeSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyWeaponSetting;
    private static final VisibleVisibleSettingPropertyImpl oldDelaySetting;
    private static final RangeVisibleSettingPropertyImpl minCpsSetting;
    private static final RangeVisibleSettingPropertyImpl maxCpsSetting;
    private static final VisibleVisibleSettingPropertyImpl shieldBreakerSetting;
    private static final VisibleVisibleSettingPropertyImpl splashWhileOnGroundSetting;
    private static final VisibleVisibleSettingPropertyImpl backTrackSetting;
    private static final RangeVisibleSettingPropertyImpl moveDelaySetting;
    private static final RangeVisibleSettingPropertyImpl attackChanceSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseWhileEatingSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseInInventorySetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 whileShieldingSetting;
    private static final VisibleVisibleSettingPropertyImpl deathDisableSetting;
    private static final VisibleVisibleSettingPropertyImpl overrideCrosshairSetting;
    private static final VisibleVisibleSettingPropertyImpl rotateOnDisableSetting;
    private static final VisibleVisibleSettingPropertyImpl onHitSwapSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 randomizeDelaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 sprintModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 espSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 sortSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 targetsSetting;
    private static final VisibleVisibleSettingPropertyImpl antibotSetting;
    private static final VisibleVisibleSettingPropertyImpl playersSetting;
    private static final VisibleVisibleSettingPropertyImpl mobsSetting;
    private static final VisibleVisibleSettingPropertyImpl animalsSetting;
    private static final VisibleVisibleSettingPropertyImpl villagersSetting;
    private static final VisibleVisibleSettingPropertyImpl hostilesSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyAngrySetting;
    private static final VisibleVisibleSettingPropertyImpl projectilesSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreInvisibleSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreNamedSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreTeamSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreCreativeSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreNakedSetting;
    private static Entity targetEntity;
    private static List itemList;
    private static MoveFixServiceComponent moveFixServiceComponent;
    private static boolean enabledFlag;
    private static String textValue;

    private AuraModule() {
        super("aura", SubCategoriesKt.getAttackCategory());
    }

    public float getAttackRange() {
        return (Number) attackRangeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public boolean getIgnoreWalls() {
        return (Boolean) ignoreWallsSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    public int getFov() {
        return (Number) fovSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    public AuraRotationMode getRotationMode() {
        return (AuraRotationMode) rotationModeSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    public boolean getPriorityManual() {
        return (Boolean) priorityManualSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    public AuraSwitchMode getSwitchMode() {
        return (AuraSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    public boolean getOnlyWeapon() {
        return (Boolean) onlyWeaponSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    public boolean getOldDelay() {
        return (Boolean) oldDelaySetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    public int getMinCps() {
        return (Number) minCpsSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    public int getMaxCps() {
        return (Number) maxCpsSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    public boolean getShieldBreaker() {
        return (Boolean) shieldBreakerSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    public boolean getSplashWhileOnGround() {
        return (Boolean) splashWhileOnGroundSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    public boolean getBackTrack() {
        return (Boolean) backTrackSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    public int getMoveDelay() {
        return (Number) moveDelaySetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    public int getAttackChance() {
        return (Number) attackChanceSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    public boolean getPauseWhileEating() {
        return (Boolean) pauseWhileEatingSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    public boolean getPauseInInventory() {
        return (Boolean) pauseInInventorySetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    public AuraWhileShieldingMode getWhileShielding() {
        return (AuraWhileShieldingMode) whileShieldingSetting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    public boolean getDeathDisable() {
        return (Boolean) deathDisableSetting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    public boolean getOverrideCrosshair() {
        return (Boolean) overrideCrosshairSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    public boolean getRotateOnDisable() {
        return (Boolean) rotateOnDisableSetting.getValue(this, DELEGATED_PROPERTIES[20]);
    }

    public boolean getOnHitSwap() {
        return (Boolean) onHitSwapSetting.getValue(this, DELEGATED_PROPERTIES[21]);
    }

    public AuraRandomizeDelayMode getRandomizeDelay() {
        return (AuraRandomizeDelayMode) randomizeDelaySetting.getValue(this, DELEGATED_PROPERTIES[22]);
    }

    public AuraSprintMode getSprintMode() {
        return (AuraSprintMode) sprintModeSetting.getValue(this, DELEGATED_PROPERTIES[23]);
    }

    public AuraEspMode getEsp() {
        return (AuraEspMode) espSetting.getValue(this, DELEGATED_PROPERTIES[24]);
    }

    public AuraSortMode getSort() {
        return (AuraSortMode) sortSetting.getValue(this, DELEGATED_PROPERTIES[25]);
    }

    public SettingGroup getTargets() {
        return (SettingGroup) targetsSetting.getValue(this, DELEGATED_PROPERTIES[26]);
    }

    public boolean getAntibot() {
        return (Boolean) antibotSetting.getValue(this, DELEGATED_PROPERTIES[27]);
    }

    public boolean getPlayers() {
        return (Boolean) playersSetting.getValue(this, DELEGATED_PROPERTIES[28]);
    }

    public boolean getMobs() {
        return (Boolean) mobsSetting.getValue(this, DELEGATED_PROPERTIES[29]);
    }

    public boolean getAnimals() {
        return (Boolean) animalsSetting.getValue(this, DELEGATED_PROPERTIES[30]);
    }

    public boolean getVillagers() {
        return (Boolean) villagersSetting.getValue(this, DELEGATED_PROPERTIES[31]);
    }

    public boolean getHostiles() {
        return (Boolean) hostilesSetting.getValue(this, DELEGATED_PROPERTIES[32]);
    }

    public boolean getOnlyAngry() {
        return (Boolean) onlyAngrySetting.getValue(this, DELEGATED_PROPERTIES[33]);
    }

    public boolean getProjectiles() {
        return (Boolean) projectilesSetting.getValue(this, DELEGATED_PROPERTIES[34]);
    }

    public boolean getIgnoreInvisible() {
        return (Boolean) ignoreInvisibleSetting.getValue(this, DELEGATED_PROPERTIES[35]);
    }

    public boolean getIgnoreNamed() {
        return (Boolean) ignoreNamedSetting.getValue(this, DELEGATED_PROPERTIES[36]);
    }

    public boolean getIgnoreTeam() {
        return (Boolean) ignoreTeamSetting.getValue(this, DELEGATED_PROPERTIES[37]);
    }

    public boolean getIgnoreCreative() {
        return (Boolean) ignoreCreativeSetting.getValue(this, DELEGATED_PROPERTIES[38]);
    }

    public boolean getIgnoreNaked() {
        return (Boolean) ignoreNakedSetting.getValue(this, DELEGATED_PROPERTIES[39]);
    }

    public Entity getTarget() {
        return targetEntity;
    }

    public void updateValue(Entity value) {
        targetEntity = value;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (this.checkCondition3()) {
            targetEntity = null;
            if (this.getRotateOnDisable() && enabledFlag) {
                SharedKt.getPlayer().method_64578(moveFixServiceComponent.getNumericValue(), 0, moveFixServiceComponent.getNumericValue2(), 0);
                enabledFlag = 0;
            }
            moveFixServiceComponent = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455());
            Iterable var23 = (Iterable) itemList;
            int var24 = 0;
            Iterator iterator = var23.iterator();
            while (iterator.hasNext()) {
                Object var26 = iterator.next();
                Contract2 var27 = var26;
                int var28 = 0;
                var27.updateValue();
            }
            return;
        }
        if (this.getBackTrack()) {
            EventPacketHelper.INSTANCE.updateValue();
        }
        if (targetEntity != null && targetEntity instanceof LivingEntity && (LivingEntity) targetEntity.method_29504()) {
            StartupServiceComponent.INSTANCE.executeAction(0);
        }
        ActionEntityHelper.INSTANCE.executeAction(this::getUnit);
    }

    private void onSprintEvent(SprintEvent arg0) {
        if (!(RotationServiceComponent2.INSTANCE.isActive())) {
        }
        arg0.setSprinting(0);
    }

    private void onPostTickEvent(PostTickEvent arg0) {
        RotationServiceComponent5.INSTANCE.executeAction();
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if ((class_2663) arg0.getPacket().method_11470() == 48) {
            if (targetEntity != null) {
                if (Intrinsics.areEqual((class_2663) arg0.getPacket().method_11469((World) SharedKt.getWorld()), targetEntity)) {
                    TitleRenderHelper.executeAction("Aura", ("\u0423\u0441\u043f\u0435\u0448\u043d\u043e \u0441\u043b\u043e\u043c\u0430\u043b\u0438 \u0449\u0438\u0442 \u0438\u0433\u0440\u043e\u043a\u0443 " + targetEntity.method_5477().getString()), 2, OptionMode16.SUCCESS);
                }
            }
        }
        if (arg0.getPacket() instanceof class_2663 && (class_2663) arg0.getPacket().method_11470() == 3 && Intrinsics.areEqual((class_2663) arg0.getPacket().method_11469((World) SharedKt.getWorld()), SharedKt.getPlayer()) && this.getDeathDisable()) {
            this.executeAction("Disabling due to death!");
        }
        EventPacketHelper.INSTANCE.executeAction(arg0);
    }

    private void onPostTasksProcessEvent(PostTasksProcessEvent arg0) {
        EventPacketHelper.INSTANCE.executeAction();
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (!(SwitchModeServiceComponent.INSTANCE.checkCondition(this.getOnlyWeapon(), this.getSwitchMode())) || targetEntity == null) {
            return;
        }
        float var29 = (1.0F - RangesKt.coerceIn((SharedKt.getPlayer().distanceTo(targetEntity) / this.getAttackRange()), 0.0F, 1.0F));
        Entity entity = targetEntity;
        StackShaderComponent3.INSTANCE.render(arg0.getStack(), entity);
        var29 = (1.0F - RangesKt.coerceIn((SharedKt.getPlayer().distanceTo(targetEntity) / this.getAttackRange()), 0.0F, 1.0F));
        entity = targetEntity;
        StackShaderComponent3.INSTANCE.render(arg0.getStack(), entity);
        StackShaderComponent3.INSTANCE.render(arg0.getStack(), targetEntity);
        EventPacketHelper.INSTANCE.executeAction(arg0);
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        if (!(SwitchModeServiceComponent.INSTANCE.checkCondition(this.getOnlyWeapon(), this.getSwitchMode())) || targetEntity == null) {
            return;
        }
        StackShaderComponent3.INSTANCE.executeAction();
    }

    private void onUpdateCrosshairTarget(UpdateCrosshairTarget arg0) {
        if (targetEntity == null || !(this.getOverrideCrosshair())) {
            return;
        }
        class_10209.method_64146().method_15407();
        arg0.cancel();
        if (var14 == null) {
        }
        if (var14 == null) {
        }
        class_239 var15 = EventPacketHelper2.INSTANCE.resolveMinecraftObject(SharedKt.getPlayer().method_55754(), this.getAttackRange(), moveFixServiceComponent.getNumericValue(), moveFixServiceComponent.getNumericValue2());
        SharedKt.getMc().field_1765 = var15;
        if (var14 == null) {
            if (var15 instanceof class_3966) {
            }
        } else {
        }
        (class_3966) var15.method_17782().field_1692 = null;
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 87812952281004L);
        this.updateValue();
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 64129331416845L);
        long var5 = (arg0 ^ 38140406740344L);
        long var7 = (arg0 ^ 114833186027750L);
        long var9 = (arg0 ^ 29647348875563L);
        if (this.getRotateOnDisable() && SharedKt.getMc().player != null) {
            SharedKt.getPlayer().method_64578(moveFixServiceComponent.getNumericValue(), 0, moveFixServiceComponent.getNumericValue2(), 0);
        }
        this.updateValue();
    }

    public boolean checkCondition() {
        return SwitchModeServiceComponent.INSTANCE.checkCondition(this.getOnlyWeapon(), this.getSwitchMode());
    }

    public void updateValue() {
        targetEntity = null;
        EventPacketHelper.INSTANCE.executeAction();
        if (SharedKt.getMc().player == null) {
            return;
        }
        moveFixServiceComponent = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455());
        RotationServiceComponent2.INSTANCE.updateValue(0);
    }

    private boolean checkCondition(char arg0, short arg1) {
        if (this.getShieldBreaker() && targetEntity instanceof PlayerEntity) {
            if (arg0 >= 0) {
                if (var23 == null) {
                    if (!((PlayerEntity) targetEntity.method_6115())) {
                    }
                    return false;
                }
            }
        }
        if (arg1 < 0 && var23 == null) {
        }
        if (!(Intrinsics.areEqual((PlayerEntity) targetEntity.method_6079().getItem(), Items.field_8255)) && !(Intrinsics.areEqual((PlayerEntity) targetEntity.method_6047().getItem(), Items.field_8255))) {
            return false;
        }
        StackServiceComponent2 var24 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(this::checkCondition);
        if (arg1 < 0) {
            if (!(var24.isActive())) {
                return false;
            }
        }
        if (arg0 >= 0) {
            if (var24.getNumericValue() > 8) {
                GuiMoveModule.INSTANCE.updateValue(1);
                HandServiceComponent.executeAction(var24.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, 1);
                SharedKt.getInteractionManager().method_2918((PlayerEntity) SharedKt.getPlayer(), targetEntity);
                SharedKt.getPlayer().method_6104(Hand.field_5808);
            }
            HandServiceComponent.executeAction(var24.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, 1);
            GuiMoveModule.INSTANCE.updateValue(0);
            if (arg1 <= 0) {
            } else {
                ItemPacketHelper.INSTANCE.executeAction(var24.getNumericValue());
                SharedKt.getInteractionManager().method_2918((PlayerEntity) SharedKt.getPlayer(), targetEntity);
                SharedKt.getPlayer().method_6104(Hand.field_5808);
                ItemPacketHelper.INSTANCE.updateValue2();
            }
            RotationServiceComponent.INSTANCE.updateValue(10);
        }
        return true;
    }

    private void executeAction(Entity arg0, MoveFixServiceComponent arg1) {
        if (this.getAttackChance() != 100) {
            if ((Random.Default.nextFloat() * 100.0F) < this.getAttackChance()) {
            }
            Iterable var25 = (Iterable) itemList;
            int var26 = 0;
            Iterator iterator = var25.iterator();
            while (iterator.hasNext()) {
                Object var28 = iterator.next();
                Contract2 var29 = var28;
                int var30 = 0;
                var29.executeAction();
            }
            var25 = MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(arg0.method_5829().method_1005());
            if (this.getRotationMode() == AuraRotationMode.GRIM_SILENT) {
                iterator = SharedKt.getPlayer();
                var28 = 0;
                iterator.field_3944.method_52787((Packet) new class_2830(iterator.getX(), iterator.getY(), iterator.getZ(), var25.getNumericValue(), var25.getNumericValue2(), iterator.isOnGround(), iterator.field_5976));
            }
            var26 = (class_12125) SharedKt.getPlayer().method_5998(Hand.field_5808).method_58694(class_9334.field_63631);
            if (var26 != null && !(SharedKt.getInteractionManager().method_2928())) {
                SharedKt.getInteractionManager().method_75407();
            } else {
                SharedKt.getInteractionManager().method_2918((PlayerEntity) SharedKt.getPlayer(), arg0);
            }
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            if (this.getRotationMode() == AuraRotationMode.GRIM_SILENT) {
                var28 = SharedKt.getPlayer();
                var29 = 0;
                var28.field_3944.method_52787((Packet) new class_2830(var28.getX(), var28.getY(), var28.getZ(), var28.method_36454(), var28.method_36455(), var28.isOnGround(), var28.field_5976));
            }
            iterator = (Iterable) itemList;
            var28 = 0;
            var29 = iterator.iterator();
            while (var29.hasNext()) {
                var30 = var29.next();
                Contract2 var31 = var30;
                int var32 = 0;
                var31.executeAction(arg1);
            }
        } else {
            SharedKt.getPlayer().method_6104(Hand.field_5808);
        }
        SharedKt.getPlayer().method_75203();
        TargetEntityHelper10.INSTANCE.updateValue();
    }

    public boolean checkCondition2() {
        if (var7 != null) {
        }
        return SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_1009(-0.25D, 1.0D, -0.25D)).iterator().hasNext();
    }

    private boolean checkCondition3() {
        if (EventPacketHelper2.INSTANCE.isActive2()) {
        }
        if (SharedKt.getPlayer().method_6115()) {
            if (this.getPauseWhileEating()) {
            }
        }
        if (SharedKt.getPlayer().method_6115()) {
            if (this.getWhileShielding() == AuraWhileShieldingMode.PAUSE) {
            }
        }
        if (!(this.getPauseInInventory()) && SharedKt.getPlayer().method_6030().method_58694(class_9334.field_56396) != null && SharedKt.getPlayer().method_6030().method_58694(class_9334.field_56396) == null && SwitchModeServiceComponent.INSTANCE.checkCondition(this.getOnlyWeapon(), this.getSwitchMode())) {
            if (BlinkModule.INSTANCE.getEnabled() && BlinkModule.INSTANCE.getAttackAction() == BlinkAttackActionMode.NONE && !(ElytraTargetModule.INSTANCE.getEnabled())) {
            }
        } else {
        }
        return false;
    }

    public AuraRotationMode resolveAuraRotationMode() {
        if (ElytraTargetModule.INSTANCE.getEnabled()) {
            if (!(SharedKt.getPlayer().isFallFlying())) {
            }
            if (MaceElytraTargetModule.INSTANCE.getEnabled()) {
            }
        } else {
        }
        if (this.getRotationMode() != null) {
        }
        return AuraRotationMode.DEFAULT;
    }

    private static boolean isActive() {
        return INSTANCE.getRotationMode() == AuraRotationMode.SNAP;
    }

    private static boolean isActive2() {
        return INSTANCE.getOldDelay();
    }

    private static boolean isActive3() {
        return INSTANCE.getOldDelay();
    }

    private static boolean isActive4() {
        return INSTANCE.getBackTrack();
    }

    private static boolean isActive5() {
        return INSTANCE.getHostiles();
    }

    private static Unit resolveUnit(boolean arg0, boolean arg1) {
        enabledFlag = 1;
        if (arg0 && arg1 && !(INSTANCE.checkCondition())) {
            INSTANCE.executeAction(targetEntity, moveFixServiceComponent);
        }
        return Unit.INSTANCE;
    }

    private static Unit getUnit() {
        targetEntity = ActionEntityHelper.INSTANCE.resolveMinecraftObject(targetEntity);
        Iterable var41 = (Iterable) itemList;
        int var42 = 0;
        Iterator iterator = var41.iterator();
        while (iterator.hasNext()) {
            Object var44 = iterator.next();
            Contract2 var45 = var44;
            int var46 = 0;
            var45.updateValue();
        }
        if (targetEntity == null) {
            if (INSTANCE.getRotateOnDisable() && enabledFlag) {
                SharedKt.getPlayer().method_64578(moveFixServiceComponent.getNumericValue(), 0, moveFixServiceComponent.getNumericValue2(), 0);
                enabledFlag = 0;
            }
            moveFixServiceComponent = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455());
            return Unit.INSTANCE;
        }
        if (INSTANCE.getSwitchMode() == AuraSwitchMode.NORMAL) {
            SwitchModeServiceComponent.executeAction();
        }
        var41 = RotationServiceComponent2.INSTANCE.checkCondition(RotationServiceComponent.checkCondition());
        if (INSTANCE.getFov() == 1) {
        } else {
        }
        moveFixServiceComponent = INSTANCE.resolveAuraRotationMode().getZEROEntityHelper().resolveMoveFixServiceComponent(targetEntity, moveFixServiceComponent);
        if (INSTANCE.resolveAuraRotationMode().getZEROEntityHelper().isActive()) {
        } else {
            if (!(SharedKt.getPlayer().method_6057(targetEntity))) {
                if (INSTANCE.getIgnoreWalls()) {
                }
            } else {
            }
        }
        var42 = 0;
        SequenceServiceComponent.INSTANCE.executeAction((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(moveFixServiceComponent, 130, this::resolveUnit));
        return Unit.INSTANCE;
    }

    private static boolean checkCondition(ItemStack arg0) {
        return arg0.getItem() instanceof class_1743;
    }

    static {
        KProperty[] var44 = new KProperty[40];
        INSTANCE = new AuraModule();
        attackRangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range", 3.0F, RangesKt.rangeTo(3.0F, 6.0F));
        ignoreWallsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-walls");
        fovSetting = StringServiceComponent.resolveRangeVisibleSettingPropertyImpl(VisibleRenderHelper.registerSetting(INSTANCE, "fov", 180, new IntRange(1, 180)), 1, "trigger");
        rotationModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotation-mode", AuraRotationMode.DEFAULT);
        priorityManualSetting = VisibleRenderHelper.registerSetting(INSTANCE, "priority-manual", 1, null, this::isActive);
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "auto-weapon", AuraSwitchMode.NONE);
        onlyWeaponSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-weapon");
        oldDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "old-delay");
        minCpsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-cps", 9, new IntRange(1, 20), null, this::isActive2);
        maxCpsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-cps", 11, new IntRange(1, 20), null, this::isActive3);
        shieldBreakerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shield-breaker");
        splashWhileOnGroundSetting = VisibleRenderHelper.registerSetting(INSTANCE, "splash-while-on-ground");
        backTrackSetting = VisibleRenderHelper.registerSetting(INSTANCE, "back-track");
        moveDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "move-delay", 250, new IntRange(0, 1000), null, this::isActive4);
        attackChanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "attack-chance", 100, new IntRange(50, 100));
        pauseWhileEatingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-while-eating");
        pauseInInventorySetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-in-inventory");
        whileShieldingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "while-shielding", AuraWhileShieldingMode.UNPRESS);
        deathDisableSetting = VisibleRenderHelper.registerSetting(INSTANCE, "disable-on-death");
        overrideCrosshairSetting = VisibleRenderHelper.registerSetting(INSTANCE, "override-crosshair");
        rotateOnDisableSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate-on-disable");
        onHitSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "offhand-hit-swap");
        randomizeDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "randomize-delay", AuraRandomizeDelayMode.OFF);
        sprintModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sprint", AuraSprintMode.NORMAL);
        espSetting = VisibleRenderHelper.registerSetting(INSTANCE, "esp", AuraEspMode.COMETS);
        sortSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sort", AuraSortMode.Distance);
        targetsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "targets", OptionMode14.BOOLS);
        antibotSetting = VisibleRenderHelper.registerSetting(INSTANCE, "antibot", 1, INSTANCE.getTargets());
        playersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "players", 1, INSTANCE.getTargets());
        mobsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mobs", 1, INSTANCE.getTargets());
        animalsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "animals", 1, INSTANCE.getTargets());
        villagersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "villagers", 1, INSTANCE.getTargets());
        hostilesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hostiles", 1, INSTANCE.getTargets());
        onlyAngrySetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "only-angry-hostiles", 1, INSTANCE.getTargets(), this::isActive5);
        projectilesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "projectiles", 1, INSTANCE.getTargets());
        ignoreInvisibleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-invisible-entities", 0, INSTANCE.getTargets());
        ignoreNamedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-named", 0, INSTANCE.getTargets());
        ignoreTeamSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-team", 0, INSTANCE.getTargets());
        ignoreCreativeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-creative", 1, INSTANCE.getTargets());
        ignoreNakedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-naked", 0, INSTANCE.getTargets());
        var44 = new Contract2[5];
        var44[0] = RotationServiceComponent.INSTANCE;
        var44[1] = RotationServiceComponent5.INSTANCE;
        var44[2] = RotationServiceComponent2.INSTANCE;
        var44[3] = RotationServiceComponent3.INSTANCE;
        var44[4] = SwitchModeServiceComponent.INSTANCE;
        itemList = CollectionsKt.listOf();
        moveFixServiceComponent = new MoveFixServiceComponent(0.0F, 0.0F);
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
