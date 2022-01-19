package com.medrep.services;

import java.util.List;
import java.util.Optional;

import com.medrep.model.Drug;

public interface DrugService {

    public Optional<Drug> getDrug(long id);
    
    public List<Drug> getDrugs();

    public Drug addDrug(Drug drug);

    public Drug updateDrug(Drug drug);

    public void deleteDrug(long id);

    public List<Drug> getDrugsByRepId(int id);

}
