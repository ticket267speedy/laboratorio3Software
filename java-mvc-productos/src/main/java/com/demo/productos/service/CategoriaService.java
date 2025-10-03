package com.demo.productos.service;

import com.demo.productos.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> listarTodasLasCategorias();

    Categoria obtenerCategoriaPorId(Long id);

    Categoria guardarCategoria(Categoria categoria);

    void eliminarCategoria(Long id);

    List<Categoria> buscarCategoriaPorNombre(String nombre);

}
