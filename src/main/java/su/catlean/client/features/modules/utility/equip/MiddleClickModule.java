package su.catlean.client.features.modules.utility.equip;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_124;
import net.minecraft.class_1661;
import net.minecraft.class_239;
import net.minecraft.class_2561;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PickUpBlockEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.render.cosmetic.TrajectoriesModule;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationRotationServiceComponent4Impl;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent37;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.player.EntityHelper2;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.player.PlayerEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class MiddleClickModule extends Module {

    public static final MiddleClickModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 onBlockSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 onAirSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 onEntitySetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 onFlyingSetting;
    private static final VisibleVisibleSettingPropertyImpl silentSetting;
    private static final VisibleVisibleSettingPropertyImpl inventorySetting;
    private static final RangeVisibleSettingPropertyImpl swapDelaySetting;
    private static final VisibleVisibleSettingPropertyImpl antiWasteSetting;
    private static final RangeVisibleSettingPropertyImpl durabilitySetting;
    private static final RangeVisibleSettingPropertyImpl xpFactorSetting;
    private static final VisibleVisibleSettingPropertyImpl pearlOnReleaseSetting;
    private static final ServiceComponent10 serviceComponent10;
    private static boolean enabledFlag;

    private MiddleClickModule() {
        super("middle-click", SubCategoriesKt.getEquipCategory());
    }

    private MiddleClickOnBlockMode getOnBlock() {
        return (MiddleClickOnBlockMode) onBlockSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private MiddleClickOnBlockMode getOnAir() {
        return (MiddleClickOnBlockMode) onAirSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private MiddleClickOnBlockMode getOnEntity() {
        return (MiddleClickOnBlockMode) onEntitySetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private MiddleClickOnBlockMode getOnFlying() {
        return (MiddleClickOnBlockMode) onFlyingSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getSilent() {
        return (Boolean) silentSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getInventory() {
        return (Boolean) inventorySetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private int getSwapDelay() {
        return (Number) swapDelaySetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getAntiWaste() {
        return (Boolean) antiWasteSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private int getDurability() {
        return (Number) durabilitySetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private int getXpFactor() {
        return (Number) xpFactorSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private boolean getPearlOnRelease() {
        return (Boolean) pearlOnReleaseSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private void onPickUpBlockEvent(PickUpBlockEvent arg0) {
        arg0.cancel();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        class_239 var21 = SharedKt.getMc().field_1765;
        if (SharedKt.getMc().options.field_1871.method_1434()) {
            enabledFlag = 1;
            if (SharedKt.getPlayer().isFallFlying()) {
                this.getOnFlying().getFunction0().invoke();
            } else {
                if (var21 instanceof class_3966 && (class_3966) var21.method_17782() instanceof PlayerEntity) {
                    this.getOnEntity().getFunction0().invoke();
                } else {
                    if (var21 instanceof class_3965 && !(SharedKt.getWorld().method_22347((class_3965) var21.method_17777()))) {
                        this.getOnBlock().getFunction0().invoke();
                    } else {
                        this.getOnAir().getFunction0().invoke();
                    } else {
                        if (SharedKt.getPlayer().isFallFlying()) {
                            this.getOnFlying().getFunction02().invoke();
                        } else {
                            if (var21 instanceof class_3966 && (class_3966) var21.method_17782() instanceof PlayerEntity) {
                                this.getOnEntity().getFunction02().invoke();
                            } else {
                                if (var21 instanceof class_3965 && !(SharedKt.getWorld().method_22347((class_3965) var21.method_17777()))) {
                                    this.getOnBlock().getFunction02().invoke();
                                } else {
                                    this.getOnAir().getFunction02().invoke();
                                }
                            }
                        }
                        enabledFlag = 0;
                    }
                }
            }
        }
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (this.getOnBlock() != MiddleClickOnBlockMode.PEARL && this.getOnAir() != MiddleClickOnBlockMode.PEARL && this.getOnEntity() != MiddleClickOnBlockMode.PEARL) {
        }
        Item[] var28 = new Item[1];
        var28[0] = Items.field_8634;
        boolean var27 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().isActive();
        TrajectoriesModule.INSTANCE.executeAction((PlayerEntity) SharedKt.getPlayer(), Items.field_8634, SharedKt.getPlayer().method_36454());
    }

    private boolean checkCondition(int arg0, int arg1) {
        Item[] var21 = new Item[1];
        var21[0] = Items.field_8287;
        if (!(ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().isActive())) {
            return false;
        }
        var21 = (Iterable) EntityHelper2.resolveList(SharedKt.getPlayer());
        int var22 = 0;
        if (var21 instanceof Collection && (Collection) var21.isEmpty()) {
        } else {
            Iterator iterator = var21.iterator();
            if (iterator.hasNext()) {
                Object var24 = iterator.next();
                ItemStack stack = (ItemStack) var24;
                int var26 = 0;
            } else {
            }
        }
        if (arg0 >= 0) {
            if (0) {
                return true;
            }
        }
        return !(this.getAntiWaste());
    }

    private void updateValue() {
        Item[] var31 = new Item[1];
        var31[0] = Items.FIREWORK_ROCKET;
        int var30 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue();
        if (this.getSilent()) {
            if (this.getInventory()) {
                if (this.getInventory() && var30 != -1) {
                }
                ItemPacketHelper.INSTANCE.executeAction(this.getXpFactor());
            } else {
                var31 = new Item[1];
                var31[0] = Items.FIREWORK_ROCKET;
                ItemPacketHelper.INSTANCE.executeAction(ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue());
            } else {
                if (this.getInventory()) {
                    if (this.getInventory() && var30 != -1) {
                    }
                    new ServiceComponent37(SharedKt.getPlayer().method_31548().method_67532(), this.getSwapDelay(), 0).start();
                } else {
                    Item[] var32 = new Item[1];
                    var32[0] = Items.FIREWORK_ROCKET;
                    var31 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue();
                    new ServiceComponent37(SharedKt.getPlayer().method_31548().method_67532(), this.getSwapDelay(), 1).start();
                }
            }
        }
    }

    private void updateValue2() {
        class_3966 var19 = (class_3966) SharedKt.getMc().field_1765;
        if (EntityHelper4.isFriend((PlayerEntity) var19.method_17782())) {
            PlayerEntityHelper.INSTANCE.checkCondition((PlayerEntity) var19.method_17782());
            MessageServiceComponent.S(this, (class_124.field_1061 + var19.method_17782().method_5477().getString() + class_124.field_1080 + MessageServiceComponent.Z(this, "removed", new Object[0])));
        } else {
            PlayerEntityHelper.INSTANCE.checkCondition((PlayerEntity) var19.method_17782());
            MessageServiceComponent.S(this, (class_124.field_1060 + var19.method_17782().method_5477().getString() + class_124.field_1080 + MessageServiceComponent.Z(this, "added", new Object[0])));
        }
    }

    private void executeAction(int arg0) {
        Item[] var24 = new Item[1];
        var24[0] = Items.field_8634;
        int var23 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue();
        Item[] var25 = new Item[1];
        var25[0] = Items.field_8634;
        var24 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue();
        if (arg0 > 0) {
            if (var23 == -1) {
            }
        }
        SequenceServiceComponent.INSTANCE.executeAction((RotationServiceComponent4) new RotationRotationServiceComponent4Impl(new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455()), 200, this::resolveUnit));
    }

    private void updateValue3() {
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), 90.0F), 200, this::getUnit));
    }

    private static boolean isActive() {
        return !(INSTANCE.getSilent());
    }

    private static Unit resolveUnit(int arg0, int arg1) {
        if (INSTANCE.getSilent()) {
            if (INSTANCE.getInventory()) {
                if (INSTANCE.getInventory() && arg0 != -1) {
                }
                ItemPacketHelper.INSTANCE.executeAction(arg0, INSTANCE.getXpFactor());
            } else {
                Item[] var26 = new Item[1];
                var26[0] = Items.field_8634;
                ItemPacketHelper.INSTANCE.executeAction(ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue());
            } else {
                if (INSTANCE.getInventory()) {
                    if (INSTANCE.getInventory() && arg0 != -1) {
                    }
                    new ServiceComponent37(arg0, SharedKt.getPlayer().method_31548().method_67532(), INSTANCE.getSwapDelay(), 0).start();
                } else {
                    if (arg0 != -1 && arg1 != -1) {
                        new ServiceComponent37(arg1, SharedKt.getPlayer().method_31548().method_67532(), INSTANCE.getSwapDelay(), 1).start();
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    private static Unit getUnit() {
        Item[] var9 = new Item[1];
        var9[0] = Items.field_8287;
        ItemPacketHelper.INSTANCE.executeAction(ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue(), INSTANCE.getXpFactor());
        return Unit.INSTANCE;
    }

    public static void executeAction(MiddleClickModule $this) {
        $this.updateValue();
    }

    public static void executeAction(MiddleClickModule $this) {
        $this.updateValue2();
    }

    public static boolean checkCondition(MiddleClickModule $this) {
        return $this.getPearlOnRelease();
    }

    public static void executeAction(MiddleClickModule $this) {
        $this.executeAction();
    }

    public static void executeAction2(MiddleClickModule $this) {
        $this.updateValue3();
    }

    static {
        KProperty[] var30 = new KProperty[11];
        INSTANCE = new MiddleClickModule();
        onBlockSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-block", MiddleClickOnBlockMode.INSTANCE);
        onAirSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-air", MiddleClickOnBlockMode.PEARL);
        onEntitySetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-entity", MiddleClickOnBlockMode.FRIEND);
        onFlyingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-elytra", MiddleClickOnBlockMode.FIREWORK);
        silentSetting = VisibleRenderHelper.registerSetting(INSTANCE, "silent");
        inventorySetting = VisibleRenderHelper.registerSetting(INSTANCE, "inventory");
        swapDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-delay", 100, new IntRange(0, 1000), null, this::isActive);
        antiWasteSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-waste");
        durabilitySetting = VisibleRenderHelper.registerSetting(INSTANCE, "stop-on", 90, new IntRange(0, 100));
        xpFactorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "xp-factor", 1, new IntRange(1, 16));
        pearlOnReleaseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pearl-on-release");
        serviceComponent10 = new ServiceComponent10();
    }

}
