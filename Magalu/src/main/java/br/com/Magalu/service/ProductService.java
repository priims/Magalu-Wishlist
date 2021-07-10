package br.com.Magalu.service;

import br.com.Magalu.entity.Product;
import br.com.Magalu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product cadastrarProduto (Product product){
        return productRepository.save(product);
    }
}
