package server.desdent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.desdent.exception.AuthenticationException;
import server.desdent.exception.BadRequestException;
import server.desdent.model.pojo.Dentists;
import server.desdent.model.repository.DentistsRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
public class SessionManager {

    private static final String LOGGED_USER_ID = "logged_user_id";
    private static final String LOGGED_USER_REMOTE_ADDRESS = "logged_user_remote_address";

    @Autowired
    private DentistsRepository dentistsRepository;

    public void isLoggedVerification(HttpSession session) {
        if (session.getAttribute(LOGGED_USER_ID) != null ){
            throw new AuthenticationException("You are already logged in!");
        }
    }

    public void loginUser(HttpServletRequest request, long id) {
        HttpSession session = request.getSession();
        session.setAttribute(LOGGED_USER_REMOTE_ADDRESS, request.getRemoteAddr());
        session.setAttribute(LOGGED_USER_ID , id);
    }

    public void logoutUser(HttpSession session) {
        if (session.getAttribute(LOGGED_USER_ID) == null){
            throw new BadRequestException("You have to be logged in to logout!");
        }
        session.invalidate();
    }

    public Dentists getLoggedUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        validateSession(request);
        long userId = (long) session.getAttribute(LOGGED_USER_ID);
        return dentistsRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("The user does not exist!"));
    }

    public void validateSession (HttpServletRequest request){
        String remoteAddress = request.getRemoteAddr();
        HttpSession session = request.getSession();
        if (session.getAttribute(LOGGED_USER_ID) == null) {
            throw new AuthenticationException("You have to be logged in!");
        }
        if (!remoteAddress.equals(session.getAttribute(LOGGED_USER_REMOTE_ADDRESS))) {
            session.invalidate();
            throw new AuthenticationException("IP mismatch!");
        }
    }

}
