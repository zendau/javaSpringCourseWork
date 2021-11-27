<template>

  <div class="filter">
    <p>Выберите категорию:</p>
    <select v-model="categoryId" class="form-select">
      <option value="all">Все категории</option>
      <option v-for="item in categories" :key="item">{{item}}</option>
    </select>
  </div>
  <div class="container" v-if="filterCategory.length > 0">

    <div class="card" style="width: 18rem;" v-for="item in filterCategory" :key="item[0]">
      <img :src="'http://localhost:8080/'+item[3]" class="card-img-top" alt="Изображение товара">
      <div class="card-body">
        <h5 class="card-title">{{item[1]}}</h5>
        <p class="card-text">{{item[2]}}</p>
        <p class="card-text">{{new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(item[4])}}</p>
        <RouterLink class="btn btn-primary" :to="'/item/'+item[0]">Купить</RouterLink>
      </div>
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

<style scoped lang="scss">

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

    .card {
      margin-top: 20px;
    }

    img {
      height: 160px;
    }

    .card-img-top {
      height: 160px;
      width: auto;
      justify-self: center;
      align-self: center;
      padding: 10px;
    }

    .filter {
      display: flex;
      margin: 0 auto;
      justify-content: center;
      align-items: center;

      margin: 30px 0;

      p {
        margin: 0 10px 0 0;
      }

    }

    .form-select {
      width: 250px;
    }

</style>
