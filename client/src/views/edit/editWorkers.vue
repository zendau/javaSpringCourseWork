<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Имя работника</th>
      <th>Роль</th>
      <th>День рождения</th>
      <th>Номер телефона</th>
      <th>Адрес</th>
      <th>Зарплата</th>
      <th>Удаление записи</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in workers" :key="item[0]">
      <td>{{item[0]}}</td>
      <td><input type="text" :value="item[1]"></td>
      <td>
        <select name="" id="" v-model="item[2]">
          <option disabled value="" selected>Выберите категорию</option>
          <option v-for="role in roles" :key="role[1]">{{role[1]}}</option>
        </select>
      </td>

      <td><input type="date" :value="item[3]"></td>
      <td><input type="text" :value="item[4]"></td>
      <td><input type="text" :value="item[5]"></td>
      <td><input type="number" :value="item[6]"></td>
      <td>
        <router-link :to="'/delete/workers/'+item[0]">Удалить</router-link>
      </td>
    </tr>
    </tbody>
  </table>
  <button>Сохранить</button>
</template>

<script>
import $api from "../../axios";

export default {
  name: "editWorkers",
  data() {
    return {
      roles: [],
      workers: []
    }
  },
  async mounted() {
    const resWorkers = await $api.get("/goods/workers")
    this.workers = resWorkers.data

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