package guru.springframework.mcbrewery.services;

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

}
