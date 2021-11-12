<template>
  <div class="container">
    <div v-if="itemData[6] > 0">
      <h1>{{itemData[1]}}</h1>
      <small>{{itemData[2]}}</small>
      <img :src="'/img/'+itemData[3]" alt="Изображение товара">
      <p>{{itemData[4]}}</p>
      <p>{{getCurrency}}</p>
      <button @click="buyItem = true">Купить</button>
      <BuyItem v-if="buyItem" @closeModal="buyItem = false" :item-id="itemData[0]" :count="itemData[6]" :currency="itemData[5]" />
    </div>
    <p v-else>Данного товара нет в наличии</p>
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
      return new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(this.itemData[5])
    },
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