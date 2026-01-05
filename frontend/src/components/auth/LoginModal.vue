<script setup>
import { ref } from 'vue'
import * as yup from 'yup'
import { loginApi } from '../../api/auth'
import { useAuth } from '../../stores/auth'

const emit = defineEmits(['close', 'open-register'])

const email = ref('')
const password = ref('')
const error = ref('')
const loading = ref(false)

const { setAuth } = useAuth()

const schema = yup.object({
  email: yup
    .string()
    .trim()
    .email('유효한 이메일 형식이 아닙니다.')
    .matches(/^\S+$/, '이메일에 공백을 포함할 수 없습니다.')
    .required('이메일은 필수입니다.'),
  password: yup
    .string()
    .trim()
    .matches(/^\S+$/, '비밀번호에 공백을 포함할 수 없습니다.')
    .required('비밀번호는 필수입니다.')
})

const submit = async () => {
  error.value = ''
  loading.value = true

  try {
    await schema.validate({
      email: email.value,
      password: password.value
    })

    const res = await loginApi({
      email: email.value.trim(),
      password: password.value.trim()
    })

    setAuth({
      token: res.data.accessToken,
      name: res.data.username
    })

    emit('close')
  } catch (e) {
    error.value = e.message || '로그인 실패'
  } finally {
    loading.value = false
  }
}
</script>

<template>
  <div class="auth-overlay" @click.self="emit('close')">
    <div class="auth-modal">
      <h2 class="auth-title">로그인</h2>

      <input class="auth-input" placeholder="이메일" v-model="email" />
      <input
        class="auth-input"
        type="password"
        placeholder="비밀번호"
        v-model="password"
      />

      <button
        type="button"
        class="auth-btn"
        :disabled="loading"
        @click="submit"
      >
        {{ loading ? '로그인 중...' : '로그인' }}
      </button>

      <p v-if="error" class="auth-error">{{ error }}</p>

      <p class="auth-switch">
        아직 회원이 아니신가요?
        <span @click="emit('open-register')">회원가입</span>
      </p>
    </div>
  </div>
</template>

<style scoped>
@import './authModal.css';
</style>
