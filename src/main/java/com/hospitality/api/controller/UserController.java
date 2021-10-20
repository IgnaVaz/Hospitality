package com.hospitality.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitality.api.entity.ResponseApi;
import com.hospitality.api.entity.UserEntity;
import com.hospitality.api.service.UserService;
import com.hospitality.api.util.Constants;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping(path = Constants.list)
	public ResponseApi getAllUser() {
		return new ResponseApi(service.getServiceAllUser()); 
	}

	@GetMapping(path = Constants.detail)
	public ResponseApi getDetailUser(@PathVariable String id) {
		return new ResponseApi(service.getServiceByIdUser(id));
	}

	@PostMapping(path = Constants.create, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi setCreatelUser(@RequestBody UserEntity UserEntity) {
		return new ResponseApi(service.setServiceCreateUser(UserEntity));
	}

	@PatchMapping(path = Constants.update, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi setUpdateUser(@RequestBody UserEntity UserEntity) {
		return new ResponseApi(service.setServiceUpdateUser(UserEntity));
	}
	
	@PutMapping(path = Constants.delete, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi setDeleteUser(@RequestBody UserEntity UserEntity) {
		return new ResponseApi(service.setServiceDeleteUser(UserEntity));
	}

}
