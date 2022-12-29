package com.example.case_study.controller;

import com.example.case_study.model.facility.Facility;
import com.example.case_study.model.facility.FacilityDto;
import com.example.case_study.service.IFacilityService;
import com.example.case_study.service.IFacilityTypeService;
import com.example.case_study.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

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

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        model.addAttribute("facilityDto", new FacilityDto());
        return "/facility/create";

    }

    @PostMapping("/save")
    public String saveFacility(@Validated @ModelAttribute FacilityDto facilityDto,
                               BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityType", facilityTypeService.findAll());
            model.addAttribute("rentType", rentTypeService.findAll());
            return "/facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            model.addAttribute("facilityType", facilityTypeService.findAll());
            model.addAttribute("rentType", rentTypeService.findAll());
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
            return "redirect:/facility/list";
        }
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        Facility facility = facilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility, facilityDto);
        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute FacilityDto facilityDto) {
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        return "redirect:/facility/list";
    }
}
