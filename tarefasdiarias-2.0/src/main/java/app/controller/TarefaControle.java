package app.controller;

import app.model.Tarefa;
import app.service.TarefaServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que este Controller retorna dados (JSON)
@RequestMapping("/api/tarefas") // Prefixo para todos os endpoints
public class TarefaControle {

    @Autowired
    private TarefaServico tarefaServico;

    // GET /api/tarefas
    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaServico.listarTodas();
    }

    // GET /api/tarefas/1
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Integer id) {
        // O serviço lança uma RecursoNaoEncontradoExcecao se não encontrar
        Tarefa tarefa = tarefaServico.buscarPorId(id);
        return ResponseEntity.ok(tarefa);
    }

    // POST /api/tarefas
    // @RequestBody mapeia o JSON de entrada para o objeto Tarefa
    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaServico.salvar(tarefa);
        // Retorna 201 Created
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
    }

    // PUT /api/tarefas/1
    //Atualiza a tarefa existente, usando o ID do Path
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Integer id, @RequestBody Tarefa detalhesTarefa) {
        //Garante que o ID da URL seja usado para a busca
        Tarefa tarefaExistente = tarefaServico.buscarPorId(id); 

        //Atualiza os campos 
        tarefaExistente.setTitulo(detalhesTarefa.getTitulo());
        tarefaExistente.setDescricao(detalhesTarefa.getDescricao());
        tarefaExistente.setDataLimite(detalhesTarefa.getDataLimite());
        tarefaExistente.setCategoria(detalhesTarefa.getCategoria());
        tarefaExistente.setStatus(detalhesTarefa.getStatus());
        
        Tarefa tarefaAtualizada = tarefaServico.salvar(tarefaExistente);
        return ResponseEntity.ok(tarefaAtualizada);
    }

    //DELETE /api/tarefas/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable Integer id) {
        tarefaServico.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
