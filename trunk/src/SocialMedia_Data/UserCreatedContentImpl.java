package SocialMedia_Data;


import java.util.Date;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.8AE5A633-3062-4D82-1BEC-55C100571D26]
// </editor-fold> 
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
    public UserCreatedContentImpl () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.09AA971C-CC81-7A33-68D2-9D93A9D48B66]
    // </editor-fold> 
    @Override
    public int getNutzerID () {
        return nutzerID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4C3FF8B3-5DDD-8FA9-21F4-D9B3320848A8]
    // </editor-fold> 
    @Override
    public void setNutzerID (int val) {
        this.nutzerID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0A75001D-1A8F-9B66-7C7A-A84D8D309A09]
    // </editor-fold> 
    @Override
    public String getText () {
        return text;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3084509D-FA6D-C60E-74B5-268CF2D5817F]
    // </editor-fold> 
    @Override
    public void setText (String val) {
        this.text = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CB563634-1841-4105-4579-E5B5A00B379F]
    // </editor-fold> 
    @Override
    public int getID () {
        return super.getID();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.835D5887-E4CA-D7BE-1D7E-883FD1B8AF11]
    // </editor-fold> 
    @Override
    public void setID (int val) {
        super.setID(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3FFF7CC0-A385-C9AB-FC0F-D5E595FE08FD]
    // </editor-fold> 
    @Override
    public Date getCreationDate () {
        return super.getCreationDate();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.61ADF81F-39BD-E018-FAC8-8F23B5B49FD4]
    // </editor-fold> 
    @Override
    public void setCreationDate (Date val) {
        super.setCreationDate(val);
    }

}

