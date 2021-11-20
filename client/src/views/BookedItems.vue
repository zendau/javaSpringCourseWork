<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Название товара</th>
      <th>Номер товара</th>
      <th>Дата продажи</th>
      <th>Почта покупателя</th>
      <th>Кол-во</th>
      <th>Курьер</th>
      <th>Подтвердить заказ</th>
      <th>Отменить заказ</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(item, index) in bookedItems" :key="item[0]">

      <BookedRow :index="index" :item="item" :couriers="couriers" />

<!--      <td>{{index+1}}</td>-->
<!--      <td>{{item[2]}}</td>-->
<!--      <td> <router-link :to="'/item/'+item[1]">{{item[1]}}</router-link></td>-->
<!--      <td>{{item[3]}}</td>-->
<!--      <td>{{item[4]}}</td>-->
<!--      <td>{{item[5]}}</td>-->

<!--      <td>-->
<!--        <select name="" id="" v-model="selectedCouriers[index]">-->
<!--          <option disabled value="" selected>Выберите курьера</option>-->
<!--          <option v-for="courier in couriers" :key="courier">{{courier[1]}}({{courier[0]}})</option>-->
<!--        </select>-->
<!--      </td>-->
<!--      <td><button @click="updateData">Подтвердить</button></td>-->
<!--      <td><button>Отменить</button></td>-->
    </tr>
    </tbody>
  </table>
</template>

<script>
import $api from "../axios";
import BookedRow from "../components/BookedRow";

export default {
  name: "BookedItems",
  components: {BookedRow},
  data() {
    return {
      couriers: [],
      bookedItems: [],
      selectedCouriers: []
    }
  },
  async mounted() {

    this.selectedCouriers.fill("Выберите курьера")

    const resCouriers = await $api.get("/goods/couriers")
    this.couriers = resCouriers.data

    const resBookedItems = await $api.get("/goods/BookedItems")
    this.bookedItems = resBookedItems.data

    console.log(this.couriers)
  }
}
</script>

<style scoped lang="scss">


</style>