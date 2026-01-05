/* eslint-env node */
module.exports = {
  root: true,
  env: {
    browser: true,
    es2021: true,
    node: true,
  },
  extends: [
    'eslint:recommended',
    'plugin:vue/vue3-recommended',
    'plugin:prettier/recommended',
  ],
  // 여기가 핵심입니다!
  parser: 'vue-eslint-parser', // .vue 파일을 해석하는 메인 파서
  parserOptions: {
    parser: '@babel/eslint-parser', // <script> 태그 내부를 해석하는 파서
    sourceType: 'module',
    ecmaVersion: 'latest',
    requireConfigFile: false, // <--- [중요] 설정 파일 없어도 에러 내지 말라는 옵션
    babelOptions: {
      parserOpts: {
        plugins: ['jsx'],
      },
    },
  },
  rules: {
    'prettier/prettier': [
      'error',
      {
        endOfLine: 'auto',
      },
    ],
    // 컴포넌트 이름 한 단어("Details" 등)로 썼을 때 에러 무시
    'vue/multi-word-component-names': 'off',
  },
}
