<script setup>
defineProps({
  imageUrl: {
    type: String,
    required: false,
    default: '',
  },
})
</script>

<template>
  <div class="image-card">
    <img
      :src="imageUrl || 'https://placehold.co/600x600?text=No+Image'"
      alt="상품 이미지"
    />
  </div>
</template>

<style scoped>
.image-card img {
  width: 100%;
  height: auto;
  border-radius: 12px;
  aspect-ratio: 1/1; /* 정사각형 비율 유지 */
  object-fit: cover;
  display: block;
}
</style>
