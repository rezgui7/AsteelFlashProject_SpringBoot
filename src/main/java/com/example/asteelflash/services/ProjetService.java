package com.example.asteelflash.services;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.entities.Projets;
import com.example.asteelflash.repositories.ProjetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {
    @Autowired
    ProjetsRepository projetsRepository;

//----------------------CRUD--------------------------------------------------------------------------------------

    public Projets addProjets(Projets cl){return projetsRepository.save(cl);}

    public List<Projets> displayProjets(){ return (List<Projets>) projetsRepository.findAll();}


    public Projets displayProjets(long idEquipe){return projetsRepository.findById(idEquipe).get();}

    public Projets modifieProjets(Projets cl){ return projetsRepository.save(cl); }

    public void deleteProjets(Projets cl){projetsRepository.delete(cl);}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
