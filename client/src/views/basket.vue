<template>
  <h1>Корзина</h1>
  <div v-if="basketData.length > 0">
    <table class="table">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Товар</th>
        <th scope="col">Кол-во</th>
        <th scope="col">Цена</th>
        <th scope="col">Удалить</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(item, index) in basketData" :key="index">
        <th scope="row">{{index+1}}</th>
        <td><router-link :to="`/item/${item.itemData[0]}`">{{item.itemData[1]}}</router-link></td>
        <td>{{item.count}}</td>
        <td>{{getCurrency(item.itemData[5],item.count)}}</td>
        <td><button class="btn btn-primary" @click="confirmDelete(index)">Подтвердить удаление</button></td>
      </tr>
      </tbody>
    </table>
    <div class="confirm">
      <p>Итого к оплате: {{getPrice}}</p>
      <button class="btn btn-success" @click="buyBasket = true">Купить</button>
    </div>

    <buy-basket v-if="buyBasket" @closeModal="buyBasket = false" :items="basketData" :currency="totalPayable"/>
  </div>
  <div v-else>
    <h1>Корзина пуста</h1>
  </div>




</template>

<script>
import BuyBasket from "../components/BuyBasket";
export default {
  // eslint-disable-next-line vue/multi-word-component-names
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


    if (basket !== null || basket !== "") {
      this.basketData = JSON.parse(basket)
    }

    console.log(this.basketData)

  },
  methods: {
    getCurrency(currency, count) {
      return new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(currency * count)
    },
    confirmDelete(id) {


      this.basketData = this.basketData.filter((item, index) => {
        if (id !== index) return item
      })

      localStorage.setItem("basket", this.basketData)
    }
  },
  computed: {
    getPrice() {
      const price = this.basketData.reduce((accum, curr) => accum +=  curr.itemData[5] * curr.count, 0)
      return this.getCurrency(price, 1)
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