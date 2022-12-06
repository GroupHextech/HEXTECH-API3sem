package com.iacit.ioweather.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.iacit.ioweather.model.Estado;



@RepositoryRestResource 
public interface Estados extends JpaRepository<Estado, Integer>{
	public Optional<Estado> findById(Integer idEstado);
    public List<Estado> findAll();
}
