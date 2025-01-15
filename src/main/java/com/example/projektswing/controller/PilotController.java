package com.example.projektswing.controller;

import com.example.projektswing.model.Pilot;
import com.example.projektswing.service.PilotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pilots")
public class PilotController {

    private PilotService pilotService;

    @Autowired
    public PilotController(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("pilots", pilotService.getAllPilots());
        return "pilot_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id) {
        Pilot pilot = pilotService.getPilotById(id);
        if (pilot != null) {
            model.addAttribute("pilot", pilot);
            return "pilot_detail";
        }
        return "redirect:/pilots/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        pilotService.deletePilotById(id);
        return "redirect:/pilots/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pilot", new Pilot());
        model.addAttribute("edit", false);
        return "pilot_edit";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        Pilot pilot = pilotService.getPilotById(id);
        if (pilot != null) {
            model.addAttribute("pilot", pilot);
            model.addAttribute("edit", true);
            return "pilot_edit";
        }
        return "redirect:/pilots/";
    }

    @PostMapping("/save")
    public String save(@Valid Pilot pilot, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            return "pilot_edit";
        }
        pilotService.savePilot(pilot);
        return "redirect:/pilots/";
    }
}
