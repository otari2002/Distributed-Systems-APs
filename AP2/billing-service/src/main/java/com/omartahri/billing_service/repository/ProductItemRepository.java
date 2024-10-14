package com.omartahri.billing_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.omartahri.billing_service.entities.ProductItem;
@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
