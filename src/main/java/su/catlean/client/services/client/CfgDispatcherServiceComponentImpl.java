package su.catlean.client.services.client;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_124;
import net.minecraft.class_156;
import net.minecraft.class_156.class_158;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.config.models.IdRecord3;
import su.catlean.client.types.OptionMode8;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class CfgDispatcherServiceComponentImpl extends DispatcherServiceComponent {

    public static final CfgDispatcherServiceComponentImpl INSTANCE;

    private CfgDispatcherServiceComponentImpl() {
        super("cfg");
    }

    public void executeAction(LiteralArgumentBuilder builder) {
        long var4 = (0L ^ 131983109906692L);
        long var6 = (0L ^ 61473902788714L);
        builder.then(this.resolveLiteralArgumentBuilder("list").executes(this::computeValue));
        builder.then(this.resolveLiteralArgumentBuilder("folder").executes(this::computeValue2));
        builder.then(this.resolveLiteralArgumentBuilder("reset").executes(this::computeValue3));
        builder.then(this.resolveLiteralArgumentBuilder("save").then(this.resolveRequiredArgumentBuilder("name", (ArgumentType) StringArgumentType.word()).executes(this::computeValue4)));
        builder.then(this.resolveLiteralArgumentBuilder("load").then(this.resolveRequiredArgumentBuilder("name", (ArgumentType) ReaderServiceComponent3.serviceComponent111.getReaderServiceComponent3()).executes(this::computeValue5)));
        builder.then(this.resolveLiteralArgumentBuilder("remove").then(this.resolveRequiredArgumentBuilder("name", (ArgumentType) ReaderServiceComponent3.serviceComponent111.getReaderServiceComponent3()).executes(this::computeValue6)));
        builder.executes(this::computeValue7);
    }

    private static int computeValue(CommandContext arg0) {
        StringBuilder var13 = new StringBuilder(KeyServiceComponent.INSTANCE.resolveString("commands.config.configs", new Object[0]));
        Iterator iterator = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList().iterator();
        while (iterator.hasNext()) {
            IdRecord3 var15 = (IdRecord3) iterator.next();
            if (Intrinsics.areEqual(ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveIdRecord3())) {
            } else {
            }
            class_124.field_1060.append(("")).append(var15.getString()).append(class_124.field_1070);
        }
        INSTANCE.executeAction(var13.toString());
        return 1;
    }

    private static int computeValue2(CommandContext arg0) {
        File var4 = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().getFile();
        Object var5 = var4;
        class_158 var7 = class_156.method_668();
        int var6 = 0;
        if (var3 == null) {
            if (!(var5.exists())) {
                var5.createNewFile();
            }
            var7.method_672();
        }
        var4.printStackTrace();
        return 1;
    }

    private static int computeValue3(CommandContext arg0) {
        Iterator iterator = EnabledServiceComponent.INSTANCE.getArrayList2().iterator();
        if (iterator.hasNext()) {
            Module var9 = (Module) iterator.next();
            if (var9.getEnabled()) {
                var9.updateValue2();
            }
            Iterator iterator2 = var9.getList().iterator();
            while (iterator2.hasNext()) {
            }
            VisibleSettingProperty var11 = (VisibleSettingProperty) iterator2.next();
            var11.setValue();
        }
        return 1;
    }

    private static int computeValue4(CommandContext arg0) {
        String var11 = (String) arg0.getArgument("name", String.class);
        DefaultServiceComponent.executeAction(OptionMode8.MODULES);
        Object[] var12 = new Object[1];
        var12[0] = var11;
        INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.config.saved"));
        return 1;
    }

    private static int computeValue5(CommandContext arg0) {
        String var11 = (String) arg0.getArgument("name", String.class);
        DefaultServiceComponent.executeAction(OptionMode8.MODULES);
        Object[] var12 = new Object[1];
        var12[0] = var11;
        INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.config.loaded"));
        return 1;
    }

    private static int computeValue6(CommandContext arg0) {
        String var11 = (String) arg0.getArgument("name", String.class);
        DefaultServiceComponent.executeAction(OptionMode8.MODULES);
        Object[] var12 = new Object[1];
        var12[0] = var11;
        INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.config.removed"));
        return 1;
    }

    private static int computeValue7(CommandContext arg0) {
        INSTANCE.executeAction((class_124.field_1061 + "cfg <load/remove/save> <id> / cfg list"));
        return 1;
    }

    static {
        INSTANCE = new CfgDispatcherServiceComponentImpl();
    }

}
