package dev.logos.topologyinventory.domain.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Network {
    private IP networkAddr;
    private String networkName;
    private int networkCidr;

    public Network(IP networkAddr, String networkName, int networkCidr) {
        if (networkCidr < 1 || networkCidr > 32) {
            throw new IllegalArgumentException("Invalid CIDR value");
        }

        this.networkCidr = networkCidr;
        this.networkAddr = networkAddr;
        this.networkName = networkName;

    }
}
