package es.codeurjc.controller;

import es.codeurjc.exception.PuntoRecogidaNotFoundException;
import es.codeurjc.model.Book;
import es.codeurjc.model.PuntoRecogida;
import es.codeurjc.service.PuntoRecogidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/puntos")
public class PuntoRecogidaController {

    @Autowired
    private PuntoRecogidaService puntoService;

    // Get all pickup points (to display on the page)
    @GetMapping("/api")
    public String getAll(Model model) {
        List<PuntoRecogida> puntos = puntoService.getAll();
        model.addAttribute("puntoRecogidas", puntos);
        return "puntoRecogidaList"; // Thymeleaf template
    }

    @PostMapping("/api")
    @ResponseBody
    public PuntoRecogida createApi(@RequestBody PuntoRecogida punto) {
        return puntoService.create(punto);
    }

    // Create a new pickup point (via form)
    @PostMapping("/add")
    public String addPunto(@RequestParam String direccion, @RequestParam String ciudad, @RequestParam int userId){
        PuntoRecogida punto = new PuntoRecogida(direccion, ciudad, userId);
        puntoService.addPunto(punto);  // Add the book to the service
        return "redirect:/"; // Redirect back to the list
    }


    // Show form for editing an existing pickup point
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        PuntoRecogida punto = puntoService.getById(id);
        if (punto == null) {
            throw new PuntoRecogidaNotFoundException(id); // Custom exception if not found
        }
        model.addAttribute("puntoRecogida", punto);
        return "editPuntoRecogidaForm"; // Thymeleaf template for editing
    }

    // Update an existing pickup point
    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @ModelAttribute PuntoRecogida punto) {
        punto.setId(id); // Ensure the ID is retained during update
        puntoService.update(id, punto);
        return "puntos"; // Redirect back to the list
    }

    // Partially update a pickup point (handled by PATCH)
    @PatchMapping("/{id}")
    @ResponseBody
    public PuntoRecogida patch(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return puntoService.patch(id, updates);
    }

    // Delete a pickup point by ID
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        puntoService.delete(id);
        return "redirect:/puntos"; // Redirect back to the list
    }
}
