package com.example.asteelflash.restController;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.entities.Projets;
import com.example.asteelflash.services.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/projet")
public class ProjetController {
    @Autowired
    ProjetService projetService;

    @PostMapping("/addProjets")
    public Projets addProjets(@RequestBody Projets ct){return projetService.addProjets(ct);}

    @GetMapping("/displayProjets")
    public List<Projets> displayProjets(){ return (List<Projets>) projetService.displayProjets();}

    @GetMapping("/displayProjetsByID/{idProjets}")
    public Projets displayProjets(@PathVariable("idProjets") long idProjets){return projetService.displayProjets((int)idProjets);}


    @PutMapping("/updateProjets")
    public Projets modifieProjets(@RequestBody Projets ct){ return projetService.modifieProjets(ct); }


    @DeleteMapping("/deleteProjets/{idProjets}")
    public void deleteProjets(@PathVariable("idProjets") long idProjets){projetService.deleteProjets(idProjets);}

    @GetMapping("/displayresult")
    public float displayresult(){ return (float) projetService.progressPourcentage();}

    @GetMapping("/displayresultLead")
    public float displayresultLead(){ return (float) projetService.mean_Lead_Time();}


}
