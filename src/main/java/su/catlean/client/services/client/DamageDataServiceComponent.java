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
        boolean flag = this.object != null;
        flag = ((flag * 31) + this.serviceComponent95.hashCode());
        return flag;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DamageDataServiceComponent)) {
            return false;
        }
        DamageDataServiceComponent damageDataServiceComponent = ((DamageDataServiceComponent) other);
        if (!(Intrinsics.areEqual(this.object, damageDataServiceComponent.object))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.serviceComponent95, damageDataServiceComponent.serviceComponent95))) {
            return false;
        }
        return true;
    }

}
