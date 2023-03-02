package com.projeto.bankapp.controllers;

import com.projeto.bankapp.entities.ClientEntity;
import com.projeto.bankapp.repositories.ClientRepository;
import com.projeto.bankapp.services.Clientservice;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.AuthenticationException;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ClientController {

    private final ClientRepository clientRepository;
    private final Clientservice clientservice;


    @Autowired
    public ClientController(ClientRepository clientRepository, Clientservice clientservice){
        this.clientRepository = clientRepository;
        this.clientservice = clientservice;
    }


    @RequestMapping("/register")
    public ModelAndView registerForm() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @RequestMapping("/afterlogin")
    public ModelAndView afterregisterForm() {
        ModelAndView modelAndView = new ModelAndView("afterlogin");
        return modelAndView;
    }

    @PostMapping("/criarNovoCliente")
    public ModelAndView criarNovoCliente(
            @RequestParam String datanascimento,
            @RequestParam String segundonome,
            @RequestParam int telefone,
            @RequestParam String email,
            @RequestParam String primeironome,
            @RequestParam int nif,
            @RequestParam String profissao,
            @RequestParam String password,
            @RequestParam int telemovel) {

        clientservice.criarNovoCliente(nif, primeironome, segundonome,password , datanascimento, telefone, telemovel, email,
                profissao);
        return new ModelAndView("login");
    }

    @PostMapping("/logIn")
    public ModelAndView logIn(
            @RequestParam Integer nif,
            @RequestParam String password,
            HttpSession session) throws AuthenticationException {
        clientservice.login(nif, password);
        ClientEntity cliente = clientservice.login(nif, password);
        if (cliente == null) {
            throw new AuthenticationException("Invalid login credentials");
        }
        else {
            // Set client information in session
            session.setAttribute("clientId", session.getId());
            session.setAttribute("clientName", cliente.getPrimeironome() + " " + cliente.getSegundonome());
            //session.setAttribute("clientEmail", cliente.getEmail());


            return new ModelAndView("afterlogin");
        }
    }


    @RequestMapping ("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping
    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> getClientById(@PathVariable Long id) {
        ClientEntity client = clientRepository.findById(String.valueOf(id)).orElse(null);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientEntity createClient(@RequestBody ClientEntity client) {
        return clientRepository.save(client);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (!clientRepository.existsById(String.valueOf(id))) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }

}