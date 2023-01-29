package owl.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import owl.models.SecondaryImageNames;
import owl.repository.SecondaryImageNamesRep;

@Service
public class SecondaryImageNamesService {
    private final SecondaryImageNamesRep secondaryImageNamesRep;

    @Autowired
    public SecondaryImageNamesService(SecondaryImageNamesRep secondaryImageNamesRep){
        this.secondaryImageNamesRep = secondaryImageNamesRep;
    }
    @Transactional
    public void addImageNames(List<SecondaryImageNames> imageNames){
        
        for(SecondaryImageNames name : imageNames){
            secondaryImageNamesRep.save(name);
        }
    }

    @Transactional
    public void addImageName(SecondaryImageNames imageNames){
        secondaryImageNamesRep.save(imageNames);
    }

    @Transactional
    public void deleteSecImages(long id){
        secondaryImageNamesRep.deleteAllByProductForSaleId(id);
    }
}
