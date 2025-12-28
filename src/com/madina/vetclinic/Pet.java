package com.madina.vetclinic;

public class Pet {
    private int petId;
    private String name;
    private String species;
    private int age;
    private String ownerName;


    public Pet() {
        this.petId = 0;
        this.name = "Unknown";
        this.species = "Unknown";
        this.age = 0;
        this.ownerName = "Unknown";
    }


    public Pet(int petId, String name, String species, int age, String ownerName) {
        setPetId(petId);
        setName(name);
        setSpecies(species);
        setAge(age);
        setOwnerName(ownerName);
    }


    public int getPetId() { return petId; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public String getOwnerName() { return ownerName; }


    public void setPetId(int petId) {
        if (petId > 0) this.petId = petId;
        else {
            System.out.println("Warning: petId must be positive! Setting to 0.");
            this.petId = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name.trim();
        else System.out.println("Warning: Pet name cannot be empty!");
    }

    public void setSpecies(String species) {
        if (species != null && !species.trim().isEmpty()) this.species = species.trim();
        else System.out.println("Warning: Species cannot be empty!");
    }

    public void setAge(int age) {
        if (age >= 0) this.age = age;
        else {
            System.out.println("Warning: Age cannot be negative! Setting to 0.");
            this.age = 0;
        }
    }

    public void setOwnerName(String ownerName) {
        if (ownerName != null && !ownerName.trim().isEmpty()) this.ownerName = ownerName.trim();
        else System.out.println("Warning: Owner name cannot be empty!");
    }


    public boolean isYoung() { return age < 2; }

    public String getLifeStage() {
        if (age < 2) return "Young";
        else if (age <= 7) return "Adult";
        else return "Senior";
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
