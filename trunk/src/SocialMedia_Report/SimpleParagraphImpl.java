package SocialMedia_Report;

import java.rmi.RemoteException;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.0BCEFED5-709C-C881-F6DE-BEC6977B5E59]
// </editor-fold> 
/**
 * @todo Kommentierung
 * @author Max
 */
public class SimpleParagraphImpl extends ParagraphImpl implements SimpleParagraph {
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F53CDAB6-019F-C91C-45C5-EC1F1804E748]
    // </editor-fold> 
    private String text = "";

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5E408F32-89DC-3A7C-71A4-820980F3252C]
    // </editor-fold>
    /*
     * @throws java.rmi.RemoteException
     */
    public SimpleParagraphImpl (String val) 
            throws RemoteException{
        super();
        this.text = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.ABD5A780-991F-8EB7-9901-2929A1CBA75D]
    // </editor-fold>
    /*
     * @throws java.rmi.RemoteException
     */
    @Override
    public String getText () 
            throws RemoteException{
        return text;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D0033BDC-E2EA-54A4-4419-6C910255DDE4]
    // </editor-fold>
    /*
     * @throws java.rmi.RemoteException
     */
    @Override
    public void setText (String val) 
            throws RemoteException{
        this.text = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.193B4D3C-F228-B112-FBD8-4CE55F239E30]
    // </editor-fold>
    /*
     * @throws java.rmi.RemoteException
     */
    public String toStrings () 
            throws RemoteException{
        StringBuilder buffer = new StringBuilder();
        buffer.append(text);   
        return buffer.toString();
    }
}

