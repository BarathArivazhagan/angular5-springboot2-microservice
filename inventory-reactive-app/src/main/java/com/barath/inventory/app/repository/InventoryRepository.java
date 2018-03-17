package com.barath.inventory.app.repository;

import com.barath.inventory.app.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by barath on 17/03/18.
 */
public interface InventoryRepository extends JpaRepository<Inventory,String>{

    Inventory findByProductNameAndLocationName(String productName,String locationName);

    List<Inventory> findByProductName(String productName);

    List<Inventory> findByLocationName(String locationName);

}
