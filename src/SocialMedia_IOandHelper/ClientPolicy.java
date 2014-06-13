/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_IOandHelper;

import java.awt.AWTPermission;
import java.io.FilePermission;
import java.net.SocketPermission;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Policy;
import java.util.PropertyPermission;

/**
 * @todo Kommentierung
 * @author Sebastian
 */
public class ClientPolicy extends Policy {

    private static PermissionCollection perms;

    public ClientPolicy() {
        super();
        if (perms == null) {
            perms = new MyPermissionCollection();
            addPermissions();
        }
    }

    @Override
    public PermissionCollection getPermissions(CodeSource codesource) {
        return perms;
    }

    private void addPermissions() {
        SocketPermission socketPermission = new SocketPermission("*:1024-", "connect, resolve");
        PropertyPermission propertyPermission = new PropertyPermission("<<ALL FILES>>", "read, write");
        PropertyPermission propertyPermission0 = new PropertyPermission("line.separator", "read");
        FilePermission filePermission = new FilePermission("<<ALL FILES>>", "read, write, execute");
        AWTPermission aWTPermission = new AWTPermission("showWindowWithoutWarningBanner");
        
        perms.add(aWTPermission);
        perms.add(socketPermission);
        perms.add(propertyPermission);
        perms.add(filePermission);
    }

}