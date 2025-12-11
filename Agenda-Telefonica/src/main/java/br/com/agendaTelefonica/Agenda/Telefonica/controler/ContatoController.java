package br.com.agendaTelefonica.Agenda.Telefonica.controler;



import br.com.agendaTelefonica.Agenda.Telefonica.dtos.ContatoRequestDTO;
import br.com.agendaTelefonica.Agenda.Telefonica.dtos.ContatoResponseDTO;
import br.com.agendaTelefonica.Agenda.Telefonica.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @GetMapping
    public ResponseEntity<List<ContatoResponseDTO>> listar(
            @RequestParam(required = false) String buscar) {
        List<ContatoResponseDTO> lista = service.buscar(buscar);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> criar(
            @Valid @RequestBody ContatoRequestDTO dto) {
        ContatoResponseDTO criado = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> buscarPorId(@PathVariable Long id) {
        ContatoResponseDTO contato = service.buscarPorId(id);
        return ResponseEntity.ok(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ContatoRequestDTO dto) {
        ContatoResponseDTO atualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
