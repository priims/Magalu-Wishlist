package br.com.Magalu.controller;

import br.com.Magalu.entity.Product;
import br.com.Magalu.payload.Response;
import br.com.Magalu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/magalu")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(productService.cadastrarProduto(product), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response(false, "Bad Request"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
