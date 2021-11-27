<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Дата создания</th>
      <th>Номер товара</th>
      <th>Кол-во</th>
      <th>Цена</th>
      <th>Карточка складского учета</th>
      <th>Номер накладной</th>
      <th>Номер кладовщика</th>
      <th>Удаление записи</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in waybills" :key="item[0]">
      <td>{{item[0]}}</td>
      <td><input type="date" v-model="item[1]" required></td>
      <td>
        <select name="" id="" v-model="item[2]" required>
          <option disabled value="" selected>Выберите номер товара</option>
          <option v-for="good in goods" :key="good[0]">{{good[0]}}</option>
        </select>
      </td>
      <td><input type="number"  v-model="item[3]" required></td>
      <td><input type="number" v-model="item[4]" required></td>
      <td>
        <select name="" id="" v-model="item[5]" required>
          <option disabled value="" selected>Выберите карточку складского учета</option>
          <option v-for="waybill in SCCs" :key="waybill[0]">{{waybill[0]}}</option>
        </select>
      </td>
      <td><input type="text" v-model="item[6]" required></td>
      <td>
        <select name="" id="" v-model="item[7]" required>
          <option disabled value="" selected>Выберите карточку складского учета</option>
          <option v-for="worker in workers" :key="worker[0]">{{worker[0]}}</option>
        </select>
      </td>
      <td>
        <router-link :to="'/delete/waybill/'+item[0]">Удалить</router-link>
      </td>
    </tr>
    </tbody>
  </table>
  <button @click="editData" class="btn btn-primary btn-mb">Сохранить</button>
</template>

<script>
import $api from "../../axios";

export default {
  name: "editWaybills",
  data() {
    return {
      waybills: [],
      workers: [],
      SCCs: [],
      goods: []
    }
  },
  methods: {
    async editData() {

      const res = await $api.put("/goods/editWaybills", {
        param: this.waybills
      })

      if (res.data.errorCode) {
        this.update(true, res.data.errorCode)
      } else {
        await this.$router.push("/edit")
      }

    }
  },
  async mounted() {
    const resWaybills = await $api.get("/goods/waybills")
    this.waybills = resWaybills.data

    const resWorkers = await $api.get("/goods/workers")
    this.workers = resWorkers.data

    const resSCCs = await $api.get("/goods/SCCs")
    this.SCCs = resSCCs.data

    const resGoods = await $api.get("/goods/items")
    this.goods = resGoods.data


  }
}
</script>

<style scoped lang="scss">
</style>