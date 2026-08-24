import java.util.Scanner;


public class MedicSavedData extends MedicalModel{
    public MedicSavedData(String PatientId, String PatientName, String PatientAge, String MedicalCondition, String patientGender, String patientCategory){
        super(PatientId, PatientName, PatientAge, MedicalCondition, patientGender, patientCategory);
    }


    public static String registerPatient(){ // This captures the patient
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        String age = "";
        String MedicalCondition = "";
        String patientGender = "";
        String patientCategory = "";
        int ageNum;
        System.out.println("PATIENT REGISTRATION" ) ;
        System.out.println("*********************************************");
        System.out.println("Enter the patient ID");
        id = scanner.nextLine();
        System.out.println("Enter the patient name (Enter full name)");
        name= scanner.nextLine();
        while (true) {
            System.out.println("Enter the patient age");
            age = scanner.nextLine();

            if (age.matches("\\d+")) {
                ageNum = Integer.parseInt(age);
                if (ageNum >= 0 && ageNum <= 130) {
                    System.out.println("Age captured successfully.");
                    break;
                } else {
                    System.out.println("You have entered the incorrect patient age.");
                }
            } else {
                System.out.println("You have entered the incorrect patient age. Only digits are allowed.");
            }
        }
        System.out.println("Enter patient gender");
        patientGender = scanner.nextLine();
        System.out.println("Enter patient category");
        patientCategory = scanner.nextLine();
        System.out.println("Enter the patient medical condition");
        MedicalCondition = scanner.nextLine();

        MedicSavedData patient = new MedicSavedData( id, name, age, MedicalCondition, patientGender, patientCategory );
        MedicList.add(patient);
        System.out.println("Medical data saved.");
        return id;
    }


    public static void searchPatientID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PATIENT SEARCH");
        System.out.println("*******************************");
        System.out.println("Enter the patient ID to search for:");
        String searchId = scanner.nextLine();
        System.out.println("Searching for a patient ");
        boolean foundIt = false;

        for (MedicalModel s : MedicList) {
            if (s.getPatientId().equalsIgnoreCase(searchId)) {
                System.out.println("Series Found:");
                System.out.println("ID: " + s.getPatientId());
                System.out.println("Name: " + s.getPatientName());
                System.out.println("Age: " + s.getPatientAge());
                System.out.println("Gender: "+ s.getPatientGender());
                System.out.println("Medical condition: " + s.getMedicalCondition());
                System.out.println("Category: "+ s.getPatientCategory());
                foundIt = true;
            }
        }

        if (!foundIt) {
            System.out.println("patient not found");
        }
    }


    public static void UpdatePatient() { // this method updates patient information after the patient ID has been entered
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        String age = "";
        int ageNum;
        String condition;
        boolean foundIt = false;
        System.out.println("UPDATE PATIENT RECORDS");
        System.out.println("*******************************");

        System.out.println("Enter the Patient ID you want to update:");
        id = scanner.nextLine();
        for (MedicalModel s : MedicList) {
            if (s.getPatientId().equalsIgnoreCase(id)) {
                foundIt = true;
                System.out.println("Enter the updated Patient name:");
                name = scanner.nextLine();
                s.PatientName = name;
                System.out.println("Patient name updated successfully.");
                while (true) {
                    System.out.println("Enter the updated patient age (digits only):");
                    age = scanner.nextLine();
                    if (age.matches("\\d+")) {
                        ageNum = Integer.parseInt(age);
                        if (ageNum >= 0 && ageNum <= 120) {
                            s.PatientAge = age;
                            System.out.println("Patient age updated successfully.");
                            break;
                        } else {
                            System.out.println("Invalid age");
                        }
                    } else {
                        System.out.println("You have entered the incorrect patient age. Only digits are allowed.");
                    }
                }
                System.out.println("Enter the updated patient condition:");
                condition = scanner.nextLine();
                s.MedicalCondition = condition;
                System.out.println("Number of patient condition successfully .");
            }
        }

        if (!foundIt) {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }




    public static void deletePatient(){ // this method deletes the series
        Scanner scanner = new Scanner(System.in);
        String id;
        String choice;
        boolean found = false;
        System.out.println("PATIENT DElETION");
        System.out.println("*******************************");
        System.out.println("Enter the patient ID of the patient you want to delete");
        id = scanner.nextLine();
        System.out.println("Are you sure you want to delete patient with ID \"" + id + "\"? Type Y to confirm.");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")){
            for (int i = 0; i < MedicList.size(); i++) {
                if (MedicList.get(i).getPatientId().equalsIgnoreCase(id)) {
                    MedicList.remove(i);
                    System.out.println("Patient" + id + "successfully deleted.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Patient with ID " + id + " not found.");
            }
        } else {
            System.out.println("Canceled patient deletion.");
        }
    }

    // Display total number of registered patients
    public static void displayTotalPatients() {

        System.out.println("\nTOTAL REGISTERED PATIENTS");
        System.out.println("=================================");

        int totalPatients = MedicalModel.MedicList.size();

        System.out.println("Total number of registered patients: "
                + totalPatients);

        System.out.println("=================================");
    }


    public static void displayPatient() { // this displays the full report of the patient
        System.out.println("PATIENT REPORT");
        System.out.println("*******************************");
        if (MedicList.isEmpty()) {
            System.out.println("No patient available.");
            return;
        }

        for (MedicalModel s : MedicList) {
            System.out.println("----------------------------");
            System.out.println("Id: " + s.getPatientId());
            System.out.println("----------------------------");
            System.out.println("Name: " + s.getPatientName());
            System.out.println("Age: " + s.getPatientAge());
            System.out.println("Gender"+s.getPatientGender());
            System.out.println("Medical Condition: " + s.getMedicalCondition());
            System.out.println("Category: "+ s.getPatientCategory());
            System.out.println("----------------------------");
        }

    }

    public static void sortPatientsBySurname() {
    }

    public static void sortPatientsByPatientId() {
    }
}


