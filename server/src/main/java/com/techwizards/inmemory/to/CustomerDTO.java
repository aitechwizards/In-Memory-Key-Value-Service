package com.techwizards.inmemory.to;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.keyvalue.annotation.KeySpace;

@KeySpace("customer")
@Table
@EntityListeners(AuditingEntityListener.class)
public class CustomerDTO {
	@Id
	private Long keyId;
	private String fullName;

	@CreatedBy
	@Column(nullable = false, updatable = false)
	private String createdBy;

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime created;

	@LastModifiedBy
	@Column(nullable = false)
	private String modifiedBy;

	@LastModifiedDate
	@Column(nullable = false)
	private LocalDateTime modified;

	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}

	public CustomerDTO(Long keyId) {
		super();
		this.keyId = keyId;
	}

	public CustomerDTO(Long keyId, String fullName) {
		super();
		this.keyId = keyId;
		this.fullName = fullName;
	}

	public Long getKeyId() {
		return keyId;
	}

	public void setKeyId(Long keyId) {
		this.keyId = keyId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "CustomerDTO [keyId=" + keyId + ", fullName=" + fullName + ", createdBy=" + createdBy + ", created="
				+ created + ", modifiedBy=" + modifiedBy + ", modified=" + modified + "]";
	}

}
