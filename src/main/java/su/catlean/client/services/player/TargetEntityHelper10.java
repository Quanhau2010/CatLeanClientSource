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
        return (SettingGroup) advancedOptionsSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public TpPointMode getPoint() {
        return (TpPointMode) pointSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    public TpPointJitterMode getPointJitter() {
        return (TpPointJitterMode) pointJitterSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    public float getPointVRange() {
        return (Number) pointVRangeSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    public float getPointHRange() {
        return (Number) pointHRangeSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    public float getPointHFreq() {
        return (Number) pointHFreqSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    public float getPointVFreq() {
        return (Number) pointVFreqSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    public TpSpeedDistributionMode getSpeedDistribution() {
        return (TpSpeedDistributionMode) speedDistributionSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    public float getMinYawSpeed() {
        return (Number) minYawSpeedSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    public float getMaxYawSpeed() {
        return (Number) maxYawSpeedSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    public float getMinPitchSpeed() {
        return (Number) minPitchSpeedSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    public float getMaxPitchSpeed() {
        return (Number) maxPitchSpeedSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    public TpSpeedDistributionMode getJitterDistribution() {
        return (TpSpeedDistributionMode) jitterDistributionSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    public TpPointJitterMode getYawJitter() {
        return (TpPointJitterMode) yawJitterSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    public TpPointJitterMode getPitchJitter() {
        return (TpPointJitterMode) pitchJitterSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    public float getYawAmplMin() {
        return (Number) yawAmplMinSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    public float getPitchAmplMin() {
        return (Number) pitchAmplMinSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    public float getYawAmplMax() {
        return (Number) yawAmplMaxSetting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    public float getPitchAmplMax() {
        return (Number) pitchAmplMaxSetting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    public float getYawFreqMin() {
        return (Number) yawFreqMinSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    public float getPitchFreqMin() {
        return (Number) pitchFreqMinSetting.getValue(this, DELEGATED_PROPERTIES[20]);
    }

    public float getYawFreqMax() {
        return (Number) yawFreqMaxSetting.getValue(this, DELEGATED_PROPERTIES[21]);
    }

    public float getPitchFreqMax() {
        return (Number) pitchFreqMaxSetting.getValue(this, DELEGATED_PROPERTIES[22]);
    }

    public float getSmoothHbScale() {
        return (Number) smoothHbScaleSetting.getValue(this, DELEGATED_PROPERTIES[23]);
    }

    public float getYawAcceleration() {
        return (Number) yawAccelerationSetting.getValue(this, DELEGATED_PROPERTIES[24]);
    }

    public float getPitchAcceleration() {
        return (Number) pitchAccelerationSetting.getValue(this, DELEGATED_PROPERTIES[25]);
    }

    public float getYawDeceleration() {
        return (Number) yawDecelerationSetting.getValue(this, DELEGATED_PROPERTIES[26]);
    }

    public float getPitchDeceleration() {
        return (Number) pitchDecelerationSetting.getValue(this, DELEGATED_PROPERTIES[27]);
    }

    public TpYawSmootherMode getYawSmoother() {
        return (TpYawSmootherMode) yawSmootherSetting.getValue(this, DELEGATED_PROPERTIES[28]);
    }

    public TpYawSmootherMode getPitchSmoother() {
        return (TpYawSmootherMode) pitchSmootherSetting.getValue(this, DELEGATED_PROPERTIES[29]);
    }

    public float getYawAccelerationMin() {
        return (Number) yawAccelerationMinSetting.getValue(this, DELEGATED_PROPERTIES[30]);
    }

    public float getPitchAccelerationMin() {
        return (Number) pitchAccelerationMinSetting.getValue(this, DELEGATED_PROPERTIES[31]);
    }

    public boolean getClientLook() {
        return (Boolean) clientLookSetting.getValue(this, DELEGATED_PROPERTIES[32]);
    }

    public boolean getOverShoot() {
        return (Boolean) overShootSetting.getValue(this, DELEGATED_PROPERTIES[33]);
    }

    public float getOvershootTrigger() {
        return (Number) overshootTriggerSetting.getValue(this, DELEGATED_PROPERTIES[34]);
    }

    public int getOvershootStreak() {
        return (Number) overshootStreakSetting.getValue(this, DELEGATED_PROPERTIES[35]);
    }

    public float getOvershootValue() {
        return (Number) overshootValueSetting.getValue(this, DELEGATED_PROPERTIES[36]);
    }

    public int getOvershootMinTicks() {
        return (Number) overshootMinTicksSetting.getValue(this, DELEGATED_PROPERTIES[37]);
    }

    public int getOvershootMaxTicks() {
        return (Number) overshootMaxTicksSetting.getValue(this, DELEGATED_PROPERTIES[38]);
    }

    public boolean getHeadUp() {
        return (Boolean) headUpSetting.getValue(this, DELEGATED_PROPERTIES[39]);
    }

    public int getHuIntervalMin() {
        return (Number) huIntervalMinSetting.getValue(this, DELEGATED_PROPERTIES[40]);
    }

    public int getHuIntervalMax() {
        return (Number) huIntervalMaxSetting.getValue(this, DELEGATED_PROPERTIES[41]);
    }

    public int getHuTicksMin() {
        return (Number) huTicksMinSetting.getValue(this, DELEGATED_PROPERTIES[42]);
    }

    public int getHuTicksMax() {
        return (Number) huTicksMaxSetting.getValue(this, DELEGATED_PROPERTIES[43]);
    }

    public float getHuSpeedMin() {
        return (Number) huSpeedMinSetting.getValue(this, DELEGATED_PROPERTIES[44]);
    }

    public float getHuSpeedMax() {
        return (Number) huSpeedMaxSetting.getValue(this, DELEGATED_PROPERTIES[45]);
    }

    public boolean getClickJitter() {
        return (Boolean) clickJitterSetting.getValue(this, DELEGATED_PROPERTIES[46]);
    }

    public boolean getYaw360() {
        return (Boolean) yaw360Setting.getValue(this, DELEGATED_PROPERTIES[47]);
    }

    public int getYaw360Chance() {
        return (Number) yaw360ChanceSetting.getValue(this, DELEGATED_PROPERTIES[48]);
    }

    public boolean getHoldAfterHit() {
        return (Boolean) holdAfterHitSetting.getValue(this, DELEGATED_PROPERTIES[49]);
    }

    public int getHoldMin() {
        return (Number) holdMinSetting.getValue(this, DELEGATED_PROPERTIES[50]);
    }

    public int getHoldMax() {
        return (Number) holdMaxSetting.getValue(this, DELEGATED_PROPERTIES[51]);
    }

    public TpHoldTimingMode getHoldTiming() {
        return (TpHoldTimingMode) holdTimingSetting.getValue(this, DELEGATED_PROPERTIES[52]);
    }

    public int getHoldChance() {
        return (Number) holdChanceSetting.getValue(this, DELEGATED_PROPERTIES[53]);
    }

    public float getPitchMin() {
        return (Number) pitchMinSetting.getValue(this, DELEGATED_PROPERTIES[54]);
    }

    public float getPitchMax() {
        return (Number) pitchMaxSetting.getValue(this, DELEGATED_PROPERTIES[55]);
    }

    public float getPitchITMin() {
        return (Number) pitchITMinSetting.getValue(this, DELEGATED_PROPERTIES[56]);
    }

    public float getPitchITMax() {
        return (Number) pitchITMaxSetting.getValue(this, DELEGATED_PROPERTIES[57]);
    }

    public TpFilterLowDeltasMode getFilterLowDeltas() {
        return (TpFilterLowDeltasMode) filterLowDeltasSetting.getValue(this, DELEGATED_PROPERTIES[58]);
    }

    public float getLowDeltaThreshold() {
        return (Number) lowDeltaThresholdSetting.getValue(this, DELEGATED_PROPERTIES[59]);
    }

    public float getReplaceMin() {
        return (Number) replaceMinSetting.getValue(this, DELEGATED_PROPERTIES[60]);
    }

    public float getReplaceMax() {
        return (Number) replaceMaxSetting.getValue(this, DELEGATED_PROPERTIES[61]);
    }

    public MoveFixServiceComponent resolveMoveFixServiceComponent(Entity target, MoveFixServiceComponent currentRotation, boolean attackTick) {
        long var6 = (0L ^ 103848013537014L);
        long var8 = (0L ^ 45435731867884L);
        long var10 = (0L ^ 39546115194913L);
        long var12 = (0L ^ 97445712017664L);
        long var14 = (0L ^ 64805540243721L);
        long var16 = (0L ^ 43306842265647L);
        long var18 = (0L ^ 14321932853208L);
        long var20 = (0L ^ 114944925389187L);
        long var22 = ((0L ^ 97037607575412L) >>> 32);
        long var23 = (((0L ^ 97037607575412L) << 32) >>> 40);
        long var24 = (((0L ^ 97037607575412L) << 56) >>> 56);
        long var25 = (0L ^ 6280098270877L);
        long var27 = (0L ^ 109847894072436L);
        long var29 = ((0L ^ 44813980922473L) >>> 48);
        long var30 = (((0L ^ 44813980922473L) << 16) >>> 32);
        long var31 = (((0L ^ 44813980922473L) << 48) >>> 48);
        long var32 = (0L ^ 79032121006651L);
        long var34 = (0L ^ 107134539154669L);
        long var36 = ((0L ^ 27975644175784L) >>> 48);
        long var37 = (((0L ^ 27975644175784L) << 16) >>> 32);
        long var38 = (((0L ^ 27975644175784L) << 48) >>> 48);
        long var39 = (0L ^ 34585555688145L);
        long var41 = (0L ^ 124664417749529L);
        long var43 = (0L ^ 120013133989640L);
        long var45 = (0L ^ 45378156339060L);
        long var47 = (0L ^ 72943673787470L);
        long var49 = (0L ^ 68997309831326L);
        long var51 = (0L ^ 118435926143872L);
        long var53 = (0L ^ 133142105964501L);
        long var55 = (0L ^ 38753063586444L);
        long var57 = (0L ^ 70141323828151L);
        long var59 = (0L ^ 33615733051039L);
        long var61 = (0L ^ 91380657410594L);
        long var63 = ((0L ^ 101203704705148L) >>> 32);
        long var64 = (((0L ^ 101203704705148L) << 32) >>> 56);
        long var65 = (((0L ^ 101203704705148L) << 40) >>> 40);
        long var66 = (0L ^ 129440275841107L);
        long var68 = ((0L ^ 74098600614282L) >>> 32);
        long var69 = (((0L ^ 74098600614282L) << 32) >>> 32);
        long var70 = (0L ^ 117228445131743L);
        long var72 = (0L ^ 101949105333032L);
        long var74 = (0L ^ 84304143753800L);
        long var76 = ((0L ^ 53203560345462L) >>> 32);
        long var77 = (((0L ^ 53203560345462L) << 32) >>> 48);
        long var78 = (((0L ^ 53203560345462L) << 48) >>> 48);
        long var79 = ((0L ^ 43029055762660L) >>> 32);
        long var80 = (((0L ^ 43029055762660L) << 32) >>> 32);
        long var82 = ((0L ^ 119825535552173L) >>> 48);
        long var83 = (((0L ^ 119825535552173L) << 16) >>> 32);
        long var84 = (((0L ^ 119825535552173L) << 48) >>> 48);
        long var85 = ((0L ^ 51979304196239L) >>> 32);
        long var87 = (((0L ^ 51979304196239L) << 32) >>> 32);
        long var88 = (0L ^ 40335320474785L);
        long var90 = (0L ^ 110098063975283L);
        long var92 = ((0L ^ 115363263044903L) >>> 32);
        long var93 = (((0L ^ 115363263044903L) << 32) >>> 40);
        long var94 = (((0L ^ 115363263044903L) << 56) >>> 56);
        long var95 = (0L ^ 76083599961676L);
        long var97 = (0L ^ 34202416819712L);
        long var99 = (0L ^ 65175841139459L);
        long var101 = ((0L ^ 60568097754263L) >>> 32);
        long var102 = (((0L ^ 60568097754263L) << 32) >>> 48);
        long var103 = (((0L ^ 60568097754263L) << 48) >>> 48);
        long var104 = (0L ^ 31852927257017L);
        long var106 = (0L ^ 3610462761264L);
        long var108 = (0L ^ 102952618125833L);
        long var110 = (0L ^ 36650562922020L);
        long var112 = (0L ^ 117104718242872L);
        long var114 = (0L ^ 45848804258439L);
        long var116 = (0L ^ 76972132209904L);
        long var118 = (0L ^ 85253548660025L);
        if (var120 == null) {
            if (this.checkCondition2()) {
                if (var120 == null) {
                    if (this.getHoldTiming() == TpHoldTimingMode.BEFORE_RANDOM) {
                    }
                }
                return this.resolveMoveFixServiceComponent(currentRotation.getNumericValue(), currentRotation.getNumericValue2());
            }
        }
        Vec3d vec = this.resolveMinecraftObject(target);
        this.executeAction(target);
        target.method_5857(target.method_5829().method_1014(this.getSmoothHbScale()));
        if (var120 == null) {
            if (!(AuraModule.INSTANCE.getIgnoreWalls())) {
            }
        } else {
        }
        boolean var122 = target.checkCondition(currentRotation, (AuraModule.INSTANCE.getAttackRange() + 2.0F), 1, 0);
        target.method_5857(target.method_5829().method_1014(this.getSmoothHbScale()));
        if (var120 == null) {
            if (var122) {
                factorValue = (factorValue - this.getYawDeceleration());
                factorValue2 = (factorValue2 - this.getPitchDeceleration());
                if (0L >= 0L) {
                    if (var120 != null) {
                    }
                    factorValue = (factorValue + this.getYawAcceleration());
                }
                factorValue2 = (factorValue2 + this.getPitchAcceleration());
            }
            factorValue = this.computeValue(factorValue, RangesKt.rangeTo(this.getYawAccelerationMin(), 1.0F));
            factorValue2 = this.computeValue(factorValue2, RangesKt.rangeTo(this.getPitchAccelerationMin(), 1.0F));
        }
        double var123 = (Math.toDegrees(Math.atan2((vec.field_1350 - SharedKt.getPlayer().getZ()), (vec.field_1352 - SharedKt.getPlayer().getX()))) - 90.0F);
        double var125 = Math.toDegrees(Math.atan2((vec.field_1351 - (EntityHelper.resolveMinecraftObject(SharedKt.getPlayer()).field_1351 + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()))), Math.hypot((vec.field_1352 - SharedKt.getPlayer().getX()), (vec.field_1350 - SharedKt.getPlayer().getZ()))));
        if (this.getOverShoot()) {
            if (0L > 0L) {
                if (var120 == null && var120 == null) {
                    if (countValue > 0) {
                        if (0L > 0L) {
                            var123 = (var123 + (factorValue4 + (this.getOvershootValue() * factorValue3)));
                            int var127 = countValue;
                            countValue = (var127 + -1);
                        }
                    }
                }
            }
            if (0L >= 0L) {
                if (var120 == null) {
                }
            }
            if (var120 == null) {
                if (var120 != null && this.getYaw360() && countValue7 > 0) {
                    factorValue5 = (factorValue5 + (360.0F / countValue6));
                    var123 = (var123 + (factorValue5 * factorValue6));
                }
                var127 = countValue7;
                countValue7 = (var127 + -1);
            }
        }
        var127 = class_3532.method_15338((var123 - currentRotation.getNumericValue()));
        double var129 = (var125 - currentRotation.getNumericValue2());
        float var131 = (this.computeValue((ClosedRange) RangesKt.rangeTo(this.getMinYawSpeed(), this.getMaxYawSpeed()), 0) * (Number) this.getYawSmoother().getFunction1().invoke(Double.valueOf(factorValue)));
        float var133 = (this.computeValue((ClosedRange) RangesKt.rangeTo(this.getMinPitchSpeed(), this.getMaxPitchSpeed()), 0) * (Number) this.getPitchSmoother().getFunction1().invoke(Double.valueOf(factorValue2)));
        double var135 = this.computeValue(Math.abs(), RangesKt.rangeTo(0.0D));
        double var136 = this.computeValue(Math.abs(), RangesKt.rangeTo(0.0D));
        if (var127 > 0.0D) {
        }
        float var137 = (var135 + var135);
        if (var129 > 0.0D) {
        }
        float var138 = (var136 + var136);
        MoveFixServiceComponent var139 = this.resolveMoveFixServiceComponent();
        var137 = var139.getNumericValue();
        var138 = var139.getNumericValue2();
        if (this.getOverShoot()) {
            if (var135 > this.getOvershootTrigger()) {
                if (var120 == null && var120 == null && var120 == null) {
                    if (countValue <= 0) {
                        int var140 = countValue2;
                        countValue2 = (var140 + 1);
                        factorValue4 = 0.0F;
                        if (0L >= 0L) {
                            if (var120 == null) {
                                if (countValue2 >= this.getOvershootStreak()) {
                                    countValue2 = 0;
                                    countValue = RangeServiceComponent.f((ClosedRange) new IntRange(this.getOvershootMinTicks(), this.getOvershootMaxTicks()));
                                    if (var120 == null) {
                                        if ((var137 - currentRotation.getNumericValue()) > 0.0F) {
                                        }
                                    } else {
                                    }
                                    factorValue3 = -1.0F;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (var120 == null) {
            if (this.getHeadUp()) {
                var140 = countValue4;
                countValue4 = (var140 + 1);
                if (0L > 0L) {
                    if (var120 == null) {
                        if (var140 > countValue5) {
                            countValue5 = RangeServiceComponent.f((ClosedRange) new IntRange(this.getHuIntervalMin(), this.getHuIntervalMax()));
                            countValue4 = 0;
                            countValue3 = RangeServiceComponent.f((ClosedRange) new IntRange(this.getHuTicksMin(), this.getHuTicksMax()));
                        }
                    }
                }
            }
        }
        if (this.getHeadUp()) {
            if (var120 == null && 0L > 0L && var120 == null) {
                if (countValue3 > 0) {
                    var140 = countValue3;
                    countValue3 = (var140 + -1);
                    var138 = (var138 - this.computeValue((ClosedRange) RangesKt.rangeTo(this.getHuSpeedMin(), this.getHuSpeedMax()), 1));
                    var137 = (var137 + (var138 * 0.1F));
                }
            }
            if (var120 == null) {
            }
            if (0L > 0L) {
            }
            if (this.getClickJitter() && countValue8 >= 0) {
                var140 = (Pair) itemList.get(countValue9).get((4 - countValue8));
                var137 = (var137 + (Number) var140.getFirst());
                var138 = (var138 + (Number) var140.getSecond());
                int var141 = countValue8;
                countValue8 = (var141 + -1);
            }
        }
        if (this.getFilterLowDeltas() != TpFilterLowDeltasMode.OFF) {
            var140 = (currentRotation.getNumericValue() - var137);
            var141 = (currentRotation.getNumericValue2() - var138);
            float var142 = this.getLowDeltaThreshold();
            float var143 = Math.abs();
            if (0L > 0L) {
                if (var120 == null) {
                    if (0.0F <= var143) {
                    }
                }
                if (var120 == null) {
                    if (var143 <= var142) {
                    }
                }
            } else {
            }
            if (0L >= 0L) {
                if (0) {
                    if (this.getFilterLowDeltas() == TpFilterLowDeltasMode.REMOVE) {
                    }
                    var137 = (currentRotation.getNumericValue() + RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(this.getReplaceMin(), this.getReplaceMax())));
                }
                var142 = this.getLowDeltaThreshold();
                var143 = Math.abs();
            }
            if (0L >= 0L) {
                if (var120 == null) {
                    if (0.0F <= var143) {
                    }
                }
                if (var120 == null) {
                    if (var143 <= var142) {
                    }
                }
            } else {
            }
            if (0L > 0L) {
                if (0) {
                    if (this.getFilterLowDeltas() == TpFilterLowDeltasMode.REMOVE) {
                    }
                    var138 = (currentRotation.getNumericValue2() + RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(this.getReplaceMin(), this.getReplaceMax())));
                }
            }
        }
        if (SharedKt.getPlayer().method_5829().method_994(target.method_5829())) {
        }
        var140 = new MoveFixServiceComponent(this.computeValue(RangesKt.rangeTo(this.getPitchMin(), this.getPitchMax())));
        return var140;
    }

    private boolean checkCondition2() {
        if (var6 == null) {
            if (this.getHoldAfterHit()) {
                int var7 = countValue10;
                countValue10 = (var7 + -1);
                if (var6 == null) {
                    if (countValue10 > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private MoveFixServiceComponent resolveMoveFixServiceComponent(float arg0, short arg1, float arg2, int arg3, short arg4) {
        long var43 = ((SharedKt.getNumericValue() % 10000L) / 500.0F);
        float var44 = RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(this.getYawFreqMin(), this.getYawFreqMax()));
        float var45 = RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(this.getYawAmplMin(), this.getYawAmplMax()));
        float var46 = RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(this.getPitchFreqMin(), this.getPitchFreqMax()));
        float var47 = RangeServiceComponent.p((ClosedRange) RangesKt.rangeTo(this.getPitchAmplMin(), this.getPitchAmplMax()));
        float var48 = arg0;
        float var49 = arg2;
        if (var42 == null) {
            var48 = (var48 + (Math.sin((var43 * var44)) * var45));
        }
        if (arg4 < 0) {
            if (var42 != null) {
                var48 = (var48 + (serviceComponent55.computeValue() * var45));
            }
            if (arg3 > 0) {
                if (var42 != null) {
                    var48 = (var48 + ((Math.sin((SharedKt.getPlayer().field_6012 * var44)) + this.computeValue((ClosedRange) RangesKt.rangeTo(-0.1F, 0.1F), 1)) * var45));
                }
                if (arg1 >= 0) {
                    if (var42 != null) {
                        var48 = (var48 + this.computeValue((ClosedRange) RangesKt.rangeTo(), 1));
                    }
                    if (arg4 < 0) {
                    }
                    if (var42 != null && var42 != null) {
                    }
                }
            }
        }
        var49 = (var49 + (Math.sin((var43 * var46)) * var47));
        if (arg4 <= 0) {
            if (var42 != null) {
                var49 = (var49 + (serviceComponent552.computeValue() * var47));
            }
            if (arg1 >= 0) {
                if (var42 != null) {
                    var49 = (var49 + ((Math.sin((SharedKt.getPlayer().field_6012 * var46)) + this.computeValue((ClosedRange) RangesKt.rangeTo(-0.1F, 0.1F), 1)) * var47));
                }
                if (arg3 > 0) {
                    if (var42 != null) {
                        var49 = (var49 + this.computeValue((ClosedRange) RangesKt.rangeTo(), 1));
                    }
                    if (arg4 < 0) {
                    }
                    if (var42 != null && var42 != null) {
                    }
                }
            }
        }
        return new MoveFixServiceComponent();
    }

    private float computeValue(ClosedRange arg0, boolean arg1) {
        if (arg1) {
            if (var15 == null) {
                if (this.getJitterDistribution() == TpSpeedDistributionMode.FLAT) {
                    return RangeServiceComponent.p(arg0);
                }
            }
            return ((Number) arg0.getStart() + (((Number) arg0.getEndInclusive() - (Number) arg0.getStart()) * this.computeValue(((RangeServiceComponent.getNumericValue() + 3.0F) / 6.0F), RangesKt.rangeTo(0.0F, 1.0F))));
        }
        if (var15 == null) {
            if (this.getSpeedDistribution() == TpSpeedDistributionMode.FLAT) {
                return RangeServiceComponent.p(arg0);
            }
        }
        return ((Number) arg0.getStart() + (((Number) arg0.getEndInclusive() - (Number) arg0.getStart()) * this.computeValue(((RangeServiceComponent.getNumericValue() + 3.0F) / 6.0F), RangesKt.rangeTo(0.0F, 1.0F))));
    }

    public Vec3d resolveMinecraftObject(Entity target) {
        long var4 = (0L ^ 99256764478621L);
        long var6 = (0L ^ 100744130797779L);
        long var8 = ((0L ^ 47521969804286L) >>> 32);
        long var9 = (((0L ^ 47521969804286L) << 32) >>> 32);
        long var11 = ((0L ^ 79682836449311L) >>> 32);
        long var12 = (((0L ^ 79682836449311L) << 32) >>> 48);
        long var13 = (((0L ^ 79682836449311L) << 48) >>> 48);
        long var14 = (0L ^ 13235677991175L);
        long var16 = ((0L ^ 14258589622431L) >>> 48);
        long var17 = (((0L ^ 14258589622431L) << 16) >>> 48);
        long var18 = (((0L ^ 14258589622431L) << 32) >>> 32);
        long var19 = (0L ^ 66130015998361L);
        long var21 = (0L ^ 42086361257596L);
        long var23 = ((0L ^ 124297090464785L) >>> 32);
        long var24 = (((0L ^ 124297090464785L) << 32) >>> 32);
        long var26 = (0L ^ 108103236449891L);
        long var28 = (0L ^ 123922492656172L);
        if (var30 == null) {
            if (SharedKt.getPlayer().isFallFlying()) {
            }
            return target.getEyePos();
        }
        long var31 = ((SharedKt.getNumericValue() % 10000L) / 500.0F);
        NoWhenBranchMatchedException var32 = new NoWhenBranchMatchedException();
        return target.method_5829().method_1005().method_1019();
        return target.getEyePos().method_1019();
        return EntityHelper.resolveMinecraftObject(target).method_1019(vec3d).method_1019();
        return EntityHelper.resolveMinecraftObject(target).method_1019(vec3d3).method_1019();
        Box var33 = target.method_5829().method_1002((this.getPointHRange() + 0.1D), (this.getPointVRange() + 0.2D), (this.getPointHRange() + 0.1D));
        return new Vec3d(this.computeValue(SharedKt.getPlayer().getEyePos().field_1352, RangesKt.rangeTo(var33.field_1323, var33.field_1320)), this.computeValue(SharedKt.getPlayer().getEyePos().field_1351, RangesKt.rangeTo(var33.field_1322, var33.field_1325)), this.computeValue(SharedKt.getPlayer().getEyePos().field_1350, RangesKt.rangeTo(var33.field_1321, var33.field_1324)));
    }

    public double computeValue(double receiver, ClosedFloatingPointRange range) {
        double var7 = (Number) range.getStart();
        double var9 = (Number) range.getEndInclusive();
        if (var6 == null) {
            if (var7 > var9) {
                double var11 = var9;
                var9 = var7;
                var7 = var11;
            }
        }
        if (var6 == null) {
            if (receiver < var7) {
                return var7;
            }
            if (var6 == null) {
            }
            if (receiver > var9) {
                return var9;
            }
        }
        return receiver;
    }

    public float computeValue(float receiver, ClosedFloatingPointRange range) {
        float var9 = (Number) range.getStart();
        float var10 = (Number) range.getEndInclusive();
        if (var8 == null) {
            if (var9 > var10) {
                float var11 = var10;
                var10 = var9;
                var9 = var11;
            }
        }
        if (0L > 0 && var8 == null) {
            if (receiver < var9) {
                return var9;
            }
            if (var8 == null) {
            }
            if (receiver > var10) {
                return var10;
            }
        }
        return receiver;
    }

    public int computeValue(int receiver, IntRange range) {
        int var9 = range.getStart();
        int var10 = range.getEndInclusive();
        if (var8 == null) {
            if (var9 > var10) {
                int var11 = var10;
                var10 = var9;
                var9 = var11;
            }
        }
        if (0L >= 0 && var8 == null) {
            if (receiver < var9) {
                return var9;
            }
            if (var8 == null) {
            }
            if (receiver > var10) {
                return var10;
            }
        }
        return receiver;
    }

    public void updateValue() {
        if (this.getYaw360()) {
            if (var31 == null && var31 == null) {
                if (RangeServiceComponent.f((ClosedRange) new IntRange(0, 100)) >= (100 - this.getYaw360Chance())) {
                    countValue6 = RangeServiceComponent.f((ClosedRange) new IntRange(7, 9));
                    countValue7 = countValue6;
                    if (!((SharedKt.getPlayer().field_6012 % 2))) {
                    }
                    factorValue6 = 1.0F;
                }
            }
        }
        if (var31 == null) {
            if (this.getClickJitter()) {
                countValue8 = 4;
                countValue9 = RangeServiceComponent.f((ClosedRange) new IntRange(0, 4));
            }
        }
        if (var31 == null) {
        }
        if (var31 == null) {
            if (this.getHoldAfterHit() && RangeServiceComponent.f((ClosedRange) new IntRange(0, 100)) >= (100 - this.getHoldChance())) {
            }
            countValue10 = RangeServiceComponent.f((ClosedRange) new IntRange(this.getHoldMin(), this.getHoldMax()));
        }
        double var32 = (0.3D - (this.getPointHRange() / 2.0D));
        double var34 = (1.81D - (this.getPointVRange() / 2.0D));
        ClosedFloatingPointRange var36 = RangesKt.rangeTo();
        ClosedFloatingPointRange var37 = RangesKt.rangeTo(0.0D);
        vec3d3 = new Vec3d(this.computeValue(RangeServiceComponent.k((ClosedRange) var36), RangesKt.rangeTo(-0.3D, 0.3D)), this.computeValue(RangeServiceComponent.k((ClosedRange) var37), RangesKt.rangeTo(0.0D, 1.81D)), this.computeValue(RangeServiceComponent.k((ClosedRange) var36), RangesKt.rangeTo(-0.3D, 0.3D)));
    }

    public void executeAction(Entity target) {
        double var11 = 0.003D;
        double var13 = 0.03D;
        double var15 = 0.001D;
        double var17 = 0.03D;
        float var19 = this.getPointHRange();
        double var21 = target.method_5829().method_17939();
        double var23 = target.method_5829().method_17940();
        double var25 = target.method_5829().method_17941();
        if (var10 == null) {
            if (Intrinsics.areEqual(vec3d2, Vec3d.ZERO)) {
                var6.<init>(RangeServiceComponent.a(RangeServiceComponent.a(RangeServiceComponent.a(new Vec3d))));
                vec3d2 = new Vec3d;
            }
        }
        double var27 = vec3d2.field_1352;
        double var29 = vec3d2.field_1351;
        double var31 = vec3d2.field_1350;
        if (var10 == null) {
            if (vec3d.field_1352 >= ((var21 - var19) / 2.0F)) {
                var27 = RangeServiceComponent.a(0, 4, null);
            }
        }
        if (var10 == null) {
            if (vec3d.field_1352 <= ((var21 - var19) / 2.0F)) {
                var27 = RangeServiceComponent.a(0, 4, null);
            }
        }
        if (var10 == null) {
            if (vec3d.field_1351 >= var23) {
                var29 = RangeServiceComponent.a(0, 4, null);
            }
        }
        if (var10 == null) {
            if (vec3d.field_1351 <= var19) {
                var29 = RangeServiceComponent.a(0, 4, null);
            }
        }
        if (var10 == null) {
            if (vec3d.field_1350 >= ((var25 - var19) / 2.0F)) {
                var31 = RangeServiceComponent.a(0, 4, null);
            }
        }
        if (var10 == null) {
            if (vec3d.field_1350 <= ((var25 - var19) / 2.0F)) {
                var31 = RangeServiceComponent.a(0, 4, null);
            }
        }
        if (var10 == null) {
            if (-0.03D <= var27) {
            }
            if (var10 == null) {
                if (var27 <= 0.03D) {
                }
            }
        } else {
        }
        if (var10 == null) {
            if (-0.03D <= var29) {
            }
            if (var10 == null) {
                if (var29 <= 0.03D) {
                }
            }
        } else {
        }
        if (!(0) && !(0)) {
            if (var10 == null) {
                if (-0.03D <= var31) {
                }
                if (var10 == null) {
                    if (var31 <= 0.03D) {
                    }
                }
            } else {
            }
            if (0) {
            }
            var6.<init>(RangeServiceComponent.a(RangeServiceComponent.a(RangeServiceComponent.a(new Vec3d))));
            vec3d2 = new Vec3d;
        }
        vec3d2 = new Vec3d();
        vec3d = vec3d.method_1019(vec3d2);
        vec3d = new Vec3d(this.computeValue(vec3d.field_1352, RangesKt.rangeTo()), this.computeValue(vec3d.field_1351, RangesKt.rangeTo(0.0D)), this.computeValue(vec3d.field_1350, RangesKt.rangeTo()));
        vec3d.method_1031(RangeServiceComponent.a(-0.03D, 0.03D), 0.0D, RangeServiceComponent.a(-0.03D, 0.03D));
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
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getOverShoot()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive36() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getOverShoot()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive37() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getOverShoot()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive38() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getOverShoot()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive39() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getOverShoot()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive40() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive41() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive42() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive43() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive44() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive45() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive46() {
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getHeadUp()) {
            }
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
        if (var6 == null) {
        }
        if (var6 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getYaw360()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive50() {
        return INSTANCE.checkCondition();
    }

    private static boolean isActive51() {
        if (var7 == null) {
        }
        if (var7 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getHoldAfterHit()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive52() {
        if (var7 == null) {
        }
        if (var7 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getHoldAfterHit()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive53() {
        if (var7 == null) {
        }
        if (var7 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getHoldAfterHit()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive54() {
        if (var7 == null) {
        }
        if (var7 == null) {
            if (INSTANCE.checkCondition() && INSTANCE.getHoldAfterHit()) {
            }
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
        if (var6 == null) {
        }
        return INSTANCE.getFilterLowDeltas() != TpFilterLowDeltasMode.OFF;
    }

    private static boolean isActive61() {
        if (var6 == null) {
        }
        return INSTANCE.getFilterLowDeltas() == TpFilterLowDeltasMode.REPLACE;
    }

    private static boolean isActive62() {
        if (var6 == null) {
        }
        return INSTANCE.getFilterLowDeltas() == TpFilterLowDeltasMode.REPLACE;
    }

    static {
        KProperty[] var60 = new KProperty[62];
        INSTANCE = new TargetEntityHelper10();
        advancedOptionsSetting = VisibleRenderHelper.registerSetting((Module) AuraModule.INSTANCE, "advanced", null, this::isActive);
        pointSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10((Module) AuraModule.INSTANCE, "point", TpPointMode.CENTER, INSTANCE.getAdvancedOptions(), this::isActive2);
        pointJitterSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10((Module) AuraModule.INSTANCE, "point-jitter", TpPointJitterMode.NONE, INSTANCE.getAdvancedOptions(), this::isActive3);
        pointVRangeSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "point-v-range", 0.1F, RangesKt.rangeTo(0.01F, 1.8F), INSTANCE.getAdvancedOptions(), this::isActive4);
        pointHRangeSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "point-h-range", 0.1F, RangesKt.rangeTo(0.01F, 0.3F), INSTANCE.getAdvancedOptions(), this::isActive5);
        pointHFreqSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "point-h-freq", 20.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive6);
        pointVFreqSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "point-v-freq", 10.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive7);
        speedDistributionSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10((Module) AuraModule.INSTANCE, "speed-distribution", TpSpeedDistributionMode.FLAT, INSTANCE.getAdvancedOptions(), this::isActive8);
        minYawSpeedSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "min-yaw-speed", 30.0F, RangesKt.rangeTo(0.1F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive9);
        maxYawSpeedSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "max-yaw-speed", 60.0F, RangesKt.rangeTo(0.1F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive10);
        minPitchSpeedSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "min-pitch-speed", 10.0F, RangesKt.rangeTo(0.1F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive11);
        maxPitchSpeedSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "max-pitch-speed", 20.0F, RangesKt.rangeTo(0.1F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive12);
        jitterDistributionSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10((Module) AuraModule.INSTANCE, "jitter-distribution", TpSpeedDistributionMode.NORMAL, INSTANCE.getAdvancedOptions(), this::isActive13);
        yawJitterSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10((Module) AuraModule.INSTANCE, "yaw-jitter", TpPointJitterMode.NONE, INSTANCE.getAdvancedOptions(), this::isActive14);
        pitchJitterSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10((Module) AuraModule.INSTANCE, "pitch-jitter", TpPointJitterMode.NONE, INSTANCE.getAdvancedOptions(), this::isActive15);
        yawAmplMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "yaw-ampl-min", 5.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive16);
        pitchAmplMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "pitch-ampl-min", 3.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive17);
        yawAmplMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "yaw-ampl-max", 10.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive18);
        pitchAmplMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "pitch-ampl-max", 5.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive19);
        yawFreqMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "yaw-freq-min", 20.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive20);
        pitchFreqMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "pitch-freq-min", 10.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive21);
        yawFreqMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "yaw-freq-max", 40.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive22);
        pitchFreqMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "pitch-freq-max", 20.0F, RangesKt.rangeTo(1.0F, 30.0F), INSTANCE.getAdvancedOptions(), this::isActive23);
        smoothHbScaleSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "smooth-box-expand", 0.0F, RangesKt.rangeTo(0.1F, 5.0F), INSTANCE.getAdvancedOptions(), this::isActive24);
        yawAccelerationSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "yaw-accel", 1.0F, RangesKt.rangeTo(0.1F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive25);
        pitchAccelerationSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "pitch-accel", 1.0F, RangesKt.rangeTo(0.1F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive26);
        yawDecelerationSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "yaw-decel", 0.0F, RangesKt.rangeTo(0.0F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive27);
        pitchDecelerationSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "pitch-decel", 0.0F, RangesKt.rangeTo(0.0F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive28);
        yawSmootherSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10((Module) AuraModule.INSTANCE, "yaw-smoother", TpYawSmootherMode.LINEAR, INSTANCE.getAdvancedOptions(), this::isActive29);
        pitchSmootherSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10((Module) AuraModule.INSTANCE, "pitch-smoother", TpYawSmootherMode.LINEAR, INSTANCE.getAdvancedOptions(), this::isActive30);
        yawAccelerationMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "min-factor-yaw", 0.5F, RangesKt.rangeTo(0.0F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive31);
        pitchAccelerationMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "min-factor-pitch", 0.5F, RangesKt.rangeTo(0.0F, 1.0F), INSTANCE.getAdvancedOptions(), this::isActive32);
        clientLookSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "client-look", 0, INSTANCE.getAdvancedOptions(), this::isActive33);
        overShootSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "over-shoot", 0, INSTANCE.getAdvancedOptions(), this::isActive34);
        overshootTriggerSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "os-trigger", 45.0F, RangesKt.rangeTo(20.0F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive35);
        Function0 var57 = this::isActive36;
        SettingGroup var58 = INSTANCE.getAdvancedOptions();
        IntRange var59 = new IntRange(1, 10);
        overshootStreakSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "os-streak", 3);
        overshootValueSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "os-value", 25.0F, RangesKt.rangeTo(20.0F, 180.0F), INSTANCE.getAdvancedOptions(), this::isActive37);
        var57 = this::isActive38;
        var58 = INSTANCE.getAdvancedOptions();
        var59 = new IntRange(0, 10);
        overshootMinTicksSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "os-min-ticks", 2);
        var57 = this::isActive39;
        var58 = INSTANCE.getAdvancedOptions();
        var59 = new IntRange(0, 10);
        overshootMaxTicksSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "os-max-ticks", 2);
        headUpSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "head-up", 0, INSTANCE.getAdvancedOptions(), this::isActive40);
        var57 = this::isActive41;
        var58 = INSTANCE.getAdvancedOptions();
        var59 = new IntRange(5, 400);
        huIntervalMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "hu-interval-min", 165);
        var57 = this::isActive42;
        var58 = INSTANCE.getAdvancedOptions();
        var59 = new IntRange(5, 400);
        huIntervalMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "hu-interval-max", 180);
        var57 = this::isActive43;
        var58 = INSTANCE.getAdvancedOptions();
        var59 = new IntRange(1, 20);
        huTicksMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "hu-ticks-min", 3);
        var57 = this::isActive44;
        var58 = INSTANCE.getAdvancedOptions();
        var59 = new IntRange(1, 20);
        huTicksMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "hu-ticks-max", 6);
        huSpeedMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "hu-speed-min", 5.0F, RangesKt.rangeTo(1.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive45);
        huSpeedMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "hu-speed-max", 36.0F, RangesKt.rangeTo(1.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive46);
        clickJitterSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "click-jitter", 0, INSTANCE.getAdvancedOptions(), this::isActive47);
        yaw360Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "do-360", 0, INSTANCE.getAdvancedOptions(), this::isActive48);
        var57 = this::isActive49;
        var58 = INSTANCE.getAdvancedOptions();
        var59 = new IntRange(1, 100);
        yaw360ChanceSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "do-360-chance", 20);
        holdAfterHitSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "hold-after-hit", 0, INSTANCE.getAdvancedOptions(), this::isActive50);
        var57 = this::isActive51;
        var58 = INSTANCE.getAdvancedOptions();
        var59 = new IntRange(0, 15);
        holdMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "hold-min", 5);
        var57 = this::isActive52;
        var58 = INSTANCE.getAdvancedOptions();
        var59 = new IntRange(0, 15);
        holdMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "hold-max", 7);
        holdTimingSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10((Module) AuraModule.INSTANCE, "hold-timing", TpHoldTimingMode.AFTER_RANDOM, INSTANCE.getAdvancedOptions(), this::isActive53);
        var57 = this::isActive54;
        var58 = INSTANCE.getAdvancedOptions();
        var59 = new IntRange(1, 100);
        holdChanceSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl((Module) AuraModule.INSTANCE, "hold-chance", 100);
        pitchMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "pitch-min", -90.0F, RangesKt.rangeTo(-90.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive55);
        pitchMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "pitch-max", 90.0F, RangesKt.rangeTo(-90.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive56);
        pitchITMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "pitch-in-target-min", -90.0F, RangesKt.rangeTo(-90.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive57);
        pitchITMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "pitch-in-target-max", 90.0F, RangesKt.rangeTo(-90.0F, 90.0F), INSTANCE.getAdvancedOptions(), this::isActive58);
        filterLowDeltasSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10((Module) AuraModule.INSTANCE, "filter-low-deltas", TpFilterLowDeltasMode.OFF, INSTANCE.getAdvancedOptions(), this::isActive59);
        lowDeltaThresholdSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "low-delta-threshold", 1.0F, RangesKt.rangeTo(0.0F, 20.0F), INSTANCE.getAdvancedOptions(), this::isActive60);
        replaceMinSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "replace-min", 3.0F, RangesKt.rangeTo(0.0F, 45.0F), INSTANCE.getAdvancedOptions(), this::isActive61);
        replaceMaxSetting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2((Module) AuraModule.INSTANCE, "replace-max", 5.0F, RangesKt.rangeTo(0.0F, 45.0F), INSTANCE.getAdvancedOptions(), this::isActive62);
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
        countValue5 = RangeServiceComponent.P(INSTANCE.getHuIntervalMin(), INSTANCE.getHuIntervalMax());
        var60 = new List[5];
        Pair[] var61 = new Pair[5];
        var61[0] = TuplesKt.to(Double.valueOf(0.15000153D), Double.valueOf(0.14999962D));
        var61[1] = TuplesKt.to(Double.valueOf(-0.15000153D), Double.valueOf(-0.14999962D));
        var61[2] = TuplesKt.to(Double.valueOf(-0.6000061D), Double.valueOf(0.0D));
        var61[3] = TuplesKt.to(Double.valueOf(-0.6000061D), Double.valueOf(0.0D));
        var61[4] = TuplesKt.to(Double.valueOf(0.45000458D), Double.valueOf(0.0D));
        var60[0] = CollectionsKt.listOf();
        var61 = new Pair[5];
        var61[0] = TuplesKt.to(Double.valueOf(-0.15000153D), Double.valueOf(0.0D));
        var61[1] = TuplesKt.to(Double.valueOf(-0.30000305D), Double.valueOf(0.0D));
        var61[2] = TuplesKt.to(Double.valueOf(0.30000305D), Double.valueOf(0.14999962D));
        var61[3] = TuplesKt.to(Double.valueOf(0.15000153D), Double.valueOf(-0.14999962D));
        var61[4] = TuplesKt.to(Double.valueOf(0.0D), Double.valueOf(0.0D));
        var60[1] = CollectionsKt.listOf();
        var61 = new Pair[5];
        var61[0] = TuplesKt.to(Double.valueOf(0.15000153D), Double.valueOf(-0.14999962D));
        var61[1] = TuplesKt.to(Double.valueOf(-0.6000061D), Double.valueOf(0.0D));
        var61[2] = TuplesKt.to(Double.valueOf(0.15000153D), Double.valueOf(0.14999962D));
        var61[3] = TuplesKt.to(Double.valueOf(-0.15000153D), Double.valueOf(0.0D));
        var61[4] = TuplesKt.to(Double.valueOf(0.30000305D), Double.valueOf(0.0D));
        var60[2] = CollectionsKt.listOf();
        var61 = new Pair[5];
        var61[0] = TuplesKt.to(Double.valueOf(-0.6000061D), Double.valueOf(0.29999924D));
        var61[1] = TuplesKt.to(Double.valueOf(0.6000061D), Double.valueOf(0.29999924D));
        var61[2] = TuplesKt.to(Double.valueOf(-0.30000305D), Double.valueOf(-0.44999886D));
        var61[3] = TuplesKt.to(Double.valueOf(0.15000153D), Double.valueOf(0.0D));
        var61[4] = TuplesKt.to(Double.valueOf(0.0D), Double.valueOf(0.0D));
        var60[3] = CollectionsKt.listOf();
        var61 = new Pair[5];
        var61[0] = TuplesKt.to(Double.valueOf(-0.30000305D), Double.valueOf(0.0D));
        var61[1] = TuplesKt.to(Double.valueOf(-0.29999542D), Double.valueOf(0.6000004D));
        var61[2] = TuplesKt.to(Double.valueOf(0.30000305D), Double.valueOf(0.0D));
        var61[3] = TuplesKt.to(Double.valueOf(-0.7500076D), Double.valueOf(-0.44999886D));
        var61[4] = TuplesKt.to(Double.valueOf(0.30000305D), Double.valueOf(0.0D));
        var60[4] = CollectionsKt.listOf();
        itemList = CollectionsKt.listOf();
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
