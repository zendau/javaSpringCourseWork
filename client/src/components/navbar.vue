<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Виртуальный магазин</a>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0" v-if="getAuthStatus">
          <li class="nav-item">
            <router-link to="/newItem" class="nav-link">Добавление товаров</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/addItem" class="nav-link">Регистрация товара</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/add" class="nav-link">Добавление</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/edit" class="nav-link">Редактирование</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/BookedItems" class="nav-link">Забронированные товары</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/shop" class="nav-link">Просмотр товаров</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/basket" class="nav-link">Корзина</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/reference" class="nav-link">Справочные таблицы</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/exit" class="nav-link">Выход</router-link>
          </li>
        </ul>
        <ul class="navbar-nav me-auto mb-2 mb-lg-0" v-else>
          <li class="nav-item">
            <router-link to="/shop" class="nav-link">Просмотр товаров</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/basket" class="nav-link">Корзина</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/login" class="nav-link">Авторизация</router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: "navbarComponent",
  computed: {
    getAuthStatus() {
      return this.$store.state.authStatus
    }
  }
}
</script>

<style scoped lang="scss">
.nav {
  padding: 30px;

a {
  font-weight: bold;
  color: #2c3e50;

&.router-link-exact-active {
   color: #42b983;
 }
}
}
</style>