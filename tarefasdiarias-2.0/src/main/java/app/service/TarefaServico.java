package app.service;

import app.model.Tarefa;
import app.repository.TarefaRepositorio;
import app.exception.RecursoNaoEncontradoExcecao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 É a classe que atua como intermediário entre o controlador (que é a API) e o Repositório. Ela 
 funciona como se fosse o cérebro da aplicação, e o @service serve para informar ao Spring para criar uma única
 instância dessa classe e gerenciá-la.
 */
@Service
public class TarefaServico {

    @Autowired
    private TarefaRepositorio repositorio;

    public List<Tarefa> listarTodas() {
        return repositorio.findAll();
    }

    public Tarefa buscarPorId(Integer id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoExcecao("Tarefa não encontrada com ID: " + id));
    }

    public Tarefa salvar(Tarefa tarefa) {
        return repositorio.save(tarefa);
    }

    public void excluir(Integer id) {
        if (!repositorio.existsById(id)) {
            throw new RecursoNaoEncontradoExcecao("Tarefa não encontrada para exclusão com ID: " + id);
        }
        repositorio.deleteById(id);
    }
}