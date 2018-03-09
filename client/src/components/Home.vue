<template>
  <div class="hello">
    <h1>{{ msg }}</h1>

    <book-list :books="books" :removeBook="removeBook"  />

  </div>
</template>

<script>
import BookList from './BookList.vue'

export default {
  name: 'Welcome',
  data () {
    return {
      msg: 'Welcome to the Library',
      books: []
    }
  },
  created: function () {
    fetch(`http://localhost:8080/book`)
      .then(r => r.json())
      .then(json => {
        this.books = json
      })
      .catch(e => console.warn(e))
  },
  methods: {
    removeBook: function (id) {
      fetch(`http://localhost:8080/book/${id}`, {method: 'delete'})
        .then(r => {
          if (r.status === 204) {
            this.books = this.books.filter(b => b.id !== id)
          }
        })
    }
  },
  components: {
    'book-list': BookList
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
