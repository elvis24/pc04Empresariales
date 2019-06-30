package pe.isil.pc04villaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.pc04villaca.model.Product;
import pe.isil.pc04villaca.repository.JdbcProductRepository;


@Controller
public class ProductController {

    @Autowired
    JdbcProductRepository jdbcProductRepository;

    @GetMapping( {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/products")
    public String getAll(Model model){
        model.addAttribute("products", jdbcProductRepository.findAll());
        return "product";
    }

    @GetMapping("/products/add")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @PostMapping("/products/save")
    public String update(Product product, Model model){

        jdbcProductRepository.update(product);

        model.addAttribute("products", jdbcProductRepository.findAll());

        return "product";
    }

    @GetMapping("/product/edit/{sku}")
    public String getProductForEdit(@PathVariable String  sku,
                                    Model model){
        model.addAttribute("product",
                jdbcProductRepository.findById(sku));
        return "product-edit";
    }

    @PostMapping("/products/update/{sku}")
    public String update(@PathVariable String sku,
                                Product product,
                                Model model){
        jdbcProductRepository.update(product);
        model.addAttribute("products",
                jdbcProductRepository.findAll());
        return "product";
    }

    @GetMapping("/products/delete/{ruc}")
    public String delete(@PathVariable String sku,
                                Model model){
        jdbcProductRepository.delete(sku);
        model.addAttribute("suppliers",
                jdbcProductRepository.findAll());
        return "product";
    }

}
