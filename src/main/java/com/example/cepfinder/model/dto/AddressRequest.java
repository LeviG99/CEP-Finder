package com.example.cepfinder.model.dto;


import io.swagger.annotations.ApiModelProperty;

public class AddressRequest {

    public AddressRequest(String cep){
      this.cep = cep;
    };
    @ApiModelProperty(notes= "CEP", example = "01001000")
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
