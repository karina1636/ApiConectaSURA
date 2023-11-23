package com.example.konectaAPI.controladores;

import com.example.konectaAPI.entidades.Examen;
import com.example.konectaAPI.servicios.ExamenGeneralServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
    @RequestMapping("api/sura/examen")
    public class ExamenControlador {
        @Autowired
        private ExamenGeneralServicio examenGeneralServicio;
        @PostMapping
        public ResponseEntity<?> registrarExamen(@RequestBody Examen examen){
            try{
                Examen respuestaExamen=this.examenGeneralServicio.examenRegistro(examen);
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(respuestaExamen);
            }catch (Exception error){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());
            }
        }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarExamen(@PathVariable Integer id){
        try {
            Examen respuestaServicio= this.examenGeneralServicio.consultarExamen(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
        public ResponseEntity<List<Examen>> consultarExamenes(){
            try {
                List<Examen>listaConsultada=this.examenGeneralServicio.buscarTodosLosExamenes();
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(listaConsultada);
            }catch (Exception error){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null);
            }
        }

    //BORRAR
    @DeleteMapping ("/{id}")
    public ResponseEntity<?> eliminarExamen(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.examenGeneralServicio.retirarExamen(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }




    }

