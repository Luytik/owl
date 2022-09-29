package owl.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import owl.models.Category;
import owl.services.CategoryService;


@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:///" + System.getProperty("user.dir") + "/src/main/upload/");
    }

   /* @Bean
    public CommandLineRunner firstInput(final CategoryService categoryService){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Category category1 = new Category("Дизайнерські рішення");
                categoryService.addCategory(category1);
                Category category2 = new Category("Конструктори");
                categoryService.addCategory(category2);
                Category category3 = new Category("Для дому");
                categoryService.addCategory(category3);
            }
        };
    }*/

}
