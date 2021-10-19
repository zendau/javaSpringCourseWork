<template>
  <div>
    <h1>Работники</h1>
    <table>
      <tbody>
      <tr>
        <th>№</th>
        <th>Имя сотрудника</th>
        <th>Долженность</th>
        <th>Дата рождения</th>
        <th>Номер телефона</th>
        <th>Адрес</th>
        <th>Зарплата</th>
      </tr>
      <tr v-for="item in workers" :key="item[0]">
        <td>{{item[0]}}</td>
        <td>{{item[1]}}</td>
        <td>{{item[2]}}</td>
        <td>{{item[3]}}</td>
        <td>{{item[4]}}</td>
        <td>{{item[5]}}</td>
        <td>{{new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(item[6])}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import $api from "../axios";

export default {
  name: "Workers",
  data() {
    return {
      workers: []
    }
  },
  async mounted() {

    const resWorkers = await $api.get("/reverence/workers")
    this.workers = resWorkers.data

  },
}
</script>

<style scoped>
table {
  width: 1000px;
  margin: 0 auto;
  font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
  font-size: 14px;
  border-collapse: collapse;
  text-align: center;
}
th, td:first-child {
  background: #AFCDE7;
  color: white;
  padding: 10px 20px;
}
th, td {
  border-style: solid;
  border-width: 0 1px 1px 0;
  border-color: white;
}
td {
  background: #D8E6F3;
}
th:first-child, td:first-child {
  text-align: left;
}
</style>