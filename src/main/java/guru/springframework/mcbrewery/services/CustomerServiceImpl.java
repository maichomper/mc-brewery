package guru.springframework.mcbrewery.services;

import guru.springframework.mcbrewery.web.model.BeerDto;
import guru.springframework.mcbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Mishew")
                .build();
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Shew")
                .build();
    }

    @Override
    public void update(UUID customerId, CustomerDto customerDto) {

    }

    @Override
    public void delete(UUID customerId) {

    }

}
