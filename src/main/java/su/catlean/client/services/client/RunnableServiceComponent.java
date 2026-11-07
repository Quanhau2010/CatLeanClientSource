package su.catlean.client.services.client;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.client.PostTickEvent;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;

public class RunnableServiceComponent implements Contract9 {

    public static final RunnableServiceComponent INSTANCE;
    private static AtomicBoolean atomicBoolean;
    private static ExecutorService executorService;
    private static List itemList;
    private static boolean enabledFlag;

    private RunnableServiceComponent() {
    }

    public AtomicBoolean getAtomicBoolean() {
        return atomicBoolean;
    }

    public void executeAction(AtomicBoolean value) {
        atomicBoolean = value;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void executeAction(ExecutorService value) {
        executorService = value;
    }

    public List getList() {
        return itemList;
    }

    public void executeAction(List value) {
        itemList = value;
    }

    private void onTickEvent(TickEvent arg0) {
        atomicBoolean.set(1);
    }

    private void onPostTickEvent(PostTickEvent arg0) {
        atomicBoolean.set(0);
    }

    public boolean checkCondition() {
        if (!(SharedKt.getMc().method_18854())) {
            if (!(atomicBoolean.get())) {
            }
        } else {
        }
        return false;
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        itemList = Lists.newArrayList((Iterable) SharedKt.getWorld().getPlayers());
    }

    public void executeAction(int delay, Function0 runnable) {
        int var8 = 0;
        this.getExecutorService().execute((Runnable) new ServiceComponent14(delay, runnable));
    }

    public static void executeAction(RunnableServiceComponent arg0, int arg1, Function0 arg2, int arg3, Object arg4) {
        if ((arg3 & 1)) {
            arg1 = 0;
        }
        arg3 = 0;
        arg0.getExecutorService().execute((Runnable) new ServiceComponent14(arg1, arg2));
    }

    static {
        INSTANCE = new RunnableServiceComponent();
        atomicBoolean = new AtomicBoolean(0);
        executorService = Executors.newVirtualThreadPerTaskExecutor();
        itemList = CollectionsKt.emptyList();
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
