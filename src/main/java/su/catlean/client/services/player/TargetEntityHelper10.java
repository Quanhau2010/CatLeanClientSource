package su.catlean.client.services.player;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_3532;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AuraRotationMode;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.ServiceComponent55;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.TpFilterLowDeltasMode;
import su.catlean.client.types.TpHoldTimingMode;
import su.catlean.client.types.TpPointJitterMode;
import su.catlean.client.types.TpPointMode;
import su.catlean.client.types.TpSpeedDistributionMode;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.types.mappings.TpPointJitterModeWhenMappings;

public class TargetEntityHelper10 extends ZEROEntityHelper {

    public static final TargetEntityHelper10 INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl7 advancedOptionsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 pointSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 pointJitterSetting;
    private static final RangeVisibleSettingPropertyImpl2 pointVRangeSetting;
    private static final RangeVisibleSettingPropertyImpl2 pointHRangeSetting;
    private static final RangeVisibleSettingPropertyImpl2 pointHFreqSetting;
    private static final RangeVisibleSettingPropertyImpl2 pointVFreqSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 speedDistributionSetting;
    private static final RangeVisibleSettingPropertyImpl2 minYawSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 maxYawSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 minPitchSpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 maxPitchSpeedSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 jitterDistributionSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 yawJitterSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 pitchJitterSetting;
    private static final RangeVisibleSettingPropertyImpl2 yawAmplMinSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchAmplMinSetting;
    private static final RangeVisibleSettingPropertyImpl2 yawAmplMaxSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchAmplMaxSetting;
    private static final RangeVisibleSettingPropertyImpl2 yawFreqMinSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchFreqMinSetting;
    private static final RangeVisibleSettingPropertyImpl2 yawFreqMaxSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchFreqMaxSetting;
    private static final RangeVisibleSettingPropertyImpl2 smoothHbScaleSetting;
    private static final RangeVisibleSettingPropertyImpl2 yawAccelerationSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchAccelerationSetting;
    private static final RangeVisibleSettingPropertyImpl2 yawDecelerationSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchDecelerationSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 yawSmootherSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 pitchSmootherSetting;
    private static final RangeVisibleSettingPropertyImpl2 yawAccelerationMinSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchAccelerationMinSetting;
    private static final VisibleVisibleSettingPropertyImpl clientLookSetting;
    private static final VisibleVisibleSettingPropertyImpl overShootSetting;
    private static final RangeVisibleSettingPropertyImpl2 overshootTriggerSetting;
    private static final RangeVisibleSettingPropertyImpl overshootStreakSetting;
    private static final RangeVisibleSettingPropertyImpl2 overshootValueSetting;
    private static final RangeVisibleSettingPropertyImpl overshootMinTicksSetting;
    private static final RangeVisibleSettingPropertyImpl overshootMaxTicksSetting;
    private static final VisibleVisibleSettingPropertyImpl headUpSetting;
    private static final RangeVisibleSettingPropertyImpl huIntervalMinSetting;
    private static final RangeVisibleSettingPropertyImpl huIntervalMaxSetting;
    private static final RangeVisibleSettingPropertyImpl huTicksMinSetting;
    private static final RangeVisibleSettingPropertyImpl huTicksMaxSetting;
    private static final RangeVisibleSettingPropertyImpl2 huSpeedMinSetting;
    private static final RangeVisibleSettingPropertyImpl2 huSpeedMaxSetting;
    private static final VisibleVisibleSettingPropertyImpl clickJitterSetting;
    private static final VisibleVisibleSettingPropertyImpl yaw360Setting;
    private static final RangeVisibleSettingPropertyImpl yaw360ChanceSetting;
    private static final VisibleVisibleSettingPropertyImpl holdAfterHitSetting;
    private static final RangeVisibleSettingPropertyImpl holdMinSetting;
    private static final RangeVisibleSettingPropertyImpl holdMaxSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 holdTimingSetting;
    private static final RangeVisibleSettingPropertyImpl holdChanceSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchMinSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchMaxSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchITMinSetting;
    private static final RangeVisibleSettingPropertyImpl2 pitchITMaxSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 filterLowDeltasSetting;
    private static final RangeVisibleSettingPropertyImpl2 lowDeltaThresholdSetting;
    private static final RangeVisibleSettingPropertyImpl2 replaceMinSetting;
    private static final RangeVisibleSettingPropertyImpl2 replaceMaxSetting;
    private static Vec3d vec3d;
    private static Vec3d vec3d2;
    private static Vec3d vec3d3;
    private static ServiceComponent55 serviceComponent55;
    private static ServiceComponent55 serviceComponent552;
    private static ServiceComponent55 serviceComponent553;
    private static ServiceComponent55 serviceComponent554;
    private static ServiceComponent55 serviceComponent555;
    private static float factorValue;
    private static float factorValue2;
    private static int countValue;
    private static int countValue2;
    private static float factorValue3;
    private static float factorValue4;
    private static int countValue3;
    private static int countValue4;
    private static int countValue5;
    private static int countValue6;
    private static int countValue7;
    private static float factorValue5;
    private static float factorValue6;
    private static int countValue8;
    private static int countValue9;
    private static int countValue10;
    private static final List itemList;
    private static int[] countValueArray;

    private TargetEntityHelper10() {
        super();
    }

    public boolean checkCondition() {
        return AuraModule.INSTANCE.getRotationMode() == AuraRotationMode.ADVANCED;
    }

