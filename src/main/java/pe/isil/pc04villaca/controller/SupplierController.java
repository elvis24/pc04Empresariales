package pe.isil.pc04villaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.isil.pc04villaca.repository.JdbcSupplierRepository;
import pe.isil.pc04villaca.model.Supplier;

@Controller
public class SupplierController {

    @Autowired
    JdbcSupplierRepository jdbcSupplierRepository;

    @GetMapping( {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/suppliers")
    public String getAll(Model model){
        model.addAttribute("suppliers", jdbcSupplierRepository.findAll());
        return "supplier";
    }

    @GetMapping("/suppliers/add")
    public String create(Model model){
        model.addAttribute("supplier", new Supplier());
        return "supplier-add";
    }

    @PostMapping("/suppliers/save")
    public String update(Supplier supplier, Model model){

        jdbcSupplierRepository.create(supplier);

        model.addAttribute("suppliers", jdbcSupplierRepository.findAll());

        return "supplier";
    }

    @GetMapping("/suppliers/edit/{ruc}")
    public String getProductForEdit(@PathVariable String  ruc,
                                    Model model){
        model.addAttribute("supplier",
                jdbcSupplierRepository.findById(ruc));
        return "supplier-edit";
    }

    @PostMapping("/suppliers/update/{ruc}")
    public String update(@PathVariable String ruc,
                                Supplier supplier,
                                Model model){
        jdbcSupplierRepository.update(supplier);
        model.addAttribute("suppliers",
                jdbcSupplierRepository.findAll());
        return "supplier";
    }

    @GetMapping("/suppliers/delete/{ruc}")
    public String delete(@PathVariable String ruc,
                                Model model){
        jdbcSupplierRepository.delete(ruc);
        model.addAttribute("suppliers",
                jdbcSupplierRepository.findAll());
        return "supplier";
    }

}
