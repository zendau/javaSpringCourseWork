<template>

  <form @submit.prevent="onSubmit">
    <div class="mb-3">
      <label for="login" class="form-label">Логин</label>
      <input type="text" class="form-control" id="login" v-model="login" required aria-describedby="loginHelp">
      <div id="loginHelp" class="form-text">Логин выданный администатором виртуального магазина</div>
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">Пароль</label>
      <input type="password" class="form-control" id="password" aria-describedby="passHelp" v-model="password">
      <div id="passHelp" class="form-text">Пароль выданный администатором виртуального магазина</div>
    </div>
    <button type="submit" class="btn btn-primary">Войти</button>
  </form>

</template>

<script>

export default {
  name: "login",
  data() {
    return {
      login: "",
      password: ""
    }
  },
  inject: ['update'],
  methods: {
    onSubmit() {
      this.$store.dispatch("updateStatus", {
        login: this.login,
        password: this.password
      }).then(() => {

        const errorCode = this.$store.state.errorCode
        
        if (errorCode !== 0) {
          this.update(true, errorCode)
          this.$store.commit("updateErrorCode", 0)
        } else {
          this.$router.push("/shop")
        }
      })
    }
  }
}
</script>

<style scoped>
  form {
    width: 600px;
    margin: 100px auto 0;
  }

  .mb-3 {
    display: grid;
    justify-items: baseline;
  }

</style>