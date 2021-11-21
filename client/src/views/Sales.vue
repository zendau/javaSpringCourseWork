<template>
  <div>
    <h1>Продажи</h1>

    <input type="date" v-model="beforeDate">
    <input type="date" v-model="afterDate">

    <button class="btn btn-primary" @click="activeFilter">Применить фильтр</button>

    <table class="table table-striped">
      <tbody>
      <tr>
        <th>№</th>
        <th>Название товара</th>
        <th>Цена</th>
        <th>Дата получения</th>
        <th>Дата продажи</th>
        <th>Почта покупателя</th>
        <th>Кол-во</th>
        <th>Номер накладной</th>
      </tr>
      <tr v-for="(item, index) in items" :key="index">
        <td>{{item[0]}}</td>
        <td>{{item[1]}}</td>
        <td>{{new Intl.NumberFormat('ru-RU', { style: 'currency', currency: 'RUB' }).format(item[2])}}</td>
        <td>{{item[3]}}</td>
        <td>{{item[4]}}</td>
        <td>{{item[5]}}</td>
        <td>{{item[6]}}</td>
        <td>{{item[7]}}</td>
      </tr>
      </tbody>
    </table>
    <canvas id="myChart"></canvas>
  </div>
</template>

<script>
import $api from "../axios";
import {Chart, LineController, PointElement, LineElement, LinearScale, Title, BarController, CategoryScale, BarElement} from "chart.js";


export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Workers",
  data() {
    return {
      sales: [],
      items: [],
      afterDate: "",
      beforeDate: "",
      chart: null
    }
  },
  async mounted() {

    const resWorkers = await $api.get("/reverence/sales")
    this.sales = resWorkers.data

    this.items = this.sales

    this.paintChar()

  },
  provide: [],
  methods: {
    activeFilter() {

      if (this.beforeDate === "") {
        console.log("Поля со значениями 'До' должны быть выбраны")
      } else if (this.afterDate === "") {
        console.log("Поля со значениями 'После' должны быть выбраны")
      } else {

        const beforeDate = new Date(this.beforeDate)
        const afterDate = new Date(this.afterDate)

        if (beforeDate < afterDate) {
          this.items = this.sales.filter(date => {
            const tempDate = new Date(date[4])

            if (tempDate >= beforeDate && tempDate <= afterDate) {
              return tempDate
            }

          })

        } else {
          console.log("Введенная дата 'После' не должна быть меньше введенной даты 'До'")
        }

      }

          this.paintChar()
          console.log(this.beforeDate, this.afterDate)

    },
    paintChar() {

      if (this.chart !== null) {
        this.chart.destroy()
      }

      Chart.register(LineController, LineElement, PointElement, LinearScale, Title, BarController, CategoryScale, BarElement);

      console.log(this.items)

      const prices = []
      const dates = []

      this.items.forEach(item => {
        prices.push(item[2])
        dates.push(item[4])
      })

      const data = {
        labels: dates,
        datasets: [{
          label: 'My First dataset',
          backgroundColor: 'rgb(255, 99, 132)',
          borderColor: 'rgb(255, 99, 132)',
          data: prices,
        }]
      }

      const config = {
        type: 'line',
        data: data,
        options: {}
      }


      const ctx = document.getElementById('myChart').getContext('2d');

      this.chart = new Chart(
          ctx,
          config
      );
    }
  }
}
</script>

<style scoped>
  #myChart {
    width: 1000px!important;
    margin: 0 auto;
  }
</style>