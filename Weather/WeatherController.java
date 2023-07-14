import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherMicroserviceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

@RestController
class WeatherController {

    private final RestTemplate restTemplate;

    public WeatherController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/weather")
    public String getWeather() {
        String apiUrl = "https://api.open-meteo.com/weather?latitude=38.9072&longitude=-77.0369";
        String weatherData = restTemplate.getForObject(apiUrl, String.class);
        return weatherData;
    }
}
