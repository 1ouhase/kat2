package net.iouhase.kat2.usecase;

import net.iouhase.kat2.adapters.CatRepository;
import net.iouhase.kat2.model.Cat;
import net.iouhase.kat2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    private final CatRepository catRepository;

    public CatService(final CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void save(Cat cat) {
        catRepository.save(cat);
    }

    public Cat findById(Cat cat) {
        return catRepository.findById(cat);
    }

    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    public void update(Cat cat) {
        catRepository.update(cat);
    }

    public void delete(Cat cat) {
        catRepository.delete(cat);
    }
    public List<Cat> findByOwner(User user) {
        return findAll();
    }
}
