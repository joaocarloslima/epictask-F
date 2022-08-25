package br.com.fiap.epictaskapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.repository.TaskRepository;

@Configuration
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    TaskRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.saveAll(List.of(
            new Task("Modelar BD", "modelar tabelas do banco", 150),
            new Task("Prototipo", "prototipar as telas", 20),
            new Task("Login", "prototipar as telas", 10),
            new Task("Deploy", "prototipar as telas", 50),
            new Task("Cadastro de usuário", "prototipar as telas", 30),
            new Task("Testes", "prototipar as telas", 25),
            new Task("Logout", "prototipar as telas", 12),
            new Task("Internacionalização", "prototipar as telas", 70),
            new Task("Bug", "corrigir erro da API", 50)
        ));
    }
    
}
