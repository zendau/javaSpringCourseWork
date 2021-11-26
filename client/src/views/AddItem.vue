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
  methods: {
    formSubmit(form) {

      $api.post("/goods/add", form)

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
