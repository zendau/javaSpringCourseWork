<template>
  <div class="hello">
    <!--    @submit.prevent="formSubmit"-->
    <form>
      <div>
        <label for="name">Имя работника</label>
        <input id="name" type="text" placeholder="Имя работника">
      </div>
      <select name="" id="">
        <option disabled value="" selected>Выберите роль работника</option>
        <option v-for="role in roles" :key="role[0]">{{role[0]}}</option>
      </select>
      <div>
        <label for="birthday">День рождения</label>
        <input id="birthday" type="date" placeholder="День рождения">
      </div>
      <div>
        <label for="price">Номер телефона</label>
        <input id="price" type="number" placeholder="Номер телефона">
      </div>
      <div>
        <label for="address">Адрес</label>
        <input id="address" type="text" placeholder="Адрес">
      </div>
      <div>
        <label for="salary">Зарплата</label>
        <input id="salary" type="number" placeholder="Зарплата">
      </div>
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
      roles: []
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


    const resRoles = await $api.get("/goods/roles")
    this.roles = resRoles.data


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