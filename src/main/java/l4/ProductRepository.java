package l4;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    @Override
    List<Product> findAll();

    List<Product> findAll(Sort sort);

    Product findOneById(Long l);

    Product findFirstByOrderByPrice();

    Product findFirstByOrderByPriceDesc();
}
