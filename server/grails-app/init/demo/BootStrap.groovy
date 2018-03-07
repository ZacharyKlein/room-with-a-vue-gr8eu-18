package demo

import demo.*
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired

@Slf4j
class BootStrap {

    @Autowired
    BookService bookService

    @Autowired
    AuthorService authorService

    def init = { servletContext ->
        log.info "Populating database"
        Author ken = authorService.save("Ken Kousen")

        bookService.save "Making Java Groovy", 800, ken
        bookService.save "Gradle Recipes", 500, ken
        bookService.save "Android Recipies", 600, ken


    }
    def destroy = {
    }
}
