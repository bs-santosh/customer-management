package com.customermgmt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressTypes {
    HOUSE("House"),
    COMPANY("Comapny");
    private final String addressType;
}
