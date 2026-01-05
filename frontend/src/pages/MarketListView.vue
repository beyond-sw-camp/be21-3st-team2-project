<template>
  <div class="market-list-page">
    <!-- 상단 -->
    <div class="header">
      <SearchBar @search="handleSearch" class="search-bar" />
      <button class="write-btn" @click="goToWrite">글쓰기</button>
    </div>

    <!-- SearchBar removed as per design request -->

    <nav class="breadcrumb">
      <router-link to="/">홈</router-link> &gt;
      <router-link to="/market">중고거래</router-link>
    </nav>

    <!-- 메인 영역 -->
    <div class="content">
      <!--			&lt;!&ndash; 사이드바 &ndash;&gt;-->
      <!--			<aside class="sidebar">-->
      <!--				<h3>카테고리</h3>-->
      <!--				<ul>-->
      <!--					<li v-for="category in categories" :key="category">-->
      <!--						{{ category }}-->
      <!--					</li>-->
      <!--				</ul>-->
      <!--			</aside>-->

      <!-- 카드 영역 -->
      <section class="cards-container">
        <router-link
          v-for="item in items"
          :key="item.id"
          :to="`/details/${item.id}`"
          class="card-link"
        >
          <MarketCard :item="item" />
        </router-link>
      </section>
    </div>
    <!-- 글쓰기 모달 -->
    <MarketWriteModal 
      v-if="showModal" 
      @close="showModal = false" 
      @refresh="fetchProducts"
    />
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { getRecentProducts, searchProducts } from '../api/product'
import MarketCard from '../components/MarketList/MarketCard.vue'
import SearchBar from '../components/mainpageSection/SearchBar.vue'
import MarketWriteModal from '../components/MarketList/MarketWriteModal.vue'
import { useAuth } from '../stores/auth'

// 라우터 가져오기
const router = useRouter()
const route = useRoute()
const { accessToken } = useAuth()

// 모달 상태
const showModal = ref(false)

// 버튼 클릭 메서드 -> 모달 오픈
const goToWrite = () => {
  if (!accessToken.value) {
    alert('비 로그인 상태에서는 글을 작성할 수 없습니다')
    return
  }
  showModal.value = true
}

const items = ref([])

const fetchProducts = async () => {
  try {
    const response = await getRecentProducts()
    if (response && response.data) {
      items.value = response.data
    }
  } catch (error) {
    console.error('Failed to fetch recent products', error)
  }
}

const handleSearch = async (keyword) => {
  if (!keyword || !keyword.trim()) {
    await fetchProducts()
    return
  }

  try {
    const response = await searchProducts(keyword)
    if (response && response.data) {
      items.value = response.data
    }
  } catch (error) {
    console.error('Failed to search products', error)
  }
}

onMounted(() => {
  const query = route.query.q
  if (query) {
    handleSearch(query)
  } else {
    fetchProducts()
  }
})

// 더미 데이터 (Optional: Valid categories if needed, or remove)
// const categories = ref([ ... ])
</script>

<style scoped>
.market-list-page {
  max-width: 980px; /* Karrot web width approx */
  margin: 0 auto;
  padding: 40px 20px;
}

/* 상단 헤더 */
.header {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 40px;
  position: relative;
}

.search-bar {
  flex: 1;
  max-width: 600px; /* Limit width */
  margin-right: 20px;
}

/* 글 작성 버튼 (Optional position) */
.write-btn {
  position: absolute;
  right: 0;
  background-color: #941da0; /* Karrot Orange */
  border: none;
  padding: 10px 20px;
  border-radius: 6px;
  font-weight: 700;
  color: #ffffff;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.2s;
}

.write-btn:hover {
  background-color: #ff8c42;
}

/* breadcrumb */
.breadcrumb {
  font-size: 14px;
  color: #868e96;
  margin-bottom: 20px;
}

.breadcrumb a {
  text-decoration: none;
  color: inherit;
}

.breadcrumb a:hover {
  text-decoration: underline;
}

/* 메인 레이아웃 */
.content {
  display: block; /* Removed flex sidebar */
}

/* 카드 영역 */
.cards-container {
  display: grid;
  grid-template-columns: repeat(
    auto-fill,
    minmax(220px, 1fr)
  ); /* Wider cards */
  gap: 40px 24px; /* Row gap 40px, Col gap 24px */
}

.card-link {
  text-decoration: none;
  color: inherit;
  display: block;
}
</style>
