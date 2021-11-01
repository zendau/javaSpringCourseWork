<template>
  <div class="hello">
    <!--    @submit.prevent="formSubmit"-->
    <form>
      <div>
        <label for="date">Дата создания</label>
        <input id="date" type="date" placeholder="Дата создания">
      </div>
      <div>
        <label for="count">Кол-во</label>
        <input id="count" type="number" placeholder="Кол-во">
      </div>
      <div>
        <label for="price">Цена</label>
        <input id="price" type="number" placeholder="Цена">
      </div>
      <div>
        <label for="waybillName">Номер накладной</label>
        <input id="waybillName" type="text" placeholder="Номер накладной">
      </div>
      <select name="" id="">
        <option disabled value="" selected>Выберите номер товара</option>
        <option v-for="good in goods" :key="good[0]">{{good[0]}}</option>
      </select>
      <select name="" id="">
        <option disabled value="" selected>Выберите карточку складского учета</option>
        <option v-for="SCC in SCCs" :key="SCC[0]">{{SCC[0]}}</option>
      </select>
      <select name="" id="">
        <option disabled value="" selected>Выберите кладовщика</option>
        <option v-for="worker in workers" :key="worker[0]">{{worker[0]}}</option>
      </select>
      <input type="submit" value="Добавить">
    </form>

  </div>
</template>

<script>

//import $api from "../axios";

import $api from "../../axios";

export default {
  data() {
    return {
      SCCs: [],
      workers: [],
      goods: []
    }
  },
  methods: {
    // formSubmit() {
    //   $api.post("/goods/add", {
    //     name: this.name,
    //     category: this.itemCategory,
    //     image: this.image,
    //     description: this.desk,
    //     storageId: this.storageId
    //   })
    //
    //   console.log(this.name, this.itemCategory, this.image, this.desk, this.storageId)
    // }
  },
  async mounted() {

    const resWorkers = await $api.get("/goods/workers")
    this.workers = resWorkers.data

    const resSCCs = await $api.get("/goods/SCCs")
    this.SCCs = resSCCs.data

    const resGoods = await $api.get("/goods/items")
    this.goods = resGoods.data

  }
}
</script>

<style scoped>
form {
  margin: 0 auto;
  display: grid;
  width: 800px;
  max-width: 800px;
  grid-template-columns: 1fr 1fr;
  justify-items: baseline;
}
label {
  display: inline-block;
  min-width: 200px;
}

input, select {
  margin-bottom: 10px;
  margin-right: 10px;
  margin-left: 10px;
  padding: 5px;
  width: 170px;
}

select {
  justify-self: center;
}

textarea {
  padding: 5px;
  margin-top: 10px;
  grid-column: 1/3;
  min-height: 300px;
  min-width: 800px;
  max-width: 800px;
}

input[type="submit"] {
  margin-top: 15px;
  grid-column: 1/3;
  width: 150px;
  justify-self: center;
}

</style>