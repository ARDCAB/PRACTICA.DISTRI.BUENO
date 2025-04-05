package es.codeurjc.controller;

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

    @GetMapping
    public List<PuntoRecogida> getAll() {
        return puntoService.getAll();
    }

    @GetMapping("/{id}")
    public PuntoRecogida getById(@PathVariable int id) {
        return puntoService.getById(id);
    }

    @PostMapping
    public PuntoRecogida create(@RequestBody PuntoRecogida punto) {
        return puntoService.create(punto);
    }

    @PutMapping("/{id}")
    public PuntoRecogida update(@PathVariable int id, @RequestBody PuntoRecogida punto) {
        return puntoService.update(id, punto);
    }

    @PatchMapping("/{id}")
    public PuntoRecogida patch(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return puntoService.patch(id, updates);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        puntoService.delete(id);
    }
}
