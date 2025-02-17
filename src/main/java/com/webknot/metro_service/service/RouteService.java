package com.webknot.metro_service.service;


import com.webknot.metro_service.model.RouteModel;
import com.webknot.metro_service.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<RouteModel> getAllRoutes() {
        return routeRepository.findAll();
    }

    public RouteModel getRouteById(Long id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + id));
    }

    public RouteModel addRoute(RouteModel route) {
        return routeRepository.save(route);
    }

    public RouteModel updateRoute(Long id, RouteModel routeDetails) {
        RouteModel route = getRouteById(id);
        route.setName(routeDetails.getName());
        route.setActive(routeDetails.isActive());
        route.setStations(routeDetails.getStations());
        route.setSourceStation(routeDetails.getSourceStation());
        route.setDestinationStation(routeDetails.getDestinationStation());
        route.setDistance(routeDetails.getDistance());
        route.setBaseFare(routeDetails.getBaseFare());
        return routeRepository.save(route);
    }


    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}
