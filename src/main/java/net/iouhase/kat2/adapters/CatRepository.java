package net.iouhase.kat2.adapters;

import net.iouhase.kat2.model.Cat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatRepository {
    private final JdbcTemplate jdbcTemplate;

    public CatRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Cat cat) {
        String sql = "INSERT INTO kats (owner, name, race age) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, cat.getOwner(), cat.getName(), cat.getRace(), cat.getAge());
    }

    public Cat findByID(Cat cat) {
        String sql = "SELECT * FROM kats WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Cat.class), cat.getId());
    }

    public List<Cat> findAll() {
        String sql = "SELECT id, owner, name, race, age FROM kats ORDER BY id DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cat.class));
    }

    public void update(Cat cat) {
        String sql = "UPDATE kats SET owner = ?, name = ?, race = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, cat.getOwner(), cat.getName(), cat.getRace(), cat.getAge());
    }

    public void delete(Cat cat) {
        String sql = "DELETE FROM kats WHERE id = ?";
        jdbcTemplate.update(sql, cat.getId());
    }
}
