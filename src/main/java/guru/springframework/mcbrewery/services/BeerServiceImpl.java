package guru.springframework.mcbrewery.services;

import guru.springframework.mcbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Colimita")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto create(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void update(UUID beerId, BeerDto beerDto){

    }

    @Override
    public void delete(UUID beerId) {
        log.debug("Deleting a beer");
    }
}
