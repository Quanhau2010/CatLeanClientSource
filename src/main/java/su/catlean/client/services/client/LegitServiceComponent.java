package su.catlean.client.services.client;

import kotlin.jvm.internal.MutablePropertyReference0Impl;
import su.catlean.client.services.client.config.models.IdRecord;

public class LegitServiceComponent extends MutablePropertyReference0Impl {

    private LegitServiceComponent(Object arg0) {
        super(arg0, IdRecord.class, "legit", "getLegit()Z", 0);
    }

    public Object get() {
        return Boolean.valueOf(((IdRecord) this.receiver).isActive());
    }

    public void set(Object value) {
        ((IdRecord) this.receiver).updateValue(((Boolean) value));
    }

}
