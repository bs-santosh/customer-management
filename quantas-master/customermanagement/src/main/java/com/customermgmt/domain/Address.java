package com.customermgmt.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "STREET_NO")
    private String streetNo;
    @Column(name = "STREET")
    private String street;
    @Column(name = "SUBURB")
    private String suburb;
    @Column(name = "PINCODE")
    private String pincode;
    @Column(name = "STATE")
    private String state;
    @Column(name = "email")
    private String email;
    @Column(name = "CONTACT_NUMBER")
    private String contactNo;
    @Column(name = "ADDRESS_TYPE")
    private String addressType;
}
