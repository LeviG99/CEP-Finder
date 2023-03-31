package com.example.cepfinder;

import com.example.cepfinder.exceptions.InvalidCepException;
import com.example.cepfinder.exceptions.NotFoundException;
import com.example.cepfinder.exceptions.UnknownException;
import com.example.cepfinder.model.dto.AddressRequest;
import com.example.cepfinder.model.dto.AddressResponse;
import com.example.cepfinder.service.AddressService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CucumberSteps {

    private AddressService addressService;
    private AddressRequest addressRequest;
    private AddressResponse addressResponse;
    private Exception exception;

    public CucumberSteps(AddressService addressService) {
        this.addressService = addressService;
    }

    @Given("a valid CEP {string}")
    public void a_valid_cep(String cep) {
        addressRequest = new AddressRequest(cep);
    }

    @When("the Address Request is executed")
    public void the_address_request_is_executed() {
        try {
            addressResponse = addressService.execute(addressRequest);
        } catch (Exception ex) {
            exception = ex;
        }
    }

    @Then("the Address Response should contain the expected information")
    public void the_address_response_should_contain_the_expected_information() {
        Assertions.assertNotNull(addressResponse.getCEP());
        Assertions.assertNotNull(addressResponse.getCity());
        Assertions.assertNotNull(addressResponse.getStreet());
        Assertions.assertNotNull(addressResponse.getState());
        Assertions.assertNotNull(addressResponse.getComplement());
        Assertions.assertNotNull(addressResponse.getDistrict());
        Assertions.assertNotNull(addressResponse.getShipping());
    }

    @Then("the Shipping value should be calculated correctly")
    public void the_shipping_value_should_be_calculated_correctly() {
        Assertions.assertNotEquals(0.0, addressResponse.getShipping());
    }

    @Given("an invalid CEP {string}")
    public void an_invalid_cep(String cep) {
        addressRequest = new AddressRequest(cep);
    }

    @Then("an InvalidCepException should be thrown")
    public void an_invalid_cep_exception_should_be_thrown() {
        Assertions.assertNotNull(exception);
        Assertions.assertTrue(exception instanceof InvalidCepException);
    }

    @Given("a valid CEP {string} not found")
    public void a_valid_cep_not_found(String cep) {
        addressRequest = new AddressRequest(cep);
    }

    @Then("a NotFoundException should be thrown")
    public void a_not_found_exception_should_be_thrown() {
        Assertions.assertNotNull(exception);
        Assertions.assertTrue(exception instanceof NotFoundException);
    }

    @Given("an Address Request with an unknown error")
    public void an_address_request_with_an_unknown_error() {
        addressRequest = new AddressRequest("00000-000");
    }

    @Then("an UnknownException should be thrown")
    public void an_unknown_exception_should_be_thrown() {
        Assertions.assertNotNull(exception);
        Assertions.assertTrue(exception instanceof UnknownException);
    }

}