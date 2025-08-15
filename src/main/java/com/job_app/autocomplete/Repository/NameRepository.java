package com.job_app.autocomplete.Repository;

import com.job_app.autocomplete.Model.Name;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NameRepository extends JpaRepository<Name, Long> {
    // Custom query to find names starting with a given prefix
    List<Name> findByNameStartingWith(String prefix);
}
