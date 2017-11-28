package br.com.venus.notepad.controller;

import br.com.venus.notepad.model.Nota;
import br.com.venus.notepad.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin // para quando a requisição vier via web e não via mobile
@RequestMapping(value = "/nota")
public class NotaController {

    @Autowired
    NotaService notaService;

    @GetMapping
    List<Nota> buscarTodos() {
        return notaService.buscarTodas();
    }

    @GetMapping(value = "/titulo/{titulo}")
    Nota buscar(@PathVariable(value = "titulo") String titulo) {
        return notaService.buscar(titulo);
    }

    @PostMapping
    public void salvar(@RequestBody Nota nota) {
        notaService.salvar(nota);
    }

}
