import java.util.ArrayList;


public abstract class MedicalModel {
    static ArrayList<MedicalModel> MedicList = new ArrayList<MedicalModel>();
    public  String PatientId;
    public  String PatientName;
    public  String PatientAge;
    public  String patientGender;
    public  String patientCategory;
    public  String MedicalCondition;

    public MedicalModel(String PatientId, String PatientName, String patientAge, String medicalCondition, String PatientGender,String patientCategory) {
        this.PatientId = PatientId;
        this.PatientName = PatientName;
        this.PatientAge = patientAge;
        this.MedicalCondition = medicalCondition;
        this.patientGender = PatientGender;
        this.patientCategory = patientCategory;


    }

    public String getPatientId() {
        return PatientId;
    }

    public String getPatientName() {
        return PatientName;
    }

    public String getPatientAge() {
        return PatientAge;
    }

    public String getMedicalCondition() {
        return MedicalCondition;
    }

    public String getPatientGender() {
        return  patientGender;
    }

    String getPatientCategory() {
        return patientCategory;
    }

}



