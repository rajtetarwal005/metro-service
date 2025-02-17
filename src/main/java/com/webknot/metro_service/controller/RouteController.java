package com.webknot.metro_service.controller;

import com.webknot.metro_service.model.RouteModel;
import com.webknot.metro_service.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    // Constructor-based dependency injection
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    // Get all routes
    @GetMapping
    public ResponseEntity<List<RouteModel>> getAllRoutes() {
        List<RouteModel> routes = routeService.getAllRoutes();
        return ResponseEntity.ok(routes);
    }

    // Get a specific route by ID
    @GetMapping("/{id}")
    public ResponseEntity<RouteModel> getRouteById(@PathVariable Long id) {
        RouteModel route = routeService.getRouteById(id);
        return ResponseEntity.ok(route);
    }

    // Add a new route
    @PostMapping
    public ResponseEntity<RouteModel> addRoute(@RequestBody RouteModel route) {
        RouteModel savedRoute = routeService.addRoute(route);
        return ResponseEntity.ok(savedRoute);
    }

    // Update an existing route
    @PutMapping("/{id}")
    public ResponseEntity<RouteModel> updateRoute(@PathVariable Long id, @RequestBody RouteModel routeDetails) {
        RouteModel updatedRoute = routeService.updateRoute(id, routeDetails);
        return ResponseEntity.ok(updatedRoute);
    }

    // Delete a route
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return ResponseEntity.ok("Route deleted successfully!");
    }
}
