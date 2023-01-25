package com.fronchak.animeflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fronchak.animeflix.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
