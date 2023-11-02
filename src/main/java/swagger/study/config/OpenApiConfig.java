package swagger.study.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "swagger 공부",
                description = "스웨거를 이용한 api",
                version = "v1.0.0",
                contact = @Contact(
                        name = "AhnDaHoon",
                        email = "psycn@kakao.com"
                )
        )
)
@Configuration
public class OpenApiConfig  {
    @Bean
    public GroupedOpenApi group1() {
        String[] packagesToScan = {"swagger.study.controller"};

        return GroupedOpenApi.builder()
                .group("USER")
                .packagesToScan(packagesToScan)
                .build();
    }
    @Bean
    public GroupedOpenApi group2() {
        String[] packagesToScan = {"swagger.study.controller2"};

        return GroupedOpenApi.builder()
                .group("USER2")
                .packagesToScan(packagesToScan)
                .build();
    }
}
