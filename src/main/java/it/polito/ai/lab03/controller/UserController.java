package it.polito.ai.lab03.controller;

import it.polito.ai.lab03.repository.Position;
import it.polito.ai.lab03.repository.User;
import it.polito.ai.lab03.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PositionService positionService;

    // Restituisce una collezione di positions
    @RequestMapping(
            path = "/positions",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    List<Position> getAll() { // Bisognerebbe creare la classe Position che risiede nel data layer.
        return positionService.getAll();
    }

    // Aggiungiamo una posizione a quelle che già abbiamo
    @RequestMapping(
            path = "/positions",
            method = RequestMethod.POST
    )
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addPosition(@RequestParam(value = "position") Position position, @AuthenticationPrincipal User principal) {
    }

    // Credo sia così che funzioni la questione dei path. Questo si aggiunge a quello della classe
    @RequestMapping(
            path = "/positions/{id}",
            method = RequestMethod.GET
    )
    @ResponseStatus(value = HttpStatus.CREATED)
    public void getPosition(@PathVariable(value = "id") long positionId) {
    }

    @RequestMapping(
            path = "/positions/{id}",
            method = RequestMethod.PUT
    )
    @ResponseStatus(value = HttpStatus.CREATED)
    public void updatePosition(@PathVariable(value = "id") long positionId) {
    }
}
