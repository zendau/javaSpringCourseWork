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
  <button @click="editData" class="btn btn-primary btn-mb">Сохранить</button>
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

</style>