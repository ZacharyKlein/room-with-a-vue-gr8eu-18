<template>
    <tr class="book-row">
      <td class="title">{{book.title}}</td>
      <td class="pages">{{book.pages}}</td>
      <td class="author">{{book.author}}</td>
    </tr>
</template>

<script>
export default {
  name: 'book',
  props: ['book']
}
</script>

<style scoped>
  .book-row {
    padding: 15px;
    border: 1px solid lightblue;
  }

  .title {
    font-weight: bold;
  }

  .pages {
    font-style: italic;
  }

  .author {
    text-decoration: underline;
  }
</style>
