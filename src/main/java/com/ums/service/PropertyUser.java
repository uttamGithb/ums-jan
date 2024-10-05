package com.ums.service;

import com.ums.dto.PropertyUserDto;
import com.ums.entity.User;

import java.util.List;

public interface PropertyUser {
    public PropertyUserDto addPropertyUser(PropertyUserDto dto);

  public void deletePropertyUser(long propertyUserId);

    User updatePropertyUser(long propertyUserId,PropertyUserDto dto);

    List<PropertyUserDto> getPropertyUsers(int pageSize, int pageNo, String sortBy, String sortDir);

    User getPropertyUserById(long propertyUserId);


}
