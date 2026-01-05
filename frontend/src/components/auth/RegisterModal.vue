<script setup>
import { ref } from 'vue'
import * as yup from 'yup'
import { registerApi } from '../../api/auth'

const emit = defineEmits(['close', 'open-login'])

const username = ref('')
const email = ref('')
const password = ref('')
const error = ref('')
const loading = ref(false)

const schema = yup.object({
  username: yup
    .string()
    .trim()
    .required('이름은 필수입니다.'),
  email: yup
    .string()
    .trim()
    .email('유효한 이메일 형식이 아닙니다.')
    .matches(/^\S+$/, '이메일에 공백을 포함할 수 없습니다.')
    .required('이메일은 필수입니다.'),
  password: yup
    .string()
    .trim()
    .min(6, '비밀번호는 최소 6자 이상입니다.')
    .matches(/^\S+$/, '비밀번호에 공백을 포함할 수 없습니다.')
    .required('비밀번호는 필수입니다.')
})

const submit = async () => {
  error.value = ''
  loading.value = true

  try {
    await schema.validate({
      username: username.value,
      email: email.value,
      password: password.value
    })

    await registerApi({
      username: username.value.trim(),
      email: email.value.trim(),
      password: password.value.trim()
    })

    alert('회원가입에 성공했습니다. \n로그인해주세요.')
    emit('open-login')
  } catch (e) {
    error.value = e.message || '회원가입 실패'
  } finally {
    loading.value = false
  }
}
</script>

<template>
  <div class="auth-overlay" @click.self="emit('close')">
    <div class="auth-modal">
      <h2 class="auth-title">회원가입</h2>

      <input class="auth-input" placeholder="이름" v-model="username" />
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
        {{ loading ? '처리 중...' : '회원가입' }}
      </button>

      <p v-if="error" class="auth-error">{{ error }}</p>

      <p class="auth-switch">
        이미 계정이 있으신가요?
        <span @click="emit('open-login')">로그인</span>
      </p>
    </div>
  </div>
</template>

<style scoped>
@import './authModal.css';
</style>
