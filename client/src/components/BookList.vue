<template>
  <table class="book-list">
    <thead>
      <td>Title</td>
      <td>Pages</td>
      <td>Author</td>
    </thead>
    <tbody>
      <book :key="book.id" :book="book" v-for="book in books" />
    </tbody>
  </table>
</template>
<script>
import Book from './Book.vue'

export default {
  name: 'book-list',
  props: ['books'],
  components: {
    book: Book
  }
}
</script>

<style scoped>
  .book-list {
    min-width: 1000px
  }
</style>
