package Alura.Challenge.Foro_Hub.controller;

import Alura.Challenge.Foro_Hub.domain.security.DatosDelTokenJWT;
import Alura.Challenge.Foro_Hub.domain.security.TokenService;
import Alura.Challenge.Foro_Hub.domain.usuario.DatosUsuario;
import Alura.Challenge.Foro_Hub.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosUsuario datosUsuario) {

        var authToken = new UsernamePasswordAuthenticationToken(datosUsuario.login(), datosUsuario.contrasenia());
        var auth = manager.authenticate(authToken);

        var tokenJWT = tokenService.generarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new DatosDelTokenJWT(tokenJWT));

    }

}
