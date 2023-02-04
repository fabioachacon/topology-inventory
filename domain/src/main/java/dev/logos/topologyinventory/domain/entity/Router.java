package dev.logos.topologyinventory.domain.entity;

import java.util.function.Predicate;

import dev.logos.topologyinventory.domain.vo.IP;
import dev.logos.topologyinventory.domain.vo.Id;
import dev.logos.topologyinventory.domain.vo.Location;
import dev.logos.topologyinventory.domain.vo.Model;
import dev.logos.topologyinventory.domain.vo.RouterType;
import dev.logos.topologyinventory.domain.vo.Vendor;
import lombok.Getter;

@Getter
public abstract class Router extends Equipment {
    protected final RouterType routerType = null;

    public Router(Id id, Vendor vendor, Model model, IP ip, Location location) {
        super(id, vendor, model, ip, location);
    }

    public static Predicate<Router> getRouterTypPredicate(RouterType routerType) {
        return router -> router.getRouterType().equals(routerType);
    }

    public static Predicate<Equipment> getModelPredicate(Model model) {
        return r -> r.getModel().equals(model);
    }

    public static Predicate<Equipment> getCountryPredicate(Location location) {
        return p -> p.location.getCountry().equals(location.getCountry());
    }
}
