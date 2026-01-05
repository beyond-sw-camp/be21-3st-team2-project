<script setup>
defineProps({
  productTitle: {
    type: String,
    required: false,
    default: '',
  },
})
</script>

<template>
  <nav class="navbar">
    <ol>
      <li><router-link to="/">홈</router-link></li>
      <li><router-link to="/market">중고거래</router-link></li>
      <li>{{ productTitle }}</li>
    </ol>
  </nav>
</template>

<style scoped>
.navbar ol {
  display: flex;
  list-style: none;
  padding: 0;
  margin: 0 0 20px 0;
  font-size: 13px;
  color: #868e96;
}

.navbar li:not(:last-child)::after {
  content: '>';
  margin: 0 8px;
  color: #ced4da;
}

.navbar a {
  text-decoration: none;
  color: inherit;
  cursor: pointer;
}

.navbar a:hover {
  text-decoration: underline;
}
</style>
