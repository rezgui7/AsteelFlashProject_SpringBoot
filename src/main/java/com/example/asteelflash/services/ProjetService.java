package com.example.asteelflash.services;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.entities.Projets;
import com.example.asteelflash.repositories.ProjetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProjetService {
    @Autowired
    ProjetsRepository projetsRepository;

//----------------------CRUD--------------------------------------------------------------------------------------

    public Projets addProjets(Projets cl){return projetsRepository.save(cl);}

    public List<Projets> displayProjets(){ return (List<Projets>) projetsRepository.findAll();}


    public Projets displayProjets(long idEquipe){return projetsRepository.findById(idEquipe).get();}

    public Projets modifieProjets(Projets cl){ return projetsRepository.save(cl); }

    public void deleteProjets(long cl){projetsRepository.deleteById(cl);}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public float progressPourcentage(){
        float sum=0;
        float result=0;
        List<Projets> projets= (List<Projets>) projetsRepository.findAll();
        for (Projets p :projets) {

            sum+=p.getProgress();
        }
        result=sum/projets.size();
        return result;
    }

    public float mean_Lead_Time(){
        float sum=0;
        float result=0;
        List<Projets> projets= (List<Projets>) projetsRepository.findAll();
        for (Projets p :projets) {

            sum+=p.getLead_time();
        }
        result=sum/projets.size();
        return result;
    }
}
