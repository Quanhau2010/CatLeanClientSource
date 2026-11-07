package su.catlean.client.services.client;

import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2172;
import net.minecraft.class_640;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import su.catlean.SharedKt;

public class ReaderServiceComponent2 implements ArgumentType {

    public static final ServiceComponent60 serviceComponent60;

    public ReaderServiceComponent2() {
    }

    public String resolveString(StringReader reader) {
        String var7 = reader.readString();
        class_640 var8 = (class_640) SharedKt.getMc().method_1562().method_2880().stream().filter(this::checkCondition).findFirst().orElse(null);
        if (var6 == null) {
            if (var8 == null) {
                return var7;
            }
        }
        return var8.method_2966().name();
    }

    public CompletableFuture listSuggestions(CommandContext context, SuggestionsBuilder builder) {
        return class_2172.method_9264(SharedKt.getMc().method_1562().method_2880().stream().map(this::resolveString), builder);
    }

    public List resolveList() {
        return SharedKt.getMc().method_1562().method_2880().stream().map(this::resolveString2).limit(5L).toList();
    }

    private static boolean checkCondition(String arg0, class_640 arg1) {
        return Intrinsics.areEqual(arg0, arg1.method_2966().name());
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static String resolveString(class_640 arg0) {
        return arg0.method_2966().name();
    }

    private static String resolveString(Function1 arg0, Object arg1) {
        return (String) arg0.invoke(arg1);
    }

    private static String resolveString2(class_640 arg0) {
        return arg0.method_2966().name();
    }

    private static String resolveString2(Function1 arg0, Object arg1) {
        return (String) arg0.invoke(arg1);
    }

    public Object parse(StringReader p0) {
        return this.resolveString(p0);
    }

    public Collection getExamples() {
        return (Collection) this.resolveList();
    }

    static {
        serviceComponent60 = new ServiceComponent60();
    }

}
