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
      <td><input type="text" v-model="item[1]"></td>
      <td>
        <select v-model="item[2]">
          <option disabled  selected>Выберите категорию</option>
          <option v-for="role in roles" :key="role[1]">{{role[1]}}</option>
        </select>
      </td>

      <td><input type="date" v-model="item[3]"></td>
      <td><input type="text" v-model="item[4]"></td>
      <td><input type="text" v-model="item[5]"></td>
      <td><input type="number" v-model="item[6]"></td>
      <td>
        <router-link :to="'/delete/workers/'+item[0]">Удалить</router-link>
      </td>
    </tr>
    </tbody>
  </table>
  <button @click="editData" class="btn btn-primary btn-mb">Сохранить</button>
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
  methods: {
    editData() {

      $api.put("/goods/editWorkers", {
        param: this.workers
      })

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
</style>