<template>
  <div class="hello">
    <!--    @submit.prevent="formSubmit"-->
    <form>
      <div>
        <label for="price">Цена</label>
        <input v-model="name" id="price" type="text" placeholder="Цена">
      </div>
      <div>
        <label for="place">Место на складе</label>
        <input v-model="name" id="place" type="text" placeholder="Место на складе">
      </div>
      <div>
        <label for="dateA">Дата прибытия</label>
        <input v-model="name" id="dateA" type="date" placeholder="Дата прибытия">
      </div>
      <div>
        <label for="dateI">Дата выдачи</label>
        <input v-model="name" id="dateI" type="date" placeholder="Дата выдачи">
      </div>

      <textarea v-model="desk" placeholder="Описание" id="desk" cols="30" rows="10"></textarea>
      <input type="submit" value="Добавить">
    </form>

  </div>
</template>

<script>

//import $api from "../axios";

export default {
  data() {
    return {
      name: "",
      itemCategory: "",
      image: "",
      desk: "",
      storageId: ""
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
  mounted() {
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