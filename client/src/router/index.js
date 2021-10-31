import { createRouter, createWebHistory } from 'vue-router'
import Reference from "../views/Reference";
import Workers from "../views/Workers";
import Sales from "../views/Sales";
import Item from "../views/Item";
import RegisterItem from "../views/RegisterItem";
import AddItem from "../views/AddItem";
import BookedItems from "../views/BookedItems";

const routes = [
  {
    path: '/',
    name: 'AddConfirmedItem',
    component: AddItem
  },
  {
    path: '/addItem',
    name: 'addItem',
    component: RegisterItem
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/All_items.vue')
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
  },
  {
    path: '/item/:id',
    name: 'Item',
    component: Item,
  },
  {
    path: '/BookedItems',
    name: 'BookedItems',
    component: BookedItems,
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
