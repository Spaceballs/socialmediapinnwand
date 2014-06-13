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
 * Testklasse, um den <code>CustomerMapper</code> auf seine Funktion zu prüfen.
 * 
 * @see AccountMapperTest
 * @author Thies
 */
public class CustomerMapperTest {

  // CustomerMapper instantiieren.
  CustomerMapper cMapper = CustomerMapper.customerMapper();

  public CustomerMapperTest() {
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
      Customer c = cMapper.findByKey(3);
      System.out.println("id=" + c.getId());
      System.out.println("lastName=" + c.getLastName());
      System.out.println("firstName=" + c.getFirstName());

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
      Vector<Customer> results = cMapper.findAll();
      for ( Customer c : results ) {
        System.out.println("id=" + c.getId());
        System.out.println("lastName=" + c.getLastName());
        System.out.println("firstName=" + c.getFirstName());
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
   * Test der findByLastName-Methode
   *
   */
  @Test
  public void testFindByLastName() {
    System.out.println("\n*** testFindByLastName");

    try {
      Vector<Customer> results = cMapper.findByLastName("Adenauer");
      for ( Customer c : results ) {
        System.out.println("id=" + c.getId());
        System.out.println("lastName=" + c.getLastName());
        System.out.println("firstName=" + c.getFirstName());
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
   * Test des Einfügens eines Kunden in die DB.
   */
  @Test
  public void testInsert() {
    System.out.println("\n*** testInsert");

    try {
      Customer c = new CustomerImpl();
      c.setId(1);
      c.setFirstName("Walter");
      c.setLastName("von der Vogelweide");

      cMapper.insert(c);

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
   * Test des Überschreibens eines Kunden in der DB.
   */
  @Test
  public void testUpdate() {
    System.out.println("\n*** testUpdate");

    try {
      Customer c = new CustomerImpl();
      c.setId(2);
      c.setFirstName("Erna");
      c.setLastName("von habe nichts und krieg´ auch nichts");

      cMapper.update(c);

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
   * Test des Löschens eines Kunden aus der DB.
   */
  @Test
  public void testDelete() {
    System.out.println("\n*** testDelete");

    try {
      Customer c = new CustomerImpl();
      c.setId(11);

      cMapper.delete(c);

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
