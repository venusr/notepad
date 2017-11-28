package br.com.venus.notepad.repository;

import br.com.venus.notepad.model.Nota;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends MongoRepository<Nota, String> {

    //@Query - se precisar fazer query

    List<Nota> findByTitulo(String Titulo);


}
