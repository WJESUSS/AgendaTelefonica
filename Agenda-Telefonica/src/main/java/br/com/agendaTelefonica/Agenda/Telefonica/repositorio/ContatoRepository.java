package br.com.agendaTelefonica.Agenda.Telefonica.repositorio;



import br.com.agendaTelefonica.Agenda.Telefonica.modelo.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    // Busca por nome (ignorando maiúsculas/minúsculas)
    List<Contato> findByNomeContainingIgnoreCase(String nome);

    // Busca por telefone
    List<Contato> findByTelefoneContaining(String telefone);

    // Busca combinada (nome OU telefone)
    @Query("SELECT c FROM Contato c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR c.telefone LIKE %:termo%")
    List<Contato> buscarPorNomeOuTelefone(@Param("termo") String termo);
}