package io.github.jandersoneusebio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Parameter implements Serializable {
	
	private static final long serialVersionUID = 4412417133319287601L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "PARAM_NAME")
	private String paramName;
	
	@Column(name = "PARAM_VALUE")
	private String paramValue;
	

}
