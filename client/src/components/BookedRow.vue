<template>
  <td>{{index+1}}</td>
  <td>{{item[2]}}</td>
  <td> <router-link :to="'/item/'+item[1]">{{item[1]}}</router-link></td>
  <td>{{item[3]}}</td>
  <td>{{item[4]}}</td>
  <td>{{item[5]}}</td>

  <td>
    <select name="" id="" v-model="selectedCourier">
      <option disabled value="" selected>Выберите курьера</option>
      <option v-for="courier in couriers" :key="courier" :value="courier[0]">{{courier[1]}}({{courier[0]}})</option>
    </select>
  </td>
  <td><button @click="updateData">Подтвердить</button></td>
  <td><button @click="cancelData">Отменить</button></td>
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
        const res = await $api.post("/goods/saleGoods", {
          courierId: this.selectedCourier,
          itemId: this.item[1],
          count: this.item[5],
          saleId: this.item[0],
          sccId: this.item[6]
        })
        if (res.data === 24) {
          this.update(true, 24)
        }
        //window.location.reload()
      }
    },
    async cancelData() {

      await $api.delete("/goods/delete", {
        data: {
          type: "sales",
          id:  this.item[0]
        }
      })

      window.location.reload()
    }
  }
}
</script>

<style scoped>
td {
  border-left: 1px solid #ddd;
  border-right: 1px solid #ddd;
  padding: 10px 15px;
  font-size: 14px;
  vertical-align: top;
  text-align: center;
}
</style>