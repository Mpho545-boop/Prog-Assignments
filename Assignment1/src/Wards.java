import java.util.Scanner;

public class Wards {

    private static final int ROWS = 4;
    private static final int COLUMNS = 5;

    private static String[][] beds = new String[ROWS][COLUMNS];

    public static void displayWardLayout() {
        System.out.println("\nWARD LAYOUT");
        System.out.println("***********************");

        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {

                String bedNumber = getBedNumber(row, column);

                if (beds[row][column] == null) {
                    System.out.printf("[%-8s] ", bedNumber + " A");
                } else {
                    System.out.printf("[%-8s] ", bedNumber + " O");
                }
            }

            System.out.println();
        }

        System.out.println("\nA = Available");
        System.out.println("O = Occupied");
        System.out.println("*********************");
    }


    public static void allocateBed() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nALLOCATE BED");
        System.out.println("=================================");

        System.out.print("Enter patient ID: ");
        String patientId = scanner.nextLine();

        // Check if patient exists
        MedicalModel patient = findPatient(patientId);

        if (patient == null) {
            System.out.println("Patient with ID " + patientId + " was not found.");
            return;
        }

        // Only inpatients can use beds
        if (!patient.getPatientCategory().equalsIgnoreCase("Inpatient")) {
            System.out.println("Bed allocation denied.");
            System.out.println("Only inpatients are allowed to use hospital beds.");
            return;
        }

        // Check whether patient already has a bed
        if (patientAlreadyHasBed(patientId)) {
            System.out.println("This patient already has a bed allocated.");
            return;
        }

        // Find an available bed
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {

                if (beds[row][column] == null) {

                    beds[row][column] = patientId;

                    System.out.println("Bed successfully allocated.");
                    System.out.println("Patient: " + patient.getPatientName());
                    System.out.println("Patient ID: " + patientId);
                    System.out.println("Bed: " + getBedNumber(row, column));

                    return;
                }
            }
        }

        // No bed was available
        System.out.println("BED ALLOCATION FAILED.");
        System.out.println("There are no available beds.");
    }


    public static void releaseBed() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nRELEASE BED");
        System.out.println("=================================");

        System.out.print("Enter patient ID: ");
        String patientId = scanner.nextLine();

        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {

                if (beds[row][column] != null &&
                        beds[row][column].equalsIgnoreCase(patientId)) {

                    beds[row][column] = null;

                    System.out.println("Bed successfully released.");
                    System.out.println("Patient ID: " + patientId);
                    System.out.println("Released bed: " + getBedNumber(row, column));

                    return;
                }
            }
        }

        System.out.println("No bed was found for patient ID " + patientId);
    }


    public static void displayAvailableBeds() {

        System.out.println("\nAVAILABLE BEDS");
        System.out.println("=================================");

        boolean available = false;

        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {

                if (beds[row][column] == null) {
                    System.out.println(getBedNumber(row, column));
                    available = true;
                }
            }
        }

        if (!available) {
            System.out.println("There are no available beds.");
        }

        System.out.println("=================================");
    }


    public static void displayOccupiedBeds() {

        System.out.println("\nOCCUPIED BEDS");
        System.out.println("=================================");

        boolean occupied = false;

        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {

                if (beds[row][column] != null) {

                    System.out.println(
                            getBedNumber(row, column)
                                    + " -> Patient ID: "
                                    + beds[row][column]
                    );

                    occupied = true;
                }
            }
        }

        if (!occupied) {
            System.out.println("There are no occupied beds.");
        }

        System.out.println("=================================");
    }
    public static int getOccupiedBedCount() {

        int occupiedBeds = 0;

        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {

                if (beds[row][column] != null) {
                    occupiedBeds++;
                }
            }
        }

        return occupiedBeds;
    }

    private static String getBedNumber(int row, int column) {

        int bedNumber = (row * COLUMNS) + column + 1;

        return "Bed " + bedNumber;
    }


    private static MedicalModel findPatient(String patientId) {

        for (MedicalModel patient : MedicalModel.MedicList) {

            if (patient.getPatientId() != null &&
                    patient.getPatientId().equalsIgnoreCase(patientId)) {

                return patient;
            }
        }

        return null;
    }


    private static boolean patientAlreadyHasBed(String patientId) {

        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {

                if (beds[row][column] != null &&
                        beds[row][column].equalsIgnoreCase(patientId)) {

                    return true;
                }
            }
        }

        return false;
    }

    // Display total number of occupied beds
    public static void displayTotalOccupiedBeds() {

        System.out.println("\nTOTAL OCCUPIED BEDS");
        System.out.println("=================================");

        int occupiedBeds = Wards.getOccupiedBedCount();

        System.out.println("Total number of occupied beds: "
                + occupiedBeds);

        System.out.println("=================================");
    }


    // Display ward occupancy percentage
    public static void displayOccupancyPercentage() {

        System.out.println("\nWARD OCCUPANCY PERCENTAGE");
        System.out.println("=================================");

        int totalBeds = 20;
        int occupiedBeds = Wards.getOccupiedBedCount();

        double occupancyPercentage =
                ((double) occupiedBeds / totalBeds) * 100;

        System.out.printf("Ward occupancy: %.2f%%%n",
                occupancyPercentage);

        System.out.println("=================================");
    }

    public static void resetBedsForTesting() {
    }
}

