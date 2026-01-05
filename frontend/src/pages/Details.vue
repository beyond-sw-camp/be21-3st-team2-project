<script setup>
import { onMounted, ref } from 'vue'
import { useRoute } from 'vue-router'
import { getProduct } from '../api/product'
import ImageCard from '../components/detailsSection/ImageCard.vue'
import Navigation from '../components/detailsSection/Navigation.vue'
import ProductInfoCard from '../components/detailsSection/ProductInfoCard.vue'
import ProfileCard from '../components/detailsSection/ProfileCard.vue'

const route = useRoute()
const product = ref(null)
const loading = ref(true)

onMounted(async () => {
  try {
    const id = route.params.id
    const response = await getProduct(id)
    if (response && response.data) {
      product.value = response.data
    }
  } catch (error) {
    console.error('Failed to fetch product', error)
  } finally {
    loading.value = false
  }
})
</script>

<template>
  <main>
    <article class="product-container" v-if="product">
      <Navigation :productTitle="product.title" />

      <div class="content-wrapper">
        <section class="image-section">
          <ImageCard :imageUrl="product.url" />
          <ProfileCard :username="product.username" />
        </section>

        <section class="info-section">
          <ProductInfoCard :product="product" />
        </section>
      </div>
      <hr class="divider" />
    </article>
    <div v-else-if="loading">Loading...</div>
    <div v-else>Product not found</div>
  </main>
</template>

<style scoped>
/* --- 기본 레이아웃 --- */
main {
  padding-top: 20px;
  display: flex;
  justify-content: center;
}

article.product-container {
  width: 100%;
  max-width: 900px; /* PC화면 기준 적당한 너비 */
  padding: 0 16px;
  margin: 0 auto;
}

.content-wrapper {
  display: flex;
  flex-direction: column; /* 모바일: 세로 배치 */
  gap: 20px;
}

@media (min-width: 768px) {
  .content-wrapper {
    flex-direction: row; /* PC: 가로 배치 */
    gap: 40px;
  }

  .image-section {
    flex: 1;
    min-width: 0; /* flex overflow 방지 */
  }

  .info-section {
    flex: 1;
    min-width: 0;
  }
}

.image-section {
  overflow: hidden;
  flex-direction: row;
  background-color: #ffffff;
}

.divider {
  border: 0;
  height: 1px;
  background-color: #e9ecef;
  margin: 0 0 20px 0;
}

/* --- 상품 상세 내용 --- */
</style>
