package com.example.asteelflash.restController;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.entities.EquipeMember;
import com.example.asteelflash.entities.Sous_projets;
import com.example.asteelflash.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/equipe")
public class EquipeController {
    @Autowired
    EquipeService equipeService;

    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe ct){return equipeService.addEquipe(ct);}

    @GetMapping("/displayEquipe")
    public List<Equipe> displayEquipe(){ return (List<Equipe>) equipeService.displayEquipe();}

    @GetMapping("/displayEquipeByID/{idEquipe}")
    public Equipe displayEquipe(@PathVariable("idEquipe") long idEquipe){return equipeService.displayEquipe((int)idEquipe);}


    @PutMapping("/updateEquipe")
    public Equipe modifieEquipe(@RequestBody Equipe ct){ return equipeService.modifieEquipe(ct); }


    @DeleteMapping("/deleteEquipe")
    public void deleteEquipe(@RequestBody Equipe ct){equipeService.deleteEquipe(ct);}
    @PostMapping("assignMember/{idEquipe}/{sp}")
    public ResponseEntity<String> assignMember(@PathVariable("sp") Long sp , @PathVariable("idEquipe") Long idEquipe){
        equipeService.AssignMember(sp, idEquipe);
        return ResponseEntity.ok("Equipe member assigned successfully.");
    }

    @GetMapping("/displayMemberByEquipeID/{idMember}")
    public List<EquipeMember> displayMemberByEquipeID(@PathVariable("idMember") Long idMember){return equipeService.getEquipeMemberByEquipeId(idMember);}

    @PostMapping("/unassign/{idMember}/{equipeId}")
    public ResponseEntity<String> unassignUserFromClass(@PathVariable("idMember") Long idMember, @PathVariable("equipeId") Long equipeId) {
        equipeService.unassignMemberFromEquipe(idMember, equipeId);
        return ResponseEntity.ok("User unassigned from class successfully.");
    }

}
