package com.customermgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class CustomerProfileResponse {
    private String message;
    private List<CustomerProfileDto> customerProfileDtos;
}
