package su.catlean.api.event;

public class GofraState {

    public static final GofraState INSTANCE;
    private static boolean modifyBuffer;
    private static boolean modifyCollisions;
    private static boolean shouldRender;
    private static boolean stopSwapBuffers;
    private static boolean xray;

    private GofraState() {
    }

    public boolean getModifyBuffer() {
        return modifyBuffer;
    }

    public void setModifyBuffer(boolean value) {
        modifyBuffer = value;
    }

    public boolean getModifyCollisions() {
        return modifyCollisions;
    }

    public void setModifyCollisions(boolean value) {
        modifyCollisions = value;
    }

    public boolean getShouldRender() {
        return shouldRender;
    }

    public void setShouldRender(boolean value) {
        shouldRender = value;
    }

    public boolean getStopSwapBuffers() {
        return stopSwapBuffers;
    }

    public void setStopSwapBuffers(boolean value) {
        stopSwapBuffers = value;
    }

    public boolean getXray() {
        return xray;
    }

    public void setXray(boolean value) {
        xray = value;
    }

    static {
        INSTANCE = new GofraState();
    }

}
