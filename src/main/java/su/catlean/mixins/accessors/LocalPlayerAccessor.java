package su.catlean.mixins.accessors;

public interface LocalPlayerAccessor {

    public void iSendMovementPackets();

    public float getLastYaw();

    public float getLastPitch();

    public void setLastYaw(float value);

    public void setLastPitch(float value);

    public double getLastX();

    public double getLastBaseY();

    public double getLastZ();

    public void setJumpRidingScale(float value);

}
