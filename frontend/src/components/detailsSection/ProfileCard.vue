<script setup>
defineProps({
  username: {
    type: String,
    required: true,
  },
})
</script>

<template>
  <div class="profile-card">
    <div class="profile-left">
      <div class="profile-image">
        <img src="https://placehold.co/100x100?text=User" alt="프로필" />
      </div>
      <div class="profile-text">
        <span class="nickname">{{ username }}</span>
      </div>
    </div>
  </div>
</template>

<style scoped>
.profile-card {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  background-color: #ffffff;
}

.profile-left {
  display: flex;
  align-items: center;
  gap: 8px;
}

.profile-image img {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  object-fit: cover;
  background-color: #eee;
}

.profile-text {
  display: flex;
  flex-direction: column;
}

.nickname {
  font-weight: 600;
  font-size: 15px;
  color: #212529;
}
</style>
