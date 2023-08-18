package com.example.asteelflash.services;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.entities.EquipeMember;
import com.example.asteelflash.repositories.EquipeRepository;
import com.example.asteelflash.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EquipeRepository equipeRepository;

    //----------------------CRUD--------------------------------------------------------------------------------------

    public EquipeMember addEquipeMember(EquipeMember cl){return memberRepository.save(cl);}

    public List<EquipeMember> displayEquipeMember(){
        return (List<EquipeMember>) memberRepository.findAll();}


    public EquipeMember displayEquipeMember(long idEquipeMember){return memberRepository.findById(idEquipeMember).get();}

    public EquipeMember modifieEquipeMember(EquipeMember cl){ return memberRepository.save(cl); }

    public void deleteEquipeMember(EquipeMember cl){memberRepository.delete(cl);}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Boolean displayEquipeMember1(Long idMember) {

    EquipeMember em = memberRepository.findById(idMember).get();

    for (EquipeMember cl: memberRepository.findAll()) {
        if (cl.getIdMember()==idMember){
            return true;
        }


    }
return false;
}

}
