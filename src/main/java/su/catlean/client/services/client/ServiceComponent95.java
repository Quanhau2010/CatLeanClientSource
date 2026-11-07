package su.catlean.client.services.client;

public class ServiceComponent95 {

    private final float factorValue;
    private final float factorValue2;
    private final boolean enabledFlag;
    private final boolean enabledFlag2;
    private static String textValue;

    public ServiceComponent95(float damage, float selfDamage, boolean override, boolean lethal) {
        this.factorValue = damage;
        this.factorValue2 = selfDamage;
        this.enabledFlag = override;
        this.enabledFlag2 = lethal;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public boolean isActive2() {
        return this.enabledFlag2;
    }

    public float getNumericValue3() {
        return this.factorValue;
    }

    public float getNumericValue4() {
        return this.factorValue2;
    }

    public boolean isActive3() {
        return this.enabledFlag;
    }

    public boolean isActive4() {
        return this.enabledFlag2;
    }

    public ServiceComponent95 resolveServiceComponent95(float damage, float selfDamage, boolean override, boolean lethal) {
        return new ServiceComponent95(damage, selfDamage, override, lethal);
    }

    public String toString() {
        boolean flag = this.enabledFlag2;
        boolean flag2 = this.enabledFlag;
        float factor = this.factorValue2;
        float factor2 = this.factorValue;
        return ("DamageComparatorResult(damage=" + factor2 + ", selfDamage=" + factor + ", override=" + flag2 + ", lethal=" + flag + ")");
    }

    public int hashCode() {
        int index = Float.hashCode(this.factorValue);
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag2));
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent95)) {
            return false;
        }
        ServiceComponent95 serviceComponent95 = ((ServiceComponent95) other);
        if (Float.compare(this.factorValue, serviceComponent95.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, serviceComponent95.factorValue2)) {
            return false;
        }
        if (this.enabledFlag != serviceComponent95.enabledFlag) {
            return false;
        }
        if (this.enabledFlag2 != serviceComponent95.enabledFlag2) {
            return false;
        }
        return true;
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
