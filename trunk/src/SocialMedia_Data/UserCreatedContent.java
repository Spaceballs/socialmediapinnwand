/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Data;

/**
 *
 * @author Sebastian
 */
public interface UserCreatedContent extends DataReference{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.09AA971C-CC81-7A33-68D2-9D93A9D48B66]
    // </editor-fold>
    /**
     * 
     * @return 
     */
    int getNutzerID();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.0A75001D-1A8F-9B66-7C7A-A84D8D309A09]
    // </editor-fold>
    /**
     * 
     * @return 
     */
    String getText();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.4C3FF8B3-5DDD-8FA9-21F4-D9B3320848A8]
    // </editor-fold>
    /**
     * 
     * @param val 
     */
    void setNutzerID(int val);
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.3084509D-FA6D-C60E-74B5-268CF2D5817F]
    // </editor-fold>
    /**
     * 
     * @param val 
     */
    void setText(String val);
    
}
