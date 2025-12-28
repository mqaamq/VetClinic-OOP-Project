package com.madina.vetclinic;

public class Veterinarian {
    private int vetId;
    private String name;
    private String specialization;
    private int experience;


    public Veterinarian() {
        this.vetId = 0;
        this.name = "Unknown";
        this.specialization = "General";
        this.experience = 0;
    }


    public Veterinarian(int vetId, String name, String specialization, int experience) {
        setVetId(vetId);
        setName(name);
        setSpecialization(specialization);
        setExperience(experience);
    }


    public int getVetId() { return vetId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public int getExperience() { return experience; }


    public void setVetId(int vetId) {
        if (vetId > 0) this.vetId = vetId;
        else {
            System.out.println("Warning: vetId must be positive! Setting to 0.");
            this.vetId = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name.trim();
        else System.out.println("Warning: Vet name cannot be empty!");
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.trim().isEmpty())
            this.specialization = specialization.trim();
        else System.out.println("Warning: Specialization cannot be empty!");
    }

    public void setExperience(int experience) {
        if (experience >= 0) this.experience = experience;
        else {
            System.out.println("Warning: Experience cannot be negative! Setting to 0.");
            this.experience = 0;
        }
    }


    public boolean canTreat(Pet pet) {
        return specialization.equalsIgnoreCase(pet.getSpecies());
    }

    public boolean isExperienced() {
        return experience >= 5;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "vetId=" + vetId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience=" + experience +
                '}';
    }
}
