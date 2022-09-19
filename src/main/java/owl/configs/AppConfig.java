package owl.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    /*@Bean
    public CommandLineRunner firstInput(final SalesListService salesListService){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //Goods goods = new Goods();
                SalesList goodsForSaling = new SalesList();
                for(long i = 1; i < 5; i++){
                    //goodsForSaling.setGoods(goods);
                    goodsForSaling.setDescription("short description");
                    goodsForSaling.setPrice(22.0);
                    goodsForSaling.setSelfPrice(16.0);
                    goodsForSaling.setPathToPicture("E://PRJS/owl/pictures/a.jpg");
                    salesListService.addGoodsForSaling(goodsForSaling);
                }
            }
        };
    }*/

}
