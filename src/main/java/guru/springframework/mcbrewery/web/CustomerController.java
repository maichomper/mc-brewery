package guru.springframework.mcbrewery.web;

import guru.springframework.mcbrewery.services.CustomerService;
import guru.springframework.mcbrewery.web.model.BeerDto;
import guru.springframework.mcbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto newCustomer = customerService.create(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add( "Location", "/api/v1/customer/" + newCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer(
            @PathVariable("customerId") UUID customerId,
            @Valid @RequestBody CustomerDto customerDto
    ) {
        customerService.update(customerId, customerDto);

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity(headers, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.delete(customerId);
    }

}
