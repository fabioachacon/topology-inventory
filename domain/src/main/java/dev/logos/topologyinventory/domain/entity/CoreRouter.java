package dev.logos.topologyinventory.domain.entity;

import java.util.Map;

import dev.logos.topologyinventory.domain.specs.EmptyRouterSpec;
import dev.logos.topologyinventory.domain.specs.EmptySwitchSpec;
import dev.logos.topologyinventory.domain.specs.SameCountrySpec;
import dev.logos.topologyinventory.domain.specs.SameIpSpec;
import dev.logos.topologyinventory.domain.vo.IP;
import dev.logos.topologyinventory.domain.vo.Id;
import dev.logos.topologyinventory.domain.vo.Location;
import dev.logos.topologyinventory.domain.vo.Model;
import dev.logos.topologyinventory.domain.vo.Vendor;
import lombok.Getter;

@Getter
public class CoreRouter extends Router {
    private Map<Id, Router> routers;

    public CoreRouter(Id id, Vendor vendor, Model model, IP ip, Location location) {
        super(id, vendor, model, ip, location);
    }

    public Router addRouter(Router anyRouter) {
        var sameCountryRouterSpec = new SameCountrySpec(this);
        var sameIpSpec = new SameIpSpec(this);

        try {
            sameCountryRouterSpec.check(anyRouter);
            sameIpSpec.check(anyRouter);

            this.routers.put(anyRouter.id, anyRouter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Router removeRouter(Router anyRouter) throws Exception {
        var emptyRoutersSpec = new EmptyRouterSpec();
        var emptySwitchSpec = new EmptySwitchSpec();

        switch (anyRouter.routerType) {
            case CORE:
                var coureRouter = (CoreRouter) anyRouter;
                emptyRoutersSpec.check(coureRouter);
            case EDGE:
                var edgeRouter = (EdgeRouter) anyRouter;
                emptySwitchSpec.check(edgeRouter);
        }

        return this.routers.remove(anyRouter.id);
    }
}
