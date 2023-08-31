package com.example.asteelflash.services;

import com.example.asteelflash.entities.Projets;
import com.example.asteelflash.entities.ScheduleEntry;
import com.example.asteelflash.repositories.ScheduleEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleEntryService {
    @Autowired
    ScheduleEntryRepository scheduleEntryRepository;

//----------------------CRUD--------------------------------------------------------------------------------------

    public ScheduleEntry addScheduleEntry(ScheduleEntry cl){return scheduleEntryRepository.save(cl);}

    public List<ScheduleEntry> displayScheduleEntry(){ return (List<ScheduleEntry>) scheduleEntryRepository.findAll();}


    public ScheduleEntry displayScheduleEntry(long idScheduleEntry){return scheduleEntryRepository.findById(idScheduleEntry).get();}

    public ScheduleEntry modifieScheduleEntry(ScheduleEntry cl){ return scheduleEntryRepository.save(cl); }

    public void deleteScheduleEntry(ScheduleEntry cl){scheduleEntryRepository.delete(cl);}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
