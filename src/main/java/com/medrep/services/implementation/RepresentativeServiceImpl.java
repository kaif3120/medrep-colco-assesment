package com.medrep.services.implementation;

import java.util.List;
import java.util.Optional;

import com.medrep.model.Drug;
import com.medrep.model.Representative;
import com.medrep.repository.DrugRepository;
import com.medrep.repository.RepresentativeRepository;
import com.medrep.services.RepresentativeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepresentativeServiceImpl implements RepresentativeService{
    
     @Autowired
    private RepresentativeRepository representativeRepository;

    @Autowired
    private DrugRepository drugRepository;


    @Override
    public Optional<Representative> getRepresentative(int id) {
        return this.representativeRepository.findById(id);
    }

    @Override
    public void deleteRepresentative(int id) {
        this.representativeRepository.deleteById(id);
    }

    @Override
    public Representative addRepresentative(Representative representative) {
        return this.representativeRepository.save(representative);
    }

    @Override
    public Representative updateRepresentative(Representative representative) {
          return this.representativeRepository.save(representative);
    }

    @Override
    public void addDrugToRepresentative(Drug drug, int representativeId) {
        drug.setRepresentative(this.representativeRepository.findById(representativeId).get());
        this.drugRepository.save(drug);
    }

    @Override
    public void removeDrug(long drugId) {
        this.drugRepository.deleteById(drugId);
    }

    @Override
    public List<Representative> getRepresentatives() {
        return this.representativeRepository.findAll();
    }
    
}
