<template>
  <div class="form-container">
    <form @submit.prevent="formSubmit">
      <div>
        <label for="name">Название Категории</label>
        <input v-model="name" id="name" type="text" placeholder="Введите название" required>
      </div>
      <textarea v-model="desk" placeholder="Описание" id="desk" cols="30" rows="10" required></textarea>
      <input type="submit" value="Добавить" class="btn btn-primary">
    </form>

  </div>
</template>

<script>

import $api from "../../axios";

export default {
  data() {
    return {
      name: "",
      desk: "",
    }
  },
  inject: ['update'],
  methods: {
    async formSubmit() {
      const res = await $api.post("/goods/addCategories", {
        name: this.name,
        description: this.desk,
      })

      if (res.data.errorCode) {
        this.update(true, res.data.errorCode)
      } else {
        await this.$router.push("/add")
      }



    },

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

div {
  grid-column: 1/3;
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