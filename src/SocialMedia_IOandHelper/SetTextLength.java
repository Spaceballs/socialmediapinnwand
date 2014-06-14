
package SocialMedia_IOandHelper;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Class for setting the maximum lengt of a Document
 * @author Max
 */
public class SetTextLength extends PlainDocument {
    private final int limit;
    /**
     * Constructor of the class calls the super class constructor
     * @param limit - max text lenth
     */
    public SetTextLength(int limit) {
        super();
        this.limit = limit;
    }

    /**
     * Insert Method to set the text of the document
     * 
     * @param offset the starting offset &gt;= 0
     * @param str the string to insert; does nothing with null/empty strings
     * @param attr the attributes for the inserted content 
     * @throws BadLocationException the given insert position is not a valid position within the document
     */
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
