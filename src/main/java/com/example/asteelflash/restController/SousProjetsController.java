package com.example.asteelflash.restController;

import com.example.asteelflash.entities.Projets;
import com.example.asteelflash.entities.Sous_projets;
import com.example.asteelflash.services.SousProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/SousProjets")
public class SousProjetsController {
    @Autowired
    SousProjetService sousProjetService;

    @PostMapping("/addSousProjets")
    public Sous_projets addSousProjets(@RequestBody Sous_projets ct){return sousProjetService.addSousProjets(ct);}

    @GetMapping("/displaySousProjets")
    public List<Sous_projets> displaySousProjets(){ return (List<Sous_projets>) sousProjetService.displaySousProjets();}

    @GetMapping("/displaySousProjetsByID")
    public Sous_projets displaySousProjets(@RequestParam long idSousProjets){return sousProjetService.displaySousProjets((int)idSousProjets);}


    @PutMapping("/updateSousProjets")
    public Sous_projets modifieSousProjets(@RequestBody Sous_projets ct){ return sousProjetService.modifieSousProjets(ct); }


    @DeleteMapping("/deleteSousProjets")
    public void deleteSousProjets(@RequestBody Sous_projets ct){sousProjetService.deleteSousProjets(ct);}

    @PostMapping("addSousProjet/{idProjet}")
    public Sous_projets addSousProjet(@RequestBody Sous_projets sp ,@PathVariable("idProjet") Long idProjet){
        return sousProjetService.AjouterSousProjetEtAffecterProjet(sp, idProjet);
    }
    @PostMapping("assignEquipe/{idSousProjet}/{idEquipe}")
    public ResponseEntity<String> AssignTeam(@PathVariable("idSousProjet") Long idSousProjet , @PathVariable("idEquipe") Long idEquipe){
        sousProjetService.AssignTeam(idSousProjet, idEquipe);
        return ResponseEntity.ok("Equipe assigned successfully.");
    }
    @GetMapping("/displaySousProjetsByProjetID/{idProjets}")
    public List<Sous_projets> displaySousProjetsWithProjetID(@PathVariable("idProjets") Long idProjets){return sousProjetService.getSousProjectsByProjectId(idProjets);}

}
