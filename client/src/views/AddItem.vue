<template>
  <div class="home">
    <AddItemForm @updateFilter="formSubmit"/>
  </div>
</template>

<script>

import AddItemForm from "../components/AddItemForm"
import $api from "../axios";

export default {
  data() {
    return {

    }
  },
  inject: ["update"],
  methods: {
    async formSubmit(form) {

      const res = await $api.post("/goods/add", form)

      if (res.data[0] === "error") {
        this.update(true, 56)
      } else {
        this.update(true, 57)
      }
    }

  },
  async mounted() {

    const resStorage = await $api.get("/goods/storage")
    this.storage = resStorage.data

    const resCategories = await $api.get("/goods/category")
    this.categories = resCategories.data
  },
  components: {
    AddItemForm
  }
}
</script>
