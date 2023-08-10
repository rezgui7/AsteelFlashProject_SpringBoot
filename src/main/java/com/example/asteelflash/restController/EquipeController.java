package com.example.asteelflash.restController;

import com.example.asteelflash.entities.Equipe;
import com.example.asteelflash.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
    @Autowired
    EquipeService equipeService;

    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe ct){return equipeService.addEquipe(ct);}

    @GetMapping("/displayEquipe")
    public List<Equipe> displayEquipe(){ return (List<Equipe>) equipeService.displayEquipe();}

    @GetMapping("/displayEquipeByID")
    public Equipe displayEquipe(@RequestParam long idEquipe){return equipeService.displayEquipe((int)idEquipe);}


    @PutMapping("/updateEquipe")
    public Equipe modifieEquipe(@RequestBody Equipe ct){ return equipeService.modifieEquipe(ct); }


    @DeleteMapping("/deleteEquipe")
    public void deleteEquipe(@RequestBody Equipe ct){equipeService.deleteEquipe(ct);}
}
