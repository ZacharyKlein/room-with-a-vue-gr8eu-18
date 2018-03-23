<template>
  <div class="hello">
    <h1>{{ msg }}</h1>

    <book-create-form :authors="authors" :addBook="addBook"  />
    <br/><hr/>
    <book-list :books="books" :removeBook="removeBook"  />

    <br/><hr/>
    <author-create-form :addAuthor="addAuthor" />

    <br/><hr/>
    <author-list :authors="authors" :removeAuthor="removeAuthor" />

  </div>
</template>

<script>
import BookList from '@/components/book/BookList'
import BookCreateForm from '@/components/book/BookCreateForm'
import AuthorList from '@/components/author/AuthorList'
import AuthorCreateForm from '@/components/author/AuthorCreateForm'

export default {
  data () {
    return {
      msg: 'Welcome to the Library',
      books: [],
      authors: []
    }
  },
  created: function () {
    fetch(`http://localhost:8080/book`)
      .then(r => r.json())
      .then(json => {
        this.books = json
      })
      .catch(e => console.warn(e))

    fetch(`http://localhost:8080/author`)
      .then(r => r.json())
      .then(json => {
        this.authors = json
      })
      .catch(e => console.warn(e))
  },
  methods: {
    addBook: function (book) {
      fetch(`http://localhost:8080/book/`,
        { method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(book)})
        .then(r => {
          if (r.status === 201) return r.json()
          else throw Error('Could not save book')
        })
        .then(json => this.books.push(json))
        .catch(e => console.error(e))
    },
    addAuthor: function (author) {
      fetch(`http://localhost:8080/author/`,
        { method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(author)})
        .then(r => {
          if (r.status === 201) return r.json()
          else throw Error('Could not save author')
        })
        .then(json => this.authors.push(json))
        .catch(e => console.error(e))
    },
    removeBook: function (id) {
      fetch(`http://localhost:8080/book/${id}`, {method: 'delete'})
        .then(r => {
          if (r.status === 204) this.books = this.books.filter(b => b.id !== id)
        })
    },
    removeAuthor: function (id) {
      fetch(`http://localhost:8080/author/${id}`, {method: 'delete'})
        .then(r => {
          if (r.status === 204) this.authors = this.authors.filter(b => b.id !== id)
        })
    }
  },
  components: {
    'book-list': BookList,
    'book-create-form': BookCreateForm,
    'author-list': AuthorList,
    'author-create-form': AuthorCreateForm
  }
}
</script>

<style scoped>
  .hello {
    width: 1000px;
    margin: 0 auto;
  }

  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
