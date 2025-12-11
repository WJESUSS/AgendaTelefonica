package br.com.agendaTelefonica.Agenda.Telefonica.dtos;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContatoRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 100)
        String nome,

        @NotBlank(message = "Telefone é obrigatório")
        @Size(min = 8, max = 20)
        String telefone,

        String email
) {}
