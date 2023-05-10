package itgate.formation.recrutement.web;

import itgate.formation.recrutement.mailService.EmailService;
import itgate.formation.recrutement.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/send")
    public void  sendEmail(@RequestBody Mail mail) {


        emailService.sendSimpleMessage(mail);
    }
}
