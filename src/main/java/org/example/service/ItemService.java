package org.example.service;

import org.example.model.Item;
import org.example.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ItemService {

    private final ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public void add(Item item) {
        repository.save(item);
    }

    public List<Item> getList() {
        return (List<Item>) repository.findAll();
    }

    public Item getById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
