package ru.tinkoff.shmeleva.configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.Contact
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfiguration {

    @Bean
    fun openAPI(): OpenAPI = OpenAPI()
        .info(
            Info()
                .title("Toy Store")
                .version("1.0.0")
                .contact(
                    Contact()
                        .email("dgshmeleva@mail.ru")
                        .url("https://toyStore.ru")
                        .name("Shmeleva Daria")
                )
        )
}