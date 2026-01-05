import http from './http'

export const registerApi = async ({ username, email, password }) => {
  return http.post('/api/v1/user/register', { username, email, password })
}

export const loginApi = async ({ email, password }) => {
  return http.post('/api/v1/auth/login', { email, password })
}

export const logoutApi = async () => {
  return http.post('/api/v1/auth/logout')
}

