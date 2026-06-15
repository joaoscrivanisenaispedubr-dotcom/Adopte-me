package com.pbe.adopt.me.Repository;

import com.pbe.adopt.me.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
