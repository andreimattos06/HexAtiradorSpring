package com.andreimattos06.hexatirador.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andreimattos06.hexatirador.dto.LoginDTO;
import com.andreimattos06.hexatirador.dto.ProfileDTO;
import com.andreimattos06.hexatirador.dto.RegisterDTO;
import com.andreimattos06.hexatirador.entity.HabitualityEntity;
import com.andreimattos06.hexatirador.entity.ProfileEntity;
import com.andreimattos06.hexatirador.service.JwtService;
import com.andreimattos06.hexatirador.service.ProfileService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/all") // Later this will be a ADMIN only route, for now its avaiable for all users for ease.
    public ResponseEntity<List<ProfileDTO>> findAllProfiles() {
        List<ProfileEntity> profiles = profileService.findAllProfiles();
        List<ProfileDTO> list_dto = profiles.stream().map(e -> new ProfileDTO(e)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list_dto);

    }

    @GetMapping
    public ResponseEntity<ProfileDTO> findByEmail(HttpServletRequest request) {
        String user_email = request.getAttribute("user_email").toString();
        ProfileDTO profile = new ProfileDTO(profileService.findByEmail(user_email));
        return ResponseEntity.ok().body(profile);
    }

    @DeleteMapping
    public void deleteByEmail(HttpServletRequest request) {
        String user_email = request.getAttribute("user_email").toString();
        profileService.deleteProfileByEmail(user_email);
    }

    @PutMapping
    public ResponseEntity<Object> updateProfile(HttpServletRequest request,
            @RequestBody ProfileDTO profileDTO) {

        String user_email = request.getAttribute("user_email").toString();
        if (profileDTO.getEmail().equals(user_email)) {
            ProfileEntity profile = profileService.findByEmail(user_email);
            profile.setFirst_name(profileDTO.getFirst_name());
            profile.setLast_name(profileDTO.getLast_name());
            profile.setGender(profileDTO.getGender());
            profile = profileService.updateProfile(profile);
            return ResponseEntity.ok().body(profile);
        }
        return ResponseEntity.badRequest().body("Provided user doesn't match token information.");
    }

    // -------Start of authentication and register functions, this two routes are not token protected ---------//

    @PostMapping("/auth/register")
    public ResponseEntity<Object> saveProfile(@RequestBody RegisterDTO profile) {
        if (!profileService.emailAlreadyRegistered(profile.getEmail())) {

            if (validateNewRegister(profile)) {
                profile.setPassword(BCrypt.hashpw(profile.getPassword(), BCrypt.gensalt()));
                ProfileEntity profileEntity = profileService.saveProfile(profile.fromDTO(profile));
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(profileEntity.getId())
                        .toUri();
                return ResponseEntity.created(uri).build();
            } else {
                return ResponseEntity.badRequest().body("Missing or inconsistente information.");
            }

        } else {
            return ResponseEntity.badRequest().body("Email already registed.");
        }

    }

    @PostMapping("/auth/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        ProfileEntity profile = profileService.findByEmail(loginDTO.getEmail());

        String jwt = jwtService.generateToken(profile);
        return jwt;

    }

    // -----------Start of Functions---------------- //

    private boolean validateNewRegister(RegisterDTO profile) {
        if (!profile.getEmail().contains("@")) {
            return false;

        }
        if (profile.getPassword().length() < 3) {
            return false;
        }
        if (!profile.getGender().equalsIgnoreCase("Masculino") && !profile.getGender().equalsIgnoreCase("Feminino")) {
            return false;
        }
        if (profile.getFirst_name().length() < 3 || profile.getLast_name().length() < 3) {
            return false;
        }

        return true;
    }

}
