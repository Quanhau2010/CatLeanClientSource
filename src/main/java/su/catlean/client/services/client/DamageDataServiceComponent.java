package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;

public class DamageDataServiceComponent {

    private final Object object;
    private final ServiceComponent95 serviceComponent95;

    public DamageDataServiceComponent(Object data, ServiceComponent95 damageData) {
        this.object = data;
        this.serviceComponent95 = damageData;
    }

    public Object getObject() {
        return this.object;
    }

    public ServiceComponent95 getServiceComponent95() {
        return this.serviceComponent95;
    }

    public Object getObject2() {
        return this.object;
    }

    public ServiceComponent95 getServiceComponent952() {
        return this.serviceComponent95;
    }

    public DamageDataServiceComponent resolveDamageDataServiceComponent(Object data, ServiceComponent95 damageData) {
        return new DamageDataServiceComponent(data, damageData);
    }

    public String toString() {
        return (null + this.object + ", damageData=" + this.serviceComponent95 + ")");
    }

    public int hashCode() {
        boolean var4 = this.object != null;
        var4 = ((var4 * -748536993520025569L) + this.serviceComponent95.hashCode());
        return var4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DamageDataServiceComponent)) {
            return false;
        }
        DamageDataServiceComponent var5 = (DamageDataServiceComponent) other;
        if (!(Intrinsics.areEqual(this.object, var5.object))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.serviceComponent95, var5.serviceComponent95))) {
            return false;
        }
        return true;
    }

}
