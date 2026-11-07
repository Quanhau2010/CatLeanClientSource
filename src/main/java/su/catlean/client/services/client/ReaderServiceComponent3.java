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
        String text = reader.readString();
        Iterable iterable = ((Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList());
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord3 idRecord3 = ((IdRecord3) element);
            if (__UNDEF_KEY__ >= 0L) {
                collection.add(idRecord3.getString());
                if (__UNDEF_KEY__ == null && !(collection.contains(text))) {
                }
            }
        }
        return text;
    }

    public CompletableFuture listSuggestions(CommandContext context, SuggestionsBuilder builder) {
        Iterable iterable = ((Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList());
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord3 idRecord3 = ((IdRecord3) element);
            if (__UNDEF_KEY__ == null) {
                collection.add(idRecord3.getString());
            }
        }
        return class_2172.method_9265(((Iterable) collection), builder);
    }

    public List resolveList(int arg0) {
        Iterable iterable = ((Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList());
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IdRecord3 idRecord3 = ((IdRecord3) element);
            if (__UNDEF_KEY__ == null) {
                collection.add(idRecord3.getString());
            }
        }
        return collection.stream().limit(timestampValue).toList();
    }

    private static Message resolveMessage(Object arg0) {
        Object[] items = new Object[1];
        items[0] = arg0;
        return ((Message) class_2561.method_43470(KeyServiceComponent.INSTANCE.resolveString("commands.config.not-exist", items)));
    }

    public Object parse(StringReader p0) {
        return this.resolveString(p0);
    }

    public Collection getExamples() {
        return ((Collection) this.resolveList());
    }

    static {
        serviceComponent111 = new ServiceComponent111();
    }

}
