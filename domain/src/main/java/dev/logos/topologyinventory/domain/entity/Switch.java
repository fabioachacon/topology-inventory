package dev.logos.topologyinventory.domain.entity;

import java.util.List;
import java.util.function.Predicate;

import dev.logos.topologyinventory.domain.vo.IP;
import dev.logos.topologyinventory.domain.vo.Id;
import dev.logos.topologyinventory.domain.vo.Location;
import dev.logos.topologyinventory.domain.vo.Model;
import dev.logos.topologyinventory.domain.vo.Network;
import dev.logos.topologyinventory.domain.vo.SwitchType;
import dev.logos.topologyinventory.domain.vo.Vendor;

public class Switch extends Equipment {
    private SwitchType switchType;
    private List<Network> switchNetworks;

    public Switch(Id id, Vendor vendor, Model model, IP ip, Location location) {
        super(id, vendor, model, ip, location);
    }

    public static Predicate<Switch> getSwitchTypePredicate(SwitchType switchType) {
        return s -> s.switchType.equals(switchType);
    }

    public boolean addNetworkToSwicht(Network network) {
        var availabiltySpec = new NetworkAvailabilitySpec(network);
        var cidrSpec = new CIDRSpecification();
        var amountSpec = new NetworkAmountSpec();

        cidrSpec.check(network.getNetworkCidr());
        availabiltySpec.check(this);
        amountSpec.check(this);

        return this.switchNetworks.add(network);
    }

    public boolean removeNetworkFromSwitch(Network network) {
        return this.switchNetworks.remove(network);
    }

}
