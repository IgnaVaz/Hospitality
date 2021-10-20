package com.hospitality.api.service;

import java.util.List;

import com.hospitality.api.entity.UserEntity;

public interface UserService {

	List<UserEntity> getServiceAllUser();
	List<UserEntity> getServiceByIdUser(String id);
	int setServiceCreateUser(UserEntity User);
	int setServiceUpdateUser(UserEntity User);
	int setServiceDeleteUser(UserEntity User);
	
}
