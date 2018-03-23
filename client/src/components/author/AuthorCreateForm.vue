<template>
  <div class="form">
    <div class="title cell">
      <label>Name</label>
      <input v-model="author.name" type="text"/>
    </div>

    <div class="save cell">
      <button @click="addAuthor(author)">Add Author</button>
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
