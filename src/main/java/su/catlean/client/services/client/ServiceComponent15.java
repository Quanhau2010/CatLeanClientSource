package su.catlean.client.services.client;

import java.util.Locale;
import java.util.Objects;
import net.minecraft.class_2797;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.misc.TranslatorModule;
import su.catlean.client.features.modules.utility.misc.TranslatorUrLangMode;

public class ServiceComponent15 implements Runnable {

    private final int countValue;
    private final class_2797 minecraftRef;

    public ServiceComponent15(int arg0, class_2797 arg1) {
        this.countValue = arg0;
        this.minecraftRef = arg1;
    }

    public void run() {
        Thread.sleep(this.countValue);
        int var10 = 0;
        String var11 = TranslatorModule.resolveString(this.minecraftRef.comp_945(), TranslatorModule.resolveTranslatorUrLangMode().name().toLowerCase(Locale.ROOT));
        if (var9 == null) {
            if (Objects.equals(this.minecraftRef.comp_945())) {
                TranslatorModule.updateValue(this.minecraftRef.comp_945());
                MessageServiceComponent.executeAction((Module) TranslatorModule.INSTANCE, this.minecraftRef.comp_945(), 1);
                if (var9 != null) {
                }
            }
            TranslatorModule.updateValue();
            MessageServiceComponent.executeAction((Module) TranslatorModule.INSTANCE, 1);
            var11.printStackTrace();
        }
    }

}
