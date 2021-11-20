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
import login from "../views/login";
import Exit from "../views/Exit";
import basket from "../views/basket";

const routes = [
  {
    path: '/newItem',
    name: 'AddConfirmedItem',
    component: AddItem,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/addItem',
    name: 'addItem',
    component: RegisterItem,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/shop',
    name: 'Shop',
    component: All_items,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/reference",
    name: "Reference",
    component: Reference,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/workers",
    name: "Workers",
    component: Workers,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/sales",
    name: "Sales",
    component: Sales,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/item/:id',
    name: 'Item',
    component: Item,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/BookedItems',
    name: 'BookedItems',
    component: BookedItems,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/edit',
    name: 'Edit',
    component: Edit,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/add',
    name: 'Add',
    component: Add,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/addCategories',
    name: 'addCategories',
    component: addCategories,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/addRoles',
    name: 'addRoles',
    component: addRoles,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/addWorkers',
    name: 'addWorkers',
    component: addWorkers,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/editCategories',
    name: 'editCategories',
    component: editCategories,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/editGoods',
    name: 'editGoods',
    component: editGoods,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/editProviders',
    name: 'editProviders',
    component: editProviders,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/editRoles',
    name: 'editRoles',
    component: editRoles,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/editWorkers',
    name: 'editWorkers',
    component: editWorkers,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/editWaybills',
    name: 'editWaybills',
    component: editWaybills,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/editStorage',
    name: 'editStorage',
    component: editStorage,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/editSCC',
    name: 'editSCC',
    component: editSCC,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/delete/:type/:id",
    name: "Delete",
    component: Delete,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/login',
    name: 'Login',
    component: login,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/exit',
    name: 'Exit',
    component: Exit,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/basket",
    name: "Basket",
    component: basket,
    meta: {
      requiresAuth: false
    }
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  linkExactActiveClass: "active"
})

router.beforeEach((to, from, next) => {

  const auth = (localStorage.getItem("auth") === 'true')

  if (to.meta.requiresAuth && auth && to.fullPath !== "/") {
    next()
  } else {

    if (to.fullPath === "/") next("/shop")
    next()
  }

})

export default router
