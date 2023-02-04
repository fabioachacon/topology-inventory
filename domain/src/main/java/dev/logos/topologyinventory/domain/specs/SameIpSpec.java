package dev.logos.topologyinventory.domain.specs;

import dev.logos.topologyinventory.domain.entity.Equipment;
import dev.logos.topologyinventory.domain.exceptions.GenericSpecificationException;
import dev.logos.topologyinventory.domain.specs.base.AbstractSpecification;

public class SameIpSpec extends AbstractSpecification<Equipment> {
    private Equipment equipment;

    public SameIpSpec(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public boolean isSatisfiedBy(Equipment anyEquipment) {
        return !this.equipment.getIp().equals(anyEquipment.getIp());
    }

    @Override
    public void check(Equipment equipment) throws Exception {
        if (isSatisfiedBy(equipment)) {
            throw new GenericSpecificationException("It is not possible to attach routers with the same IP");
        }

    }

}
