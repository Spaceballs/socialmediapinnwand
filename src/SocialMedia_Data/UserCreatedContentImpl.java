package SocialMedia_Data;

// #[regen=yes,id=DCE.8AE5A633-3062-4D82-1BEC-55C100571D26]

import java.rmi.RemoteException;

// </editor-fold> 

/**
 * 
 * @author Sebastian
 */
public class UserCreatedContentImpl extends DataReferenceImpl implements UserCreatedContent {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B5F3134E-BDA8-DEBB-2A3B-B5656E0181A0]
    // </editor-fold> 
    private String text;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C5A1F23F-1F32-02B5-6FF9-0EE98F73AB08]
    // </editor-fold> 
    private int nutzerID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FC2B9EA8-431E-EEC0-1E02-8DD9F2C5450A]
    // </editor-fold> 
    /**
     * 
     * @throws java.rmi.RemoteException
     */
    public UserCreatedContentImpl () 
            throws RemoteException{
    }

    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.09AA971C-CC81-7A33-68D2-9D93A9D48B66]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public int getNutzerID () 
            throws RemoteException{
        return nutzerID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4C3FF8B3-5DDD-8FA9-21F4-D9B3320848A8]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setNutzerID (int val) 
            throws RemoteException{
        this.nutzerID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0A75001D-1A8F-9B66-7C7A-A84D8D309A09]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public String getText () 
            throws RemoteException{
        return text;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3084509D-FA6D-C60E-74B5-268CF2D5817F]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setText (String val) 
            throws RemoteException{
        this.text = val;
    }
}

