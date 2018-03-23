<template>
  <table class="author-list">
    <thead>
    <td>Name</td>
    <td>Books</td>
    <td></td>
    </thead>
    <tbody>
    <author v-for="author in authors" v-bind="{author, removeAuthor}" :key="author.id" />
    </tbody>
  </table>
</template>
<script>
import Author from './Author.vue'

export default {
  name: 'author-list',
  props: ['authors', 'removeAuthor'],
  components: {'author': Author}
}
</script>

<style scoped>
  .author-list {
    clear: both;
    min-width: 1000px
  }
</style>
