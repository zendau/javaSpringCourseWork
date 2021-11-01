<template>
  <div class="hello">
    <!--    @submit.prevent="formSubmit"-->
    <form>
      <div>
        <label for="name">Имя поставщика</label>
        <input v-model="name" id="name" type="text" placeholder="Имя поставщика">
      </div>
      <div>
        <label for="phone">Номер телефона</label>
        <input v-model="name" id="phone" type="text" placeholder="Номер телефона">
      </div>
      <select name="" id="">
        <option disabled value="" selected>Выберите накладную</option>
        <option v-for="waybill in waybills" :key="waybill[0]">{{waybill[0]}}</option>
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
      waybills: []
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

    const resWaybills = await $api.get("/goods/waybills")
    this.waybills = resWaybills.data

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

select {
  grid-column: 1/3;
  justify-self: center;
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