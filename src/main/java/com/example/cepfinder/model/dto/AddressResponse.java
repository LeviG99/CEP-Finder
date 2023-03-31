package com.example.cepfinder.model.dto;

public class AddressResponse {

    private String cep;
    private String rua;

    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    private double frete;

    public AddressResponse(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, double frete) {
        this.cep = cep;
        this.rua = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = localidade;
        this.estado = uf;
        this.frete = frete;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }
}
