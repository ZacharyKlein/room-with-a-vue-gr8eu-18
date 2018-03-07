package demo

import grails.gorm.services.Service

@Service(Author)
interface AuthorService {

    Author save(String name)

    Author get(Serializable id)
}
