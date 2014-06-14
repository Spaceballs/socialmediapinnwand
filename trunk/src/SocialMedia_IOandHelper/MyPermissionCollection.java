/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_IOandHelper;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Class to store and make security permissions avaliable
 * @author Sebastian
 */
class MyPermissionCollection extends PermissionCollection {

    /**
     * ArrayList for storeing the permissions
     */
    ArrayList<Permission> perms = new ArrayList<Permission>();

    /**
     * Adder method for the permissions array
     * @param p - Permission to add
     */
    public void add(Permission p) {
        perms.add(p);
    }

    /**
     * Method to ask for a specific Permission in the array list.
     * @param p - Permission to ask for.
     * @return true - if implied/ false - if not
     */
    public boolean implies(Permission p) {
        for (Iterator<Permission> i = perms.iterator(); i.hasNext();) {
            if (((Permission) i.next()).implies(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method for getting a type enumeration of the permissions array list
     * @return An enumeration of the permissions in the array list.
     */
    public Enumeration<Permission> elements() {
        return Collections.enumeration(perms);
    }
    /**
     * Method for checking if the array list of permissions is read only.
     * @return false
     */
    @Override
    public boolean isReadOnly() {
        return false;
    }
}
