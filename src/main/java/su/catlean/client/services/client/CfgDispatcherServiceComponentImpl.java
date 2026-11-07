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
        builder.then(this.resolveLiteralArgumentBuilder("list").executes(this::computeValue));
        builder.then(this.resolveLiteralArgumentBuilder("folder").executes(this::computeValue2));
        builder.then(this.resolveLiteralArgumentBuilder("reset").executes(this::computeValue3));
        builder.then(this.resolveLiteralArgumentBuilder("save").then(this.resolveRequiredArgumentBuilder("name", ((ArgumentType) StringArgumentType.word())).executes(this::computeValue4)));
        builder.then(this.resolveLiteralArgumentBuilder("load").then(this.resolveRequiredArgumentBuilder("name", ((ArgumentType) ReaderServiceComponent3.serviceComponent111.getReaderServiceComponent3())).executes(this::computeValue5)));
        builder.then(this.resolveLiteralArgumentBuilder("remove").then(this.resolveRequiredArgumentBuilder("name", ((ArgumentType) ReaderServiceComponent3.serviceComponent111.getReaderServiceComponent3())).executes(this::computeValue6)));
        builder.executes(this::computeValue7);
    }

    private static int computeValue(CommandContext arg0) {
        StringBuilder stringBuilder = new StringBuilder(KeyServiceComponent.INSTANCE.resolveString("commands.config.configs", new Object[0]));
        Iterator iterator = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveList().iterator();
        while (iterator.hasNext()) {
            IdRecord3 idRecord3 = ((IdRecord3) iterator.next());
            if (Intrinsics.areEqual(idRecord3, ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().resolveIdRecord3())) {
            } else {
            }
            class_124.field_1060.append(("")).append(idRecord3.getString()).append(class_124.field_1070);
        }
        INSTANCE.executeAction(stringBuilder.toString());
        return 1;
    }

    private static int computeValue2(CommandContext arg0) {
        File file = ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl2().getFile();
        class_158 class158 = class_156.method_668();
        if (!(file.exists())) {
            file.createNewFile();
        }
        class158.method_672(file);
        file.printStackTrace();
        return 1;
    }

    private static int computeValue3(CommandContext arg0) {
        Iterator iterator = EnabledServiceComponent.INSTANCE.getArrayList2().iterator();
        while (iterator.hasNext()) {
            Module module = ((Module) iterator.next());
            if (module.getEnabled()) {
                module.updateValue2();
            }
            Iterator iterator2 = module.getList().iterator();
            while (iterator2.hasNext()) {
            }
            VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) iterator2.next());
            visibleSettingProperty.setValue();
        }
        return 1;
    }

    private static int computeValue4(CommandContext arg0) {
        String text = ((String) arg0.getArgument("name", String.class));
        DefaultServiceComponent.executeAction(text, OptionMode8.MODULES);
        Object[] items = new Object[1];
        items[0] = text;
        INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.config.saved", items));
        return 1;
    }

    private static int computeValue5(CommandContext arg0) {
        String text = ((String) arg0.getArgument("name", String.class));
        DefaultServiceComponent.executeAction(text, OptionMode8.MODULES);
        Object[] items = new Object[1];
        items[0] = text;
        INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.config.loaded", items));
        return 1;
    }

    private static int computeValue6(CommandContext arg0) {
        String text = ((String) arg0.getArgument("name", String.class));
        DefaultServiceComponent.executeAction(text, OptionMode8.MODULES);
        Object[] items = new Object[1];
        items[0] = text;
        INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.config.removed", items));
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
