/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Report;

import java.util.Vector;

/**
 *
 * @author Sebastian
 */
public interface Column {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.EE824E0A-E1CC-A136-A270-3296FD5B60B2]
    // </editor-fold>
    Vector<String> getText();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,regenBody=yes,id=DCE.EA1C9E86-F80C-78AB-903D-A40831A430D8]
    // </editor-fold>
    void setText(String val);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.2FD23B39-7046-715C-3BA7-7FC20E86B691]
    // </editor-fold>
    String toString();
    
}
