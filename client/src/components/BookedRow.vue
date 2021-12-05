<template>
  <td>{{index+1}}</td>
  <td>{{item[0]}}</td>
  <td> <router-link :to="'/item/'+item[1]">{{item[1]}}</router-link></td>
  <td>{{item[2]}}</td>
  <td>{{item[3]}}</td>
  <td>{{item[4]}}</td>

  <td>
    <select name="" id="" v-model="selectedCourier">
      <option disabled value="" selected>Выберите курьера</option>
      <option v-for="courier in couriers" :key="courier" :value="courier[0]">{{courier[1]}}({{courier[0]}})</option>
    </select>
  </td>
  <td><button @click="updateData" class="btn btn-success">Подтвердить</button></td>
  <td><button @click="cancelData" class="btn btn-danger">Отменить</button></td>
</template>

<script>
import $api from "../axios";

export default {
  name: "BookedRow",
  props: ["item", "index", "couriers"],
  data() {
    return {
      selectedCourier: ""
    }
  },
  inject: ["update"],
  methods: {
    async updateData() {


      if (this.selectedCourier === "") {
        this.update(true, 12)
      } else {

        const obj = {
          courierId: this.selectedCourier,
          itemId: this.item[1],
          count: this.item[4],
          saleId: this.item[5]
        }


        console.log("test", obj)

        const res = await $api.post("/goods/saleGoods", obj)

        if (res.data === 24) {
          this.update(true, 24)
        }
        window.location.reload()
      }
    },
    async cancelData() {

      await $api.delete("/goods/delete", {
        data: {
          type: "sales",
          id:  this.item[5]
        }
      })

      window.location.reload()
    }
  }
}
</script>

<style scoped>
td {
  vertical-align: middle;
}
</style>