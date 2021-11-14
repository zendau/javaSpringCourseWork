<template>
  <div></div>
</template>

<script>
export default {
  name: "Exit",
  mounted() {
    localStorage.setItem("auth", "false")
    this.$store.dispatch("checkStatus")
    this.$router.push("/shop")
  }
}
</script>

<style scoped>

</style>