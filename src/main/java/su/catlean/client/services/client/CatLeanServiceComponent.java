package su.catlean.client.services.client;

import java.awt.Color;
import su.catlean.client.services.client.config.models.IdRecord6;

public class CatLeanServiceComponent {

    private static IdRecord6 idRecord6;

    public static IdRecord6 getIdRecord6() {
        return idRecord6;
    }

    public static void executeAction(IdRecord6 value) {
        idRecord6 = value;
    }

    static {
        Color color = new Color(56, 56, 86, 255);
        Color color2 = new Color(127, 127, 188, 199);
        Color color3 = new Color(127, 127, 188, 60);
        Color color4 = new Color(30, 30, 40, 60);
        Color color5 = new Color(56, 244, 224);
        Color color6 = new Color(128, 128, 128);
        Color color7 = new Color(255, 255, 255);
        Color color8 = new Color(150, 150, 200);
        idRecord6 = new IdRecord6("CatLean", color8, color7, color6, color5, color4, color3, color2, color);
    }

}
