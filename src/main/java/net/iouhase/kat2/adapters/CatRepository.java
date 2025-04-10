package net.iouhase.kat2.adapters;

import net.iouhase.kat2.model.Cat;
import net.iouhase.kat2.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatRepository implements RepositoryItf<Cat>{
    private final JdbcTemplate jdbcTemplate;

    public CatRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Cat cat) {
        String sql = "INSERT INTO kats ( name, race, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, cat.getName(), cat.getRace(), cat.getAge());
    }

    @Override
    public Cat findById(Cat cat) {
        String sql = "SELECT * FROM kats WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Cat.class), cat.getId());
    }

    @Override
    public List<Cat> findAll() {
        String sql = "SELECT * FROM kats";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cat.class));
    }

    public List<Cat> findByOwner(User user){
        String sql = "SELECT * FROM kats WHERE owner = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cat.class), user.getId());
    }

    @Override
    public void update(Cat cat) {
        String sql = "UPDATE kats SET name = ?, race = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, cat.getName(), cat.getRace(), cat.getAge());
    }

    @Override
    public void delete(Cat cat) {
        String sql = "DELETE FROM kats WHERE id = ?";
        jdbcTemplate.update(sql, cat.getId());
    }
}
