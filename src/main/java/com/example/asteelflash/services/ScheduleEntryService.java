package com.example.asteelflash.services;

import com.example.asteelflash.entities.Projets;
import com.example.asteelflash.entities.ScheduleEntry;
import com.example.asteelflash.repositories.ScheduleEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleEntryService {
    @Autowired
    ScheduleEntryRepository scheduleEntryRepository;

    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    MailService mailService;
//----------------------CRUD--------------------------------------------------------------------------------------

    public ScheduleEntry addScheduleEntry(ScheduleEntry cl){return scheduleEntryRepository.save(cl);}
    public ScheduleEntry addScheduleEntry2(ScheduleEntry cl){
        taskScheduler.schedule(() -> {
            mailService.sendMail("rezguiy67@gmail.com",cl.getTitle(),cl.getDescription());
            System.out.println("Task executed at " + new Date() );
        }, cl.getStartTime());
        return scheduleEntryRepository.save(cl);
    }

    public List<ScheduleEntry> displayScheduleEntry(){ return (List<ScheduleEntry>) scheduleEntryRepository.findAll();}


    public ScheduleEntry displayScheduleEntry(long idScheduleEntry){return scheduleEntryRepository.findById(idScheduleEntry).get();}

    public ScheduleEntry modifieScheduleEntry(ScheduleEntry cl){ return scheduleEntryRepository.save(cl); }

    public void deleteScheduleEntry(ScheduleEntry cl){scheduleEntryRepository.delete(cl);}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void sendRemaind(){
        Date currentDate = new Date();

        List<ScheduleEntry> scheduleEntries= (List<ScheduleEntry>) scheduleEntryRepository.findAll();
        for (ScheduleEntry sc:scheduleEntries) {
            if (sc.getStartTime().equals(currentDate)){
                mailService.sendMail("rezguiy67@gmail.com",sc.getTitle(),sc.getDescription());
            }
        }
    }
}
