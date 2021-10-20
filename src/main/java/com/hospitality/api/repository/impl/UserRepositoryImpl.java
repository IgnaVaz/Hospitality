package com.hospitality.api.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.hospitality.api.entity.UserEntity;
import com.hospitality.api.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserEntity> getRepositoryAllUser() {
		return jdbcTemplate.query("SELECT * from public.users",
				BeanPropertyRowMapper.newInstance(UserEntity.class));
	}

	@Override
	public List<UserEntity> getRepositoryByIdUser(String id) {
		return jdbcTemplate.query("SELECT * from public.users WHERE id=" + id,
				BeanPropertyRowMapper.newInstance(UserEntity.class));
	}

	@Override
	public int setRepositoryCreateUser(UserEntity User) {
		return jdbcTemplate.update(
				"INSERT INTO public.users (email, name, lastname, phone, cell, id_position, password, old_password, url_picture, id_status, create_by,  id_lenguage, message) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);",
				new Object[] { User.getEmail(), User.getName(), User.getLastname(), User.getPhone(),
						User.getCell(), User.getIdPosition(), User.getPassword(), User.getOldPassword(),
						User.getUrlPicture(), User.getIdStatus(), User.getCreateBy(), User.getIdLenguage(),
						User.getMessage() });

	}

	@Override
	public int setRepositoryUpdateUser(UserEntity User) {
		return jdbcTemplate.update("UPDATE public.users SET email=?, name=?, lastname=? WHERE id=? ",
				new Object[] { User.getEmail(), User.getName(), User.getLastname(), User.getId() });

	}

	@Override
	public int setRepositoryDeleteUser(UserEntity User) {
		return jdbcTemplate.update("DELETE FROM public.users WHERE id=?", User.getId());

	}

}
