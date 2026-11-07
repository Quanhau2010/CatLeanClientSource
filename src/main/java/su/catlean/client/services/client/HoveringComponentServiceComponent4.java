package su.catlean.client.services.client;

import kotlin.jvm.internal.MutablePropertyReference0Impl;
import su.catlean.client.services.render.MacroPanelRenderHelper3Impl;
import su.catlean.client.services.render.RenderHelper2;

public class HoveringComponentServiceComponent4 extends MutablePropertyReference0Impl {

    private HoveringComponentServiceComponent4(Object arg0) {
        super(arg0, MacroPanelRenderHelper3Impl.class, "hoveringComponent", "getHoveringComponent()Lsu/catlean/f6;", 0);
    }

    public Object get() {
        return (MacroPanelRenderHelper3Impl) this.receiver.getRenderHelper2();
    }

    public void set(Object value) {
        (MacroPanelRenderHelper3Impl) this.receiver.updateValue((RenderHelper2) value);
    }

}
