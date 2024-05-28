/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Categoria;
import pe.edu.upeu.syscenterlife.repositorio.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository repository;
    
    //C
    public Categoria guardarEntidad(Categoria categoria){
        return repository.save(categoria);
    }
    
    //R
    public List<Categoria> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public Categoria actualizarEntidad(Categoria categoria){
        return repository.save(categoria);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public Categoria buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
