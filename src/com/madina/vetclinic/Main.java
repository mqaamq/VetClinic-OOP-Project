package com.madina.vetclinic;

public class Main {
    public static void main(String[] args) {

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

        Developed by: Madina Yerzhimbay
        Course: Object-Oriented Programming (OOP)
        """);
        System.out.println();

        Pet pet1 = new Pet (1,"Rex", "Dog",3,"Balausa");
        Pet pet2= new Pet(2, "Snezhok", "Cat", 1, "Zhanerke");
        Pet pet3 = new Pet(3, "Kitya", "Cat", 2, "Zarina");

        Owner owner1=new Owner(1, "Balausa", "+7 777 777 77 77", 1 );
        Owner owner2=new Owner(2,"Zhanerke","+7 707 707 77 77", 1);
        Owner owner3=new Owner(3,"Zarina","+7 747 747 77 77", 1);

        Veterinarian vet1=new Veterinarian(1,"Dr. Kang", "Dog", 6);
        Veterinarian vet2=new Veterinarian(2,"Dr. Smith","Cat",4);

        //Display All Objects
        System.out.println("--- Pets ---");
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);
        System.out.println();

        System.out.println("--- Owners ---");
        System.out.println(owner1);
        System.out.println(owner2);
        System.out.println(owner3);
        System.out.println();

        System.out.println("--- Veterinarians ---");
        System.out.println(vet1);
        System.out.println(vet2);
        System.out.println();


        //Testing getters
        System.out.println("--- TESTING GETTERS ---");
        System.out.println("Pet 1 name: " + pet1.getName());
        System.out.println("Pet 1 species: " + pet1.getSpecies());
        System.out.println("Pet 1 age: " + pet1.getAge());
        System.out.println("Pet 1 life stage: " + pet1.getLifeStage());

        System.out.println("Owner 1 name: " + owner1.getName());
        System.out.println("Owner 1 number of pets: " + owner1.getNumberOfPets());

        System.out.println("Vet 1 name: " + vet1.getName());
        System.out.println("Vet 1 experienced: " + vet1.isExperienced());
        System.out.println();


        //Testing setters
        System.out.println("--- TESTING SETTERS ---");
        System.out.println("Updating pet3...");
        pet3.setName("Max");
        pet3.setAge(10);
        pet3.setSpecies("Dog");
        System.out.println("Updated: " + pet3);
        System.out.println();

        System.out.println("Updating owner2...");
        owner2.setPhone("+7 705 111 22 33");
        owner2.addPet();
        System.out.println("Updated: " + owner2);
        System.out.println();

        System.out.println("Updating veterinarian...");
        vet2.setExperience(6);
        System.out.println("Updated: " + vet2);
        System.out.println();


        //Test add. methods
        System.out.println("--- TESTING PET METHODS ---");
        System.out.println(pet1.getName() + " is young: " + pet1.isYoung());
        System.out.println(pet3.getName() + " life stage: " + pet3.getLifeStage());
        System.out.println();


        System.out.println("--- TESTING OWNER METHODS ---");
        System.out.println(owner1.getName() + " is frequent client: " + owner1.isFrequentClient());
        System.out.println(owner2.getName() + " is frequent client: " + owner2.isFrequentClient());
        System.out.println();
        System.out.println("Adding a pet to " + owner2.getName());
        owner2.addPet();
        System.out.println(owner2.getName() + " number of pets: " + owner2.getNumberOfPets());
        System.out.println(owner2.getName() + " is frequent client: " + owner2.isFrequentClient());
        System.out.println();


        System.out.println("--- TESTING VETERINARIAN METHODS ---");
        System.out.println("Can " + vet1.getName() + " treat " + pet1.getName() + ": "
                + vet1.canTreat(pet1));
        System.out.println("Can " + vet2.getName() + " treat " + pet1.getName() + ": "
                + vet2.canTreat(pet1));
        System.out.println(vet2.getName() + " is experienced: " + vet2.isExperienced());
        System.out.println();

        // Testing default const-s
        System.out.println("--- TESTING DEFAULT CONSTRUCTORS ---");

        Pet defaultPet = new Pet();
        Owner defaultOwner = new Owner();
        Veterinarian defaultVet = new Veterinarian();

        System.out.println(defaultPet);
        System.out.println(defaultOwner);
        System.out.println(defaultVet);

        System.out.println();


        //final summary
        System.out.println("--- FINAL STATE ---");
        System.out.println("Pets:");
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);
        System.out.println();

        System.out.println("Owners:");
        System.out.println(owner1);
        System.out.println(owner2);
        System.out.println(owner3);
        System.out.println();

        System.out.println("Veterinarians:");
        System.out.println(vet1);
        System.out.println(vet2);

        System.out.println("\n=== Program Complete ===");
    }
}
