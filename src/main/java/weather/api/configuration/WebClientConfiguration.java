package weather.api.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfiguration {

    @Value("${values.api.baseUrl}")
    private String baseUrl;

    private final ObjectMapper objectMapper;

    @Bean
    public WebClient myWebClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .clientConnector(new ReactorClientHttpConnector())
                .codecs(configurer -> {
                    configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper));
                    configurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(objectMapper));
                })
                .build();
    }
}
