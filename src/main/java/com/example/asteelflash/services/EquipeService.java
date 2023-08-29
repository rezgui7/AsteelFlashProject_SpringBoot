package com.example.asteelflash.services;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.entities.EquipeMember;
import com.example.asteelflash.entities.Sous_projets;
import com.example.asteelflash.repositories.EquipeRepository;
import com.example.asteelflash.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EquipeService {
    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    MemberRepository memberRepository;

    //----------------------CRUD--------------------------------------------------------------------------------------

    public Equipe addEquipe(Equipe cl){return equipeRepository.save(cl);}

    public List<Equipe> displayEquipe(){ return (List<Equipe>) equipeRepository.findAll();}


    public Equipe displayEquipe(long idEquipe){return equipeRepository.findById(idEquipe).get();}

    public Equipe modifieEquipe(Equipe cl){ return equipeRepository.save(cl); }

    public void deleteEquipe(Equipe cl){equipeRepository.delete(cl);}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<Equipe> searchEquipeByName(String pmName){
    return equipeRepository.findByName(pmName);
}

    public void AssignMember(Long idMember, Long idEquipe ) {

        Equipe equipe = equipeRepository.findById(idEquipe).get();
        EquipeMember em= memberRepository.findById(idMember).get();
        equipe.getEquipeMembers().add((EquipeMember) em);
        em.setState("Assigned");

        equipeRepository.save(equipe);
    }

    @Transactional
    public void unassignMemberFromEquipe(Long idMember, Long idEquipe) {
        EquipeMember member = memberRepository.findById(idMember).get();
        Equipe equipe = equipeRepository.findById(idEquipe).get();


        if (member == null) {
            System.out.println("Utilisateur not found with ID: " + idMember);
            return;
        }

        if (equipe == null) {
            System.out.println("Classe not found with ID: " + idEquipe);
            return;
        }

        if (member.getEquipes().contains(equipe)) {
            member.getEquipes().remove(equipe);
            equipe.getEquipeMembers().remove(member);
            equipeRepository.save(equipe);
            memberRepository.save(member);
            System.out.println("User unassigned from class.");
        } else {
            System.out.println("User was not assigned to the class.");
        }
    }


    public List<EquipeMember> getEquipeMemberByEquipeId(Long equipeId) {
        return equipeRepository.findByEquipe_Id(equipeId);
    }

    public Equipe getMostHardWorking(){
        int n=200;
        List<Equipe> e = (List<Equipe>) equipeRepository.findAll();
        Equipe highestEquipeList =  Collections.max(e, Comparator.comparingInt(Equipe::getNcp));

        return highestEquipeList;
    }

    public List<Equipe> displayEquipewithoutMember(){ return (List<Equipe>) equipeRepository.findTeamsWithoutMembers();}

}
