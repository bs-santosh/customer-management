package com.customermgmt.controller;

import com.customermgmt.constants.Messages;
import com.customermgmt.dto.CustomerProfileDto;
import com.customermgmt.dto.CustomerProfileResponse;
import com.customermgmt.service.CustomerProfileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerProfileController {
    @Autowired
    CustomerProfileService customerProfileService;

    @ApiOperation(value = "Find all customers",
            notes = "Returns a JSON string of all the available customer profiles",
            response = CustomerProfileResponse.class,
            responseContainer = "List")
    @GetMapping(value = "/customers/find/all")
    public CustomerProfileResponse findAllCustomers() {

        return CustomerProfileResponse.builder()
                .customerProfileDtos(customerProfileService.findAllCustomerProfiles())
                .build();
    }

    @ApiOperation(value = "Save a Customer Profile",
            notes = "Saves customer profile received as JSON post")
    @PostMapping(value = "/customers/save")
    public void saveCustomerProfile(@RequestBody CustomerProfileDto customerProfileDto) {
        customerProfileService.saveCustomerProfile(customerProfileDto);
    }

    @ApiOperation(value = "Find a single customer profile",
            notes = "Returns a JSON string of a customer profile based on Customer ID",
            response = CustomerProfileResponse.class,
            responseContainer = "List")
    @GetMapping(value="/customers/find/{customerId}")
    public CustomerProfileResponse findSingleCustomer(@PathVariable(name = "customerId") Long customerId) {
        String errorMessage = "";
        CustomerProfileDto customerProfileDto = customerProfileService.findCustomerProfileById(customerId);
        if(customerProfileDto == null) {
            errorMessage = String.format(Messages.ERROR_CUSTOMER_PROFILE_NOT_FOUND, customerId);
        }
        List<CustomerProfileDto> customerProfileDtos = new ArrayList<>();
        customerProfileDtos.add(customerProfileDto);
        return CustomerProfileResponse.builder()
                .customerProfileDtos(customerProfileDtos)
                .message(errorMessage)
                .build();
    }

    @ApiOperation(value = "Deletes a single customer profile",
            notes = "Deletes a single customer profile based on ID")
    @PostMapping(value = "/customers/delete")
    public void deleteCustomerProfile(@RequestBody CustomerProfileDto customerProfileDto) {
        customerProfileService.deleteCustomerProfile(customerProfileDto.getId());
    }
}
