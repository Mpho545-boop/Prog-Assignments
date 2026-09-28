/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wildliferescue;

/**
 *
 * @author Student
 */
import java.util.ArrayList;
import java.util.Scanner;
public class WildlifeRescueSystem {
    private final ArrayList<RescueCase> rescueCases = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        WildlifeRescueSystem system =
                new WildlifeRescueSystem();
        system.menu();
    }
    public void menu() {
        int option;
        do {
            System.out.println("\n================================");
            System.out.println("WILDLIFE RESCUE OPERATIONS SYSTEM");
            System.out.println("================================");
            System.out.println("1. Create Rescue Case");
            System.out.println("2. Search Rescue Case");
            System.out.println("3. Update Rescue Status");
            System.out.println("4. Display All Rescue Cases");
            System.out.println("5. Start Rescue");
            System.out.println("6. Complete Rescue");
            System.out.println("7. Generate Report");
            System.out.println("8. Exit");
            System.out.print("Select Option: ");
            option = Integer.parseInt(input.nextLine());
            switch (option) {
                case 1 -> createRescueCase();
                case 2 -> searchCase();
                case 3 -> updateStatus();
                case 4 -> displayAllCases();
                case 5 -> startRescue();
                case 6 -> completeRescue();
                case 7 -> generateReport();
                case 8 -> System.out.println("Goodbye");
                default ->
                        System.out.println("Invalid Option");
            }
        } while (option != 8);
    }
    private boolean caseExists(String id) {
        for (RescueCase rc : rescueCases) {
            if (rc.getCaseId().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }
    public void createRescueCase() {
        System.out.print("Case ID: ");
        String id = input.nextLine();
        // Validation
        if (id.isBlank()) {
            System.out.println("Case ID cannot be blank");
            return;
        }
        if (caseExists(id)) {
            System.out.println("Case ID already exists");
            return;
        }
        System.out.print("Animal Name: ");
        String animal = input.nextLine();
        System.out.print("Species: ");
        String species = input.nextLine();
        System.out.print("Location: ");
        String location = input.nextLine();
        System.out.print("Assigned Ranger: ");
        String ranger = input.nextLine();
        System.out.print("Days: ");
        int days = Integer.parseInt(input.nextLine());
        System.out.print("Daily Cost: ");
        double dailyCost =
                Double.parseDouble(input.nextLine());
        System.out.println("""
                1. Injured
                2. Orphaned
                3. Endangered
                """);
        int type =
                Integer.parseInt(input.nextLine());
        RescueCase rescueCase;
        switch (type) {
            case 1 -> {
                rescueCase = new InjuredAnimalRescue(
                        id, animal, species,
                        location, ranger,
                        days, dailyCost,
                        "Open",
                        "Broken Leg",
                        3000,
                        true);
            }
            case 2 -> {
                rescueCase = new OrphanedAnimalRescue(
                        id, animal, species,
                        location, ranger,
                        days, dailyCost,
                        "Open",
                        4,
                        1000,
                        true);
            }
            case 3 -> {
                rescueCase = new EndangeredSpeciesRescue(
                        id, animal, species,
                        location, ranger,
                        days, dailyCost,
                        "Open",
                        "Critical",
                        5000,
                        true);
            }
            default -> {
                System.out.println("Invalid Rescue Type");
                return;
            }
        }
        rescueCases.add(rescueCase);
        System.out.println("Case Created");
    }
    public RescueCase findCase(String id) {
        for (RescueCase rc : rescueCases) {
            if (rc.getCaseId().equalsIgnoreCase(id))
                return rc;
        }
        return null;
    }
    public void searchCase() {
        System.out.print("Enter Case ID: ");
        RescueCase rc =
                findCase(input.nextLine());
        if (rc == null) {
            System.out.println("Case Not Found");
            return;
        }
        System.out.println(rc.getRescueType());
    }
    public void updateStatus() {
        System.out.print("Case ID: ");
        RescueCase rc =
                findCase(input.nextLine());
        if (rc == null) {
            System.out.println("Not Found");
            return;
        }
        System.out.print("New Status: ");
        rc.setStatus(input.nextLine());
        System.out.println("Updated");
    }
    public void startRescue() {
        System.out.print("Case ID: ");
        RescueCase rc =
                findCase(input.nextLine());
        if (rc != null)
            rc.startRescue();
    }
    public void completeRescue() {
        System.out.print("Case ID: ");
        RescueCase rc =
                findCase(input.nextLine());
        if (rc != null)
            rc.completeRescue();
    }
    public void displayAllCases() {
        for (RescueCase rc : rescueCases) {
            System.out.println("------------------------");
            System.out.println(rc.getCaseId());
            System.out.println(rc.getRescueType());
            System.out.println(rc.getSpecies());
        }
    }
    public void generateReport() {
        double totalCost = 0;
        System.out.println("\nWILDLIFE RESCUE REPORT");
        for (RescueCase rc : rescueCases) {
            System.out.println("\nCase ID: "
                    + rc.getCaseId());
            System.out.println("Type: "
                    + rc.getRescueType());
            System.out.println("Species: "
                    + rc.getSpecies());
            System.out.println("Location: "
                    + rc.getLocation());
            System.out.println("Assigned Ranger: "
                    + rc.getAssignedRanger());
            System.out.println("Priority: "
                    + rc.determinePriority());
            System.out.println("Status: "
                    + rc.getStatus());
            System.out.println("Total Cost: R"
                    + rc.calculateTotalCost());
            totalCost += rc.calculateTotalCost();
        }
        System.out.println(
                "\nTotal Rescue Cases: "
                        + rescueCases.size());
        System.out.println(
                "Total Rescue Cost: R"
                        + totalCost);
    }
}
