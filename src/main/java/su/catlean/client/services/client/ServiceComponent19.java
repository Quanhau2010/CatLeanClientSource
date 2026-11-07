package su.catlean.client.services.client;

import java.util.concurrent.CopyOnWriteArrayList;
import su.catlean.client.services.network.EntryPacketHelper;

public class ServiceComponent19 implements Runnable {

    private final int countValue;
    private final ProfileServiceComponent profileServiceComponent;
    private final String[] textValueArray;

    public ServiceComponent19(int arg0, ProfileServiceComponent arg1, String[] arg2) {
        this.countValue = arg0;
        this.profileServiceComponent = arg1;
        this.textValueArray = arg2;
    }

    public void run() {
        Thread.sleep(this.countValue);
        if (EntryPacketHelper.checkCondition(this.profileServiceComponent.resolveString()) && EntryPacketHelper.getCopyOnWriteArrayList().add(this.profileServiceComponent)) {
            EntryPacketHelper.executeAction(this.textValueArray);
        }
    }

}
