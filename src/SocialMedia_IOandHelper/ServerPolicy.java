/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_IOandHelper;

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
public class ServerPolicy extends Policy {

    private static PermissionCollection perms;


    
    
    public ServerPolicy() {
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
        RuntimePermission rtp0 = new RuntimePermission("setSecurityManager");
        RuntimePermission rtp1 = new RuntimePermission("createSecurityManager");
        RuntimePermission rtp2 = new RuntimePermission("usePolicy");
        RuntimePermission rtp3 = new RuntimePermission("accessClassInPackage.com.mysql.jdbc.Driver");
        PropertyPermission propertyPermission0 = new PropertyPermission("line.separator", "read");
        FilePermission fp = new  FilePermission("<<ALL FILES>>", "execute");
        PropertyPermission pp = new PropertyPermission("java.rmi.registry.hostname", "read");
        SocketPermission sp = new SocketPermission("*:1024-", "accept, connect, resolve");
        SocketPermission sp0 = new SocketPermission("*:1521-", "connect, resolve");
        
        perms.add(propertyPermission0);
        perms.add(fp);
        perms.add(pp);
        perms.add(sp);
        perms.add(sp0);
        perms.add(rtp0);
        perms.add(rtp1);
        perms.add(rtp2);
        perms.add(rtp3);
    }

}