package br.com.Magalu.service;

import br.com.Magalu.entity.Client;
import br.com.Magalu.entity.Product;
import br.com.Magalu.repository.ClientRepository;
import br.com.Magalu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Client addProductToWishlist(long clientId, long productId) {
        List<Product> test = this.getProductsByClientId(clientId);
        if (test.size() <= 19) {
            Optional<Client> client = clientRepository.findById(clientId);
            if (client.isPresent()) {
                Optional<Product> product = (productRepository.findById(productId));
                if (product.isPresent()) {

                    Product product1 = product.get();
                    Client client1 = client.get();
                    client1.addProduct(product1);
                    return clientRepository.save(client1);
                }
            }
        } else {
            return null;
        }
        return null;
    }

    public List<Product> getProductsByClientId (long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        return client.map(Client::getProducts).orElse(null);
    }

    public Client deleteProductInWishlistByClientId(Long clientId, Long productId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            Optional<Product> product = (productRepository.findById(productId));
            if (product.isPresent()) {

                Product product1 = product.get();
                Client client1 = client.get();
                client1.remove(product1);
                return clientRepository.save(client1);
            }
        } return null;
    }

    public Product getProductIfExistInAWishlist(long clientId, long productId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            Optional<Product> product = (productRepository.findById(productId));
            if (product.isPresent()){

                Product product1 = product.get();
                Client client1 = client.get();
                if (client1.productExist(product1)){
                    return product1;
                } else{
                    return null;
                }
            }
        }
        return null;
    }
}
