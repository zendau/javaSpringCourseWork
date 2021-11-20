<template>
  <div class="form-container">

    <form @submit.prevent="formSubmit">
      <div>
        <label for="name">Название товара</label>
        <input v-model="name" id="name" type="text" placeholder="Название товара">
      </div>

      <div>
        <label for="image">Изображение товара</label>
        <input v-model="image" id="image" type="text" placeholder="Изображение товара">
      </div>

      <select v-model="itemCategory">
        <option disabled value="" selected>Выберите одну из категорий</option>
        <option v-for="item in category" :key="item">{{item}}</option>
      </select>

      <textarea v-model="desk" placeholder="Описание" id="desk" cols="30" rows="10"></textarea>
      <input type="submit" value="Добавить товар" class="btn btn-primary">
    </form>
    


  </div>
</template>

<script>

 import $api from "../axios";

 export default {
   data() {
     return {
        name: "",
        itemCategory: "",
        image: "",
        desk: ""
     }
   },
   methods: {
    formSubmit() {
      $api.post("/goods/add", {
        name: this.name,
        category: this.itemCategory,
        image: this.image,
        description: this.desk
      })
    }
   },
   props: ["storage", "category"],
   mounted() {
     console.log(this.storage, this.category)
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
  }

  input, select {
    margin-bottom: 10px;
    margin-right: 10px;
    margin-left: 10px;
    padding: 5px;
  }

  select {
    grid-column: 1/3;
    width: 100%;
    margin: 0 0 10px;

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
