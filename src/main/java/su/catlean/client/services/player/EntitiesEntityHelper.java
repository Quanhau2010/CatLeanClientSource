package su.catlean.client.services.player;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.PlayerEntity;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalFriendProtectionMode;

public class EntitiesEntityHelper {

    private final List itemList;
    private final PlayerEntity playerEntity;
    private final float factorValue;
    private final float factorValue2;
    private final float factorValue3;
    private final float factorValue4;
    private final boolean enabledFlag;
    private final float factorValue5;
    private final float factorValue6;
    private final boolean enabledFlag2;
    private final float factorValue7;
    private final boolean enabledFlag3;
    private final AutoCrystalFriendProtectionMode autoCrystalFriendProtectionMode;
    private final boolean enabledFlag4;
    private final boolean enabledFlag5;
    private final int countValue;
    private final boolean enabledFlag6;
    private final float factorValue8;
    private final boolean enabledFlag7;
    private final boolean enabledFlag8;
    private final boolean enabledFlag9;
    private final boolean enabledFlag10;
    private final boolean enabledFlag11;
    private final boolean enabledFlag12;
    private final boolean enabledFlag13;

    public EntitiesEntityHelper(List entities, PlayerEntity target, float placeRange, float explodeRange, float maxSelfDamage, float minDamage, boolean oldVer, float armorScale, float facePlaceHp, boolean overrideSelfDamage, float efficiencyFactor, boolean rayTrace, AutoCrystalFriendProtectionMode friendProtection, boolean breakFire, boolean ignoreTerrain, int lethalMultiplier, boolean minimizeSelfDamage, float maxDamageReduction, boolean calcShields, boolean stringWaterRemove, boolean grimBreakRange, boolean explodeEChestFarm, boolean antiPortal, boolean antiQuiver, boolean overrideMinDamage) {
        this.itemList = entities;
        this.playerEntity = target;
        this.factorValue = placeRange;
        this.factorValue2 = explodeRange;
        this.factorValue3 = maxSelfDamage;
        this.factorValue4 = minDamage;
        this.enabledFlag = oldVer;
        this.factorValue5 = armorScale;
        this.factorValue6 = facePlaceHp;
        this.enabledFlag2 = overrideSelfDamage;
        this.factorValue7 = efficiencyFactor;
        this.enabledFlag3 = rayTrace;
        this.autoCrystalFriendProtectionMode = friendProtection;
        this.enabledFlag4 = breakFire;
        this.enabledFlag5 = ignoreTerrain;
        this.countValue = lethalMultiplier;
        this.enabledFlag6 = minimizeSelfDamage;
        this.factorValue8 = maxDamageReduction;
        this.enabledFlag7 = calcShields;
        this.enabledFlag8 = stringWaterRemove;
        this.enabledFlag9 = grimBreakRange;
        this.enabledFlag10 = explodeEChestFarm;
        this.enabledFlag11 = antiPortal;
        this.enabledFlag12 = antiQuiver;
        this.enabledFlag13 = overrideMinDamage;
    }

    public List getList() {
        return this.itemList;
    }

