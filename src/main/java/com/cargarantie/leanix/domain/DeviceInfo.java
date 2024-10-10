package com.cargarantie.leanix.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DeviceInfo {

    private String id;
    private String name;
    @JsonProperty("data")
    private HardwareInfo hardwareInfo;
}
