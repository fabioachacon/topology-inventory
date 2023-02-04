package dev.logos.topologyinventory.domain.specs;

import dev.logos.topologyinventory.domain.entity.EdgeRouter;
import dev.logos.topologyinventory.domain.exceptions.GenericSpecificationException;
import dev.logos.topologyinventory.domain.specs.base.AbstractSpecification;

public class EmptySwitchSpec extends AbstractSpecification<EdgeRouter> {

    @Override
    public boolean isSatisfiedBy(EdgeRouter edgeRouter) {
        return edgeRouter.getSwitchs() == null || edgeRouter.getSwitchs().isEmpty();
    }

    @Override
    public void check(EdgeRouter equipment) throws Exception {
        if (!isSatisfiedBy(equipment)) {
            throw new GenericSpecificationException(
                    "It isn't allowed to remove an edge router with a switch attached to it");
        }

    }

}
