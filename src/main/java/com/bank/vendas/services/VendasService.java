package com.bank.vendas.services;

import com.bank.vendas.models.VendasModel;
import com.bank.vendas.repositories.VendasRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VendasService {

    final VendasRepository vendasRepository;

    public VendasService(VendasRepository vendasRepository) {
        this.vendasRepository = vendasRepository;
    }

    @Transactional
    public VendasModel save(VendasModel vendasModel) {
        return vendasRepository.save(vendasModel);
    }

    public List<VendasModel> findAll() {
        return vendasRepository.findAll();
    }

    public List<VendasModel> findAllMatricula(String matricula) {
        return vendasRepository.findByMatricula(matricula);
    }


    public Optional<VendasModel> findById(UUID id) {
        return vendasRepository.findById(id);
    }

    @Transactional
    public void delete(VendasModel vendasModel) {
        vendasRepository.delete(vendasModel);
    }
}
