package com.abc.model;

import org.springframework.data.annotation.Id;

import com.abc.common.Helper;



public class BaseEntity1 {
	@Id
	private String id;
	private String uuid;

	
	

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public void exportBaseProperty() {
		System.out.println(" id is uuid " + this.getUuid());

		if (this.getUuid() == null || this.getUuid().isEmpty()) {
			this.setUuid(Helper.getNextUUID());
		}
		
		
		
		}
	
}
