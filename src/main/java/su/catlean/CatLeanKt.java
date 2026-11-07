package su.catlean;

import java.util.Optional;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

public class CatLeanKt {

    public static final String textValue;
    private static final ModContainer modContainer;

    public static ModContainer getModContainer() {
        return modContainer;
    }

    static {
        textValue = "catlean";
        modContainer = (ModContainer) FabricLoader.getInstance().getModContainer("catlean").orElseThrow();
    }

}
