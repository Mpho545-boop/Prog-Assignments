/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wildliferescue;

/**
 *
 * @author Student
 */
public abstract class RescueCase {
    // Encapsulation
    private final String caseId;
    private final String animalName;
    private final String species;
    private final String location;
    private final String assignedRanger;
    private final int rescueDays;
    private final double dailyCareCost;
    private String status;
    public RescueCase(String caseId, String animalName,
                      String species, String location,
                      String assignedRanger, int rescueDays,
                      double dailyCareCost, String status) {
        this.caseId = caseId;
        this.animalName = animalName;
        this.species = species;
        this.location = location;
        this.assignedRanger = assignedRanger;
        this.rescueDays = rescueDays;
        this.dailyCareCost = dailyCareCost;
        this.status = status;
    }
    // Getters
    public String getCaseId() {
        return caseId;
    }
    public String getAnimalName() {
        return animalName;
    }
    public String getSpecies() {
        return species;
    }
    public String getLocation() {
        return location;
    }
    public String getAssignedRanger() {
        return assignedRanger;
    }
    public int getRescueDays() {
        return rescueDays;
    }
    public double getDailyCareCost() {
        return dailyCareCost;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getBaseCost() {
        return rescueDays * dailyCareCost;
    }
    // Abstract methods
    public abstract double calculateTotalCost();
    public abstract String determinePriority();
    public abstract String getRescueType();
    public abstract void displayAdditionalInfo();
   
    public void startRescue() {
        status = "Rescue In Progress";
    }
  
    public void completeRescue() {
        status = "Completed";
    }

}   

