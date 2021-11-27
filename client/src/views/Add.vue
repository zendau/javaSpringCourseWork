<template>
  <div class="form-container">
    Добавление данных
    <RouterLink class="link" to="/addWorkers">Работники</RouterLink>
    <RouterLink class="link" to="/addCategories">Категории</RouterLink>
    <RouterLink class="link" to="/addRoles">Роли работников</RouterLink>
    <RouterLink class="link" to="/addProvider">Поставщики</RouterLink>
  </div>
</template>

<script>
export default {
  name: "addData",
  data() {
    return {

    }
  },
  methods: {

  }
}
</script>

<style scoped>
.link {
  display: block;
  margin: 10px;
  font-size: 18px;
}
</style>