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
  <button @click="editData">Сохранить</button>
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