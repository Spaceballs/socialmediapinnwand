
package SocialMedia_Gui;

/**
 *
 * @author Max
 */
public class Main {


    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(
            new Runnable() {
                public void run() {
        createAndShowGUI();
                }
        }
    );
}

    public static void createAndShowGUI() {
        new DialogRegistrieren();
    }

}
