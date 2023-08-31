package com.example.asteelflash.restController;

import com.example.asteelflash.entities.Projets;
import com.example.asteelflash.entities.ScheduleEntry;
import com.example.asteelflash.services.ScheduleEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/schedule")
public class ScheduleEntryController {

    @Autowired
    ScheduleEntryService scheduleEntryService;

    @PostMapping("/addScheduleEntry")
    public ScheduleEntry addScheduleEntry(@RequestBody ScheduleEntry ct){return scheduleEntryService.addScheduleEntry(ct);}

    @GetMapping("/displayScheduleEntry")
    public List<ScheduleEntry> displayScheduleEntry(){ return (List<ScheduleEntry>) scheduleEntryService.displayScheduleEntry();}

    @GetMapping("/displayScheduleEntryByID/{idScheduleEntry}")
    public ScheduleEntry displayScheduleEntry(@PathVariable("idScheduleEntry") long idScheduleEntry){return scheduleEntryService.displayScheduleEntry((int)idScheduleEntry);}


    @PutMapping("/updateScheduleEntry")
    public ScheduleEntry modifieScheduleEntry(@RequestBody ScheduleEntry ct){ return scheduleEntryService.modifieScheduleEntry(ct); }


    @DeleteMapping("/deleteScheduleEntry")
    public void deleteScheduleEntry(@RequestBody ScheduleEntry ct){scheduleEntryService.deleteScheduleEntry(ct);}

}
