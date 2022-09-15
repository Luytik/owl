package owl.services;

import org.springframework.stereotype.Service;
import owl.models.Goods;
import owl.repository.GoodsRepository;

@Service
public class GoodsService {

    private final GoodsRepository goodsRepository;

    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public void addGoodsIfNotExist(Goods goods){

    }

    public void addGoods(Goods goods){
        goodsRepository.save(goods);
    }
}
