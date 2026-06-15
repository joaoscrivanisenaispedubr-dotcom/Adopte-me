package com.pbe.adopt.me.Controller;

import com.pbe.adopt.me.Repository.PetRepository;
import com.pbe.adopt.me.model.Pet;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;
import java.io.IOException;
import java.util.UUID;

@Controller
public class PetController {

    @Autowired
    private PetRepository petRepository;

    private final String uploadDir = "src/main/resources/static/pet_foto/";

    // LISTAGEM
    @GetMapping("/pet/listagem")
    public String listagem(Model model){
        model.addAttribute("pets", petRepository.findAll());
        return "/pet/listagem";
        // return "/fragments/listagem_pet";
    }

    // CADASTRO
    @GetMapping("/pet/cadastro")
    public String cadastro(Model model){

        model.addAttribute("pet", new Pet());

        return "/pet/cadastro";
    }

    // ALTERAR
    @GetMapping("/pet/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){

        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet inválido"));

        model.addAttribute("pet", pet);

        return "/pet/alterar";
    }

    // SALVAR
    @PostMapping("/pet/salvar")
    public String salvar(@Valid Pet pet,
                         BindingResult result,
                         @RequestParam(value="arquivoFoto", required=false) MultipartFile arquivoFoto){

        if(result.hasErrors()){

            if(pet.getId() != null){
                return "/pet/alterar";
            }

            return "/pet/cadastro";
        }

        try {

            if (arquivoFoto != null && !arquivoFoto.isEmpty()) {

                String nomeArquivo = UUID.randomUUID() + "_" + arquivoFoto.getOriginalFilename();

                Path caminhoDiretorio = Paths.get(uploadDir).toAbsolutePath();

                if (!Files.exists(caminhoDiretorio)) {
                    Files.createDirectories(caminhoDiretorio);
                }

                Path caminhoArquivo = caminhoDiretorio.resolve(nomeArquivo);

                arquivoFoto.transferTo(caminhoArquivo.toFile());

                pet.setFoto(nomeArquivo);
            }
            else if(pet.getId() != null){

                Pet petBanco = petRepository.findById(pet.getId()).orElse(null);

                if(petBanco != null){
                    pet.setFoto(petBanco.getFoto());
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        petRepository.save(pet);

        return "redirect:/pet/listagem";
    }

    // EXCLUIR
    @GetMapping("/pet/excluir/{id}")
    public String excluir(@PathVariable Long id){

        petRepository.deleteById(id);

        return "redirect:/pet/listagem";
    }

    @GetMapping("/pet/catalogo")
    public String catalogo(Model model){

        model.addAttribute("pets", petRepository.findAll());

        return "/pet/catalogo";
    }
}