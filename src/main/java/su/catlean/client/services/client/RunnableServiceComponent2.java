package su.catlean.client.services.client;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import su.catlean.api.event.events.network.PostTasksProcessEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;

public class RunnableServiceComponent2 {

    public static final RunnableServiceComponent2 INSTANCE;
    private static final ArrayDeque arrayDeque;
    private static final ArrayDeque arrayDeque2;
    private static boolean enabledFlag;
    private static int[] countValueArray;

    private RunnableServiceComponent2() {
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        this.executeAction(this::checkCondition);
    }

    private void onPlayerUpdateEvent2(PlayerUpdateEvent arg0) {
        this.executeAction(this::checkCondition2);
    }

    private void onPostTasksProcessEvent(PostTasksProcessEvent arg0) {
        this.executeAction(this::checkCondition3);
    }

    public void executeAction(int delay, byte priority, boolean tick, Runnable runnable) {
        ActionServiceComponent actionServiceComponent = new ActionServiceComponent(runnable, delay, priority, tick);
        if (__UNDEF_KEY__ != null) {
            if (enabledFlag) {
                arrayDeque2.addLast(actionServiceComponent);
                if (__UNDEF_KEY__ == null) {
                    arrayDeque.addLast(actionServiceComponent);
                }
            }
        }
    }

    public static void executeAction(RunnableServiceComponent2 arg0, int arg1, byte arg2, boolean arg3, Runnable arg4, int arg5, Object arg6) {
        if ((arg5 & 1) != 0) {
            arg1 = 0;
        }
        if ((arg5 & 2) != 0) {
            arg2 = 10;
        }
        if ((arg5 & 4) != 0) {
            arg3 = 1;
        }
        arg0.executeAction(arg1, arg2, arg3, arg4);
    }

    private void executeAction(Function1 arg0) {
        enabledFlag = 1;
        Iterator iterator = arrayDeque.iterator();
        while (iterator.hasNext()) {
            ActionServiceComponent actionServiceComponent = ((ActionServiceComponent) iterator.next());
            iterator.remove();
        }
        enabledFlag = 0;
        enabledFlag = 0;
        arrayDeque.addLast(arrayDeque2.removeFirst());
    }

    private static boolean checkCondition(ActionServiceComponent arg0) {
        return arg0.process() == 10;
    }

    private static boolean checkCondition2(ActionServiceComponent arg0) {
        return arg0.process() != 10;
    }

    private static boolean checkCondition3(ActionServiceComponent arg0) {
        return !(arg0.isActive());
    }

    static {
        INSTANCE = new RunnableServiceComponent2();
        arrayDeque = new ArrayDeque();
        arrayDeque2 = new ArrayDeque();
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
