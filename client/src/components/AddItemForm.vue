<template>

    <form @submit.prevent="formSubmit" class="form-container">
      <div>
        <label for="name">Название товара</label>
        <input v-model="name" id="name" type="text" placeholder="Название товара" required>
      </div>

      <div>
        <label for="image">Изображение товара</label>
        <input id="image" ref="inputImage" type="file" placeholder="Изображение товара" required>
      </div>

      <select v-model="itemCategory" required>
        <option disabled value="" selected>Выберите одну из категорий</option>
        <option v-for="item in categories" :key="item">{{item}}</option>
      </select>

      <img v-if="edit" class="form-img" :src="'http://localhost:8080/'+image" alt="">

      <textarea v-model="desk" placeholder="Описание" id="desk" cols="30" rows="10" required></textarea>
      <input type="submit" :value="edit ? 'Изменить товар' : 'Добавить товар'" class="btn btn-primary">
      <router-link v-if="edit" :to="'/delete/goods/'+itemId" class="btn btn-primary">Удалить</router-link>
    </form>
</template>

<script>

 import $api from "../axios";

 export default {
   data() {
     return {
        name: "",
        itemCategory: "",
        desk: "",
        itemId: 0,
        categories: [],
        image: ""
     }
   },
   props: ["itemData", "edit"],
   methods: {
    formSubmit() {

      const form = new FormData();

      form.append("category", this.itemCategory)
      form.append("name", this.name)
      form.append("description", this.desk)
      form.append('file', this.$refs.inputImage.files[0])
      form.append("id", this.itemId)


      this.name = ""
      this.itemCategory = ""
      this.desk = ""
      this.image = ""

      this.$emit("updateFilter", form)

    }
   },
   async mounted() {

     const resCategories = await $api.get("/goods/category")
     this.categories = resCategories.data

     console.log(this.itemData)

   },
   watch: {
     itemData: {
       handler: function (newData) {

         if (newData !== undefined) {
           this.itemId = newData[0]
           this.name = newData[1]
           this.itemCategory = newData[2]
           this.image = this.itemData[3]
           this.desk = newData[4]
         }
       },
       immediate: true
     }
   }
 }
</script>

<style scoped>
  form {
    margin: 30px auto 0;
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

  .form-img {
    grid-column: 1/3;
    height: 300px;
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

  input[type="submit"], a {
    margin-top: 15px;
    grid-column: 1/3;
    width: 150px;
    justify-self: center;
  }

  a {
    margin-bottom: 30px;
  }

</style>
