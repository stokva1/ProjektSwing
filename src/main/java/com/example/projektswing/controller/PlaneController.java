package com.example.projektswing.controller;

import com.example.projektswing.model.Plane;
import com.example.projektswing.service.PlaneService;
import com.example.projektswing.service.PilotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/planes")
public class PlaneController {

    private PlaneService planeService;
    private PilotService pilotService;

    @Autowired
    public PlaneController(PlaneService planeService, PilotService pilotService) {
        this.planeService = planeService;
        this.pilotService = pilotService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("planes", planeService.getAllPlanes());
        return "plane_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id) {
        Plane plane = planeService.getPlaneById(id);
        if (plane != null) {
            model.addAttribute("plane", plane);
            return "plane_detail";
        }
        return "redirect:/planes/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        planeService.deletePlaneById(id);
        return "redirect:/planes/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("plane", new Plane());
        model.addAttribute("edit", false);
        model.addAttribute("pilots", pilotService.getAllPilots());
        return "plane_edit";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Plane plane = planeService.getPlaneById(id);
        if (plane != null) {
            plane.setId(id);
            model.addAttribute("plane", plane);
            model.addAttribute("edit", true);
            model.addAttribute("pilots", pilotService.getAllPilots());
            return "plane_edit";
        }
        return "redirect:/planes/";
    }

    @PostMapping("/save")
    public String save(@Valid Plane plane, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            return "plane_edit";
        }
        planeService.savePlane(plane);
        return "redirect:/planes/";
    }
}
