<template>
  <div class="nav" v-if="getAuthStatus" >
    <router-link to="/newItem">Добавление товаров</router-link> |
    <router-link to="/addItem">Регистрация товара</router-link> |
    <router-link to="/add">Добавление</router-link> |
    <router-link to="/edit">Редактирование</router-link> |
    <router-link to="/BookedItems">Забронированные товары</router-link> |
    <router-link to="/shop">Просмотр товаров</router-link> |
    <router-link to="/reference">Справочные таблицы</router-link> |
    <router-link to="/exit">Выход</router-link>
  </div>
  <div class="nav" v-else>
    <router-link to="/shop">Просмотр товаров</router-link> |
    <router-link to="/login">Авторизация</router-link>
  </div>
  <router-view/>
  <error-message :error-code="errorCode" :status="errorStatus"  />
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

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
<script>
import ErrorMessage from "./components/errorMessage";
export default {
  components: {ErrorMessage},
  data() {
    return {
      errorStatus: false,
      errorCode: 0,
      auth: false
    }
  },
  provide() {
    return {
      update: this.updateError
    }
  },
  mounted() {
    this.$store.dispatch("checkStatus")
    this.auth = this.$store.state.auth
  },
  methods: {
    updateError(newStatus, code) {

      this.errorStatus = newStatus
      this.errorCode = code
    }
  },
  computed: {
    getAuthStatus() {
      console.log(this.$store.state.authStatus)
      return this.$store.state.authStatus
    }
  }
}
</script>