package SocialMedia_Data;
// #[regen=yes,id=DCE.10E903FF-6500-1EBC-DEF5-09B7199BA578]
// </editor-fold> 
public class LikeImpl extends DataReferenceImpl implements Like {

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
    /**
     * 
     */
    public LikeImpl () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1CEDDD1F-7E5F-0544-8139-963D27603812]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public int getBeitragID () {
        return beitragID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EC09937C-CAAB-C140-161B-0AE8991B4937]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setBeitragID (int val) {
        this.beitragID = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.840EB099-4650-E28D-4FBC-1362311648DE]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public boolean getLike () {
        return like;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1735E31C-F812-B729-A9EC-741E874D6456]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setLike (boolean val) {
        this.like = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.59BCCE90-17A4-3B37-F84E-7BE592E9ECE9]
    // </editor-fold> 
    /**
     * 
     * @return 
     */
    public int getNutzerID () {
        return nutzerID;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.94FDDF80-9772-FB4D-1B30-AD2A2D73E78A]
    // </editor-fold> 
    /**
     * 
     * @param val 
     */
    public void setNutzerID (int val) {
        this.nutzerID = val;
    }

}

