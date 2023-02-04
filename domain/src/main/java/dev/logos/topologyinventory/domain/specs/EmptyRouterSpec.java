package dev.logos.topologyinventory.domain.specs;

import dev.logos.topologyinventory.domain.entity.CoreRouter;
import dev.logos.topologyinventory.domain.exceptions.GenericSpecificationException;
import dev.logos.topologyinventory.domain.specs.base.AbstractSpecification;

public class EmptyRouterSpec extends AbstractSpecification<CoreRouter> {

    @Override
    public boolean isSatisfiedBy(CoreRouter coreRouter) {
        return coreRouter.getRouters() != null || coreRouter.getRouters().isEmpty();
    }

    @Override
    public void check(CoreRouter coreRouter) throws Exception {
        if (!isSatisfiedBy(coreRouter)) {
            throw new GenericSpecificationException(
                    "it isn't allowed to remove a core router with other routers attached to it");
        }

    }

}
