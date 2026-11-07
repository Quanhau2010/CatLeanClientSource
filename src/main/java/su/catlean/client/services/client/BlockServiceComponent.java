package su.catlean.client.services.client;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public class BlockServiceComponent {

    public static boolean checkCondition(AppIdXDGRUNTIMEDIRServiceComponentImpl receiver, Function1 block) {
        DraftIdServiceComponent draftIdServiceComponent = new DraftIdServiceComponent();
        block.invoke(draftIdServiceComponent);
        return ServiceComponent76.INSTANCE.getList().add(draftIdServiceComponent);
    }

    public static void executeAction(AppIdXDGRUNTIMEDIRServiceComponentImpl receiver, Object draftId) {
        Iterable iterable = ((Iterable) ServiceComponent76.INSTANCE.getList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            DraftIdServiceComponent draftIdServiceComponent = ((DraftIdServiceComponent) element);
            int index = 0;
        }
        if (((DraftIdServiceComponent) null) != null) {
            iterator = ((DraftIdServiceComponent) null);
            element = 0;
            draftIdServiceComponent = AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE;
            index = draftIdServiceComponent;
            index.setDetails(iterator.getString());
            index.setState(iterator.getString2());
            index.setLargeImage(iterator.getPair());
            index.setSmallImage(iterator.getPair2());
            index.setButton1(iterator.getPair3());
            index.setButton2(iterator.getPair4());
            if (draftIdServiceComponent == null) {
                System.out.println(("Discord IPC - Draft with id " + draftId + " not found"));
            }
        }
    }

}
