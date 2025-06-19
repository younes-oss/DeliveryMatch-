package org.example.deliverymatch.service;

import org.example.deliverymatch.dto.TrajetDto;
import org.example.deliverymatch.entity.Trajet;
import org.example.deliverymatch.entity.User;
import org.example.deliverymatch.mapper.TrajetMapper;
import org.example.deliverymatch.repository.TrajetRepository;
import org.example.deliverymatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrajetService {
    @Autowired
    private TrajetRepository trajetRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TrajetMapper trajetMapper;

    public TrajetDto creerTrajet(TrajetDto trajetDto, Long conducteurId) {
        Trajet trajet = trajetMapper.toEntity(trajetDto);
        User conducteur = userRepository.findById(conducteurId)
                .orElseThrow(() -> new RuntimeException("Conducteur non trouvé"));
        trajet.setConducteur(conducteur);
        trajet.setActif(true);
        trajet.setDateCreation(java.time.LocalDateTime.now());
        Trajet saved = trajetRepository.save(trajet);
        return trajetMapper.toDto(saved);
    }
}