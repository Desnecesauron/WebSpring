package org.projects.WebSpring.services;

import org.projects.WebSpring.entities.User;
import org.projects.WebSpring.repositories.UserRepository;
import org.projects.WebSpring.services.exceptions.DatabaseException;
import org.projects.WebSpring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository repository;

    public List<User> findAll()
    {
        return repository.findAll();
    }

    public User findById(Long id)
    {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException((id)));
    }

    public User insert(User obj)
    {
        return repository.save(obj);
    }

    public void delete(Long id)
    {
        try
        {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex)
        {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException ex)
        {
            throw new DatabaseException(ex.getMessage());
        }

    }

    public User update(Long id, User obj)
    {
        User entity = null;
        try
        {
            entity = repository.getReferenceById(id);
            updateData(entity, obj);

        }
        catch (EntityNotFoundException ex)
        {
            throw new ResourceNotFoundException(id);
        }
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
