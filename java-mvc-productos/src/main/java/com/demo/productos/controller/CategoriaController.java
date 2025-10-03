package com.demo.productos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.productos.model.Categoria;
import com.demo.productos.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Mostrar todos los productos
    @GetMapping({"", "/"})
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaService.listarTodasLasCategorias();
        model.addAttribute("categorias", categorias);
        return "listar-categorias";
    }

    // Formulario para crear una nueva categoria
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "crear-categoria";
    }

    // Guardar un nueva categoria
    @PostMapping("/guardar")
    public String guardarCategoria(@Valid @ModelAttribute("categoria") Categoria categoria,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "crear-categoria";
        }

        categoriaService.guardarCategoria(categoria);
        redirectAttributes.addFlashAttribute("mensaje", "Categoria guardado con éxito.");
        return "redirect:/categorias";
    }

    // Formulario para editar un producto existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
        model.addAttribute("categoria", categoria);
        return "editar-categoria";
    }

    // Actualizar un producto existente
    @PostMapping("/actualizar/{id}")
    public String actualizarCategoria(@PathVariable Long id,
                                     @Valid @ModelAttribute("categoria") Categoria categoria,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "editar-categoria";
        }

        categoria.setId(id);
        categoriaService.guardarCategoria(categoria);
        redirectAttributes.addFlashAttribute("mensaje", "Categoria actualizada con éxito.");
        return "redirect:/categorias";
    }

    // Eliminar una categoria
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        categoriaService.eliminarCategoria(id);
        redirectAttributes.addFlashAttribute("mensaje", "Categoria eliminada con éxito.");
        return "redirect:/categorias";
    }

    // Buscar productos por nombre
    @GetMapping("/buscar")
    public String buscarCategorias(@RequestParam(required = false) String nombre, Model model) {
        List<Categoria> categorias;

        if (nombre != null && !nombre.isEmpty()) {
            categorias = categoriaService.buscarCategoriaPorNombre(nombre);
            model.addAttribute("nombreBusqueda", nombre);
        } else {
            categorias = categoriaService.listarTodasLasCategorias();
        }

        model.addAttribute("categorias", categorias);
        return "listar-categorias";
    }
}
