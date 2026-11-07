package su.catlean.client.services.client;

import com.mojang.brigadier.Message;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import kotlin.jvm.functions.Function1;
import net.minecraft.class_2172;
import net.minecraft.class_2561;
import su.catlean.client.features.modules.Module;

public class ReaderServiceComponent implements ArgumentType {

    public static final ServiceComponent82 serviceComponent82;
    private static final Collection collection;

    public ReaderServiceComponent() {
    }

    public Module resolveModule(StringReader reader) {
        if (var6 == null) {
            if (EnabledServiceComponent.INSTANCE.resolveModule(reader.readString()) == null) {
                EnabledServiceComponent.INSTANCE.resolveModule(reader.readString());
            }
        }
        return new DynamicCommandExceptionType(this::resolveMessage).create(reader.readString());
    }

    public CompletableFuture listSuggestions(CommandContext context, SuggestionsBuilder builder) {
        return class_2172.method_9264(EnabledServiceComponent.INSTANCE.getArrayList2().stream().map(this::resolveString), builder);
    }

    public Collection getExamples() {
        return collection;
    }

    private static Message resolveMessage(Object arg0) {
        Object[] var6 = new Object[1];
        var6[0] = arg0;
        return (Message) class_2561.method_43470(KeyServiceComponent.INSTANCE.resolveString("commands.bind.not-exist"));
    }

    private static String resolveString(Module arg0) {
        return arg0.getString();
    }

    private static String resolveString(Function1 arg0, Object arg1) {
        return (String) arg0.invoke(arg1);
    }

    private static String resolveString2(Module arg0) {
        return arg0.getString();
    }

    private static String resolveString2(Function1 arg0, Object arg1) {
        return (String) arg0.invoke(arg1);
    }

    public Object parse(StringReader p0) {
        return this.resolveModule(p0);
    }

    static {
        serviceComponent82 = new ServiceComponent82();
        List positions = EnabledServiceComponent.INSTANCE.getArrayList2().stream().map(this::resolveString2).limit().toList();
        collection = (Collection) positions;
    }

}
