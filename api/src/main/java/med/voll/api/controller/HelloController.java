package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//ver o que 'e uma aplicacao REST
// estudar dto. dao e jpa
// o spring nao precisa de DAO, pois ele simplifica usando interfaces

//SOBRE O BD:
//as migrations fazem o controle de versao do BD. No springboot a biblioteca que faz isso 'e o FLYWAY;
//Sempre que eu for mexer com migrations, devo parar a execucao o projeto;
//os arquivos de migrations seguem um padrao de nome, tem que cuidar isso;
//migrations executadas nao podem ser modificadas. devo criar uma nova migration

//validadoes no bd:
//o modulo validation serve para isso,
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String olaMundo(){
        return "Ola mundo spring 2023!";
    }
}
