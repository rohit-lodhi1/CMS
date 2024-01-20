package com.dollop.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.ModulePermissions;

public interface ModulePermissionsRepository extends JpaRepository<ModulePermissions, Integer>{

	
	@Query(value="select m.id,m.name from module_permissions as m left join permissions as p on m.id = p.module_permissions_id and p.role_permissions = :rId GROUP by (p.module_permissions_id);",nativeQuery = true)
	List<ModulePermissions>  getModulePermissionByRoleId(Integer rId);
	
	 
}
