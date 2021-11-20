<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Название категории</th>
      <th>Описание</th>
      <th>Удаление записи</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in categories" :key="item[0]">
      <td>{{item[0]}}</td>
      <td><input type="text" v-model="item[1]"></td>
      <td><input type="text" v-model="item[2]"></td>
      <td>
        <router-link :to="'/delete/categories/'+item[0]">Удалить</router-link>
      </td>
    </tr>

    </tbody>
  </table>
  <button @click="editData" class="btn btn-primary">Сохранить</button>
</template>

<script>
import $api from "../../axios";

export default {
  name: "editCategories",
  data() {
    return {
      categories: [],
    }
  },
  inject: ['update'],
  methods: {
    async editData() {

      const res = await $api.put("/goods/editCategories", {
        param: this.categories
      })

      this.update(true, res.data.errorCode)

    }
  },
  async mounted() {
    const resCategory = await $api.get("/goods/allCategories")
    this.categories = resCategory.data

    console.log(this.categories)

  }
}
</script>

<style scoped lang="scss">
</style>