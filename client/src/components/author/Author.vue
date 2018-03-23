<template>
  <tr  :class="{ hover: hover, 'author-row': true }"
       @mouseover="hover = true"
       @mouseleave="hover = false">
    <td class="name">{{author.name}}</td>
    <td class="books">{{author.books}}</td>
    <td><button @click="removeAuthor(author.id)">X</button></td>
  </tr>
</template>

<script>
export default {
  data () {
    return {
      hover: false
    }
  },
  props: ['author', 'removeAuthor']
}
</script>

<style scoped>
  .author-row {
    padding: 15px;
    border: 1px solid lightblue;
  }

  .hover {
    background: lightblue;
  }

  .name {
    font-weight: bold;
  }

  .books {
    font-style: italic;
  }

</style>
