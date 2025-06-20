package org.example.deliverymatch.service;

import org.example.deliverymatch.dto.TrajetDto;
import org.example.deliverymatch.entity.Trajet;
import org.example.deliverymatch.entity.User;
import org.example.deliverymatch.mapper.TrajetMapper;
import org.example.deliverymatch.repository.TrajetRepository;
import org.example.deliverymatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<TrajetDto> getAllTrajets() {
        return trajetRepository.findAll().stream()
                .map(trajetMapper::toDto)
                .toList();
    }

    public TrajetDto modifierTrajet(Long id, TrajetDto trajetDto, Long conducteurId) {
        Trajet trajet = trajetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trajet non trouvé"));
        if (!trajet.getConducteur().getId().equals(conducteurId)) {
            throw new RuntimeException("Vous n'êtes pas autorisé à modifier ce trajet");
        }
        trajet.setLieuDepart(trajetDto.getLieuDepart());
        trajet.setEtapesIntermediaires(trajetDto.getEtapesIntermediaires());
        trajet.setDestination(trajetDto.getDestination());
        trajet.setLongueurMax(trajetDto.getLongueurMax());
        trajet.setLargeurMax(trajetDto.getLargeurMax());
        trajet.setHauteurMax(trajetDto.getHauteurMax());
        trajet.setTypeMarchandise(trajetDto.getTypeMarchandise());
        trajet.setCapaciteDisponible(trajetDto.getCapaciteDisponible());
        trajet.setDateDepart(trajetDto.getDateDepart());
        trajet.setActif(trajetDto.isActif());
        Trajet saved = trajetRepository.save(trajet);
        return trajetMapper.toDto(saved);
    }

    public void supprimerTrajet(Long id, Long conducteurId) {
        Trajet trajet = trajetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trajet non trouvé"));
        if (!trajet.getConducteur().getId().equals(conducteurId)) {
            throw new RuntimeException("Vous n'êtes pas autorisé à supprimer ce trajet");
        }
        trajetRepository.deleteById(id);
    }
}