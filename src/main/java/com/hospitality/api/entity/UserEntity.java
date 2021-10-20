package com.hospitality.api.entity;

import javax.persistence.Column;

public class UserEntity {

	public int id;
	public String email;
	public String name;
	public String lastname;
	public String phone;
	public String cell;
	@Column(name = "id_position")
	public int idPosition;
	public String password;
	@Column(name = "old_password")
	public String oldPassword;
	@Column(name = "url_picture")
	public String urlPicture;
	@Column(name = "id_status")
	public int idStatus;
	@Column(name = "create_by")
	public String createBy;
	@Column(name = "date_password")
	public String datePassword;
	@Column(name = "id_lenguage")
	public int idLenguage;
	public String message;
	public String created;
	public String updated;
	
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getLastname() {
		return lastname;
	}
	public String getPhone() {
		return phone;
	}
	public String getCell() {
		return cell;
	}
	public int getIdPosition() {
		return idPosition;
	}
	public String getPassword() {
		return password;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public String getUrlPicture() {
		return urlPicture;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public String getCreateBy() {
		return createBy;
	}
	public String getDatePassword() {
		return datePassword;
	}
	public int getIdLenguage() {
		return idLenguage;
	}
	public String getMessage() {
		return message;
	}
	public String getCreated() {
		return created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public void setUrlPicture(String urlPicture) {
		this.urlPicture = urlPicture;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public void setDatePassword(String datePassword) {
		this.datePassword = datePassword;
	}
	public void setIdLenguage(int idLenguage) {
		this.idLenguage = idLenguage;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", email=" + email + ", name=" + name + ", lastname=" + lastname + ", phone="
				+ phone + ", cell=" + cell + ", idPosition=" + idPosition + ", password=" + password + ", oldPassword="
				+ oldPassword + ", urlPicture=" + urlPicture + ", idStatus=" + idStatus + ", createBy=" + createBy
				+ ", datePassword=" + datePassword + ", idLenguage=" + idLenguage + ", message=" + message
				+ ", created=" + created + ", updated=" + updated + "]";
	}
	
}
