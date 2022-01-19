package com.medrep.services.implementation;

import java.util.List;
import java.util.Optional;

import com.medrep.model.Drug;
import com.medrep.repository.DrugRepository;
import com.medrep.services.DrugService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugServiceImpl implements DrugService{

    @Autowired
    private DrugRepository drugRepository;

    @Override
    public Optional<Drug> getDrug(long id) {
        return this.drugRepository.findById(id);
    }

    @Override
    public List<Drug> getDrugs() {
        return this.drugRepository.findAll();
    }

    @Override
    public Drug addDrug(Drug drug) {
        return this.drugRepository.save(drug);
    }

    @Override
    public Drug updateDrug(Drug drug) {
          return this.drugRepository.save(drug);
    }

    @Override
    public void deleteDrug(long id) {
        this.drugRepository.deleteById(id);
    }

    @Override
    public List<Drug> getDrugsByRepId(int id) {
        return this.drugRepository.findByRepresentative_Id(id);
    }
    
}
