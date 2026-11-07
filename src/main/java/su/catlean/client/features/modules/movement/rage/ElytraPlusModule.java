package su.catlean.client.features.modules.movement.rage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1661;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract6;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.AfterElytraEvent;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PreElytraEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.event.events.player.SetPoseEvent;
import su.catlean.api.event.events.world.FireWorkVelocityEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class ElytraPlusModule extends Module {

    public static final ElytraPlusModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final VisibleVisibleSettingPropertyImpl twoBeeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 liftSetting;
    private static final VisibleVisibleSettingPropertyImpl onlySpaceSetting;
    private static final VisibleVisibleSettingPropertyImpl stopOnGroundSetting;
    private static final VisibleVisibleSettingPropertyImpl infDurabilitySetting;
    private static final VisibleVisibleSettingPropertyImpl verticalSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 ncpStrictModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 antiKickSetting;
    private static final RangeVisibleSettingPropertyImpl2 xzSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 ySpeedSetting;
    private static final RangeVisibleSettingPropertyImpl fireSlotSetting;
    private static final VisibleVisibleSettingPropertyImpl accelerateSetting;
    private static final RangeVisibleSettingPropertyImpl2 accelerateFactorSetting;
    private static final RangeVisibleSettingPropertyImpl2 fireDelaySetting;
    private static final VisibleVisibleSettingPropertyImpl rotateSetting;
    private static final VisibleVisibleSettingPropertyImpl stayMadSetting;
    private static final VisibleVisibleSettingPropertyImpl keepFlyingSetting;
    private static final VisibleVisibleSettingPropertyImpl disableOnFlagSetting;
    private static final VisibleVisibleSettingPropertyImpl allowFireSwapSetting;
    private static final VisibleVisibleSettingPropertyImpl instantFlySetting;
    private static final VisibleVisibleSettingPropertyImpl cruiseControlSetting;
    private static final VisibleVisibleSettingPropertyImpl pitchControlSetting;
    private static final RangeVisibleSettingPropertyImpl2 factorSetting;
    private static final RangeVisibleSettingPropertyImpl2 upSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 downFactorSetting;
    private static final VisibleVisibleSettingPropertyImpl stopMotionSetting;
    private static final RangeVisibleSettingPropertyImpl2 minUpSpeedSetting;
    private static final VisibleVisibleSettingPropertyImpl forceHeightSetting;
    private static final RangeVisibleSettingPropertyImpl manualHeightSetting;
    private static final RangeVisibleSettingPropertyImpl2 sneakDownSpeedSetting;
    private static final VisibleVisibleSettingPropertyImpl speedLimitSetting;
    private static final RangeVisibleSettingPropertyImpl2 maxSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 redeployIntervalSetting;
    private static final RangeVisibleSettingPropertyImpl2 redeployTimeOutSetting;
    private static final RangeVisibleSettingPropertyImpl2 redeployDelaySetting;
    private static final RangeVisibleSettingPropertyImpl infiniteMaxHeightSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 stopMoveSetting;
    private static final RangeVisibleSettingPropertyImpl swapDelaySetting;
    private static final RangeVisibleSettingPropertyImpl fireworkDelaySetting;
    private static final VisibleVisibleSettingPropertyImpl offHandFireworkSetting;
    private static final VisibleVisibleSettingPropertyImpl alternativeFireworkSwapSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseWhileEatingSetting;
    private static final VisibleVisibleSettingPropertyImpl minimizeClicksSetting;
    private static final VisibleVisibleSettingPropertyImpl boostSetting;
    private static final VisibleVisibleSettingPropertyImpl customSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 degrees0Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees5Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees10Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees15Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees20Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees25Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees30Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees35Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees40Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees45Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees50Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees55Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees60Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees65Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees70Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees75Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees80Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees85Setting;
    private static final RangeVisibleSettingPropertyImpl2 degrees90Setting;
    private static final ServiceComponent10 serviceComponent10;
    private static final ServiceComponent10 serviceComponent102;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static float factorValue;
    private static float factorValue2;
    private static float factorValue3;
    private static Module[] moduleArray;

    private ElytraPlusModule() {
        super("elytra-plus", SubCategoriesKt.getRageMovementCategory());
    }

    public ElytraPlusMode getMode() {
        return ((ElytraPlusMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public boolean getTwoBee() {
        return ((Boolean) twoBeeSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public KeyRecord getLift() {
        return ((KeyRecord) liftSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    public boolean getOnlySpace() {
        return ((Boolean) onlySpaceSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    public boolean getStopOnGround() {
        return ((Boolean) stopOnGroundSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    public boolean getInfDurability() {
        return ((Boolean) infDurabilitySetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    public boolean getVertical() {
        return ((Boolean) verticalSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    public ElytraPlusNcpStrictMode getNcpStrictMode() {
        return ((ElytraPlusNcpStrictMode) ncpStrictModeSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    public ElytraPlusAntiKickMode getAntiKick() {
        return ((ElytraPlusAntiKickMode) antiKickSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    public float getXzSpeed() {
        return ((Number) xzSpeedSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    public float getYSpeed() {
        return ((Number) ySpeedSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    public int getFireSlot() {
        return ((Number) fireSlotSetting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    public boolean getAccelerate() {
        return ((Boolean) accelerateSetting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    public float getAccelerateFactor() {
        return ((Number) accelerateFactorSetting.getValue(this, DELEGATED_PROPERTIES[13]));
    }

    public float getFireDelay() {
        return ((Number) fireDelaySetting.getValue(this, DELEGATED_PROPERTIES[14]));
    }

    public boolean getRotate() {
        return ((Boolean) rotateSetting.getValue(this, DELEGATED_PROPERTIES[15]));
    }

    public boolean getStayMad() {
        return ((Boolean) stayMadSetting.getValue(this, DELEGATED_PROPERTIES[16]));
    }

    public boolean getKeepFlying() {
        return ((Boolean) keepFlyingSetting.getValue(this, DELEGATED_PROPERTIES[17]));
    }

    public boolean getDisableOnFlag() {
        return ((Boolean) disableOnFlagSetting.getValue(this, DELEGATED_PROPERTIES[18]));
    }

    public boolean getAllowFireSwap() {
        return ((Boolean) allowFireSwapSetting.getValue(this, DELEGATED_PROPERTIES[19]));
    }

    public boolean getInstantFly() {
        return ((Boolean) instantFlySetting.getValue(this, DELEGATED_PROPERTIES[20]));
    }

    public boolean getCruiseControl() {
        return ((Boolean) cruiseControlSetting.getValue(this, DELEGATED_PROPERTIES[21]));
    }

    public boolean getPitchControl() {
        return ((Boolean) pitchControlSetting.getValue(this, DELEGATED_PROPERTIES[22]));
    }

    public float getFactor() {
        return ((Number) factorSetting.getValue(this, DELEGATED_PROPERTIES[23]));
    }

    public float getUpSpeed() {
        return ((Number) upSpeedSetting.getValue(this, DELEGATED_PROPERTIES[24]));
    }

    public float getDownFactor() {
        return ((Number) downFactorSetting.getValue(this, DELEGATED_PROPERTIES[25]));
    }

    public boolean getStopMotion() {
        return ((Boolean) stopMotionSetting.getValue(this, DELEGATED_PROPERTIES[26]));
    }

    public float getMinUpSpeed() {
        return ((Number) minUpSpeedSetting.getValue(this, DELEGATED_PROPERTIES[27]));
    }

    public boolean getForceHeight() {
        return ((Boolean) forceHeightSetting.getValue(this, DELEGATED_PROPERTIES[28]));
    }

    public int getManualHeight() {
        return ((Number) manualHeightSetting.getValue(this, DELEGATED_PROPERTIES[29]));
    }

    public float getSneakDownSpeed() {
        return ((Number) sneakDownSpeedSetting.getValue(this, DELEGATED_PROPERTIES[30]));
    }

    public boolean getSpeedLimit() {
        return ((Boolean) speedLimitSetting.getValue(this, DELEGATED_PROPERTIES[31]));
    }

    public float getMaxSpeed() {
        return ((Number) maxSpeedSetting.getValue(this, DELEGATED_PROPERTIES[32]));
    }

    public float getRedeployInterval() {
        return ((Number) redeployIntervalSetting.getValue(this, DELEGATED_PROPERTIES[33]));
    }

    public float getRedeployTimeOut() {
        return ((Number) redeployTimeOutSetting.getValue(this, DELEGATED_PROPERTIES[34]));
    }

    public float getRedeployDelay() {
        return ((Number) redeployDelaySetting.getValue(this, DELEGATED_PROPERTIES[35]));
    }

    public int getInfiniteMaxHeight() {
        return ((Number) infiniteMaxHeightSetting.getValue(this, DELEGATED_PROPERTIES[36]));
    }

    public ElytraPlusStopMoveMode getStopMove() {
        return ((ElytraPlusStopMoveMode) stopMoveSetting.getValue(this, DELEGATED_PROPERTIES[37]));
    }

    public int getSwapDelay() {
        return ((Number) swapDelaySetting.getValue(this, DELEGATED_PROPERTIES[38]));
    }

    public int getFireworkDelay() {
        return ((Number) fireworkDelaySetting.getValue(this, DELEGATED_PROPERTIES[39]));
    }

    public boolean getOffHandFirework() {
        return ((Boolean) offHandFireworkSetting.getValue(this, DELEGATED_PROPERTIES[40]));
    }

    public boolean getAlternativeFireworkSwap() {
        return ((Boolean) alternativeFireworkSwapSetting.getValue(this, DELEGATED_PROPERTIES[41]));
    }

    public boolean getPauseWhileEating() {
        return ((Boolean) pauseWhileEatingSetting.getValue(this, DELEGATED_PROPERTIES[42]));
    }

    public boolean getMinimizeClicks() {
        return ((Boolean) minimizeClicksSetting.getValue(this, DELEGATED_PROPERTIES[43]));
    }

    public boolean getBoost() {
        return ((Boolean) boostSetting.getValue(this, DELEGATED_PROPERTIES[44]));
    }

    public boolean getCustomSpeed() {
        return ((Boolean) customSpeedSetting.getValue(this, DELEGATED_PROPERTIES[45]));
    }

    public float getDegrees0() {
        return ((Number) degrees0Setting.getValue(this, DELEGATED_PROPERTIES[46]));
    }

    public float getDegrees5() {
        return ((Number) degrees5Setting.getValue(this, DELEGATED_PROPERTIES[47]));
    }

    public float getDegrees10() {
        return ((Number) degrees10Setting.getValue(this, DELEGATED_PROPERTIES[48]));
    }

    public float getDegrees15() {
        return ((Number) degrees15Setting.getValue(this, DELEGATED_PROPERTIES[49]));
    }

    public float getDegrees20() {
        return ((Number) degrees20Setting.getValue(this, DELEGATED_PROPERTIES[50]));
    }

    public float getDegrees25() {
        return ((Number) degrees25Setting.getValue(this, DELEGATED_PROPERTIES[51]));
    }

    public float getDegrees30() {
        return ((Number) degrees30Setting.getValue(this, DELEGATED_PROPERTIES[52]));
    }

    public float getDegrees35() {
        return ((Number) degrees35Setting.getValue(this, DELEGATED_PROPERTIES[53]));
    }

    public float getDegrees40() {
        return ((Number) degrees40Setting.getValue(this, DELEGATED_PROPERTIES[54]));
    }

    public float getDegrees45() {
        return ((Number) degrees45Setting.getValue(this, DELEGATED_PROPERTIES[55]));
    }

    public float getDegrees50() {
        return ((Number) degrees50Setting.getValue(this, DELEGATED_PROPERTIES[56]));
    }

    public float getDegrees55() {
        return ((Number) degrees55Setting.getValue(this, DELEGATED_PROPERTIES[57]));
    }

    public float getDegrees60() {
        return ((Number) degrees60Setting.getValue(this, DELEGATED_PROPERTIES[58]));
    }

    public float getDegrees65() {
        return ((Number) degrees65Setting.getValue(this, DELEGATED_PROPERTIES[59]));
    }

    public float getDegrees70() {
        return ((Number) degrees70Setting.getValue(this, DELEGATED_PROPERTIES[60]));
    }

    public float getDegrees75() {
        return ((Number) degrees75Setting.getValue(this, DELEGATED_PROPERTIES[61]));
    }

    public float getDegrees80() {
        return ((Number) degrees80Setting.getValue(this, DELEGATED_PROPERTIES[62]));
    }

    public float getDegrees85() {
        return ((Number) degrees85Setting.getValue(this, DELEGATED_PROPERTIES[63]));
    }

    public float getDegrees90() {
        return ((Number) degrees90Setting.getValue(this, DELEGATED_PROPERTIES[64]));
    }

    public ServiceComponent10 getServiceComponent10() {
        return serviceComponent10;
    }

    public ServiceComponent10 getServiceComponent102() {
        return serviceComponent102;
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public boolean isActive2() {
        return enabledFlag2;
    }

    public void updateValue2(boolean value) {
        enabledFlag2 = value;
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
    }

    public float getNumericValue2() {
        return factorValue2;
    }

    public void updateValue2(float value) {
        factorValue2 = value;
    }

    public float getNumericValue3() {
        return factorValue3;
    }

    public void updateValue3(float value) {
        factorValue3 = value;
    }

    public void updateValue() {
        if (SharedKt.getMc().world == null) {
            return;
        }
        factorValue = 0.0F;
        factorValue2 = SharedKt.getPlayer().getY();
        this.getMode().getContract6().executeAction();
    }

    private void onPreElytraEvent(PreElytraEvent arg0) {
        this.getMode().getContract6().executeAction(arg0);
    }

    private void onAfterElytraEvent(AfterElytraEvent arg0) {
        this.getMode().getContract6().executeAction(arg0);
    }

    private void onPreSyncEvent(PreSyncEvent arg0) {
        this.getMode().getContract6().executeAction(arg0);
    }

    public void onMoveEvent(MoveEvent e) {
        this.getMode().getContract6().executeAction(e);
    }

    public void onAfterSendPacket(AfterSendPacket e) {
        this.getMode().getContract6().executeAction(e);
    }

    public void onReceivePacket(ReceivePacket e) {
        this.getMode().getContract6().executeAction(e);
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        this.getMode().getContract6().executeAction(e);
    }

    private void onFireWorkVelocityEvent(FireWorkVelocityEvent arg0) {
        this.getMode().getContract6().executeAction(arg0);
    }

    private void onSetPoseEvent(SetPoseEvent arg0) {
        this.getMode().getContract6().onSetPoseEvent(arg0);
    }

    private void onReceivePacket2(ReceivePacket arg0) {
        this.getMode().getContract6().executeAction(arg0);
    }

    public void updateValue2() {
        this.getMode().getContract6().updateValue();
    }

    public boolean checkCondition() {
        return Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(38).getItem(), Items.ELYTRA);
    }

    public boolean checkCondition(ItemStack stack) {
        return stack.method_57826(class_9334.field_54197);
    }

    public void executeAction(String m) {
        if (!(((CharSequence) m).length())) {
            this.updateValue2();
        } else {
            this.executeAction(m);
        }
    }

    public static void executeAction(ElytraPlusModule arg0, String arg1, int arg2, Object arg3) {
        if ((arg2 & 1) != 0) {
            arg1 = "";
        }
        arg0.executeAction(arg1);
    }

    public String resolveString(String key, Object[] args) {
        Object[] items = new Object[1];
        items[0] = args;
        if (__UNDEF_KEY__ != null) {
        }
        return MessageServiceComponent.Z(this, key, items, false);
    }

    public void updateValue() {
        Object[] items = new Object[1];
        items[0] = String.valueOf(this.getInfiniteMaxHeight());
        this.executeAction(MessageServiceComponent.Z(this, "need-more-height", items, false));
    }

    private static boolean isActive3() {
        return INSTANCE.getMode() == ElytraPlusMode.BOOST;
    }

    private static boolean isActive4() {
        return INSTANCE.getTwoBee();
    }

    private static boolean isActive5() {
        return INSTANCE.getTwoBee();
    }

    private static boolean isActive6() {
        return INSTANCE.getMode() == ElytraPlusMode.PACKET;
    }

    private static boolean isActive7() {
        return INSTANCE.getMode() == ElytraPlusMode.PACKET;
    }

    private static boolean isActive8() {
        return INSTANCE.getMode() == ElytraPlusMode.PACKET;
    }

    private static boolean isActive9() {
        return INSTANCE.getMode() == ElytraPlusMode.PACKET;
    }

    private static boolean isActive10() {
        return INSTANCE.getMode() == ElytraPlusMode.FIRE_WORK;
    }

    private static boolean isActive11() {
        return INSTANCE.getMode() != ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive12() {
        if (INSTANCE.getMode() != ElytraPlusMode.FIRE_WORK) {
            if (INSTANCE.getMode() == ElytraPlusMode.PACKET && INSTANCE.getVertical()) {
            } else {
            }
        }
        return false;
    }

    private static boolean isActive13() {
        return INSTANCE.getMode() == ElytraPlusMode.FIRE_WORK;
    }

    private static boolean isActive14() {
        if (INSTANCE.getMode() != ElytraPlusMode.CONTROL) {
            if (INSTANCE.getMode() == ElytraPlusMode.PACKET) {
            } else {
            }
        }
        return false;
    }

    private static boolean isActive15() {
        if (INSTANCE.getMode() != ElytraPlusMode.CONTROL) {
            if (INSTANCE.getAccelerate() && INSTANCE.getMode() == ElytraPlusMode.PACKET) {
            } else {
            }
        }
        return false;
    }

    private static boolean isActive16() {
        return INSTANCE.getMode() == ElytraPlusMode.FIRE_WORK;
    }

    private static boolean isActive17() {
        return INSTANCE.getMode() == ElytraPlusMode.FIRE_WORK;
    }

    private static boolean isActive18() {
        return INSTANCE.getMode() == ElytraPlusMode.FIRE_WORK;
    }

    private static boolean isActive19() {
        return INSTANCE.getMode() == ElytraPlusMode.FIRE_WORK;
    }

    private static boolean isActive20() {
        return INSTANCE.getMode() == ElytraPlusMode.FIRE_WORK;
    }

    private static boolean isActive21() {
        return INSTANCE.getMode() == ElytraPlusMode.FIRE_WORK;
    }

    private static boolean isActive22() {
        if (INSTANCE.getMode() == ElytraPlusMode.BOOST) {
            if (INSTANCE.getTwoBee()) {
                if (INSTANCE.getMode() == ElytraPlusMode.CONTROL) {
                } else {
                }
            }
        }
        return false;
    }

    private static boolean isActive23() {
        return INSTANCE.getMode() == ElytraPlusMode.BOOST;
    }

    private static boolean isActive24() {
        if (INSTANCE.getMode() != ElytraPlusMode.CONTROL) {
            if (INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK) {
            } else {
            }
        }
        return false;
    }

    private static boolean isActive25() {
        return INSTANCE.getMode() == ElytraPlusMode.BOOST;
    }

    private static boolean isActive26() {
        if (INSTANCE.getMode() == ElytraPlusMode.BOOST) {
            if (INSTANCE.getTwoBee()) {
                if (INSTANCE.getMode() == ElytraPlusMode.CONTROL) {
                } else {
                }
            }
        }
        return false;
    }

    private static boolean isActive27() {
        if (INSTANCE.getMode() == ElytraPlusMode.BOOST) {
            if (INSTANCE.getTwoBee()) {
                if (INSTANCE.getMode() == ElytraPlusMode.CONTROL) {
                } else {
                }
            }
        }
        return false;
    }

    private static boolean isActive28() {
        return !(INSTANCE.getTwoBee());
    }

    private static boolean isActive29() {
        return INSTANCE.getCruiseControl();
    }

    private static boolean isActive30() {
        return INSTANCE.getCruiseControl();
    }

    private static boolean isActive31() {
        return INSTANCE.getForceHeight();
    }

    private static boolean isActive32() {
        return INSTANCE.getMode() == ElytraPlusMode.CONTROL;
    }

    private static boolean isActive33() {
        return INSTANCE.getMode() == ElytraPlusMode.BOOST;
    }

    private static boolean isActive34() {
        return INSTANCE.getMode() == ElytraPlusMode.BOOST;
    }

    private static boolean isActive35() {
        return INSTANCE.getMode() == ElytraPlusMode.BOOST;
    }

    private static boolean isActive36() {
        return INSTANCE.getMode() == ElytraPlusMode.BOOST;
    }

    private static boolean isActive37() {
        return INSTANCE.getMode() == ElytraPlusMode.BOOST;
    }

    private static boolean isActive38() {
        return INSTANCE.getMode() == ElytraPlusMode.INFINITE;
    }

    private static boolean isActive39() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive40() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive41() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive42() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive43() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive44() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive45() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive46() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive47() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive48() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive49() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive50() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive51() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive52() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive53() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive54() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive55() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive56() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive57() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive58() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive59() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive60() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive61() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive62() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive63() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive64() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive65() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    private static boolean isActive66() {
        return INSTANCE.getMode() == ElytraPlusMode.SILENT_FIRE_WORK;
    }

    static {
        KProperty[] items = new KProperty[65];
        INSTANCE = new ElytraPlusModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", ElytraPlusMode.FIRE_WORK);
        twoBeeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vanilla", false, null, this::isActive3);
        liftSetting = VisibleRenderHelper.registerSetting(INSTANCE, "lift", new KeyRecord(0, false, false), null, this::isActive4);
        onlySpaceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-space", true, null, this::isActive5);
        stopOnGroundSetting = VisibleRenderHelper.registerSetting(INSTANCE, "stop-on-ground", false, null, this::isActive6);
        infDurabilitySetting = VisibleRenderHelper.registerSetting(INSTANCE, "inf-durability", true, null, this::isActive7);
        verticalSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vertical", false, null, this::isActive8);
        ncpStrictModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ncp-strict", ElytraPlusNcpStrictMode.Off, null, this::isActive9);
        antiKickSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-kick", ElytraPlusAntiKickMode.Jitter, null, this::isActive10);
        xzSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "x-z-speed", 1.55F, RangesKt.rangeTo(0.1F, 10.0F), null, this::isActive11);
        ySpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "y-speed", 0.47F, RangesKt.rangeTo(0.0F, 2.0F), null, this::isActive12);
        fireSlotSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-slot", 1, new IntRange(1, 9), null, this::isActive13);
        accelerateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "acceleration", false, null, this::isActive14);
        accelerateFactorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "accelerate-factor", 9.0F, RangesKt.rangeTo(0.1F, 10.0F), null, this::isActive15);
        fireDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire-delay", 1.5F, RangesKt.rangeTo(0.0F, 1.5F), null, this::isActive16);
        rotateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate", true, null, this::isActive17);
        stayMadSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ground-safe", false, null, this::isActive18);
        keepFlyingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "keep-flying", false, null, this::isActive19);
        disableOnFlagSetting = VisibleRenderHelper.registerSetting(INSTANCE, "disable-on-flag", false, null, this::isActive20);
        allowFireSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "allow-fire-swap", false, null, this::isActive21);
        instantFlySetting = VisibleRenderHelper.registerSetting(INSTANCE, "instant-fly", true, null, this::isActive22);
        cruiseControlSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cruise-control", false, null, this::isActive23);
        pitchControlSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pitch-control", false, null, this::isActive24);
        factorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "factor", 1.5F, RangesKt.rangeTo(0.1F, 50.0F), null, this::isActive25);
        upSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "up-speed", 1.0F, RangesKt.rangeTo(0.01F, 5.0F), null, this::isActive26);
        downFactorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glide", 1.0F, RangesKt.rangeTo(0.0F, 2.0F), null, this::isActive27);
        stopMotionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "stop-motion", true, null, this::isActive28);
        minUpSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-up-speed", 0.5F, RangesKt.rangeTo(0.1F, 5.0F), null, this::isActive29);
        forceHeightSetting = VisibleRenderHelper.registerSetting(INSTANCE, "force-height", false, null, this::isActive30);
        manualHeightSetting = VisibleRenderHelper.registerSetting(INSTANCE, "height", 121, new IntRange(1, 256), null, this::isActive31);
        sneakDownSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "down-speed", 1.0F, RangesKt.rangeTo(0.01F, 5.0F), null, this::isActive32);
        speedLimitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed-limit", true, null, this::isActive33);
        maxSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-speed", 2.5F, RangesKt.rangeTo(0.1F, 10.0F), null, this::isActive34);
        redeployIntervalSetting = VisibleRenderHelper.registerSetting(INSTANCE, "redeploy-interval", 1.0F, RangesKt.rangeTo(0.1F, 5.0F), null, this::isActive35);
        redeployTimeOutSetting = VisibleRenderHelper.registerSetting(INSTANCE, "redeploy-timeout", 5.0F, RangesKt.rangeTo(0.1F, 20.0F), null, this::isActive36);
        redeployDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "redeploy-delay", 0.5F, RangesKt.rangeTo(0.1F, 1.0F), null, this::isActive37);
        infiniteMaxHeightSetting = VisibleRenderHelper.registerSetting(INSTANCE, "infinite-max-height", 200, new IntRange(50, 360), null, this::isActive38);
        stopMoveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "stop-move", ElytraPlusStopMoveMode.BLOCK, null, this::isActive39);
        swapDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "elytra-delay", 2, new IntRange(0, 40), null, this::isActive40);
        fireworkDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "firework-delay", 8, new IntRange(0, 40), null, this::isActive41);
        offHandFireworkSetting = VisibleRenderHelper.registerSetting(INSTANCE, "offhand-firework", true, null, this::isActive42);
        alternativeFireworkSwapSetting = VisibleRenderHelper.registerSetting(INSTANCE, "alt-firework-swap", false, null, this::isActive43);
        pauseWhileEatingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-while-eating", true, null, this::isActive44);
        minimizeClicksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "minimize-clicks", false, null, this::isActive45);
        boostSetting = VisibleRenderHelper.registerSetting(INSTANCE, "boost", false, null, this::isActive46);
        customSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "custom-speed", false, null, this::isActive47);
        degrees0Setting = VisibleRenderHelper.registerSetting(INSTANCE, "0-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive48);
        degrees5Setting = VisibleRenderHelper.registerSetting(INSTANCE, "5-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive49);
        degrees10Setting = VisibleRenderHelper.registerSetting(INSTANCE, "10-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive50);
        degrees15Setting = VisibleRenderHelper.registerSetting(INSTANCE, "15-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive51);
        degrees20Setting = VisibleRenderHelper.registerSetting(INSTANCE, "20-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive52);
        degrees25Setting = VisibleRenderHelper.registerSetting(INSTANCE, "25-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive53);
        degrees30Setting = VisibleRenderHelper.registerSetting(INSTANCE, "30-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive54);
        degrees35Setting = VisibleRenderHelper.registerSetting(INSTANCE, "35-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive55);
        degrees40Setting = VisibleRenderHelper.registerSetting(INSTANCE, "40-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive56);
        degrees45Setting = VisibleRenderHelper.registerSetting(INSTANCE, "45-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive57);
        degrees50Setting = VisibleRenderHelper.registerSetting(INSTANCE, "50-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive58);
        degrees55Setting = VisibleRenderHelper.registerSetting(INSTANCE, "55-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive59);
        degrees60Setting = VisibleRenderHelper.registerSetting(INSTANCE, "60-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive60);
        degrees65Setting = VisibleRenderHelper.registerSetting(INSTANCE, "65-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive61);
        degrees70Setting = VisibleRenderHelper.registerSetting(INSTANCE, "70-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive62);
        degrees75Setting = VisibleRenderHelper.registerSetting(INSTANCE, "75-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive63);
        degrees80Setting = VisibleRenderHelper.registerSetting(INSTANCE, "80-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive64);
        degrees85Setting = VisibleRenderHelper.registerSetting(INSTANCE, "85-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive65);
        degrees90Setting = VisibleRenderHelper.registerSetting(INSTANCE, "90-degrees", 0.15F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive66);
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
