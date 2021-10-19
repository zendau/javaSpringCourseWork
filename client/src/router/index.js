import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Reference from "../views/Reference";
import Workers from "../views/Workers";
import Sales from "../views/Sales";

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: "/reference",
    name: "Reference",
    component: Reference
  },
  {
    path: "/workers",
    name: "Workers",
    component: Workers
  },
  {
    path: "/sales",
    name: "Sales",
    component: Sales
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
