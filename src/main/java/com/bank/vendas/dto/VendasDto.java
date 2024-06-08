package com.bank.vendas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VendasDto {

    @NotBlank
    private String produto;
    @NotBlank
    private String nome;
    @NotBlank
    @Size(min = 6, max = 6)
    private String matricula;

    public @NotBlank String getProduto() {
        return produto;
    }

    public void setProduto(@NotBlank String produto) {
        this.produto = produto;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank @Size(max = 6) String getMatricula() {
        return matricula;
    }

    public void setMatricula(@NotBlank @Size(max = 6) String matricula) {
        this.matricula = matricula;
    }
}
