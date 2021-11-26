<template>
  <div class="container">
    <div v-if="itemData[6] > 0">
      <div class="item-container">
        <div class="wrapper">
          <h1>{{itemData[1]}}</h1>
          <img :src="'http://localhost:8080/'+itemData[3]" alt="Изображение товара">
        </div>
        <div class="wrapper">
          <p>Категория: {{itemData[2]}}</p>
          <p>Доступность: есть на складе</p>
          <p>Описание модели: {{itemData[4]}}</p>
          <p>Цена: {{getCurrency}}</p>
          <div>
            <label for="count">Количество: </label>
            <input id="count" required type="number" :max="itemData[6]" min="1"  v-model="countOfItems">
          </div>

          <button @click="addToBasket" class="btn btn-success">Добавить в корзину</button>
          <button @click="buyItem = true" class="btn btn-success">Купить в один клик</button>
        </div>
      </div>

      <BuyItem v-if="buyItem" @closeModal="buyItem = false" :item-id="itemData[0]" :count="itemData[6]" :currency="itemData[5]" />
    </div>
    <p v-else>Данного товара нет в наличии</p>
  </div>
</template>

<script>
import $api from "../axios";
import BuyItem from "../components/BuyItem";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Item",
  components: {
    BuyItem
  },
  data() {
    return {
      itemData: [],
      buyItem: false,
      countOfItems: 1
    }
  },
  computed: {
    getCurrency() {
      return new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(this.itemData[5])
    },
  },
  async mounted() {

    const resItemData = await $api.get("/goods/item",{
      params: {
        id: this.$route.params.id
      }
    })
    this.itemData = resItemData.data

  },
  methods: {
    addToBasket() {

      let basket = localStorage.getItem("basket")

      if (basket === null || basket === "") {
        basket = []
      } else {
        basket = JSON.parse(basket)
      }

      basket.push({
        itemData: this.itemData,
        count: this.countOfItems
      })


      localStorage.setItem("basket", JSON.stringify(basket))

    }
  }
}
</script>

<style scoped lang="scss">
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

  .item-container {
    display: flex;
    margin-top: 60px;
  }

  .wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;

    img {
      height: 400px;
    }

    &:nth-child(2) {
      padding-top: 70px;
      margin-left: 15px;
    }
  }


  .btn {
    margin-top: 15px;
    width: 200px;
  }

</style>