<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Название товара</th>
      <th>Категория</th>
      <th>Изображение</th>
      <th>Описание</th>
      <th>Удаление записи</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in goods" :key="item[0]">
      <td>{{item[0]}}</td>
      <td><input type="text" v-model="item[1]"></td>
      <td>
        <select name="" id="" v-model="item[2]">
          <option disabled value="" selected>Выберите категорию</option>
          <option v-for="category in categories" :key="category">{{category}}</option>
        </select>
      </td>
      <td><input type="text" v-model="item[3]"></td>
      <td><input type="text" v-model="item[4]"></td>
      <td>
        <router-link :to="'/delete/goods/'+item[0]">Удалить</router-link>
      </td>
    </tr>
    </tbody>
  </table>
  <button @click="editData">Сохранить</button>
</template>

<script>
import $api from "../../axios";

export default {
  name: "editGoods",
  data() {
    return {
      categories: [],
      goods: []
    }
  },
  methods: {
    editData() {

      $api.put("/goods/editGoods", {
        param: this.goods
      })

    }
  },
  async mounted() {
    const resCategory = await $api.get("/goods/category")
    this.categories = resCategory.data

    const resGoods = await $api.get("/goods/items")
    this.goods = resGoods.data


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