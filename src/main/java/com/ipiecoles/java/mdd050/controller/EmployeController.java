package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.model.Employe;
import com.ipiecoles.java.mdd050.repository.CommercialRepository;
import com.ipiecoles.java.mdd050.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.CommandAPDU;

@RestController
@RequestMapping("/employes")
public class EmployeController {

    @Autowired
    private EmployeRepository employeRepository;


    //@RequestMapping("/count")//GET par défaut
    //@GetMapping("/count")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long countEmployes(){
        //Récupérer le nbr d'employés et l'envoyer au client
        return employeRepository.count();
    }

    /*

    @RequestMapping("/6")
    public Employe GetEmployeById(){
        return employeRepository.findOne(6L);
    }

     */
    @RequestMapping(value = "/{id}")
    public Employe GetEmployeById(
            @PathVariable(value = "id") Long id)
    {
        return employeRepository.findOne(id);
    }

}
