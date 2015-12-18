package com.untitled.dataaccess.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@MappedSuperclass
public abstract class BaseEntity {
  
    @Column(name = "created_by_user", nullable = false)
    @CreatedBy
    private String createdByUser; 
     
    @Column(name = "modified_by_user", nullable = false)
    @LastModifiedBy
    private String modifiedByUser;
    
    @Column(name = "creation_time", nullable = false)
	private Date creationTime;

	@Column(name = "modification_time")
	private Date modificationTime;
 
     
    @PrePersist
    public void prePersist() {
        String createdByUser = getUsernameOfAuthenticatedUser();
        this.createdByUser = createdByUser;
        this.modifiedByUser = createdByUser;
        
        Date now = new Date(System.currentTimeMillis());
		this.creationTime = now;
		this.modificationTime = now;
    }
      
    @PreUpdate
    public void preUpdate() {
        String modifiedByUser = getUsernameOfAuthenticatedUser();
        this.modifiedByUser = modifiedByUser;
        
        this.modificationTime = new Date(System.currentTimeMillis());
    }
     
    private String getUsernameOfAuthenticatedUser() {
    	/*
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
 
        return ((User) authentication.getPrincipal()).getUsername();
        .*/
    	return "Pedro";
    }

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public String getModifiedByUser() {
		return modifiedByUser;
	}

	public void setModifiedByUser(String modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}
    
    
}