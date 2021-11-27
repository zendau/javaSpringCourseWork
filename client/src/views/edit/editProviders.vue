<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Имя поставщика</th>
      <th>Номер телефона</th>
      <th>Удаление записи</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in providers" :key="item[0]">
      <td>{{item[0]}}</td>
      <td><input type="text" v-model="item[1]" required></td>
      <td><input type="text" v-model="item[2]" required></td>
      <td>
        <router-link :to="'/delete/providers/'+item[0]">Удалить</router-link>
      </td>
    </tr>
    </tbody>
  </table>
  <button @click="editData" class="btn btn-primary btn-mb">Сохранить</button>
</template>

<script>
import $api from "../../axios";

export default {
  name: "editProviders",
  data() {
    return {
      providers: [],
    }
  },
  methods: {
    async editData() {

      const res = await $api.put("/goods/editProviders", {
        param: this.providers
      })

      if (res.data.errorCode) {
        this.update(true, res.data.errorCode)
      } else {
        await this.$router.push("/edit")
      }

    }
  },
  async mounted() {
    const resProviders = await $api.get("/goods/providers")
    this.providers = resProviders.data
  }
}
</script>

<style scoped lang="scss">
</style>