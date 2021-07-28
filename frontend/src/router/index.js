import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'layout',
      component: () => import('@/views/layout/Layout')
    },
    {
      path: '/notice',
      name: 'notice',
      component: () => import('@/views/notice/index')
    },
    {
      path: '/codeList',
      name: 'codeList',
      component: () => import('@/views/code/codeList')
    }
  ]
})
