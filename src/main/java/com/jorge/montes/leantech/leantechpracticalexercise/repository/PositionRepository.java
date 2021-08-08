package com.jorge.montes.leantech.leantechpracticalexercise.repository;

import com.jorge.montes.leantech.leantechpracticalexercise.entity.Position;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends PagingAndSortingRepository<Position, Long> {

    public Optional<Position> findByName(String name);

}
