package su.catlean.api.event.events.player;

import net.minecraft.class_4050;
import su.catlean.api.event.Event;

public class SetPoseEvent extends Event {

    public static final SetPoseEvent INSTANCE;
    private static class_4050 pose;

    private SetPoseEvent() {
        super();
    }

    public class_4050 getPose() {
        return pose;
    }

    public void setPose(class_4050 value) {
        pose = value;
    }

    static {
        INSTANCE = new SetPoseEvent();
        pose = class_4050.field_18076;
    }

}
