package com.madina.vetclinic;

public class Owner extends ClinicPerson {
    private String phone;
    private int numberOfPets;

    public Owner() {
        super();
        this.phone = "Not provided";
        this.numberOfPets = 0;
    }

    public Owner(int ownerId, String name, String phone, int numberOfPets) {
        super(ownerId, name);
        setPhone(phone);
        setNumberOfPets(numberOfPets);
    }

    public String getPhone() { return phone; }
    public int getNumberOfPets() { return numberOfPets; }

    public void setPhone(String phone) {
        if (phone != null && !phone.trim().isEmpty()) this.phone = phone.trim();
        else System.out.println("Warning: Phone cannot be empty!");
    }

    public void setNumberOfPets(int numberOfPets) {
        if (numberOfPets >= 0) this.numberOfPets = numberOfPets;
        else {
            System.out.println("Warning: numberOfPets cannot be negative! Setting to 0.");
            this.numberOfPets = 0;
        }
    }

    public void addPet() { numberOfPets++; }
    public boolean isFrequentClient() { return numberOfPets >= 3; }

    @Override
    public String getRoleInfo() {
        return "Owner: " + name + " | Pets: " + numberOfPets;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfPets=" + numberOfPets +
                '}';
    }
}
