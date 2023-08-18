package com.example.asteelflash.services;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.entities.EquipeMember;
import com.example.asteelflash.entities.Projets;
import com.example.asteelflash.entities.Sous_projets;
import com.example.asteelflash.repositories.EquipeRepository;
import com.example.asteelflash.repositories.ProjetsRepository;
import com.example.asteelflash.repositories.SousProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SousProjetService {
    @Autowired
    SousProjetRepository sousProjetRepository;

    @Autowired
    ProjetsRepository projetsRepository;

    @Autowired
    EquipeRepository equipeRepository;

//----------------------CRUD--------------------------------------------------------------------------------------

    public Sous_projets addSousProjets(Sous_projets cl){
        Sous_projets sous_projets = new Sous_projets();
        sous_projets.setSousProjetType(cl.getSousProjetType());
        sous_projets.setState("Not Awarded");

        return sousProjetRepository.save(sous_projets);
    }

    public List<Sous_projets> displaySousProjets(){ return (List<Sous_projets>) sousProjetRepository.findAll();}


    public Sous_projets displaySousProjets(long idSousProjets){return sousProjetRepository.findById(idSousProjets).get();}

    public Sous_projets modifieSousProjets(Sous_projets cl){ return sousProjetRepository.save(cl); }

    public void deleteSousProjets(Sous_projets cl){sousProjetRepository.delete(cl);}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Sous_projets AjouterSousProjetEtAffecterProjet(Sous_projets sp,Long idProjet){
        Projets p = projetsRepository.findById(idProjet).get();
        sp.setProjets(p);
        sp.setState("Not Assigned");
        return sousProjetRepository.save(sp);
    }

    public void AssignTeam(Long idSousProjet, Long idEquipe ) {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        Sous_projets sp= sousProjetRepository.findById(idSousProjet).get();
        equipe.getSous_projets().add( sp);
        sp.setState("Assigned");
        equipeRepository.save(equipe);
    }

    public List<Sous_projets> getSousProjectsByProjectId(Long projectId) {
        return sousProjetRepository.findByProjets_Id(projectId);
    }

}
