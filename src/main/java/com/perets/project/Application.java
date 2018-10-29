package com.perets.project;

import com.perets.project.domain.User;
import com.perets.project.persistence.UserElasticRepository;
import com.perets.project.persistence.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private UserMongoRepository userMongoRepository;
    private UserElasticRepository userElasticRepository;

    @Autowired
    public Application(UserMongoRepository userMongoRepository, UserElasticRepository userElasticRepository) {
        this.userMongoRepository = userMongoRepository;
        this.userElasticRepository = userElasticRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // fetch all articles from Mongo

        System.out.println("Articles found in MongoDB with findAll():");
        System.out.println("-----------------------------------------");
        Iterable<User> articles = userMongoRepository.findAll();
        articles.forEach(System.out::println);
        System.out.println();

        TimeUnit.SECONDS.sleep(5);

        // fetch all articles from Elastisearch
        System.out.println("Articles found in Elasticsearch with findAll():");
        System.out.println("-----------------------------------------------");
        articles = userElasticRepository.findAll();
        articles.forEach(System.out::println);
        System.out.println();
    }
}
