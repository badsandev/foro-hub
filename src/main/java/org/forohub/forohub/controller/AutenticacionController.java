package org.forohub.forohub.controller;


import jakarta.validation.Valid;
import org.forohub.forohub.domain.usuario.AutenticacionService;
import org.forohub.forohub.domain.usuario.DatosAutenticacion;
import org.forohub.forohub.domain.usuario.Usuario;
import org.forohub.forohub.infra.security.DatosTokenJWT;
import org.forohub.forohub.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {


    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos) {

        var AutenticationToken = new UsernamePasswordAuthenticationToken(datos.email(),datos.contrasenia());
        var autenticacion = manager.authenticate(AutenticationToken);
        var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));

    }

}
