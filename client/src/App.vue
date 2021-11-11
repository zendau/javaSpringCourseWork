<template>
  <div id="nav">
    <router-link to="/">Добавление товаров</router-link> |
    <router-link to="/addItem">Регистрация товара</router-link> |
    <router-link to="/add">Добавление</router-link> |
    <router-link to="/edit">Редактирование</router-link> |
    <router-link to="/BookedItems">Забронированные товары</router-link> |
    <router-link to="/about">Просмотр товаров</router-link> |
    <router-link to="/reference">Справочные таблицы</router-link>
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

#nav {
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
    }
  },
  provide() {
    return {
      update: this.updateError
    }
  },
  methods: {
    updateError(newStatus, code) {

      console.log(newStatus)

      this.errorStatus = newStatus
      this.errorCode = code
    }
  },
  watch: {
    errorStatus: function(val) {
      console.log("1",val)
    }
  }
}
</script>