package com.example.cepfinder.controller;

import com.example.cepfinder.model.dto.AddressRequest;
import com.example.cepfinder.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1")
@Api(value = "API REST de consulta de fretes por CEP utilizando viacep")
@CrossOrigin(origins = "*")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/consulta-endereco")
    @ApiOperation(value = "Retorna as informações relacionadas ao cep juntamente com o frete para este cep")
    public ResponseEntity requestCEP(@RequestBody AddressRequest addressRequest){
        return ResponseEntity.ok(addressService.execute(addressRequest));
    };

}
