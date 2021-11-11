<template>
  <div>
    <ConfirmDelete/>
  </div>
</template>

<script>
import ConfirmDelete from "../components/confirmDelete";
export default {
  name: "Delete",
  components: {ConfirmDelete},
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