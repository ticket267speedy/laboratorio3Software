package com.demo.productos.service;

import java.util.List;
import com.demo.productos.model.Usuario;

public interface UsuarioService {

    List<Usuario> listarTodosLosUsuarios();

    Usuario obtenerUsuarioPorId(Long id);

    Usuario guardarUsuario(Usuario usuario);

    void eliminarUsuario(Long id);

    // Método para la lógica del login
    Usuario validarLogin(String email, String password);
}