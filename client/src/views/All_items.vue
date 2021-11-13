<template>
  <select v-model="categoryId">
    <option value="all">Все категории</option>
    <option v-for="item in categories" :key="item">{{item}}</option>
  </select>
  <div class="container" v-if="filterCategory.length > 0">
    <div  class="item" v-for="item in filterCategory" :key="item[0]">
      <h2>{{item[1]}}</h2>
      <small>{{item[2]}}</small>
      <img :src="'/img/'+item[3]" alt="Изображение товара">
      <p>{{new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(item[4])}}</p>
      <RouterLink :to="'/item/'+item[0]">Купить</RouterLink>
    </div>
  </div>
  <p v-else>Товаров не найдено</p>
</template>

<script>
  import $api from "../axios";

  export default {
    data() {
      return {
        items: [],
        filterItems: [],
        categories: [],
        categoryId: "all"
      }
    },
    methods: {
    },
    computed: {
      filterCategory: function () {

        if (this.categoryId === "all") {
          return this.items
        } else {
          return this.items.filter(item => item[2] === this.categoryId)
        }
      }
    },
    async mounted() {

      const resCategories = await $api.get("/goods/category")
      this.categories = resCategories.data

      const resStorage = await $api.get("/goods/all")
      this.items = resStorage.data

    }
  }

</script>

<style scoped>

    .container {
      display: grid;
      grid-template-columns: 1fr 1fr 1fr;
      width: 1000px;
      margin: 0 auto;
    }

    .item {
      width: 300px;
      box-shadow: 0 0 10px 0 rgba(34, 60, 80, 0.2);
      display: grid;
      justify-items: center;
      margin-bottom: 20px;
      padding: 10px;
    }

    img {
      height: 160px;
    }

</style>
