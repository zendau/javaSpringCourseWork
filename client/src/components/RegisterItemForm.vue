<template>
  <div class="hello">

    <form @submit.prevent="formSubmit">
      <select v-model="name">
        <option disabled value="" selected>Выберите наименование товара</option>
        <option v-for="item in goods" :key="item" :value="item[0]">{{item[1]}}({{item[0]}})</option>
      </select>

      <div>
        <label for="count">Количество</label>
        <input v-model="count" id="count" type="number" placeholder="Количество" required>
      </div>


      <div>
        <label for="numberOfWaybill">Номер накладной</label>
        <input v-model="numberOfWaybill" id="numberOfWaybill" type="text" placeholder="Номер накладной" required>
      </div>

      <div>
        <label for="arrivedDate">Дата получения</label>
        <input v-model="arrivedDate" id="arrivedDate" type="date" required>
      </div>

      <div>
        <label for="place">Место на складе</label>
        <input v-model="place" id="place" type="text" placeholder="Место на складе" required>
      </div>

      <div>
        <label for="price1">Цена при получении</label>
        <input v-model="price1" id="price1" type="number" placeholder="Цена при получении" required>
      </div>


      <div>
        <label for="price2">Цена для продажи</label>
        <input v-model="price2" id="price2" type="number" placeholder="Цена для продажи" required>
      </div>

      <div>
        <label for="address">Адрес склада</label>
        <input v-model="address"  id="address" type="text" placeholder="Адрес склада" required>
      </div>

      <div>
        <label for="providerName">Имя поставщика</label>
        <input v-model="providerName"  id="providerName" type="text" placeholder="Имя поставщика" required>
      </div>

      <div>
        <label for="providerPhone">Номер поставщика</label>
        <input v-model="providerPhone"  id="providerPhone" type="text" placeholder="Номер поставщика" required>
      </div>

      <select v-model="worker">
        <option disabled value="" selected>Выберите получателя товара</option>
        <option v-for="item in workers" :key="item" :value="item[0]">{{item[1]}}({{item[0]}})</option>
      </select>

      <input type="submit" value="Зарегестрировать товар">
    </form>
    


  </div>
</template>

<script>

 import $api from "../axios";

 export default {
   data() {
     return {
       name: "",
       numberOfWaybill: "",
       count: 0,
       arrivedDate: "",
       place: "",
       price1: 0,
       price2: 0,
       workers: [],
       worker: "",
       providerName: "",
       providerPhone: "",
       goods: [],
       address: ""
     }
   },
   methods: {
    formSubmit() {
      $api.post("/goods/register", {
        name: parseInt(this.name),
        count: this.count,
        numberOfWaybill: this.numberOfWaybill,
        arrivedDate: this.arrivedDate,
        place: this.place,
        price1: this.price1,
        price2: this.price2,
        worker: this.worker,
        address: this.address,
        providerName: this.providerName,
        providerPhone: this.providerPhone,
      })
    }
   },
   props: ["storage", "category"],
   async mounted() {
     const resWorkers = await $api.get("/goods/workers")

     this.workers = resWorkers.data.filter(item => item[2] === "Кладовщик")

     const resGoods = await $api.get("/goods/items")
     this.goods = resGoods.data
   }
 }
</script>

<style lang="scss"  scoped>
  form {
    margin: 0 auto;
    display: grid;
    width: 800px;
    max-width: 800px;
    grid-template-columns: 1fr 1fr;

    div {
      display: flex;
      justify-items: center;
      width: 100%;
      justify-content: space-between;

    }

  }

  input, select {
    margin-bottom: 10px;
    margin-right: 10px;
    margin-left: 10px;
    padding: 5px;
    width: 200px;
  }

  select {
    width: 390px;
    margin: 0;
  }

  textarea {
    padding: 5px;
    margin-top: 10px;
    grid-column: 1/3;
    min-height: 300px;
    min-width: 800px;
    max-width: 800px;
  }

  select:nth-child(1) {
    grid-column: 1/3;
    width: 100%;
    margin-bottom: 10px;

  }

  #name {
    width: 560px;
  }

  .address {
    grid-column: 1/3;
    justify-content: center;
  }

  input[type="submit"] {
    margin-top: 15px;
    grid-column: 1/3;
    width: 200px;
    justify-self: center;
  }

</style>
