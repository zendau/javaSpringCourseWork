<template>
  <div class="container">
    <h1>{{itemData[0]}}</h1>
    <small>{{itemData[1]}}</small>
    <img :src="'/img/'+itemData[2]" alt="Изображение товара">
    <p>{{itemData[3]}}</p>
    <p>{{getCurrency}}</p>
    <button @click="buyItem = true">Купить</button>
    <BuyItem v-if="buyItem" @closeModal="buyItem = false" :currency="getCurrency" />
  </div>
</template>

<script>
import $api from "../axios";
import BuyItem from "../components/BuyItem";

export default {
  name: "Item",
  components: {
    BuyItem
  },
  data() {
    return {
      itemData: [],
      buyItem: false
    }
  },
  computed: {
    getCurrency() {
      return new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(this.itemData[4])
    }
  },
  async mounted() {
    console.log()

    const resItemData = await $api.get("/goods/item",{
      params: {
        id: this.$route.params.id
      }
    })
    this.itemData = resItemData.data

    console.log(this.itemData)
  }
}
</script>

<style scoped>
  .container {
    width: 1000px;
    margin: 0 auto;
    display: grid;
    justify-items: center;
  }
  img {
    max-width: 400px;
  }
  p {
    font-size: 18px;
  }
</style>