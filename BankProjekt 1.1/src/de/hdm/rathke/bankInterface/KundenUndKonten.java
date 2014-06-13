/*
 * Created on 11.12.2004
 *
 */
package de.hdm.rathke.bankInterface;

import java.awt.Component;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import de.hdm.thies.bankProjekt.data.Account;
import de.hdm.thies.bankProjekt.data.Customer;

/**
 * Struktur und Darstellung aller bekannten Kunden und Konten als Baum.
 * In einer realistischen Anwendung müsste dafür Sorge getragen werden, dass nicht auf alle (!)
 * Datensätze zugegriffen wird. Denkbar wäre z.B. das Einziehen einer weiteren Ebene in die Baumstruktur,
 * die alle Kunden nach Anfangsbuchstaben auflistet. Dann würden die Datensätze erst bemüht, wenn
 * die entsprechende Unterstruktur des Baumes sichtbar gemacht wird.
 * @author Christian Rathke
 */

public class KundenUndKonten {

    private DefaultMutableTreeNode rootNode;
    private TreeModel treeModel;
    private JTree tree;
    
    /**
     * Erzeugen des Kunden-und-Konten-Baumes.
     * @param bi
     * @return
     */
   Component generateComponents(BankInterface bi){
       tree = new JTree();
       tree.setRootVisible(false);
       tree.setShowsRootHandles(true);
       
       tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
       tree.addTreeSelectionListener(bi);
       
       JScrollPane treeView = new JScrollPane(tree);
       treeView.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
       
       return treeView;
    }
   
   /**
    * Aktualisieren der Baumstruktur mit einem <code>Vector<code> aus Kunden und Konten und
    * Erzeugen des zugehörenden <code>TreeModel>s.
    * @param customersAndAccounts
    */
   void update(Vector customersAndAccounts) {
       createNodes(customersAndAccounts);
       treeModel = new DefaultTreeModel(rootNode);
       tree.setModel(treeModel);
       // Neuberechnung des tree nach Umsetzen des Modells.
       tree.revalidate();

   }
   
   /**
    * Erzeugen der Knotenstruktur des Kunden-und-Konten-Baumes.
    * Das Argument enthält eine <code>Vector<code> bestehend aus Teilvektoren. Jeder Teilvektor
    * besteht aus einem Kundenobjekt gefolgt von seinen Kontoobjekten.
    * @param customersAndAccounts
    */
    void createNodes(Vector customersAndAccounts){
        rootNode = new DefaultMutableTreeNode();
        DefaultMutableTreeNode customerNode = null;
        DefaultMutableTreeNode accountNode = null;
        Vector accounts;
        for (int i = 0; i < customersAndAccounts.size(); i++){
            accounts = (Vector)customersAndAccounts.elementAt(i);
            customerNode =
                new DefaultMutableTreeNode(
                        new CustomerInfo((Customer)accounts.elementAt(0)));
            rootNode.add(customerNode);
            for (int j = 1; j < accounts.size(); j++){
                accountNode = 
                    new DefaultMutableTreeNode(new AccountInfo((Account)accounts.elementAt(j)));
                customerNode.add(accountNode);
            }
            
        }
    }
    
