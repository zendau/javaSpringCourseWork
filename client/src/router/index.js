import { createRouter, createWebHistory } from 'vue-router'
import Reference from "../views/Reference";
import Workers from "../views/Workers";
import Sales from "../views/Sales";
import Item from "../views/Item";
import RegisterItem from "../views/RegisterItem";
import AddItem from "../views/AddItem";
import BookedItems from "../views/BookedItems";
import Edit from "../views/Edit";
import Add from "../views/Add";
import addCategories from "../views/add/addCategories";
import addRoles from "../views/add/addRoles";
import addWorkers from "../views/add/addWorkers";
import editCategories from "../views/edit/editCategories";
import editGoods from "../views/edit/editGoods";
import editProviders from "../views/edit/editProviders";
import editRoles from "../views/edit/editRoles";
import editWorkers from "../views/edit/editWorkers";
import editWaybills from "../views/edit/editWaybills";
import editStorage from "../views/edit/editStorage";
import editSCC from "../views/edit/editSCC";
import Delete from "../views/Delete";
import All_items from "../views/All_items";

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
    path: '/shop',
    name: 'Shop',
    component: All_items
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
  {
    path: '/edit',
    name: 'Edit',
    component: Edit,
  },
  {
    path: '/add',
    name: 'Add',
    component: Add,
  },
  {
    path: '/addCategories',
    name: 'addCategories',
    component: addCategories,
  },
  {
    path: '/addRoles',
    name: 'addRoles',
    component: addRoles,
  },
  {
    path: '/addWorkers',
    name: 'addWorkers',
    component: addWorkers,
  },
  {
    path: '/editCategories',
    name: 'editCategories',
    component: editCategories
  },
  {
    path: '/editGoods',
    name: 'editGoods',
    component: editGoods,
  },
  {
    path: '/editProviders',
    name: 'editProviders',
    component: editProviders,
  },
  {
    path: '/editRoles',
    name: 'editRoles',
    component: editRoles,
  },
  {
    path: '/editWorkers',
    name: 'editWorkers',
    component: editWorkers,
  },
  {
    path: '/editWaybills',
    name: 'editWaybills',
    component: editWaybills,
  },
  {
    path: '/editStorage',
    name: 'editStorage',
    component: editStorage,
  },
  {
    path: '/editSCC',
    name: 'editSCC',
    component: editSCC,
  },
  {
    path: "/delete/:type/:id",
    name: "Delete",
    component: Delete
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
