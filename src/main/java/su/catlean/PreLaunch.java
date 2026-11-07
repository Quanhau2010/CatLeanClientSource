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
            jFrame.setVisible(false);
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
        JFrame frame = new JFrame("CatLean");
        JFrame frame2 = frame;
        frame2.setDefaultCloseOperation(2);
        frame2.getContentPane().add(((Component) LoadingPanel.INSTANCE));
        frame2.pack();
        frame2.setVisible(true);
        frame2.setResizable(false);
        frame2.setLayout(((LayoutManager) new GridLayout()));
        frame2.setLocationRelativeTo(null);
        jFrame = frame;
        frame = new Timer(100, this::updateValue);
        frame2 = frame;
        frame2.setRepeats(true);
        frame2.start();
    }

    static {
        INSTANCE = new PreLaunch();
    }

}
