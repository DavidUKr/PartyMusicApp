package com.partymusicapp.repository;

import com.partymusicapp.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepo extends JpaRepository<Theme, String> {

}
