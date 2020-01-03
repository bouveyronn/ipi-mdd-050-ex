package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employes")
public class EmployeController {

    @Autowired
    private EmployeRepository employeRepository;

    @RequestMapping("/count")
    public long countEmployes(){
        //Récupérer le nbr d'employés et l'envoyer au client
        return employeRepository.count();
    }

}
