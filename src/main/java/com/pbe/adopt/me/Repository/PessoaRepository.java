package com.pbe.adopt.me.Repository;

import com.pbe.adopt.me.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
