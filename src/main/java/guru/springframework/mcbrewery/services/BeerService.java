package guru.springframework.mcbrewery.services;

import guru.springframework.mcbrewery.web.model.BeerDto;
import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto create(BeerDto beerDto);

    void update(UUID beerId, BeerDto beerDto);

    void delete(UUID beerId);
}

