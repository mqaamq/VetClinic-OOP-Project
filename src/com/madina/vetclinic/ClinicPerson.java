package com.madina.vetclinic;

public class ClinicPerson {
    protected int id;
    protected String name;


    public ClinicPerson() {
        this.id = 0;
        this.name = "Unknown";
    }


    public ClinicPerson(int id, String name) {
        setId(id);
        setName(name);
    }


    public int getId() { return id; }
    public String getName() { return name; }


    public void setId(int id) {
        if (id > 0) this.id = id;
        else {
            System.out.println("Warning: id must be positive! Setting to 0.");
            this.id = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name.trim();
        else System.out.println("Warning: name cannot be empty!");
    }


    public String getRoleInfo() {
        return "Clinic person: " + name;
    }

    @Override
    public String toString() {
        return "ClinicPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
