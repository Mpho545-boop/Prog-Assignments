import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MedicSavedDataTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    private ByteArrayOutputStream output;

    @BeforeEach
    public void setUp() {
        // Clear patients before every test
        MedicalModel.MedicList.clear();

        // Reset ward beds
        Wards.resetBedsForTesting();

        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);

        MedicalModel.MedicList.clear();
        Wards.resetBedsForTesting();
    }

    /*
     * Helper method used to simulate keyboard input.
     */
    private void provideInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    /*
     * ---------------------------------------------------------
     * TEST 1: REGISTER A PATIENT
     * ---------------------------------------------------------
     */
    @Test
    public void testRegisterPatient() {

        provideInput(
                "P001\n" +
                        "John Smith\n" +
                        "45\n" +
                        "Broken leg\n" +
                        "Male\n" +
                        "Inpatient\n"
        );

        String returnedId = MedicSavedData.registerPatient();

        assertEquals("P001", returnedId);
        assertEquals(1, MedicalModel.MedicList.size());

        MedicalModel patient = MedicalModel.MedicList.get(0);

        assertEquals("P001", patient.getPatientId());
        assertEquals("John Smith", patient.getPatientName());
        assertEquals("45", patient.getPatientAge());
        assertEquals("Broken leg", patient.getMedicalCondition());
        assertEquals("Male", patient.getPatientGender());
        assertEquals("Inpatient", patient.getPatientCategory());
    }


    /*
     * ---------------------------------------------------------
     * TEST 2: SEARCH FOR A PATIENT
     * ---------------------------------------------------------
     */
    @Test
    public void testSearchPatient() {

        MedicSavedData patient = new MedicSavedData(
                "P002",
                "Mary Jones",
                "30",
                "Flu",
                "Female",
                "Outpatient"
        );

        MedicalModel.MedicList.add(patient);

        provideInput("P002\n");

        MedicSavedData.searchPatientID();

        String result = output.toString();

        assertTrue(result.contains("P002"));
        assertTrue(result.contains("Mary Jones"));
        assertTrue(result.contains("30"));
        assertTrue(result.contains("Flu"));
    }


    /*
     * ---------------------------------------------------------
     * TEST 3: UPDATE PATIENT DETAILS
     * ---------------------------------------------------------
     */
    @Test
    public void testUpdatePatient() {

        MedicSavedData patient = new MedicSavedData(
                "P003",
                "Peter Brown",
                "40",
                "Headache",
                "Male",
                "Outpatient"
        );

        MedicalModel.MedicList.add(patient);

        provideInput(
                "P003\n" +
                        "Peter Smith\n" +
                        "41\n" +
                        "Migraine\n"
        );

        MedicSavedData.UpdatePatient();

        assertEquals("Peter Smith", patient.getPatientName());
        assertEquals("41", patient.getPatientAge());
        assertEquals("Migraine", patient.getMedicalCondition());
    }


    /*
     * ---------------------------------------------------------
     * TEST 4: DELETE A PATIENT
     * ---------------------------------------------------------
     */
    @Test
    public void testDeletePatient() {

        MedicSavedData patient = new MedicSavedData(
                "P004",
                "Susan Williams",
                "25",
                "Fever",
                "Female",
                "Outpatient"
        );

        MedicalModel.MedicList.add(patient);

        assertEquals(1, MedicalModel.MedicList.size());

        provideInput(
                "P004\n" +
                        "Y\n"
        );

        MedicSavedData.deletePatient();

        assertEquals(0, MedicalModel.MedicList.size());
    }


    /*
     * ---------------------------------------------------------
     * TEST 5: ALLOCATE A BED
     * ---------------------------------------------------------
     */
    @Test
    public void testAllocateBed() {

        MedicSavedData patient = new MedicSavedData(
                "P005",
                "David Adams",
                "50",
                "Broken arm",
                "Male",
                "Inpatient"
        );

        MedicalModel.MedicList.add(patient);

        provideInput("P005\n");

        Wards.allocateBed();

        assertEquals(1, Wards.getOccupiedBedCount());

        String result = output.toString();

        assertTrue(result.contains("Bed successfully allocated"));
        assertTrue(result.contains("P005"));
    }


    /*
     * ---------------------------------------------------------
     * TEST 6: RELEASE A BED
     * ---------------------------------------------------------
     */
    @Test
    public void testReleaseBed() {

        MedicSavedData patient = new MedicSavedData(
                "P006",
                "Linda Adams",
                "35",
                "Pneumonia",
                "Female",
                "Inpatient"
        );

        MedicalModel.MedicList.add(patient);

        // First allocate the bed
        provideInput("P006\n");
        Wards.allocateBed();

        assertEquals(1, Wards.getOccupiedBedCount());

        // Clear output and release the bed
        output.reset();

        provideInput("P006\n");
        Wards.releaseBed();

        assertEquals(0, Wards.getOccupiedBedCount());

        String result = output.toString();

        assertTrue(result.contains("Bed successfully released"));
        assertTrue(result.contains("P006"));
    }


    /*
     * ---------------------------------------------------------
     * TEST 7: PREVENT DUPLICATE PATIENT IDs
     * ---------------------------------------------------------
     *
     * This test will FAIL with your current code because
     * registerPatient() currently allows duplicate IDs.
     *
     * You need to add duplicate-ID validation to the
     * registerPatient() method.
     * ---------------------------------------------------------
     */
    @Test
    public void testDuplicatePatientIdIsPrevented() {

        MedicSavedData firstPatient = new MedicSavedData(
                "P007",
                "John Smith",
                "40",
                "Flu",
                "Male",
                "Outpatient"
        );

        MedicalModel.MedicList.add(firstPatient);

        provideInput(
                "P007\n" +
                        "Jane Smith\n" +
                        "30\n" +
                        "Headache\n" +
                        "Female\n" +
                        "Outpatient\n"
        );

        MedicSavedData.registerPatient();

        // Only one patient with P007 should exist
        long count = MedicalModel.MedicList.stream()
                .filter(p -> p.getPatientId().equalsIgnoreCase("P007"))
                .count();

        assertEquals(1, count,
                "Duplicate Patient IDs should not be allowed");
    }


    /*
     * ---------------------------------------------------------
     * TEST 8: PREVENT ALLOCATING AN OCCUPIED BED
     * ---------------------------------------------------------
     *
     * Your program does not allow the same patient to receive
     * another bed because of patientAlreadyHasBed().
     *
     * This test verifies that functionality.
     * ---------------------------------------------------------
     */
    @Test
    public void testPatientCannotBeAllocatedTwoBeds() {

        MedicSavedData patient = new MedicSavedData(
                "P008",
                "Michael Jones",
                "45",
                "Injury",
                "Male",
                "Inpatient"
        );

        MedicalModel.MedicList.add(patient);

        // First allocation
        provideInput("P008\n");
        Wards.allocateBed();

        assertEquals(1, Wards.getOccupiedBedCount());

        output.reset();

        // Try allocating another bed to same patient
        provideInput("P008\n");
        Wards.allocateBed();

        // Number of occupied beds must still be one
        assertEquals(1, Wards.getOccupiedBedCount());

        String result = output.toString();

        assertTrue(result.contains("already has a bed allocated"));
    }


    /*
     * ---------------------------------------------------------
     * TEST 9: PREVENT ALLOCATION WHEN ALL BEDS ARE OCCUPIED
     * ---------------------------------------------------------
     *
     * Your ward contains 20 beds.
     * ---------------------------------------------------------
     */
    @Test
    public void testCannotAllocateWhenAllBedsAreOccupied() {

        // Create 20 inpatient patients
        for (int i = 1; i <= 20; i++) {

            String id = String.format("P%03d", i);

            MedicSavedData patient = new MedicSavedData(
                    id,
                    "Patient " + i,
                    "30",
                    "Condition",
                    "Male",
                    "Inpatient"
            );

            MedicalModel.MedicList.add(patient);

            provideInput(id + "\n");
            Wards.allocateBed();
        }

        // All 20 beds should be occupied
        assertEquals(20, Wards.getOccupiedBedCount());

        output.reset();

        // Add another patient
        MedicSavedData extraPatient = new MedicSavedData(
                "P021",
                "Extra Patient",
                "25",
                "Fever",
                "Female",
                "Inpatient"
        );

        MedicalModel.MedicList.add(extraPatient);

        provideInput("P021\n");

        Wards.allocateBed();

        // Still only 20 occupied beds
        assertEquals(20, Wards.getOccupiedBedCount());

        String result = output.toString();

        assertTrue(result.contains("There are no available beds"));
    }


    /*
     * ---------------------------------------------------------
     * TEST 10A: SORT PATIENTS BY SURNAME
     * ---------------------------------------------------------
     *
     * Requires sortPatientsBySurname() to be added to
     * MedicSavedData.
     * ---------------------------------------------------------
     */
    @Test
    public void testSortPatientsBySurname() {

        MedicalModel.MedicList.add(
                new MedicSavedData(
                        "P010",
                        "John Smith",
                        "40",
                        "Flu",
                        "Male",
                        "Outpatient"
                )
        );

        MedicalModel.MedicList.add(
                new MedicSavedData(
                        "P011",
                        "Alice Adams",
                        "25",
                        "Fever",
                        "Female",
                        "Outpatient"
                )
        );

        MedicalModel.MedicList.add(
                new MedicSavedData(
                        "P012",
                        "Peter Brown",
                        "35",
                        "Injury",
                        "Male",
                        "Inpatient"
                )
        );

        MedicSavedData.sortPatientsBySurname();

        assertEquals(
                "Alice Adams",
                MedicalModel.MedicList.get(0).getPatientName()
        );

        assertEquals(
                "Peter Brown",
                MedicalModel.MedicList.get(1).getPatientName()
        );

        assertEquals(
                "John Smith",
                MedicalModel.MedicList.get(2).getPatientName()
        );
    }


    /*
     * ---------------------------------------------------------
     * TEST 10B: SORT PATIENTS BY PATIENT ID
     * ---------------------------------------------------------
     */
    @Test
    public void testSortPatientsByPatientId() {

        MedicalModel.MedicList.add(
                new MedicSavedData(
                        "P003",
                        "John Smith",
                        "40",
                        "Flu",
                        "Male",
                        "Outpatient"
                )
        );

        MedicalModel.MedicList.add(
                new MedicSavedData(
                        "P001",
                        "Alice Adams",
                        "25",
                        "Fever",
                        "Female",
                        "Outpatient"
                )
        );

        MedicalModel.MedicList.add(
                new MedicSavedData(
                        "P002",
                        "Peter Brown",
                        "35",
                        "Injury",
                        "Male",
                        "Inpatient"
                )
        );

        MedicSavedData.sortPatientsByPatientId();

        assertEquals(
                "P001",
                MedicalModel.MedicList.get(0).getPatientId()
        );

        assertEquals(
                "P002",
                MedicalModel.MedicList.get(1).getPatientId()
        );

        assertEquals(
                "P003",
                MedicalModel.MedicList.get(2).getPatientId()
        );
    }
}
