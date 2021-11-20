<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Имя поставщика</th>
      <th>Номер телефона</th>
      <th>Накладная</th>
      <th>Удаление записи</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in providers" :key="item[0]">
      <td>{{item[0]}}</td>
      <td><input type="text" v-model="item[1]"></td>
      <td><input type="text" v-model="item[2]"></td>
      <td>
        <select v-model="item[3]">
          <option disabled value="" selected>Выберите категорию</option>
          <option v-for="waybill in waybills" :key="waybill[0]">{{waybill[0]}}</option>
        </select>
      </td>
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
      waybills: []
    }
  },
  methods: {
    editData() {

      $api.put("/goods/editProviders", {
        param: this.providers
      })

    }
  },
  async mounted() {
    const resProviders = await $api.get("/goods/providers")
    this.providers = resProviders.data

    const resWaybills = await $api.get("/goods/waybills")
    this.waybills = resWaybills.data

    console.log(this.categories, this.storages, this.goods)

  }
}
</script>

<style scoped lang="scss">
</style>