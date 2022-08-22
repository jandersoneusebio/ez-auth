package io.github.jandersoneusebio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.github.jandersoneusebio.util.GeneralUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 6921085546141595863L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SQ_USER")
	@JsonIgnore
	private Long id;
	
	@Column(name = "LOGIN")
	private String login;
	
	@JsonIgnore
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "IDENTIFIER_TYPE")
	private Character identifierType;

	@Column(name = "IDENTIFIER")
	private String identifier;
	
	@Transient
	private String fullIdentifier;
	
	@Getter(AccessLevel.NONE)
	@Column(name = "PERMISSIONS")
	private String permissionsStr;
	
	@Transient
	private List<String> permissions;
	
	@PostLoad
	private void postLoad() {
		loadIdentifier();
		loadPermissions();
	}
	
	private void loadIdentifier() {
		this.fullIdentifier = identifierType + identifier;
	}
	
	private void loadPermissions() {
		if(!GeneralUtil.isNullOrEmpty(permissionsStr)) {
			this.permissions = Arrays.asList(permissionsStr.split(";"));
		} else {
			this.permissions = new ArrayList<String>();
		}
	}
	

}
