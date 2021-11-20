<template>
  <h1>Корзина</h1>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Товар</th>
      <th scope="col">Кол-во</th>
      <th scope="col">Цена</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(item, index) in basketData" :key="index">
      <th scope="row">1</th>
      <td><router-link :to="`/item/${item.itemData[0]}`">{{item.itemData[1]}}</router-link></td>
      <td>{{item.count}}</td>
      <td>{{getCurrency(item.itemData[5],item.count)}}</td>
    </tr>
    </tbody>
  </table>

  <div class="confirm">
    <p>Итого к оплате: {{getCurrency(totalPayable, 1)}}</p>
    <button class="btn btn-success" @click="buyBasket = true">Купить</button>
  </div>

  <buy-basket v-if="buyBasket" @closeModal="buyBasket = false" :items="basketData" :currency="totalPayable"/>

</template>

<script>
import BuyBasket from "../components/BuyBasket";
export default {
  name: "basket",
  components: {BuyBasket},
  data() {
    return {
      basketData: [],
      totalPayable: 0,
      buyBasket: false,
    }
  },
  mounted() {
    let basket = localStorage.getItem("basket")

    if (basket !== null) {
      this.basketData = JSON.parse(basket)
    }

    console.log(this.basketData)

    this.basketData.forEach(item => {
      this.totalPayable += item.itemData[5] * item.count
    })

  },
  methods: {
    getCurrency(currency, count) {
      return new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(currency * count)
    }
  }
}
</script>

<style scoped>

  h1 {
    margin-top: 10px;
    margin-bottom: 30px;
  }

  table {
    width: 1000px;
    margin: 0 auto;
  }

  .confirm {
    margin-top: 50px;
  }

</style>