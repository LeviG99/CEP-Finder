package mocks;

import com.example.cepfinder.feign.AddressFeign;
import com.example.cepfinder.model.dto.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public class AddressFeignMock implements AddressFeign {

    @Override
    public AddressResponse findAddressCep(String cep) {
        if(cep.equals("00000-000")){
          return new AddressResponse("","","","","","",0.0);
        };
        return new AddressResponse("01001-000","Praça da Sé", "lado ímpar","Sé","São Paulo","SP",7.85);
    }
}
