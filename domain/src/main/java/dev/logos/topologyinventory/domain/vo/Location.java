package dev.logos.topologyinventory.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Location {
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private float latitude;
    private float longitude;
}
