package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
//ENTIDADE JPA
//Essa classe 'e um entidade JPA para representar uma tabela do BD. que vai ser a classe de dominio para a persistencia do BD
//tem os mesmos atributos que declarei no record DadosCadastroMedico

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter //LOMBOK VAI GERAR AUTOMATICO
@NoArgsConstructor //JPA EXIGE, vai gerar o construtor sem argumentos
@AllArgsConstructor
@EqualsAndHashCode(of = "id")//pk

public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)//para identificar que e um ENUM
    private Especialidade especialidade;

    @Embedded //para eu criar uma classe separada, mas no BD ele considera da mesma tabela
    private Endereco endereco;
    private boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }
    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.nome = dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    //exclusao em que eu so desativo o usuario
    public void excluir() {
        this.ativo = false;
    }
}







