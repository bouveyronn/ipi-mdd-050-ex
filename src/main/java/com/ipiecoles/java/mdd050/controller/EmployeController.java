package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.model.Employe;
import com.ipiecoles.java.mdd050.repository.CommercialRepository;
import com.ipiecoles.java.mdd050.repository.EmployeRepository;
import javafx.scene.control.TableColumn;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.CommandAPDU;
import java.util.List;

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


    @RequestMapping
    public Employe GetEmployerByMatricule(
            @RequestParam("matricule") String matricule
    )
    {
        return employeRepository.findByMatricule(matricule);
    }

    @GetMapping(params = {"page","size","sortProperty","sortDirection"})
    public Page<Employe> GetEmployees(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam("sortProperty") String sortProperty,
            @RequestParam("sortDirection") String sortDirection
    )
    {
        PageRequest Pagination = new PageRequest(page,size, Sort.Direction.ASC,sortProperty);
        return employeRepository.findAll(Pagination);

    }



}
