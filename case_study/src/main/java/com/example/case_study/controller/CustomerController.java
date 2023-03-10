package com.example.case_study.controller;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.customer.CustomerDto;
import com.example.case_study.model.customer.CustomerType;
import com.example.case_study.service.ICustomerService;
import com.example.case_study.service.ICustomerTypeService;
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

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;



    @GetMapping("/list")
    public String showAndSearch(@PageableDefault(value = 4) Pageable pageable, @RequestParam(value = "name", defaultValue = "") String name,
                                @RequestParam(value = "email", defaultValue = "") String email,
                                @RequestParam(value = "customerType", defaultValue = "") String customerType, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerType", customerType);
        model.addAttribute("customers", customerService.findByName(pageable, name, email, customerType));
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String saveCreate(@Validated @ModelAttribute CustomerDto customerDto,
                             BindingResult bindingResult,
//                             @PageableDefault(value = 4) Pageable pageable,
                             Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "/customer/create";
        } else {
            Customer customer = new Customer();
            System.out.println(customerDto);
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            return "redirect:/customer/list";
        }
    }

    @GetMapping("{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customerType", customerTypeService.findAll());
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            return "redirect:/customer/list";
        }
    }

    @GetMapping("{id}/delete")
    public String showDeleteFormCustomer(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customer.setStatus(1);
        customerService.save(customer);
//            customerService.remove(customer.getId());
        return "redirect:/customer/list";
    }
}
