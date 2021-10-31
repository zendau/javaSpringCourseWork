<template>
  <div>
    Добавление данных
    <RouterLink class="link" to="/addProviders">Поставщики</RouterLink>
    <RouterLink class="link" to="/addWorkers">Работники</RouterLink>
    <RouterLink class="link" to="/addCategories">Категории</RouterLink>
    <RouterLink class="link" to="/addRoles">Роли работников</RouterLink>
    <RouterLink class="link" to="/addSCC">Карточка складского учета</RouterLink>
    <RouterLink class="link" to="/addStorage">Склады</RouterLink>
    <RouterLink class="link" to="/addWaybills">Накладные</RouterLink>
  </div>
</template>

<script>
export default {
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