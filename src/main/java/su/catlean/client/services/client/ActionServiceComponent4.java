package su.catlean.client.services.client;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import su.catlean.SharedKt;

public class ActionServiceComponent4 {

    public static Pair resolvePair(Function0 action) {
        long time = SharedKt.getNumericValue();
        return TuplesKt.to(action.invoke(), Long.valueOf((SharedKt.getNumericValue() - time)));
    }

}
