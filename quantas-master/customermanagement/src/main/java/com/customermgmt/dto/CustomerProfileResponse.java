package com.customermgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class CustomerProfileResponse {
    private List<CustomerProfileDto> customerProfileDtos;
}
