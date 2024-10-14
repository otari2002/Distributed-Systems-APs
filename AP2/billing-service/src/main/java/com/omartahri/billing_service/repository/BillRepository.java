package com.omartahri.billing_service.repository;

import com.omartahri.billing_service.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
