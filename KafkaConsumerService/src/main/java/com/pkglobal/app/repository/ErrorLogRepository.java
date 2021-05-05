package com.pkglobal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pkglobal.app.model.ErrorLog;

@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Integer> {

}
