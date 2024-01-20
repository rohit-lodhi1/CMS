package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Assets;

public interface AssetsRepository extends JpaRepository<Assets,Long>{

public	Page<Assets> findByIsDelete(PageRequest pageRequest, boolean b);

public	Optional<Assets> findByIdAndIsDelete(Long id, boolean b);

}
