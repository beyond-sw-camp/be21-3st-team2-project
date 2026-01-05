import { createRouter, createWebHistory } from 'vue-router'

import MainPage from '../pages/MainPage.vue'
import Details from '../pages/Details.vue'
import MarketListView from '../pages/MarketListView.vue'

const routes = [
  { path: '/', component: MainPage },
  { path: '/details/:id', component: Details },
  { path: '/market', component: MarketListView },
]

export default createRouter({
  history: createWebHistory(),
  routes: routes,
})
