package su.catlean.client.services.client;

import kotlin.jvm.internal.MutablePropertyReference0Impl;
import su.catlean.client.services.render.ProxyPanelRenderHelper3Impl;
import su.catlean.client.services.render.RenderHelper2;

public class HoveringComponentServiceComponent9 extends MutablePropertyReference0Impl {

    private HoveringComponentServiceComponent9(Object arg0) {
        super(arg0, ProxyPanelRenderHelper3Impl.class, "hoveringComponent", "getHoveringComponent()Lsu/catlean/f6;", 0);
    }

    public Object get() {
        return ((ProxyPanelRenderHelper3Impl) this.receiver).getRenderHelper2();
    }

    public void set(Object value) {
        ((ProxyPanelRenderHelper3Impl) this.receiver).updateValue(((RenderHelper2) value));
    }

}
