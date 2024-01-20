package com.dollop.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.CompanySettings;

public interface CompanySettingsRepository extends JpaRepository<CompanySettings, Integer> {

}
