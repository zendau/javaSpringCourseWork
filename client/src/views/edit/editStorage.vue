<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Номер кладовщика</th>
      <th>Карточка складского учета</th>
      <th>Номер предмета</th>
      <th>Удаление записи</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in storages" :key="item[0]">
      <td>{{item[0]}}</td>
      <td>
        <select name="" id="" v-model="item[1]" required>
          <option disabled value="" selected>Выберите кладовщика</option>
          <option v-for="worker in workers" :key="worker[0]">{{worker[0]}}</option>
        </select>
      </td>
      <td>
        <select name="" id="" v-model="item[2]" required>
          <option disabled value="" selected>Выберите карточку складского учета</option>
          <option v-for="waybill in SCCs" :key="waybill[0]">{{waybill[0]}}</option>
        </select>
      </td>
      <td>
        <select name="" id="" v-model="item[3]" required>
          <option disabled value="" selected>Выберите номер предмета</option>
          <option v-for="item in items" :key="item[0]">{{item[0]}}</option>
        </select>
      </td>
      <td>
        <router-link :to="'/delete/storage/'+item[0]">Удалить</router-link>
      </td>
    </tr>
    </tbody>
  </table>
  <button @click="editData" class="btn btn-primary btn-mb">Сохранить</button>
</template>

<script>
import $api from "../../axios";

export default {
  name: "editStorage",
  data() {
    return {
      storages: [],
      workers: [],
      SCCs: [],
      items: []
    }
  },
  methods: {
     async editData() {

       const res = await $api.put("/goods/editStorage", {
        param: this.storages
      })

       if (res.data.errorCode) {
         this.update(true, res.data.errorCode)
       } else {
         await this.$router.push("/edit")
       }

    }
  },
  async mounted() {
    const resStorages = await $api.get("/goods/allStorages")
    this.storages = resStorages.data

    const resWorkers = await $api.get("/goods/workers")
    this.workers = resWorkers.data

    const resSCCs = await $api.get("/goods/SCCs")
    this.SCCs = resSCCs.data

    const resItems = await $api.get("/goods/items")
    this.items = resItems.data

  }
}
</script>

<style scoped lang="scss">
</style>