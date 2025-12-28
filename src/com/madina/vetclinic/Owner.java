package com.madina.vetclinic;

public class Owner {
    private int ownerId;
    private String name;
    private String phone;
    private int numberOfPets;


    public Owner() {
        this.ownerId = 0;
        this.name = "Unknown";
        this.phone = "Not provided";
        this.numberOfPets = 0;
    }

    public Owner(int ownerId, String name, String phone, int numberOfPets) {
        setOwnerId(ownerId);
        setName(name);
        setPhone(phone);
        setNumberOfPets(numberOfPets);
    }


    public int getOwnerId() { return ownerId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getNumberOfPets() { return numberOfPets; }


    public void setOwnerId(int ownerId) {
        if (ownerId > 0) this.ownerId = ownerId;
        else {
            System.out.println("Warning: ownerId must be positive! Setting to 0.");
            this.ownerId = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name.trim();
        else System.out.println("Warning: Owner name cannot be empty!");
    }

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
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfPets=" + numberOfPets +
                '}';
    }
}
