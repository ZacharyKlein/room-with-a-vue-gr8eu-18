<template>
  <div class="form">
    <div class="title cell">
      <label>Name</label>
      <input v-model="author.name" type="text" ref="authorName">
    </div>

    <div class="save cell">
      <button @click="submitNewAuthor()">Add Author</button>
    </div>
  </div>
</template>

<script>
export default {
  props: ['addAuthor'],
  data () {
    return {
      author: {
        name: ''
      }
    }
  },
  methods: {
    submitNewAuthor: function () {
      this.addAuthor(this.author)
      this.author = {name: ''}
      this.$refs.authorName.focus()
    }
  }
}
</script>

<style scoped>

  .cell {
    width: 250px;
    float: left
  }

  .save {

  }

</style>
