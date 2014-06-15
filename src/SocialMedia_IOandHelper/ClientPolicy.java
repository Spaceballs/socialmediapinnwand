
package SocialMedia_IOandHelper;

import java.awt.AWTPermission;
import java.io.FilePermission;
import java.net.SocketPermission;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Policy;
import java.util.PropertyPermission;

/**
 * Class to set the security policy rules for the client.
 * @author Sebastian
 */
public class ClientPolicy extends Policy {
    /**
     * PermissionsCollection for the client
     */
    private static PermissionCollection perms;
    
    /**
     * Constructror of the client policy class calls for the super class and creates a new permissionCollection.
     */
    public ClientPolicy() {
        super();
        if (perms == null) {
            perms = new MyPermissionCollection();
            addPermissions();
        }
    }
    
    /**
     * Permission getter for the security manager
     * @param codesource - The source of the permission invocation.
     * @return 
     */
    @Override
    public PermissionCollection getPermissions(CodeSource codesource) {
        return perms;
    }
    
    /**
     * Method for adding permission grants to the collection
     */
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
