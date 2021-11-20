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
  <button @click="editData" class="btn btn-primary btn-mb">Сохранить</button>
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
</style>