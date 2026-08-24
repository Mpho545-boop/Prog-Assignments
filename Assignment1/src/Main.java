import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int choice;
        int option = 0;
        int wardOption=0;

        System.out.println("WELCOME TO YOUR HOSPITAL DATABASE");
        System.out.println("*******************************");
        System.out.println("Enter (1) to launch the menu or any other key to exit:");
        choice = Integer.parseInt(scanner.nextLine());

        while (running) {

            if (choice == 1) {
                System.out.println("Please select one of the following menu options (1-6)");
                System.out.println("1. Register new patient");
                System.out.println("2. Search for patient ID");
                System.out.println("3. Update patient details");
                System.out.println("4. Delete a patient");
                System.out.println("5. Total patients");
                System.out.println("6. Patient details");
                System.out.println("7. Print patient report");
                System.out.println("8. Ward Management");
                System.out.println("9. Exit Application");

                option = Integer.parseInt(scanner.nextLine());

            } else {
                System.out.println("Quitting... Goodbye!");
                running = false;
            }

            switch (option) {

                case 1: // done

                    MedicSavedData.registerPatient();
                    break;

                case 2: // done
                    MedicSavedData.searchPatientID();
                    break;

                case 3: // done
                    MedicSavedData.UpdatePatient();
                    break;

                case 4: // done
                    MedicSavedData.deletePatient();
                    break;
                case 5:
                    MedicSavedData.displayTotalPatients();
                    break;

                case 6:
                    Inpatient patient = new Inpatient(
                            "P001",
                            "John Smith",
                            "45",
                            "Broken leg",
                            "Male",
                            "Inpatient",
                            "Ward 2",
                            "Bed 5"
                    );

                    patient.displayDetails();

                case 7: //done
                    System.out.println("Print Medical report");
                    MedicSavedData.displayPatient();
                    break;

                case 8:

                    System.out.println("WARD MANAGEMENT");
                    System.out.println("1. Allocate bed");
                    System.out.println("2. Release bed");
                    System.out.println("3. Display ward layout");
                    System.out.println("4. Display available beds");
                    System.out.println("5. Display occupied beds");
                    System.out.println("6. Display total occupied beds");
                    System.out.println("7. Display ward occupancy percentage");
                    System.out.println("8. Return to previous menu");

                    wardOption = Integer.parseInt(scanner.nextLine());
                    switch (wardOption) {
                        case 1:
                            System.out.println("6. Allocate bed");
                            Wards.allocateBed();
                            break;

                        case 2:
                            System.out.println("7. Release bed");
                            Wards.releaseBed();
                            break;

                        case 3:
                            System.out.println("8. Display ward layout");
                            Wards.displayWardLayout();
                            break;

                        case 4:
                            System.out.println("9. Display available beds");
                            Wards.displayAvailableBeds();
                            break;

                        case 5:
                            System.out.println("10. Display occupied beds");
                            Wards.displayOccupiedBeds();
                            break;
                        case 6:
                            Wards.displayTotalOccupiedBeds();
                            break;

                        case 7:
                            Wards.displayOccupancyPercentage();
                            break;

                        case 8:
                            System.out.println("Returning to previous menu");
                            break;
                    }
                    break;

                case 9: //done
                    System.out.println("Exit Application");
                    System.out.println("Quitting... Goodbye!");
                    running = false;

            }
        }
    }
}


