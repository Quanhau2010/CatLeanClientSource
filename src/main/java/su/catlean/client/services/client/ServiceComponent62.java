package su.catlean.client.services.client;

import su.catlean.client.services.render.RenderHelper;
import su.catlean.client.services.render.SelectRenderHelperImpl;

public class ServiceComponent62 {

    private ServiceComponent62() {
    }

    public RenderHelper getRenderHelper() {
        return SelectRenderHelperImpl.getRenderHelper();
    }

    public void updateValue(RenderHelper value) {
        SelectRenderHelperImpl.updateValue(value);
    }

}
