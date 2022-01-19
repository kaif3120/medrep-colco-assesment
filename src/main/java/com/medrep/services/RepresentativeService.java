package com.medrep.services;

import java.util.List;
import java.util.Optional;

import com.medrep.model.Drug;
import com.medrep.model.Representative;

public interface RepresentativeService {
    
    public Optional<Representative> getRepresentative(int id);

    public void deleteRepresentative(int id);

    public Representative addRepresentative(Representative representative);
    
    public Representative updateRepresentative(Representative representative);
    
    public void addDrugToRepresentative(Drug drug, int representativeId);

    public void removeDrug(long drugId);

    public List<Representative> getRepresentatives();
}
