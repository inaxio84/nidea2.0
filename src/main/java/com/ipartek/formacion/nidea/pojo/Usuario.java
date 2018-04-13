package com.ipartek.formacion.nidea.pojo;

public class Usuario {

	private int id;
	private String user;

	public Usuario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", user=" + user + "]";
	}

}
