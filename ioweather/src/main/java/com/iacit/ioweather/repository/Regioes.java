package com.iacit.ioweather.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.iacit.ioweather.model.Regiao;



@RepositoryRestResource 
public interface Regioes extends JpaRepository<Regiao, Integer>{
    public Optional<Regiao> findById(Integer idRegiao);
    public List<Regiao> findAll();

}
