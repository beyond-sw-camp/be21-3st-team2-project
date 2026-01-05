<template>
  <article class="card">
    <div class="card-photo">
      <img
        :src="item.url || 'https://placehold.co/400x400?text=No+Image'"
        alt="상품 이미지"
      />
    </div>

    <div class="card-desc">
      <h2 class="card-title">{{ item.title }}</h2>
      <div class="card-price">{{ formatPrice(item.price) }}원</div>
      <div class="card-region">
        <!-- Assuming region or counts might be added later, currently category as placeholder -->
        {{ item.category }}
      </div>
    </div>
  </article>
</template>

<script setup>
import { defineProps } from 'vue'

const props = defineProps({
  item: {
    type: Object,
    required: true,
  },
})

const formatPrice = (price) => {
  return price.toLocaleString()
}
</script>

<style scoped>
.card {
  display: flex;
  flex-direction: column;
  background-color: transparent;
  cursor: pointer;
}

/* 이미지 영역 */
.card-photo {
  width: 100%;
  padding-top: 100%; /* 1:1 Aspect Ratio */
  position: relative;
  border-radius: 12px;
  overflow: hidden;
  background-color: #f1f3f5;
  margin-bottom: 12px;
  border: 1px solid #edeef0;
}

.card-photo img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.2s ease-in-out;
}

.card:hover .card-photo img {
  transform: scale(1.05);
}

/* 텍스트 영역 */
.card-desc {
  display: flex;
  flex-direction: column;
  gap: 4px;
}

.card-title {
  font-size: 16px;
  font-weight: 400;
  color: #212529;
  line-height: 1.5;
  margin: 0;

  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;
}

.card-price {
  font-size: 15px;
  font-weight: 700;
  color: #941da0; /* Karrot Orange */
  margin-bottom: 4px;
}

.card-region {
  font-size: 13px;
  color: #868e96;
}
</style>
