package com.madina.vetclinic;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Owner> owners = new ArrayList<>();
    private static ArrayList<Veterinarian> veterinarians = new ArrayList<>();


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


                case 7 -> runAssignment1Testing();


                case 8 -> printFinalState();

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
        System.out.println("7. Run Assignment 1 Testing (Get/Set/Methods)");
        System.out.println("8. View Final State");
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
        scanner.nextLine(); // consume newline
        return value;
    }



    private static void seedTestData() {

        pets.add(new Pet(1, "Rex", "Dog", 3, "Balausa"));
        pets.add(new Pet(2, "Snezhok", "Cat", 1, "Zhanerke"));
        pets.add(new Pet(3, "Kitya", "Cat", 2, "Zarina"));


        owners.add(new Owner(1, "Balausa", "+7 777 777 77 77", 1));
        owners.add(new Owner(2, "Zhanerke", "+7 707 707 77 77", 1));
        owners.add(new Owner(3, "Zarina", "+7 747 747 77 77", 1));


        veterinarians.add(new Veterinarian(1, "Dr. Kang", "Dog", 6));
        veterinarians.add(new Veterinarian(2, "Dr. Smith", "Cat", 4));
    }

    private static void printWelcomeMessage() {
        System.out.println("""
                === Welcome to the Veterinary Clinic Management System ===
                This project focuses on managing veterinary clinic operations efficiently.
                Our system helps automate pet registration, appointment scheduling, and medical record tracking.
                Main features we plan to implement:
                    1. Pet registration and owner information management
                    2. Veterinarian appointment scheduling
                    3. Medical history and treatment record tracking
                    4. Billing and payment processing
                    5. Inventory management for medicines and supplies
                

                Week 3 Improvements:
                - Encapsulation with validation (in setters/constructors)
                - ArrayList storage for multiple objects
                - Console menu for Add/View operations

                Developed by: Madina Yerzhimbay
                Course: Object-Oriented Programming (OOP)
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
        System.out.println("\n========================================");
        System.out.println("                ALL PETS");
        System.out.println("========================================");

        if (pets.isEmpty()) {
            System.out.println("No pets found.");
            return;
        }

        System.out.println("Total pets: " + pets.size());
        System.out.println();

        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            System.out.println((i + 1) + ". " + pet);
            System.out.println("   Life stage: " + pet.getLifeStage());
            System.out.println("   Young: " + (pet.isYoung() ? "Yes ✅" : "No ❌"));
            System.out.println();
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

        System.out.println("\nOwner added successfully! ✅");
    }

    private static void viewAllOwners() {
        System.out.println("\n========================================");
        System.out.println("               ALL OWNERS");
        System.out.println("========================================");

        if (owners.isEmpty()) {
            System.out.println("No owners found.");
            return;
        }

        System.out.println("Total owners: " + owners.size());
        System.out.println();

        for (int i = 0; i < owners.size(); i++) {
            Owner owner = owners.get(i);
            System.out.println((i + 1) + ". " + owner);
            System.out.println("   Frequent client: " + (owner.isFrequentClient() ? "Yes 🌟" : "No"));
            System.out.println();
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

        System.out.println("\nVeterinarian added successfully! ✅");
    }

    private static void viewAllVeterinarians() {
        System.out.println("\n========================================");
        System.out.println("            ALL VETERINARIANS");
        System.out.println("========================================");

        if (veterinarians.isEmpty()) {
            System.out.println("No veterinarians found.");
            return;
        }

        System.out.println("Total veterinarians: " + veterinarians.size());
        System.out.println();

        for (int i = 0; i < veterinarians.size(); i++) {
            Veterinarian vet = veterinarians.get(i);
            System.out.println((i + 1) + ". " + vet);
            System.out.println("   Experienced: " + (vet.isExperienced() ? "Yes ✅" : "No ❌"));
            System.out.println();
        }
    }



    private static void runAssignment1Testing() {
        System.out.println("\n========================================");
        System.out.println("     ASSIGNMENT 1 TESTING SECTION");
        System.out.println("========================================");

        if (pets.isEmpty() || owners.isEmpty() || veterinarians.isEmpty()) {
            System.out.println("Not enough test data to run testing.");
            return;
        }


        Pet pet1 = pets.get(0);
        Pet pet2 = pets.size() > 1 ? pets.get(1) : pets.get(0);
        Pet pet3 = pets.size() > 2 ? pets.get(2) : pets.get(0);

        Owner owner1 = owners.get(0);
        Owner owner2 = owners.size() > 1 ? owners.get(1) : owners.get(0);
        Owner owner3 = owners.size() > 2 ? owners.get(2) : owners.get(0);

        Veterinarian vet1 = veterinarians.get(0);
        Veterinarian vet2 = veterinarians.size() > 1 ? veterinarians.get(1) : veterinarians.get(0);


        System.out.println("\n--- Pets ---");
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);

        System.out.println("\n--- Owners ---");
        System.out.println(owner1);
        System.out.println(owner2);
        System.out.println(owner3);

        System.out.println("\n--- Veterinarians ---");
        System.out.println(vet1);
        System.out.println(vet2);


        System.out.println("\n--- TESTING GETTERS ---");
        System.out.println("Pet 1 name: " + pet1.getName());
        System.out.println("Pet 1 species: " + pet1.getSpecies());
        System.out.println("Pet 1 age: " + pet1.getAge());
        System.out.println("Pet 1 life stage: " + pet1.getLifeStage());

        System.out.println("Owner 1 name: " + owner1.getName());
        System.out.println("Owner 1 number of pets: " + owner1.getNumberOfPets());

        System.out.println("Vet 1 name: " + vet1.getName());
        System.out.println("Vet 1 experienced: " + vet1.isExperienced());


        System.out.println("\n--- TESTING SETTERS ---");
        System.out.println("Updating pet3...");
        pet3.setName("Max");
        pet3.setAge(10);
        pet3.setSpecies("Dog");
        System.out.println("Updated: " + pet3);

        System.out.println("\nUpdating owner2...");
        owner2.setPhone("+7 705 111 22 33");
        owner2.addPet();
        System.out.println("Updated: " + owner2);

        System.out.println("\nUpdating veterinarian...");
        vet2.setExperience(6);
        System.out.println("Updated: " + vet2);


        System.out.println("\n--- TESTING PET METHODS ---");
        System.out.println(pet1.getName() + " is young: " + pet1.isYoung());
        System.out.println(pet3.getName() + " life stage: " + pet3.getLifeStage());

        System.out.println("\n--- TESTING OWNER METHODS ---");
        System.out.println(owner1.getName() + " is frequent client: " + owner1.isFrequentClient());
        System.out.println(owner2.getName() + " is frequent client: " + owner2.isFrequentClient());

        System.out.println("\nAdding a pet to " + owner2.getName());
        owner2.addPet();
        System.out.println(owner2.getName() + " number of pets: " + owner2.getNumberOfPets());
        System.out.println(owner2.getName() + " is frequent client: " + owner2.isFrequentClient());

        System.out.println("\n--- TESTING VETERINARIAN METHODS ---");
        System.out.println("Can " + vet1.getName() + " treat " + pet1.getName() + ": " + vet1.canTreat(pet1));
        System.out.println("Can " + vet2.getName() + " treat " + pet1.getName() + ": " + vet2.canTreat(pet1));
        System.out.println(vet2.getName() + " is experienced: " + vet2.isExperienced());

        System.out.println("\n=== Assignment 1 Testing Complete ===");
    }



    private static void printFinalState() {
        System.out.println("\n========================================");
        System.out.println("               FINAL STATE");
        System.out.println("========================================");

        System.out.println("\nPets:");
        if (pets.isEmpty()) System.out.println("No pets.");
        else for (Pet p : pets) System.out.println(p);

        System.out.println("\nOwners:");
        if (owners.isEmpty()) System.out.println("No owners.");
        else for (Owner o : owners) System.out.println(o);

        System.out.println("\nVeterinarians:");
        if (veterinarians.isEmpty()) System.out.println("No veterinarians.");
        else for (Veterinarian v : veterinarians) System.out.println(v);

        System.out.println("\n=== Program State Printed ===");
    }
}
