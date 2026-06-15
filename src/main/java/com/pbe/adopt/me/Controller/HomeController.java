//package com.pbe.adopt.me.Controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class HomeController {
//
//    @GetMapping("/")
//    public String home() {
//
//        // return  "home/teste";
//        return "home/index";
//        //return "fragments/listagem_pet";
//    }
//}

package com.pbe.adopt.me.Controller;

import com.pbe.adopt.me.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping("/")
    public String home(Model model) {
        // Buscamos todos os pets e enviamos para a index.html conseguir alimentar o fragmento
        model.addAttribute("pets", petRepository.findAll());

        return "home/index";
    }
}