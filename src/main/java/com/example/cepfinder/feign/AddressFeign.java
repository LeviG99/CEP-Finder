package com.example.cepfinder.feign;

import com.example.cepfinder.model.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface AddressFeign {

    @RequestMapping(method = RequestMethod.GET, value = "{cep}/json", produces = "application/json")
    AddressResponse findAddressCep(@PathVariable("cep") String cep);

}
