package com.example.asteelflash.services;

import com.example.asteelflash.entities.Sous_projets;
import com.example.asteelflash.repositories.SousProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SousProjetService {
    @Autowired
    SousProjetRepository sousProjetRepository;

//----------------------CRUD--------------------------------------------------------------------------------------

    public Sous_projets addSousProjets(Sous_projets cl){return sousProjetRepository.save(cl);}

    public List<Sous_projets> displaySousProjets(){ return (List<Sous_projets>) sousProjetRepository.findAll();}


    public Sous_projets displaySousProjets(long idSousProjets){return sousProjetRepository.findById(idSousProjets).get();}

    public Sous_projets modifieSousProjets(Sous_projets cl){ return sousProjetRepository.save(cl); }

    public void deleteSousProjets(Sous_projets cl){sousProjetRepository.delete(cl);}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
