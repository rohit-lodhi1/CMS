package com.dollop.app.repository;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.dollop.app.entity.UserRoles;
import com.dollop.app.entity.Users;



public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {

	@Query("SELECT u FROM Users u JOIN u.userRoles ur JOIN ur.roles r WHERE r.id = ?1")
	public List<Users> getUsersByRoles(Integer roleId);

	 @Query("SELECT ur.roles.id FROM UserRoles ur WHERE ur.roles.title = :roleTitle")
	 public Integer findByTitle(String role);

	 @Query("SELECT COUNT(*) FROM Users u Join u.userRoles ur Join ur.roles r where r.id = :id")
	 public Optional<Integer> getCountOfUsersByRole(Integer id);

	@Query("SELECT u FROM Users u JOIN u.userRoles ur JOIN ur.roles r WHERE r.id = :id  and  u.deleted = false and u.email !=  :email ")
	public Page<Users> getByRoles(Pageable pageable,Integer id,String email);
	
	public List<UserRoles> findByUser(Users user);
	
	@Modifying
	@Transactional
	@Query("Delete  from UserRoles  u where u.id =:id")
	public void deleteUserRoleById(Integer id);

}
