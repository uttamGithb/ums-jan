package com.ums.service;

import com.ums.dto.PageDetails;
import com.ums.dto.PropertyUserDto;
import com.ums.entity.User;
import com.ums.exception.ResourceNotFoundException;
import com.ums.repository.PropertyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PropertyUserImpl implements PropertyUser{
    @Autowired
    private PropertyUserRepository repo;

    @Override
    public PropertyUserDto addPropertyUser(PropertyUserDto dto) {

        User user = dtoToEntity(dto);
        User savedUser = repo.save(user);

        PropertyUserDto puo = entityToDto(savedUser);
        return puo;
    }

    public User dtoToEntity(PropertyUserDto dto){
        User user=new User();
        user.setName(dto.getName());
        user.setMobile(dto.getMobile());
        user.setEmailId(dto.getEmailId());
        return user;
    }

    public PropertyUserDto entityToDto(User user){
        PropertyUserDto puo = new PropertyUserDto();
        puo.setId(user.getId());
        puo.setName(user.getName());
        puo.setMobile(user.getMobile());
        puo.setEmailId(user.getEmailId());
        puo.setDate(new Date());
        return puo;
    }

    @Override
    public void deletePropertyUser(long propertyUserId) {
        repo.deleteById(propertyUserId);
    }

    @Override
    public User updatePropertyUser(long propertyUserId,PropertyUserDto dto) {
        User user=null;
        Optional<User> byId = repo.findById(propertyUserId);
        if (byId.isPresent()){
             user = byId.get();
        }else {
            throw new ResourceNotFoundException("User not found with Id " + propertyUserId);  // handle resource not found exception here. 404 error code.
        }


        user.setName(dto.getName());
        user.setMobile(dto.getMobile());
        user.setEmailId(dto.getEmailId());

        return repo.save(user);

    }

    @Override
    public List<PropertyUserDto> getPropertyUsers(int pageSize, int pageNo, String sortBy, String sortDir) {
        Pageable pageable=null;
           if(sortDir.equalsIgnoreCase("asc")){
               pageable= PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
           } else if (sortDir.equalsIgnoreCase("desc")) {
               pageable= PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
           }

//        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<User> page = repo.findAll(pageable);

        List<User> user = page.getContent();
        List<PropertyUserDto> pud = user.stream().map(p -> entityToDto(p)).collect(Collectors.toList());

        PageDetails pageDetails =new PageDetails();


//        pageDetails.setFirst(page.isFirst());
//        pageDetails.setLast(page.isLast());
//        pageDetails.setTotalPages(page.getTotalPages());
//        pageDetails.setTotalElements((int) page.getTotalElements());
//        pageDetails.setPageNo(page.getNumber());
//        pud.setPageDetails(pageDetails);

        return pud;
    }

    @Override
    public User getPropertyUserById(long propertyUserId) {
        User user = repo.findById(propertyUserId).orElseThrow(() -> new ResourceNotFoundException("USer not found with Id " + propertyUserId));

        return user;
    }
}