    public SettingGroup getAdvancedOptions() {
        return ((SettingGroup) advancedOptionsSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public TpPointMode getPoint() {
        return ((TpPointMode) pointSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public TpPointJitterMode getPointJitter() {
        return ((TpPointJitterMode) pointJitterSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    public float getPointVRange() {
        return ((Number) pointVRangeSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    public float getPointHRange() {
        return ((Number) pointHRangeSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    public float getPointHFreq() {
        return ((Number) pointHFreqSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    public float getPointVFreq() {
        return ((Number) pointVFreqSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    public TpSpeedDistributionMode getSpeedDistribution() {
        return ((TpSpeedDistributionMode) speedDistributionSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    public float getMinYawSpeed() {
        return ((Number) minYawSpeedSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    public float getMaxYawSpeed() {
        return ((Number) maxYawSpeedSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    public float getMinPitchSpeed() {
        return ((Number) minPitchSpeedSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    public float getMaxPitchSpeed() {
        return ((Number) maxPitchSpeedSetting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    public TpSpeedDistributionMode getJitterDistribution() {
        return ((TpSpeedDistributionMode) jitterDistributionSetting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    public TpPointJitterMode getYawJitter() {
        return ((TpPointJitterMode) yawJitterSetting.getValue(this, DELEGATED_PROPERTIES[13]));
    }

    public TpPointJitterMode getPitchJitter() {
        return ((TpPointJitterMode) pitchJitterSetting.getValue(this, DELEGATED_PROPERTIES[14]));
    }

    public float getYawAmplMin() {
        return ((Number) yawAmplMinSetting.getValue(this, DELEGATED_PROPERTIES[15]));
    }

    public float getPitchAmplMin() {
        return ((Number) pitchAmplMinSetting.getValue(this, DELEGATED_PROPERTIES[16]));
    }

    public float getYawAmplMax() {
        return ((Number) yawAmplMaxSetting.getValue(this, DELEGATED_PROPERTIES[17]));
    }

    public float getPitchAmplMax() {
        return ((Number) pitchAmplMaxSetting.getValue(this, DELEGATED_PROPERTIES[18]));
    }

    public float getYawFreqMin() {
        return ((Number) yawFreqMinSetting.getValue(this, DELEGATED_PROPERTIES[19]));
    }

    public float getPitchFreqMin() {
        return ((Number) pitchFreqMinSetting.getValue(this, DELEGATED_PROPERTIES[20]));
    }

    public float getYawFreqMax() {
        return ((Number) yawFreqMaxSetting.getValue(this, DELEGATED_PROPERTIES[21]));
    }

    public float getPitchFreqMax() {
        return ((Number) pitchFreqMaxSetting.getValue(this, DELEGATED_PROPERTIES[22]));
    }

    public float getSmoothHbScale() {
        return ((Number) smoothHbScaleSetting.getValue(this, DELEGATED_PROPERTIES[23]));
    }

    public float getYawAcceleration() {
        return ((Number) yawAccelerationSetting.getValue(this, DELEGATED_PROPERTIES[24]));
    }

    public float getPitchAcceleration() {
        return ((Number) pitchAccelerationSetting.getValue(this, DELEGATED_PROPERTIES[25]));
    }

    public float getYawDeceleration() {
        return ((Number) yawDecelerationSetting.getValue(this, DELEGATED_PROPERTIES[26]));
    }

    public float getPitchDeceleration() {
        return ((Number) pitchDecelerationSetting.getValue(this, DELEGATED_PROPERTIES[27]));
    }

    public TpYawSmootherMode getYawSmoother() {
        return ((TpYawSmootherMode) yawSmootherSetting.getValue(this, DELEGATED_PROPERTIES[28]));
    }

    public TpYawSmootherMode getPitchSmoother() {
        return ((TpYawSmootherMode) pitchSmootherSetting.getValue(this, DELEGATED_PROPERTIES[29]));
    }

    public float getYawAccelerationMin() {
        return ((Number) yawAccelerationMinSetting.getValue(this, DELEGATED_PROPERTIES[30]));
    }

    public float getPitchAccelerationMin() {
        return ((Number) pitchAccelerationMinSetting.getValue(this, DELEGATED_PROPERTIES[31]));
    }

    public boolean getClientLook() {
        return ((Boolean) clientLookSetting.getValue(this, DELEGATED_PROPERTIES[32]));
    }

    public boolean getOverShoot() {
        return ((Boolean) overShootSetting.getValue(this, DELEGATED_PROPERTIES[33]));
    }

    public float getOvershootTrigger() {
        return ((Number) overshootTriggerSetting.getValue(this, DELEGATED_PROPERTIES[34]));
    }

    public int getOvershootStreak() {
        return ((Number) overshootStreakSetting.getValue(this, DELEGATED_PROPERTIES[35]));
    }

    public float getOvershootValue() {
        return ((Number) overshootValueSetting.getValue(this, DELEGATED_PROPERTIES[36]));
    }

    public int getOvershootMinTicks() {
        return ((Number) overshootMinTicksSetting.getValue(this, DELEGATED_PROPERTIES[37]));
    }

    public int getOvershootMaxTicks() {
        return ((Number) overshootMaxTicksSetting.getValue(this, DELEGATED_PROPERTIES[38]));
    }

    public boolean getHeadUp() {
        return ((Boolean) headUpSetting.getValue(this, DELEGATED_PROPERTIES[39]));
    }

    public int getHuIntervalMin() {
        return ((Number) huIntervalMinSetting.getValue(this, DELEGATED_PROPERTIES[40]));
    }

    public int getHuIntervalMax() {
        return ((Number) huIntervalMaxSetting.getValue(this, DELEGATED_PROPERTIES[41]));
    }

    public int getHuTicksMin() {
        return ((Number) huTicksMinSetting.getValue(this, DELEGATED_PROPERTIES[42]));
    }

    public int getHuTicksMax() {
        return ((Number) huTicksMaxSetting.getValue(this, DELEGATED_PROPERTIES[43]));
    }

    public float getHuSpeedMin() {
        return ((Number) huSpeedMinSetting.getValue(this, DELEGATED_PROPERTIES[44]));
    }

    public float getHuSpeedMax() {
        return ((Number) huSpeedMaxSetting.getValue(this, DELEGATED_PROPERTIES[45]));
    }

    public boolean getClickJitter() {
        return ((Boolean) clickJitterSetting.getValue(this, DELEGATED_PROPERTIES[46]));
    }

    public boolean getYaw360() {
        return ((Boolean) yaw360Setting.getValue(this, DELEGATED_PROPERTIES[47]));
    }

    public int getYaw360Chance() {
        return ((Number) yaw360ChanceSetting.getValue(this, DELEGATED_PROPERTIES[48]));
    }

    public boolean getHoldAfterHit() {
        return ((Boolean) holdAfterHitSetting.getValue(this, DELEGATED_PROPERTIES[49]));
    }

    public int getHoldMin() {
        return ((Number) holdMinSetting.getValue(this, DELEGATED_PROPERTIES[50]));
    }

    public int getHoldMax() {
        return ((Number) holdMaxSetting.getValue(this, DELEGATED_PROPERTIES[51]));
    }

    public TpHoldTimingMode getHoldTiming() {
        return ((TpHoldTimingMode) holdTimingSetting.getValue(this, DELEGATED_PROPERTIES[52]));
    }

    public int getHoldChance() {
        return ((Number) holdChanceSetting.getValue(this, DELEGATED_PROPERTIES[53]));
    }

    public float getPitchMin() {
        return ((Number) pitchMinSetting.getValue(this, DELEGATED_PROPERTIES[54]));
    }

    public float getPitchMax() {
        return ((Number) pitchMaxSetting.getValue(this, DELEGATED_PROPERTIES[55]));
    }

    public float getPitchITMin() {
        return ((Number) pitchITMinSetting.getValue(this, DELEGATED_PROPERTIES[56]));
    }

    public float getPitchITMax() {
        return ((Number) pitchITMaxSetting.getValue(this, DELEGATED_PROPERTIES[57]));
    }

    public TpFilterLowDeltasMode getFilterLowDeltas() {
        return ((TpFilterLowDeltasMode) filterLowDeltasSetting.getValue(this, DELEGATED_PROPERTIES[58]));
    }

    public float getLowDeltaThreshold() {
        return ((Number) lowDeltaThresholdSetting.getValue(this, DELEGATED_PROPERTIES[59]));
    }

    public float getReplaceMin() {
        return ((Number) replaceMinSetting.getValue(this, DELEGATED_PROPERTIES[60]));
    }

    public float getReplaceMax() {
        return ((Number) replaceMaxSetting.getValue(this, DELEGATED_PROPERTIES[61]));
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity target, MoveFixServiceComponent currentRotation, boolean attackTick) {
        if (__UNDEF_KEY__ == null) {
            if (this.checkCondition2()) {
                if (__UNDEF_KEY__ == null) {
                    if (this.getHoldTiming() == TpHoldTimingMode.BEFORE_RANDOM) {
                    }
                }
                return this.resolveMoveFixServiceComponent(currentRotation.getNumericValue(), currentRotation.getNumericValue2());
            }
        }
        Vec3d vec = this.resolveMinecraftObject(target);
        this.executeAction(target);
        target.method_5857(target.method_5829().method_1014(this.getSmoothHbScale()));
        if (__UNDEF_KEY__ == null) {
            if (!(AuraModule.INSTANCE.getIgnoreWalls())) {
            } else {
            }
        }
        boolean flag = target.checkCondition(currentRotation, (AuraModule.INSTANCE.getAttackRange() + 2.0F), 1, false);
        target.method_5857(target.method_5829().method_1014(this.getSmoothHbScale()));
        if (__UNDEF_KEY__ == null) {
            if (flag) {
                factorValue = (factorValue - this.getYawDeceleration());
                factorValue2 = (factorValue2 - this.getPitchDeceleration());
                if (__UNDEF_KEY__ != null) {
                    factorValue = (factorValue + this.getYawAcceleration());
                    factorValue2 = (factorValue2 + this.getPitchAcceleration());
                }
            }
        }
        factorValue = this.computeValue(factorValue, RangesKt.rangeTo(this.getYawAccelerationMin(), 1.0F));
        factorValue2 = this.computeValue(factorValue2, RangesKt.rangeTo(this.getPitchAccelerationMin(), 1.0F));
        double offset = (Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90.0F);
        double offset2 = Math.toDegrees(Math.atan2((vec.field_1351 - (EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ()))));
        if (this.getOverShoot()) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (countValue > 0) {
                    offset = (offset + (factorValue4 + (this.getOvershootValue() * factorValue3)));
                    int index = countValue;
                    countValue = (index + -1);
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
        }
        if (__UNDEF_KEY__ == null) {
            if (__UNDEF_KEY__ != null && this.getYaw360() && countValue7 > 0) {
                factorValue5 = (factorValue5 + (360.0F / countValue6));
                offset = (offset + (factorValue5 * factorValue6));
                index = countValue7;
                countValue7 = (index + -1);
            }
        }
        index = class_3532.method_15338((offset - currentRotation.getNumericValue()));
        double offset3 = (offset2 - currentRotation.getNumericValue2());
        float factor = (this.computeValue(((ClosedRange) RangesKt.rangeTo(this.getMinYawSpeed(), this.getMaxYawSpeed())), false) * ((Number) this.getYawSmoother().getFunction1().invoke(Double.valueOf(factorValue))));
        float factor2 = (this.computeValue(((ClosedRange) RangesKt.rangeTo(this.getMinPitchSpeed(), this.getMaxPitchSpeed())), false) * ((Number) this.getPitchSmoother().getFunction1().invoke(Double.valueOf(factorValue2))));
        double offset4 = this.computeValue(Math.abs(index), RangesKt.rangeTo(0.0D, factor));
        double offset5 = this.computeValue(Math.abs(offset3), RangesKt.rangeTo(0.0D, factor2));
        if (index > 0.0D) {
        }
        double offset6 = (offset4 + offset4);
        if (offset3 > 0.0D) {
        }
        double offset7 = (offset5 + offset5);
        MoveFixServiceComponent moveFixServiceComponent = this.resolveMoveFixServiceComponent(offset6, offset7);
        offset6 = moveFixServiceComponent.getNumericValue();
        offset7 = moveFixServiceComponent.getNumericValue2();
        if (this.getOverShoot()) {
            if (offset4 > this.getOvershootTrigger()) {
                if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                    if (countValue <= 0) {
                        int index2 = countValue2;
                        countValue2 = (index2 + 1);
                        factorValue4 = 0.0F;
                        if (__UNDEF_KEY__ == null) {
                            if (countValue2 >= this.getOvershootStreak()) {
                                countValue2 = 0;
                                countValue = RangeServiceComponent.f(((ClosedRange) new IntRange(this.getOvershootMinTicks(), this.getOvershootMaxTicks())), false);
                                if (__UNDEF_KEY__ == null) {
                                    if ((offset6 - currentRotation.getNumericValue()) > 0.0F) {
                                    } else {
                                    }
                                }
                                factorValue3 = -1.0F;
                            }
                        }
                    }
                }
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (this.getHeadUp()) {
                index2 = countValue4;
                countValue4 = (index2 + 1);
                if (__UNDEF_KEY__ == null) {
                    if (index2 > countValue5) {
                        countValue5 = RangeServiceComponent.f(((ClosedRange) new IntRange(this.getHuIntervalMin(), this.getHuIntervalMax())), false);
                        countValue4 = 0;
                        countValue3 = RangeServiceComponent.f(((ClosedRange) new IntRange(this.getHuTicksMin(), this.getHuTicksMax())), false);
                    }
                }
            }
        }
        if (this.getHeadUp()) {
            if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                if (countValue3 > 0) {
                    index2 = countValue3;
                    countValue3 = (index2 + -1);
                    offset7 = (offset7 - this.computeValue(((ClosedRange) RangesKt.rangeTo(this.getHuSpeedMin(), this.getHuSpeedMax())), true));
                    offset6 = (offset6 + (offset7 * 0.1F));
                }
                if (__UNDEF_KEY__ == null) {
                    if (this.getClickJitter() && countValue8 >= 0) {
                        index2 = ((Pair) itemList.get(countValue9).get((4 - countValue8)));
                        offset6 = (offset6 + ((Number) index2.getFirst()));
                        offset7 = (offset7 + ((Number) index2.getSecond()));
                        int index3 = countValue8;
                        countValue8 = (index3 + -1);
                    }
                }
            }
        }
        if (this.getFilterLowDeltas() != TpFilterLowDeltasMode.OFF) {
            index2 = (currentRotation.getNumericValue() - offset6);
            index3 = (currentRotation.getNumericValue2() - offset7);
            float factor3 = this.getLowDeltaThreshold();
            float factor4 = Math.abs(index2);
            if (__UNDEF_KEY__ == null) {
                if (0.0F <= factor4) {
                    if (__UNDEF_KEY__ == null) {
                        if (factor4 <= factor3) {
                        }
                    }
                } else {
                }
            }
            if (0) {
                if (this.getFilterLowDeltas() == TpFilterLowDeltasMode.REMOVE) {
                }
                offset6 = (currentRotation.getNumericValue() + RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(this.getReplaceMin(), this.getReplaceMax())), false));
            }
            factor3 = this.getLowDeltaThreshold();
            factor4 = Math.abs(index3);
            if (__UNDEF_KEY__ == null) {
                if (0.0F <= factor4) {
                    if (__UNDEF_KEY__ == null) {
                        if (factor4 <= factor3) {
                        }
                    }
                } else {
                }
            }
            if (0) {
                if (this.getFilterLowDeltas() == TpFilterLowDeltasMode.REMOVE) {
                }
                offset7 = (currentRotation.getNumericValue2() + RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(this.getReplaceMin(), this.getReplaceMax())), false));
            }
        }
        if (SharedKt.getPlayer().method_5829().method_994(target.method_5829())) {
        }
        index2 = new MoveFixServiceComponent(offset6, this.computeValue(offset7, RangesKt.rangeTo(this.getPitchMin(), this.getPitchMax())), false);
        return index2;
    }

    private boolean checkCondition2() {
        if (this.getHoldAfterHit()) {
            countValue10 = (countValue10 + -1);
            if (countValue10 > 0) {
                return true;
            }
        }
        return false;
    }

    private MoveFixServiceComponent resolveMoveFixServiceComponent(float arg0, short arg1, float arg2, int arg3, short arg4) {
        long time = ((SharedKt.getNumericValue() % 10000L) / 500.0F);
        float factor = RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(this.getYawFreqMin(), this.getYawFreqMax())), false);
        float factor2 = RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(this.getYawAmplMin(), this.getYawAmplMax())), false);
        float factor3 = RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(this.getPitchFreqMin(), this.getPitchFreqMax())), false);
        float factor4 = RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(this.getPitchAmplMin(), this.getPitchAmplMax())), false);
        float factor5 = arg0;
        float factor6 = arg2;
        if (__UNDEF_KEY__ == null) {
            factor5 = (factor5 + (Math.sin((time * factor)) * factor2));
        }
        if (arg4 < 0) {
            if (__UNDEF_KEY__ != null) {
                factor5 = (factor5 + (serviceComponent55.computeValue() * factor2));
                if (arg3 > 0) {
                    if (__UNDEF_KEY__ != null) {
                        factor5 = (factor5 + ((Math.sin((SharedKt.getPlayer().field_6012 * factor)) + this.computeValue(((ClosedRange) RangesKt.rangeTo(-0.1F, 0.1F)), true)) * factor2));
                        if (arg1 >= 0) {
                            if (__UNDEF_KEY__ != null) {
                                factor5 = (factor5 + this.computeValue(((ClosedRange) RangesKt.rangeTo(factor2, factor2)), true));
                                if (arg4 < 0) {
                                }
                                if (__UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
                                }
                            }
                        }
                    }
                }
            }
        }
        factor6 = (factor6 + (Math.sin((time * factor3)) * factor4));
        if (arg4 <= 0) {
            if (__UNDEF_KEY__ != null) {
                factor6 = (factor6 + (serviceComponent552.computeValue() * factor4));
                if (arg1 >= 0) {
                    if (__UNDEF_KEY__ != null) {
                        factor6 = (factor6 + ((Math.sin((SharedKt.getPlayer().field_6012 * factor3)) + this.computeValue(((ClosedRange) RangesKt.rangeTo(-0.1F, 0.1F)), true)) * factor4));
                        if (arg3 > 0) {
                            if (__UNDEF_KEY__ != null) {
                                factor6 = (factor6 + this.computeValue(((ClosedRange) RangesKt.rangeTo(factor4, factor4)), true));
                                if (arg4 < 0) {
                                }
                                if (__UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return new MoveFixServiceComponent(factor5, factor6, false);
    }

    private float computeValue(ClosedRange arg0, boolean arg1) {
        if (arg1) {
            if (this.getJitterDistribution() == TpSpeedDistributionMode.FLAT) {
                return RangeServiceComponent.p(arg0, false);
            }
            return (((Number) arg0.getStart()) + ((((Number) arg0.getEndInclusive()) - ((Number) arg0.getStart())) * this.computeValue(((RangeServiceComponent.getNumericValue() + 3.0F) / 6.0F), RangesKt.rangeTo(0.0F, 1.0F))));
        }
        if (this.getSpeedDistribution() == TpSpeedDistributionMode.FLAT) {
            return RangeServiceComponent.p(arg0, false);
        }
        return (((Number) arg0.getStart()) + ((((Number) arg0.getEndInclusive()) - ((Number) arg0.getStart())) * this.computeValue(((RangeServiceComponent.getNumericValue() + 3.0F) / 6.0F), RangesKt.rangeTo(0.0F, 1.0F))));
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        if (__UNDEF_KEY__ == null) {
            if (SharedKt.getPlayer().isFallFlying()) {
                return target.getEyePos();
            }
        }
        long time = ((SharedKt.getNumericValue() % 10000L) / 500.0F);
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        return target.method_5829().method_1005().method_1019(noWhenBranchMatchedException);
        return target.getEyePos().method_1019(noWhenBranchMatchedException);
        return EntityHelper.resolveMinecraftObject(target).method_1019(vec3d).method_1019(noWhenBranchMatchedException);
        return EntityHelper.resolveMinecraftObject(target).method_1019(vec3d3).method_1019(noWhenBranchMatchedException);
        Box box = target.method_5829().method_1002((this.getPointHRange() + 0.1D), (this.getPointVRange() + 0.2D), (this.getPointHRange() + 0.1D));
        return new Vec3d(this.computeValue(SharedKt.getPlayer().getEyePos().field_1352, RangesKt.rangeTo(box.field_1323, box.field_1320)), this.computeValue(SharedKt.getPlayer().getEyePos().field_1351, RangesKt.rangeTo(box.field_1322, box.field_1325)), this.computeValue(SharedKt.getPlayer().getEyePos().field_1350, RangesKt.rangeTo(box.field_1321, box.field_1324)));
    }

    public double computeValue(double receiver, ClosedFloatingPointRange range) {
        double offset = ((Number) range.getStart());
        double offset2 = ((Number) range.getEndInclusive());
        if (__UNDEF_KEY__ == null) {
            if (offset > offset2) {
                offset2 = offset;
                offset = offset2;
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (receiver < offset) {
                return offset;
            }
            if (__UNDEF_KEY__ == null) {
                if (receiver > offset2) {
                    return offset2;
                }
            }
        }
        return receiver;
    }

    public float computeValue(float receiver, ClosedFloatingPointRange range) {
        float factor = ((Number) range.getStart());
        float factor2 = ((Number) range.getEndInclusive());
        if (__UNDEF_KEY__ == null) {
            if (factor > factor2) {
                factor2 = factor;
                factor = factor2;
            }
        }
        if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ == null) {
            if (receiver < factor) {
                return factor;
            }
            if (__UNDEF_KEY__ == null) {
                if (receiver > factor2) {
                    return factor2;
                }
            }
        }
        return receiver;
    }

    public int computeValue(int receiver, IntRange range) {
        int index = range.getStart();
        int index2 = range.getEndInclusive();
        if (__UNDEF_KEY__ == null) {
            if (index > index2) {
                index2 = index;
                index = index2;
            }
        }
        if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ == null) {
            if (receiver < index) {
                return index;
            }
            if (__UNDEF_KEY__ == null) {
                if (receiver > index2) {
                    return index2;
                }
            }
        }
        return receiver;
    }

    public void updateValue() {
        if (this.getYaw360() && RangeServiceComponent.f(((ClosedRange) new IntRange(0, 100)), false) >= (100 - this.getYaw360Chance())) {
            countValue6 = RangeServiceComponent.f(((ClosedRange) new IntRange(7, 9)), false);
            countValue7 = countValue6;
            if (!((SharedKt.getPlayer().field_6012 % 2))) {
            }
            factorValue6 = 1.0F;
        }
        if (this.getClickJitter()) {
            countValue8 = 4;
            countValue9 = RangeServiceComponent.f(((ClosedRange) new IntRange(0, 4)), false);
        }
        if (this.getHoldAfterHit() && RangeServiceComponent.f(((ClosedRange) new IntRange(0, 100)), false) >= (100 - this.getHoldChance())) {
            countValue10 = RangeServiceComponent.f(((ClosedRange) new IntRange(this.getHoldMin(), this.getHoldMax())), false);
        }
        double offset = (0.3D - (this.getPointHRange() / 2.0D));
        double offset2 = (1.81D - (this.getPointVRange() / 2.0D));
        ClosedFloatingPointRange closedFloatingPointRange = RangesKt.rangeTo(offset, offset);
        ClosedFloatingPointRange closedFloatingPointRange2 = RangesKt.rangeTo(0.0D, offset2);
        vec3d3 = new Vec3d(this.computeValue(RangeServiceComponent.k(((ClosedRange) closedFloatingPointRange), false), RangesKt.rangeTo(-0.3D, 0.3D)), this.computeValue(RangeServiceComponent.k(((ClosedRange) closedFloatingPointRange2), false), RangesKt.rangeTo(0.0D, 1.81D)), this.computeValue(RangeServiceComponent.k(((ClosedRange) closedFloatingPointRange), false), RangesKt.rangeTo(-0.3D, 0.3D)));
    }

    public void executeAction(Entity target) {
        double offset = 0.003D;
        double offset2 = 0.03D;
        double offset3 = 0.001D;
        double offset4 = 0.03D;
        float factor = this.getPointHRange();
        double offset5 = target.method_5829().method_17939();
        double offset6 = target.method_5829().method_17940();
        double offset7 = target.method_5829().method_17941();
        if (__UNDEF_KEY__ == null) {
            if (Intrinsics.areEqual(vec3d2, Vec3d.ZERO)) {
                vec3d2 = new Vec3d(RangeServiceComponent.a(RangeServiceComponent.a(RangeServiceComponent.a(factor, factor, false), factor, factor, false), factor, factor, false));
            }
        }
        double offset8 = vec3d2.field_1352;
        double offset9 = vec3d2.field_1351;
        double offset10 = vec3d2.field_1350;
        if (__UNDEF_KEY__ == null) {
            if (vec3d.field_1352 >= ((offset5 - factor) / 2.0F)) {
                offset8 = RangeServiceComponent.a(offset, offset2, false);
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (vec3d.field_1352 <= ((offset5 - factor) / 2.0F)) {
                offset8 = RangeServiceComponent.a(offset, offset2, false);
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (vec3d.field_1351 >= offset6) {
                offset9 = RangeServiceComponent.a(offset3, offset4, false);
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (vec3d.field_1351 <= factor) {
                offset9 = RangeServiceComponent.a(offset3, offset4, false);
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (vec3d.field_1350 >= ((offset7 - factor) / 2.0F)) {
                offset10 = RangeServiceComponent.a(offset, offset2, false);
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (vec3d.field_1350 <= ((offset7 - factor) / 2.0F)) {
                offset10 = RangeServiceComponent.a(offset, offset2, false);
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (-0.03D <= offset8) {
                if (__UNDEF_KEY__ == null) {
                    if (offset8 <= 0.03D) {
                    }
                }
            } else {
            }
        }
        if (__UNDEF_KEY__ == null) {
            if (-0.03D <= offset9) {
                if (__UNDEF_KEY__ == null) {
                    if (offset9 <= 0.03D) {
                    }
                }
            } else {
            }
        }
        if (!(0) && !(0)) {
            if (__UNDEF_KEY__ == null) {
                if (-0.03D <= offset10) {
                    if (__UNDEF_KEY__ == null) {
                        if (offset10 <= 0.03D) {
                        }
                    }
                } else {
                }
            }
            if (0) {
                vec3d2 = new Vec3d(RangeServiceComponent.a(RangeServiceComponent.a(RangeServiceComponent.a(factor, factor, false), factor, factor, false), factor, factor, false));
            }
        }
        vec3d2 = new Vec3d(offset8, offset9, offset10);
        vec3d = vec3d.method_1019(vec3d2);
        vec3d = new Vec3d(this.computeValue(vec3d.field_1352, RangesKt.rangeTo(offset5, offset5)), this.computeValue(vec3d.field_1351, RangesKt.rangeTo(0.0D, offset6)), this.computeValue(vec3d.field_1350, RangesKt.rangeTo(offset7, offset7)));
        vec3d.method_1031(RangeServiceComponent.a(-0.03D, 0.03D, false), 0.0D, RangeServiceComponent.a(-0.03D, 0.03D, false));
    }

    private static boolean isActive() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive2() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive3() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive4() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive5() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive6() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive7() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive8() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive9() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive10() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive11() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive12() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive13() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive14() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive15() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive16() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive17() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive18() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive19() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive20() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive21() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive22() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive23() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive24() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive25() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive26() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive27() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive28() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive29() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive30() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive31() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive32() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive33() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive34() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive35() {
        if (INSTANCE.checkCondition() && INSTANCE.getOverShoot()) {
        } else {
        }
        return false;
    }

    private static boolean isActive36() {
        if (INSTANCE.checkCondition() && INSTANCE.getOverShoot()) {
        } else {
        }
        return false;
    }

    private static boolean isActive37() {
        if (INSTANCE.checkCondition() && INSTANCE.getOverShoot()) {
        } else {
        }
        return false;
    }

    private static boolean isActive38() {
        if (INSTANCE.checkCondition() && INSTANCE.getOverShoot()) {
        } else {
        }
        return false;
    }

    private static boolean isActive39() {
        if (INSTANCE.checkCondition() && INSTANCE.getOverShoot()) {
        } else {
        }
        return false;
    }

    private static boolean isActive40() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive41() {
        if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
        } else {
        }
        return false;
    }

    private static boolean isActive42() {
        if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
        } else {
        }
        return false;
    }

    private static boolean isActive43() {
        if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
        } else {
        }
        return false;
    }

    private static boolean isActive44() {
        if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
        } else {
        }
        return false;
    }

    private static boolean isActive45() {
        if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
        } else {
        }
        return false;
    }

    private static boolean isActive46() {
        if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
        } else {
        }
        return false;
    }

    private static boolean isActive47() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive48() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive49() {
        if (INSTANCE.checkCondition() && INSTANCE.getYaw360()) {
        } else {
        }
        return false;
    }

    private static boolean isActive50() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive51() {
        if (INSTANCE.checkCondition() && INSTANCE.getHoldAfterHit()) {
        } else {
        }
        return false;
    }

    private static boolean isActive52() {
        if (INSTANCE.checkCondition() && INSTANCE.getHoldAfterHit()) {
        } else {
        }
        return false;
    }

    private static boolean isActive53() {
        if (INSTANCE.checkCondition() && INSTANCE.getHoldAfterHit()) {
        } else {
        }
        return false;
    }

    private static boolean isActive54() {
        if (INSTANCE.checkCondition() && INSTANCE.getHoldAfterHit()) {
        } else {
        }
        return false;
    }

    private static boolean isActive55() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive56() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive57() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive58() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive59() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive60() {
        return INSTANCE.getFilterLowDeltas() != TpFilterLowDeltasMode.OFF;
    }

    private static boolean isActive61() {
        return INSTANCE.getFilterLowDeltas() == TpFilterLowDeltasMode.REPLACE;
    }

    private static boolean isActive62() {
        return INSTANCE.getFilterLowDeltas() == TpFilterLowDeltasMode.REPLACE;
    }

    static {
        KProperty[] items = new KProperty[62];
        INSTANCE = new TargetEntityHelper10();
        advancedOptionsSetting = VisibleRenderHelper.registerSetting(((Module) AuraModule.INSTANCE), "advanced", null, this::isActive);
        pointSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(((Module) AuraModule.INSTANCE), "point", TpPointMode.CENTER, INSTANCE.getAdvancedOptions(), this::isActive2);
        pointJitterSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(((Module) AuraModule.INSTANCE), "point-jitter", TpPointJitterMode.NONE, INSTANCE.getAdvancedOptions(), this::isActive3);
        pointVRangeSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "point-v-range", 0.1F, RangesKt.rangeTo(0.01F, 1.8F), INSTANCE.getAdvancedOptions(), this::isActive4);
        pointHRangeSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "point-h-range", 0.1F, RangesKt.rangeTo(0.01F, 0.3F), INSTANCE.getAdvancedOptions(), this::isActive5);
        pointHFreqSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "point-h-freq", 20.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive6);
        pointVFreqSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "point-v-freq", 10.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive7);
        speedDistributionSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(((Module) AuraModule.INSTANCE), "speed-distribution", TpSpeedDistributionMode.FLAT, INSTANCE.getAdvancedOptions(), this::isActive8);
        minYawSpeedSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "min-yaw-speed", 30.0F, RangesKt.rangeTo(0.1F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive9);
        maxYawSpeedSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "max-yaw-speed", 60.0F, RangesKt.rangeTo(0.1F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive10);
        minPitchSpeedSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "min-pitch-speed", 10.0F, RangesKt.rangeTo(0.1F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive11);
        maxPitchSpeedSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "max-pitch-speed", 20.0F, RangesKt.rangeTo(0.1F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive12);
        jitterDistributionSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(((Module) AuraModule.INSTANCE), "jitter-distribution", TpSpeedDistributionMode.NORMAL, INSTANCE.getAdvancedOptions(), this::isActive13);
        yawJitterSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(((Module) AuraModule.INSTANCE), "yaw-jitter", TpPointJitterMode.NONE, INSTANCE.getAdvancedOptions(), this::isActive14);
        pitchJitterSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(((Module) AuraModule.INSTANCE), "pitch-jitter", TpPointJitterMode.NONE, INSTANCE.getAdvancedOptions(), this::isActive15);
        yawAmplMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "yaw-ampl-min", 5.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive16);
        pitchAmplMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "pitch-ampl-min", 3.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive17);
        yawAmplMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "yaw-ampl-max", 10.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive18);
        pitchAmplMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "pitch-ampl-max", 5.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive19);
        yawFreqMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "yaw-freq-min", 20.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive20);
        pitchFreqMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "pitch-freq-min", 10.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive21);
        yawFreqMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "yaw-freq-max", 40.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive22);
        pitchFreqMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "pitch-freq-max", 20.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive23);
        smoothHbScaleSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "smooth-box-expand", 0.0F, RangesKt.rangeTo(0.1F, 5.0F), INSTANCE.getAdvancedOptions(), this::isActive24);
        yawAccelerationSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "yaw-accel", 1.0F, RangesKt.rangeTo(0.1F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive25);
        pitchAccelerationSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "pitch-accel", 1.0F, RangesKt.rangeTo(0.1F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive26);
        yawDecelerationSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "yaw-decel", 0.0F, RangesKt.rangeTo(0.0F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive27);
        pitchDecelerationSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "pitch-decel", 0.0F, RangesKt.rangeTo(0.0F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive28);
        yawSmootherSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(((Module) AuraModule.INSTANCE), "yaw-smoother", TpYawSmootherMode.LINEAR, INSTANCE.getAdvancedOptions(), this::isActive29);
        pitchSmootherSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(((Module) AuraModule.INSTANCE), "pitch-smoother", TpYawSmootherMode.LINEAR, INSTANCE.getAdvancedOptions(), this::isActive30);
        yawAccelerationMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "min-factor-yaw", 0.5F, RangesKt.rangeTo(0.0F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive31);
        pitchAccelerationMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "min-factor-pitch", 0.5F, RangesKt.rangeTo(0.0F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive32);
        clientLookSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "client-look", false, INSTANCE.getAdvancedOptions(), this::isActive33);
        overShootSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "over-shoot", false, INSTANCE.getAdvancedOptions(), this::isActive34);
        overshootTriggerSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "os-trigger", 45.0F, RangesKt.rangeTo(20.0F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive35);
        Function0 function0 = this::isActive36;
        SettingGroup settingGroup = INSTANCE.getAdvancedOptions();
        IntRange intRange = new IntRange(1, 10);
        overshootStreakSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "os-streak", 3, intRange, settingGroup, function0);
        overshootValueSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "os-value", 25.0F, RangesKt.rangeTo(20.0F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive37);
        function0 = this::isActive38;
        settingGroup = INSTANCE.getAdvancedOptions();
        intRange = new IntRange(0, 10);
        overshootMinTicksSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "os-min-ticks", 2, intRange, settingGroup, function0);
        function0 = this::isActive39;
        settingGroup = INSTANCE.getAdvancedOptions();
        intRange = new IntRange(0, 10);
        overshootMaxTicksSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "os-max-ticks", 2, intRange, settingGroup, function0);
        headUpSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "head-up", false, INSTANCE.getAdvancedOptions(), this::isActive40);
        function0 = this::isActive41;
        settingGroup = INSTANCE.getAdvancedOptions();
        intRange = new IntRange(5, 400);
        huIntervalMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "hu-interval-min", 165, intRange, settingGroup, function0);
        function0 = this::isActive42;
        settingGroup = INSTANCE.getAdvancedOptions();
        intRange = new IntRange(5, 400);
        huIntervalMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "hu-interval-max", 180, intRange, settingGroup, function0);
        function0 = this::isActive43;
        settingGroup = INSTANCE.getAdvancedOptions();
        intRange = new IntRange(1, 20);
        huTicksMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "hu-ticks-min", 3, intRange, settingGroup, function0);
        function0 = this::isActive44;
        settingGroup = INSTANCE.getAdvancedOptions();
        intRange = new IntRange(1, 20);
        huTicksMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "hu-ticks-max", 6, intRange, settingGroup, function0);
        huSpeedMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "hu-speed-min", 5.0F, RangesKt.rangeTo(1.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive45);
        huSpeedMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "hu-speed-max", 36.0F, RangesKt.rangeTo(1.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive46);
        clickJitterSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "click-jitter", false, INSTANCE.getAdvancedOptions(), this::isActive47);
        yaw360Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "do-360", false, INSTANCE.getAdvancedOptions(), this::isActive48);
        function0 = this::isActive49;
        settingGroup = INSTANCE.getAdvancedOptions();
        intRange = new IntRange(1, 100);
        yaw360ChanceSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "do-360-chance", 20, intRange, settingGroup, function0);
        holdAfterHitSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "hold-after-hit", false, INSTANCE.getAdvancedOptions(), this::isActive50);
        function0 = this::isActive51;
        settingGroup = INSTANCE.getAdvancedOptions();
        intRange = new IntRange(0, 15);
        holdMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "hold-min", 5, intRange, settingGroup, function0);
        function0 = this::isActive52;
        settingGroup = INSTANCE.getAdvancedOptions();
        intRange = new IntRange(0, 15);
        holdMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "hold-max", 7, intRange, settingGroup, function0);
        holdTimingSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(((Module) AuraModule.INSTANCE), "hold-timing", TpHoldTimingMode.AFTER_RANDOM, INSTANCE.getAdvancedOptions(), this::isActive53);
        function0 = this::isActive54;
        settingGroup = INSTANCE.getAdvancedOptions();
        intRange = new IntRange(1, 100);
        holdChanceSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl(((Module) AuraModule.INSTANCE), "hold-chance", 100, intRange, settingGroup, function0);
        pitchMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "pitch-min", -90.0F, RangesKt.rangeTo(-90.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive55);
        pitchMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "pitch-max", 90.0F, RangesKt.rangeTo(-90.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive56);
        pitchITMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "pitch-in-target-min", -90.0F, RangesKt.rangeTo(-90.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive57);
        pitchITMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "pitch-in-target-max", 90.0F, RangesKt.rangeTo(-90.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive58);
        filterLowDeltasSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(((Module) AuraModule.INSTANCE), "filter-low-deltas", TpFilterLowDeltasMode.OFF, INSTANCE.getAdvancedOptions(), this::isActive59);
        lowDeltaThresholdSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "low-delta-threshold", 1.0F, RangesKt.rangeTo(0.0F, 20.0F), INSTANCE.getAdvancedOptions(), this::isActive60);
        replaceMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "replace-min", 3.0F, RangesKt.rangeTo(0.0F, 45.0F), INSTANCE.getAdvancedOptions(), this::isActive61);
        replaceMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(((Module) AuraModule.INSTANCE), "replace-max", 5.0F, RangesKt.rangeTo(0.0F, 45.0F), INSTANCE.getAdvancedOptions(), this::isActive62);
        vec3d = Vec3d.ZERO;
        vec3d2 = Vec3d.ZERO;
        vec3d3 = Vec3d.ZERO;
        serviceComponent55 = new ServiceComponent55(0.0F, 0.0F);
        serviceComponent552 = new ServiceComponent55(0.0F, 0.0F);
        serviceComponent553 = new ServiceComponent55(0.0F, 0.0F);
        serviceComponent554 = new ServiceComponent55(0.0F, 0.0F);
        serviceComponent555 = new ServiceComponent55(0.0F, 0.0F);
        factorValue = 1.0F;
        factorValue2 = 1.0F;
        countValue5 = RangeServiceComponent.P(INSTANCE.getHuIntervalMin(), INSTANCE.getHuIntervalMax(), false);
        items = new List[5];
        Pair[] items2 = new Pair[5];
        items2[0] = TuplesKt.to(Double.valueOf(0.15000153D), Double.valueOf(0.14999962D));
        items2[1] = TuplesKt.to(Double.valueOf(-0.15000153D), Double.valueOf(-0.14999962D));
        items2[2] = TuplesKt.to(Double.valueOf(-0.6000061D), Double.valueOf(0.0D));
        items2[3] = TuplesKt.to(Double.valueOf(-0.6000061D), Double.valueOf(0.0D));
        items2[4] = TuplesKt.to(Double.valueOf(0.45000458D), Double.valueOf(0.0D));
        items[0] = CollectionsKt.listOf(items2);
        items2 = new Pair[5];
        items2[0] = TuplesKt.to(Double.valueOf(-0.15000153D), Double.valueOf(0.0D));
        items2[1] = TuplesKt.to(Double.valueOf(-0.30000305D), Double.valueOf(0.0D));
        items2[2] = TuplesKt.to(Double.valueOf(0.30000305D), Double.valueOf(0.14999962D));
        items2[3] = TuplesKt.to(Double.valueOf(0.15000153D), Double.valueOf(-0.14999962D));
        items2[4] = TuplesKt.to(Double.valueOf(0.0D), Double.valueOf(0.0D));
        items[1] = CollectionsKt.listOf(items2);
        items2 = new Pair[5];
        items2[0] = TuplesKt.to(Double.valueOf(0.15000153D), Double.valueOf(-0.14999962D));
        items2[1] = TuplesKt.to(Double.valueOf(-0.6000061D), Double.valueOf(0.0D));
        items2[2] = TuplesKt.to(Double.valueOf(0.15000153D), Double.valueOf(0.14999962D));
        items2[3] = TuplesKt.to(Double.valueOf(-0.15000153D), Double.valueOf(0.0D));
        items2[4] = TuplesKt.to(Double.valueOf(0.30000305D), Double.valueOf(0.0D));
        items[2] = CollectionsKt.listOf(items2);
        items2 = new Pair[5];
        items2[0] = TuplesKt.to(Double.valueOf(-0.6000061D), Double.valueOf(0.29999924D));
        items2[1] = TuplesKt.to(Double.valueOf(0.6000061D), Double.valueOf(0.29999924D));
        items2[2] = TuplesKt.to(Double.valueOf(-0.30000305D), Double.valueOf(-0.44999886D));
        items2[3] = TuplesKt.to(Double.valueOf(0.15000153D), Double.valueOf(0.0D));
        items2[4] = TuplesKt.to(Double.valueOf(0.0D), Double.valueOf(0.0D));
        items[3] = CollectionsKt.listOf(items2);
        items2 = new Pair[5];
        items2[0] = TuplesKt.to(Double.valueOf(-0.30000305D), Double.valueOf(0.0D));
        items2[1] = TuplesKt.to(Double.valueOf(-0.29999542D), Double.valueOf(0.6000004D));
        items2[2] = TuplesKt.to(Double.valueOf(0.30000305D), Double.valueOf(0.0D));
        items2[3] = TuplesKt.to(Double.valueOf(-0.7500076D), Double.valueOf(-0.44999886D));
        items2[4] = TuplesKt.to(Double.valueOf(0.30000305D), Double.valueOf(0.0D));
        items[4] = CollectionsKt.listOf(items2);
        itemList = CollectionsKt.listOf(items);
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
