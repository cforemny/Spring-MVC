package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.repository.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Cyprian on 2017-03-03.
 */
@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<Product>();

    public InMemoryProductRepository() {
        Product robotics = new Product("P1234", "Zajecia z robotyki", new BigDecimal(999));
        robotics.setDescription("Super zajecia z robotyki dla dzieci i mlodziezy");
        robotics.setCategory("Szkolenia");
        robotics.setManufacturer("cyp");
        robotics.setUnitsInStock(20);

        Product it = new Product("P1235", "Uslugi programistyczne", new BigDecimal(1000000));
        it.setDescription("Profesjonalne uslugi programistyczne");
        it.setCategory("it");
        it.setManufacturer("cyp");
        it.setUnitsInStock(1);

        Product machine = new Product("P1236", "Montowanie urzadzen", new BigDecimal(5000));
        machine.setDescription("Instalacja maszyn i urzadzen");
        machine.setCategory("Maszyny");
        machine.setManufacturer("Ekipa");
        machine.setUnitsInStock(2);

        listOfProducts.add(robotics);
        listOfProducts.add(it);
        listOfProducts.add(machine);
    }

    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    public Product getProductById(String productId) {
        Product productById = null;
        for (Product product : listOfProducts) {
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId)){
                productById = product;
                break;
            }
        }
    if(productById == null){
            throw new IllegalArgumentException("Nie ma produktu o wksazanym id: " + productId);
    }
        return productById;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<Product>();
        for (Product product : listOfProducts) {
            if (category.equalsIgnoreCase(product.getCategory())) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<Product>();
        Set<Product> productsByCategory = new HashSet<Product>();
        Set<String> criterias = filterParams.keySet();
        if(criterias.contains("brand")){
            for (String brandName : filterParams.get("brand")) {
                for (Product product : listOfProducts) {
                    if(brandName.equalsIgnoreCase(product.getManufacturer())){
                        productsByBrand.add(product);
                    }
                }

            }

        }
        if(criterias.contains("category")){
            for (String category : filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(category));

            }
        }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
    }

    public void addProduct(Product product) {
        listOfProducts.add(product);
    }
}
