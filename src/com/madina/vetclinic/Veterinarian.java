package com.madina.vetclinic;

public class Veterinarian {
    private int vetId;
    private String name;
    private String specialization;
    private int experience;

    public Veterinarian(int vetId, String name, String specialization, int experience){
        this.vetId=vetId;
        this.name=name;
        this.specialization=specialization;
        this.experience=experience;
    }

    public Veterinarian() {
        this.vetId = 0;
        this.name = "Unknown";
        this.specialization = "General";
        this.experience = 0;
    }


    public int getVetId() {
        return vetId;
    }

    public void setVerId(int vetId) {
        this.vetId = vetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean canTreat(Pet pet){
        return specialization.equalsIgnoreCase(pet.getSpecies());
    }

    public boolean isExperienced(){
        return experience >=5;
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
