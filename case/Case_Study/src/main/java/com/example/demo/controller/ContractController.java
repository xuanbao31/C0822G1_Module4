package com.example.demo.controller;

import com.example.demo.model.contract.*;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.facility.Facility;
import com.example.demo.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

@Controller
@RequestMapping("/contract")
public class ContractController {
    private ContractDetailService contractDetailService;
    private AttachFacilityService attachFacilityService;
    private ContractService contractService;
    private CustomerService customerService;
    private FacilityService facilityService;

    public ContractController(ContractDetailService contractDetailService,
                              AttachFacilityService attachFacilityService,
                              ContractService contractService,
                              CustomerService customerService,
                              FacilityService facilityService) {
        this.contractDetailService = contractDetailService;
        this.attachFacilityService = attachFacilityService;
        this.contractService = contractService;
        this.customerService = customerService;
        this.facilityService = facilityService;
    }

    @ModelAttribute("attachFacilities")
    public List<AttachFacility> getListAttachFacility() {
        return attachFacilityService.findAll();
    }

    @ModelAttribute("contractDetailService")
    public List<ContractDetail> getListContractDetail() {
        return contractDetailService.findAll();
    }

    @ModelAttribute("customerServices")
    public List<Customer> getListCustomer() {
        return customerService.showList();
    }

    @ModelAttribute("facilityServices")
    public List<Facility> getListFacility() {
        return facilityService.showList();
    }


    @GetMapping("")
    public String showListContract(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<IContractDto> contractDtoPage = contractService.showListContractDto(pageable);
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        model.addAttribute("contractDtoPage", contractDtoPage);
        model.addAttribute("attachFacilityList", attachFacilityList);
        model.addAttribute("contract", new Contract());
        model.addAttribute("customerPage", customerService.findAll());
        model.addAttribute("facilityPage", facilityService.findAll());
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractDetailList", contractDetailService.findAll());
//        model.addAttribute("employeePage", employeeService.findAll(pageable));
        return "contract/list";
    }

    @GetMapping("/add")
    public String showFormCreate(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("facility", facilityService.findAll());
        model.addAttribute("customer", customerService.findAll());
        return "redirect:/contract";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("contract") Contract contract, Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("facility", facilityService.findAll());
        model.addAttribute("customer", customerService.findAll());
        model.addAttribute("mess", 1);
        contractService.save(contract);
        return "redirect:/contract";
    }
    @PostMapping("/attach")
    public String saveAttach(@ModelAttribute("contractDetail") ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return "redirect:/contract";
    }
}
