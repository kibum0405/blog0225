import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/blogmanagements/blogs',
      component: () => import('../components/ui/BlogGrid.vue'),
    },
    {
      path: '/blogmanagements/blogReads',
      component: () => import('../components/BlogReadView.vue'),
    },
    {
      path: '/blogmanagements/blogReadModels',
      component: () => import('../components/BlogReadModelView.vue'),
    },
    {
      path: '/postmanagements/posts',
      component: () => import('../components/ui/PostGrid.vue'),
    },
  ],
})

export default router;
