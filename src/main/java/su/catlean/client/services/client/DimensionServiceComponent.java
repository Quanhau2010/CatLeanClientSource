package su.catlean.client.services.client;

import kotlin.jvm.internal.MutablePropertyReference0Impl;
import su.catlean.client.services.client.config.models.IdRecord7;

public class DimensionServiceComponent extends MutablePropertyReference0Impl {

    private DimensionServiceComponent(Object arg0) {
        super(arg0, IdRecord7.class, "dimension", "getDimension()I", 0);
    }

    public Object get() {
        return Integer.valueOf(((IdRecord7) this.receiver).getNumericValue4());
    }

    public void set(Object value) {
        ((IdRecord7) this.receiver).updateValue4(((Number) value));
    }

}
