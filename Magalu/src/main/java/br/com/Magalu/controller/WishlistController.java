package br.com.Magalu.controller;

import br.com.Magalu.entity.Client;
import br.com.Magalu.entity.Product;
import br.com.Magalu.service.ClientService;
import br.com.Magalu.service.ProductService;
import br.com.Magalu.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magalu")
public class WishlistController {

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;

    @Autowired
    WishlistService wishlistService;


    @PostMapping("/{clientId}/{productId}")
    public Client addProductToWishlist (@PathVariable long clientId, @PathVariable long productId) {
        return wishlistService.addProductToWishlist(clientId, productId);
    }

    @GetMapping("/{clientId}")
    public List<Product> getProductsByClientId (@PathVariable long clientId) {
        return wishlistService.getProductsByClientId(clientId);
    }

    @GetMapping("/{clientId}/{productId}")
    public Product getProductIfExistInAWishlist (@PathVariable long clientId, @PathVariable long productId){
        return wishlistService.getProductIfExistInAWishlist(clientId, productId);
    }

    @DeleteMapping("/{clientId}/{productId}")
    public Client deleteProductInWishlistByClientId (@PathVariable long clientId, @PathVariable long productId) {
        return wishlistService.deleteProductInWishlistByClientId(clientId, productId);
    }


}
