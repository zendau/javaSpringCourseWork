<template>
  <div>
    <p>Type - {{type}}</p>
    <p>id - {{id}}</p>
  </div>
</template>

<script>
export default {
  name: "Delete",
  data() {
    return {
      type: "",
      id: 0
    }
  },
  mounted() {

    this.type = this.$route.params.type
    this.id = this.$route.params.id
  }
}
</script>

<style scoped>

</style>