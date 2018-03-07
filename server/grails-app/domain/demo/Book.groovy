package demo

import grails.rest.Resource

@Resource
class Book {

    String title
    Integer pages

    static belongsTo = [author: Author]

    static constraints = {
        pages max: 1000, nullable: true
    }
}
