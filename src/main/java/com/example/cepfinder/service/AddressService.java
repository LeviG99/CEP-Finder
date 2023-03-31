package com.example.cepfinder.service;

import com.example.cepfinder.enums.RegionEnum;
import com.example.cepfinder.exceptions.InvalidCepException;
import com.example.cepfinder.exceptions.NotFoundException;
import com.example.cepfinder.exceptions.UnknownException;
import com.example.cepfinder.feign.AddressFeign;
import com.example.cepfinder.model.dto.AddressRequest;
import com.example.cepfinder.model.dto.AddressResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class AddressService {

    private final AddressFeign addressFeign;
    private final String regex = "^\\d{5}-?\\d{3}$";
    private final Pattern pattern = Pattern.compile(regex);


    public AddressService(AddressFeign addressFeign) {
        this.addressFeign = addressFeign;
    }


    public AddressResponse execute (AddressRequest request){
        if(!validateCep(request.getCEP())){
            throw new InvalidCepException("O formato do CEP inserido está incorreto.");
        }
        try {
            AddressResponse response = addressFeign.findAddressCep(request.getCEP());
            response.setShipping(calculateShipping(response.getState()));
            if(response.getShipping() == 0.0){
                throw new NotFoundException("O CEP inserido não foi encontrado.");
            }
            return response;
        } catch (NotFoundException ex) {
            throw ex;
        } catch (Exception ex){
            throw new UnknownException("Erro desconhecido");
        }
    }

    private double calculateShipping(String state){
        return Arrays.stream(RegionEnum.values())
                .filter(region -> region.getStates().contains(state))
                .mapToDouble(RegionEnum::getValue)
                .findFirst()
                .orElse(0.0);
    };

    private boolean validateCep(String cep){
        Matcher matcher = pattern.matcher(cep);
        return matcher.matches();
    }
}
