package su.catlean.api.event.events.render;

import su.catlean.api.event.Event;

public class BasicProjectionMatrixEvent extends Event {

    public static final BasicProjectionMatrixEvent INSTANCE;
    private static float ratio;
    private static float zoom;
    private static float zoomX;
    private static float zoomY;
    private static float fov;

    private BasicProjectionMatrixEvent() {
        super();
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float value) {
        ratio = value;
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float value) {
        zoom = value;
    }

    public float getZoomX() {
        return zoomX;
    }

    public void setZoomX(float value) {
        zoomX = value;
    }

    public float getZoomY() {
        return zoomY;
    }

    public void setZoomY(float value) {
        zoomY = value;
    }

    public float getFov() {
        return fov;
    }

    public void setFov(float value) {
        fov = value;
    }

    static {
        INSTANCE = new BasicProjectionMatrixEvent();
        ratio = 1.0F;
        zoom = 1.0F;
        zoomX = 1.0F;
        zoomY = 1.0F;
        fov = 1.0F;
    }

}
