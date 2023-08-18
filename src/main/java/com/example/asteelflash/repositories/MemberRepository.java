package com.example.asteelflash.repositories;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.entities.EquipeMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository  extends CrudRepository<EquipeMember,Long> {
    @Query("select t from EquipeMember t where t.prenom=?1")
    List<EquipeMember> findByName(String peName);
}
