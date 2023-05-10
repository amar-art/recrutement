package itgate.formation.recrutement;

import itgate.formation.recrutement.file.StorageService;
import itgate.formation.recrutement.model.Role;
import itgate.formation.recrutement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootApplication
public class RecrutementApplication/* implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(RecrutementApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder getBCPE() {

        return new BCryptPasswordEncoder();
    }

    @Autowired
    StorageService storageService;

   /* @Override
    public void run(String... args) throws Exception {
        storageService.deleteAll();
        storageService.init();

    }*/
	/*
//	@Bean
//	CommandLineRunner start(AccountService accountService){
//		return args->{
//
//			accountService.save(new Role("candidat"));
//			accountService.save(new Role("admin"));
//			accountService.save(new Role("responsable"));
//
//
//
//
//		};
//	}
*/

}
