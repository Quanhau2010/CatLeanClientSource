package su.catlean.client.services.client;

import java.util.List;
import kotlin.text.StringsKt;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.item.Items;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalDamageSyncMode;
import su.catlean.client.features.modules.utility.player.SpeedMineModule;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class DamageSyncServiceComponent {

    public static final DamageSyncServiceComponent INSTANCE;
    private static float factorValue;
    private static final ServiceComponent10 serviceComponent10;
    private static final ServiceComponent10 serviceComponent102;
    private static boolean enabledFlag;
    private static float factorValue2;

    private DamageSyncServiceComponent() {
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
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

    public float getNumericValue2() {
        return factorValue2;
    }

    public void updateValue2(float value) {
        factorValue2 = value;
    }

    public long getNumericValue() {
        return timestampValue;
    }

    public void updateValue(long value) {
        timestampValue = value;
    }

    public void executeAction(float damage) {
        factorValue = damage;
        serviceComponent10.executeAction();
        enabledFlag = !(enabledFlag);
    }

    public void executeAction() {
        serviceComponent102.executeAction();
    }

    public boolean checkCondition(ServiceComponent95 damage, boolean random, AutoCrystalDamageSyncMode damageSync, boolean facePlaceSync, boolean lowCrystals, float stacksLeft, float minDamage) {
        return true;
        if (__UNDEF_KEY__ <= 0) {
            if (damageSync == AutoCrystalDamageSyncMode.OFF) {
                return true;
            }
        }
        if (damageSync == AutoCrystalDamageSyncMode.CONDITIONS) {
            if (__UNDEF_KEY__ > 0) {
                if (__UNDEF_KEY__ != null) {
                    if (lowCrystals) {
                        if (ItemPacketHelper.INSTANCE.computeValue(Items.field_8301, true) > (64 * stacksLeft)) {
                            if (__UNDEF_KEY__ >= 0) {
                                if (__UNDEF_KEY__ != null) {
                                }
                            }
                            if (__UNDEF_KEY__ <= 0) {
                                if (__UNDEF_KEY__ != null) {
                                }
                            }
                            if (facePlaceSync && !(damage.isActive2()) && damage.getNumericValue() < minDamage) {
                            } else {
                            }
                        }
                    }
                }
            }
            int index = 0;
            if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ != null) {
                if (!(index)) {
                    return true;
                }
            }
        }
        if ((damage.getNumericValue() - factorValue) > 2.0F) {
            return true;
        }
        if (random) {
        } else {
        }
        if (__UNDEF_KEY__ < 0 && __UNDEF_KEY__ != null) {
            if (this.checkCondition(((60 + 0) / TheNetherPacketHelper.INSTANCE.computeValue()))) {
                return true;
            }
        }
        if (!(SpeedMineModule.resolveList(false).isEmpty())) {
            return true;
        }
        if (__UNDEF_KEY__ >= 0) {
        }
        if (__UNDEF_KEY__ >= 0) {
            if (__UNDEF_KEY__ != null) {
                if (enabledFlag) {
                    return true;
                }
            }
        }
        if (SharedKt.getNetwork().method_45734() != null && StringsKt.contains$default(((CharSequence) SharedKt.getNetwork().method_45734().field_3761), ((CharSequence) "tntland"), false) && !(serviceComponent102.checkCondition(15500))) {
            return true;
        }
        return false;
    }

    public void executeAction(float damage) {
        if (damage < 0.0F) {
            return;
        }
        factorValue2 = damage;
        timestampValue = SharedKt.getNumericValue();
    }

    public float computeValue(float currentDamage) {
        return currentDamage;
    }

    public void executeAction2() {
        factorValue = 0.0F;
        factorValue2 = 0.0F;
        timestampValue = 0L;
    }

    static {
        INSTANCE = new DamageSyncServiceComponent();
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
    }

}
