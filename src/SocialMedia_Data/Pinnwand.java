package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
import java.util.Vector;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.A573FCE8-0C7C-85E2-81F5-BD4F7AE55AF6]
// </editor-fold> 
public interface Pinnwand extends DataReference{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9A113161-9549-A226-EBD6-6C10C1599BB1]
    // </editor-fold> 
    public int getNutzerID ()
            throws RemoteException;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B638B2FD-144C-3974-C959-2CE811B56263]
    // </editor-fold> 
    public void setNutzerID (int val)
            throws RemoteException;

    public Vector<Beitrag> getAllPinnwandBeitraege (SocialMediaLogicImpl verwaltung)
            throws RemoteException;

    public Nutzer getOwner (SocialMediaLogicImpl verwaltung)
            throws RemoteException;

}

