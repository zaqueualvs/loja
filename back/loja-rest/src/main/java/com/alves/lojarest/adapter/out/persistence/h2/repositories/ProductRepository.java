package com.alves.lojarest.adapter.out.persistence.h2.repositories;

import com.alves.lojarest.adapter.out.persistence.h2.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByName(String name);
}
