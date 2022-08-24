package io.github.jandersoneusebio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jandersoneusebio.model.Parameter;

public interface ParameterRepository extends JpaRepository<Parameter, Long>{

	Optional<Parameter> findByParamName(String paramName);
	
}
