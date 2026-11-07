package su.catlean.client.services.client;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public class BlockServiceComponent {

    public static boolean checkCondition(AppIdXDGRUNTIMEDIRServiceComponentImpl receiver, Function1 block) {
        DraftIdServiceComponent var6 = new DraftIdServiceComponent(null, null, null, null, null, null, null, -4324700345272893313L);
        block.invoke();
        return ServiceComponent76.INSTANCE.getList().add();
    }

    public static void executeAction(AppIdXDGRUNTIMEDIRServiceComponentImpl receiver, Object draftId) {
        Iterable var7 = (Iterable) ServiceComponent76.INSTANCE.getList();
        int var8 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            DraftIdServiceComponent var11 = (DraftIdServiceComponent) var10;
            int var12 = 0;
        } else {
        }
        if ((DraftIdServiceComponent) null != null) {
            iterator = (DraftIdServiceComponent) null;
            var10 = 0;
            var11 = AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE;
            var12 = var11;
            int var13 = 0;
            var12.setDetails(iterator.getString());
            var12.setState(iterator.getString2());
            var12.setLargeImage(iterator.getPair());
            var12.setSmallImage(iterator.getPair2());
            var12.setButton1(iterator.getPair3());
            var12.setButton2(iterator.getPair4());
            if (var11 == null) {
            }
            System.out.println(("Discord IPC - Draft with id " + draftId + " not found"));
        }
    }

}
