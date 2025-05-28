package services;

import data.models.Security;
import dtos.responses.SecurityRegisterResponses;

public interface SecurityServices {
    SecurityRegisterResponses registerSecurity(SecurityRegisterResponses security);
    Security loginSecurity(String username, String password);
}
