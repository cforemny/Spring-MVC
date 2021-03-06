package com.packt.webstore.controller;

import com.packt.webstore.domain.repository.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Cyprian on 2017-03-03.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String list(Model model){

        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    @RequestMapping("/all")
    public String allProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";

    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(@PathVariable("category") String productCategory, Model model){
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria")Map<String, List<String>> filterParams, Model model){
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model){
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model){
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result){
        String[] suppressedFields = result.getSuppressedFields();
        if(suppressedFields.length>0){
            throw new RuntimeException("Proba wiazania niedozwolonych pol:" + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
       productService.addProduct(newProduct);
       return "redirect:/products";
    }
    @InitBinder
    public void initialiseBinder(WebDataBinder bidner){
        bidner.setDisallowedFields("unitsInOrder", "discontinued");
    }
}
