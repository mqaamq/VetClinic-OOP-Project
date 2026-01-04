package com.madina.vetclinic;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Owner> owners = new ArrayList<>();
    private static ArrayList<Veterinarian> veterinarians = new ArrayList<>();

    private static ArrayList<ClinicPerson> people = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedTestData();
        printWelcomeMessage();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = readInt();

            switch (choice) {
                case 1 -> addPet();
                case 2 -> viewAllPets();
                case 3 -> addOwner();
                case 4 -> viewAllOwners();
                case 5 -> addVeterinarian();
                case 6 -> viewAllVeterinarians();
                case 7 -> viewAllPeoplePolymorphism();
                case 8 -> demonstrateInstanceofCasting();

                case 0 -> {
                    System.out.println("\nGoodbye! 👋");
                    running = false;
                }
                default -> System.out.println("\nInvalid choice! ❌ Please try again.");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
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
        System.out.println("8. instanceof + Casting Demo");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Enter a number: ");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static void seedTestData() {
        pets.add(new Pet(1, "Rex", "Dog", 3, "Balausa"));
        pets.add(new Pet(2, "Snezhok", "Cat", 1, "Zhanerke"));
        pets.add(new Pet(3, "Kitya", "Cat", 2, "Zarina"));

        Owner o1 = new Owner(1, "Balausa", "+7 777 777 77 77", 1);
        Owner o2 = new Owner(2, "Zhanerke", "+7 707 707 77 77", 1);
        Owner o3 = new Owner(3, "Zarina", "+7 747 747 77 77", 1);
        owners.add(o1); owners.add(o2); owners.add(o3);

        Veterinarian v1 = new Veterinarian(1, "Dr. Kang", "Dog", 6);
        Veterinarian v2 = new Veterinarian(2, "Dr. Smith", "Cat", 4);
        veterinarians.add(v1); veterinarians.add(v2);

        people.add(o1);
        people.add(o2);
        people.add(o3);
        people.add(v1);
        people.add(v2);
    }

    private static void printWelcomeMessage() {
        System.out.println("""
                === Welcome to the Veterinary Clinic Management System ===
                Week 4 Topics:
                - Inheritance: ClinicPerson -> Owner, Veterinarian
                - Polymorphism: ArrayList<ClinicPerson> stores different child objects
                - instanceof + Casting demonstration
                """);
    }


    private static void addPet() {
        System.out.println("\n--- ADD PET ---");

        System.out.print("Enter Pet ID: ");
        int id = readInt();

        System.out.print("Enter Pet Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Species (Dog/Cat/etc): ");
        String species = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = readInt();

        System.out.print("Enter Owner Name: ");
        String ownerName = scanner.nextLine();

        Pet pet = new Pet(id, name, species, age, ownerName);
        pets.add(pet);

        System.out.println("\nPet added successfully! ✅");
    }

    private static void viewAllPets() {
        System.out.println("\n========== ALL PETS ==========");
        if (pets.isEmpty()) {
            System.out.println("No pets found.");
            return;
        }
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            System.out.println((i + 1) + ". " + pet);
            System.out.println("   Life stage: " + pet.getLifeStage());
        }
    }


    private static void addOwner() {
        System.out.println("\n--- ADD OWNER ---");

        System.out.print("Enter Owner ID: ");
        int id = readInt();

        System.out.print("Enter Owner Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Number of Pets: ");
        int numberOfPets = readInt();

        Owner owner = new Owner(id, name, phone, numberOfPets);
        owners.add(owner);
        people.add(owner);

        System.out.println("\nOwner added successfully! ✅");
    }

    private static void viewAllOwners() {
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

    private static void addVeterinarian() {
        System.out.println("\n--- ADD VETERINARIAN ---");

        System.out.print("Enter Vet ID: ");
        int id = readInt();

        System.out.print("Enter Vet Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Specialization (Dog/Cat/etc): ");
        String specialization = scanner.nextLine();

        System.out.print("Enter Experience (years): ");
        int experience = readInt();

        Veterinarian vet = new Veterinarian(id, name, specialization, experience);
        veterinarians.add(vet);
        people.add(vet);

        System.out.println("\nVeterinarian added successfully!");
    }

    private static void viewAllVeterinarians() {
        System.out.println("\n====== ALL VETERINARIANS ======");
        if (veterinarians.isEmpty()) {
            System.out.println("No veterinarians found.");
            return;
        }
        for (int i = 0; i < veterinarians.size(); i++) {
            Veterinarian vet = veterinarians.get(i);
            System.out.println((i + 1) + ". " + vet);
            System.out.println("   Experienced: " + (vet.isExperienced() ? "Yes" : "No"));
        }
    }

    private static void viewAllPeoplePolymorphism() {
        System.out.println("\n====== ALL PEOPLE (POLYMORPHISM) ======");
        if (people.isEmpty()) {
            System.out.println("No people found.");
            return;
        }

        for (int i = 0; i < people.size(); i++) {
            ClinicPerson person = people.get(i);
            System.out.println((i + 1) + ". " + person.getRoleInfo());
        }
    }

    private static void demonstrateInstanceofCasting() {
        System.out.println("\n====== instanceof + CASTING DEMO ======");

        for (ClinicPerson person : people) {
            System.out.println("\nPerson: " + person.getName());

            if (person instanceof Veterinarian) {
                Veterinarian vet = (Veterinarian) person;
                System.out.println("Type: Veterinarian");
                System.out.println("Specialization: " + vet.getSpecialization());
                System.out.println("Experience: " + vet.getExperience());
            } else if (person instanceof Owner) {
                Owner owner = (Owner) person;
                System.out.println("Type: Owner");
                System.out.println("Phone: " + owner.getPhone());
                System.out.println("Number of pets: " + owner.getNumberOfPets());
            } else {
                System.out.println("Type: ClinicPerson");
            }
        }
    }
}
