package com.fyle.starter.bank.dao;

import com.fyle.starter.bank.model.Bank;
import com.fyle.starter.bank.model.Bank_branches;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepo extends JpaRepository<Bank,String>,PagingAndSortingRepository<Bank,String> {
    Page<Bank> findAll(Pageable pageable);
    Page findByifsc(String ifsc,Pageable pageable);
    Page<Bank> findBystate(String state,Pageable pageable);
    Page<Bank> findBycity(String city,Pageable pageable);
    @Query("SELECT u FROM Bank u WHERE u.state = :state and u.city = :city")
    Page<Bank> findBystateAndcity(@Param("state")String state, @Param("city")String city,Pageable pageable);
    @Query("SELECT u FROM Bank_branches u WHERE u.bank_name = :bank_name and u.city = :city")
    Page<Bank_branches> findBybank_nameAndcity(@Param("bank_name")String name, @Param("city")String city,Pageable pageable);
}
