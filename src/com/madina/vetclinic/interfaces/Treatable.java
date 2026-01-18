package com.madina.vetclinic.interfaces;

import com.madina.vetclinic.model.Pet;

public interface Treatable {
    boolean canTreat(Pet pet);
}
