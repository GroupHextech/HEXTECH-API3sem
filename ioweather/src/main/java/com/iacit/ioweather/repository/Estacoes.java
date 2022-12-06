package com.iacit.ioweather.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.iacit.ioweather.model.Estacao;



@RepositoryRestResource 
public interface Estacoes extends JpaRepository<Estacao, Integer>{
	public Optional<Estacao> findById(Integer idEstacao);
    public List<Estacao> findAll();
}
