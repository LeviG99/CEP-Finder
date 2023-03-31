package com.example.cepfinder;

import com.example.cepfinder.exceptions.InvalidCepException;
import com.example.cepfinder.exceptions.NotFoundException;
import com.example.cepfinder.model.dto.AddressRequest;
import com.example.cepfinder.model.dto.AddressResponse;
import com.example.cepfinder.service.AddressService;
import mocks.AddressFeignMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class CepFinderApplicationTests {

    @Mock
    AddressRequest addressRequest;

    @Mock
    AddressResponse addressResponse;

    @InjectMocks
    AddressService addressService;

    @Mock
    AddressFeignMock addressFeignMock;

    @BeforeEach
    public void setup(){
      addressRequest = new AddressRequest("01001000");
      addressResponse = new AddressResponse("01001-000","Praça da Sé", "lado ímpar","Sé","São Paulo","SP",7.85);
      addressService = new AddressService(addressFeignMock);
    };

    @Test
    public void execute_mustReturnValidAddress_whenMethodCalledCorrectly(){
        AddressResponse addressResponse1 = new AddressResponse("01001-000","Praça da Sé", "lado ímpar","Sé","São Paulo","SP",7.85);
        when(addressFeignMock.findAddressCep(any())).thenReturn(addressResponse1);
        AddressResponse addressResponse2 = addressService.execute(addressRequest);
        verify(addressFeignMock,times(1)).findAddressCep(any());
        assertEquals(addressResponse1.getCEP(),addressResponse2.getCEP());
        assertEquals(addressResponse1.getCity(),addressResponse2.getCity());
        assertEquals(addressResponse1.getStreet(),addressResponse2.getStreet());
    }
    @Test
    public void execute_mustThrowInvalidCepException_whenMethodCalledWithInvalidCEP(){
      addressRequest.setCEP("0");
      assertThrows(InvalidCepException.class, () -> addressService.execute(addressRequest));
    };

    @Test
    public void execute_mustThrowNotFoundException_whenMethodCalledWithNotFoundCEP(){
        AddressResponse addressResponse1 = new AddressResponse("00000-000","", "","","","",0);
        when(addressFeignMock.findAddressCep(any())).thenReturn(addressResponse1);
        assertThrows(NotFoundException.class, () -> addressService.execute(addressRequest));
    };

}
