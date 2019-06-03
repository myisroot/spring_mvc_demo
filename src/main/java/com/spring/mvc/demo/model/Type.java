package com.spring.mvc.demo.model;

import java.io.Serializable;
import java.util.List;

public class Type implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer t_id;
	private String typeName;
	private List<User> users;

	public Type() {
	}

	public Type(Integer t_id, String typeName) {
		this.t_id = t_id;
		this.typeName = typeName;
	}

	public Integer getT_id() {
		return t_id;
	}

	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Type{" + "id=" + t_id + ", typeName='" + typeName + '\'' + '}';
	}
}
