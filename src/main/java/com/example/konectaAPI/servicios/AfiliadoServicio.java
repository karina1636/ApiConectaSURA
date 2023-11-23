package com.example.konectaAPI.servicios;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.repositorios.AfiliadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliadoServicio {

    @Autowired
    private AfiliadoRepositorio afiliadoRepositorio;

    //RegistrarAfiliado
    public Afiliado registrarAfiliado(Afiliado afiliado) throws Exception{
        try{

           return this.afiliadoRepositorio.save(afiliado);

        }catch(Exception error){
            throw new Exception("error al registrarse");
        }
    }

    //ConsultarAfiliado
    public Afiliado consultarAfiliado(Integer idAfiliado) throws Exception {
        try{
            Optional<Afiliado>afiliadoBuscado=this.afiliadoRepositorio.findById(idAfiliado);
            if(afiliadoBuscado.isPresent()){ //Lo encontre en BD
                return afiliadoBuscado.get();
            }else{ //No lo encontra
                throw new Exception("Afiliado no encontrado");
            }
        }catch(Exception error){
            throw new Exception("error en la consulta del afiliado");
        }
    }

    //ConsultarAfiliados


    public List<Afiliado> buscarTodosAfiliado() throws Exception{

        try{
          List<Afiliado>listaConsultada=this.afiliadoRepositorio.findAll();

          return listaConsultada;

        }catch (Exception error){
            throw new Exception("error consultando afiliado");

        }

    }



    //ModificarDatosAfiliado

    public Afiliado editarAfiliado(Integer id,Afiliado afiliado) throws Exception{

        try {
            Optional<Afiliado>afiliadoBuscado=this.afiliadoRepositorio.findById(id);

            if (afiliadoBuscado.isPresent()){
            //  Afiliado afiliadoEditado =this.afiliadoRepositorio.save(afiliado);
            //  return afiliadoEditado;

             Afiliado afiliadoExistente = afiliadoBuscado.get();
             afiliadoExistente.setCorreo(afiliado.getCorreo());
             afiliadoExistente.setTelefono(afiliado.getTelefono());
            Afiliado afiliadoModificado = this.afiliadoRepositorio.save(afiliadoExistente);
            return afiliadoModificado;

            }else {

                throw  new Exception("no encontramos este afiliado");
            }


        }catch (Exception error){
            throw new Exception("fallaste editando");

        }


    }

    //BorrarAfiliado

    public Boolean retirarAfiliado(Integer id) throws Exception {
        try{
         Boolean afiliadoEncontrado = this.afiliadoRepositorio.existsById(id);
         if (afiliadoEncontrado){
             this.afiliadoRepositorio.deleteById(id);
             return true;
         }else {
             throw new Exception("Usuario no Encontrado");
         }

        }catch (Exception error){
            throw new Exception("Error borrando al Usuario");

        }
    }



}
