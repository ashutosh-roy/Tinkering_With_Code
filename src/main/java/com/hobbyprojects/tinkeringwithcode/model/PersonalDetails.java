package com.hobbyprojects.tinkeringwithcode.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PersonalDetails {
    String name;
    int age;
    boolean hasDrivingLicense;
}
