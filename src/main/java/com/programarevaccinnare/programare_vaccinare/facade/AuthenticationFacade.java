package com.programarevaccinnare.programare_vaccinare.facade;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
    Authentication getAuthentication();
}
