package su.catlean.client.services.client;

import com.mojang.brigadier.Message;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import net.minecraft.class_2172;
import net.minecraft.class_2561;
import su.catlean.client.services.player.PlayerEntityHelper;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class ReaderServiceComponent4 implements ArgumentType {

    public static final ServiceComponent56 serviceComponent56;

    public ReaderServiceComponent4() {
    }

    public String resolveString(StringReader reader) {
        String var6 = reader.readString();
        if (!(PlayerEntityHelper.INSTANCE.checkCondition())) {
        }
        return var6;
    }

    public CompletableFuture listSuggestions(CommandContext context, SuggestionsBuilder builder) {
        return class_2172.method_9265((Iterable) ProxyGuiElement.INSTANCE.getJsonServiceComponent2().resolveList(), builder);
    }

    public List resolveList() {
        return ProxyGuiElement.INSTANCE.getJsonServiceComponent2().resolveList().stream().limit(5L).toList();
    }

    private static Message resolveMessage(Object arg0) {
        Object[] var6 = new Object[1];
        var6[0] = arg0;
        return (Message) class_2561.method_43470(KeyServiceComponent.INSTANCE.resolveString("commands.friend.not-exist"));
    }

    public Object parse(StringReader p0) {
        return this.resolveString(p0);
    }

    public Collection getExamples() {
        return (Collection) this.resolveList();
    }

    static {
        serviceComponent56 = new ServiceComponent56();
    }

}
