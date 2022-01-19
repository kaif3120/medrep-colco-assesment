package com.medrep.repository;

import com.medrep.model.Representative;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentativeRepository extends JpaRepository<Representative,Integer>{
    
}
