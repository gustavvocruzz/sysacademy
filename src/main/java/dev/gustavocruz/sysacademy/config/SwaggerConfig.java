package dev.gustavocruz.sysacademy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SysAcademy API")
                        .version("1.0.0")
                        .description("API para gerenciamento de sistema acadêmico. " +
                                "Permite gerenciar alunos, matrículas, graduações e modalidades de ensino.")
                        .contact(new Contact()
                                .name("Gustavo Cruz")
                                .url("https://github.com/gustavvocruzz")
                                .email("contato@gustavocruz.dev"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Local Development Server"),
                        new Server()
                                .url("https://api.sysacademy.dev")
                                .description("Production Server")
                ));
    }
}
