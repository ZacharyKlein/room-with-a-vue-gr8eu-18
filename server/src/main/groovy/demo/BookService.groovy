package demo

import grails.gorm.services.Service

@Service(Book)
interface BookService {

    Book save(String title, Integer pages, Author author)

    Book get(Serializable id)
}