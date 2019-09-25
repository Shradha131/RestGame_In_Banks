package com.fyle.starter.bank.controller;

import com.fyle.starter.bank.dao.BankRepo;
import com.fyle.starter.bank.model.Bank;
import com.fyle.starter.bank.model.Bank_branches;
import com.fyle.starter.bank.security.services.OffsetBasedPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {
    @Autowired
    BankRepo repo;

    @RequestMapping("/bank")
    public Page<Bank> findAll(int offset, int limit){
        Pageable pageable = new OffsetBasedPageRequest(offset, limit);
        return repo.findAll(pageable);
    }
    @RequestMapping("/bank/{ifsc}")
    public Page findByIfsc(@PathVariable("ifsc") String ifsc,int offset,int limit)
    {
        Pageable pageable = new OffsetBasedPageRequest(offset, limit);
        return repo.findByifsc(ifsc,pageable);
    }
    @RequestMapping("/bank/state/{state}")
    public Page<Bank> findBystate(@PathVariable("state") String state,int offset,int limit){

        Pageable pageable = new OffsetBasedPageRequest(offset, limit);
        return repo.findBystate(state, pageable);
    }
    @RequestMapping("/bank/city/{city}")
    public Page<Bank> findBycity(@PathVariable("city") String city,int offset,int limit){
        Pageable pageable = new OffsetBasedPageRequest(offset, limit);
        return repo.findBycity(city,pageable);
    }
    @RequestMapping("bank/state/{state}/city/{city}")
    public Page<Bank> findBystateAndcity(@PathVariable("state") String state,@PathVariable("city") String city,int offset,int limit){
        Pageable pageable = new OffsetBasedPageRequest(offset, limit);
        return repo.findBystateAndcity(state,city,pageable);
    }

    @RequestMapping(value = "bankname/city", params = {"bankname", "city"})
    public Page<Bank_branches> findBybank_nameAndcity(@RequestParam("bankname") String bankname, @RequestParam("city") String city, int offset, int limit)
    {
        Pageable pageable = new OffsetBasedPageRequest(offset, limit);
        return repo.findBybank_nameAndcity(bankname,city,pageable);
    }
}
