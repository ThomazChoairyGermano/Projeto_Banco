package com.br.banco.authentication.controller;

import com.br.banco.authentication.service.UserDetailsServiceImpl;
import com.br.banco.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class UserModelController {

    @Autowired
    UserDetailsServiceImpl service;

    @RequestMapping(value="/criar-usuario", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserDTO>  criarUsuario (@RequestBody UserDTO user) {

        return ResponseEntity.status(201).body(service.criarUsuario(user));
    }

}