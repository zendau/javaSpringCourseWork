<template>
  <div>
    <h1>Продажи</h1>
    <table>
      <tbody>
      <tr>
        <th>№</th>
        <th>Название товара</th>
        <th>Цена</th>
        <th>Дата получения</th>
        <th>Дата продажи</th>
        <th>Почта покупателя</th>
        <th>Номер накладной</th>
      </tr>
      <tr v-for="item in sales" :key="item[0]">
        <td>{{item[0]}}</td>
        <td>{{item[1]}}</td>
        <td>{{new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(item[2])}}</td>
        <td>{{item[3]}}</td>
        <td>{{item[4]}}</td>
        <td>{{item[5]}}</td>
        <td>{{item[6]}}</td>
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
      sales: []
    }
  },
  async mounted() {

    const resWorkers = await $api.get("/reverence/sales")
    this.sales = resWorkers.data

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