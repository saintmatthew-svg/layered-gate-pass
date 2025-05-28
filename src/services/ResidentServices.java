package services;

import data.models.Resident;
import dtos.requests.ResidentRegisterRequests;
import dtos.responses.ResidentRegisterResponses;

public interface ResidentServices {
    ResidentRegisterResponses registerResident(ResidentRegisterRequests resident);
    Resident Login(String username, String password);
}
