<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Цена</th>
      <th>Дата прибытия</th>
      <th>Дата выдачи</th>
      <th>Место на складе</th>
      <th>Удаление записи</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in SCCs" :key="item[0]">
      <td>{{item[0]}}</td>
      <td><input type="number" v-model="item[1]"></td>
      <td><input type="date" v-model="item[2]"></td>
      <td><input type="date" v-model="item[3]"></td>
      <td><input type="text" v-model="item[4]"></td>
      <td>
        <router-link :to="'/delete/stockcontrolcard/'+item[0]">Удалить</router-link>
      </td>
    </tr>
    </tbody>
  </table>
  <button @click="editData">Сохранить</button>
</template>

<script>
import $api from "../../axios";

export default {
  name: "editSCC",
  data() {
    return {
      SCCs: []
    }
  },
  methods: {
    editData() {

      $api.put("/goods/editSCC", {
        param: this.SCCs
      })

    }
  },
  async mounted() {
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