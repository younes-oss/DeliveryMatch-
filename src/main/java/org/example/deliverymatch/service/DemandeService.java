package org.example.deliverymatch.service;

import org.example.deliverymatch.dto.DemandeDto;
import org.example.deliverymatch.entity.Demande;
import org.example.deliverymatch.entity.Trajet;
import org.example.deliverymatch.entity.User;
import org.example.deliverymatch.mapper.DemandeMapper;
import org.example.deliverymatch.repository.DemandeRepository;
import org.example.deliverymatch.repository.TrajetRepository;
import org.example.deliverymatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeService {
    @Autowired
    private DemandeRepository demandeRepository;
    @Autowired
    private TrajetRepository trajetRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DemandeMapper demandeMapper;

    public DemandeDto creerDemande(DemandeDto demandeDto, Long expediteurId) {
        Demande demande = demandeMapper.toEntity(demandeDto);
        User expediteur = userRepository.findById(expediteurId)
                .orElseThrow(() -> new RuntimeException("Expéditeur non trouvé"));
        Trajet trajet = trajetRepository.findById(demandeDto.getTrajetId())
                .orElseThrow(() -> new RuntimeException("Trajet non trouvé"));
        demande.setExpediteur(expediteur);
        demande.setTrajet(trajet);
        demande.setStatut(org.example.deliverymatch.entity.StatutDemande.EN_ATTENTE);
        demande.setDateCreation(java.time.LocalDateTime.now());
        Demande saved = demandeRepository.save(demande);
        return demandeMapper.toDto(saved);
    }
} 