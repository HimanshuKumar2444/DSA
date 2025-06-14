package com.naukri.database_api.controllers;

import com.naukri.database_api.models.AppUser;
import com.naukri.database_api.models.Company;
import com.naukri.database_api.repositories.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/company")
public class CompanyController {
    @Autowired
    private CompanyRepo companyRepo;


    @PostMapping("/save")
    public ResponseEntity createCompany(@RequestBody Company company){
        companyRepo.save(company);
        return new ResponseEntity(company, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCompanyById(@PathVariable UUID id){
        Company response=  companyRepo.findById(id).orElse(null);
        return new ResponseEntity(response,HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCompany( @RequestBody Company company){
        Company response=  companyRepo.save(company);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable UUID id){

        companyRepo.deleteById(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);

    }

}
