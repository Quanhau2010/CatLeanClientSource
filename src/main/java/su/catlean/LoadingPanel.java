package su.catlean;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Optional;
import javax.swing.JPanel;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;

public class LoadingPanel extends JPanel {

    public static final LoadingPanel INSTANCE;
    private static final ModContainer modContainer;
    private static final int countValue;
    private static final int countValue2;

    private LoadingPanel() {
        super();
    }

    public ModContainer getModContainer() {
        return modContainer;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    protected void paintComponent(Graphics g) {
        this.paintComponent(g);
        Graphics2D var4 = (Graphics2D) g;
        var4.setColor(Color.GREEN);
        var4.setFont(new Font("Monospaced", 1, 12));
        var4.drawString("  /$$$$$$              /$$     /$$                                    ", 10, 20);
        var4.drawString(" /$$__  $$            | $$    | $$                                    \n", 10, 30);
        var4.drawString("| $$  \\__/  /$$$$$$  /$$$$$$  | $$        /$$$$$$   /$$$$$$  /$$$$$$$ \n", 10, 40);
        var4.drawString("| $$       |____  $$|_  $$_/  | $$       /$$__  $$ |____  $$| $$__  $$\n", 10, 50);
        var4.drawString("| $$        /$$$$$$$  | $$    | $$      | $$$$$$$$  /$$$$$$$| $$  \\ $$\n", 10, 60);
        var4.drawString("| $$    $$ /$$__  $$  | $$ /$$| $$      | $$_____/ /$$__  $$| $$  | $$\n", 10, 70);
        var4.drawString("|  $$$$$$/|  $$$$$$$  |  $$$$/| $$$$$$$$|  $$$$$$$|  $$$$$$$| $$  | $$\n", 10, 80);
        var4.drawString(" \\______/  \\_______/   \\___/  |________/ \\_______/ \\_______/|__/  |__/\n", 10, 90);
        int var5 = 250;
        int var6 = 110;
        var4.drawString((modContainer.getMetadata().getVersion()), 10, 110);
        var4.drawString(("Welcome back, " + System.getProperty("user.name") + "! =^.^="), 10, 210);
        if ((System.currentTimeMillis() % 1000) > timestampValue) {
            var4.drawString("                                   \n");
            var4.drawString("                                    \n", (var6 + 10));
            var4.drawString("                    @@@@@           \n", (var6 + 20));
            var4.drawString("                   @@@@@@@          \n", (var6 + 30));
            var4.drawString("                 @@@@@@@@           \n", (var6 + 40));
            var4.drawString("                @@@@@@@@@@          \n", (var6 + 50));
            var4.drawString("               @@@@@@@@@@@@@        \n", (var6 + 60));
            var4.drawString("                 @@@    @@@@@@@     \n", (var6 + 70));
            var4.drawString("                          @@@@@@@   \n", (var6 + 80));
            var4.drawString("                             @@@    \n", (var6 + 90));
            var4.drawString("                                    \n", (var6 + 100));
            var4.drawString("            @@@@@@@@@@@@@@@@@@@     \n", (var6 + 110));
            var4.drawString("      @@@@@@@%@%%%%%@@@@@@@         \n", (var6 + 120));
            var4.drawString("         %@@@@@@@@%@@@@=            \n", (var6 + 130));
            var4.drawString("              @@@@@@@@              \n", (var6 + 140));
            var4.drawString("               @@@@@@               \n", (var6 + 150));
            var4.drawString("               @@@@@@               \n", (var6 + 160));
            var4.drawString("              @@@@@@@@              \n", (var6 + 170));
            var4.drawString("           .@@@@-  @@@@@            ", (var6 + 180));
        } else {
            var4.drawString("                                    \n");
            var4.drawString("                                    \n", (var6 + 10));
            var4.drawString("                                    \n", (var6 + 20));
            var4.drawString("                                    \n", (var6 + 30));
            var4.drawString("                                    \n", (var6 + 40));
            var4.drawString("                  @@@@%             \n", (var6 + 50));
            var4.drawString("        &         @@@@@@            \n", (var6 + 60));
            var4.drawString("     %  '         @@@@@@@@@@@@@@@@  \n", (var6 + 70));
            var4.drawString("      %   .       @@@@@@@@@@@@@@@@  \n", (var6 + 80));
            var4.drawString("    %    &        @@@@@@            \n", (var6 + 90));
            var4.drawString("       %          @@@@@@            \n", (var6 + 100));
            var4.drawString("            @@@@@@@@@@@@@@@@@@@     \n", (var6 + 110));
            var4.drawString("      @@@@@@@%@%%%%%@@@@@@@         \n", (var6 + 120));
            var4.drawString("         %@@@@@@@@%@@@@=            \n", (var6 + 130));
            var4.drawString("              @@@@@@@@              \n", (var6 + 140));
            var4.drawString("               @@@@@@               \n", (var6 + 150));
            var4.drawString("               @@@@@@               \n", (var6 + 160));
            var4.drawString("              @@@@@@@@              \n", (var6 + 170));
            var4.drawString("           .@@@@-  @@@@@            ", (var6 + 180));
        }
    }

    static {
        INSTANCE = new LoadingPanel();
        modContainer = (ModContainer) FabricLoader.getInstance().getModContainer("catlean").orElseThrow();
        INSTANCE.setPreferredSize(new Dimension(510, 300));
        INSTANCE.setBackground(new Color(10, 10, 10));
    }

}
