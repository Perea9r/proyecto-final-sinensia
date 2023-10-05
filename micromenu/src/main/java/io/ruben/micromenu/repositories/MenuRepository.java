package io.ruben.micromenu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ruben.micromenu.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
