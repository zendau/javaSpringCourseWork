<template>
  <div class="hello">

    <form @submit.prevent="formSubmit">
      <div>
        <label for="name">Кодовое название товара</label>
        <input v-model="name" id="name" type="text" placeholder="Кодовое название товара">
      </div>

      <div>
        <label for="count">Количество</label>
        <input v-model="count" id="count" type="number" placeholder="Количество">
      </div>


      <div>
        <label for="numberOfWaybill">Номер накладной</label>
        <input v-model="numberOfWaybill" id="numberOfWaybill" type="text" placeholder="Номер накладной">
      </div>

      <div>
        <label for="arrivedDate">Дата получения</label>
        <input v-model="arrivedDate" id="arrivedDate" type="date">
      </div>

      <div>
        <label for="place">Место на складе</label>
        <input v-model="place" id="place" type="text" placeholder="Место на складе">
      </div>

      <div>
        <label for="price1">Цена при получении</label>
        <input v-model="price1" id="price1" type="number" placeholder="Цена при получении">
      </div>


      <div>
        <label for="price2">Цена для продажи</label>
        <input v-model="price2" id="price2" type="number" placeholder="Цена для продажи">
      </div>


      <select v-model="worker">
        <option disabled value="" selected>Выберите получателя товара</option>
        <option v-for="item in workers" :key="item">{{item}}</option>
      </select>

      <select v-model="provider">
        <option disabled value="" selected>Выберите поставшика товара</option>
        <option v-for="item in providers" :key="item">{{item}}</option>
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
       providers: [],
       worker: "",
       provider: ""
     }
   },
   methods: {
    formSubmit() {
      $api.post("/goods/add", {
        name: this.name,
        category: this.itemCategory,
        image: this.image,
        description: this.desk,
        storageId: this.storageId
      })

      console.log(this.name, this.itemCategory, this.image, this.desk, this.storageId)
    }
   },
   props: ["storage", "category"],
   mounted() {
     console.log(this.storage, this.category)
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

  div:nth-child(1) {
    grid-column: 1/3;

  }

  #name {
    width: 560px;
  }

  input[type="submit"] {
    margin-top: 15px;
    grid-column: 1/3;
    width: 200px;
    justify-self: center;
  }

</style>
