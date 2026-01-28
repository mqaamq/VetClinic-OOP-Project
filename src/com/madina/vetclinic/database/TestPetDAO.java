package com.madina.vetclinic.database;

import com.madina.vetclinic.database.PetDAO;
import com.madina.vetclinic.model.Pet;

public class TestPetDAO {
    public static void main(String[] args) {

        PetDAO dao = new PetDAO();

        System.out.println("All pets in database:");
        dao.getAllPets();
    }
}


