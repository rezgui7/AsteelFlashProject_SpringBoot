package com.example.asteelflash.restController;

import com.example.asteelflash.entities.EquipeMember;
import com.example.asteelflash.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/addEquipeMember")
    public EquipeMember addEquipeMember(@RequestBody EquipeMember ct){return memberService.addEquipeMember(ct);}

    @GetMapping("/displayEquipeMember")
    public List<EquipeMember> displayEquipeMember(){ return (List<EquipeMember>) memberService.displayEquipeMember();}

    @GetMapping("/displayEquipeMemberByID")
    public EquipeMember displayEquipeMember(@RequestParam long idEquipeMember){return memberService.displayEquipeMember((int)idEquipeMember);}

    @GetMapping("/test/{idM}")
    public boolean test(@PathVariable("idM") long idM){return memberService.displayEquipeMember1((long) idM);}


    @PutMapping("/updateEquipeMember")
    public EquipeMember modifieEquipeMember(@RequestBody EquipeMember ct){ return memberService.modifieEquipeMember(ct); }


    @DeleteMapping("/deleteEquipeMember")
    public void deleteEquipeMember(@RequestBody EquipeMember ct){memberService.deleteEquipeMember(ct);}
}
