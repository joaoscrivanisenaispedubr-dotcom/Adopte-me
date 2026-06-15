package com.pbe.adopt.me.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "pet")

public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    private Integer idade;
    private Integer data_nasc;
    private String raca;
    private String caracteristica;
    private String porte;
    private String doencas;
    private String vacinacao;
    private String hist_retorno;
    private String sexo;
    private String comprovante_de_residencia;
    private String foto;

    // Getter e Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Integer data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public String getVacinacao() {
        return vacinacao;
    }

    public void setVacinacao(String vacinacao) {
        this.vacinacao = vacinacao;
    }

    public String getHist_retorno() {
        return hist_retorno;
    }

    public void setHist_retorno(String hist_retorno) {
        this.hist_retorno = hist_retorno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getComprovante_de_residencia() {
        return comprovante_de_residencia;
    }

    public void setComprovante_de_residencia(String comprovante_de_residencia) {
        this.comprovante_de_residencia = comprovante_de_residencia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
