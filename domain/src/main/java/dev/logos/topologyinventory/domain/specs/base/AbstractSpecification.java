package dev.logos.topologyinventory.domain.specs.base;

import dev.logos.topologyinventory.domain.entity.Equipment;

public abstract class AbstractSpecification<T extends Equipment> {

    public abstract boolean isSatisfiedBy(T anyEquipment);

    public abstract void check(T equipment) throws Exception;
}
