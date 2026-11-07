package su.catlean.client.services.client;

import net.minecraft.class_320;
import net.minecraft.client.MinecraftClient;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.render.esp.NameTagsModule;
import su.catlean.client.features.modules.render.esp.NameTagsSeeCatleanUsersMode;

public class AnonimServiceComponent implements Runnable {

    private final int countValue;

    public AnonimServiceComponent(int $delay) {
        this.countValue = $delay;
    }

    public void run() {
        Thread.sleep(this.countValue);
        int var13 = 0;
        if (NameTagsModule.INSTANCE.getSeeCatleanUsers() != NameTagsSeeCatleanUsersMode.OFF) {
            if (NameTagsModule.INSTANCE.getSeeCatleanUsers() == NameTagsSeeCatleanUsersMode.INSTANCE) {
            } else {
            }
            ContentTypeServiceComponent.resolveString((SharedKt.getMc().method_1548().method_1676() + "1f")).executeAction(("anonim_" + ContentTypeServiceComponent.getNumericValue()));
        }
    }

}
