package com.bank.vendas.controllers;

import com.bank.vendas.dto.VendasDto;
import com.bank.vendas.models.VendasModel;
import com.bank.vendas.services.VendasService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class VendasController {

    final VendasService vendasService;

    public VendasController(VendasService vendasService) {
        this.vendasService = vendasService;
    }

    @PostMapping("/vendas")
    public ResponseEntity<Object> saveVendas(@RequestBody @Valid VendasDto vendasDto){
        var vendasModel = new VendasModel();
        BeanUtils.copyProperties(vendasDto, vendasModel);
        vendasModel.setData(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(vendasService.save(vendasModel));
    }

    @GetMapping("/vendas")
    public ResponseEntity<List<VendasModel>> getAllVendas(){
        List<VendasModel> vendasList = vendasService.findAll();
        if (!vendasList.isEmpty()){
            for (VendasModel vendas : vendasList){
                UUID id = vendas.getId();
                vendas.add(linkTo(methodOn(VendasController.class).getOneVenda(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(vendasList);
    }

    @GetMapping("/vendas/id/{id}")
    public ResponseEntity<Object> getOneVenda(@PathVariable(value = "id")UUID id){
        Optional<VendasModel> vendaModelOptional = vendasService.findById(id);
        if (!vendaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID da venda não encontrado!");
        }
        vendaModelOptional.get().add(linkTo(methodOn(VendasController.class).getAllVendas()).withRel("Vendas List"));
        return ResponseEntity.status(HttpStatus.OK).body(vendaModelOptional.get());
    }

    @GetMapping("/vendas/{matricula}")
    public ResponseEntity<List<VendasModel>> getAllVendasMatricula(@PathVariable(value = "matricula")String matricula){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.findAllMatricula(matricula));
    }

    @DeleteMapping("/vendas/{id}")
    public ResponseEntity<Object> deleteVendas(@PathVariable(value = "id")UUID id){
        Optional<VendasModel> vendasModelOptional = vendasService.findById(id);
        if (!vendasModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id da venda não localizado.");
        }
        vendasService.delete(vendasModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Venda deletada com sucesso.");
    }

    @PutMapping("/vendas/{id}")
    public ResponseEntity<Object> updateVendas(@PathVariable(value = "id")UUID id,
                                               @RequestBody @Valid VendasDto vendasDto){
        Optional<VendasModel> vendasModelOptional = vendasService.findById(id);
        if (!vendasModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id da venda não localizado.");
        }
        var vendasModel = new VendasModel();
        BeanUtils.copyProperties(vendasDto, vendasModel);
        vendasModel.setId(vendasModelOptional.get().getId());
        vendasModel.setData(vendasModelOptional.get().getData());
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.save(vendasModel));
    }

}
