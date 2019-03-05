package com.customermgmt.service;

import com.customermgmt.domain.Address;
import com.customermgmt.domain.CustomerProfile;
import com.customermgmt.dto.AddressDto;
import com.customermgmt.dto.CustomerProfileDto;
import com.customermgmt.repository.AddressRepository;
import com.customermgmt.repository.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerProfileService {
    @Autowired
    CustomerProfileRepository customerProfileRepository;
    @Autowired
    AddressRepository addressRepository;

    public List<CustomerProfileDto> findAllCustomerProfiles() {
        List<CustomerProfile> customerProfiles = customerProfileRepository.findAll();
        return customerProfiles.stream().map(customerProfile ->
                CustomerProfileDto.builder()
                        .firstName(customerProfile.getFirstName())
                        .lastName(customerProfile.getLastName())
                        .dateOfBirth(customerProfile.getDateOfBirth())
                        .id(customerProfile.getId())
                        .addresses(customerProfile.getAddresses().stream().map(address -> AddressDto.builder()
                                .addressType(address.getAddressType())
                                .contactNo(address.getContactNo())
                                .id(address.getId())
                                .pincode(address.getPincode())
                                .state(address.getState())
                                .street(address.getStreet())
                                .streetNo(address.getStreetNo())
                                .suburb(address.getSuburb())
                                .build()).collect(Collectors.toList()))
                        .build()).collect(Collectors.toList());
    }

    public CustomerProfileDto findCustomerProfileById(Long customerId) {
        Optional<CustomerProfile> customerProfile = customerProfileRepository.findById(customerId);
        if (customerProfile.isPresent()) {
            List<AddressDto> addressDtos = customerProfile.get().getAddresses().stream()
                    .map(address -> AddressDto.builder()
                            .addressType(address.getAddressType())
                            .contactNo(address.getContactNo())
                            .id(address.getId())
                            .pincode(address.getPincode())
                            .state(address.getState())
                            .street(address.getStreet())
                            .streetNo(address.getStreetNo())
                            .suburb(address.getSuburb())
                            .build()).collect(Collectors.toList());
            return CustomerProfileDto.builder()
                    .firstName(customerProfile.get().getFirstName())
                    .lastName(customerProfile.get().getLastName())
                    .dateOfBirth(customerProfile.get().getDateOfBirth())
                    .id(customerProfile.get().getId())
                    .addresses(addressDtos)
                    .build();
        } else {
            return null;
        }
    }

    public CustomerProfile saveCustomerProfile(CustomerProfileDto customerProfileDto) {
        System.out.println("customerProfileDto = " + customerProfileDto);
        List<Address> addresses = new ArrayList<Address>();
        customerProfileDto.getAddresses().stream().forEach(addressDto -> {
            addresses.add(addressRepository.save(
               Address.builder()
                       .id(addressDto.getId())
                       .addressType(addressDto.getAddressType())
                       .contactNo(addressDto.getContactNo())
                       .email(addressDto.
                               getEmail())
                       .streetNo(addressDto.getStreetNo())
                       .street(addressDto.getStreet())
                       .state(addressDto.getState())
                       .suburb(addressDto.getSuburb())
                       .pincode(addressDto.getPincode())
                       .build()
            ));

        });
        return customerProfileRepository.save(CustomerProfile.builder()
                .id(customerProfileDto.getId())
                .addresses(addresses)
                .firstName(customerProfileDto.getFirstName())
                .lastName(customerProfileDto.getLastName())
                .dateOfBirth(customerProfileDto.getDateOfBirth())
                .build());
    }

    public void deleteCustomerProfile(Long customerId) {
        customerProfileRepository.deleteById(customerId);
    }
}
