package dev.logos.topologyinventory.domain.vo;

import lombok.Data;

@Data
public class IP {
    private String ipAddress;
    private Protocol protocol;

    public IP(String ipAddress) {
        if (ipAddress == null) {
            throw new IllegalArgumentException("Null IP address");
        }

        this.ipAddress = ipAddress;

        if (ipAddress.length() <= 15) {
            this.protocol = Protocol.IPV4;
        } else {
            this.protocol = Protocol.IPV6;
        }

    }
}
