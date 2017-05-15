package de.mo.lunch.controller;


import de.mo.lunch.model.Message;
import de.mo.lunch.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class WelcomeController {

    private final MessageService messageService;

    @Autowired
    public WelcomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("messages", messageService.findAll());
        return "welcome";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addMessage(Model model, @RequestParam("message") String message) {
        messageService.save(message);
        return welcome(model);
    }
}
