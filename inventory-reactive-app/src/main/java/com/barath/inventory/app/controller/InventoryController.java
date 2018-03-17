package com.barath.inventory.app.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.barath.inventory.app.entities.Inventory;
import com.barath.inventory.app.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Created by barath on 17/03/18.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    protected InventoryService inventoryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @PostMapping
    public Mono<Inventory> saveInventory(final @RequestBody Mono<Inventory> inventory) {
        LOGGER.info(" save inventory");
        return inventoryService.addInventory(inventory);

    }

    @GetMapping(value = "/all")
    public Flux<Inventory> getInventories() {

        LOGGER.info("get all the inventories");
        return inventoryService.getInventories();

    }

    @GetMapping(value = "/getByProductName/{productName}")
    public Flux<Inventory> getByProductName(final @PathVariable String productName) {
        LOGGER.info("get inventory by product name {} ", productName);
        return inventoryService.getInventoryByProductName(productName);

    }

    @GetMapping(value = "/getByLocationName/{locationName}")
    public Flux<Inventory> getByLocationName(final @PathVariable String locationName) {
        LOGGER.info("get inventory by location name {} ", locationName);
        return inventoryService.getInventoryByLocationName(locationName);

    }





    @RequestMapping(value = "/inventory/updateQuantity", method = RequestMethod.PUT)
    public Mono<Inventory> updateQuantity(@RequestBody Inventory inventory) {
        LOGGER.info("The Inventory to be updated is: {} ", inventory);
        int quantity = inventory.getQuantity();
        //return inventoryservice.updateInventory(inventory.getProductName(), inventory.getLocationName(), quantity);
        return Mono.empty();
    }


}