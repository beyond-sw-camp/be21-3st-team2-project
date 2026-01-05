<script setup>
import { useRouter } from 'vue-router'
import BuySell from '../components/mainpageSection/BuySell.vue'
import GogumaText from "../components/mainpageSection/GogumaText.vue"
import SearchBar from '../components/mainpageSection/SearchBar.vue'

const router = useRouter()

const handleSearch = (keyword) => {
  if (keyword && keyword.trim()) {
    router.push({ path: '/market', query: { q: keyword } })
  }
}
</script>

<template>
  <main class="main-page">
    <!-- 타이틀 -->
    <GogumaText/>
    <!-- 검색 영역 -->
    <SearchBar @search="handleSearch"/>
    <BuySell/>


  </main>
</template>


<style scoped>

.main-page {
  padding: 40px 16px;
  display: flex;
  flex-direction: column;
  align-items: center; /* 자식 요소 가운데 정렬 */
}

.hero h2 {
  font-size: 28px;
  font-weight: bold;
  line-height: 1.3;
}



</style>