import { ref } from 'vue'

const ACCESS_TOKEN_KEY = 'accessToken'
const USERNAME_KEY = 'username'

const accessToken = ref(localStorage.getItem(ACCESS_TOKEN_KEY))
const username = ref(localStorage.getItem(USERNAME_KEY))

export const useAuth = () => {
  const setAuth = ({ token, name }) => {
    accessToken.value = token
    username.value = name
    localStorage.setItem(ACCESS_TOKEN_KEY, token)
    localStorage.setItem(USERNAME_KEY, name)
  }

  const clearAuth = () => {
    accessToken.value = null
    username.value = null
    localStorage.removeItem(ACCESS_TOKEN_KEY)
    localStorage.removeItem(USERNAME_KEY)
  }

  return {
    accessToken,
    username,
    setAuth,
    clearAuth,
  }
}
