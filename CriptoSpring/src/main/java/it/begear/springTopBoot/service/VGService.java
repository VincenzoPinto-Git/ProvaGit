package it.begear.springTopBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.springTopBoot.entities.Registrato;
import it.begear.springTopBoot.repository.VGRepo;

@Service
public class VGService {
 
    @Autowired
    private VGRepo repo;
     
    public List<Registrato> listAll() {
        List<Registrato> lista = repo.findAll();
        return lista;
    }
     
    public void save(Registrato product) {
        repo.save(product);
    }
     
    public Registrato get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
    public List<Registrato> findByAcquisto(String acquisto) {
    	return repo.findRegistratoByAcquisto(acquisto);
    }
}