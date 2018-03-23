<template>
  <div class="form">
    <div class="title cell">
      <label>Title</label>
      <input v-model="book.title" type="text" ref="bookTitle"/>
    </div>
    <div class="pages cell">
      <label>Pages</label>
      <input v-model="book.pages" type="number"/>
    </div>
    <div class="author cell">
      <label>Author</label>

      <select v-model="book.author">
        <option disabled selected value="">Choose Author</option>
        <option :key="author.id" :value="{ id: author.id }" v-for="author in authors">{{author.name}}</option>
      </select>
    </div>
    <div class="save cell">
      <button @click="submitNewBook()">Add Book</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'BookCreateForm',
  props: ['addBook', 'authors'],
  data () {
    return {
      book: {
        title: '',
        pages: null,
        author: null
      }
    }
  },
  methods: {
    submitNewBook: function () {
      this.addBook(this.book)
      this.book = {title: '', pages: null, author: {}}
      this.$refs.bookTitle.focus()
    }
  }
}
</script>

<style scoped>

  .cell {
    width: 250px;
    float: left
  }

</style>
