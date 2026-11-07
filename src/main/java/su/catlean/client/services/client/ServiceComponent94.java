package su.catlean.client.services.client;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServiceComponent94 implements Runnable {

    private final int countValue;

    public ServiceComponent94(int $delay) {
        this.countValue = $delay;
    }

    public void run() {
        Thread.sleep(this.countValue);
        int var6 = 0;
        List positions = ContentTypeServiceComponent.INSTANCE.resolveList();
        ContentTypeServiceComponent.getCopyOnWriteArrayList().clear();
        ContentTypeServiceComponent.getCopyOnWriteArrayList().addAll((Collection) positions);
    }

}
