package br.com.Magalu.service;

import br.com.Magalu.entity.Client;
import br.com.Magalu.repository.ClientRepository;
import br.com.Magalu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    public Client cadastrarCliente(Client client){
        return clientRepository.save(client);
    }

    public Boolean existByCpf(String cpf) {
        return clientRepository.existsByCpf(cpf);
    }
}
