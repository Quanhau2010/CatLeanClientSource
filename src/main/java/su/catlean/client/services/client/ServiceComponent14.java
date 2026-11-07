package su.catlean.client.services.client;

import kotlin.jvm.functions.Function0;

public class ServiceComponent14 implements Runnable {

    private final int countValue;
    private final Function0 function0;

    public ServiceComponent14(int $delay, Function0 $runnable) {
        this.countValue = $delay;
        this.function0 = $runnable;
    }

    public void run() {
        Thread.sleep(this.countValue);
        this.function0.invoke();
    }

}
