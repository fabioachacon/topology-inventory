package dev.logos.topologyinventory.domain.entity;

import java.util.Map;

import dev.logos.topologyinventory.domain.specs.SameCountrySpec;
import dev.logos.topologyinventory.domain.specs.SameIpSpec;
import dev.logos.topologyinventory.domain.vo.IP;
import dev.logos.topologyinventory.domain.vo.Id;
import dev.logos.topologyinventory.domain.vo.Location;
import dev.logos.topologyinventory.domain.vo.Model;
import dev.logos.topologyinventory.domain.vo.Vendor;
import lombok.Getter;

@Getter
public class EdgeRouter extends Router {
    private Map<Id, Switch> switchs;

    public EdgeRouter(Id id, Vendor vendor, Model model, IP ip, Location location) {
        super(id, vendor, model, ip, location);
    }

    public void addSwitch(Switch anySwith) throws Exception {
        var sameCountrySpec = new SameCountrySpec(this);
        var sameIpSpec = new SameIpSpec(this);

        sameCountrySpec.check(anySwith);
        sameIpSpec.check(anySwith);

        this.switchs.put(anySwith.id, anySwith);
    }

    public Switch removeSwitch(Switch anySwith) {
        var emptyNetworkSpec = new EmptyNetworkSpec();
        emptyNetworkSpec.check(anySwith);

        return this.switchs.remove(anySwith.id);

    }

}
