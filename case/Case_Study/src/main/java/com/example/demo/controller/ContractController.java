package com.example.demo.controller;

import com.example.demo.model.contract.AttachFacility;
import com.example.demo.model.contract.Contract;
import com.example.demo.model.contract.ContractDetail;
import com.example.demo.model.contract.ContractDto;
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
        Page<Contract> contractPage = contractService.showList(pageable);
        Page<ContractDto> contractDtoPage = contractPage.map(new Function<Contract, ContractDto>() {
            @Override
            public ContractDto apply(Contract contract) {
                ContractDto contractDto = new ContractDto();
                BeanUtils.copyProperties(contract, contractDto);
                contractDto.getTotalcost();
                return contractDto;
            }
        });
        model.addAttribute("contracts", contractDtoPage);
//        modelAndView.addObject("contractDetail",new ContractDetail());
//        modelAndView.addObject("contractDto", new ContractDto());

//        LocalDate minAge = LocalDate.now();
//        model.addAttribute("minAge", minAge);

        return "/contract/list";
    }
}
