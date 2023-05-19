package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

// um record 'e como uma classe normal, mas sem getter e setter. pois assim fica menos verboso. 'e imutavel;
//estou usando o bean validation nos @. o bean validation serve para validar os dados que vai ser inseridos no bd;
public record DadosCadastroMedico(
        @NotBlank //NotBlank eu so uso para campos String
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //aqui to dizendo que tem que ser um numero de 4 a 6 digitos
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid //vai validar tbm um dos objetos q esta como atributo
        DadosEndereco endereco
    ) {
}
