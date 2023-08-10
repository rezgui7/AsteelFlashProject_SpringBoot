package com.example.asteelflash.services;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {
    @Autowired
    EquipeRepository equipeRepository;

    //----------------------CRUD--------------------------------------------------------------------------------------

    public Equipe addEquipe(Equipe cl){return equipeRepository.save(cl);}

    public List<Equipe> displayEquipe(){ return (List<Equipe>) equipeRepository.findAll();}


    public Equipe displayEquipe(long idEquipe){return equipeRepository.findById(idEquipe).get();}

    public Equipe modifieEquipe(Equipe cl){ return equipeRepository.save(cl); }

    public void deleteEquipe(Equipe cl){equipeRepository.delete(cl);}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
