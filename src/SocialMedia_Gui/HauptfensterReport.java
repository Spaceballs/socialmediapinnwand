
package SocialMedia_Gui;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Max
 */
public class HauptfensterReport extends JFrame {

    public HauptfensterReport() {
        initialize();
    }

    private void initialize() {
        this.pack();

        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH); // Frame is maximized on start
        this.setMinimumSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null); // frame is at the center of the screen
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
