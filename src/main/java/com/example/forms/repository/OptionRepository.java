package com.example.forms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.forms.entities.Option;


@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
}