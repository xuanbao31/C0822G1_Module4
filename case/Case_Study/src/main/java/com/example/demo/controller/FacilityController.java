package com.example.demo.controller;

import com.example.demo.model.facility.Facility;
import com.example.demo.model.facility.FacilityDto;
import com.example.demo.model.facility.FacilityType;
import com.example.demo.model.facility.RentType;
import com.example.demo.service.IFacilityService;
import com.example.demo.service.IFacilityTypeService;
import com.example.demo.service.IRentTypeService;
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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @ModelAttribute("rentType")
    public List<RentType> getRent() {
        return rentTypeService.findAll();
    }

    @GetMapping("/list")
    public String showFacility(@PageableDefault(value = 2) Pageable pageable, Model model) {
        model.addAttribute("facility", facilityService.findAll(pageable));
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("facilityType", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("rentType", rentTypeList);
        return "/facility/list";
    }

    @GetMapping("/search")
    public String searchName(@PageableDefault(value = 2) Pageable pageable,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "facilityType") String facilityType,
                             Model model) {
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("facilityType", facilityTypeList);
        model.addAttribute("facility", facilityService.findByName(pageable, name, facilityType));
        model.addAttribute("name", name);
        return "/facility/list";
    }

    @GetMapping("/create")
    public String showFormCreateVilla(Model model) {
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        model.addAttribute("facilityDto", new FacilityDto());
        return "/facility/create";
    }


    @PostMapping("/save")
    public String save(@Validated @ModelAttribute FacilityDto facilityDto,
                       BindingResult bindingResult,
                       @PageableDefault(value = 5) Pageable pageable,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
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

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "deleteId") int facilityId) {
        facilityService.remove(facilityId);
        return "redirect:/facility/list";
    }
}
