package guru.springframework.mcbrewery.web;

import guru.springframework.mcbrewery.services.BeerService;
import guru.springframework.mcbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService){

        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody BeerDto beerDto){
        BeerDto newBeer = beerService.create(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add( "Location", "/api/v1/beer/" + newBeer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity update(@Valid @PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto){
        beerService.update(beerId, beerDto);

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity(headers, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("beerId") UUID beerId){
        beerService.delete(beerId);
    }

}
