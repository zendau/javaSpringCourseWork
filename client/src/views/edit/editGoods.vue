<template>

  <select @change="onChange" v-model="selectedItem">
    <option disabled value="" selected>Выберите один из товаров</option>
    <option v-for="item in goods" :key="item[0]" :value="item[0]">{{item[1]}}</option>
  </select>
  <AddItemForm v-if="itemData.length > 0" @updateFilter="formSubmit" :edit="true" :item-data="itemData"/>
  <p v-else>Для редактирования товара необходимо выбрать редактируемый товар</p>
<!--  <table class="table">-->
<!--    <thead>-->
<!--    <tr>-->
<!--      <th>№</th>-->
<!--      <th>Название товара</th>-->
<!--      <th>Категория</th>-->
<!--      <th>Изображение</th>-->
<!--      <th>Описание</th>-->
<!--      <th>Удаление записи</th>-->
<!--    </tr>-->
<!--    </thead>-->
<!--    <tbody>-->
<!--    <tr v-for="item in goods" :key="item[0]">-->
<!--      <td>{{item[0]}}</td>-->
<!--      <td><input type="text" v-model="item[1]"></td>-->
<!--      <td>-->
<!--        <select name="" id="" v-model="item[2]">-->
<!--          <option disabled value="" selected>Выберите категорию</option>-->
<!--          <option v-for="category in categories" :key="category">{{category}}</option>-->
<!--        </select>-->
<!--      </td>-->
<!--      <td><input type="file" ref="inputImage" placeholder="Изображение товара"></td>-->
<!--      <td><input type="text" v-model="item[4]"></td>-->
<!--      <td>-->
<!--        <router-link :to="'/delete/goods/'+item[0]">Удалить</router-link>-->
<!--      </td>-->
<!--    </tr>-->
<!--    </tbody>-->
<!--  </table>-->
<!--  <button @click="editData" class="btn btn-primary btn-mb">Сохранить</button>-->
</template>

<script>
import $api from "../../axios"

import AddItemForm from "../../components/AddItemForm"

export default {
  name: "editGoods",
  components: {
    AddItemForm
  },
  inject: ['update'],
  data() {
    return {
      categories: [],
      goods: [],
      selectedItem: "",
      itemData: [],
    }
  },
  methods: {
    async formSubmit(form) {

      const res = await $api.put("/goods/editGoods", form)

      if (res.data.errorCode) {
        this.update(true, 50)
      } else {
        await this.$router.push("/edit")
      }
    },
    onChange() {

      console.log(this.selectedItem)

      this.itemData = this.goods.filter(item => item[0] === this.selectedItem)[0]

      console.log(this.itemData)
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
  select, p {
    margin-top: 30px;
  }

</style>