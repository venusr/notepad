package br.com.venus.notepad.service;

import br.com.venus.notepad.model.Nota;
import br.com.venus.notepad.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    NotaRepository notaRepository;

    public void salvar(Nota nota) {
       List<Nota> auxs = notaRepository.findByTitulo(nota.getTitulo());
       if(auxs != null && !auxs.isEmpty()) {
           nota.setId(auxs.get(0).getId());
       }
       notaRepository.save(nota);
    }

    public List<Nota> buscarTodas() {
        List<Nota> notas = notaRepository.findAll();
        return notaRepository.findAll();
    }

    public Nota buscar(String titulo) {
        List<Nota> auxs = notaRepository.findByTitulo(titulo);
        if(auxs != null && !auxs.isEmpty()) {
            return auxs.get(0);
        }
        return new Nota();
    }
}
