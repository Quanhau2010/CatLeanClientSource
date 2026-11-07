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
        boolean var3 = this.enabledFlag2;
        boolean var4 = this.enabledFlag;
        float var5 = this.factorValue2;
        float var6 = this.factorValue;
        return ("DamageComparatorResult(damage=" + var6 + ", selfDamage=" + var5 + ", override=" + var4 + ", lethal=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Float.hashCode(this.factorValue);
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag));
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag2));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceComponent95)) {
            return false;
        }
        ServiceComponent95 var5 = (ServiceComponent95) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        if (this.enabledFlag2 != var5.enabledFlag2) {
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
