package app.repository;

import app.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Essa classe serve para simplificar o acesso e manipulação dos dados no banco de dados, ou seja, 
 * ele é meio que responsável pelo CRUD do projeto, porém feito de maneira automática.
 * 
 */
@Repository
public interface TarefaRepositorio extends JpaRepository<Tarefa, Integer> {
}