    public PlayerEntity getMinecraftObject() {
        return this.playerEntity;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public float getNumericValue5() {
        return this.factorValue5;
    }

    public float getNumericValue6() {
        return this.factorValue6;
    }

    public boolean isActive2() {
        return this.enabledFlag2;
    }

    public float getNumericValue7() {
        return this.factorValue7;
    }

    public boolean isActive3() {
        return this.enabledFlag3;
    }

    public AutoCrystalFriendProtectionMode getAutoCrystalFriendProtectionMode() {
        return this.autoCrystalFriendProtectionMode;
    }

    public boolean isActive4() {
        return this.enabledFlag4;
    }

    public boolean isActive5() {
        return this.enabledFlag5;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public boolean isActive6() {
        return this.enabledFlag6;
    }

    public float getNumericValue8() {
        return this.factorValue8;
    }

    public boolean isActive7() {
        return this.enabledFlag7;
    }

    public boolean isActive8() {
        return this.enabledFlag8;
    }

    public boolean isActive9() {
        return this.enabledFlag9;
    }

    public boolean isActive10() {
        return this.enabledFlag10;
    }

    public boolean isActive11() {
        return this.enabledFlag11;
    }

    public boolean isActive12() {
        return this.enabledFlag12;
    }

    public boolean isActive13() {
        return this.enabledFlag13;
    }

    public List getList2() {
        return this.itemList;
    }

    public PlayerEntity getMinecraftObject2() {
        return this.playerEntity;
    }

    public float getNumericValue9() {
        return this.factorValue;
    }

    public float getNumericValue10() {
        return this.factorValue2;
    }

    public float getNumericValue11() {
        return this.factorValue3;
    }

    public float getNumericValue12() {
        return this.factorValue4;
    }

    public boolean isActive14() {
        return this.enabledFlag;
    }

    public float getNumericValue13() {
        return this.factorValue5;
    }

    public float getNumericValue14() {
        return this.factorValue6;
    }

    public boolean isActive15() {
        return this.enabledFlag2;
    }

    public float getNumericValue15() {
        return this.factorValue7;
    }

    public boolean isActive16() {
        return this.enabledFlag3;
    }

    public AutoCrystalFriendProtectionMode getAutoCrystalFriendProtectionMode2() {
        return this.autoCrystalFriendProtectionMode;
    }

    public boolean isActive17() {
        return this.enabledFlag4;
    }

    public boolean isActive18() {
        return this.enabledFlag5;
    }

    public int getNumericValue2() {
        return this.countValue;
    }

    public boolean isActive19() {
        return this.enabledFlag6;
    }

    public float getNumericValue16() {
        return this.factorValue8;
    }

    public boolean isActive20() {
        return this.enabledFlag7;
    }

    public boolean isActive21() {
        return this.enabledFlag8;
    }

    public boolean isActive22() {
        return this.enabledFlag9;
    }

    public boolean isActive23() {
        return this.enabledFlag10;
    }

    public boolean isActive24() {
        return this.enabledFlag11;
    }

    public boolean isActive25() {
        return this.enabledFlag12;
    }

    public boolean isActive26() {
        return this.enabledFlag13;
    }

    public EntitiesEntityHelper resolveEntitiesEntityHelper(List entities, PlayerEntity target, float placeRange, float explodeRange, float maxSelfDamage, float minDamage, boolean oldVer, float armorScale, float facePlaceHp, boolean overrideSelfDamage, float efficiencyFactor, boolean rayTrace, AutoCrystalFriendProtectionMode friendProtection, boolean breakFire, boolean ignoreTerrain, int lethalMultiplier, boolean minimizeSelfDamage, float maxDamageReduction, boolean calcShields, boolean stringWaterRemove, boolean grimBreakRange, boolean explodeEChestFarm, boolean antiPortal, boolean antiQuiver, boolean overrideMinDamage) {
        return new EntitiesEntityHelper(entities, target, placeRange, explodeRange, maxSelfDamage, minDamage, oldVer, armorScale, facePlaceHp, overrideSelfDamage, efficiencyFactor, rayTrace, friendProtection, breakFire, ignoreTerrain, lethalMultiplier, minimizeSelfDamage, maxDamageReduction, calcShields, stringWaterRemove, grimBreakRange, explodeEChestFarm, antiPortal, antiQuiver, overrideMinDamage);
    }

    public static EntitiesEntityHelper resolveEntitiesEntityHelper(EntitiesEntityHelper arg0, List arg1, PlayerEntity arg2, float arg3, float arg4, float arg5, float arg6, boolean arg7, float arg8, float arg9, boolean arg10, float arg11, boolean arg12, AutoCrystalFriendProtectionMode arg13, boolean arg14, boolean arg15, int arg16, boolean arg17, float arg18, boolean arg19, boolean arg20, boolean arg21, boolean arg22, boolean arg23, boolean arg24, boolean arg25, int arg26, Object arg27) {
        if ((arg26 & 1)) {
            arg1 = arg0.itemList;
        }
        if ((arg26 & 2)) {
            arg2 = arg0.playerEntity;
        }
        if ((arg26 & 4)) {
            arg3 = arg0.factorValue;
        }
        if ((arg26 & 8)) {
            arg4 = arg0.factorValue2;
        }
        if ((arg26 & 16)) {
            arg5 = arg0.factorValue3;
        }
        if ((arg26 & 32)) {
            arg6 = arg0.factorValue4;
        }
        if ((arg26 & 64)) {
            arg7 = arg0.enabledFlag;
        }
        if ((arg26 & 128)) {
            arg8 = arg0.factorValue5;
        }
        if ((arg26 & 256)) {
            arg9 = arg0.factorValue6;
        }
        if ((arg26 & 512)) {
            arg10 = arg0.enabledFlag2;
        }
        if ((arg26 & 1024)) {
            arg11 = arg0.factorValue7;
        }
        if ((arg26 & 2048)) {
            arg12 = arg0.enabledFlag3;
        }
        if ((arg26 & 4096)) {
            arg13 = arg0.autoCrystalFriendProtectionMode;
        }
        if ((arg26 & 8192)) {
            arg14 = arg0.enabledFlag4;
        }
        if ((arg26 & 16384)) {
            arg15 = arg0.enabledFlag5;
        }
        if ((arg26 & 32768)) {
            arg16 = arg0.countValue;
        }
        if ((arg26 & 65536)) {
            arg17 = arg0.enabledFlag6;
        }
        if ((arg26 & 131072)) {
            arg18 = arg0.factorValue8;
        }
        if ((arg26 & 262144)) {
            arg19 = arg0.enabledFlag7;
        }
        if ((arg26 & 524288)) {
            arg20 = arg0.enabledFlag8;
        }
        if ((arg26 & 1048576)) {
            arg21 = arg0.enabledFlag9;
        }
        if ((arg26 & 2097152)) {
            arg22 = arg0.enabledFlag10;
        }
        if ((arg26 & 4194304)) {
            arg23 = arg0.enabledFlag11;
        }
        if ((arg26 & 8388608)) {
            arg24 = arg0.enabledFlag12;
        }
        if ((arg26 & 16777216)) {
            arg25 = arg0.enabledFlag13;
        }
        if (arg0.resolveEntitiesEntityHelper(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25) != null) {
        }
        return null;
    }

    public String toString() {
        boolean var3 = this.enabledFlag13;
        boolean var4 = this.enabledFlag12;
        boolean var5 = this.enabledFlag11;
        boolean var6 = this.enabledFlag10;
        boolean var7 = this.enabledFlag9;
        boolean var8 = this.enabledFlag8;
        boolean var9 = this.enabledFlag7;
        float var10 = this.factorValue8;
        boolean var11 = this.enabledFlag6;
        int var12 = this.countValue;
        boolean var13 = this.enabledFlag5;
        boolean var14 = this.enabledFlag4;
        AutoCrystalFriendProtectionMode var15 = this.autoCrystalFriendProtectionMode;
        boolean var16 = this.enabledFlag3;
        float var17 = this.factorValue7;
        boolean var18 = this.enabledFlag2;
        float var19 = this.factorValue6;
        float var20 = this.factorValue5;
        boolean var21 = this.enabledFlag;
        float var22 = this.factorValue4;
        float var23 = this.factorValue3;
        float var24 = this.factorValue2;
        float var25 = this.factorValue;
        PlayerEntity player = this.playerEntity;
        List positions = this.itemList;
        return ("ConfigState(entities=" + positions + ", target=" + player + ", placeRange=" + var25 + ", explodeRange=" + var24 + ", maxSelfDamage=" + var23 + ", minDamage=" + var22 + ", oldVer=" + var21 + ", armorScale=" + var20 + ", facePlaceHp=" + var19 + ", overrideSelfDamage=" + var18 + ", efficiencyFactor=" + var17 + ", rayTrace=" + var16 + ", friendProtection=" + var15 + ", breakFire=" + var14 + ", ignoreTerrain=" + var13 + ", lethalMultiplier=" + var12 + ", minimizeSelfDamage=" + var11 + ", maxDamageReduction=" + var10 + ", calcShields=" + var9 + ", stringWaterRemove=" + var8 + ", grimBreakRange=" + var7 + ", explodeEChestFarm=" + var6 + ", antiPortal=" + var5 + ", antiQuiver=" + var4 + ", overrideMinDamage=" + var3 + ")");
    }

    public int hashCode() {
        int var4 = this.itemList.hashCode();
        var4 = ((var4 * 31) + this.playerEntity.hashCode());
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue2));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue3));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue4));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue5));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue6));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag2));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue7));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag3));
        var4 = ((var4 * 31) + this.autoCrystalFriendProtectionMode.hashCode());
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag4));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag5));
        var4 = ((var4 * 31) + Integer.hashCode(this.countValue));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag6));
        var4 = ((var4 * 31) + Float.hashCode(this.factorValue8));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag7));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag8));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag9));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag10));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag11));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag12));
        var4 = ((var4 * 31) + Boolean.hashCode(this.enabledFlag13));
        if (var3 != null) {
        }
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntitiesEntityHelper)) {
            return false;
        }
        EntitiesEntityHelper var5 = (EntitiesEntityHelper) other;
        if (!(Intrinsics.areEqual(this.itemList, var5.itemList))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.playerEntity, var5.playerEntity))) {
            return false;
        }
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, var5.factorValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue4, var5.factorValue4)) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        if (Float.compare(this.factorValue5, var5.factorValue5)) {
            return false;
        }
        if (Float.compare(this.factorValue6, var5.factorValue6)) {
            return false;
        }
        if (this.enabledFlag2 != var5.enabledFlag2) {
            return false;
        }
        if (Float.compare(this.factorValue7, var5.factorValue7)) {
            return false;
        }
        if (this.enabledFlag3 != var5.enabledFlag3) {
            return false;
        }
        if (this.autoCrystalFriendProtectionMode != var5.autoCrystalFriendProtectionMode) {
            return false;
        }
        if (this.enabledFlag4 != var5.enabledFlag4) {
            return false;
        }
        if (this.enabledFlag5 != var5.enabledFlag5) {
            return false;
        }
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (this.enabledFlag6 != var5.enabledFlag6) {
            return false;
        }
        if (Float.compare(this.factorValue8, var5.factorValue8)) {
            return false;
        }
        if (this.enabledFlag7 != var5.enabledFlag7) {
            return false;
        }
        if (this.enabledFlag8 != var5.enabledFlag8) {
            return false;
        }
        if (this.enabledFlag9 != var5.enabledFlag9) {
            return false;
        }
        if (this.enabledFlag10 != var5.enabledFlag10) {
            return false;
        }
        if (this.enabledFlag11 != var5.enabledFlag11) {
            return false;
        }
        if (this.enabledFlag12 != var5.enabledFlag12) {
            return false;
        }
        if (this.enabledFlag13 != var5.enabledFlag13) {
            return false;
        }
        return true;
    }

}
