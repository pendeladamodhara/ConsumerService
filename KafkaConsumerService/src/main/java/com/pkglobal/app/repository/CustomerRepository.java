package com.pkglobal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pkglobal.app.model.CustomerVo;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerVo, String> {

}
