import com.shiyan.domain.Book;
import com.shiyan.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-service.xml",
        "classpath:application-dao.xml"})
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Test
    public void findBookById() {
        Book book = bookService.findById("1");
        System.out.println(book.getAuthor());
        System.out.println(book.getName());
        System.out.println(book.getPress());
    }
}
