package com.example.cepfinder.model.dto;


import io.swagger.annotations.ApiModelProperty;

public class AddressRequest {

    @ApiModelProperty(notes= "CEP", example = "01001000")
    private String CEP;
    public AddressRequest(String CEP){
      this.CEP = CEP;
    };
    public AddressRequest(){};

    public String getCEP() {
        return CEP;
    }
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
