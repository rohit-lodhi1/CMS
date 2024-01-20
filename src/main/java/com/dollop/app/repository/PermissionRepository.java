package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.ModulePermissions;
import com.dollop.app.entity.Permissions;
import com.dollop.app.entity.Roles;

public interface PermissionRepository extends JpaRepository<Permissions, Integer> {

	List<Permissions> findByRole(Roles roles);
	
	Optional<Permissions> findByTitle(String title);
	
	Optional<Permissions> findByTitleContaining(String title);
	
	List<Permissions> findByModulePermissionsAndRole(ModulePermissions m,Roles role);
}
