package com.bank.vendas.repositories;

import com.bank.vendas.models.VendasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VendasRepository extends JpaRepository<VendasModel, UUID> {

    List<VendasModel> findByMatricula(String matricula);


}
