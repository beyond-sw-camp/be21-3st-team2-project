<template>
  <div class="modal-overlay" @click.self="$emit('close')">
    <div class="write-card horizontal">
      <div class="modal-header">
        <h2 class="title">상품 등록</h2>
        <button class="close-btn" @click="$emit('close')">✕</button>
      </div>

      <div class="content-row">
        <!-- 왼쪽: 이미지 -->
        <div class="left-section">
          <div class="form-group">
            <label>상품 이미지</label>

            <label class="image-upload-box">
              <input
                type="file"
                accept="image/*"
                @change="handleImageUpload"
                hidden
              />

              <div v-if="imagePreview" class="image-preview">
                <img :src="imagePreview" />
                <button
                  type="button"
                  class="remove-img"
                  @click.prevent="removeImage"
                >
                  ✕
                </button>
              </div>

              <div v-else class="image-placeholder">
                <span>📷</span>
                <p>이미지 업로드</p>
                <small>1장만 가능</small>
              </div>
            </label>
          </div>
        </div>

        <!-- 오른쪽: 입력 폼 -->
        <div class="right-section">
          <!-- 제목 -->
          <div class="form-group">
            <label>제목</label>
            <div class="input-wrapper">
              <span class="icon">📝</span>
              <input v-model="title" placeholder="상품 제목을 입력하세요" />
            </div>
          </div>

          <!-- 가격 -->
          <div class="form-group">
            <label>가격</label>
            <div class="input-wrapper">
              <span class="icon">💰</span>
              <input
                type="number"
                v-model="price"
                placeholder="상품 가격을 입력하세요"
              />
            </div>
          </div>

          <!-- 카테고리 -->
          <div class="form-group">
            <label>카테고리</label>
            <select v-model="category">
              <option disabled value="">카테고리를 선택하세요</option>
              <option v-for="c in categories" :key="c">{{ c }}</option>
            </select>
          </div>

          <!-- 내용 -->
          <div class="form-group">
            <label>내용</label>
            <textarea
              v-model="content"
              rows="3"
              placeholder="상품 설명을 입력하세요"
            ></textarea>
          </div>

          <button class="submit-btn" @click="submitForm" :disabled="loading">
            {{ loading ? '등록 중...' : '등록 완료' }}
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { createProduct } from '../../api/product'

const emit = defineEmits(['close', 'refresh'])

const title = ref('')
const price = ref('')
const category = ref('')
const content = ref('')
const imageFile = ref(null)
const imagePreview = ref(null)
const loading = ref(false)

const categories = [
  '디지털기기',
  '생활가전',
  '주방/인테리어',
  '생활/주방',
  '기타',
]

const handleImageUpload = (event) => {
  const file = event.target.files[0]
  if (file) {
    imageFile.value = file
    imagePreview.value = URL.createObjectURL(file)
  }
}

const removeImage = () => {
  imageFile.value = null
  imagePreview.value = null
}

const submitForm = async () => {
  if (
    !title.value.trim() ||
    !price.value ||
    !category.value ||
    !content.value.trim()
  ) {
    alert('모든 항목을 입력해주세요.')
    return
  }

  if (!imageFile.value) {
    alert('상품 이미지를 1장 업로드해주세요.')
    return
  }

  loading.value = true

  // 백엔드 Enum 매핑
  const categoryMapping = {
    '디지털기기': 'DIGITAL',
    '생활가전': 'ELECTRONIC',
    '주방/인테리어': 'INTERIOR',
    '생활/주방': 'LIFE',
    '기타': 'ETC'
  }

  try {
    const formData = new FormData()
    const dto = {
      title: title.value,
      price: Number(price.value),
      category: categoryMapping[category.value] || 'ETC',
      description: content.value
    }

    formData.append('dto', new Blob([JSON.stringify(dto)], { type: 'application/json' }))
    formData.append('file', imageFile.value)

    await createProduct(formData)

    alert('상품이 등록되었습니다.')
    emit('refresh')
    emit('close')
  } catch (error) {
    console.error('Upload failed', error)
    alert('상품 등록에 실패했습니다.')
  } finally {
    loading.value = false
  }
}
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  inset: 0;
  background: rgba(0, 0, 0, 0.45);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.write-card.horizontal {
  width: 760px;
  max-width: 95vw;
  background-color: #ffffff;
  padding: 28px 24px;
  border-radius: 16px;
  box-shadow: 0 12px 30px rgba(0, 0, 0, 0.08);
  position: relative;
}

