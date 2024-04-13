package com.alves.lojarest.adapter.out.persistence.h2.repositories;

import com.alves.lojarest.adapter.out.persistence.h2.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

    Optional<TagEntity> findByName(String name);
}
