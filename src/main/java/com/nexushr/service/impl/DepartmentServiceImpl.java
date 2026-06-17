package com.nexushr.service.impl;

import com.nexushr.entity.Department;
import com.nexushr.repository.DepartmentRepository;
import com.nexushr.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {

        Department existingDepartment =
                repository.findById(id).orElse(null);

        if (existingDepartment != null) {

            existingDepartment.setName(department.getName());
            existingDepartment.setDescription(department.getDescription());

            return repository.save(existingDepartment);
        }

        return null;
    }

    @Override
    public void deleteDepartment(Long id) {
        repository.deleteById(id);
    }
}