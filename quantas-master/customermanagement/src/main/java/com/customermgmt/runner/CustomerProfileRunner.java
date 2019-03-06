package com.customermgmt.runner;

import com.customermgmt.domain.Address;
import com.customermgmt.domain.CustomerProfile;
import com.customermgmt.repository.AddressRepository;
import com.customermgmt.repository.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerProfileRunner implements CommandLineRunner {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerProfileRepository customerProfileRepository;

    @Override
    public void run(String... args) throws Exception {
        Address address1 = Address.builder()
                .pincode("2000")
                .suburb("Ultimo")
                .streetNo("111")
                .street("George Street")
                .state("NSW")
                .email("a@a.com")
                .contactNo("123456789")
                .addressType("OFFICE")
                .build();

        Address address2 = Address.builder()
                .pincode("2001")
                .suburb("Sydney")
                .streetNo("222")
                .street("George Street")
                .state("NSW")
                .email("a@b.com")
                .contactNo("123456789")
                .addressType("HOME")
                .build();

        Address address3 = Address.builder()
                .pincode("2005")
                .suburb("Redfern")
                .streetNo("111")
                .street("George Street")
                .state("NSW")
                .email("a@c.com")
                .contactNo("123456789")
                .addressType("OFFICE")
                .build();

        List<Address> addressList1 = new ArrayList<>();
        addressList1.add(address1);
        addressList1.add(address2);

        List<Address> addressList2 = new ArrayList<>();
        addressList2.add(address3);

        customerProfileRepository.save(CustomerProfile.builder()
                .firstName("John")
                .lastName("Welsch")
                .dateOfBirth(new SimpleDateFormat("dd-mm-yyyy").parse("10-10-1980"))
                .addresses(addressList1)
                .build());

        customerProfileRepository.save(CustomerProfile.builder()
                .firstName("William")
                .lastName("La")
                .dateOfBirth(new SimpleDateFormat("dd-mm-yyyy").parse("10-10-1972"))
                .addresses(addressList2)
                .build());
    }
}
