package com.devpro.imageload.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}