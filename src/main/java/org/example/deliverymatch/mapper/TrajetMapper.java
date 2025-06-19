package org.example.deliverymatch.mapper;

import org.example.deliverymatch.dto.TrajetDto;
import org.example.deliverymatch.entity.Trajet;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TrajetMapper {
    @Mapping(source = "conducteur.id", target = "conducteurId")
    TrajetDto toDto(Trajet trajet);

    @Mapping(source = "conducteurId", target = "conducteur.id")
    Trajet toEntity(TrajetDto dto);
} 