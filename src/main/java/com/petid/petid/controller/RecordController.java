package com.petid.petid.controller;

import com.petid.petid.model.Animal;
import com.petid.petid.model.Record;
import com.petid.petid.service.AnimalService;
import com.petid.petid.service.RecordService;
import com.petid.petid.userdetails.UserDetailsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Controller
@SessionAttributes({"animal", "record"})
public class RecordController {

    @Autowired
    private RecordService recordService;
    @Autowired
    private AnimalService animalService;

    @GetMapping("/add-record/record-information/{animalId}")
    public String addRecordInformation(@PathVariable("animalId") UUID animalId, Record record, Model model) {


        Optional<Animal> animal = animalService.findById(animalId);

        if(!animal.isPresent()){
            return "redirect:/animals";
        }

        record.setAnimal(animal.get());

        model.addAttribute("animal", animal.get());
        model.addAttribute("record", record);
        model.addAttribute("action", "add");

        return "record-information";
    }

    @PostMapping("/add-record/record-information")
    public String addRecord(@Valid Record record, BindingResult bindingResult, @SessionAttribute(name = "animal", required = false)Animal animal, Model model,
                            @AuthenticationPrincipal UserDetailsCustom user, SessionStatus sessionStatus) {

        model.addAttribute("animal", animal);
        model.addAttribute("record", record);
        model.addAttribute("action", "add");

        if(animal == null || animal.getId() == null){
            return "redirect:/animals";
        }

        if(bindingResult.hasErrors()){
            return "record-information";
        }

        record.setAnimal(animal);
        record.setUser(user.getUser());

        recordService.save(record);

        sessionStatus.setComplete();

        return "redirect:/animal/"+animal.getMicrochip();
    }

    @GetMapping("/edit-record/{id}")
    public String editRecordInformation(@PathVariable("id") UUID id, Model model) {

        Optional<Record> record = recordService.findById(id);

        if(!record.isPresent()){
            return "redirect:/animals";
        }

        model.addAttribute("action", "edit");
        model.addAttribute("record", record.get());

        return "record-information";
    }

    @PostMapping("/edit-record/record-information")
    public String editRecord(@Valid Record record, @SessionAttribute(name = "record", required = false)Record oldRecord, BindingResult bindingResult,
                             Model model, SessionStatus sessionStatus) {

        record.setAnimal(oldRecord.getAnimal());
        record.setCreatedDateTime(oldRecord.getCreatedDateTime());
        record.setUser(oldRecord.getUser());

        model.addAttribute("record", record);
        model.addAttribute("action", "edit");

        if(bindingResult.hasErrors()){
            return "record-information";
        }

        recordService.save(record);

        sessionStatus.setComplete();

        return "redirect:/animal/"+record.getAnimal().getMicrochip();
    }

    @GetMapping("/delete-record/{id}")
    public String deleteRecord(@PathVariable("id") UUID id, Model model) {

        Optional<Record> record = recordService.findById(id);

        if(record.isPresent()){

            Animal animal = record.get().getAnimal();

            recordService.delete(record.get());

            return "redirect:/animal/"+animal.getMicrochip();
        }
        else{
            return "redirect:/animals";
        }
    }
}
