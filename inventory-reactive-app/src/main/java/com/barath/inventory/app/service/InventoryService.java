package com.barath.inventory.app.service;

import com.barath.inventory.app.entities.Inventory;
import com.barath.inventory.app.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by barath on 17/03/18.
 */
@Service
public class InventoryService {


    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Mono<Inventory> addInventory(Mono<Inventory> inventoryMono){

        return inventoryMono.doOnNext( inventory -> {
            inventoryRepository.save(inventory);
        }).log();
    }


    public Flux<Inventory> getInventories(){

        return Flux.fromIterable(inventoryRepository.findAll()).log();
    }

    @PostConstruct
    public void init(){

        Flux.fromIterable(
                             Arrays.asList(
                                 Mono.just(new Inventory("TV","CHENNAI",10)),
                                 Mono.just( new Inventory("TV","BANGALORE",10)),
                                 Mono.just( new Inventory("TV","DELHI",10))
                             )

        ).doOnNext(this::addInventory);
    }
}
