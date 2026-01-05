<script setup>
import { ref, onMounted } from 'vue'
const emit = defineEmits(['search'])

/* 검색어 */
const keyword = ref('')

const onSearch = () => {
  // Emit search event regardless of empty or not, parent handles logic (or standard debounce could be better but sticking to simple submit)
  console.log('검색어:', keyword.value)
  emit('search', keyword.value)
}

</script>

<template>
  <section class="search-section">
    <form @submit.prevent="onSearch">

      <span class="service">중고거래</span>

      <!-- 검색어 -->
      <input
        type="search"
        v-model="keyword"
        placeholder="검색어를 입력해주세요"
        aria-label="검색어 입력"
      />

      <!-- 검색 버튼 -->
      <button type="submit">
        검색
      </button>
    </form>
  </section>
</template>

<style scoped>

/* 검색 섹션 전체 */
.search-section {
  width: 100%;
  display: flex;
  justify-content: center;
  padding: 1rem;
  background-color: #fff; /* 은은한 배경 */
}

/* 폼 스타일 */
.search-section form {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  background-color: #fff;
  padding: 0.5rem 1rem;
  border-radius: 24px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.1);
  max-width: 500px;
  width: 100%;
}

/* 서비스 이름 */
.search-section .service {
  font-weight: 600;
  color: #941da0; /* 포인트 컬러 */
  padding: 0 0.5rem;
  white-space: nowrap;
}

/* 검색 input */
.search-section input[type="search"] {
  flex: 1;
  padding: 0.5rem 1rem;
  border: 1px solid #fff;
  border-radius: 20px;
  font-size: 1rem;
  outline: none;
  transition: border 0.2s;
}

.search-section input[type="search"]:focus {
  border-color: #941da0;
}

/* 검색 버튼 */
.search-section button {
  padding: 0.5rem 1rem;
  background-color: lightgrey;
  color: white;
  border: none;
  border-radius: 20px;
  font-weight: 600;
  cursor: pointer;
  transition: background-color 0.2s;
}

.search-section button:hover {
  background-color: #941da0;
}

</style>
