/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wildliferescue;

/**
 *
 * @author Student
 */
public class OrphanedAnimalRescue extends RescueCase {
    private int estimatedAge;
    private double feedingCost;
    private boolean fosterCareRequired;
    public OrphanedAnimalRescue(
            String caseId,
            String animalName,
            String species,
            String location,
            String ranger,
            int days,
            double dailyCost,
            String status,
            int estimatedAge,
            double feedingCost,
            boolean fosterCareRequired) {
        super(caseId, animalName, species,
                location, ranger,
                days, dailyCost, status);
        this.estimatedAge = estimatedAge;
        this.feedingCost = feedingCost;
        this.fosterCareRequired = fosterCareRequired;
    }
    @Override
    public double calculateTotalCost() {
        double total = getBaseCost() + feedingCost;
        if (fosterCareRequired)
            total += 2500;
        return total;
    }
    @Override
    public String determinePriority() {
        return estimatedAge < 6 ? "High" : "Medium";
    }
    @Override
    public String getRescueType() {
        return "Orphaned Animal Rescue";
    }
    @Override
    public void displayAdditionalInfo() {
        System.out.println("Age: " + estimatedAge);
        System.out.println("Feeding Cost: R" + feedingCost);
        System.out.println("Foster Care: " + fosterCareRequired);
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