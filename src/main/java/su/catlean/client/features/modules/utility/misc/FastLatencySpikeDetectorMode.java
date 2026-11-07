package su.catlean.client.features.modules.utility.misc;

public enum FastLatencySpikeDetectorMode {

    public static final FastLatencySpikeDetectorMode OFF;
    public static final FastLatencySpikeDetectorMode NOTIFICATION;
    public static final FastLatencySpikeDetectorMode CHAT;
    public static final FastLatencySpikeDetectorMode BOTH;

    FastLatencySpikeDetectorMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

}
