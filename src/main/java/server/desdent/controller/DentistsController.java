package server.desdent.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.desdent.model.dto.user.*;
import server.desdent.service.DentistsService;

import javax.validation.Valid;

@RestController
public class DentistsController {
    @Autowired
    private DentistsService dentistsService;

    @Autowired
    private SessionManager sessionManager;

    @PostMapping("/users/login")
    public ResponseEntity<DentistWithoutPasswordDTO> login(@RequestBody @Valid LoginRequestDentistDTO dto, HttpServletRequest request) {
        DentistWithoutPasswordDTO user = dentistsService.login(dto);
        sessionManager.loginUser(request, user.getId());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users/logout")
    public ResponseEntity<LogoutDTO> logout(HttpSession session) {
        sessionManager.logoutUser(session);
        return ResponseEntity.ok(new LogoutDTO("Logout successful!"));
    }

    @Transactional
    @PutMapping("/users/forgotten-pass")
    public ResponseEntity<DentistWithoutPasswordDTO> forgottenPassword(@RequestBody @Valid ForgottenPassDTO dto, HttpServletRequest request) {
        sessionManager.isLoggedVerification(request.getSession());
        return ResponseEntity.ok(dentistsService.forgottenPassword(dto));
    }

    @Transactional
    @PutMapping("/users/{id}")
    public DentistWithoutPasswordDTO editUserData(@PathVariable long id, @RequestBody @Valid EditUserRequestDTO dto) {
        return dentistsService.editUserData(id, dto);
    }

    @Transactional
    @PutMapping("/users/{id}/pass")
    public DentistWithoutPasswordDTO editUserPassword(@PathVariable long id, @RequestBody @Valid EditPasswordRequestDTO dto) {
        return dentistsService.editUserPassword(id, dto);
    }


}
