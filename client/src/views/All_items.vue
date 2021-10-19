<template>
  <div class="container">
    <div class="item" v-for="item in items" :key="item[0]">
      <h2>{{item[1]}}</h2>
      <small>{{item[2]}}</small>
      <img :src="'/img/'+item[3]" alt="Изображение товара">
      <p>{{new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(item[4])}}</p>
      <RouterLink :to="'/item/'+item[0]">Купить</RouterLink>
    </div>
  </div>
</template>

<script>
  import $api from "../axios";

  export default {
    data() {
      return {
        items: []
      }
    },
    methods: {
      getImgUrl(pet) {
        const images = require.context('../assets/', false, /\.png$/)
        return images('./' + pet + ".png")
      }
    },
    async mounted() {
      const resStorage = await $api.get("/goods/all")
      this.items = resStorage.data

      console.log(this.items)
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
      box-shadow: 0px 0px 10px 0px rgba(34, 60, 80, 0.2);
      display: grid;
      justify-items: center;
      margin-bottom: 20px;
      padding: 10px;
    }

    img {
      height: 160px;
    }

</style>
