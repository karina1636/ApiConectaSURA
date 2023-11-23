package com.example.konectaAPI.controladores;

import com.example.konectaAPI.entidades.SignoVital;
import com.example.konectaAPI.servicios.SignoVitalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
    @RequestMapping("api/sura/signoVital")
    public class SignoVitalControlador {
        @Autowired
        private SignoVitalServicio signoVitalServicio;
        @PostMapping
        public ResponseEntity<?> registrarSignoVital(@RequestBody SignoVital signoVital){
            try{
                SignoVital respuestadoSignoVital=this.signoVitalServicio.registosignovital(signoVital);
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(respuestadoSignoVital);
            }catch (Exception error){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());
            }
        }


        //BUSCAR SIGNO VITAL
        @GetMapping("/{id}")
        public ResponseEntity<?> buscarSignoVital(@PathVariable Integer id){
            try {
                SignoVital respuestaServicio= this.signoVitalServicio.consultarSignoVital(id);
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
    public ResponseEntity<List<SignoVital>> consultarSignosVitales(){
        try {
            List<SignoVital>listaConsultada=this.signoVitalServicio.buscarTodosLosSignosVitales();
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
    public ResponseEntity<?> eliminarSignoVital(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.signoVitalServicio.retirarSignoVital(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }





    }

