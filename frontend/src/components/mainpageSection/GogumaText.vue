<script setup>
import { ref, onMounted } from 'vue'

const texts = ['의류', '상품권', '노트북']
const rotatingText = ref(texts[0])
const textIndex = ref(0)

onMounted(() => {
  setInterval(() => {
    textIndex.value = (textIndex.value + 1) % texts.length
    rotatingText.value = texts[textIndex.value]
  }, 2000)
})
</script>

<template>
  <section class="hero">
    <h2>
      고구마에서<br />

      <transition name="fade" mode="out-in">
        <span
          :key="rotatingText"
          class="highlight"
        >
          {{ rotatingText }}
        </span>
      </transition>

      찾고 계신가요?
    </h2>
  </section>
</template>

<style scoped>
.hero {
  text-align: center;
  margin-bottom: 24px;
}

.hero h2 {
  font-size: 28px;
  font-weight: bold;
  line-height: 1.3;
}

.highlight {
  color: #941da0;
  display: inline-block;
}

/* Vue transition */
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.35s ease, transform 0.35s ease;
}

.fade-enter-from {
  opacity: 0;
  transform: translateY(6px);
}

.fade-leave-to {
  opacity: 0;
  transform: translateY(-6px);
}
</style>
