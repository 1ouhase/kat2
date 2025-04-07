package net.iouhase.kat2.adapters;

import net.iouhase.kat2.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements RepositoryItf<User> {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword());
    }

    @Override
    public User findById(User user) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getId());
    }

    @Override
    public List<User> findAll(){
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getId());
    }

    @Override
    public void delete(User user) {
        String sql = "DELETE FROM users WHERE email = ?";
        jdbcTemplate.update(sql, user.getEmail());
    }
}
