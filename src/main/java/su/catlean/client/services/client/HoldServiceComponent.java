package su.catlean.client.services.client;

import kotlin.jvm.internal.MutablePropertyReference0Impl;
import su.catlean.client.services.client.config.models.IdRecord11;

public class HoldServiceComponent extends MutablePropertyReference0Impl {

    private HoldServiceComponent(Object arg0) {
        super(arg0, IdRecord11.class, "hold", "getHold()Z", 0);
    }

    public Object get() {
        return Boolean.valueOf(((IdRecord11) this.receiver).isActive());
    }

    public void set(Object value) {
        ((IdRecord11) this.receiver).updateValue(((Boolean) value));
    }

}
