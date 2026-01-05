<script setup></script>

<template>
  <router-link to="/market" class="link-sell">
    <object
      data="/src/assets/seed.svg"
      type="image/svg+xml"
      width="24"
      height="24"
    ></object>
    <span class="text-buy">중고거래</span>
  </router-link>
</template>

<style scoped>
.link-sell {
  background-color: #eeeff1;
  transition: background-color 0.15s;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 0.5rem; /* 기존 2rem은 너무 큼, 조절 가능 */
  padding: 0.75rem 1rem;
  border-radius: 0.75rem;
  width: fit-content;
  color: inherit;
  text-decoration: none;
  box-sizing: border-box;
}

.text-buy {
  font-size: 1rem;
  font-weight: 600;
  line-height: 1.5rem;
  color: #2a3038;
}
</style>
