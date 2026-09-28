/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wildliferescue;

/**
 *
 * @author Student
 */
public class InjuredAnimalRescue extends RescueCase {
    private String injuryDescription;
    private double treatmentCost;
    private boolean surgeryRequired;
    public InjuredAnimalRescue(
            String caseId,
            String animalName,
            String species,
            String location,
            String ranger,
            int days,
            double dailyCost,
            String status,
            String injuryDescription,
            double treatmentCost,
            boolean surgeryRequired) {
        super(caseId, animalName, species, location,
                ranger, days, dailyCost, status);
        this.injuryDescription = injuryDescription;
        this.treatmentCost = treatmentCost;
        this.surgeryRequired = surgeryRequired;
    }

    
    @Override
    public double calculateTotalCost() {
        double total = getBaseCost() + treatmentCost;
        if (surgeryRequired)
            total += 5000;
        return total;
    }
    @Override
    public String determinePriority() {
        return surgeryRequired ? "Critical" : "High";
    }
    @Override
    public String getRescueType() {
        return "Injured Animal Rescue";
    }
    @Override
    public void displayAdditionalInfo() {
        System.out.println("Injury: " + injuryDescription);
        System.out.println("Treatment Cost: R" + treatmentCost);
        System.out.println("Surgery Required: " + surgeryRequired);
    }
    public void generateSummary() {
        System.out.println("Case ID: " + getCaseId());
    }
@Override
    public String getCaseId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getBaseCost() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}