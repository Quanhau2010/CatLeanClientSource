package su.catlean.client.services.client;

import kotlin.jvm.internal.MutablePropertyReference0Impl;
import su.catlean.client.services.render.RenderHelper2;
import su.catlean.client.ui.clickgui.WaypointPanelGuiElement;

public class HoveringComponentServiceComponent6 extends MutablePropertyReference0Impl {

    private HoveringComponentServiceComponent6(Object arg0) {
        super(arg0, WaypointPanelGuiElement.class, "hoveringComponent", "getHoveringComponent()Lsu/catlean/f6;", 0);
    }

    public Object get() {
        return ((WaypointPanelGuiElement) this.receiver).getRenderHelper2();
    }

    public void set(Object value) {
        ((WaypointPanelGuiElement) this.receiver).updateValue(((RenderHelper2) value));
    }

}
