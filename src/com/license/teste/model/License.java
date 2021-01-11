package com.license.teste.model;

public class License {

	private Integer id;
	private String name;
	private String type;
	private String serial;
	private String expiration;
	
	public License() {
		
	}
	
	

	public License(Integer id, String name, String type, String serial, String expiration) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.serial = serial;
		this.expiration = expiration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	
}
