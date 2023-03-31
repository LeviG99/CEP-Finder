package com.example.cepfinder.service;

import com.example.cepfinder.exceptions.InvalidCepException;
import com.example.cepfinder.exceptions.NotFoundException;
import com.example.cepfinder.feign.AddressFeign;
import com.example.cepfinder.model.dto.AddressRequest;
import com.example.cepfinder.model.dto.AddressResponse;
import org.springframework.stereotype.Service;

import static com.example.cepfinder.enums.regiaoEnum.*;


@Service
public class AddressService {

    private final AddressFeign addressFeign;


    public AddressService(AddressFeign addressFeign) {
        this.addressFeign = addressFeign;
    }


    public AddressResponse execute (AddressRequest request){
        if(!validaCep(request.getCep())){
            throw new InvalidCepException("O formato do CEP inserido está incorreto.");
        }
        AddressResponse response = addressFeign.findAddressCep(request.getCep());
        response.setFrete(calculaFrete(response.getEstado()));
        if(response.getFrete() == 0.0){
            throw new NotFoundException("O CEP inserido não foi encontrado.");
        }
        return response;
    }

    private double calculaFrete(String estado){
        if(SUDESTE.getEstados().contains(estado)) return SUDESTE.getValue();
        else if(CENTRO_OESTE.getEstados().contains(estado)) return CENTRO_OESTE.getValue();
        else if(NORDESTE.getEstados().contains(estado)) return NORDESTE.getValue();
        else if (SUL.getEstados().contains(estado)) return SUL.getValue();
        else if (NORTE.getEstados().contains(estado)) return NORTE.getValue();
        else return 0.0;
    };

    private boolean validaCep(String cep){
      if(cep.length() == 9){
         if(cep.contains("-")){
           String numericCep = cep.replace("-","");
           try{
               Integer.parseInt(numericCep);
           } catch (NumberFormatException nfe){
               return false;
           }
           return true;
         };
      };
      if (cep.length() == 8){
          try{
              Integer.parseInt(cep);
          } catch (NumberFormatException nfe){
              return false;
          }
          return true;
        };
      return false;
    };
}
