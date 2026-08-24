public class Inpatient extends MedicalModel {

    private String wardNumber;
    private String bedNumber;

    public Inpatient(
            String PatientId,
            String PatientName,
            String patientAge,
            String medicalCondition,
            String PatientGender,
            String patientCategory,
            String wardNumber,
            String bedNumber) {

        super(
                PatientId,
                PatientName,
                patientAge,
                medicalCondition,
                PatientGender,
                patientCategory
        );

        this.wardNumber = wardNumber;
        this.bedNumber = bedNumber;
    }

    public String getWardNumber() {
        return wardNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void displayDetails() {
        System.out.println("Patient ID: " + PatientId);
        System.out.println("Patient Name: " + PatientName);
        System.out.println("Patient Age: " + PatientAge);
        System.out.println("Patient Gender: " + patientGender);
        System.out.println("Patient Category: " + patientCategory);
        System.out.println("Medical Condition: " + MedicalCondition);
        System.out.println("Ward Number: " + wardNumber);
        System.out.println("Bed Number: " + bedNumber);
    }
}