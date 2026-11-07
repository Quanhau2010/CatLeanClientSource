package su.catlean.client.services.client;

import kotlin.jvm.internal.MutablePropertyReference0Impl;
import su.catlean.client.services.client.config.models.IdRecord12;

public class Socks4ServiceComponent extends MutablePropertyReference0Impl {

    private Socks4ServiceComponent(Object arg0) {
        super(arg0, IdRecord12.class, "socks4", "getSocks4()Z", 0);
    }

    public Object get() {
        return Boolean.valueOf(((IdRecord12) this.receiver).isActive());
    }

    public void set(Object value) {
        ((IdRecord12) this.receiver).updateValue(((Boolean) value));
    }

}
