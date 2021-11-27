<template>
  <div class="form-container">
    <form @submit.prevent="formSubmit">
      <div>
        <label for="name">Имя поставщика</label>
        <input v-model="name" id="name" type="text" placeholder="Введите имя" required>
      </div>
      <div>
        <label for="hone">Номер</label>
        <input v-model="phone" id="hone" type="text" placeholder="Введите номер" required>
      </div>
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
      phone: "",
    }
  },
  inject: ['update'],
  methods: {
    async formSubmit() {
      const res = await $api.post("/goods/addProvider", {
        name: this.name,
        phone: this.phone,
      })

      if (res.data.errorCode) {
        this.update(true, res.data.errorCode)
      } else {
        await this.$router.push("/add")
      }

    }
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
}
label {
  display: inline-block;
  min-width: 200px;
}

div {
  grid-column: 1/3;
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