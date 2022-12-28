package com.example.case_study.controller;

import com.example.case_study.service.IFacilityService;
import com.example.case_study.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;

    @GetMapping("/list")
    public String showAndSearchFacility(@PageableDefault(value = 3) Pageable pageable, @RequestParam(value = "name", defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("facility", facilityService.findByName(pageable, name));
        return "/facility/list";

    }
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "deleteId") int facilityId) {
        facilityService.remove(facilityId);
        return "redirect:/facility/list";
    }



}
