package com.abc.model;

import org.springframework.data.annotation.Id;

import com.abc.common.Helper;



public class BaseEntity {
	@Id
	private String id;
	private String uuid;
	private String version;
	private String name;
	private String desc;
   	private String joindate;
    private String skill;
	private String active = "Y";
	

	

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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	 public String getJoindate() {
			return joindate;
		}

		public void setJoindate(String joindate) {
			this.joindate = joindate;
		}

		

	public String getSkill() {
			return skill;
		}

		public void setSkill(String skill) {
			this.skill = skill;
		}

	public void exportBaseProperty() {
		System.out.println(" id is uuid " + this.getUuid());

		if (this.getUuid() == null || this.getUuid().isEmpty()) {
			this.setUuid(Helper.getNextUUID());
		}
		
		if (this.getVersion() == null || this.getVersion().isEmpty()) {
			this.setVersion(Helper.getVersion());
		}
		
		}
	
}
