package br.com.agendaTelefonica.Agenda.Telefonica.dtos;


import br.com.agendaTelefonica.Agenda.Telefonica.modelo.Contato;

public record ContatoResponseDTO(
        Long id,
        String nome,
        String telefone,
        String email
) {
    public ContatoResponseDTO(Contato contato) {
        this(contato.getId(), contato.getNome(), contato.getTelefone(), contato.getEmail());
    }
}