package su.catlean.client.services.client;

import com.mojang.brigadier.Message;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import kotlin.collections.CollectionsKt;
import net.minecraft.class_2172;
import net.minecraft.class_2561;
import su.catlean.client.services.client.config.models.IdRecord3;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class ReaderServiceComponent3 implements ArgumentType {

    public static final ServiceComponent111 serviceComponent111;

    public ReaderServiceComponent3() {
    }

    public String resolveString(StringReader reader) {
        String var10 = reader.readString();
        Iterable var11 = (Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList();
        int var12 = 0;
        Object var13 = var11;
        Collection var14 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var15 = 0;
        Iterator iterator = var13.iterator();
        if (iterator.hasNext()) {
            Object var17 = iterator.next();
            IdRecord3 var18 = (IdRecord3) var17;
            Object var20 = var14;
            int var19 = 0;
            if (0L >= 0L) {
                var20.add(var18.getString());
            }
            if (var9 == null && !(var14.contains())) {
            }
        }
        return var10;
    }

    public CompletableFuture listSuggestions(CommandContext context, SuggestionsBuilder builder) {
        Iterable var8 = (Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList();
        int var9 = 0;
        Object var10 = var8;
        Collection var11 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var12 = 0;
        Iterator iterator = var10.iterator();
        if (iterator.hasNext()) {
            Object var14 = iterator.next();
            IdRecord3 var15 = (IdRecord3) var14;
            if (var7 == null) {
                Object var17 = var11;
                int var16 = 0;
                var17.add(var15.getString());
            }
        }
        return class_2172.method_9265((Iterable) var11, builder);
    }

    public List resolveList(int arg0) {
        Iterable var9 = (Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList();
        int var10 = 0;
        Object var11 = var9;
        Collection var12 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var13 = 0;
        Iterator iterator = var11.iterator();
        if (iterator.hasNext()) {
            Object var15 = iterator.next();
            IdRecord3 var16 = (IdRecord3) var15;
            if (var8 == null) {
                Object var18 = var12;
                int var17 = 0;
                var18.add(var16.getString());
            }
        }
        return var12.stream().limit(timestampValue).toList();
    }

    private static Message resolveMessage(Object arg0) {
        Object[] var6 = new Object[1];
        var6[0] = arg0;
        return (Message) class_2561.method_43470(KeyServiceComponent.INSTANCE.resolveString("commands.config.not-exist"));
    }

    public Object parse(StringReader p0) {
        return this.resolveString(p0);
    }

    public Collection getExamples() {
        return (Collection) this.resolveList();
    }

    static {
        serviceComponent111 = new ServiceComponent111();
    }

}
