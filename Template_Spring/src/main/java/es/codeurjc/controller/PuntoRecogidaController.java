package es.codeurjc.controller;

import es.codeurjc.exception.PuntoRecogidaNotFoundException;
import es.codeurjc.model.CodigoPostalMadrid;
import es.codeurjc.model.PuntoRecogida;
import es.codeurjc.repository.CodigoPostalMadridRepository;
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

    @Autowired
    private CodigoPostalMadridRepository codigoPostalRepo;

    // Mostrar todos los puntos de recogida
    @GetMapping("/api")
    public String getAll(Model model) {
        List<PuntoRecogida> puntos = puntoService.getAll();
        model.addAttribute("puntoRecogidas", puntos);
        return "puntoRecogidaList";
    }

    // Crear un punto de recogida vía API (JSON)
    @PostMapping("/api")
    @ResponseBody
    public PuntoRecogida createApi(@RequestBody PuntoRecogida punto) {
        return puntoService.create(punto);
    }

    // Crear punto de recogida desde formulario
    @PostMapping("/add")
    public String addPunto(@RequestParam String codigoPostal, @RequestParam int userId) {
        PuntoRecogida punto = new PuntoRecogida(codigoPostal, userId);
        puntoService.addPunto(punto);
        return "redirect:/puntos/api";
    }

    // Mostrar formulario para buscar por código postal
    @GetMapping("/form")
    public String mostrarFormularioBusqueda() {
        return "pickup";  // HTML del formulario
    }

    // Buscar puntos de recogida por código postal
    @GetMapping("/buscar")
    public String buscarPorCodigoPostal(@RequestParam String codigoPostal, Model model) {
        List<PuntoRecogida> puntos = puntoService.getByPostalCode(codigoPostal);
        CodigoPostalMadrid infoPostal = codigoPostalRepo.findById(codigoPostal).orElse(null);

        model.addAttribute("puntos", puntos);
        model.addAttribute("direccionPostal", infoPostal != null ? infoPostal.getDireccion() : "No disponible");
        model.addAttribute("codigoPostal", codigoPostal);

        return "mostrarPuntosPorCP"; // HTML con resultados
    }

    // Mostrar formulario de edición
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        PuntoRecogida punto = puntoService.getById(id);
        if (punto == null) {
            throw new PuntoRecogidaNotFoundException(id);
        }
        model.addAttribute("puntoRecogida", punto);
        return "editPuntoRecogidaForm";
    }

    // Obtener punto de recogida por ID (API)
    @GetMapping("/{id}")
    @ResponseBody
    public PuntoRecogida getPuntoById(@PathVariable int id) {
        PuntoRecogida punto = puntoService.getById(id);
        if (punto == null) {
            throw new PuntoRecogidaNotFoundException(id);
        }
        return punto;
    }

    // Actualizar un punto
    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @ModelAttribute PuntoRecogida punto) {
        punto.setId(id);
        puntoService.update(id, punto);
        return "redirect:/puntos/api";
    }

    // Actualizar parcialmente (API)
    @PatchMapping("/{id}")
    @ResponseBody
    public PuntoRecogida patch(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return puntoService.patch(id, updates);
    }

    // Eliminar punto
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        puntoService.delete(id);
        return "redirect:/puntos/api";
    }
}


