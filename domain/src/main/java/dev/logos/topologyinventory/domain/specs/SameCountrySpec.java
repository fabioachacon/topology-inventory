package dev.logos.topologyinventory.domain.specs;

import dev.logos.topologyinventory.domain.entity.CoreRouter;
import dev.logos.topologyinventory.domain.entity.Equipment;
import dev.logos.topologyinventory.domain.exceptions.GenericSpecificationException;
import dev.logos.topologyinventory.domain.specs.base.AbstractSpecification;

public class SameCountrySpec extends AbstractSpecification<Equipment> {

    private Equipment equipment;

    public SameCountrySpec(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public boolean isSatisfiedBy(Equipment anyEquipment) {
        if (anyEquipment instanceof CoreRouter) {
            return true;
        } else if (anyEquipment != null && this.equipment != null) {
            return this.equipment.getLocation().getCountry().equals(anyEquipment.getLocation().getCountry());
        } else {
            return false;
        }
    }

    @Override
    public void check(Equipment equipment) throws Exception {
        if (!isSatisfiedBy(equipment))
            throw new GenericSpecificationException("The equipment should be in the same country");
    }
}
