package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Examen;
import com.example.konectaAPI.repositorios.ExamenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenGeneralServicio {

    @Autowired
    private ExamenRepositorio examenRepositorio;
    public Examen examenRegistro(Examen examen)throws Exception{
        try{
            return this.examenRepositorio.save(examen);
        }catch (Exception error){
            throw new Exception("Error al registrar");
        }
    }

    //CONSULTAR
    public Examen consultarExamen(Integer idExamen)throws Exception{
        try {
            Optional<Examen>examenBuscado=this.examenRepositorio.findById(idExamen);
            if (examenBuscado.isPresent()){
                return examenBuscado.get();
            }else {
                throw new Exception("");
            }
        }catch (Exception error){
            throw new Exception("");
        }
    }

    //CONSULTAR EXAMENES
    public List<Examen> buscarTodosLosExamenes()throws Exception{
        try {
            List<Examen> listaConsultada= this.examenRepositorio.findAll();
            return listaConsultada;
        }catch (Exception error){
            throw new Exception("");
        }
    }

    //MODIFICAR
    public Examen editarExamen(Integer id, Examen examen)throws Exception{
        try {
            Optional<Examen> examenBuscado=this.examenRepositorio.findById(id);
            if (examenBuscado.isPresent()){
                Examen examenExistente=examenBuscado.get();
                examenExistente.setNombreExamen(examen.getNombreExamen());
                examenExistente.setImagenExamen(examen.getImagenExamen());
                Examen examenModificado= this.examenRepositorio.save(examenExistente);
                return examenModificado;
            }else {
                throw new Exception("id inexistente");
            }
        }catch (Exception error){
            throw new Exception("no pudimos editar el examen");
        }
    }

    //BORRAR
    public Boolean retirarExamen(Integer id)throws Exception{
        try {
            Boolean examenEncontrado=this.examenRepositorio.existsById(id);
            if (examenEncontrado){
                this.examenRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("examen no encontrado");
            }
        }catch (Exception error){
            throw new Exception("error al eliminar el examen");
        }
    }





}