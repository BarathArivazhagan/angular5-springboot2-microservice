package com.barath.inventory.app.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import com.barath.inventory.app.entities.Inventory;
import com.barath.inventory.app.service.InventoryService;


/**
 * Created by barath on 17/03/18.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @PostMapping(value = "/")
    public Mono<Inventory> saveInventory(final @RequestBody Mono<Inventory> inventory) {

        if (logger.isInfoEnabled() ) logger.info(" save inventory");
        return inventoryService.addInventory(inventory);

    }

    @GetMapping(value = "/")
    public Flux<Inventory> getInventories() {

        if (logger.isInfoEnabled() ) logger.info("get all the inventories");
        return inventoryService.getInventories();

    }

    @GetMapping(value = "/getByProductName/{productName}")
    public Flux<Inventory> getByProductName(final @PathVariable String productName) {

        if (logger.isInfoEnabled() ) logger.info("get inventory by product name {} ", productName);
        return inventoryService.getInventoryByProductName(productName);

    }

    @GetMapping(value = "/getByLocationName/{locationName}")
    public Flux<Inventory> getByLocationName(final @PathVariable String locationName) {

        if (logger.isInfoEnabled() ) logger.info("get inventory by location name {} ", locationName);
        return inventoryService.getInventoryByLocationName(locationName);

    }

    @GetMapping(value = "/getByLocationAndProduct")
    public Mono<Inventory> getByLocationNameAndProductName(final @RequestParam("locationName") String locationName,final @RequestParam("productName") String productName) {

        if (logger.isInfoEnabled() ) logger.info("get inventory by product name {} and location name {} ",productName,locationName);
        return inventoryService.getByLocationAndProductName(locationName,productName);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleError(Exception ex){

        logger.error(" error {} ",ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
