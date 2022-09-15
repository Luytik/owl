package owl.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import owl.models.Goods;
import owl.models.SalesList;
import owl.services.SalesListService;

import java.io.File;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public CommandLineRunner firstInput(final SalesListService salesListService){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Goods goods = new Goods();
                SalesList goodsForSaling = new SalesList();
                for(long i = 1; i < 5; i++){
                    goodsForSaling.setGoods(goods);
                    goodsForSaling.setDescription("short description");
                    goodsForSaling.setPrice(22.0);
                    goodsForSaling.setSelfPrice(16.0);
                    goodsForSaling.setPictureAsJSON(new File("E:\\PRJS\\owl\\pictures\\2.png"));
                }
            }
        };
    }

}
