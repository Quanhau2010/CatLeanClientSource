package su.catlean.client.services.client;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_3675;
import net.minecraft.class_3675.class_306;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.misc.UIModule;
import su.catlean.client.services.client.config.models.KeyRecord;

public class BindDispatcherServiceComponentImpl extends DispatcherServiceComponent {

    public static final BindDispatcherServiceComponentImpl INSTANCE;

    private BindDispatcherServiceComponentImpl() {
        super("bind");
    }

    public void executeAction(LiteralArgumentBuilder builder) {
        builder.then(this.resolveRequiredArgumentBuilder("module", ((ArgumentType) ReaderServiceComponent.serviceComponent82.getReaderServiceComponent())).then(this.resolveRequiredArgumentBuilder("key", ((ArgumentType) StringArgumentType.word())).executes(this::computeValue)));
        builder.then(this.resolveLiteralArgumentBuilder("list").executes(this::computeValue2));
        builder.then(this.resolveLiteralArgumentBuilder("clear").executes(this::computeValue3));
        builder.then(this.resolveLiteralArgumentBuilder("reset").executes(this::computeValue4));
        builder.executes(this::computeValue5);
    }

    private static int computeValue(CommandContext arg0) {
        Module module = ((Module) arg0.getArgument("module", Module.class));
        String text = ((String) arg0.getArgument("key", String.class));
        if (text == null) {
            INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.bind.no-such-button", new Object[0]));
            return 1;
        }
        if (!(StringsKt.equals(text, "none", true))) {
            if (StringsKt.equals(text, "null", true)) {
            } else {
                int index = class_3675.method_15981(("key.keyboard." + text.toLowerCase(Locale.ROOT))).method_1444();
            }
        }
        if (!(index)) {
            INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.bind.no-such-button", new Object[0]));
            return 1;
        }
        module.setBind(new KeyRecord(index, false, StringsKt.contains$default(((CharSequence) text), ((CharSequence) "M"), false)));
        INSTANCE.executeAction(((class_2561) AdditionServiceComponent.resolveMinecraftObject2(AdditionServiceComponent.resolveMinecraftObject(AdditionServiceComponent.resolveMinecraftObject(AdditionServiceComponent.resolveMinecraftObject(), module.getString2()), KeyServiceComponent.INSTANCE.resolveString("commands.bind.bound-to", new Object[0])), text.toUpperCase(Locale.ROOT))));
        return 1;
    }

    private static int computeValue2(CommandContext arg0) {
        StringBuilder stringBuilder = new StringBuilder(KeyServiceComponent.INSTANCE.resolveString("commands.bind.binds", new Object[0]));
        Iterator iterator = EnabledServiceComponent.INSTANCE.getArrayList2().iterator();
        while (iterator.hasNext()) {
            Module module = ((Module) iterator.next());
            if (module.getBind().isActive()) {
            } else {
            }
            "[hold]".append("");
        }
        INSTANCE.executeAction(stringBuilder.toString());
        return 1;
    }

    private static int computeValue3(CommandContext arg0) {
        Iterable iterable = ((Iterable) EnabledServiceComponent.INSTANCE.getArrayList2());
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Module module = ((Module) element);
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index = ((Module) collection);
            iterator = 0;
            index.setBind(new KeyRecord(0, false, false));
        }
        return 1;
    }

    private static int computeValue4(CommandContext arg0) {
        Iterable iterable = ((Iterable) EnabledServiceComponent.INSTANCE.getArrayList2());
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Module module = ((Module) element);
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index = ((Module) collection);
            iterator = 0;
            index.setBind(new KeyRecord(0, false, false));
        }
        return 1;
    }

    private static int computeValue5(CommandContext arg0) {
        INSTANCE.executeAction((class_124.field_1061 + "bind <id> <key> / bind list / bind clear"));
        return 1;
    }

    static {
        INSTANCE = new BindDispatcherServiceComponentImpl();
    }

}
