<script setup>
defineProps({
  product: {
    type: Object,
    required: true,
  },
})
</script>

<template>
  <div class="product-detail">
    <h1 class="title">{{ product.title }}</h1>
    <div class="meta-info">
      <span class="category">{{ product.category }}</span>
      <!-- <time>1시간 전</time> Backend doesn't provide time yet, or need to format it -->
    </div>
    <div class="price">{{ Number(product.price).toLocaleString() }}원</div>

    <div class="description">
      <p>{{ product.description }}</p>
    </div>
  </div>
</template>

<style scoped>
.title {
  font-size: 20px;
  font-weight: 700;
  margin-bottom: 4px;
  line-height: 1.5;
}

.meta-info {
  font-size: 13px;
  color: #868e96;
  margin-bottom: 16px;
}

.price {
  font-size: 18px;
  font-weight: 700;
  margin-bottom: 16px;
}

.description {
  font-size: 16px;
  line-height: 1.6;
  margin-bottom: 24px;
  white-space: pre-line; /* 줄바꿈 적용 */
}

.counts {
  font-size: 13px;
  color: #868e96;
}
.counts span:not(:last-child)::after {
  content: '·';
  margin: 0 4px;
}
</style>
