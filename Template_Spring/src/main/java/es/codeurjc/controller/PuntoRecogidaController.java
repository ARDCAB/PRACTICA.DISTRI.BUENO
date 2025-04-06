package es.codeurjc.controller;

import es.codeurjc.exception.PuntoRecogidaNotFoundException;
import es.codeurjc.model.PuntoRecogida;
import es.codeurjc.service.PuntoRecogidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/puntos")
public class PuntoRecogidaController {

    @Autowired
    private PuntoRecogidaService puntoService;

    // Get all pickup points
    @GetMapping
    @ResponseBody
    public List<PuntoRecogida> getAll() {
        return puntoService.getAll();
    }

    // Get a pickup point by ID
    @GetMapping("/{id}")
    @ResponseBody
    public PuntoRecogida getById(@PathVariable int id) {
        PuntoRecogida punto = puntoService.getById(id);
        if (punto == null) {
            throw new PuntoRecogidaNotFoundException(id);  // Handle not found error (you can customize the exception)
        }
        return punto;
    }

    // Create a new pickup point
    @PostMapping
    @ResponseBody
    public PuntoRecogida create(@RequestBody PuntoRecogida punto) {
        return puntoService.create(punto);
    }

    // Update a pickup point by ID
    @PutMapping("/{id}")
    @ResponseBody
    public PuntoRecogida update(@PathVariable int id, @RequestBody PuntoRecogida punto) {
        return puntoService.update(id, punto);
    }

    // Partially update a pickup point by ID
    @PatchMapping("/{id}")
    @ResponseBody
    public PuntoRecogida patch(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return puntoService.patch(id, updates);
    }

    // Delete a pickup point by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        puntoService.delete(id);
    }
}
