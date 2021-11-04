<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Номер кладовщика</th>
      <th>Адрес</th>
      <th>Карточка складского учета</th>
      <th>Удаление записи</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in storages" :key="item[0]">
      <td>{{item[0]}}</td>
      <td>
        <select name="" id="" v-model="item[1]">
          <option disabled value="" selected>Выберите кладовщика</option>
          <option v-for="worker in workers" :key="worker[0]">{{worker[0]}}</option>
        </select>
      </td>
      <td><input type="text" v-model="item[2]"></td>
      <td>
        <select name="" id="" v-model="item[3]">
          <option disabled value="" selected>Выберите карточку складского учета</option>
          <option v-for="waybill in SCCs" :key="waybill[0]">{{waybill[0]}}</option>
        </select>
      </td>
      <td>
        <router-link :to="'/delete/storage/'+item[0]">Удалить</router-link>
      </td>
    </tr>
    </tbody>
  </table>
  <button @click="editData">Сохранить</button>
</template>

<script>
import $api from "../../axios";

export default {
  name: "editStorage",
  data() {
    return {
      storages: [],
      workers: [],
      SCCs: []
    }
  },
  methods: {
    editData() {

      $api.put("/goods/editStorage", {
        param: this.storages
      })

    }
  },
  async mounted() {
    const resStorages = await $api.get("/goods/allStorages")
    this.storages = resStorages.data

    const resWorkers = await $api.get("/goods/workers")
    this.workers = resWorkers.data

    const resSCCs = await $api.get("/goods/SCCs")
    this.SCCs = resSCCs.data


  }
}
</script>

<style scoped lang="scss">
table {
  width: 1000px;
  border: none;
  margin: 0 auto 20px;
  thead {
    th {
      font-weight: bold;
      border: none;
      padding: 10px 15px;
      background: #d8d8d8;
      font-size: 14px;
      border-left: 1px solid #ddd;
      border-right: 1px solid #ddd;
      text-align: center;
    }
  }
  tbody {
    tr:nth-child(even){
      background: #f3f3f3;
    }
    td {
      border-left: 1px solid #ddd;
      border-right: 1px solid #ddd;
      padding: 10px 15px;
      font-size: 14px;
      vertical-align: top;
      text-align: center;
    }
  }
  thead tr th:first-child, .table tbody tr td:first-child {
    border-left: none;
  }
  thead tr th:last-child, .table tbody tr td:last-child {
    border-right: none;
  }
}
</style>