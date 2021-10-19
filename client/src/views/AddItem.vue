<template>
  <div class="home">
    <HelloWorld :storage="storage" :category="categories"/>
  </div>
</template>

<script>

import HelloWorld from "../components/AddItemForm"
import $api from "../axios";

export default {
  data() {
    return {
      storage: [],
      categories: []
    }
  },
  methods: {

  },
  async mounted() {

    const resStorage = await $api.get("/goods/storage")
    this.storage = resStorage.data

    const resCategories = await $api.get("/goods/category")
    this.categories = resCategories.data
  },
  components: {
    HelloWorld
  }
}
</script>
