package com.customermgmt.controller;

import com.customermgmt.dto.CustomerProfileDto;
import com.customermgmt.dto.CustomerProfileResponse;
import com.customermgmt.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerProfileController {
    @Autowired
    CustomerProfileService customerProfileService;

    @GetMapping(value = "/customers/find/all")
    public CustomerProfileResponse findAllCustomers() {

        return CustomerProfileResponse.builder()
                .customerProfileDtos(customerProfileService.findAllCustomerProfiles())
                .build();
    }

    @PostMapping(value = "/customers/save")
    public void saveCustomerProfile(@RequestBody CustomerProfileDto customerProfileDto) {
        customerProfileService.saveCustomerProfile(customerProfileDto);
    }


    @GetMapping(value="/customers/find/{customerId}")
    public CustomerProfileResponse findSingleCustomer(@PathVariable(name = "customerId") Long customerId) {
        System.out.println("customerId = " + customerId);
        CustomerProfileDto customerProfileDto = customerProfileService.findCustomerProfileById(customerId);
        List<CustomerProfileDto> customerProfileDtos = new ArrayList<>();
        customerProfileDtos.add(customerProfileDto);
        return CustomerProfileResponse.builder()
                .customerProfileDtos(customerProfileDtos)
                .build();
    }

    @PostMapping(value = "/customers/delete")
    public void deleteCustomerProfile(@RequestBody CustomerProfileDto customerProfileDto) {
        customerProfileService.deleteCustomerProfile(customerProfileDto.getId());
    }
}
