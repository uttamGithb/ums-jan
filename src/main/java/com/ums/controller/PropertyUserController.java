package com.ums.controller;

import com.ums.dto.PropertyUserDto;
import com.ums.entity.User;
import com.ums.service.PropertyUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Rest API Class
@RequestMapping("/api/v1/propertyUser")
// http://localhost:8080/api/v1/propertyUser
public class PropertyUserController {
    @Autowired
    private PropertyUser propertyUser;

    // http://localhost:8080/api/v1/propertyUser/addPropertyUser
    @PostMapping ("/addPropertyUser")
    public ResponseEntity<?> addPropertyUser(
            @Valid @RequestBody PropertyUserDto dto,
            BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.CREATED);
        }

        PropertyUserDto puo = propertyUser.addPropertyUser(dto);

        return new ResponseEntity<>(puo, HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<String> deletePropertyUser(
           @RequestParam long propertyUserId
    ){
        propertyUser.deletePropertyUser(propertyUserId);
        return new ResponseEntity<>("Record is deleted successfully",HttpStatus.OK);
    }

    // http://localhost:8080/api/v1/propertyUser/{propertyUserId}
    @PutMapping("/{propertyUserId}")
    public ResponseEntity<User> updatePropertyUser(
            @PathVariable long propertyUserId,
            @RequestBody PropertyUserDto dto
    ){
        User user = propertyUser.updatePropertyUser(propertyUserId, dto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // http://localhost:8080/api/v1/propertyUser?pageSize=3&pageNo=0&sortBy=emailId&sortDir=asc
    @GetMapping
    public ResponseEntity<List<PropertyUserDto>> getPropertyUsers(
         @RequestParam(name="pageSize",defaultValue = "5",required = false) int pageSize,
         @RequestParam(name="pageNo",defaultValue = "0",required = false) int pageNo,
         @RequestParam(name="sortBy",defaultValue = "id",required = false) String sortBy,
         @RequestParam(name="sortDir",defaultValue = "id",required = false) String sortDir
    ){
        List<PropertyUserDto> pud = propertyUser.getPropertyUsers(pageSize,pageNo,sortBy,sortDir);

        return new ResponseEntity<>(pud, HttpStatus.OK);
    }

    @GetMapping("/getUserById")
  //  http://localhost:8080/api/v1/propertyUser/getUserById?propertyUserId=
    public ResponseEntity<User> getPropertyUserById(
            @RequestParam long propertyUserId
    ){
        User user=propertyUser.getPropertyUserById(propertyUserId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}



