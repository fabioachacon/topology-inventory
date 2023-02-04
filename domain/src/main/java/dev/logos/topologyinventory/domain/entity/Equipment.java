package dev.logos.topologyinventory.domain.entity;

import java.util.function.Predicate;

import dev.logos.topologyinventory.domain.vo.IP;
import dev.logos.topologyinventory.domain.vo.Id;
import dev.logos.topologyinventory.domain.vo.Location;
import dev.logos.topologyinventory.domain.vo.Model;
import dev.logos.topologyinventory.domain.vo.Vendor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Equipment {
    protected Id id;
    protected Vendor vendor;
    protected Model model;
    protected IP ip;
    protected Location location;

    public static Predicate<Equipment> getVendorPredicate(Vendor vendor) {
        return r -> r.getVendor().equals(vendor);
    }

}
