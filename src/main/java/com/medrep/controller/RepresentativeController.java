package com.medrep.controller;

import com.medrep.model.Drug;
import com.medrep.model.Representative;
import com.medrep.services.DrugService;
import com.medrep.services.RepresentativeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/representative")
public class RepresentativeController {
    
    @Autowired
    private RepresentativeService representativeService;

    @Autowired
    private DrugService drugService;



    // for adding representative where you could choose to pass list of drugs along with the rep data or can just send reps data
    @PostMapping("/")
    public ResponseEntity<?> addRepresentaive(@RequestBody Representative representative){
        
        Representative response = this.representativeService.addRepresentative(representative);
        
        for (Drug drug : representative.getDrugs()) {
            drug.setRepresentative(response);
            this.drugService.addDrug(drug);
        }

        if(response == null){
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(response);
    }


    // to get the list of all the representatives
    @GetMapping("/")
    public List<Representative> getRepresentatives(){
        return this.representativeService.getRepresentatives();
    }

    // to get the representative by id 
     @GetMapping("/{id}")
    public ResponseEntity<?> getRepresentative(@PathVariable("id") int id){
        Optional<Representative> rep = this.representativeService.getRepresentative(id);
        if(rep.isEmpty()){
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(rep.get());
    }

    // delete representative by Id
    @DeleteMapping("/{id}")
    public void deleteRepresentative(@PathVariable("id") int id){
       this.representativeService.deleteRepresentative(id);
    }

    // to update the representative data
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRepresentative(@PathVariable("id") int id, @RequestBody Representative representative)
    {
        representative.setId(id);
        Representative response = this.representativeService.updateRepresentative(representative);
        if(response == null){
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(response);
    }

    //to add drugs to the representative where you could give representative id as the path variable
    @PostMapping("/{id}/drug")
    public void addDrugToRep(@PathVariable("id") int id, @RequestBody Drug drug){
        this.representativeService.addDrugToRepresentative(drug, id);
    }    


    // to delete any drug by drug's id
    @DeleteMapping("/drug/{id}")
    public void deleteDrug(@PathVariable("id") long drugId){
        this.representativeService.removeDrug(drugId);
    }

}
