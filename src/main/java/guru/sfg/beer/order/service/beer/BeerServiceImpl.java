package guru.sfg.beer.order.service.beer;

import guru.sfg.beer.order.service.web.model.BeerDto;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

public class BeerServiceImpl implements BeerService {

    public final String BEER_PATH_V1 = "/api/v1/beer";

    public final String BEER_UPC_PATH_V1 = "/api/v1/upc/";

    private final RestTemplate restTemplate;

    private String beerServiceHost;

    public BeerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<BeerDto> getBeerById(UUID uuid) {
        return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_PATH_V1 + uuid.toString()
                , BeerDto.class));
    }

    @Override
    public Optional<BeerDto> getBeerByUpc(String upc) {
        return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_UPC_PATH_V1 +  upc, BeerDto.class ));
    }

    public String getBeerServiceHost() {
        return beerServiceHost;
    }
}
