package SocialMedia_Data;

//import SocialMedia_DatabaseManager.Vector<Abonnement>;
import java.util.Date;
        import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3553D03C-6305-B201-4A1B-DB2554E72E8D]
// </editor-fold> 
public class NutzerImpl extends DataReference implements Nutzer {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0D00499F-FD8A-E51C-CC84-E75EC702091C]
    // </editor-fold> 
    private String username;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F324CF40-9CE2-1008-7E23-442A7AC7DC0F]
    // </editor-fold> 
    private String name;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A66A1AC2-3399-75A7-8CB1-3B3B2FF2BE4F]
    // </editor-fold> 
    private String surname;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F5A4A879-CE9B-DC68-BABB-0063578D48C7]
    // </editor-fold> 
    private String password;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.98F2AE72-D7D0-D7AC-4E04-53CF14F84A72]
    // </editor-fold> 
    public NutzerImpl () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.567D7DB3-BF90-870F-C713-BCCF4C636E5A]
    // </editor-fold> 
    public String getName () {
        return name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E6DC5A45-7CF6-3E7C-3DAF-119DA22511B2]
    // </editor-fold> 
    public void setName (String val) {
        this.name = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D1992486-44F1-AA40-E8AD-2FB13793AC9E]
    // </editor-fold> 
    public String getPassword () {
        return password;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.08A7888A-8EAF-5D9A-562D-0D2EA0E99350]
    // </editor-fold> 
    public void setPassword (String val) {
        this.password = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A9A9B425-7C26-9DB0-4914-F2F4B9DFEC88]
    // </editor-fold> 
    public String getSurname () {
        return surname;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1F77A8CC-9095-B7EC-BA42-1992AF559AC2]
    // </editor-fold> 
    public void setSurname (String val) {
        this.surname = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.97AE0FAE-FB1C-C535-4F41-C0409F1F0C2F]
    // </editor-fold> 
    public String getUsername () {
        return username;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9C720026-A954-59B5-8742-41752CAF391E]
    // </editor-fold> 
    public void setUsername (String val) {
        this.username = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DB086FF5-415F-77FF-4654-276E885DBAAB]
    // </editor-fold> 
    public int getID () {
        return 0;
    }
/**
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2D5533DE-3888-DE18-7A6E-70C1F4DB8220]
    // </editor-fold> 
    public void setID (int val) {
    }
 */

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.533A23D6-473F-672C-342E-35A42BB259DB]
    // </editor-fold> 
    public Date getCreationDate () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C83F59FD-2047-7AB3-C249-FFFCC8DEE9F7]
    // </editor-fold> 
    public void setCreationDate (Date val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.73B6C5E7-4078-D778-0BF9-9745651A4CBE]
    // </editor-fold> 
    public void setID (int val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EA9F8A85-2059-4E68-72FA-B23705639051]
    // </editor-fold> 
    public Pinnwand getNutzerPinnwand () {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E49402FD-5DC6-2D8C-7CB5-633CA9E8C37B]
    // </editor-fold> 
    public Vector<Abonnement> getAllNutzerAbonnement () {
        return null;
    }

}

