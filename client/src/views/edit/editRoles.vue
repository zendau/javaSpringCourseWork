<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Роль</th>
      <th>Описание</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in roles" :key="item[0]">
      <td>{{item[0]}}</td>
      <td><input type="text" :value="item[1]"></td>
      <td><input type="text" :value="item[2]"></td>
    </tr>
    </tbody>
  </table>
  <button>Сохранить</button>
</template>

<script>
import $api from "../../axios";

export default {
  name: "editRoles",
  data() {
    return {
      roles: []
    }
  },
  async mounted() {
    const resRoles = await $api.get("/goods/roles")
    this.roles = resRoles.data


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