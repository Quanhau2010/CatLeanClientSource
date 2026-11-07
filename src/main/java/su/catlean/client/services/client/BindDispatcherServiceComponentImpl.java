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
        long var4 = (0L ^ 131983109906692L);
        long var6 = (0L ^ 61473902788714L);
        builder.then(this.resolveRequiredArgumentBuilder("module", (ArgumentType) ReaderServiceComponent.serviceComponent82.getReaderServiceComponent()).then(this.resolveRequiredArgumentBuilder("key", (ArgumentType) StringArgumentType.word()).executes(this::computeValue)));
        builder.then(this.resolveLiteralArgumentBuilder("list").executes(this::computeValue2));
        builder.then(this.resolveLiteralArgumentBuilder("clear").executes(this::computeValue3));
        builder.then(this.resolveLiteralArgumentBuilder("reset").executes(this::computeValue4));
        builder.executes(this::computeValue5);
    }

    private static int computeValue(CommandContext arg0) {
        Module var21 = (Module) arg0.getArgument("module", Module.class);
        String var22 = (String) arg0.getArgument("key", String.class);
        if (var22 == null) {
            INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.bind.no-such-button", new Object[0]));
            return 1;
        }
        if (!(StringsKt.equals("none", 1))) {
            if (StringsKt.equals("null", 1)) {
            }
        } else {
            int var24 = class_3675.method_15981(("key.keyboard." + var22.toLowerCase(Locale.ROOT))).method_1444();
        }
        int var23 = var24;
        if (!(var23)) {
            INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.bind.no-such-button", new Object[0]));
            return 1;
        }
        var21.setBind(new KeyRecord(0, StringsKt.contains$default((CharSequence) var22, (CharSequence) "M")));
        INSTANCE.executeAction((class_2561) AdditionServiceComponent.resolveMinecraftObject2(AdditionServiceComponent.resolveMinecraftObject(AdditionServiceComponent.resolveMinecraftObject(AdditionServiceComponent.resolveMinecraftObject(), var21.getString2()), KeyServiceComponent.INSTANCE.resolveString("commands.bind.bound-to", new Object[0])), var22.toUpperCase(Locale.ROOT)));
        return 1;
    }

    private static int computeValue2(CommandContext arg0) {
        StringBuilder var13 = new StringBuilder(KeyServiceComponent.INSTANCE.resolveString("commands.bind.binds", new Object[0]));
        Iterator iterator = EnabledServiceComponent.INSTANCE.getArrayList2().iterator();
        while (iterator.hasNext()) {
            Module var15 = (Module) iterator.next();
            if (var15.getBind().isActive()) {
            } else {
            }
            "[hold]".append("");
        }
        INSTANCE.executeAction(var13.toString());
        return 1;
    }

    private static int computeValue3(CommandContext arg0) {
        Iterable var8 = (Iterable) EnabledServiceComponent.INSTANCE.getArrayList2();
        int var9 = 0;
        Object var10 = var8;
        Collection var11 = (Collection) new ArrayList();
        int var12 = 0;
        Iterator iterator = var10.iterator();
        while (iterator.hasNext()) {
            Object var14 = iterator.next();
            Module var15 = (Module) var14;
            int var16 = 0;
            var11.add();
        }
        var8 = (Iterable) var11;
        var9 = 0;
        var10 = var8.iterator();
        while (var10.hasNext()) {
            var11 = var10.next();
            var12 = (Module) var11;
            iterator = 0;
            var12.setBind(new KeyRecord());
        }
        return 1;
    }

    private static int computeValue4(CommandContext arg0) {
        Iterable var8 = (Iterable) EnabledServiceComponent.INSTANCE.getArrayList2();
        int var9 = 0;
        Object var10 = var8;
        Collection var11 = (Collection) new ArrayList();
        int var12 = 0;
        Iterator iterator = var10.iterator();
        while (iterator.hasNext()) {
            Object var14 = iterator.next();
            Module var15 = (Module) var14;
            int var16 = 0;
            var11.add();
        }
        var8 = (Iterable) var11;
        var9 = 0;
        var10 = var8.iterator();
        while (var10.hasNext()) {
            var11 = var10.next();
            var12 = (Module) var11;
            iterator = 0;
            var12.setBind(new KeyRecord());
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
