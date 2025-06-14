package com.naukri.database_api.controllers;

import com.naukri.database_api.models.AppUser;
import com.naukri.database_api.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/user")
public class AppUserControler {

    @Autowired
  private   AppUserRepo appUserRepo;

  @PostMapping("/create")
  public ResponseEntity createUser(@RequestBody AppUser user){
    appUserRepo.save(user);
    return new ResponseEntity(user, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity getUserById(@PathVariable UUID id){
    AppUser response=  appUserRepo.findById(id).orElse(null);
    return new ResponseEntity(response,HttpStatus.CREATED);

  }

  @PutMapping("/update")
  public ResponseEntity<?> updateUser( @RequestBody AppUser appUser){
    AppUser response=  appUserRepo.save(appUser);
    return ResponseEntity.ok(response);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable UUID id){

    appUserRepo.deleteById(id);
    return new ResponseEntity(null, HttpStatus.NO_CONTENT);

  }




}
