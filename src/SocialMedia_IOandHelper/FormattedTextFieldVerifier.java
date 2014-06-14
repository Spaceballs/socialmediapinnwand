
package SocialMedia_IOandHelper;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

/**
 * Class for controlling the correct user input for the date format.
 * @author Sebastian
 */
public class FormattedTextFieldVerifier extends InputVerifier {
    
    /**
     * Verifyer method for the formatted text field.
     * 
     * @param input - JComponent where the user input occurs.
     * @return true - When string is a date/ false - When it is not.
     */
     public boolean verify(JComponent input) {
         if (input instanceof JFormattedTextField) {
             JFormattedTextField ftf = (JFormattedTextField)input;
             JFormattedTextField.AbstractFormatter formatter = ftf.getFormatter();
             if (formatter != null) {
                 String text = ftf.getText();
                 try {
                      formatter.stringToValue(text);
                      return true;
                  } catch (ParseException pe) {
                      Logger.getLogger(FormattedTextFieldVerifier.class.getName()).log(Level.SEVERE, null, pe);
                      return false;
                  }
              }
          }
          return true;
      }
     
     /**
      * Method to check the user input when the JComponent loses focus
      * @param input - JComponent with the verifier.
      * @return true - When string is a date/ false - When it is not.
      */
     @Override
      public boolean shouldYieldFocus(JComponent input) {
          return verify(input);
      }
  }






