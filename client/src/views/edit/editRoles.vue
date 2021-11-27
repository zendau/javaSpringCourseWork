<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Роль</th>
      <th>Описание</th>
      <th>Удаление записи</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in roles" :key="item[0]">
      <td>{{item[0]}}</td>
      <td><input type="text" v-model="item[1]" required></td>
      <td><input type="text" v-model="item[2]" required></td>
      <td>
        <router-link :to="'/delete/roles/'+item[0]">Удалить</router-link>
      </td>
    </tr>
    </tbody>
  </table>
  <button @click="editData" class="btn btn-primary btn-mb">Сохранить</button>
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
  inject: ['update'],
  methods: {
    async editData() {

      const res = await $api.put("/goods/editRoles", {
        param: this.roles
      })

      if (res.data.errorCode) {
        this.update(true, res.data.errorCode)
      } else {
        await this.$router.push("/edit")
      }


    }
  },
  async mounted() {
    const resRoles = await $api.get("/goods/roles")
    this.roles = resRoles.data


  }
}
</script>

<style scoped lang="scss">
</style>