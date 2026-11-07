package su.catlean.client.services.client;

import java.awt.Color;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import su.catlean.client.services.render.ThemeRenderHelper;

public class SettingServiceComponent3 extends MutablePropertyReference0Impl {

    private SettingServiceComponent3(Object arg0) {
        super(arg0, ThemeRenderHelper.class, "setting", "getSetting()Ljava/awt/Color;", 0);
    }

    public Object get() {
        return ((ThemeRenderHelper) this.receiver).getColor();
    }

    public void set(Object value) {
        ((ThemeRenderHelper) this.receiver).executeAction(((Color) value));
    }

}