    /**
     * Ergibt den im Baum zuletzt selektierten Knoten.
     * @return
     */
    DefaultMutableTreeNode getLastSelectedPathComponent() {
        return (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
    }
   
    /**
     * Hinzufügen eines Kundenknotens direkt unter der Wurzel.
     * @param infoObject
     */
   void addCustomerTreeNode(CustomerInfo infoObject){
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(infoObject);
        ((DefaultTreeModel)treeModel).insertNodeInto(childNode,
                                                    rootNode,
                                                    0);
        setSelectedCustomerNode(childNode);
        tree.setSelectionPath(new TreePath(childNode.getPath()));
    }

   /**
    * Hinzufügen eines Kontenknotens unter dem aktuell selektierten Kundenknoten.
    * @param infoObject
    */
    void addAccountTreeNode(AccountInfo infoObject){
        if (selectedCustomerNode != null){
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(infoObject);
            ((DefaultTreeModel)treeModel).insertNodeInto(childNode,
                    selectedCustomerNode,
                    selectedCustomerNode.getChildCount());
            setSelectedAccountNode(childNode);
            tree.setSelectionPath(new TreePath(childNode.getPath()));
        }
    }
    
    /**
     * Ersetzen des <code>UserObject<code> für den aktuell selektierten Kundenknoten nach einer
     * Modifikation des Kundennamens.
     * @param c
     */
    void modifyCustomerTreeNode(Customer c){
        if (selectedCustomerNode != null) {
            Object infoObject = selectedCustomerNode.getUserObject();
            if ((infoObject instanceof CustomerInfo) 
                    && ((CustomerInfo)infoObject).getCustomer().equals(c)) {
                selectedCustomerNode.setUserObject(new CustomerInfo(c));
                ((DefaultTreeModel)treeModel).nodeChanged(selectedCustomerNode);
            }
        }
    }
    
    /**
     * Entfernen eines Kundenknotes nach Löschen des Kunden.
     * @param c
     */
    void removeCustomerTreeNode(Customer c){
        if (selectedCustomerNode != null) {
            Object infoObject = selectedCustomerNode.getUserObject();
            if ((infoObject instanceof CustomerInfo)  
                    && ((CustomerInfo)infoObject).getCustomer().equals(c)) {
                ((DefaultTreeModel)treeModel).removeNodeFromParent(selectedCustomerNode);
                setSelectedCustomerNode(null);
            }
        }
    }

    /**
     * Entfernen eines Kontoknotens nach Löschen des Kontos.
     * @param a
     */
    void removeAccountTreeNode(Account a){
        if (selectedAccountNode != null) {
            Object infoObject = selectedAccountNode.getUserObject();
            if ((infoObject instanceof AccountInfo) 
                    && ((AccountInfo)infoObject).getAccount().equals(a)) {
                ((DefaultTreeModel)treeModel).removeNodeFromParent(selectedAccountNode);
                setSelectedAccountNode(null);
                tree.setSelectionPath(new TreePath(selectedCustomerNode.getPath()));
            }
        }
    }
    


    /**
     * Selektieren eins Kundenknotens für einen gefundenen Kunden.
     * Die Methode vergleicht die Kunden-Ids miteinander, um den richtigen Baumknoten
     * aufzufinden.
     * @param c
     */
    void selectCustomerTreeNode(Customer c){
        Enumeration enumer = rootNode.children();
        DefaultMutableTreeNode node = null;
        while (enumer.hasMoreElements()){
            node = (DefaultMutableTreeNode)enumer.nextElement();
            CustomerInfo ci = (CustomerInfo)node.getUserObject();
            try {
                System.out.println(c.hashCode() + " " + ci.getCustomer().hashCode());
                boolean isEqual = (ci.getCustomer().getId() == c.getId());
                if (isEqual){
                    setSelectedCustomerNode(node);
                    tree.setSelectionPath(new TreePath(node.getPath()));
                    setSelectedAccountNode(null);
                    return; 
                }
            } catch  (RemoteException re) {
                System.out.println("RemoteException");
                System.out.println(re);
            }
        }
    }

    /**
     * @uml.property  name="selectedCustomerNode"
     */
    private DefaultMutableTreeNode selectedCustomerNode;

    /**
     * Setter of the property <tt>selectedCustomerNode</tt>
     * @param selectedCustomerNode  The selectedCustomerNode to set.
     * @uml.property  name="selectedCustomerNode"
     */
    void setSelectedCustomerNode(DefaultMutableTreeNode selectedCustomerNode) {
        this.selectedCustomerNode = selectedCustomerNode;
    }

    /**
     * @uml.property  name="selectedAccountNode"
     */
    private DefaultMutableTreeNode selectedAccountNode;

    /**
     * Setter of the property <tt>selectedAccountNode</tt>
     * @param selectedAccountNode  The selectedAccountNode to set.
     * @uml.property  name="selectedAccountNode"
     */
    void setSelectedAccountNode(DefaultMutableTreeNode selectedAccountNode) {
        this.selectedAccountNode = selectedAccountNode;
    }

}
