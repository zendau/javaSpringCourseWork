<template>
  <div class="hello">
    <!--    @submit.prevent="formSubmit"-->
    <form>

      <select name="" id="">
        <option disabled value="" selected>Выберите карточку складского учета</option>
        <option v-for="SCC in SCCs" :key="SCC[0]">{{SCC[0]}}</option>
      </select>
      <select name="" id="">
        <option disabled value="" selected>Выберите кладовщика</option>
        <option v-for="worker in workers" :key="worker[0]">{{worker[0]}}</option>
      </select>
      <div>
        <label for="address">Адрес</label>
        <input id="address" type="text" placeholder="Адрес">
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
      SCCs: [],
      workers: []
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

    const resSCCs = await $api.get("/goods/SCCs")
    this.SCCs = resSCCs.data

    const resWorkers = await $api.get("/goods/workers")
    this.workers = resWorkers.data

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

div {
  grid-column: 1/3;
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