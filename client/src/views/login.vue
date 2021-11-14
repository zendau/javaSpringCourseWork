<template>
  <form @submit.prevent="onSubmit">
    <label for="login">Логин</label>
    <input required type="text" id="login" v-model="login">
    <label for="password">Пароль</label>
    <input required type="password" id="password" v-model="password">
    <input type="submit">
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
  methods: {
    async onSubmit() {
      this.$store.dispatch("updateStatus", {
        login: this.login,
        password: this.password
      })
      this.$router.push("/shop")

    }
  }
}
</script>

<style scoped>

</style>