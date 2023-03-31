package com.example.cepfinder.feign;

import com.example.cepfinder.model.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface AddressFeign {

    @GetMapping("{cep}/json")
    AddressResponse findAddressCep(@PathVariable("cep") String cep);

}
