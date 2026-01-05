import http from './http'

export const createProduct = async (formData) => {
  return http.post('/api/v1/products', formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  })
}

export const getProduct = async (id) => {
  return http.get(`/api/v1/products/${id}`)
}

export const searchProducts = async (title) => {
  return http.get('/api/v1/products/search', {
    params: { title },
  })
}

export const getRecentProducts = async () => {
  return http.get('/api/v1/products')
}
