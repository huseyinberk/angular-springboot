package config;
/*Web API geliştirmede en önemli ihtiyaçlardan biri dokümantasyon ihtiyacıdır. Çünkü API methodlarının ne işe yaradığı ve nasıl
kullanıldığı dokümantasyon içeresinde anlaşılır olması gerekir. Api dokümantasyonunu el emeği ile yazmak hem zordur hemde güncel
tutması imkansızdır. Bir biçimde bu dokümantasyonu güncel olarak üretmek gerekir. Burada imdadımıza swagger yetişiyor.
Swagger’ın önemli bir amacı RestApi ler için bir arayüz sağlamaktır. Bu hem insanların hemde bilgisayarlara kaynak koda erişmeden
RestApi lerin özelliklerini görmesine, incelemesine ve anlamasına olanak sağlar.*/
//http://localhost:8080/swagger-ui.html
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                /*select() -> ApiSelectorBuilder instance’si döndürülüyor ve ayarlarımız bunun üzerine yapılıyor.
                apis() ile dokümana dahil edilecek paketleri seçebiliyoruz, şu an tüm paketler dahil isterseniz bunu değiştirerek
                belirlediğini paketleri kullanabilirsiniz.
                paths() ise yine aynı şekilde dokümana dahil edilecek adreslerimizi belirlediğimiz yerdir.*/
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.iprobe.product"))
                .paths(regex("/.*")) //bütün metodların dökümantasyonu
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot Swagger")
                .description("\"Spring Boot Swagger Demo\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}