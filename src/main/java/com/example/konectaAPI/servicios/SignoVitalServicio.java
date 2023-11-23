package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.SignoVital;
import com.example.konectaAPI.repositorios.SignoVitalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
    public class SignoVitalServicio {
        @Autowired
        private SignoVitalRepositorio signoVitalRepositorio;
        public SignoVital registosignovital (SignoVital signoVital)throws Exception{
            try{
                return this.signoVitalRepositorio.save(signoVital);
            }catch (Exception error){
                throw new Exception("Error al registrar");
            }

        }

        //CONSULTAR
        public SignoVital consultarSignoVital(Integer idSignoVital)throws Exception{
            try {
                Optional<SignoVital> signoBuscado=this.signoVitalRepositorio.findById(idSignoVital);
                if (signoBuscado.isPresent()){
                    return signoBuscado.get();
                }else {
                    throw new Exception("");
                }
            }catch (Exception error){
                throw new Exception("");
            }
        }

    //CONSULTAR SIGNOS VITALES
    public List<SignoVital> buscarTodosLosSignosVitales()throws Exception{
        try {
            List<SignoVital>listaConsultada= this.signoVitalRepositorio.findAll();
            return listaConsultada;
        }catch (Exception error){
            throw new Exception("");
        }
    }
    //MODIFICAR
    public SignoVital editarSignoVital(Integer id, SignoVital signoVital)throws Exception{
        try {
            Optional<SignoVital>signoVitalBuscado=this.signoVitalRepositorio.findById(id);
            if (signoVitalBuscado.isPresent()){
                SignoVital signoVitalExistente=signoVitalBuscado.get();
                signoVitalExistente.setUnidadMedida(signoVital.getUnidadMedida());
                SignoVital signoVitalModificado= this.signoVitalRepositorio.save(signoVitalExistente);
                return signoVitalModificado;
            }else {
                throw new Exception("id inexistente");
            }
        }catch (Exception error){
            throw new Exception("no pudimos editar el signo vital");
        }

    }
    //BORRAR
    public Boolean retirarSignoVital(Integer id)throws Exception{
        try {
            Boolean signoVitalEncontrado=this.signoVitalRepositorio.existsById(id);
            if (signoVitalEncontrado){
                this.signoVitalRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("signo vital no encontrado");
            }
        }catch (Exception error){
            throw new Exception("error al eliminar el signo vital");
        }
    }

    }


