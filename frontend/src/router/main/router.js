export const mainRoutes = [
  {
    path: '/',
    redirect: '/goguma/main',
  },
  {
    path: '/goguma/main',
    name: 'Main',
    component: () => import('/src/pages/MainPage.vue'),
  },
]