.modal-header {
  position: relative;
  text-align: center;
  margin-bottom: 30px;
}

.title {
  font-size: 2rem;
  font-weight: 700;
  color: #7e0270;
  margin: 0;
}

.close-btn {
  position: absolute;
  top: -10px;
  right: -10px;
  background: none;
  border: none;
  font-size: 1.5rem;
  cursor: pointer;
  color: #666;
}

/* 좌우 레이아웃 */
.content-row {
  display: grid;
  grid-template-columns: 240px 1fr;
  gap: 28px;
  margin-top: 20px;
}

/* 왼쪽 이미지 영역 */
.left-section .image-upload-box {
  width: 100%;
  aspect-ratio: 4 / 5;
  border: 2px dashed #7e0270;
  border-radius: 14px;
  background: #faf5fb;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
  position: relative;
}

.image-placeholder {
  text-align: center;
  color: #7e0270;
}

.image-placeholder span {
  font-size: 2.2rem;
}

/* 오른쪽 폼 */
.right-section {
  display: flex;
  flex-direction: column;
}

/* 폼 그룹 */
.form-group {
  margin-bottom: 18px;
}

label {
  display: block;
  margin-bottom: 8px;
  font-weight: 600;
  color: #333;
}

.input-wrapper {
  display: flex;
  align-items: center;
  border: 1px solid #ddd;
  border-radius: 10px;
  padding: 8px 12px;
  transition:
    border-color 0.25s,
    box-shadow 0.25s;
}

.input-wrapper:focus-within {
  border-color: #7e0270;
  box-shadow: 0 0 0 2px rgba(126, 2, 112, 0.15);
}

.icon {
  margin-right: 8px;
  color: #7e0270;
  font-size: 1.1rem;
}

input {
  border: none;
  outline: none;
  flex: 1;
  font-size: 1rem;
  color: #222;
  background-color: transparent;
}

/* select */
select {
  width: 100%;
  height: 44px;
  padding: 0 14px;
  border-radius: 12px;
  border: 1px solid #ddd;
  font-size: 0.95rem;
  color: #222;
  background-color: #fff;
  cursor: pointer;
}

select:focus {
  outline: none;
  border-color: #7e0270;
}

/* textarea */
textarea {
  width: 100%;
  border: 1px solid #ddd;
  border-radius: 10px;
  padding: 12px 14px;
  resize: none;
  font-size: 1rem;
  font-family: inherit;
  color: #222;
  outline: none;
  box-sizing: border-box;
}

textarea:focus {
  border-color: #7e0270;
}

/* 버튼 */
.submit-btn {
  margin-top: 24px;
  width: 100%;
  padding: 14px 0;
  border: none;
  border-radius: 12px;
  background-color: #7e0270;
  color: white;
  font-weight: 700;
  font-size: 1.05rem;
  cursor: pointer;
  transition: background-color 0.25s;
}

.submit-btn:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}

.submit-btn:hover:not(:disabled) {
  background-color: #66005b;
}

.image-preview {
  width: 100%;
  height: 100%;
  position: relative;
}

.image-preview img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.remove-img {
  position: absolute;
  top: 5px;
  right: 5px;
  background: rgba(0, 0, 0, 0.6);
  color: white;
  border: none;
  border-radius: 50%;
  width: 24px;
  height: 24px;
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 12px;
}
</style>
