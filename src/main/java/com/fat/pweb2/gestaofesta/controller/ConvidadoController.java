package com.fat.pweb2.gestaofesta.controller;

import com.fat.pweb2.gestaofesta.model.Convidado;
import com.fat.pweb2.gestaofesta.repository.ConvidadoRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoRepository convidados;

    @GetMapping("/convidados")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("ListaConvidados");
        mv.addObject("convidados", convidados.findAll());
        return mv;
    }

    @GetMapping("/cadastro")
    public String listarCadastro(){
        ModelAndView mv = new ModelAndView("CadastroConvidados");
        mv.addObject("convidados", convidados.findAll());
        return "CadastroConvidados";
    }

    @PostMapping("/cadastro")
    public String cadastrar(Convidado convidado, Model model) {
        ModelAndView mv = new ModelAndView("CadastroConvidados");
        mv.addObject("convidados", convidados.save(convidado));
        model.addAttribute("convidados", convidados.findAll());
        return "ListaConvidados";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Convidado convidado = convidados.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Convidado com id Inválido:" + id));
        convidados.delete(convidado);
        model.addAttribute("convidados", convidados.findAll());
        return "ListaConvidados";
    }

}
