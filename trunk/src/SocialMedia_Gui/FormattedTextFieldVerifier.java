/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Gui;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

/**
 * Class for controlling the correct user input.
 * @author Sebastian
 */
class FormattedTextFieldVerifier extends InputVerifier {
    
    /**
     * 
     * @param input
     * @return 
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
      * 
      * @param input
      * @return 
      */
     @Override
      public boolean shouldYieldFocus(JComponent input) {
          return verify(input);
      }
  }






