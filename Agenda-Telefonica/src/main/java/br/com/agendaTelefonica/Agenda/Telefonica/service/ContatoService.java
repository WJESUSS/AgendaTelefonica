package br.com.agendaTelefonica.Agenda.Telefonica.service;



import br.com.agendaTelefonica.Agenda.Telefonica.dtos.ContatoRequestDTO;
import br.com.agendaTelefonica.Agenda.Telefonica.dtos.ContatoResponseDTO;
import br.com.agendaTelefonica.Agenda.Telefonica.modelo.Contato;
import br.com.agendaTelefonica.Agenda.Telefonica.repositorio.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<ContatoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(ContatoResponseDTO::new)
                .toList();
    }

    public ContatoResponseDTO salvar(ContatoRequestDTO dto) {
        Contato contato = new Contato(dto.nome(), dto.telefone(), dto.email());
        Contato salvo = repository.save(contato);
        return new ContatoResponseDTO(salvo);
    }

    public ContatoResponseDTO buscarPorId(Long id) {
        Contato contato = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        return new ContatoResponseDTO(contato);
    }

    public List<ContatoResponseDTO> buscar(String termo) {
        if (termo == null || termo.isBlank()) {
            return listarTodos();
        }
        return repository.buscarPorNomeOuTelefone(termo).stream()
                .map(ContatoResponseDTO::new)
                .toList();
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Contato não encontrado");
        }
        repository.deleteById(id);
    }

    public ContatoResponseDTO atualizar(Long id, ContatoRequestDTO dto) {
        Contato contato = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        contato.setNome(dto.nome());
        contato.setTelefone(dto.telefone());
        contato.setEmail(dto.email());

        Contato atualizado = repository.save(contato);
        return new ContatoResponseDTO(atualizado);
    }
}