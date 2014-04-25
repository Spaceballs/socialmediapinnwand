package SocialMedia_Data;


import java.util.Date;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.10E903FF-6500-1EBC-DEF5-09B7199BA578]
// </editor-fold> 
public class LikeImpl extends DataReference implements Like {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8858E767-5D5C-E807-0C1F-2E6D5F55A01E]
    // </editor-fold> 
    private int beitragID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B023F896-D23E-21AD-8FAF-4DA3EA0207D3]
    // </editor-fold> 
    private boolean like;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9F346565-9596-51FA-AD5A-A635411942F3]
    // </editor-fold> 
    private int nutzerID;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7CFB53F5-D920-C232-8F9A-29A12BD1521C]
    // </editor-fold> 
    public LikeImpl () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.916B3284-A731-62BC-96ED-30C92654A130]
    // </editor-fold> 
    public int getID () {
        return super.getID();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0628100C-56D2-5AA4-55EA-AD07AB380980]
    // </editor-fold> 
    public void setID (int val) {
        super.setID(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FB04B5AC-0813-1DB5-1357-1629B89D664D]
    // </editor-fold> 
    public Date getCreationDate () {
        return super.getCreationDate();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AAB82147-0B8D-A25E-5FE6-5CD95C5B7D85]
    // </editor-fold> 
    public void setCreationDate (Date val) {
        super.setCreationDate(val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1CEDDD1F-7E5F-0544-8139-963D27603812]
    // </editor-fold> 
    public int getBeitragID () {
        return beitragID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EC09937C-CAAB-C140-161B-0AE8991B4937]
    // </editor-fold> 
    public void setBeitragID (int val) {
        this.beitragID = val;
    }

    /**
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1F177342-7CA4-15C5-0BBB-A5188130DE67]
    // </editor-fold> 
    public int getID () {
        return 0;
    }
     */

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.840EB099-4650-E28D-4FBC-1362311648DE]
    // </editor-fold> 
    public boolean getLike () {
        return like;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1735E31C-F812-B729-A9EC-741E874D6456]
    // </editor-fold> 
    public void setLike (boolean val) {
        this.like = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.59BCCE90-17A4-3B37-F84E-7BE592E9ECE9]
    // </editor-fold> 
    public int getNutzerID () {
        return nutzerID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.94FDDF80-9772-FB4D-1B30-AD2A2D73E78A]
    // </editor-fold> 
    public void setNutzerID (int val) {
        this.nutzerID = val;
    }

}

