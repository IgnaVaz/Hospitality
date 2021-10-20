package com.hospitality.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitality.api.entity.UserEntity;
import com.hospitality.api.repository.UserRepository;
import com.hospitality.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public List<UserEntity> getServiceAllUser() {
		return repository.getRepositoryAllUser();
	}
	
	@Override
	public List<UserEntity> getServiceByIdUser(String id) {
		return repository.getRepositoryByIdUser(id);
	}
	
	@Override
	public int setServiceCreateUser(UserEntity User) {
		return repository.setRepositoryCreateUser(User);
	}
	
	@Override
	public int setServiceUpdateUser(UserEntity User) {
		return repository.setRepositoryUpdateUser(User);
	}
	
	@Override
	public int setServiceDeleteUser(UserEntity User) {
		return repository.setRepositoryDeleteUser(User);
	}

}
