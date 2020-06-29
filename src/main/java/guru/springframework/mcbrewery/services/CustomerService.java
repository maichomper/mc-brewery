package guru.springframework.mcbrewery.services;

import guru.springframework.mcbrewery.web.model.CustomerDto;
import java.util.UUID;

public interface CustomerService {
    CustomerDto getById(UUID customerId);

    CustomerDto create(CustomerDto customerDto);

    void update(UUID customerId, CustomerDto customerDto);

    void delete(UUID customerId);
}
