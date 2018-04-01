package com.barath.inventory.app.service;

import com.barath.inventory.app.entities.Inventory;
import com.barath.inventory.app.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by barath on 17/03/18.
 */
@Service
public class InventoryService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Mono<Inventory> addInventory(final Mono<Inventory> inventoryMono){
        return inventoryMono.doOnNext( inventory -> {
            logger.info("inventory {}",inventory);
            inventoryRepository.save(inventory);
        }).log();
    }


    public Flux<Inventory> getInventories(){

        return Flux.fromIterable(inventoryRepository.findAll()).log();
    }

    public Flux<Inventory> getInventoryByProductName(final String productName){

        return Flux.fromIterable(inventoryRepository.findByProductName(productName)).log();
    }

    public Flux<Inventory> getInventoryByLocationName(final String locationName){

        return Flux.fromIterable(inventoryRepository.findByLocationName(locationName)).log();
    }

    public Mono<Inventory> getByLocationAndProductName(final String locationName, final String productName){

        return  Mono.just(inventoryRepository.findByProductNameAndLocationName(productName,locationName)).log();
    }



    @PostConstruct
    public void init(){

       Arrays.asList(new Inventory("TV","CHENNAI",10),
               new Inventory("TV","BANGALORE",10),
               new Inventory("TV","DELHI",10)).stream().forEach(this.inventoryRepository::save);
    }
}
