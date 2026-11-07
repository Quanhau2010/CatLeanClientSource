package su.catlean;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.apache.commons.lang3.SystemUtils;

public class PreLaunch implements PreLaunchEntrypoint {

    public static final PreLaunch INSTANCE;
    private static JFrame jFrame;

    private PreLaunch() {
    }

    public void executeAction() {
        if (jFrame != null) {
            jFrame.setVisible(0);
        } else {
        }
    }

    public void onPreLaunch() {
        if (!(SystemUtils.IS_OS_WINDOWS)) {
            return;
        }
        SwingUtilities.invokeLater(this::executeAction2);
    }

    private static void updateValue(ActionEvent arg0) {
        if (jFrame != null) {
        } else {
        }
        if (jFrame != null) {
            jFrame.repaint();
        } else {
        }
    }

    private static void executeAction2() {
        JFrame var2 = new JFrame("CatLean");
        Object var3 = var2;
        int var4 = 0;
        var3.setDefaultCloseOperation(2);
        var3.getContentPane().add((Component) LoadingPanel.INSTANCE);
        var3.pack();
        var3.setVisible(1);
        var3.setResizable(0);
        var3.setLayout((LayoutManager) new GridLayout());
        var3.setLocationRelativeTo(null);
        jFrame = var2;
        var2 = new Timer(-2277639625428172700L, this::updateValue);
        var3 = var2;
        var4 = 0;
        var3.setRepeats(1);
        var3.start();
    }

    static {
        INSTANCE = new PreLaunch();
    }

}
