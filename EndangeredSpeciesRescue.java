/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wildliferescue;

/**
 *
 * @author Student
 */
public class EndangeredSpeciesRescue extends RescueCase {
    private String classification;
    private double securityCost;
    private boolean specialistTeamRequired;
    public EndangeredSpeciesRescue(
            String caseId,
            String animalName,
            String species,
            String location,
            String ranger,
            int days,
            double dailyCost,
            String status,
            String classification,
            double securityCost,
            boolean specialistTeamRequired) {
        super(caseId, animalName, species,
                location, ranger,
                days, dailyCost, status);
        this.classification = classification;
        this.securityCost = securityCost;
        this.specialistTeamRequired = specialistTeamRequired;
    }

  @Override
    public double calculateTotalCost() {
        double total = getBaseCost() + securityCost;
        if (specialistTeamRequired)
            total += 8000;
        return total;
    }
    @Override
    public String determinePriority() {
        return classification.equalsIgnoreCase("Critical")
                ? "Critical"
                : "High";
    }
    @Override
    public String getRescueType() {
        return "Endangered Species Rescue";
    }
    @Override
    public void displayAdditionalInfo() {
        System.out.println("Classification: " + classification);
        System.out.println("Security Cost: R" + securityCost);
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
