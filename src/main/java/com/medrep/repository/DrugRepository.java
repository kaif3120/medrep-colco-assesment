package com.medrep.repository;

import java.util.List;

import com.medrep.model.Drug;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug,Long> {
 public List<Drug> findByRepresentative_Id(int id);    
}
