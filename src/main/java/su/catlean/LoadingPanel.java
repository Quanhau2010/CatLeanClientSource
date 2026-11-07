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
        Graphics2D g2d = ((Graphics2D) g);
        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("Monospaced", 1, 12));
        g2d.drawString("  /$$$$$$              /$$     /$$                                    ", 10, 20);
        g2d.drawString(" /$$__  $$            | $$    | $$                                    \n", 10, 30);
        g2d.drawString("| $$  \\__/  /$$$$$$  /$$$$$$  | $$        /$$$$$$   /$$$$$$  /$$$$$$$ \n", 10, 40);
        g2d.drawString("| $$       |____  $$|_  $$_/  | $$       /$$__  $$ |____  $$| $$__  $$\n", 10, 50);
        g2d.drawString("| $$        /$$$$$$$  | $$    | $$      | $$$$$$$$  /$$$$$$$| $$  \\ $$\n", 10, 60);
        g2d.drawString("| $$    $$ /$$__  $$  | $$ /$$| $$      | $$_____/ /$$__  $$| $$  | $$\n", 10, 70);
        g2d.drawString("|  $$$$$$/|  $$$$$$$  |  $$$$/| $$$$$$$$|  $$$$$$$|  $$$$$$$| $$  | $$\n", 10, 80);
        g2d.drawString(" \\______/  \\_______/   \\___/  |________/ \\_______/ \\_______/|__/  |__/\n", 10, 90);
        int index = 250;
        int index2 = 110;
        g2d.drawString((modContainer.getMetadata().getVersion()), 10, 110);
        g2d.drawString(("Welcome back, " + System.getProperty("user.name") + "! =^.^="), 10, 210);
        if ((System.currentTimeMillis() % 1000) > timestampValue) {
            g2d.drawString("                                   \n", index, index2);
            g2d.drawString("                                    \n", index, (index2 + 10));
            g2d.drawString("                    @@@@@           \n", index, (index2 + 20));
            g2d.drawString("                   @@@@@@@          \n", index, (index2 + 30));
            g2d.drawString("                 @@@@@@@@           \n", index, (index2 + 40));
            g2d.drawString("                @@@@@@@@@@          \n", index, (index2 + 50));
            g2d.drawString("               @@@@@@@@@@@@@        \n", index, (index2 + 60));
            g2d.drawString("                 @@@    @@@@@@@     \n", index, (index2 + 70));
            g2d.drawString("                          @@@@@@@   \n", index, (index2 + 80));
            g2d.drawString("                             @@@    \n", index, (index2 + 90));
            g2d.drawString("                                    \n", index, (index2 + 100));
            g2d.drawString("            @@@@@@@@@@@@@@@@@@@     \n", index, (index2 + 110));
            g2d.drawString("      @@@@@@@%@%%%%%@@@@@@@         \n", index, (index2 + 120));
            g2d.drawString("         %@@@@@@@@%@@@@=            \n", index, (index2 + 130));
            g2d.drawString("              @@@@@@@@              \n", index, (index2 + 140));
            g2d.drawString("               @@@@@@               \n", index, (index2 + 150));
            g2d.drawString("               @@@@@@               \n", index, (index2 + 160));
            g2d.drawString("              @@@@@@@@              \n", index, (index2 + 170));
            g2d.drawString("           .@@@@-  @@@@@            ", index, (index2 + 180));
        } else {
            g2d.drawString("                                    \n", index, index2);
            g2d.drawString("                                    \n", index, (index2 + 10));
            g2d.drawString("                                    \n", index, (index2 + 20));
            g2d.drawString("                                    \n", index, (index2 + 30));
            g2d.drawString("                                    \n", index, (index2 + 40));
            g2d.drawString("                  @@@@%             \n", index, (index2 + 50));
            g2d.drawString("        &         @@@@@@            \n", index, (index2 + 60));
            g2d.drawString("     %  '         @@@@@@@@@@@@@@@@  \n", index, (index2 + 70));
            g2d.drawString("      %   .       @@@@@@@@@@@@@@@@  \n", index, (index2 + 80));
            g2d.drawString("    %    &        @@@@@@            \n", index, (index2 + 90));
            g2d.drawString("       %          @@@@@@            \n", index, (index2 + 100));
            g2d.drawString("            @@@@@@@@@@@@@@@@@@@     \n", index, (index2 + 110));
            g2d.drawString("      @@@@@@@%@%%%%%@@@@@@@         \n", index, (index2 + 120));
            g2d.drawString("         %@@@@@@@@%@@@@=            \n", index, (index2 + 130));
            g2d.drawString("              @@@@@@@@              \n", index, (index2 + 140));
            g2d.drawString("               @@@@@@               \n", index, (index2 + 150));
            g2d.drawString("               @@@@@@               \n", index, (index2 + 160));
            g2d.drawString("              @@@@@@@@              \n", index, (index2 + 170));
            g2d.drawString("           .@@@@-  @@@@@            ", index, (index2 + 180));
        }
    }

    static {
        INSTANCE = new LoadingPanel();
        modContainer = ((ModContainer) FabricLoader.getInstance().getModContainer("catlean").orElseThrow());
        INSTANCE.setPreferredSize(new Dimension(510, 300));
        INSTANCE.setBackground(new Color(10, 10, 10));
    }

}
