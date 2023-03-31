package com.example.cepfinder;

import com.example.cepfinder.exceptions.InvalidCepException;
import com.example.cepfinder.exceptions.NotFoundException;
import com.example.cepfinder.feign.AddressFeign;
import com.example.cepfinder.model.dto.AddressRequest;
import com.example.cepfinder.model.dto.AddressResponse;
import com.example.cepfinder.service.AddressService;
import mocks.AddressFeignMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CepFinderApplicationTests {

    @Mock
    AddressRequest addressRequest;

    @Mock
    AddressResponse addressResponse;

    @Mock
    AddressService addressService;

    @InjectMocks
    AddressFeignMock addressFeignMock;

    @BeforeEach
    public void setup(){
      addressRequest = new AddressRequest("01001000");
      addressResponse = new AddressResponse("01001-000","Praça da Sé", "lado ímpar","Sé","São Paulo","SP",7.85);
      addressService = new AddressService(addressFeignMock);
    };

    @Test
    public void calculaFrete(){
        assertEquals(addressService.execute(addressRequest).getFrete(),addressResponse.getFrete());
    };

    @Test
    public void cepInvalido(){
      addressRequest.setCep("0");
      assertThrows(InvalidCepException.class, () -> addressService.execute(addressRequest));
    };

    @Test
    public void cepNotFound(){
      addressRequest.setCep("00000-000");
      assertThrows(NotFoundException.class, () -> addressService.execute(addressRequest));
    };

}
