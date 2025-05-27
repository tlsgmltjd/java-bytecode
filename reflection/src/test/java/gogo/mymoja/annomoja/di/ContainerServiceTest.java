package gogo.mymoja.annomoja.di;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainerServiceTest {

    @Test
    public void getObject_BookRepository() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        Assertions.assertNotNull(bookRepository);
    }


    @Test
    public void getObject_BookService() {
        BookService bookService = ContainerService.getObject(BookService.class);
        Assertions.assertNotNull(bookService);
        Assertions.assertNotNull(bookService.bookRepository);
    }

}
