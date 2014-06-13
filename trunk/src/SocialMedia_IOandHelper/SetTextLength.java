
package SocialMedia_IOandHelper;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * @todo Kommentierung
 * @author Max
 */
public class SetTextLength extends PlainDocument {
    private final int limit;
  
  public SetTextLength(int limit) {
   super();
   this.limit = limit;
   }
  
    @Override
  public void insertString
    (int offset, String  str, AttributeSet attr)
      throws BadLocationException {
   if (str == null) return;

   if ((getLength() + str.length()) <= limit) {
     super.insertString(offset, str, attr);
     }
   }
}
