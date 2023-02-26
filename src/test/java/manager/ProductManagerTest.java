package manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.Book;
import domain.Product;
import repository.ProductRepository;
import domain.Smartphone;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(8, "Евгений Онегин", 660, "А.С.Пушкин");
    Product smartphone1 = new Smartphone(6, "Phone Honor", 30_000, "China");
    Product smartphone2 = new Smartphone(2, "Phone Samsung", 60_000, "South Korea");
    Product product = new Product(11, "Книга", 500);

    @BeforeEach
    public void addProducts(){
        manager.add(book);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(product);
    }
    @Test
    public void search() {
        String name = "Honor";

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchEmpty() {
        String name = "Apple";

        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOneMore() {
        String name = "Phone";

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }
}
