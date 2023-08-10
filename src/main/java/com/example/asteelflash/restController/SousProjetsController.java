package com.example.asteelflash.restController;

import com.example.asteelflash.entities.Sous_projets;
import com.example.asteelflash.services.SousProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
