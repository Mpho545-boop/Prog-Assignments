/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package wildliferescue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class RescueCaseTest {
    
    public RescueCaseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getCaseId method, of class RescueCase.
     */
    @Test
    public void testGetCaseId() {
        System.out.println("getCaseId");
        RescueCase instance = null;
        String expResult = "";
        String result = instance.getCaseId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnimalName method, of class RescueCase.
     */
    @Test
    public void testGetAnimalName() {
        System.out.println("getAnimalName");
        RescueCase instance = null;
        String expResult = "";
        String result = instance.getAnimalName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpecies method, of class RescueCase.
     */
    @Test
    public void testGetSpecies() {
        System.out.println("getSpecies");
        RescueCase instance = null;
        String expResult = "";
        String result = instance.getSpecies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class RescueCase.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        RescueCase instance = null;
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssignedRanger method, of class RescueCase.
     */
    @Test
    public void testGetAssignedRanger() {
        System.out.println("getAssignedRanger");
        RescueCase instance = null;
        String expResult = "";
        String result = instance.getAssignedRanger();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRescueDays method, of class RescueCase.
     */
    @Test
    public void testGetRescueDays() {
        System.out.println("getRescueDays");
        RescueCase instance = null;
        int expResult = 0;
        int result = instance.getRescueDays();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDailyCareCost method, of class RescueCase.
     */
    @Test
    public void testGetDailyCareCost() {
        System.out.println("getDailyCareCost");
        RescueCase instance = null;
        double expResult = 0.0;
        double result = instance.getDailyCareCost();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class RescueCase.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        RescueCase instance = null;
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class RescueCase.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        RescueCase instance = null;
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBaseCost method, of class RescueCase.
     */
    @Test
    public void testGetBaseCost() {
        System.out.println("getBaseCost");
        RescueCase instance = null;
        double expResult = 0.0;
        double result = instance.getBaseCost();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTotalCost method, of class RescueCase.
     */
    @Test
    public void testCalculateTotalCost() {
        System.out.println("calculateTotalCost");
        RescueCase instance = null;
        double expResult = 0.0;
        double result = instance.calculateTotalCost();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of determinePriority method, of class RescueCase.
     */
    @Test
    public void testDeterminePriority() {
        System.out.println("determinePriority");
        RescueCase instance = null;
        String expResult = "";
        String result = instance.determinePriority();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRescueType method, of class RescueCase.
     */
    @Test
    public void testGetRescueType() {
        System.out.println("getRescueType");
        RescueCase instance = null;
        String expResult = "";
        String result = instance.getRescueType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAdditionalInfo method, of class RescueCase.
     */
    @Test
    public void testDisplayAdditionalInfo() {
        System.out.println("displayAdditionalInfo");
        RescueCase instance = null;
        instance.displayAdditionalInfo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startRescue method, of class RescueCase.
     */
    @Test
    public void testStartRescue() {
        System.out.println("startRescue");
        RescueCase instance = null;
        instance.startRescue();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of completeRescue method, of class RescueCase.
     */
    @Test
    public void testCompleteRescue() {
        System.out.println("completeRescue");
        RescueCase instance = null;
        instance.completeRescue();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class RescueCaseImpl extends RescueCase {

        public RescueCaseImpl() {
            super("", "", "", "", "", 0, 0.0, "");
        }

        public double calculateTotalCost() {
            return 0.0;
        }

        public String determinePriority() {
            return "";
        }

        public String getRescueType() {
            return "";
        }

        public void displayAdditionalInfo() {
        }
    }
    
}
