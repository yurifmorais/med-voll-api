package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")//essa e a url inicial
public class MedicoController {
    @Autowired //o @ indica que o proprio spring que vai instanciar. injecao de dependencias
    private MedicoRepository repository;
    @PostMapping
    @Transactional //quando tem INSERT, tem que ter o Transactional
    //o @Valid abaixo serve para ele aplicar as validacoes do bean validation
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){ //nao posso esquecer do @RequestBody, pois o metodo tem que puxar do corpo da requisicao;
        //eu passo os parametros que vem pelo json na requisicao e ai salva no BD;
        repository.save(new Medico(dados)); //o id 'e null pq o banco gera automaticamente. a classe q esta sendo chamada e a MedicoRepository;
        //o save 'e como se fosse um INSERT no bd.
    }

    @GetMapping
    //o READ do crud
    //cuidar o retorno do metodo, pois retorna Page
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){//Pageable serve para fazer a paginacao. ex: mostrar somente 10 por pagina
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new); //vai pegar so os que tem ativo = true
    }

    @PutMapping //update
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    //vou receber o ID do medico a ser excluido na URL
    @DeleteMapping("/{id}")//parametro dinamico
    @Transactional
    public void excluir(@PathVariable Long id){//para dizer que 'e o parametro que vem da URL (caminho/path)
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}








