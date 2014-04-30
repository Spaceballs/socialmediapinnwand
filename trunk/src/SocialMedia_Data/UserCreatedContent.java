/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Data;

import java.util.Date;

/**
 *
 * @author Sebastian
 */
public interface UserCreatedContent extends DataReference{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.3FFF7CC0-A385-C9AB-FC0F-D5E595FE08FD]
    // </editor-fold>
    Date getCreationDate();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.CB563634-1841-4105-4579-E5B5A00B379F]
    // </editor-fold>
    int getID();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.09AA971C-CC81-7A33-68D2-9D93A9D48B66]
    // </editor-fold>
    int getNutzerID();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.0A75001D-1A8F-9B66-7C7A-A84D8D309A09]
    // </editor-fold>
    String getText();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.61ADF81F-39BD-E018-FAC8-8F23B5B49FD4]
    // </editor-fold>
    void setCreationDate(Date val);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.835D5887-E4CA-D7BE-1D7E-883FD1B8AF11]
    // </editor-fold>
    void setID(int val);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.4C3FF8B3-5DDD-8FA9-21F4-D9B3320848A8]
    // </editor-fold>
    void setNutzerID(int val);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.3084509D-FA6D-C60E-74B5-268CF2D5817F]
    // </editor-fold>
    void setText(String val);
    
}
