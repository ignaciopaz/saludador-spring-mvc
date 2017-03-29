package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaludadorController {
	@Autowired private SaludoRepository saludoRepository;

    @GetMapping("/saludar")
    public String firmar(Model model) {
        model.addAttribute("saludo", new Saludo());
        return "saludar";
    }

    @PostMapping("/procesarSaludo")
    public String procesarFirma(@ModelAttribute Saludo saludo) {
    	saludoRepository.save(saludo);
        return "result";
    }

}
