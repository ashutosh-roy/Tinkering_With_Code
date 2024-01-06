package com.hobbyprojects.tinkeringwithcode.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ToDo {
    @JsonProperty("item")
    String item;
    @JsonProperty("category")
    String category;
    @JsonProperty("addedBy")
    String addedBy;
}
