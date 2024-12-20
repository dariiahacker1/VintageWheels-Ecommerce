package com.dealership.vintagewheels.repository;

import com.dealership.vintagewheels.model.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long> {}
