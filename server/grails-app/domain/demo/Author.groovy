package demo

import grails.rest.Resource

@Resource
class Author {

    String name

    static hasMany = [books: Book]

    static constraints = {
    }
}
