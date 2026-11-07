package su.catlean.api.event.events.world;

import org.joml.Vector4f;
import su.catlean.api.event.Event;

public class ApplyFogEvent extends Event {

    public static final ApplyFogEvent INSTANCE;
    private static Vector4f colorVec;
    private static float eStart;
    private static float eEnd;
    private static float rStart;
    private static float rEnd;

    private ApplyFogEvent() {
        super();
    }

    public Vector4f getColorVec() {
        return colorVec;
    }

    public void setColorVec(Vector4f value) {
        colorVec = value;
    }

    public float getEStart() {
        return eStart;
    }

    public void setEStart(float value) {
        eStart = value;
    }

    public float getEEnd() {
        return eEnd;
    }

    public void setEEnd(float value) {
        eEnd = value;
    }

    public float getRStart() {
        return rStart;
    }

    public void setRStart(float value) {
        rStart = value;
    }

    public float getREnd() {
        return rEnd;
    }

    public void setREnd(float value) {
        rEnd = value;
    }

    static {
        INSTANCE = new ApplyFogEvent();
        colorVec = new Vector4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

}
