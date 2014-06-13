package de.hdm.thies.bankProjekt.db.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Vector;

import de.hdm.thies.bankProjekt.data.*;
import de.hdm.thies.bankProjekt.db.*;

/**
 * Testklasse, um den <code>AccountMapper</code> auf seine Funktion zu prüfen.
 * 
 * @see CustomerMapperTest
 * @author Thies
 */
public class AccountMapperTest {

  // AccountMapper instantiieren.
  private AccountMapper aMapper = AccountMapper.accountMapper();

  public AccountMapperTest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  /**
   * Methode in der ggf. vorbereitende Maßnahmen für die Testumgebung getroffen
   * werden können.
   */
  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test der findByKey-Methode
   */
  @Test
  public void testFindByKey() {
    System.out.println("\n*** testFindByKey");

    try {
      Account a = aMapper.findByKey(3);
      System.out.println("id=" + a.getId());
      Customer c = CustomerMapper.customerMapper().findByKey(a.getOwner());
      System.out.println("owner=" + c.getLastName() + ", " + c.getFirstName());
      System.out.println("balance=" + a.getBalance());

      /*
       * Wenn wir hier ankommen, dann gehen wir von einem erfolgreichen 
       * Testergebnis aus. Auf eine semantische Prüfung wird hier verzichtet.
       */
      assertTrue(true);
    }
    catch (Exception e) {
      // Im Falle einer Exception kennzeichnen wir den Test als gescheitert.
      assertTrue(false);
    }
  }

  /**
   * Test der findAll-Methode
   */
  @Test
  public void testFindAll() {
    System.out.println("\n*** testFindAll");

    try {
      Vector<Account> results = aMapper.findAll();
      for ( Account a : results ) {
        System.out.println("id=" + a.getId());
        Customer c = CustomerMapper.customerMapper().findByKey(a.getOwner());
        System.out.println("owner=" + c.getLastName() + ", " + c.getFirstName());
        System.out.println("balance=" + a.getBalance());
      }

      /*
       * Wenn wir hier ankommen, dann gehen wir von einem erfolgreichen 
       * Testergebnis aus. Auf eine semantische Prüfung wird hier verzichtet.
       */
      assertTrue(true);
    }
    catch (Exception e) {
      // Im Falle einer Exception kennzeichnen wir den Test als gescheitert.
      assertTrue(false);
    }
  }

  /**
   * Test der findByOwner(int id)-Methode
   */
  @Test
  public void testFindByOwnerKey() {
    System.out.println("\n*** testFindByOwnerKey, int");

    try {
      Vector<Account> results = aMapper.findByOwner(3);
      for ( Account a : results ) {
        System.out.println("id=" + a.getId());
        Customer c = CustomerMapper.customerMapper().findByKey(a.getOwner());
        System.out.println("owner=" + c.getLastName() + ", " + c.getFirstName());
        System.out.println("balance=" + a.getBalance());
      }

      /*
       * Wenn wir hier ankommen, dann gehen wir von einem erfolgreichen 
       * Testergebnis aus. Auf eine semantische Prüfung wird hier verzichtet.
       */
      assertTrue(true);
    }
    catch (Exception e) {
      // Im Falle einer Exception kennzeichnen wir den Test als gescheitert.
      assertTrue(false);
    }
  }

  /**
   * Test der findByOwner(Customer c)-Methode
   */
  @Test
  public void testFindByOwnerObj() {
    System.out.println("\n*** testFindByOwnerObj");

    try {
      Customer c = CustomerMapper.customerMapper().findByKey(10);
      Vector<Account> results = aMapper.findByOwner(c);
      for ( Account a : results ) {
        System.out.println("id=" + a.getId());
        Customer o = CustomerMapper.customerMapper().findByKey(a.getOwner());
        System.out.println("owner=" + o.getLastName() + ", " + o.getFirstName());
        System.out.println("balance=" + a.getBalance());
      }

      /*
       * Wenn wir hier ankommen, dann gehen wir von einem erfolgreichen 
       * Testergebnis aus. Auf eine semantische Prüfung wird hier verzichtet.
       */
      assertTrue(true);
    }
    catch (Exception e) {
      // Im Falle einer Exception kennzeichnen wir den Test als gescheitert.
      assertTrue(false);
    }
  }

  /**
   * Test des Einfügens eines Kontos in die DB.
   */
  @Test
  public void testInsert() {
    System.out.println("\n*** testInsert");

    try {
      Account a = new AccountImpl();
      a.setId(1);

      a.setOwner(10);

      a.setBalance((float) 430.30);

      aMapper.insert(a);

      // Zur visuellen Verifikation lesen wir alle Konten nocheinmal aus.
      testFindAll();

      /*
       * Wenn wir hier ankommen, dann gehen wir von einem erfolgreichen 
       * Testergebnis aus. Auf eine semantische Prüfung wird hier verzichtet.
       */
      assertTrue(true);
    }
    catch (Exception e) {
      // Im Falle einer Exception kennzeichnen wir den Test als gescheitert.
      assertTrue(false);
    }
  }

  /**
   * Test des Überschreibens eines Kontos in der DB.
   */
  @Test
  public void testUpdate() {
    System.out.println("\n*** testUpdate");

    try {
      Account a = new AccountImpl();
      a.setId(9);
      a.setOwner(6);

      a.setBalance((float) 3000000.0);

      aMapper.update(a);

      // Zur visuellen Verifikation lesen wir alle Konten nocheinmal aus.
      testFindAll();

      /*
       * Wenn wir hier ankommen, dann gehen wir von einem erfolgreichen 
       * Testergebnis aus. Auf eine semantische Prüfung wird hier verzichtet.
       */
      assertTrue(true);
    }
    catch (Exception e) {
      // Im Falle einer Exception kennzeichnen wir den Test als gescheitert.
      assertTrue(false);
    }
  }

  /**
   * Test des Löschens eines Kontos aus der DB.
   */
  @Test
  public void testDelete() {
    System.out.println("\n*** testDelete");

    try {
      Account a = new AccountImpl();
      a.setId(10);

      aMapper.delete(a);

      // Zur visuellen Verifikation lesen wir alle Konten nocheinmal aus.
      testFindAll();

      /*
       * Wenn wir hier ankommen, dann gehen wir von einem erfolgreichen 
       * Testergebnis aus. Auf eine semantische Prüfung wird hier verzichtet.
       */
      assertTrue(true);
    }
    catch (Exception e) {
      // Im Falle einer Exception kennzeichnen wir den Test als gescheitert.
      assertTrue(false);
    }
  }
}
