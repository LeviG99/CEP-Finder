package com.example.cepfinder.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressResponse {

    @JsonProperty("cep")
    private String CEP;
    @JsonProperty("rua")
    private String street;
    @JsonProperty("complemento")
    private String complement;
    @JsonProperty("bairro")
    private String district;
    @JsonProperty("cidade")
    private String city;
    @JsonProperty("estado")
    private String state;
    @JsonProperty("frete")
    private double shipping;

    public AddressResponse(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, double frete) {
        this.CEP = cep;
        this.street = logradouro;
        this.complement = complemento;
        this.district = bairro;
        this.city = localidade;
        this.state = uf;
        this.shipping = frete;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }
}
