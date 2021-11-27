<template>
  <table class="table">
    <thead>
    <tr>
      <th>№</th>
      <th>Имя поставщика</th>
      <th>Номер накладной</th>
      <th>Удаление записи</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in providerWaybills" :key="item[0]">
      <td>{{item[0]}}</td>
      <td>
        <select name="" id="" v-model="item[1]" required>
          <option disabled value="" selected>Выберите поставщика</option>
          <option v-for="provider in providers" :key="provider[0]" :value="provider[0]">{{provider[1] }}</option>
        </select>
      </td>
      <td>
        <select name="" id="" v-model="item[2]" required>
          <option disabled value="" selected>Выберите Накладную</option>
          <option v-for="waybill in waybills" :key="waybill[0]">{{waybill[0]}}</option>
        </select>
      </td>
      <td>
        <router-link :to="'/delete/providerwaybills/'+item[0]">Удалить</router-link>
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
      waybills: [],
      providerWaybills: []
    }
  },
  methods: {
    async editData() {

      const res = await  $api.put("/goods/editProviderWaybills", {
        param: this.providerWaybills
      })

      if (res.data.errorCode) {
        this.update(true, res.data.errorCode)
      } else {
        await this.$router.push("/edit")
      }

    }
  },
  async mounted() {
    const resProviderWaybills = await $api.get("/goods/providerWaybills")
    this.providerWaybills = resProviderWaybills.data

    const resProviders = await $api.get("/goods/providers")
    this.providers = resProviders.data

    const resWaybills = await $api.get("/goods/waybills")
    this.waybills = resWaybills.data
  }
}
</script>

<style scoped lang="scss">
</style>