<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useAuth } from '../stores/auth'
import { logoutApi } from '../api/auth'

import LoginModal from './auth/LoginModal.vue'
import RegisterModal from './auth/RegisterModal.vue'

const router = useRouter()
const { accessToken, username, clearAuth } = useAuth()

const showLoginModal = ref(false)
const showRegisterModal = ref(false)



/* 로그인 모달 열기 */
const openLogin = () => {
  showLoginModal.value = true
}

/* 로그아웃 (확인 알림 포함) */
const logout = async () => {
  const ok = confirm('정말 로그아웃 하시겠습니까?')
  if (!ok) return

  try {
    await logoutApi(accessToken.value)
  } catch (e) {
    console.warn('로그아웃 API 에러 (무시)')
  } finally {
    clearAuth()
    alert('로그아웃 되었습니다.')
    router.push('/')
  }
}
</script>

<template>
  <nav class="header">
    <div class="header-content">
      <!-- 로고 -->
      <!-- 로고 -->
      <router-link to="/" class="logo">
        <img src="../assets/logo.svg" class="logo-img" />
        <span class="logo-text">고구마마켓</span>
      </router-link>

      <!-- 오른쪽 영역 -->
      <div class="header-right">
        <!-- 로그인 전 -->
        <button
          v-if="!accessToken"
          class="primary-btn"
          @click="openLogin"
        >
          로그인
        </button>

        <!-- 로그인 후 -->
        <div v-else class="user-box">
          <span class="username">{{ username }}</span>
          <button class="outline-btn" @click="logout">
            로그아웃
          </button>
        </div>
      </div>
    </div>
  </nav>

  <!-- 로그인 모달 -->
  <LoginModal
    v-if="showLoginModal"
    @close="showLoginModal = false"
    @open-register="() => {
      showLoginModal = false
      showRegisterModal = true
    }"
  />

  <!-- 회원가입 모달 -->
  <RegisterModal
    v-if="showRegisterModal"
    @close="showRegisterModal = false"
    @open-login="() => {
      showRegisterModal = false
      showLoginModal = true
    }"
  />
</template>

<style scoped>
/* ===== Header ===== */
.header {
  position: sticky;
  top: 0;
  background: #fff;
  border-bottom: 1px solid #e9ecef;
  z-index: 100;
}

.header-content {
  max-width: 1200px;
  height: 64px;
  margin: 0 auto;
  padding: 0 20px;

  display: flex;
  align-items: center;
  justify-content: space-between;
}

/* ===== Logo ===== */
.logo {
  display: flex;
  align-items: center;
  gap: 8px;
  cursor: pointer;
  text-decoration: none;
  color: inherit;
}

.logo-img {
  height: 40px;
}

.logo-text {
  font-size: 20px;
  font-weight: 700;
  color: #941da0;
}

/* ===== Right ===== */
.header-right {
  display: flex;
  align-items: center;
}

/* 버튼 공통 */
.primary-btn,
.outline-btn {
  height: 36px;
  padding: 0 16px;
  border-radius: 6px;
  font-weight: 700;
  font-size: 14px;

  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}

/* 로그인 버튼 */
.primary-btn {
  background: #941da0;
  color: #fff;
  border: none;
}

/* 로그인 후 영역 */
.user-box {
  display: flex;
  align-items: center;
  gap: 12px;
}

.username {
  font-size: 14px;
  font-weight: 600;
  color: #495057;
}

/* 로그아웃 버튼 */
.outline-btn {
  background: #fff;
  border: 1px solid #ced4da;
}
</style>
