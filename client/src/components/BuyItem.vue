<template>
  <div>
    <div class="overlay" @click="closeModal"></div>
    <form @submit.prevent="buyItem" class="container">
      <h1>Оформление покупки</h1>
      <div class="item-container">
        <label for="email">Введите ваш email</label>
        <input id="email" required type="email" v-model="email" placeholder="user@gmail.com">
      </div>
      <div class="item-container">
        <label for="count">Количество покупаемого товара</label>
        <input id="count" required type="number" :max="count" min="1"  v-model="countOfItems">
      </div>
      <p>Сумма к оплате - {{getCurrency}}</p>
      <button type="submit">Произвести покупку</button>
    </form>
  </div>
</template>

<script>
import $api from "../axios";

export default {
  name: "BuyItem",
  props: ["currency", "count", "itemId"],
  methods: {
    closeModal() {
      this.$emit("closeModal")
    },
    async buyItem() {

      await $api.post("/goods/buyGoods", {
        itemId: this.itemId,
        mailOfBuyer: this.email,
        count: this.countOfItems
      })
      this.closeModal()
    }
  },
  data() {
    return {
      countOfItems: 1,
      email: ""
    }
  },
  computed: {
    getCurrency() {
      console.log(parseInt(this.currency), this.countOfItems)
      return new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(this.currency * this.countOfItems)
    }
  }
}
</script>

<style lang="scss" scoped>
.overlay {
  width: 100%;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  background-color: gray;
  opacity: .3;
}
.container {
  position: fixed;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -40%);
  z-index: 200;
  height: 350px;
  background-color: #EED6C4;
  width: 600px;
  box-shadow: 0px 0px 8px 0px rgba(34, 60, 80, 0.2);
  display: flex;
  flex-direction: column;
  align-items: center;
}
h1 {
  color: black;
  z-index: 100;
  font-size: 40px;
}
button {


  border: none;
  border-radius: 6px;
  width: 200px;
  height: 40px;
  font-size: 18px;
  cursor: pointer;
  margin: 50px 0 15px;
  background-color: #E26A2C;
  color: #fff;
  padding: 5px;
  transition: .5s;
  &:hover {
    background-color: #C36A2D;
  }
}

.item-container {
  p, input {
    font-size: 18px;
  }

  input {
    padding: 5px;
  }

  width: 90%;

  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}

</style>