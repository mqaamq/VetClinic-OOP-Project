package com.madina.vetclinic.menu;

import com.madina.vetclinic.exception.InvalidInputException;
import com.madina.vetclinic.interfaces.Menu;
import com.madina.vetclinic.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private final ArrayList<Pet> pets = new ArrayList<>();
    private final ArrayList<Owner> owners = new ArrayList<>();
    private final ArrayList<Veterinarian> veterinarians = new ArrayList<>();
    private final ArrayList<ClinicPerson> people = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    public MenuManager() {
        seedTestData();
    }

    @Override
    public void run() {
        printWelcomeMessage();

        boolean running = true;
        while (running) {
            displayMenu();

            try {
                int choice = readInt("Enter your choice: ");

                switch (choice) {
                    case 1 -> addPet();
                    case 2 -> viewAllPets();
                    case 3 -> addOwner();
                    case 4 -> viewAllOwners();
                    case 5 -> addVeterinarian();
                    case 6 -> viewAllVeterinarians();
                    case 7 -> viewAllPeoplePolymorphism();
                    case 8 -> demonstrateInstanceofCasting();
                    case 9 -> printFinalState();
                    case 0 -> {
                        System.out.println("\nGoodbye!");
                        running = false;
                    }
                    default -> System.out.println("\nInvalid choice! Please try again.");
                }

            } catch (InvalidInputException e) {
                System.out.println("Input error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Validation error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("            VET CLINIC SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Pet");
        System.out.println("2. View All Pets");
        System.out.println("3. Add Owner");
        System.out.println("4. View All Owners");
        System.out.println("5. Add Veterinarian");
        System.out.println("6. View All Veterinarians");
        System.out.println("----------------------------------------");
        System.out.println("7. View All People (Polymorphism)");
        System.out.println("8. Demonstrate instanceof + Casting");
        System.out.println("9. View Final State");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    private void printWelcomeMessage() {
        System.out.println("""
                === Welcome to the Veterinary Clinic Management System ===
                This project manages pets, owners, and veterinarians.

                Week 6 updates:
                - Menu moved into MenuManager (interface Menu)
                - Abstract parent class ClinicPerson + overriding
                - Exception handling + custom InvalidInputException
                - Validation throws exceptions (no print warnings)
                - Second interface Treatable implemented by Veterinarian
                """);
    }

    private void seedTestData() {
        pets.add(new Pet(1, "Rex", "Dog", 3, "Balausa"));
        pets.add(new Pet(2, "Snezhok", "Cat", 1, "Zhanerke"));
        pets.add(new Pet(3, "Kitya", "Cat", 2, "Zarina"));

        Owner o1 = new Owner(1, "Balausa", "+7 777 777 77 77", 1);
        Owner o2 = new Owner(2, "Zhanerke", "+7 707 707 77 77", 1);
        Owner o3 = new Owner(3, "Zarina", "+7 747 747 77 77", 1);

        owners.add(o1);
        owners.add(o2);
        owners.add(o3);

        Veterinarian v1 = new Veterinarian(1, "Dr. Kang", "Dog", 6);
        Veterinarian v2 = new Veterinarian(2, "Dr. Smith", "Cat", 4);

        veterinarians.add(v1);
        veterinarians.add(v2);


        people.add(o1);
        people.add(o2);
        people.add(o3);
        people.add(v1);
        people.add(v2);
    }



    private int readInt(String prompt) throws InvalidInputException {
        System.out.print(prompt);
        String line = scanner.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid integer.");
        }
    }

    private String readNonEmptyString(String prompt) throws InvalidInputException {
        System.out.print(prompt);
        String text = scanner.nextLine().trim();
        if (text.isEmpty()) throw new InvalidInputException("Input cannot be empty.");
        return text;
    }



    private void addPet() throws InvalidInputException {
        System.out.println("\n--- ADD PET ---");
        int id = readInt("Enter Pet ID: ");
        String name = readNonEmptyString("Enter Pet Name: ");
        String species = readNonEmptyString("Enter Species (Dog/Cat/etc): ");
        int age = readInt("Enter Age: ");
        String ownerName = readNonEmptyString("Enter Owner Name: ");

        Pet pet = new Pet(id, name, species, age, ownerName);
        pets.add(pet);

        System.out.println("Pet added successfully! ✅");
    }

    private void viewAllPets() {
        System.out.println("\n========== ALL PETS ==========");
        if (pets.isEmpty()) {
            System.out.println("No pets found.");
            return;
        }

        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            System.out.println((i + 1) + ". " + pet);
            System.out.println("   Life stage: " + pet.getLifeStage());
            System.out.println("   Young: " + (pet.isYoung() ? "Yes ✅" : "No ❌"));
        }
    }



    private void addOwner() throws InvalidInputException {
        System.out.println("\n--- ADD OWNER ---");
        int id = readInt("Enter Owner ID: ");
        String name = readNonEmptyString("Enter Owner Name: ");
        String phone = readNonEmptyString("Enter Phone: ");
        int numberOfPets = readInt("Enter Number of Pets: ");

        Owner owner = new Owner(id, name, phone, numberOfPets);
        owners.add(owner);
        people.add(owner);

        System.out.println("Owner added successfully! ✅");
    }

    private void viewAllOwners() {
        System.out.println("\n========== ALL OWNERS ==========");
        if (owners.isEmpty()) {
            System.out.println("No owners found.");
            return;
        }

        for (int i = 0; i < owners.size(); i++) {
            Owner owner = owners.get(i);
            System.out.println((i + 1) + ". " + owner);
            System.out.println("   Frequent client: " + (owner.isFrequentClient() ? "Yes 🌟" : "No"));
        }
    }



    private void addVeterinarian() throws InvalidInputException {
        System.out.println("\n--- ADD VETERINARIAN ---");
        int id = readInt("Enter Vet ID: ");
        String name = readNonEmptyString("Enter Vet Name: ");
        String specialization = readNonEmptyString("Enter Specialization (Dog/Cat/etc): ");
        int experience = readInt("Enter Experience (years): ");

        Veterinarian vet = new Veterinarian(id, name, specialization, experience);
        veterinarians.add(vet);
        people.add(vet);

        System.out.println("Veterinarian added successfully! ✅");
    }

    private void viewAllVeterinarians() {
        System.out.println("\n========== ALL VETERINARIANS ==========");
        if (veterinarians.isEmpty()) {
            System.out.println("No veterinarians found.");
            return;
        }

        for (int i = 0; i < veterinarians.size(); i++) {
            Veterinarian vet = veterinarians.get(i);
            System.out.println((i + 1) + ". " + vet);
            System.out.println("   Experienced: " + (vet.isExperienced() ? "Yes ✅" : "No ❌"));
        }
    }



    private void viewAllPeoplePolymorphism() {
        System.out.println("\n========== ALL PEOPLE (POLYMORPHISM) ==========");
        if (people.isEmpty()) {
            System.out.println("No people found.");
            return;
        }

        for (int i = 0; i < people.size(); i++) {
            ClinicPerson person = people.get(i);
            System.out.println((i + 1) + ". " + person.getRoleInfo());
        }
    }

    private void demonstrateInstanceofCasting() {
        System.out.println("\n========== instanceof + CASTING DEMO ==========");
        if (people.isEmpty()) {
            System.out.println("No people found.");
            return;
        }

        for (ClinicPerson person : people) {
            System.out.println("\nPerson: " + person.getName() + " (id=" + person.getId() + ")");

            if (person instanceof Veterinarian) {
                Veterinarian vet = (Veterinarian) person;
                System.out.println("Type: Veterinarian ✅");
                System.out.println("Specialization: " + vet.getSpecialization());
                System.out.println("Experience: " + vet.getExperience());
            } else if (person instanceof Owner) {
                Owner owner = (Owner) person;
                System.out.println("Type: Owner ✅");
                System.out.println("Phone: " + owner.getPhone());
                System.out.println("Number of pets: " + owner.getNumberOfPets());
            } else {
                System.out.println("Type: Unknown ClinicPerson");
            }
        }
    }



    private void printFinalState() {
        System.out.println("\n========== FINAL STATE ==========");

        System.out.println("\nPets:");
        if (pets.isEmpty()) System.out.println("No pets.");
        else for (Pet p : pets) System.out.println(p);

        System.out.println("\nOwners:");
        if (owners.isEmpty()) System.out.println("No owners.");
        else for (Owner o : owners) System.out.println(o);

        System.out.println("\nVeterinarians:");
        if (veterinarians.isEmpty()) System.out.println("No veterinarians.");
        else for (Veterinarian v : veterinarians) System.out.println(v);

        System.out.println("\nPeople (polymorphic list): " + people.size());
    }
}
