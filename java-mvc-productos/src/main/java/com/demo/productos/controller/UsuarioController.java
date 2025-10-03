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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.productos.model.Usuario;
import com.demo.productos.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // --- Rutas para el Login ---

    @GetMapping({"/", "/login"})
    public String mostrarFormularioLogin() {
        return "laboTres/login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        // Llama al método de servicio actualizado
        Usuario usuario = usuarioService.validarLogin(email, password);
        if (usuario != null) {
            return "redirect:/usuarios";
        } else {
            redirectAttributes.addFlashAttribute("error", "Email o contraseña incorrectos");
            return "redirect:/login";
        }
    }

    // --- Rutas para el CRUD de Usuarios ---

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarTodosLosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "laboTres/listar-usuarios";
    }

    @GetMapping("/usuarios/nuevo")
    public String mostrarFormularioNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "laboTres/crear-usuario";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "laboTres/crear-usuario";
        }
        usuarioService.guardarUsuario(usuario);
        redirectAttributes.addFlashAttribute("mensaje", "Usuario guardado con éxito.");
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String mostrarFormularioEditarUsuario(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);

        if (usuario == null) {
            redirectAttributes.addFlashAttribute("error", "Error: El usuario con ID " + id + " no fue encontrado.");
            return "redirect:/usuarios";
        }

        model.addAttribute("usuario", usuario);
        return "laboTres/editar-usuario";
    }

    @PostMapping("/usuarios/actualizar/{id}")
    public String actualizarUsuario(@PathVariable Long id,
                                    @Valid @ModelAttribute("usuario") Usuario usuario,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            // También corregimos aquí para que en caso de error, devuelva la vista correcta
            return "laboTres/editar-usuario";
        }
        usuario.setId(id);
        usuarioService.guardarUsuario(usuario);
        redirectAttributes.addFlashAttribute("mensaje", "Usuario actualizado con éxito.");
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        usuarioService.eliminarUsuario(id);
        redirectAttributes.addFlashAttribute("mensaje", "Usuario eliminado con éxito.");
        return "redirect:/usuarios";
    }
}