package su.catlean.client.services.client;

import java.util.Locale;
import net.minecraft.class_124;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.misc.TranslatorModule;
import su.catlean.client.features.modules.utility.misc.TranslatorUrLangMode;

public class ServiceComponent116 implements Runnable {

    private final int countValue;
    private final String textValue;

    public ServiceComponent116(int arg0, String arg1) {
        this.countValue = arg0;
        this.textValue = arg1;
    }

    public void run() {
        Thread.sleep(this.countValue);
        int var10 = 0;
        MessageServiceComponent.S((Module) TranslatorModule.INSTANCE, (class_124.field_1068 + TranslatorModule.resolveString(this.textValue, TranslatorModule.resolveTranslatorUrLangMode().name().toLowerCase(Locale.ROOT))));
        var11.printStackTrace();
    }

}
