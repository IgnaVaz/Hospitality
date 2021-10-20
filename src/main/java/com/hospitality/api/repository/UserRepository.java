package com.hospitality.api.repository;

import java.util.List;

import com.hospitality.api.entity.UserEntity;

public interface UserRepository {

	List<UserEntity> getRepositoryAllUser();
	List<UserEntity> getRepositoryByIdUser(String id);
	int setRepositoryCreateUser(UserEntity User);
	int setRepositoryUpdateUser(UserEntity User);
	int setRepositoryDeleteUser(UserEntity User);
	
}
