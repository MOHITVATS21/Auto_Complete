package com.job_app.autocomplete.Repository;

import com.job_app.autocomplete.Model.Name;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NameRepository extends JpaRepository<Name, Long> {


    List<Name> findByName(String prefix);
    // This interface will automatically provide CRUD operations for BoyName entities
    // No additional methods are needed unless custom queries are required
}


