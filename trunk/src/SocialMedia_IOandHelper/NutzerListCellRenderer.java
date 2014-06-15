
package SocialMedia_IOandHelper;

import SocialMedia_Data.Nutzer;
import java.awt.Color;
import java.awt.Component;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * This class replaces the default ListCellRenderer and displays <code>val.getUsername()</code> instead of <code>val.toString()</code>.
 * @author Sebastian
 */
 public class NutzerListCellRenderer extends JLabel implements ListCellRenderer<Object> {
     
     /**
      * Constructor of the nutzer list cell renderer.
      */
     public NutzerListCellRenderer() {
         super();
         setOpaque(true);
     }
     
     /**
      * Method for viewing the right content of the nutzer object.
      * 
      * @param list - JList of the renderer.
      * @param value - Object of the jlist.
      * @param index - Index of the object in the jlist.
      * @param isSelected - Boolean value if or not the object is selected.
      * @param cellHasFocus - Boolean value if or not the object cell has focus.
      * @return Returns the renderer object.
      */
     public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
         Nutzer val = (Nutzer)value;
         try {
             setText(val.getUsername());
         } catch (RemoteException ex) {
             Logger.getLogger(NutzerListCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
         }
         Color background;
         Color foreground;
         JList.DropLocation dropLocation = list.getDropLocation();
         if (dropLocation != null
                 && !dropLocation.isInsert()
                 && dropLocation.getIndex() == index) {
             background = Color.BLUE;
             foreground = Color.WHITE;
         } else if (isSelected) {
             background = Color.RED;
             foreground = Color.WHITE;
         } else {
             background = Color.WHITE;
             foreground = Color.BLACK;
         }
         setBackground(background);
         setForeground(foreground);
         return this;
     }
}


