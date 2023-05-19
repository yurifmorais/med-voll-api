package med.voll.api.medico;

//como eu nao preciso listar todos os dados de medico, vou criar um DTO com os dados de interesse
public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public DadosListagemMedico (Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
