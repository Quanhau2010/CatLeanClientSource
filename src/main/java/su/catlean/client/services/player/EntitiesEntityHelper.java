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
        if ((arg26 & 1) != 0) {
            arg1 = arg0.itemList;
        }
        if ((arg26 & 2) != 0) {
            arg2 = arg0.playerEntity;
        }
        if ((arg26 & 4) != 0) {
            arg3 = arg0.factorValue;
        }
        if ((arg26 & 8) != 0) {
            arg4 = arg0.factorValue2;
        }
        if ((arg26 & 16) != 0) {
            arg5 = arg0.factorValue3;
        }
        if ((arg26 & 32) != 0) {
            arg6 = arg0.factorValue4;
        }
        if ((arg26 & 64) != 0) {
            arg7 = arg0.enabledFlag;
        }
        if ((arg26 & 128) != 0) {
            arg8 = arg0.factorValue5;
        }
        if ((arg26 & 256) != 0) {
            arg9 = arg0.factorValue6;
        }
        if ((arg26 & 512) != 0) {
            arg10 = arg0.enabledFlag2;
        }
        if ((arg26 & 1024) != 0) {
            arg11 = arg0.factorValue7;
        }
        if ((arg26 & 2048) != 0) {
            arg12 = arg0.enabledFlag3;
        }
        if ((arg26 & 4096) != 0) {
            arg13 = arg0.autoCrystalFriendProtectionMode;
        }
        if ((arg26 & 8192) != 0) {
            arg14 = arg0.enabledFlag4;
        }
        if ((arg26 & 16384) != 0) {
            arg15 = arg0.enabledFlag5;
        }
        if ((arg26 & 32768) != 0) {
            arg16 = arg0.countValue;
        }
        if ((arg26 & 65536) != 0) {
            arg17 = arg0.enabledFlag6;
        }
        if ((arg26 & 131072) != 0) {
            arg18 = arg0.factorValue8;
        }
        if ((arg26 & 262144) != 0) {
            arg19 = arg0.enabledFlag7;
        }
        if ((arg26 & 524288) != 0) {
            arg20 = arg0.enabledFlag8;
        }
        if ((arg26 & 1048576) != 0) {
            arg21 = arg0.enabledFlag9;
        }
        if ((arg26 & 2097152) != 0) {
            arg22 = arg0.enabledFlag10;
        }
        if ((arg26 & 4194304) != 0) {
            arg23 = arg0.enabledFlag11;
        }
        if ((arg26 & 8388608) != 0) {
            arg24 = arg0.enabledFlag12;
        }
        if ((arg26 & 16777216) != 0) {
            arg25 = arg0.enabledFlag13;
        }
        if (arg0.resolveEntitiesEntityHelper(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25) != null) {
        }
        return null;
    }

    public String toString() {
        boolean flag = this.enabledFlag13;
        boolean flag2 = this.enabledFlag12;
        boolean flag3 = this.enabledFlag11;
        boolean flag4 = this.enabledFlag10;
        boolean flag5 = this.enabledFlag9;
        boolean flag6 = this.enabledFlag8;
        boolean flag7 = this.enabledFlag7;
        float factor = this.factorValue8;
        boolean flag8 = this.enabledFlag6;
        int index = this.countValue;
        boolean flag9 = this.enabledFlag5;
        boolean flag10 = this.enabledFlag4;
        AutoCrystalFriendProtectionMode autoCrystalFriendProtectionMode = this.autoCrystalFriendProtectionMode;
        boolean flag11 = this.enabledFlag3;
        float factor2 = this.factorValue7;
        boolean flag12 = this.enabledFlag2;
        float factor3 = this.factorValue6;
        float factor4 = this.factorValue5;
        boolean flag13 = this.enabledFlag;
        float factor5 = this.factorValue4;
        float factor6 = this.factorValue3;
        float factor7 = this.factorValue2;
        float factor8 = this.factorValue;
        PlayerEntity player = this.playerEntity;
        List list = this.itemList;
        return ("ConfigState(entities=" + list + ", target=" + player + ", placeRange=" + factor8 + ", explodeRange=" + factor7 + ", maxSelfDamage=" + factor6 + ", minDamage=" + factor5 + ", oldVer=" + flag13 + ", armorScale=" + factor4 + ", facePlaceHp=" + factor3 + ", overrideSelfDamage=" + flag12 + ", efficiencyFactor=" + factor2 + ", rayTrace=" + flag11 + ", friendProtection=" + autoCrystalFriendProtectionMode + ", breakFire=" + flag10 + ", ignoreTerrain=" + flag9 + ", lethalMultiplier=" + index + ", minimizeSelfDamage=" + flag8 + ", maxDamageReduction=" + factor + ", calcShields=" + flag7 + ", stringWaterRemove=" + flag6 + ", grimBreakRange=" + flag5 + ", explodeEChestFarm=" + flag4 + ", antiPortal=" + flag3 + ", antiQuiver=" + flag2 + ", overrideMinDamage=" + flag + ")");
    }

    public int hashCode() {
        int index = this.itemList.hashCode();
        index = ((index * 31) + this.playerEntity.hashCode());
        index = ((index * 31) + Float.hashCode(this.factorValue));
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + Float.hashCode(this.factorValue3));
        index = ((index * 31) + Float.hashCode(this.factorValue4));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        index = ((index * 31) + Float.hashCode(this.factorValue5));
        index = ((index * 31) + Float.hashCode(this.factorValue6));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag2));
        index = ((index * 31) + Float.hashCode(this.factorValue7));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag3));
        index = ((index * 31) + this.autoCrystalFriendProtectionMode.hashCode());
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag4));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag5));
        index = ((index * 31) + Integer.hashCode(this.countValue));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag6));
        index = ((index * 31) + Float.hashCode(this.factorValue8));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag7));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag8));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag9));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag10));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag11));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag12));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag13));
        if (__UNDEF_KEY__ != null) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntitiesEntityHelper)) {
            return false;
        }
        EntitiesEntityHelper entitiesEntityHelper = ((EntitiesEntityHelper) other);
        if (!(Intrinsics.areEqual(this.itemList, entitiesEntityHelper.itemList))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.playerEntity, entitiesEntityHelper.playerEntity))) {
            return false;
        }
        if (Float.compare(this.factorValue, entitiesEntityHelper.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, entitiesEntityHelper.factorValue2)) {
            return false;
        }
        if (Float.compare(this.factorValue3, entitiesEntityHelper.factorValue3)) {
            return false;
        }
        if (Float.compare(this.factorValue4, entitiesEntityHelper.factorValue4)) {
            return false;
        }
        if (this.enabledFlag != entitiesEntityHelper.enabledFlag) {
            return false;
        }
        if (Float.compare(this.factorValue5, entitiesEntityHelper.factorValue5)) {
            return false;
        }
        if (Float.compare(this.factorValue6, entitiesEntityHelper.factorValue6)) {
            return false;
        }
        if (this.enabledFlag2 != entitiesEntityHelper.enabledFlag2) {
            return false;
        }
        if (Float.compare(this.factorValue7, entitiesEntityHelper.factorValue7)) {
            return false;
        }
        if (this.enabledFlag3 != entitiesEntityHelper.enabledFlag3) {
            return false;
        }
        if (this.autoCrystalFriendProtectionMode != entitiesEntityHelper.autoCrystalFriendProtectionMode) {
            return false;
        }
        if (this.enabledFlag4 != entitiesEntityHelper.enabledFlag4) {
            return false;
        }
        if (this.enabledFlag5 != entitiesEntityHelper.enabledFlag5) {
            return false;
        }
        if (this.countValue != entitiesEntityHelper.countValue) {
            return false;
        }
        if (this.enabledFlag6 != entitiesEntityHelper.enabledFlag6) {
            return false;
        }
        if (Float.compare(this.factorValue8, entitiesEntityHelper.factorValue8)) {
            return false;
        }
        if (this.enabledFlag7 != entitiesEntityHelper.enabledFlag7) {
            return false;
        }
        if (this.enabledFlag8 != entitiesEntityHelper.enabledFlag8) {
            return false;
        }
        if (this.enabledFlag9 != entitiesEntityHelper.enabledFlag9) {
            return false;
        }
        if (this.enabledFlag10 != entitiesEntityHelper.enabledFlag10) {
            return false;
        }
        if (this.enabledFlag11 != entitiesEntityHelper.enabledFlag11) {
            return false;
        }
        if (this.enabledFlag12 != entitiesEntityHelper.enabledFlag12) {
            return false;
        }
        if (this.enabledFlag13 != entitiesEntityHelper.enabledFlag13) {
            return false;
        }
        return true;
    }

}
