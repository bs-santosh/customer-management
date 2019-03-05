package com.customermgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private String streetNo;
    private String street;
    private String suburb;
    private String pincode;
    private String state;
    private String contactNo;
    private String addressType;
    private String email;
}
