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
        String text = TranslatorModule.resolveString(this.minecraftRef.comp_945(), TranslatorModule.resolveTranslatorUrLangMode().name().toLowerCase(Locale.ROOT));
        if (__UNDEF_KEY__ == null) {
            if (Objects.equals(this.minecraftRef.comp_945(), text)) {
                TranslatorModule.updateValue(this.minecraftRef.comp_945());
                MessageServiceComponent.executeAction(((Module) TranslatorModule.INSTANCE), this.minecraftRef.comp_945(), true);
                if (__UNDEF_KEY__ != null) {
                    TranslatorModule.updateValue(text);
                    MessageServiceComponent.executeAction(((Module) TranslatorModule.INSTANCE), text, true);
                    text.printStackTrace();
                }
            }
        }
    }

}
