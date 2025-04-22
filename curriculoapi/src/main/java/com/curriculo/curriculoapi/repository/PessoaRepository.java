package com.curriculo.curriculoapi.repository;

import com.curriculo.curriculoapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
