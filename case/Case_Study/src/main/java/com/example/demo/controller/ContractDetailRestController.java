package com.example.demo.controller;

import com.example.demo.model.contract.AttachFacilityDto;
import com.example.demo.service.IAttachFacilityService;
import com.example.demo.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts/v1")
@CrossOrigin("*")
public class ContractDetailRestController {
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("{id}")
    public ResponseEntity<List<AttachFacilityDto>> showAttach(@PathVariable int id) {
        List<AttachFacilityDto> attachFacilityDto = attachFacilityService.findAllAttach(id);
        return new ResponseEntity<>(attachFacilityDto, HttpStatus.OK);
    }
}
