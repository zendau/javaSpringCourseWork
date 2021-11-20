<template>
  <div class="form-container">
    <form @submit.prevent="formSubmit">
      <div>
        <label for="name">Имя работника</label>
        <input id="name" type="text" placeholder="Имя работника" v-model="name">
      </div>
      <div>
        <p>Работник:</p>
        <select name="" id="" v-model="role">
          <option disabled value="" selected>Выберите роль работника</option>
          <option v-for="item in roles" :value="item[1]" :key="item[0]">{{item[1]}}</option>
        </select>
      </div>
      <div>
        <label for="birthday">День рождения</label>
        <input id="birthday" v-model="birthday" type="date" placeholder="День рождения">
      </div>
      <div>
        <label for="phone">Номер телефона</label>
        <input id="phone" type="text" v-model="phone" placeholder="Номер телефона">
      </div>
      <div>
        <label for="address">Адрес</label>
        <input id="address" v-model="address" type="text" placeholder="Адрес">
      </div>
      <div>
        <label for="salary">Зарплата</label>
        <input id="salary" v-model="salary" type="number" placeholder="Зарплата">
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
      roles: [],
      name: "",
      role: "",
      birthday: "",
      phone: "",
      address: "",
      salary: 0
    }
  },
  methods: {
    formSubmit() {
      $api.post("/goods/addWorkers", {
        salary: this.salary,
        workerName: this.name,
        birthday: this.birthday,
        address: this.address,
        role: this.role,
        phone: this.phone
      })
    }
  },
  async mounted() {
    const resRoles = await $api.get("/goods/roles")
    this.roles = resRoles.data

    console.log(this.roles)
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
label, p {
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