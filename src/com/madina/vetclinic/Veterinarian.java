package com.madina.vetclinic;

public class Veterinarian extends ClinicPerson {
    private String specialization;
    private int experience;


    public Veterinarian() {
        super();
        this.specialization = "General";
        this.experience = 0;
    }


    public Veterinarian(int vetId, String name, String specialization, int experience) {
        super(vetId, name);
        setSpecialization(specialization);
        setExperience(experience);
    }

    public String getSpecialization() { return specialization; }
    public int getExperience() { return experience; }


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
    public String getRoleInfo() {
        return "Veterinarian: " + name + " | " + specialization + " specialist";
    }


    @Override
    public String toString() {
        return "Veterinarian{" +
                "vetId=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience=" + experience +
                '}';
    }
}
