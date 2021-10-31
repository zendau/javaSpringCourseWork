<template>
  <div>
    Редактирование данных
    <RouterLink class="link" to="/editGoods">Товары</RouterLink>
    <RouterLink class="link" to="/editProviders">Поставщики</RouterLink>
    <RouterLink class="link" to="/editWorkers">Работники</RouterLink>
    <RouterLink class="link" to="/editCategories">Категории</RouterLink>
    <RouterLink class="link" to="/editSCC">Карточка складского учета</RouterLink>
    <RouterLink class="link" to="/editRoles">Роли</RouterLink>
    <RouterLink class="link" to="/editStorage">Склады</RouterLink>
    <RouterLink class="link" to="/editWaybills">Накладные</RouterLink>
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