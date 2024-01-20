package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer>{

	Boolean existsByTitle(String title);
}
