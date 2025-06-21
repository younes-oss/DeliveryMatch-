package org.example.deliverymatch.mapper;

import org.example.deliverymatch.dto.DemandeDto;
import org.example.deliverymatch.entity.Demande;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DemandeMapper {
    @Mapping(source = "trajet.id", target = "trajetId")
    @Mapping(source = "statut", target = "statut")
    @Mapping(source = "dateCreation", target = "dateCreation")
    DemandeDto toDto(Demande demande);

    @Mapping(source = "trajetId", target = "trajet.id")
    Demande toEntity(DemandeDto dto);
} 